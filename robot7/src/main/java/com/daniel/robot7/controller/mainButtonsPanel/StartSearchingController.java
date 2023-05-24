/**
 * Package spider.controller.mainButtons
 *
 **/
package com.daniel.robot7.controller.mainButtonsPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Arrays;
import java.util.List;

import com.daniel.robot7.controller.AbstractDataController;
import com.daniel.robot7.controller.resultTab.CrawlerThread;
import com.daniel.robot7.swing.MainWindow;
import com.daniel.robot7.swing.common.MessageWindow;
import com.daniel.robot7.swing.metadata.common.MainButtonsMetadata;
import com.daniel.robot7.swing.metadata.tab.ResultMetadata;
import com.daniel.robot7.swing.metadata.tab.SearchCriteriaMetedata;
import com.daniel.robot7.model.SearchCriteriaModel;
import com.daniel.robot7.util.CommonConstants;

/**
 * The Class StartSearchingController.
 *
 * @author Daniel Žažo
 * @date 16. 2. 2015
 */
public class StartSearchingController extends AbstractDataController implements ActionListener {

	/** The main window. */
	private final MainWindow	mainWindow;

	/** The search criteria model. */
	private SearchCriteriaModel	searchCriteriaModel;

	/**
	 * Instantiates a new start searching controller.
	 *
	 * @param mainWindow
	 *            the main window
	 */
	public StartSearchingController(MainWindow mainWindow) {
		this.mainWindow = mainWindow;
		this.searchCriteriaTab = mainWindow.getSearchCriteriaTab();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		initSearchCriteriaModel();
	}

	/**
	 * Inits the search criteria model.
	 */
	private void initSearchCriteriaModel() {
		searchCriteriaModel = new SearchCriteriaModel();

		// URL
		final String url = getUrlFromGui();
		if (url != null) {
			searchCriteriaModel.setURL(getUrlFromGui());
			// searchCriteriaModel.setURL("http://localhost:8080/ServletFilter/");
		} else {
			return;
		}

		// MAXIMUM DEPTH
		final long maxDepth = getMaxDepthFromGui();
		if (maxDepth != Long.MIN_VALUE) {
			searchCriteriaModel.setMaxDepth(maxDepth);
		} else {
			return;
		}

		// MAXIMUM VISITED PAGES
		final long maxVisitedPages = getMaxVisitedPagesFromGui();
		if (maxVisitedPages != Long.MIN_VALUE) {
			searchCriteriaModel.setMaxVisitedPages(maxVisitedPages);
		} else {
			return;
		}

		// SELECTED DOMAINS
		if (!isOnlyDefaultDomain()) {
			final List<String> domains = getSelectedDomains();
			if (domains != null) {
				searchCriteriaModel.setDomains(domains);
			} else {
				return;
			}
		}

		// SEARCHED WORDS/PHRASES
		searchCriteriaModel.setSearchedWords(getSearchedWords());

		// INTERNET CONNECTIVITY CHECKING
		if (!internetConnectivity()) {
			MessageWindow.showError(ResultMetadata.MSG_ERROR_INTERNET_CONNECTIVITY);
			return;
		}

		// SET STATUS LABEL - All is ok
		if (mainWindow.getResultTab().getjTreeUrls() != null) {
			mainWindow.getResultTab().getPanel().removeAll();
			mainWindow.getErrorLogTab().getjTextArea().setText(CommonConstants.EMPTY_STRING);
		}

		mainWindow.setStatusActiveSearching();
		mainWindow.getStatisticsModel().resetValues();
		mainWindow.updateStatistics();
		mainWindow.getTabbedPane().setSelectedIndex(1);
		final CrawlerThread spiderThread = new CrawlerThread(mainWindow, searchCriteriaModel);
		spiderThread.start();
		mainWindow.setSpiderThread(spiderThread);
	}

	/**
	 * Checks if is only default domain.
	 *
	 * @return true, if is only default domain
	 */
	private boolean isOnlyDefaultDomain() {
		if (searchCriteriaTab.getCheckboxDefaultDomain().isSelected()) {
			searchCriteriaModel.setOnlyDefaultDomain(true);
			return true;
		}
		return false;
	}

	/**
	 * Gets the searched words.
	 *
	 * @return the searched words
	 */
	private List<String> getSearchedWords() {
		final String searchedWordsString = searchCriteriaTab.getTxtAreaWords().getText();
		if (!searchedWordsString.isEmpty()) {
			return Arrays.asList(searchedWordsString.split(CommonConstants.NEW_LINE));
			// line separator with system.getporperty does not works ... this return only "\n" and this
			// return Arrays.asList(searchedWordsString.split(System.getProperty(LINE_SEPARATOR)));
		}
		return null;
	}

