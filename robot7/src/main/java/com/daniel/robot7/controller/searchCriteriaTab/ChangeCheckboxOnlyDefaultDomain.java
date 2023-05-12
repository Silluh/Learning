/**
 * Package spider.controller.searchCriteriaTab
 *
**/
package robot.controller.searchCriteriaTab;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import robot.gui.swing.tab.searchCriteria.SearchCriteriaTab;

/**
 * The Class ChangeCheckboxOnlyDefaultDomain.
 *
 * @author Daniel Žažo
 * @date 3. 3. 2015
 */
public class ChangeCheckboxOnlyDefaultDomain implements ActionListener {

	/** The search criteria tab. */
	private final SearchCriteriaTab searchCriteriaTab;
	
	/**
	 * Instantiates a new change checkbox only default domain.
	 *
	 * @param searchCriteriaTab the search criteria tab
	 */
	public ChangeCheckboxOnlyDefaultDomain(SearchCriteriaTab searchCriteriaTab) {
		this.searchCriteriaTab = searchCriteriaTab;
	}

	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if(searchCriteriaTab.getCheckboxDefaultDomain().isSelected()) {
			searchCriteriaTab.getListDomains().setEnabled(false);
			searchCriteriaTab.getBtnNewDomain().setEnabled(false);
			searchCriteriaTab.getTxtNewDomain().setEnabled(false);
			searchCriteriaTab.getTxtDefaultUrl().requestFocus();
		} else {
			searchCriteriaTab.getListDomains().setEnabled(true);
			searchCriteriaTab.getBtnNewDomain().setEnabled(true);
			searchCriteriaTab.getTxtNewDomain().setEnabled(true);
		}
	}

}
