/**
 * Package spider.gui.swing.tab
 *
 **/
package com.daniel.robot7.swing.tab.searchCriteria;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.text.PlainDocument;

import com.daniel.robot7.controller.searchCriteriaTab.AddNewDomainClick;
import com.daniel.robot7.controller.searchCriteriaTab.ChangeCheckboxMaxDepth;
import com.daniel.robot7.controller.searchCriteriaTab.ChangeCheckboxMaxVisitedPages;
import com.daniel.robot7.controller.searchCriteriaTab.ChangeCheckboxOnlyDefaultDomain;
import com.daniel.robot7.controller.searchCriteriaTab.ChangeCheckboxSetTimeout;
import com.daniel.robot7.controller.searchCriteriaTab.LongFilter;
import com.daniel.robot7.controller.searchCriteriaTab.ValidateUrlClick;
import com.daniel.robot7.swing.MainWindow;
import com.daniel.robot7.swing.common.MessageWindow;
import com.daniel.robot7.swing.common.ui.AbstractOperatingSystemUI;
import com.daniel.robot7.swing.metadata.tab.SearchCriteriaMetedata;
import com.daniel.robot7.swing.tab.AbstractTab;

/**
 * The Class SearchCriteriaTab.
 *
 * @author Daniel Žažo
 * @date 9. 2. 2015
 */
public class SearchCriteriaTab extends AbstractTab {

	/** The txt default url. */
	private JTextField						txtDefaultUrl;

	/** The list domains. */
	private JList<String>					listDomains;

	/** The default list model. */
	private DefaultListModel<String>		defaultListModel;

	/** The combo box maximum depth. */
	private JComboBox<String>				comboBoxMaximumDepth;

	/** The combo box maximum pages. */
	private JComboBox<String>				comboBoxMaximumPages;

	/** The txt area words. */
	private JTextArea						txtAreaWords;

	/** The checkbox max depth. */
	private JCheckBox						checkboxMaxDepth;

	/** The txt other max depth. */
	private JTextField						txtOtherMaxDepth;

	/** The checkbox max visited pages. */
	private JCheckBox						checkboxMaxVisitedPages;

	/** The txt othe max visited pages. */
	private JTextField						txtOtheMaxVisitedPages;

	/** The btn new domain. */
	private JButton							btnNewDomain;

	/** The txt new domain. */
	private JTextField						txtNewDomain;

	/** The domains list. */
	private List<String>					domainsList;

	/** The btn validate url. */
	private JButton							btnValidateUrl;

	/** The checkbox default domain. */
	private JCheckBox						checkboxDefaultDomain;

	/** The checkbox set timeout. */
	private JCheckBox						checkboxSetTimeout;

	/** The txt timeout. */
	private JTextField						txtTimeout;

	/** The operating system ui. */
	private final AbstractOperatingSystemUI	operatingSystemUI;

	/**
	 * Gets the checkbox default domain.
	 *
	 * @return the checkbox default domain
	 */
	public JCheckBox getCheckboxDefaultDomain() {
		return checkboxDefaultDomain;
	}

	/**
	 * Sets the checkbox default domain.
	 *
	 * @param checkboxDefaultDomain
	 *            the new checkbox default domain
	 */
	public void setCheckboxDefaultDomain(JCheckBox checkboxDefaultDomain) {
		this.checkboxDefaultDomain = checkboxDefaultDomain;
	}

	/**
	 * Gets the btn validate url.
	 *
	 * @return the btn validate url
	 */
	public JButton getBtnValidateUrl() {
		return btnValidateUrl;
	}

	/**
	 * Sets the btn validate url.
	 *
	 * @param btnValidateUrl
	 *            the new btn validate url
	 */
	public void setBtnValidateUrl(JButton btnValidateUrl) {
		this.btnValidateUrl = btnValidateUrl;
	}

	/**
	 * Gets the domains list.
	 *
	 * @return the domains list
	 */
	public List<String> getDomainsList() {
		return domainsList;
	}

	/**
	 * Sets the domains list.
	 *
	 * @param domainsList
	 *            the new domains list
	 */
	public void setDomainsList(List<String> domainsList) {
		this.domainsList = domainsList;
	}

