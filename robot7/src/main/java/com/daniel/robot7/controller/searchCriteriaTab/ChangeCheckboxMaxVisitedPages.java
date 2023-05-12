/**
 * Package spider.controller.searchCriteria
 *
 **/
package robot.controller.searchCriteriaTab;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import robot.controller.AbstractDataController;
import robot.gui.swing.tab.searchCriteria.SearchCriteriaTab;

/**
 * The Class ChangeCheckboxMaxVisitedPages.
 *
 * @author Daniel Žažo
 * @date 12. 2. 2015
 */
public class ChangeCheckboxMaxVisitedPages extends AbstractDataController implements ActionListener {

	/**
	 * Instantiates a new change checkbox max visited pages.
	 *
	 * @param searchCriteriaTab
	 *            the search criteria tab
	 */
	public ChangeCheckboxMaxVisitedPages(SearchCriteriaTab searchCriteriaTab) {
		this.searchCriteriaTab = searchCriteriaTab;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if (searchCriteriaTab.getCheckboxMaxVisitedPages().isSelected()) {
			enableTxtNeMaxVisitedPages();
		} else {
			disableNewMaxVisitedPages();
		}
	}

	/**
	 * Disable new max visited pages.
	 */
	private void disableNewMaxVisitedPages() {
		searchCriteriaTab.getTxtOtheMaxVisitedPages().setEnabled(false);
		searchCriteriaTab.getComboBoxMaximumPages().setEnabled(true);
	}

	/**
	 * Enable txt ne max visited pages.
	 */
	private void enableTxtNeMaxVisitedPages() {
		searchCriteriaTab.getTxtOtheMaxVisitedPages().setEnabled(true);
		searchCriteriaTab.getComboBoxMaximumPages().setEnabled(false);
		searchCriteriaTab.getTxtOtheMaxVisitedPages().requestFocus();
	}
}
