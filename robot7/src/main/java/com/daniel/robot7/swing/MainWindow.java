/**
 * Package spider.gui.swing
 *
 */
package com.daniel.robot7.swing;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JTabbedPane;
import javax.swing.Timer;
import javax.swing.border.TitledBorder;

import com.daniel.robot7.controller.mainButtonsPanel.TimerDefaultActionListener;
import com.daniel.robot7.controller.resultTab.CrawlerThread;
import com.daniel.robot7.swing.common.MainButtonsPanel;
import com.daniel.robot7.swing.common.ui.AbstractOperatingSystemUI;
import com.daniel.robot7.swing.common.ui.CommonColors;
import com.daniel.robot7.swing.common.ui.CommonFonts;
import com.daniel.robot7.swing.metadata.MainWindowMetadata;
import com.daniel.robot7.swing.metadata.tab.GraphMetadata;
import com.daniel.robot7.swing.metadata.tab.LogMetadata;
import com.daniel.robot7.swing.metadata.tab.ResultMetadata;
import com.daniel.robot7.swing.metadata.tab.SearchCriteriaMetedata;
import com.daniel.robot7.swing.tab.graph.GraphTab;
import com.daniel.robot7.swing.tab.log.ErrorLogTab;
import com.daniel.robot7.swing.tab.result.ResultTreeTab;
import com.daniel.robot7.swing.tab.searchCriteria.SearchCriteriaTab;
import com.daniel.robot7.model.StatisticsModel;
import com.daniel.robot7.util.CommonConstants;

/**
 * The Class MainWindow.
 *
 * @author Daniel Žažo
 * @date 9. 2. 2015
 */
public class MainWindow extends JFrame {

	/** Serial version UID. */
	private static final long			serialVersionUID	= -6431008479005528461L;

	/**
	 * Container for all components.
	 */
	private Container					container			= getContentPane();

	/**
	 * JTabbedPane tabbedPane for all tabs.
	 */
	private JTabbedPane					jTabbedPane;

	/** The search criteria tab. */
	private SearchCriteriaTab			searchCriteriaTab;

	/** The result tree tab. */
	private ResultTreeTab				resultTreeTab;

	/** The error log tab. */
	private ErrorLogTab					errorLogTab;

	/** The graph tab. */
	private GraphTab					graphTab;

	/** The main buttons panel. */
	private MainButtonsPanel			mainButtonsPanel;

	/** The main panel. */
	private JPanel						mainPanel;

	/** The spider thread. */
	private CrawlerThread				spiderThread;

	/** The progress bar. */
	private JProgressBar				progressBar;

	/** The title quick statistics. */
	private TitledBorder				titleQuickStatistics;

	/** The panel scale grid progress bar. */
	private JPanel						panelScaleGridProgressBar;

	/** The panel scale grid quick statistics. */
	private JPanel						panelScaleGridQuickStatistics;

	/** The statistics model. */
	private StatisticsModel				statisticsModel;

	/** The lbl quick statistics1. */
	private JLabel						lblQuickStatistics1;

	/** The lbl quick statistics2. */
	private JLabel						lblQuickStatistics2;

	/** The lbl quick statistics3. */
	private JLabel						lblQuickStatistics3;

	/** The lbl time. */
	private JLabel						lblTime;

	/** The timer. */
	private Timer						timer;

	/** The operating system ui. */
	private AbstractOperatingSystemUI	operatingSystemUI;

	/**
	 * Gets the spider thread.
	 *
	 * @return the spider thread
	 */
	public CrawlerThread getSpiderThread() {
		return spiderThread;
	}

	/**
	 * Sets the spider thread.
	 *
	 * @param spiderThread
	 *            the new spider thread
	 */
	public void setSpiderThread(CrawlerThread spiderThread) {
		this.spiderThread = spiderThread;
	}

	/**
	 * Sets the container.
	 *
	 * @param container
	 *            the new container
	 */
	public void setContainer(Container container) {
		this.container = container;
	}

	/**
	 * Gets the tabbed pane.
	 *
	 * @return the tabbed pane
	 */
	public JTabbedPane getTabbedPane() {
		return jTabbedPane;
	}

