/**
 * Package spider.controller.searchCriteria
 *
 **/
package com.daniel.robot7.controller.searchCriteriaTab;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.daniel.robot7.controller.AbstractDataController;
import com.daniel.robot7.swing.tab.searchCriteria.SearchCriteriaTab;

/**
 * The Class ChangeCheckboxMaxDepth.
 *
 * @author Daniel Žažo
 * @date 12. 2. 2015
 */
public class ChangeCheckboxMaxDepth extends AbstractDataController implements ActionListener {

	/**
	 * Instantiates a new change checkbox max depth.
	 *
	 * @param searchCriteriaTab
	 *            the search criteria tab
	 */
	public ChangeCheckboxMaxDepth(SearchCriteriaTab searchCriteriaTab) {
		this.searchCriteriaTab = searchCriteriaTab;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if (searchCriteriaTab.getCheckboxMaxDepth().isSelected()) {
			enableTxtNewMaxDepth();
		} else {
			disableNewMaxDepth();
		}
	}

	/**
	 * Disable new max depth.
	 */
	private void disableNewMaxDepth() {
		searchCriteriaTab.getTxtOtherMaxDepth().setEnabled(false);
		searchCriteriaTab.getComboBoxMaximumDepth().setEnabled(true);
	}

	/**
	 * Enable txt new max depth.
	 */
	private void enableTxtNewMaxDepth() {
		searchCriteriaTab.getTxtOtherMaxDepth().setEnabled(true);
		searchCriteriaTab.getComboBoxMaximumDepth().setEnabled(false);
		searchCriteriaTab.getTxtOtherMaxDepth().requestFocus();
	}

}