	/**
	 * Gets the selected domains.
	 *
	 * @return the selected domains
	 */
	private List<String> getSelectedDomains() {
		final List<String> selectedDomains = searchCriteriaTab.getListDomains().getSelectedValuesList();
		if (selectedDomains.size() == 0) {
			MessageWindow.showError(MainButtonsMetadata.ERROR_YOU_HAVE_DO_SELECT_AT_LEAST_DOMAIN);
			return null;
		} else if (containsUnlimited(selectedDomains)) {
			selectedDomains.clear();
			selectedDomains.add(CommonConstants.UNLIMITED);
			return selectedDomains;
		} else {
			return selectedDomains;
		}
	}

	/**
	 * Contains unlimited.
	 *
	 * @param domains
	 *            the domains
	 * @return true, if successful
	 */
	private boolean containsUnlimited(List<String> domains) {
		return domains.contains(CommonConstants.UNLIMITED);
	}

	/**
	 * Gets the max visited pages from gui.
	 *
	 * @return the max visited pages from gui
	 */
	private long getMaxVisitedPagesFromGui() {
		long maxVisitedPagesLong;
		try {
			if (!searchCriteriaTab.getCheckboxMaxVisitedPages().isSelected()) {
				String maxVisitedPageString;
				maxVisitedPageString = (String) searchCriteriaTab.getComboBoxMaximumPages().getSelectedItem();
				if (maxVisitedPageString.equals(CommonConstants.UNLIMITED)) {
					maxVisitedPagesLong = Long.MAX_VALUE;
				} else {
					maxVisitedPagesLong = Long.parseLong(maxVisitedPageString);
				}
			} else {
				maxVisitedPagesLong = Long.parseLong(searchCriteriaTab.getTxtOtheMaxVisitedPages().getText());
			}
		} catch (final NumberFormatException e) {
			MessageWindow.showError(SearchCriteriaMetedata.ERROR_IN_FILE_MAXIMUM_VISITED_PAGES_TXT);
			return Long.MIN_VALUE;
		}
		return maxVisitedPagesLong;
	}

	/**
	 * Gets the max depth from gui.
	 *
	 * @return the max depth from gui
	 */
	private long getMaxDepthFromGui() {
		long maxDepthLong;
		try {
			if (!searchCriteriaTab.getCheckboxMaxDepth().isSelected()) {
				String maxDepthString;

				maxDepthString = (String) searchCriteriaTab.getComboBoxMaximumDepth().getSelectedItem();
				if (maxDepthString.equals(CommonConstants.UNLIMITED)) {
					maxDepthLong = Long.MAX_VALUE;
				} else {
					maxDepthLong = Long.parseLong(maxDepthString);
				}
			} else {
				maxDepthLong = Long.parseLong(searchCriteriaTab.getTxtOtherMaxDepth().getText());
			}
		} catch (final NumberFormatException e) {
			MessageWindow.showError(SearchCriteriaMetedata.ERROR_IN_FILE_MAXIMUM_DEPTH_TXT);
			return Long.MIN_VALUE;
		}
		return maxDepthLong;
	}

	/**
	 * Gets the url from gui.
	 *
	 * @return the url from gui
	 */
	private String getUrlFromGui() {
		final String url = searchCriteriaTab.getTxtDefaultUrl().getText();
		if (url.isEmpty()) {
			MessageWindow.showError(SearchCriteriaMetedata.ERROR_URL_CANT_BE_EMPTY);
			return null;
		} else if (!isValidUrl(url)) {
			MessageWindow.showError(SearchCriteriaMetedata.ERROR_URL_IS_NOT_VALID);
			return null;
		}
		return url;
	}

	/**
	 * Internet connectivity.
	 *
	 * @return true, if successful
	 */
	private boolean internetConnectivity() {
		for (int i = 0; i < SearchCriteriaMetedata.WWW_SITES.length; i++) {
			final Socket socket = new Socket();
			final InetSocketAddress inetSocketAddress = new InetSocketAddress(SearchCriteriaMetedata.WWW_SITES[i], 80);
			try {
				socket.connect(inetSocketAddress, 3000);
				return true;
			} catch (final IOException e) {
				continue;
			} finally {
				try {
					socket.close();
				} catch (final IOException e) {
					continue;
				}
			}
		}
		return false;
	}

}
