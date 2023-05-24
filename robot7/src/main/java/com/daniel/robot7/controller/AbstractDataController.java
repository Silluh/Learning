package com.daniel.robot7.controller;

import org.apache.commons.validator.routines.UrlValidator;
import com.daniel.robot7.swing.common.MessageWindow;
import com.daniel.robot7.swing.metadata.tab.ResultMetadata;
import com.daniel.robot7.swing.tab.searchCriteria.SearchCriteriaTab;

import java.awt.*;
import java.net.URL;

/**
 * The Class AbstractDataController.
 */
public class AbstractDataController {

	/** The search criteria tab. */
	protected SearchCriteriaTab	searchCriteriaTab;

	/** The line separator. */
	protected static String		LINE_SEPARATOR	= "line.separator";

	/**
	 * Checks if is valid url.
	 *
	 * @param url
	 *            the url
	 * @return true, if is valid url
	 */
	protected boolean isValidUrl(String url) {
		final UrlValidator urlValidator = new UrlValidator();
		return urlValidator.isValid(url);
	}

	/**
	 * Open web page.
	 *
	 * @param urlString
	 *            the url string
	 */
	protected void openWebPage(String urlString) {
		try {
			Desktop.getDesktop().browse(new URL(urlString).toURI());
		} catch (final Exception e) {
			MessageWindow.showError(ResultMetadata.MSG_ERROR_OPEN_WEBPAGE);
		}
	}
}
