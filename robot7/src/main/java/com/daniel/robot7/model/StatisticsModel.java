/**
 * Package crawler.model
 *
 **/
package com.daniel.robot7.model;

/**
 * The Class StatisticsModel.
 *
 * @author Daniel Žažo
 * @date 22. 3. 2015
 */
public class StatisticsModel {

	/** The count searched pages. */
	private long	countSearchedPages;

	/** The count wrong links. */
	private long	countWrongLinks;

	/** The count pages with searched phrases. */
	private long	countPagesWithFoundPhrases;

	public StatisticsModel(long countSearchedPages, long countWrongLinks, long countPagesWithSearchedPhrases) {
		this.countSearchedPages = countSearchedPages;
		this.countWrongLinks = countWrongLinks;
		this.countPagesWithFoundPhrases = countPagesWithSearchedPhrases;
	}

	/**
	 * Gets the count searched pages.
	 *
	 * @return the count searched pages
	 */
	public long getCountSearchedPages() {
		return countSearchedPages;
	}

	/**
	 * Sets the count searched pages.
	 *
	 * @param countSearchedPages
	 *            the new count searched pages
	 */
	public void setCountSearchedPages(long countSearchedPages) {
		this.countSearchedPages = countSearchedPages;
	}

	/**
	 * Gets the count wrong links.
	 *
	 * @return the count wrong links
	 */
	public long getCountWrongLinks() {
		return countWrongLinks;
	}

	/**
	 * Sets the count wrong links.
	 *
	 * @param countWrongLinks
	 *            the new count wrong links
	 */
	public void setCountWrongLinks(long countWrongLinks) {
		this.countWrongLinks = countWrongLinks;
	}

	/**
	 * Gets the count pages with searched phrases.
	 *
	 * @return the count pages with searched phrases
	 */
	public long getCountPagesWithSearchedPhrases() {
		return countPagesWithFoundPhrases;
	}

	/**
	 * Sets the count pages with searched phrases.
	 *
	 * @param countPagesWithSearchedPhrases
	 *            the new count pages with searched phrases
	 */
	public void setCountPagesWithSearchedPhrases(long countPagesWithSearchedPhrases) {
		this.countPagesWithFoundPhrases = countPagesWithSearchedPhrases;
	}

	public void incrementCountFoundPhrases() {
		countPagesWithFoundPhrases++;
	}

	public void incrementCountWrongLinks() {
		countWrongLinks++;
	}

	public void incrementCountSearchedPages() {
		countSearchedPages++;
	}

	public void resetValues() {
		this.countSearchedPages = 0l;
		this.countWrongLinks = 0l;
		this.countPagesWithFoundPhrases = 0l;
	}

}
