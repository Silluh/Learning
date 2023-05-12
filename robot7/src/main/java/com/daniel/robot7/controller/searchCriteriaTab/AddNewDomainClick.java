/**
 * Package spider.controller.searchCriteria
 *
 **/
package robot.controller.searchCriteriaTab;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import robot.controller.AbstractDataController;
import robot.gui.swing.common.MessageWindow;
import robot.gui.swing.metadata.tab.SearchCriteriaMetedata;
import robot.gui.swing.tab.searchCriteria.SearchCriteriaTab;
import robot.util.CommonConstants;

/**
 * The Class AddNewDomainClick.
 *
 * @author Daniel Žažo
 * @date 11. 2. 2015
 */
public class AddNewDomainClick extends AbstractDataController implements ActionListener {

	/** The new domain. */
	private String	newDomain	= null;

	/**
	 * Instantiates a new adds the new domain click.
	 *
	 * @param searchCriteriaTab
	 *            the search criteria tab
	 */
	public AddNewDomainClick(SearchCriteriaTab searchCriteriaTab) {
		this.searchCriteriaTab = searchCriteriaTab;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		newDomain = searchCriteriaTab.getTxtNewDomain().getText();
		if (isFilledDomainCorrect() && !containsNewDomain()) {
			addNewDomain();
		}
	}

	/**
	 * Contains new domain.
	 *
	 * @return true, if successful
	 */
	private boolean containsNewDomain() {
		if (searchCriteriaTab.getDomainsList().contains(newDomain)) {
			MessageWindow.showError(SearchCriteriaMetedata.ERROR_NEW_DOMAIN_CANT_EXISTS);
			return true;
		}
		return false;
	}

	/**
	 * Adds the new domain.
	 */
	private void addNewDomain() {
		int index = searchCriteriaTab.getListDomains().getSelectedIndex();
		if (index == -1) { // no selection, so insert at beginning
			index = 0;
		} else { // add after the selected item
			index++;
		}
		searchCriteriaTab.getDomainsList().add(newDomain);
		searchCriteriaTab.getDefaultListModel().insertElementAt(newDomain, index);
		searchCriteriaTab.getTxtNewDomain().setText(CommonConstants.EMPTY_STRING);
	}

	/**
	 * Checks if is filled domain correct.
	 *
	 * @return true, if is filled domain correct
	 */
	private boolean isFilledDomainCorrect() {
		if (newDomain.isEmpty()) {
			MessageWindow.showError(SearchCriteriaMetedata.ERROR_NEW_DOMAIN_CANT_BE_EMPTY);
			return false;
		} else if (newDomain.charAt(0) != CommonConstants.DOT.charAt(0)) {
			MessageWindow.showError(SearchCriteriaMetedata.ERROR_NEW_DOMAIN_MUST_START_BY_DOT);
			return false;
		} else if (newDomain.length() < 3) {
			MessageWindow.showError(SearchCriteriaMetedata.ERROR_NEW_DOMAIN_MUST_BE_BIGGER_THAN_1_LETTERS);
			return false;
		}
		return true;
	}

}
