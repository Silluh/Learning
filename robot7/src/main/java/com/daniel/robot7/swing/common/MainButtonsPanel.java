/**
 * Package spider.gui.swing
 *
 **/
package com.daniel.robot7.swing.common;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JPanel;

import com.daniel.robot7.controller.mainButtonsPanel.ExitApplicationController;
import com.daniel.robot7.controller.mainButtonsPanel.StartSearchingController;
import com.daniel.robot7.controller.mainButtonsPanel.StopSearchingController;
import com.daniel.robot7.swing.MainWindow;
import com.daniel.robot7.swing.common.ui.CommonFonts;
import com.daniel.robot7.swing.metadata.common.MainButtonsMetadata;

/**
 * The Class MainButtonsPanel.
 *
 * @author Daniel Žažo
 * @date 13. 2. 2015
 */
public class MainButtonsPanel {

	/** The main window. */
	private final MainWindow	mainWindow;

	/** The main buttons panel. */
	private JPanel				mainButtonsPanel;

	/** The btn start searching. */
	private JButton				btnStartSearching;

	/** The btn stop searching. */
	private JButton				btnStopSearching;

	/** The btn exit application. */
	private JButton				btnExitApplication;

	/** The dime of buttons. */
	private Dimension			dimeOfButtons;

	/**
	 * Gets the main buttons panel.
	 *
	 * @return the main buttons panel
	 */
	public JPanel getMainButtonsPanel() {
		return mainButtonsPanel;
	}

	/**
	 * Sets the main buttons panel.
	 *
	 * @param mainButtonsPanel
	 *            the new main buttons panel
	 */
	public void setMainButtonsPanel(JPanel mainButtonsPanel) {
		this.mainButtonsPanel = mainButtonsPanel;
	}

	/**
	 * Gets the btn start searching.
	 *
	 * @return the btn start searching
	 */
	public JButton getBtnStartSearching() {
		return btnStartSearching;
	}

	/**
	 * Sets the btn start searching.
	 *
	 * @param btnStartSearching
	 *            the new btn start searching
	 */
	public void setBtnStartSearching(JButton btnStartSearching) {
		this.btnStartSearching = btnStartSearching;
	}

	/**
	 * Gets the btn stop searching.
	 *
	 * @return the btn stop searching
	 */
	public JButton getBtnStopSearching() {
		return btnStopSearching;
	}

	/**
	 * Sets the btn stop searching.
	 *
	 * @param btnStopSearching
	 *            the new btn stop searching
	 */
	public void setBtnStopSearching(JButton btnStopSearching) {
		this.btnStopSearching = btnStopSearching;
	}

	/**
	 * Gets the btn exit application.
	 *
	 * @return the btn exit application
	 */
	public JButton getBtnExitApplication() {
		return btnExitApplication;
	}

	/**
	 * Sets the btn exit application.
	 *
	 * @param btnExitApplication
	 *            the new btn exit application
	 */
	public void setBtnExitApplication(JButton btnExitApplication) {
		this.btnExitApplication = btnExitApplication;
	}

	/**
	 * Instantiates a new main buttons panel.
	 *
	 * @param mainWindow
	 *            the main window
	 */
	public MainButtonsPanel(MainWindow mainWindow) {
		this.mainWindow = mainWindow;
		initComponents();
	}

	/**
	 * Inits the components.
	 */
	private void initComponents() {
		dimeOfButtons = new Dimension(200, 50);

		mainButtonsPanel = new JPanel(new GridBagLayout());
		final GridBagConstraints gbc = new GridBagConstraints();

		gbc.insets = new Insets(10, 20, 10, 20); // TOP - LEFT - BOTTOM - RIGHT
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.anchor = GridBagConstraints.LINE_START;
		mainButtonsPanel.add(getStartButtonComponent(), gbc);

		gbc.gridx = 1;
		gbc.gridy = 0;
		mainButtonsPanel.add(getStopButtonComponent(), gbc);

		gbc.gridx = 2;
		gbc.gridy = 0;
		mainButtonsPanel.add(getExitApplicationButtonComponent(), gbc);
	}

	/**
	 * Gets the exit application button component.
	 *
	 * @return the exit application button component
	 */
	private JButton getExitApplicationButtonComponent() {
		btnExitApplication = new JButton(MainButtonsMetadata.LABEL_BUTTON_EXIT_APPLICATION);
		btnExitApplication.setPreferredSize(dimeOfButtons);
		btnExitApplication.setFont(CommonFonts.fontSize20);
		btnExitApplication.addActionListener(new ExitApplicationController());
		return btnExitApplication;
	}

	/**
	 * Gets the stop button component.
	 *
	 * @return the stop button component
	 */
	private JButton getStopButtonComponent() {
		btnStopSearching = new JButton(MainButtonsMetadata.LABEL_BUTTON_STOP_SEARCHING);
		btnStopSearching.setPreferredSize(dimeOfButtons);
		btnStopSearching.setFont(CommonFonts.fontSize20);
		btnStopSearching.addActionListener(new StopSearchingController(mainWindow));
		btnStopSearching.setEnabled(false);

		return btnStopSearching;
	}

	/**
	 * Gets the start button component.
	 *
	 * @return the start button component
	 */
	private JButton getStartButtonComponent() {
		btnStartSearching = new JButton(MainButtonsMetadata.LABEL_BUTTON_START_SEARCHING);
		btnStartSearching.setPreferredSize(dimeOfButtons);
		btnStartSearching.setFont(CommonFonts.fontSize20);
		btnStartSearching.addActionListener(new StartSearchingController(mainWindow));
		return btnStartSearching;
	}
}
