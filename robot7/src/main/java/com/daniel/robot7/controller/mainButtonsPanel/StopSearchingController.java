/**
 * Package spider.controller.mainButtonsPanel
 *
 **/
package com.daniel.robot7.controller.mainButtonsPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.daniel.robot7.swing.MainWindow;

/**
 * The Class StopSearchingController.
 *
 * @author Daniel Žažo
 * @date 26. 2. 2015
 */
public class StopSearchingController implements ActionListener {

	/** The main window. */
	private final MainWindow	mainWindow;

	/**
	 * Instantiates a new stop searching controller.
	 *
	 * @param mainWindow
	 *            the main window
	 */
	public StopSearchingController(MainWindow mainWindow) {
		this.mainWindow = mainWindow;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if (mainWindow.getSpiderThread() != null) {
			mainWindow.getSpiderThread().setStopThread(true);
			mainWindow.getMainButtonsPanel().getBtnStartSearching().setEnabled(false);
			mainWindow.getMainButtonsPanel().getBtnStopSearching().setEnabled(false);
			mainWindow.setStatusActiveNotFinished();
		}
	}

}