	/**
	 * Gets the txt default url.
	 *
	 * @return the txt default url
	 */
	public JTextField getTxtDefaultUrl() {
		return txtDefaultUrl;
	}

	/**
	 * Sets the txt default url.
	 *
	 * @param txtDefaultUrl
	 *            the new txt default url
	 */
	public void setTxtDefaultUrl(JTextField txtDefaultUrl) {
		this.txtDefaultUrl = txtDefaultUrl;
	}

	/**
	 * Gets the list domains.
	 *
	 * @return the list domains
	 */
	public JList<String> getListDomains() {
		return listDomains;
	}

	/**
	 * Sets the list domains.
	 *
	 * @param listDomains
	 *            the new list domains
	 */
	public void setListDomains(JList<String> listDomains) {
		this.listDomains = listDomains;
	}

	/**
	 * Gets the default list model.
	 *
	 * @return the default list model
	 */
	public DefaultListModel<String> getDefaultListModel() {
		return defaultListModel;
	}

	/**
	 * Sets the default list model.
	 *
	 * @param defaultListModel
	 *            the new default list model
	 */
	public void setDefaultListModel(DefaultListModel<String> defaultListModel) {
		this.defaultListModel = defaultListModel;
	}

	/**
	 * Gets the combo box maximum depth.
	 *
	 * @return the combo box maximum depth
	 */
	public JComboBox<String> getComboBoxMaximumDepth() {
		return comboBoxMaximumDepth;
	}

	/**
	 * Sets the combo box maximum depth.
	 *
	 * @param comboBoxMaximumDepth
	 *            the new combo box maximum depth
	 */
	public void setComboBoxMaximumDepth(JComboBox<String> comboBoxMaximumDepth) {
		this.comboBoxMaximumDepth = comboBoxMaximumDepth;
	}

	/**
	 * Gets the combo box maximum pages.
	 *
	 * @return the combo box maximum pages
	 */
	public JComboBox<String> getComboBoxMaximumPages() {
		return comboBoxMaximumPages;
	}

	/**
	 * Sets the combo box maximum pages.
	 *
	 * @param comboBoxMaximumPages
	 *            the new combo box maximum pages
	 */
	public void setComboBoxMaximumPages(JComboBox<String> comboBoxMaximumPages) {
		this.comboBoxMaximumPages = comboBoxMaximumPages;
	}

	/**
	 * Gets the txt area words.
	 *
	 * @return the txt area words
	 */
	public JTextArea getTxtAreaWords() {
		return txtAreaWords;
	}

	/**
	 * Sets the txt area words.
	 *
	 * @param txtAreaWords
	 *            the new txt area words
	 */
	public void setTxtAreaWords(JTextArea txtAreaWords) {
		this.txtAreaWords = txtAreaWords;
	}

	/**
	 * Gets the checkbox max depth.
	 *
	 * @return the checkbox max depth
	 */
	public JCheckBox getCheckboxMaxDepth() {
		return checkboxMaxDepth;
	}

	/**
	 * Sets the checkbox max depth.
	 *
	 * @param checkboxMaxDepth
	 *            the new checkbox max depth
	 */
	public void setCheckboxMaxDepth(JCheckBox checkboxMaxDepth) {
		this.checkboxMaxDepth = checkboxMaxDepth;
	}

	/**
	 * Gets the txt other max depth.
	 *
	 * @return the txt other max depth
	 */
	public JTextField getTxtOtherMaxDepth() {
		return txtOtherMaxDepth;
	}

	/**
	 * Sets the txt other max depth.
	 *
	 * @param txtOtherMaxDepth
	 *            the new txt other max depth
	 */
	public void setTxtOtherMaxDepth(JTextField txtOtherMaxDepth) {
		this.txtOtherMaxDepth = txtOtherMaxDepth;
	}

	/**
	 * Gets the checkbox max visited pages.
	 *
	 * @return the checkbox max visited pages
	 */
	public JCheckBox getCheckboxMaxVisitedPages() {
		return checkboxMaxVisitedPages;
	}

