/**
 * Package crawler.controller.searchCriteriaTab
 *
 **/
package robot.controller.searchCriteriaTab;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import robot.gui.swing.tab.searchCriteria.SearchCriteriaTab;

/**
 * The Class ChangeCheckboxSetTimeout.
 *
 * @author Daniel Žažo
 * @date 25. 3. 2015
 */
public class ChangeCheckboxSetTimeout implements ActionListener {

	/** The search criteria tab. */
	private final SearchCriteriaTab	searchCriteriaTab;

	/**
	 * Instantiates a new change checkbox set timeout.
	 *
	 * @param searchCriteriaTab
	 *            the search criteria tab
	 */
	public ChangeCheckboxSetTimeout(SearchCriteriaTab searchCriteriaTab) {
		this.searchCriteriaTab = searchCriteriaTab;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if (searchCriteriaTab.getCheckboxSetTimeout().isSelected()) {
			searchCriteriaTab.getTxtTimeout().setEnabled(true);
			searchCriteriaTab.getTxtTimeout().requestFocus();
		} else {
			searchCriteriaTab.getTxtTimeout().setEnabled(false);
		}
	}

}
