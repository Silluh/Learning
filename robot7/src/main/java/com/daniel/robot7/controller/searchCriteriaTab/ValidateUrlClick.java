/**
 * Package spider.controller.searchCriteria
 *
 **/
package com.daniel.robot7.controller.searchCriteriaTab;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.daniel.robot7.controller.AbstractDataController;
import com.daniel.robot7.swing.common.MessageWindow;
import com.daniel.robot7.swing.metadata.tab.SearchCriteriaMetedata;
import com.daniel.robot7.swing.tab.searchCriteria.SearchCriteriaTab;

/**
 * The Class ValidateUrlClick.
 *
 * @author Daniel Žažo
 * @date 14. 2. 2015
 */
public class ValidateUrlClick extends AbstractDataController implements ActionListener {

	/** The new url. */
	private String	newUrl;

	/**
	 * Instantiates a new validate url click.
	 *
	 * @param searchCriteriaTab
	 *            the search criteria tab
	 */
	public ValidateUrlClick(SearchCriteriaTab searchCriteriaTab) {
		this.searchCriteriaTab = searchCriteriaTab;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		newUrl = searchCriteriaTab.getTxtDefaultUrl().getText();
		checkingUrl();
	}

	/**
	 * Checking url.
	 */
	private void checkingUrl() {
		if (newUrl.isEmpty()) {
			MessageWindow.showError(SearchCriteriaMetedata.ERROR_URL_CANT_BE_EMPTY);
		} else if (!isValidUrl(newUrl)) {
			MessageWindow.showError(SearchCriteriaMetedata.ERROR_URL_IS_NOT_VALID);
		} else {
			MessageWindow.showInfo(SearchCriteriaMetedata.INFO_URL_IS_OK);
		}
	}

}