	/**
	 * Sets the tabbed pane.
	 *
	 * @param tabbedPane
	 *            the new tabbed pane
	 */
	public void setTabbedPane(JTabbedPane tabbedPane) {
		this.jTabbedPane = tabbedPane;
	}

	/**
	 * Gets the search criteria tab.
	 *
	 * @return the search criteria tab
	 */
	public SearchCriteriaTab getSearchCriteriaTab() {
		return searchCriteriaTab;
	}

	/**
	 * Sets the search criteria tab.
	 *
	 * @param searchCriteriaTab
	 *            the new search criteria tab
	 */
	public void setSearchCriteriaTab(SearchCriteriaTab searchCriteriaTab) {
		this.searchCriteriaTab = searchCriteriaTab;
	}

	/**
	 * Gets the result tab.
	 *
	 * @return the result tab
	 */
	public ResultTreeTab getResultTab() {
		return resultTreeTab;
	}

	/**
	 * Sets the result tab.
	 *
	 * @param resultTab
	 *            the new result tab
	 */
	public void setResultTab(ResultTreeTab resultTab) {
		this.resultTreeTab = resultTab;
	}

	/**
	 * Gets the error log tab.
	 *
	 * @return the error log tab
	 */
	public ErrorLogTab getErrorLogTab() {
		return errorLogTab;
	}

	/**
	 * Sets the log tab.
	 *
	 * @param logTab
	 *            the new log tab
	 */
	public void setLogTab(ErrorLogTab logTab) {
		this.errorLogTab = logTab;
	}

	/**
	 * Gets the main buttons panel.
	 *
	 * @return the main buttons panel
	 */
	public MainButtonsPanel getMainButtonsPanel() {
		return mainButtonsPanel;
	}

	/**
	 * Sets the main buttons panel.
	 *
	 * @param mainButtonsPanel
	 *            the new main buttons panel
	 */
	public void setMainButtonsPanel(MainButtonsPanel mainButtonsPanel) {
		this.mainButtonsPanel = mainButtonsPanel;
	}

	/**
	 * Gets the main panel.
	 *
	 * @return the main panel
	 */
	public JPanel getMainPanel() {
		return mainPanel;
	}

	/**
	 * Sets the main panel.
	 *
	 * @param mainPanel
	 *            the new main panel
	 */
	public void setMainPanel(JPanel mainPanel) {
		this.mainPanel = mainPanel;
	}

	/**
	 * Gets the j progress bar.
	 *
	 * @return the j progress bar
	 */
	public JProgressBar getjProgressBar() {
		return progressBar;
	}

	/**
	 * Sets the j progress bar.
	 *
	 * @param jProgressBar
	 *            the new j progress bar
	 */
	public void setjProgressBar(JProgressBar jProgressBar) {
		this.progressBar = jProgressBar;
	}

	/**
	 * Gets the statistics model.
	 *
	 * @return the statistics model
	 */
	public StatisticsModel getStatisticsModel() {
		return statisticsModel;
	}

	/**
	 * Sets the statistics model.
	 *
	 * @param statisticsModel
	 *            the new statistics model
	 */
	public void setStatisticsModel(StatisticsModel statisticsModel) {
		this.statisticsModel = statisticsModel;
	}

	/**
	 * Gets the operating system ui.
	 *
	 * @return the operating system ui
	 */
	public AbstractOperatingSystemUI getOperatingSystemUI() {
		return operatingSystemUI;
	}

	/**
	 * Sets the operating system.
	 *
	 * @param operatingSystem
	 *            the new operating system
	 */
	public void setOperatingSystem(AbstractOperatingSystemUI operatingSystem) {
		this.operatingSystemUI = operatingSystem;
	}

	/**
	 * Gets the lbl time.
	 *
	 * @return the lbl time
	 */
	public JLabel getLblTime() {
		return lblTime;
	}

	/**
	 * Sets the lbl time.
	 *
	 * @param lblTime
	 *            the new lbl time
	 */
	public void setLblTime(JLabel lblTime) {
		this.lblTime = lblTime;
	}

