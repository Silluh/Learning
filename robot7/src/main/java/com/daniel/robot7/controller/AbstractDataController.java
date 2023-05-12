package robot.controller;

import java.awt.Desktop;
import java.net.URL;

import org.apache.commons.validator.routines.UrlValidator;

import robot.gui.swing.common.MessageWindow;
import robot.gui.swing.metadata.tab.ResultMetadata;
import robot.gui.swing.tab.searchCriteria.SearchCriteriaTab;

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
