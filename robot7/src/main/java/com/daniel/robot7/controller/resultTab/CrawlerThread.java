/**
 * Package spider.controller.resultTab
 *
 **/
package com.daniel.robot7.controller.resultTab;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import javax.swing.JTextArea;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeNode;
import javax.swing.tree.TreePath;

import org.jsoup.HttpStatusException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Entities.EscapeMode;
import org.jsoup.safety.Cleaner;
import org.jsoup.safety.Whitelist;
import org.jsoup.select.Elements;

import com.daniel.robot7.swing.MainWindow;
import com.daniel.robot7.swing.metadata.tab.LogMetadata;
import com.daniel.robot7.swing.metadata.tab.ResultMetadata;
import com.daniel.robot7.swing.tab.result.UrlNodeRenderer;
import com.daniel.robot7.swing.tab.result.UrlTreeNode;
import com.daniel.robot7.model.SearchCriteriaModel;
import com.daniel.robot7.util.CommonConstants;

/**
 * The Class CrawlerThread.
 *
 * @author Daniel Žažo
 * @date 19. 2. 2015
 */
public class CrawlerThread extends Thread {

	/** The main window. */
	private final MainWindow			mainWindow;

	/** The search criteria model. */
	private final SearchCriteriaModel	searchCriteriaModel;

	/** The j tree urls. */
	private final JTree					jTreeUrls;

	/** The root url. */
	private URL							rootUrl;

	/** The stop thread. */
	private boolean						stopThread;

	/** The counter max visited pages. */
	private long						counterMaxVisitedPages;

	/** The default domain host. */
	private String						defaultDomainHost;

	/** The j text area log. */
	private final JTextArea				jTextAreaLog;

	/** The timeout. */
	private Long						timeout;

	/** The is selected tiemout. */
	private final boolean				isSelectedTiemout;

	/**
	 * Checks if is stop thread.
	 *
	 * @return true, if is stop thread
	 */
	public boolean isStopThread() {
		return stopThread;
	}

	/**
	 * Sets the stop thread.
	 *
	 * @param stopThread
	 *            the new stop thread
	 */
	public void setStopThread(boolean stopThread) {
		this.stopThread = stopThread;
	}