	/**
	 * Constructor.
	 *
	 * @param abstractOperatingSystem
	 *            the abstract operating system
	 */
	public MainWindow(AbstractOperatingSystemUI abstractOperatingSystem) {
		super(MainWindowMetadata.APPLICATION_NAME);
		this.operatingSystemUI = abstractOperatingSystem;
		setSize(this.operatingSystemUI.getDimensionMainWindow());
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		setContentPane(container);
		setVisible(true);
	}

	/**
	 * Creating user interface of application.
	 */
	public void initComponents() {
		mainPanel = new JPanel();

		mainPanel = new JPanel(new GridBagLayout());
		final GridBagConstraints gbc = new GridBagConstraints();

		gbc.insets = new Insets(10, 20, 10, 10); // TOP - LEFT - BOTTOM - RIGHT
		gbc.gridx = 0;
		gbc.gridy = 0;
		mainPanel.add(getJTabbedPane(), gbc);

		gbc.insets = new Insets(5, 20, 5, 10); // TOP - LEFT - BOTTOM - RIGHT
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		mainPanel.add(getQuickStatisticsPanelComponent(), gbc);

		gbc.insets = new Insets(5, 20, 5, 10); // TOP - LEFT - BOTTOM - RIGHT
		gbc.gridx = 0;
		gbc.gridy = 2;
		mainPanel.add(getButtonsPanel(), gbc);

		gbc.insets = new Insets(5, 20, 5, 10); // TOP - LEFT - BOTTOM - RIGHT
		gbc.gridx = 0;
		gbc.gridy = 3;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		mainPanel.add(getPanelScaleGridStatusComponent(), gbc);

		container.add(mainPanel);
	}

	/**
	 * Gets the j tabbed pane.
	 *
	 * @return the j tabbed pane
	 */
	private JTabbedPane getJTabbedPane() {
		jTabbedPane = new JTabbedPane();

		searchCriteriaTab = new SearchCriteriaTab(this);
		jTabbedPane.add(searchCriteriaTab.getPanel(), SearchCriteriaMetedata.TAB_SETTINGS);

		resultTreeTab = new ResultTreeTab(this);
		jTabbedPane.add(resultTreeTab.getPanel(), ResultMetadata.TAB_RESULT_TREE);

		errorLogTab = new ErrorLogTab(this);
		jTabbedPane.add(errorLogTab.getPanel(), LogMetadata.TAB_ERROR_LOG);

		graphTab = new GraphTab(this);
		jTabbedPane.add(graphTab.getPanel(), GraphMetadata.TAB_GRAPH);

		return jTabbedPane;
	}

	/**
	 * Gets the quick statistics panel component.
	 *
	 * @return the quick statistics panel component
	 */
	private JPanel getQuickStatisticsPanelComponent() {
		statisticsModel = new StatisticsModel(0, 0, 0);
		panelScaleGridQuickStatistics = new JPanel(new GridBagLayout());
		final GridBagConstraints gbc = new GridBagConstraints();

		final TitledBorder titleQuickStatistics = BorderFactory.createTitledBorder(MainWindowMetadata.LABEL_TITLE_QUICK_STATISTICS);
		titleQuickStatistics.setTitleFont(CommonFonts.fontSize20);
		panelScaleGridQuickStatistics.setBorder(titleQuickStatistics);

		gbc.insets = new Insets(10, 10, 10, 10); // TOP - LEFT - BOTTOM - RIGHT
		gbc.gridx = 0;
		gbc.gridy = 0;
		panelScaleGridQuickStatistics.add(getPanelQuickStatistics1(), gbc);

		gbc.insets = new Insets(10, 10, 10, 10); // TOP - LEFT - BOTTOM - RIGHT
		gbc.gridx = 1;
		gbc.gridy = 0;
		panelScaleGridQuickStatistics.add(getPanelQuickStatistics2(), gbc);

		gbc.insets = new Insets(10, 10, 10, 10); // TOP - LEFT - BOTTOM - RIGHT
		gbc.gridx = 2;
		gbc.gridy = 0;
		panelScaleGridQuickStatistics.add(getPanelQuickStatistics3(), gbc);

		gbc.insets = new Insets(10, 10, 10, 10); // TOP - LEFT - BOTTOM - RIGHT
		gbc.gridx = 3;
		gbc.gridy = 0;
		panelScaleGridQuickStatistics.add(getPanelTimer(), gbc);

		return panelScaleGridQuickStatistics;
	}