	/**
	 * Sets the checkbox max visited pages.
	 *
	 * @param checkboxMaxVisitedPages
	 *            the new checkbox max visited pages
	 */
	public void setCheckboxMaxVisitedPages(JCheckBox checkboxMaxVisitedPages) {
		this.checkboxMaxVisitedPages = checkboxMaxVisitedPages;
	}

	/**
	 * Gets the txt othe max visited pages.
	 *
	 * @return the txt othe max visited pages
	 */
	public JTextField getTxtOtheMaxVisitedPages() {
		return txtOtheMaxVisitedPages;
	}

	/**
	 * Sets the txt othe max visited pages.
	 *
	 * @param txtOtheMaxVisitedPages
	 *            the new txt othe max visited pages
	 */
	public void setTxtOtheMaxVisitedPages(JTextField txtOtheMaxVisitedPages) {
		this.txtOtheMaxVisitedPages = txtOtheMaxVisitedPages;
	}

	/**
	 * Gets the btn new domain.
	 *
	 * @return the btn new domain
	 */
	public JButton getBtnNewDomain() {
		return btnNewDomain;
	}

	/**
	 * Sets the btn new domain.
	 *
	 * @param btnNewDomain
	 *            the new btn new domain
	 */
	public void setBtnNewDomain(JButton btnNewDomain) {
		this.btnNewDomain = btnNewDomain;
	}

	/**
	 * Gets the txt new domain.
	 *
	 * @return the txt new domain
	 */
	public JTextField getTxtNewDomain() {
		return txtNewDomain;
	}

	/**
	 * Sets the txt new domain.
	 *
	 * @param txtNewDomain
	 *            the new txt new domain
	 */
	public void setTxtNewDomain(JTextField txtNewDomain) {
		this.txtNewDomain = txtNewDomain;
	}

	/**
	 * Instantiates a new search criteria tab.
	 *
	 * @param mainWindow
	 *            the main window
	 */
	public SearchCriteriaTab(MainWindow mainWindow) {
		this.mainWindow = mainWindow;
		this.operatingSystemUI = this.mainWindow.getOperatingSystemUI();
		initComponents();
	}