	/**
	 * Instantiates a new crawler thread.
	 *
	 * @param mainWindow
	 *            the main window
	 * @param searchCriteriaModel
	 *            the search criteria model
	 */
	public CrawlerThread(MainWindow mainWindow, SearchCriteriaModel searchCriteriaModel) {
		this.mainWindow = mainWindow;
		this.searchCriteriaModel = searchCriteriaModel;

		this.mainWindow.getResultTab().createTree();
		this.jTreeUrls = mainWindow.getResultTab().getjTreeUrls();
		this.jTextAreaLog = mainWindow.getErrorLogTab().getjTextArea();
		this.isSelectedTiemout = mainWindow.getSearchCriteriaTab().getCheckboxSetTimeout().isSelected();
		if (isSelectedTiemout) {
			this.timeout = Long.parseLong(mainWindow.getSearchCriteriaTab().getTxtTimeout().getText());
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Thread#run()
	 */
	@Override
	public void run() {
		counterMaxVisitedPages = 1; // Root is counted in max visite pages
		mainWindow.getStatisticsModel().incrementCountSearchedPages();
		mainWindow.updateStatistics();

		rootUrl = getUrlFromString(searchCriteriaModel.getURL());
		if (rootUrl == null) {
			return;
		}
		setDefaultDomainHost(rootUrl);

		final DefaultMutableTreeNode rootNode = new DefaultMutableTreeNode(new UrlTreeNode(this.rootUrl.toString()));
		final DefaultTreeModel treeModel = new DefaultTreeModel(rootNode);
		jTreeUrls.setModel(treeModel);
		jTreeUrls.setCellRenderer(new UrlNodeRenderer());

		searchLinksOnPage(rootNode, this.rootUrl.toString());
		if (stopThread) {
			mainWindow.setStatusInActiveStopped();
		} else {
			mainWindow.setStatusInActiveSearchingDone();
		}
		jTreeUrls.repaint();
	}

	/**
	 * Sets the default domain host.
	 *
	 * @param rootUrl
	 *            the new default domain host
	 */
	private void setDefaultDomainHost(URL rootUrl) {
		if (searchCriteriaModel.getOnlyDefaultDomain()) {
			defaultDomainHost = rootUrl.getHost();
		}
	}

	/**
	 * Search links on page.
	 *
	 * @param rootNode
	 *            the root node
	 * @param urlString
	 *            the url string
	 */
	private void searchLinksOnPage(DefaultMutableTreeNode rootNode, String urlString) {
		if (stopThread) {
			return;
		}

		// if (!areInputConditionsOk(rootNode, urlString)) {
		// return;
		// }

		final String fixedUrlString = getFixedUrlFromUrlString(urlString);
		if (fixedUrlString == null) {
			logErrorMessage(LogMetadata.ERROR_URI_SYNTAX_EXCEPTION + urlString);
			mainWindow.getStatisticsModel().incrementCountWrongLinks();
			mainWindow.updateStatistics();
			return;
		}

		Document doc = null;
		if (isSelectedTiemout) {
			delayProcess();
		}
		try {
			doc = Jsoup.connect(fixedUrlString).get();
		} catch (final HttpStatusException httpStatusException) {
			mainWindow.getStatisticsModel().incrementCountWrongLinks();
			mainWindow.updateStatistics();
			logErrorMessage(LogMetadata.ERROR_CONNECT_HTTP_STATUS_EXCEPTION + httpStatusException.getStatusCode() + CommonConstants.SPACE
					+ LogMetadata.ERROR_WRONG_URL + fixedUrlString);
			return;
		} catch (final IOException e) {
			mainWindow.getStatisticsModel().incrementCountWrongLinks();
			mainWindow.updateStatistics();
			logErrorMessage(LogMetadata.ERROR_CONNECT_OTHER_EXCEPTION + e.getMessage() + fixedUrlString);
			return;
		}

		// Marking of JTREE if links contains some searched phrase/words
		if (searchCriteriaModel.getSearchedWords() != null && containsSearchedPhrase(doc)) {
			final UrlTreeNode node = (UrlTreeNode) (rootNode.getUserObject());
			node.setContainsPhrase(true);
			mainWindow.getStatisticsModel().incrementCountFoundPhrases();
			mainWindow.updateStatistics();
			updateAllParents(rootNode);
		}

		if (!areInputConditionsOk(rootNode, urlString)) {
			return;
		}

		final Elements links = doc.select("a[href~=^[^#]+$]");
		final Map<String, DefaultMutableTreeNode> tempMap = new LinkedHashMap<String, DefaultMutableTreeNode>();

		final long maxPossibleUrls = getMaxPossibleUrls(links);

		for (long i = 0; i < maxPossibleUrls; i++) {
			final String href = links.get((int) i).attr("abs:href");
			final String fixedHref = fixSloppyUrlLink(href);
			final URL newUrl = getUrlFromString(fixedHref);

			if (newUrl == null) {
				mainWindow.getStatisticsModel().incrementCountWrongLinks();
				mainWindow.updateStatistics();
				logAfterErrorMessage(LogMetadata.ERROR_WRONG_HREF + links.get((int) i) + LogMetadata.ON_PAGE + links.get((int) i).baseUri());
				continue;
			}

			if (searchCriteriaModel.getOnlyDefaultDomain() && !newUrl.getHost().equals(defaultDomainHost)) {
				continue;
			}

			if (!isHtmlFile(newUrl)) {
				continue;
			}

			if (containsUrl(fixedHref)) {
				continue;
			} else {
				// if(isSelectedTiemout) {
				// delayProcess();
				// }
				final UrlTreeNode newnode = new UrlTreeNode(fixedHref); // create the node
				final DefaultMutableTreeNode treenode = addNode(rootNode, newnode);
				counterMaxVisitedPages++;
				mainWindow.getStatisticsModel().incrementCountSearchedPages();
				mainWindow.updateStatistics();
				mainWindow.getResultTab().getPanel().updateUI();
				// jTreeUrls.updateUI(); // Very often blicking UI
				tempMap.put(fixedHref, treenode);
				// searchOnSite(treenode, fixedHref);
			}
		}
		for (final String urlKey : tempMap.keySet()) {
			if (!stopThread) {
				searchLinksOnPage(tempMap.get(urlKey), urlKey);
			}
		}
	}

	/**
	 * Delay process.
	 */
	private void delayProcess() {
		try {
			TimeUnit.MILLISECONDS.sleep(timeout);
		} catch (final InterruptedException e) {
			logErrorMessage(ResultMetadata.MSG_ERROR_IN_INTERUPT);
		}
	}

	/**
	 * add a node to the search tree.
	 *
	 * @param parentnode
	 *            parent to add the new node under
	 * @param newnode
	 *            node to be added to the tree
	 * @return the default mutable tree node
	 */
	private DefaultMutableTreeNode addNode(DefaultMutableTreeNode parentnode, UrlTreeNode newnode) {
		final DefaultMutableTreeNode node = new DefaultMutableTreeNode(newnode);
		final DefaultTreeModel treeModel = (DefaultTreeModel) jTreeUrls.getModel(); // get our model
		final int index = treeModel.getChildCount(parentnode); // how many children are there already?
		treeModel.insertNodeInto(node, parentnode, index); // Adding last child
		final TreePath tp = new TreePath(parentnode.getPath());
		jTreeUrls.expandPath(tp);
		return node;

	}

	/**
	 * Updating all parents node for StringLabeller in graph!.
	 *
	 * @param rootNode
	 *            the root node
	 */
	private void updateAllParents(TreeNode rootNode) {
		if (rootNode.getParent() != null) {
			final UrlTreeNode urlTreeNode = (UrlTreeNode) (((DefaultMutableTreeNode) rootNode).getUserObject());
			urlTreeNode.incrementCountOfAllPhrases();
			updateAllParents(rootNode.getParent());
		} else {
			final UrlTreeNode urlTreeNode = (UrlTreeNode) (((DefaultMutableTreeNode) rootNode).getUserObject());
			urlTreeNode.incrementCountOfAllPhrases();
		}
	}

	/**
	 * Are input conditions ok.
	 *
	 * @param rootNode
	 *            the root node
	 * @param url
	 *            the url
	 * @return true, if successful
	 */
	private boolean areInputConditionsOk(DefaultMutableTreeNode rootNode, String url) {
		if (searchCriteriaModel.getMaxDepth() <= rootNode.getLevel()) {
			return false;
		}

		if (!searchCriteriaModel.getOnlyDefaultDomain()) {
			if (!containsSelectedDomains(url)) {
				return false;
			}
		}
		return true;
	}

	/**
	 * Gets the fixed url from url string.
	 *
	 * @param urlString
	 *            the url string
	 * @return the fixed url from url string
	 */
	private String getFixedUrlFromUrlString(String urlString) {
		final URI uri = getUriFromUrlString(urlString);
		if (uri != null) {
			return fixSloppyUrlLink(uri.toString());
		}
		return null;
	}

	/**
	 * Gets the uri from url string.
	 *
	 * @param urlString
	 *            the url string
	 * @return the uri from url string
	 */
	private URI getUriFromUrlString(String urlString) {
		URI uri = null;
		try {
			uri = new URI(urlString);
		} catch (final URISyntaxException e2) {
			logErrorMessage(LogMetadata.ERROR_NEW_URI + urlString);
		}
		return uri;
	}

	/**
	 * Gets the url from string.
	 *
	 * @param urlString
	 *            the url string
	 * @return the url from string
	 */
	private URL getUrlFromString(String urlString) {
		try {
			return new URL(urlString);
		} catch (final MalformedURLException e) {
			logErrorMessage(LogMetadata.ERROR_NEW_URL + e.getMessage());
		}
		return null;
	}

	/**
	 * Fix sloppy href.
	 *
	 * @param href
	 *            the href
	 * @return the string
	 */
	private String fixSloppyUrlLink(String href) {
		return href.replace(CommonConstants.BACKSLASH.charAt(0), CommonConstants.SLASH.charAt(0));
	}

	/**
	 * Checks if is html file.
	 *
	 * @param url
	 *            the url
	 * @return true, if is html file
	 */
	private boolean isHtmlFile(URL url) {
		final String path = url.getPath();
		final int lastDot = path.lastIndexOf(CommonConstants.DOT);
		if (lastDot > 0) {
			final String extension = path.substring(lastDot);
			if (!extension.equalsIgnoreCase(ResultMetadata.DOT_HTM) && !extension.equalsIgnoreCase(ResultMetadata.DOT_HTML)) {
				return false;
			}
		}
		return true;
	}

	/**
	 * If setted some value of "Maximum visited pages" so this method fixes count of iteration.
	 *
	 * @param links
	 *            the links
	 * @return the max possible urls
	 */
	private long getMaxPossibleUrls(Elements links) {
		long maxPossibleUrls = 0;
		int countOfNewFoundedUrls = 0;

		if (searchCriteriaModel.getOnlyDefaultDomain()) {
			countOfNewFoundedUrls = getOnlyCorrectDomain(links);
		} else {
			countOfNewFoundedUrls = links.size();
		}

		if ((countOfNewFoundedUrls + counterMaxVisitedPages) < searchCriteriaModel.getMaxVisitedPages()) {
			maxPossibleUrls = countOfNewFoundedUrls;
		} else {
			maxPossibleUrls = searchCriteriaModel.getMaxVisitedPages() - counterMaxVisitedPages;
		}
		return maxPossibleUrls;
	}

	/**
	 * Gets the only correct domain.
	 *
	 * @param links
	 *            the links
	 * @return the only correct domain
	 */
	private int getOnlyCorrectDomain(Elements links) {
		int countOfCorrectUrl = 0;
		for (final Element link : links) {
			final String href = link.attr("abs:href");
			final String fixedHref = fixSloppyUrlLink(href);
			final URL newUrl = getUrlFromString(fixedHref);
			try {
				if (defaultDomainHost.equals(newUrl.getHost())) {
					countOfCorrectUrl++;
				}
			} catch (final NullPointerException e) {
				logErrorMessage(LogMetadata.ERROR_IN_CONVERTING_URL + link);
				continue;
			}
		}
		return countOfCorrectUrl;
	}

	/**
	 * Contains selected domains.
	 *
	 * @param urlString
	 *            the url string
	 * @return true, if successful
	 */
	private boolean containsSelectedDomains(String urlString) {
		final URL newUrl = getUrlFromString(urlString);
		if (newUrl != null) {
			final int indexLastDot = newUrl.getHost().lastIndexOf(CommonConstants.DOT);
			String currentDomain = null;
			if (indexLastDot != -1) {
				currentDomain = newUrl.getHost().substring(indexLastDot);
			}

			for (final String domain : searchCriteriaModel.getDomains()) {
				if (domain.equals(currentDomain) || domain.equals(CommonConstants.UNLIMITED)) {
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * This method work with all words on page and from this words create dictionary with unique words and this words are fixed. Here is core of my simple
	 * Google and it's possible it somehow customize.
	 *
	 * @param doc
	 *            the doc
	 * @return true, if successful
	 */
	private boolean containsSearchedPhrase(Document doc) {
		final Document clearedDocument = new Cleaner(Whitelist.simpleText()).clean(doc);
		clearedDocument.outputSettings().escapeMode(EscapeMode.xhtml);

		// Searching is not CASE SENSITIVE
		final String finalStringLower = clearedDocument.body().text().toLowerCase();

		// Maybe here it should be more requirments and more hard logic
		// Important is using SET (big improvement)
		Set<String> onlyWords = new HashSet<String>(Arrays.asList(finalStringLower.split(CommonConstants.SPACE)));
		final DictionaryUtil dictionaryUtil = new DictionaryUtil(onlyWords);
		onlyWords = dictionaryUtil.getFixedDictionary();

		for (final String phrase : searchCriteriaModel.getSearchedWords()) {
			// Result true if contains at least one word (not all searched phrases/words)
			if (onlyWords.contains(phrase.toLowerCase())) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Contains url.
	 *
	 * @param urlstring
	 *            the urlstring
	 * @return true, if successful
	 */
	private boolean containsUrl(String urlstring) {
		final String fixedUrl = fixSloppyUrlLink(urlstring);
		final DefaultTreeModel treeModel = (DefaultTreeModel) jTreeUrls.getModel();
		final DefaultMutableTreeNode root = (DefaultMutableTreeNode) treeModel.getRoot();
		@SuppressWarnings("unchecked")
		final Enumeration<DefaultMutableTreeNode> etree = root.breadthFirstEnumeration();
		while (etree.hasMoreElements()) {
			final UrlTreeNode node = (UrlTreeNode) (etree.nextElement().getUserObject());
			if (node instanceof UrlTreeNode && node.equals(fixedUrl)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Log info message.
	 *
	 * @param message
	 *            the message
	 */
	@SuppressWarnings(value = { "unused" })
	private void logInfoMessage(String message) {
		jTextAreaLog.append(CommonConstants.INFO_STRING + message + CommonConstants.NEW_LINE);
	}

	/**
	 * Log error message.
	 *
	 * @param message
	 *            the message
	 */
	private void logErrorMessage(String message) {
		jTextAreaLog.append(CommonConstants.ERROR_STRING + message + CommonConstants.NEW_LINE);
	}

	/**
	 * Log after error message.
	 *
	 * @param message
	 *            the message
	 */
	private void logAfterErrorMessage(String message) {
		jTextAreaLog.append(CommonConstants.ARROW + CommonConstants.SPACE + message + CommonConstants.NEW_LINE);
	}
}