	/**
	 * Gets the panel timer.
	 *
	 * @return the panel timer
	 */
	private JPanel getPanelTimer() {
		final JPanel panel = new JPanel(new GridBagLayout());
		final GridBagConstraints gbc = new GridBagConstraints();

		gbc.insets = new Insets(0, 0, 0, 0); // TOP - LEFT - BOTTOM - RIGHT
		gbc.gridx = 0;
		gbc.gridy = 0;
		final JLabel description = new JLabel(MainWindowMetadata.LABEL_TIME);
		description.setFont(operatingSystemUI.getFontLabelStatistics());
		panel.add(description, gbc);

		lblTime = new JLabel(CommonConstants.ZERO);
		lblTime.setFont(operatingSystemUI.getFontLabelStatistics());
		lblTime.setForeground(CommonColors.DARK_GREEN);
		gbc.insets = new Insets(0, 0, 0, 0); // TOP - LEFT - BOTTOM - RIGHT
		gbc.gridx = 1;
		gbc.gridy = 0;
		panel.add(lblTime, gbc);

		resetTimer();

		return panel;
	}

	/**
	 * Gets the new timer.
	 *
	 * @return the new timer
	 */
	private Timer getNewTimer() {
		final int TEN_SECONDS = 10;
		return new Timer(TEN_SECONDS, new TimerDefaultActionListener(this));
	}

	/**
	 * Gets the panel quick statistics1.
	 *
	 * @return the panel quick statistics1
	 */
	private JPanel getPanelQuickStatistics1() {
		final JPanel panel = new JPanel(new GridBagLayout());
		final GridBagConstraints gbc = new GridBagConstraints();

		gbc.insets = new Insets(0, 0, 0, 0); // TOP - LEFT - BOTTOM - RIGHT
		gbc.gridx = 0;
		gbc.gridy = 0;
		final JLabel description = new JLabel(MainWindowMetadata.LABEL_FOUND_LINKS);
		description.setFont(operatingSystemUI.getFontLabelStatistics());
		panel.add(description, gbc);

		lblQuickStatistics1 = new JLabel(Long.toString(statisticsModel.getCountSearchedPages()));
		lblQuickStatistics1.setForeground(Color.BLUE);
		lblQuickStatistics1.setFont(operatingSystemUI.getFontLabelStatistics());
		gbc.insets = new Insets(0, 0, 0, 0); // TOP - LEFT - BOTTOM - RIGHT
		gbc.gridx = 1;
		gbc.gridy = 0;
		panel.add(lblQuickStatistics1, gbc);

		return panel;
	}

	/**
	 * Gets the panel quick statistics2.
	 *
	 * @return the panel quick statistics2
	 */
	private JPanel getPanelQuickStatistics2() {
		final JPanel panel = new JPanel(new GridBagLayout());
		final GridBagConstraints gbc = new GridBagConstraints();

		gbc.insets = new Insets(0, 0, 0, 0); // TOP - LEFT - BOTTOM - RIGHT
		gbc.gridx = 0;
		gbc.gridy = 0;
		final JLabel description = new JLabel(MainWindowMetadata.LABEL_WRONG_LINKS);
		description.setFont(operatingSystemUI.getFontLabelStatistics());
		panel.add(description, gbc);

		lblQuickStatistics2 = new JLabel(Long.toString(statisticsModel.getCountWrongLinks()));
		lblQuickStatistics2.setForeground(Color.RED);
		lblQuickStatistics2.setFont(operatingSystemUI.getFontLabelStatistics());
		gbc.insets = new Insets(0, 0, 0, 0); // TOP - LEFT - BOTTOM - RIGHT
		gbc.gridx = 1;
		gbc.gridy = 0;
		panel.add(lblQuickStatistics2, gbc);

		return panel;
	}