	/**
	 * Inits the components.
	 */
	private void initComponents() {
		this.panel = new JPanel();
		this.panel.setLayout(new GridBagLayout());
		final GridBagConstraints gbc = new GridBagConstraints();

		gbc.insets = new Insets(10, 10, 10, 10); // TOP - LEFT - BOTTOM - RIGHT
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.anchor = GridBagConstraints.LINE_START;
		this.panel.add(getLabelComponent(SearchCriteriaMetedata.LABEL_DEFAULT_URL), gbc);

		gbc.gridx = 0;
		gbc.gridy = 1;
		this.panel.add(getLabelComponent(SearchCriteriaMetedata.LABEL_MAXIMUM_DEPTH), gbc);

		gbc.gridx = 0;
		gbc.gridy = 2;
		this.panel.add(getLabelComponent(SearchCriteriaMetedata.LABEL_MAXIMUM_VISITED_PAGES), gbc);

		gbc.gridx = 0;
		gbc.gridy = 3;
		this.panel.add(getLabelComponent(SearchCriteriaMetedata.LABEL_SEARCHED_DOMAINS), gbc);

		gbc.gridx = 0;
		gbc.gridy = 5;
		this.panel.add(getLabelComponent(SearchCriteriaMetedata.LABEL_SEARCHED_WORDS), gbc);

		gbc.gridx = 1;
		gbc.gridy = 0;
		gbc.gridwidth = 2;
		this.panel.add(getTxtDefaultUrlComponent(), gbc);

		gbc.gridx = 3;
		gbc.gridy = 0;
		gbc.gridwidth = 1;
		gbc.insets.left = 4;
		this.panel.add(getBtnValidateUrlComponent(), gbc);

		gbc.gridx = 1;
		gbc.gridy = 1;
		gbc.gridwidth = 2;
		gbc.insets.left = 10;
		this.panel.add(getComboMaximimumDepthComponent(), gbc);

		gbc.gridx = 1;
		gbc.gridy = 2;
		gbc.gridwidth = 1;
		this.panel.add(getComboMaximimumPagesComponent(), gbc);

		gbc.gridx = 1;
		gbc.gridy = 3;
		gbc.gridheight = 2;
		gbc.gridwidth = 2;
		gbc.insets = new Insets(0, 5, 0, 0);
		this.panel.add(getListDomainsComponent(), gbc);

		gbc.gridx = 1;
		gbc.gridy = 5;
		gbc.gridwidth = 2;
		gbc.gridheight = 1;
		gbc.insets.bottom = 10;
		this.panel.add(getTxtAreaWordsComponent(), gbc);

		gbc.gridx = 2;
		gbc.gridy = 1;
		gbc.gridwidth = 1;
		gbc.insets.left = 145;
		gbc.insets.bottom = 5;
		this.panel.add(getCheckBoxOtherMaxDepthComponent(), gbc);

		gbc.gridx = 3;
		gbc.gridy = 1;
		gbc.insets.left = 5;
		this.panel.add(getTxtOtherMaxDepthComponent(), gbc);

		gbc.gridx = 2;
		gbc.gridy = 2;
		gbc.insets.left = 145;
		this.panel.add(getCheckBoxOtherMaxVisitedPagesComponent(), gbc);

		gbc.gridx = 3;
		gbc.gridy = 2;
		gbc.insets.left = 5;
		this.panel.add(getTxtOtherMaxVisitedPagesComponent(), gbc);

		gbc.gridx = 2;
		gbc.gridy = 4;
		gbc.insets.left = 145;
		gbc.gridwidth = 2;
		this.panel.add(getCheckBoxDefaultDomainComponent(), gbc);

		gbc.gridx = 2;
		gbc.gridy = 5;
		gbc.insets.left = 145;
		gbc.gridwidth = 1;
		this.panel.add(getCheckBoxTimeoutComponent(), gbc);

		gbc.gridx = 3;
		gbc.gridy = 5;
		gbc.insets.left = 4;
		gbc.gridwidth = 1;
		this.panel.add(getTxtTimeoutComponent(), gbc);

		gbc.gridx = 2;
		gbc.gridy = 3;
		gbc.insets.left = 150;
		gbc.insets.right = 20;
		gbc.insets.top = 20;
		gbc.gridwidth = 1;
		this.panel.add(getBtnNewDomainComponent(), gbc);

		gbc.gridx = 3;
		gbc.gridy = 3;
		gbc.insets.left = 5;
		this.panel.add(getTxtNewDomainComponent(), gbc);

	}

	/**
	 * Gets the check box timeout component.
	 *
	 * @return the check box timeout component
	 */
	private JCheckBox getCheckBoxTimeoutComponent() {
		checkboxSetTimeout = new JCheckBox(SearchCriteriaMetedata.LABEL_SEARCH_SET_TIMEOUT_IN_SEARCHING);
		checkboxSetTimeout.addActionListener(new ChangeCheckboxSetTimeout(this));
		return checkboxSetTimeout;
	}

	/**
	 * Gets the checkbox set timeout.
	 *
	 * @return the checkbox set timeout
	 */
	public JCheckBox getCheckboxSetTimeout() {
		return checkboxSetTimeout;
	}

	/**
	 * Sets the checkbox set timeout.
	 *
	 * @param checkboxSetTimeout
	 *            the new checkbox set timeout
	 */
	public void setCheckboxSetTimeout(JCheckBox checkboxSetTimeout) {
		this.checkboxSetTimeout = checkboxSetTimeout;
	}

	/**
	 * Gets the txt timeout.
	 *
	 * @return the txt timeout
	 */
	public JTextField getTxtTimeout() {
		return txtTimeout;
	}

	/**
	 * Sets the txt timeout.
	 *
	 * @param txtTimeout
	 *            the new txt timeout
	 */
	public void setTxtTimeout(JTextField txtTimeout) {
		this.txtTimeout = txtTimeout;
	}

