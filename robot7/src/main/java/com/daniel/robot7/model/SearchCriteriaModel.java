/**
 * Package spider.model
 *
 **/
package robot.model;

import java.util.List;

/**
 * The Class SearchCriteriaModel.
 *
 * @author Daniel Žažo
 * @date 14. 2. 2015
 */
public class SearchCriteriaModel {

	/** The url. */
	private String			URL;

	/** The max depth. */
	private long			maxDepth;

	/** The max visited pages. */
	private long			maxVisitedPages;

	/** The domains. */
	private List<String>	domains;

	/** The searched words. */
	private List<String>	searchedWords;

	/** The only default domain. */
	private boolean			onlyDefaultDomain;

	/**
	 * Gets the only default domain.
	 *
	 * @return the only default domain
	 */
	public boolean getOnlyDefaultDomain() {
		return onlyDefaultDomain;
	}

	/**
	 * Sets the only default domain.
	 *
	 * @param onlyDefaultDomain
	 *            the new only default domain
	 */
	public void setOnlyDefaultDomain(boolean onlyDefaultDomain) {
		this.onlyDefaultDomain = onlyDefaultDomain;
	}

	/**
	 * Gets the url.
	 *
	 * @return the url
	 */
	public String getURL() {
		return URL;
	}

	/**
	 * Sets the url.
	 *
	 * @param uRL
	 *            the new url
	 */
	public void setURL(String uRL) {
		URL = uRL;
	}

	/**
	 * Gets the max depth.
	 *
	 * @return the max depth
	 */
	public long getMaxDepth() {
		return maxDepth;
	}

	/**
	 * Sets the max depth.
	 *
	 * @param maxDepth
	 *            the new max depth
	 */
	public void setMaxDepth(long maxDepth) {
		this.maxDepth = maxDepth;
	}

	/**
	 * Gets the max visited pages.
	 *
	 * @return the max visited pages
	 */
	public long getMaxVisitedPages() {
		return maxVisitedPages;
	}

	/**
	 * Sets the max visited pages.
	 *
	 * @param maxVisitedPages
	 *            the new max visited pages
	 */
	public void setMaxVisitedPages(long maxVisitedPages) {
		this.maxVisitedPages = maxVisitedPages;
	}

	/**
	 * Gets the domains.
	 *
	 * @return the domains
	 */
	public List<String> getDomains() {
		return domains;
	}

	/**
	 * Sets the domains.
	 *
	 * @param domains
	 *            the new domains
	 */
	public void setDomains(List<String> domains) {
		this.domains = domains;
	}

	/**
	 * Gets the searched words.
	 *
	 * @return the searched words
	 */
	public List<String> getSearchedWords() {
		return searchedWords;
	}

	/**
	 * Sets the searched words.
	 *
	 * @param searchedWords
	 *            the new searched words
	 */
	public void setSearchedWords(List<String> searchedWords) {
		this.searchedWords = searchedWords;
	}

}