	/**
	 * Gets the panel quick statistics3.
	 *
	 * @return the panel quick statistics3
	 */
	private JPanel getPanelQuickStatistics3() {
		final JPanel panel = new JPanel(new GridBagLayout());
		final GridBagConstraints gbc = new GridBagConstraints();

		gbc.insets = new Insets(0, 0, 0, 0); // TOP - LEFT - BOTTOM - RIGHT
		gbc.gridx = 0;
		gbc.gridy = 0;
		final JLabel description = new JLabel(MainWindowMetadata.LABEL_PAGES_WITH_FOUNDED_PHRASES);
		description.setFont(operatingSystemUI.getFontLabelStatistics());
		panel.add(description, gbc);

		lblQuickStatistics3 = new JLabel(Long.toString(statisticsModel.getCountWrongLinks()));
		lblQuickStatistics3.setForeground(CommonColors.DARK_GREEN);
		lblQuickStatistics3.setFont(operatingSystemUI.getFontLabelStatistics());
		gbc.insets = new Insets(0, 0, 0, 0); // TOP - LEFT - BOTTOM - RIGHT
		gbc.gridx = 1;
		gbc.gridy = 0;
		panel.add(lblQuickStatistics3, gbc);

		return panel;
	}

	/**
	 * Gets the buttons panel.
	 *
	 * @return the buttons panel
	 */
	private JPanel getButtonsPanel() {
		mainButtonsPanel = new MainButtonsPanel(this);
		final JPanel panel = new JPanel();
		panel.add(mainButtonsPanel.getMainButtonsPanel());

		return panel;
	}

	/**
	 * Gets the panel scale grid status component.
	 *
	 * @return the panel scale grid status component
	 */
	private JPanel getPanelScaleGridStatusComponent() {
		panelScaleGridProgressBar = new JPanel(new GridBagLayout());
		final GridBagConstraints gbc = new GridBagConstraints();

		titleQuickStatistics = BorderFactory.createTitledBorder(MainWindowMetadata.LABEL_STATUS_INACTIVE);
		titleQuickStatistics.setTitleFont(CommonFonts.fontSize20);
		panelScaleGridProgressBar.setBorder(titleQuickStatistics);

		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.insets = new Insets(10, 10, 10, 10); // TOP - LEFT - BOTTOM - RIGHT

		panelScaleGridProgressBar.add(getProgressBarComponent(), gbc);
		return panelScaleGridProgressBar;
	}

	/**
	 * Gets the progress bar component.
	 *
	 * @return the progress bar component
	 */
	private JProgressBar getProgressBarComponent() {
		progressBar = new JProgressBar(JProgressBar.HORIZONTAL);
		progressBar.setPreferredSize(new Dimension(700, 20));
		setPanelProgressBarInActive();

		return progressBar;
	}

	/**
	 * Sets the status active searching.
	 */
	public void setStatusActiveSearching() {
		resetTimer();
		this.searchCriteriaTab.getPanel().setEnabled(false);
		this.getMainButtonsPanel().getBtnStopSearching().setEnabled(true);
		disableAllComponents();

		setPanelProgressBarActive();
	}

	/**
	 * Disable all components.
	 */
	private void disableAllComponents() {
		this.searchCriteriaTab.getTxtDefaultUrl().setEditable(false);
		this.searchCriteriaTab.getTxtOtherMaxDepth().setEditable(false);
		this.searchCriteriaTab.getTxtOtheMaxVisitedPages().setEditable(false);
		this.searchCriteriaTab.getTxtNewDomain().setEditable(false);
		this.searchCriteriaTab.getTxtAreaWords().setEditable(false);
		this.searchCriteriaTab.getBtnValidateUrl().setEnabled(false);
		this.searchCriteriaTab.getBtnNewDomain().setEnabled(false);
		this.mainButtonsPanel.getBtnStartSearching().setEnabled(false);
	}

	/**
	 * Sets the status in active searching done.
	 */
	public void setStatusInActiveSearchingDone() {
		setOnlyStatusSearchingDone();
		setPanelProgressBarDone();
	}