	/**
	 * Gets the txt timeout component.
	 *
	 * @return the txt timeout component
	 */
	private JTextField getTxtTimeoutComponent() {
		txtTimeout = new JTextField(10);
		txtTimeout.setEnabled(false);
		// Default time for sleep
		txtTimeout.setText(Integer.toString(1000));

		final PlainDocument plainDocument = (PlainDocument) txtTimeout.getDocument();
		plainDocument.setDocumentFilter(new LongFilter());

		return txtTimeout;
	}

	/**
	 * Gets the check box default domain component.
	 *
	 * @return the check box default domain component
	 */
	private JCheckBox getCheckBoxDefaultDomainComponent() {
		checkboxDefaultDomain = new JCheckBox(SearchCriteriaMetedata.LABEL_SEARCH_ONLY_ON_DEFAULT_HOST);
		checkboxDefaultDomain.addActionListener(new ChangeCheckboxOnlyDefaultDomain(this));
		return checkboxDefaultDomain;
	}

	/**
	 * Gets the txt new domain component.
	 *
	 * @return the txt new domain component
	 */
	private JTextField getTxtNewDomainComponent() {
		txtNewDomain = new JTextField(10);
		return txtNewDomain;
	}

	/**
	 * Gets the btn new domain component.
	 *
	 * @return the btn new domain component
	 */
	private JButton getBtnNewDomainComponent() {
		btnNewDomain = new JButton(SearchCriteriaMetedata.BUTTON_ADD_NEW_DOMAIN);
		btnNewDomain.addActionListener(new AddNewDomainClick(this));
		return btnNewDomain;
	}

	/**
	 * Gets the txt other max visited pages component.
	 *
	 * @return the txt other max visited pages component
	 */
	private JTextField getTxtOtherMaxVisitedPagesComponent() {
		txtOtheMaxVisitedPages = new JTextField(10);
		txtOtheMaxVisitedPages.setEnabled(false);

		final PlainDocument plainDocument = (PlainDocument) txtOtheMaxVisitedPages.getDocument();
		plainDocument.setDocumentFilter(new LongFilter());

		return txtOtheMaxVisitedPages;
	}

	/**
	 * Gets the check box other max visited pages component.
	 *
	 * @return the check box other max visited pages component
	 */
	private JCheckBox getCheckBoxOtherMaxVisitedPagesComponent() {
		checkboxMaxVisitedPages = new JCheckBox(SearchCriteriaMetedata.LABEL_OTHER_MAX_PAGES);
		checkboxMaxVisitedPages.addActionListener(new ChangeCheckboxMaxVisitedPages(this));
		return checkboxMaxVisitedPages;
	}

	/**
	 * Gets the txt other max depth component.
	 *
	 * @return the txt other max depth component
	 */
	private JTextField getTxtOtherMaxDepthComponent() {
		txtOtherMaxDepth = new JTextField(10);
		txtOtherMaxDepth.setEnabled(false);

		final PlainDocument plainDocument = (PlainDocument) txtOtherMaxDepth.getDocument();
		plainDocument.setDocumentFilter(new LongFilter());

		return txtOtherMaxDepth;
	}

	/**
	 * Gets the check box other max depth component.
	 *
	 * @return the check box other max depth component
	 */
	private JCheckBox getCheckBoxOtherMaxDepthComponent() {
		checkboxMaxDepth = new JCheckBox(SearchCriteriaMetedata.LABEL_OTHER_MAX_DEPTH);
		checkboxMaxDepth.addActionListener(new ChangeCheckboxMaxDepth(this));
		return checkboxMaxDepth;
	}

	/**
	 * Gets the txt area words component.
	 *
	 * @return the txt area words component
	 */
	private JPanel getTxtAreaWordsComponent() {
		txtAreaWords = new JTextArea();
		txtAreaWords.setEditable(true);
		txtAreaWords.setFont(this.operatingSystemUI.getFontTextAreaSerachedPhrases());

		final JScrollPane scrollPane = new JScrollPane(txtAreaWords);
		scrollPane.setPreferredSize(new Dimension(200, 200));
		final JPanel jPanel = new JPanel();
		scrollPane.getVerticalScrollBar().setEnabled(true);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		jPanel.add(scrollPane);

		return jPanel;
	}

