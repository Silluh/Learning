/**
 * Package spider.gui.swing.tab.result
 *
 **/
package com.daniel.robot7.swing.tab.result;

import java.io.Serializable;

// TODO: Auto-generated Javadoc
/**
 * The Class UrlTreeNode.
 *
 * @author Daniel Žažo
 * @date 25. 2. 2015
 */
public class UrlTreeNode implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long	serialVersionUID	= -7942946752408061554L;

	/** The url string. */
	private String				urlString;

	/** The contains phrase. */
	private boolean				containsPhrase;

	/**
	 * Count of all phrases in this node and all children.
	 */
	private long				countOfAllPhrases;

	/**
	 * FOR SERIALIZATION!!!.
	 */
	public UrlTreeNode() {
	}

	/**
	 * Gets the url string.
	 *
	 * @return the url string
	 */
	public String getUrlString() {
		return urlString;
	}

	/**
	 * Sets the url string.
	 *
	 * @param urlString
	 *            the new url string
	 */
	public void setUrlString(String urlString) {
		this.urlString = urlString;
	}

	/**
	 * Checks if is contains phrase.
	 *
	 * @return true, if is contains phrase
	 */
	public boolean isContainsPhrase() {
		return containsPhrase;
	}

	/**
	 * Sets the contains phrase.
	 *
	 * @param containsPhrase
	 *            the new contains phrase
	 */
	public void setContainsPhrase(boolean containsPhrase) {
		this.containsPhrase = containsPhrase;
	}

	/**
	 * Gets the count of all phrases.
	 *
	 * @return the count of all phrases
	 */
	public long getCountOfAllPhrases() {
		return countOfAllPhrases;
	}

	/**
	 * Sets the count of all phrases.
	 *
	 * @param countOfAllPhrases
	 *            the new count of all phrases
	 */
	public void setCountOfAllPhrases(long countOfAllPhrases) {
		this.countOfAllPhrases = countOfAllPhrases;
	}

	/**
	 * Creates a new instance of UrlTreeNode.
	 *
	 * @param urlString
	 *            the url string
	 */
	public UrlTreeNode(String urlString) {
		this.urlString = urlString;
	}

	/**
	 * return url string for display on screen.
	 *
	 * @return String representation of the object
	 */
	@Override
	public String toString() {
		return this.urlString;
	}

	/**
	 * Increment count of all phrases.
	 */
	public void incrementCountOfAllPhrases() {
		this.countOfAllPhrases++;
	}

	/**
	 * test for equality.
	 *
	 * @param urlstr
	 *            string containing url to compare
	 * @return true if it is the same page
	 */
	public boolean equals(String urlstr) {
		return urlString.equals(urlstr);
	}

}