	/**
	 * Sets the status in active stopped.
	 */
	public void setStatusInActiveStopped() {
		setOnlyStatusSearchingDone();
		setPanelProgressBarInActiveStopped();
	}

	/**
	 * Sets the status active not finished.
	 */
	public void setStatusActiveNotFinished() {
		disableAllComponents();
		titleQuickStatistics.setTitle(MainWindowMetadata.LABEL_STATUS_FINISHHING_STOPPING);
		panelScaleGridProgressBar.setBackground(CommonColors.LIGHT_GREEN);
		panelScaleGridProgressBar.repaint();
		mainPanel.repaint();
	}

	/**
	 * Sets the only status searching done.
	 */
	private void setOnlyStatusSearchingDone() {
		this.mainButtonsPanel.getBtnStartSearching().setEnabled(true);
		this.getMainButtonsPanel().getBtnStopSearching().setEnabled(false);
		enableAllComponents();
	}

	/**
	 * Enable all components.
	 */
	public void enableAllComponents() {
		this.searchCriteriaTab.getTxtDefaultUrl().setEditable(true);
		this.searchCriteriaTab.getTxtOtherMaxDepth().setEditable(true);
		this.searchCriteriaTab.getTxtOtheMaxVisitedPages().setEditable(true);
		this.searchCriteriaTab.getTxtNewDomain().setEditable(true);
		this.searchCriteriaTab.getTxtAreaWords().setEditable(true);
		this.searchCriteriaTab.getBtnValidateUrl().setEnabled(true);
		this.searchCriteriaTab.getBtnNewDomain().setEnabled(true);
		this.mainButtonsPanel.getBtnStartSearching().setEnabled(true);
	}

	/**
	 * Sets the panel progress bar active.
	 */
	private void setPanelProgressBarActive() {
		titleQuickStatistics.setTitle(MainWindowMetadata.LABEL_STATUS_ACTIVE);
		panelScaleGridProgressBar.setBackground(CommonColors.LIGHT_GREEN);
		panelScaleGridProgressBar.repaint();

		progressBar.setIndeterminate(true);
		timer.start();
	}

	/**
	 * Sets the panel progress bar in active.
	 */
	private void setPanelProgressBarInActive() {
		titleQuickStatistics.setTitle(MainWindowMetadata.LABEL_STATUS_INACTIVE);
		panelScaleGridProgressBar.repaint();

		progressBar.setIndeterminate(false);
		progressBar.setValue(0);
		timer.stop();
	}

	/**
	 * Sets the panel progress bar in active stopped.
	 */
	public void setPanelProgressBarInActiveStopped() {
		titleQuickStatistics.setTitle(MainWindowMetadata.LABEL_STATUS_INACTIVE_INTERRUPT);
		panelScaleGridProgressBar.setBackground(Color.PINK);
		panelScaleGridProgressBar.repaint();

		progressBar.setIndeterminate(false);
		progressBar.setValue(0);
		timer.stop();
	}

	/**
	 * Sets the panel progress bar done.
	 */
	private void setPanelProgressBarDone() {
		titleQuickStatistics.setTitle(MainWindowMetadata.LABEL_STATUS_INACTIVE_DONE);
		panelScaleGridProgressBar.setBackground(CommonColors.LIGHT_GREEN);
		panelScaleGridProgressBar.repaint();

		progressBar.setIndeterminate(false);
		progressBar.setValue(100);
		timer.stop();
	}

	/**
	 * Update statistics.
	 */
	public void updateStatistics() {
		lblQuickStatistics1.setText(Long.toString(statisticsModel.getCountSearchedPages()));
		lblQuickStatistics2.setText(Long.toString(statisticsModel.getCountWrongLinks()));
		lblQuickStatistics3.setText(Long.toString(statisticsModel.getCountPagesWithSearchedPhrases()));
		panelScaleGridQuickStatistics.repaint();
	}

	/**
	 * Reset timer.
	 */
	private void resetTimer() {
		timer = getNewTimer();
	}
}