	/**
	 * Gets the list domains component.
	 *
	 * @return the list domains component
	 */
	private JPanel getListDomainsComponent() {
		defaultListModel = new DefaultListModel<String>();
		fillDefaultListmodel();
		listDomains = new JList<String>(defaultListModel);
		listDomains.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		listDomains.setSelectedIndex(0);
		listDomains.setLayoutOrientation(JList.HORIZONTAL_WRAP);

		final JPanel jPanel = new JPanel();
		final JScrollPane scrollPane = new JScrollPane(listDomains);
		scrollPane.setPreferredSize(new Dimension(200, 100));
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		jPanel.add(scrollPane);

		return jPanel;
	}

	/**
	 * Fill default listmodel.
	 */
	private void fillDefaultListmodel() {
		final String[] domains = getValuesFromFile(SearchCriteriaMetedata.FILE_PATH_DOMAINS);
		domainsList = new ArrayList<String>();
		for (final String domain : domains) {
			defaultListModel.addElement(domain);
			domainsList.add(domain);
		}
	}

	/**
	 * Gets the values from file.
	 *
	 * @param filePath
	 *            the file path
	 * @return the values from file
	 */
	private String[] getValuesFromFile(String filePath) {
		final InputStream inputStream = ClassLoader.getSystemResourceAsStream(filePath);
		InputStreamReader streamReader = null;
		try {
			streamReader = new InputStreamReader(inputStream, StandardCharsets.UTF_8.name());
		} catch (final UnsupportedEncodingException e) {
			MessageWindow.showError(SearchCriteriaMetedata.ERROR_WRONG_ENCODING);
		}

		final BufferedReader in = new BufferedReader(streamReader);
		final List<String> list = new ArrayList<String>();
		try {
			for (String line; (line = in.readLine()) != null;) {
				list.add(line);
			}
		} catch (final IOException e) {
			MessageWindow.showError(SearchCriteriaMetedata.ERROR_LOAD_VALUES);
		}

		return list.toArray(new String[list.size()]);
	}

	/**
	 * Gets the combo maximimum pages component.
	 *
	 * @return the combo maximimum pages component
	 */
	private JComboBox<String> getComboMaximimumPagesComponent() {
		comboBoxMaximumPages = new JComboBox<String>(getValuesFromFile(SearchCriteriaMetedata.FILE_PATH_MAXIMUM_PAGES));
		comboBoxMaximumPages.setSelectedIndex(0);
		return comboBoxMaximumPages;
	}

	/**
	 * Gets the combo maximimum depth component.
	 *
	 * @return the combo maximimum depth component
	 */
	private JComboBox<String> getComboMaximimumDepthComponent() {
		comboBoxMaximumDepth = new JComboBox<String>(getValuesFromFile(SearchCriteriaMetedata.FILE_PATH_MAXIMUM_DEPTH));
		comboBoxMaximumDepth.setSelectedIndex(0);
		return comboBoxMaximumDepth;
	}

	/**
	 * Gets the btn validate url component.
	 *
	 * @return the btn validate url component
	 */
	private JButton getBtnValidateUrlComponent() {
		btnValidateUrl = new JButton(SearchCriteriaMetedata.BUTTON_VALIDATE_URL);
		btnValidateUrl.addActionListener(new ValidateUrlClick(this));
		return btnValidateUrl;
	}

	/**
	 * Gets the txt default url component.
	 *
	 * @return the txt default url component
	 */
	private JTextField getTxtDefaultUrlComponent() {
		txtDefaultUrl = new JTextField(37);
		txtDefaultUrl.setText("http://127.0.0.1:8080/servlet-filter");
		// txtDefaultUrl.setText("http://localhost:8080/ServletFilter/");
		return txtDefaultUrl;
	}

	/**
	 * Gets the label component.
	 *
	 * @param s
	 *            the s
	 * @return the label component
	 */
	private JLabel getLabelComponent(String s) {
		return new JLabel(s);
	}

}
