/**
 * Package crawler.controller.graphTab
 *
 **/
package com.daniel.robot7.controller.graphTab;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTree;

import com.daniel.robot7.swing.MainWindow;
import com.daniel.robot7.swing.common.MessageWindow;
import com.daniel.robot7.swing.metadata.tab.GraphMetadata;
import com.daniel.robot7.swing.tab.graph.window.WindowGraphFrame;

/**
 * The Class CreateGraphInWindow.
 *
 * @author Daniel Žažo
 * @date 10. 3. 2015
 */
public class CreateGraphInWindow implements ActionListener {

	/** The main window. */
	private final MainWindow	mainWindow;

	/** The j tree urls. */
	private JTree				jTreeUrls;

	/**
	 * Instantiates a new creates the graph in window.
	 *
	 * @param mainWindow
	 *            the main window
	 */
	public CreateGraphInWindow(MainWindow mainWindow) {
		this.mainWindow = mainWindow;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		this.jTreeUrls = this.mainWindow.getResultTab().getjTreeUrls();
		if (this.jTreeUrls != null) {
			final WindowGraphFrame windowGraphFrame = new WindowGraphFrame(this.mainWindow);
			windowGraphFrame.createGraph(jTreeUrls);
		} else {
			MessageWindow.showError(GraphMetadata.MESSAGE_ERROR_SEARCHING_MISSING);
		}
	}
}
