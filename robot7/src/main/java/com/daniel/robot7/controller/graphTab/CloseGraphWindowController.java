/**
 * Package crawler.controller.graphTab
 *
 **/
package com.daniel.robot7.controller.graphTab;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

import com.daniel.robot7.swing.tab.graph.window.WindowGraphFrame;

/**
 * The Class CloseGraphWindowController.
 *
 * @author Daniel Žažo
 * @date 16. 3. 2015
 */
public class CloseGraphWindowController implements ActionListener {

	/** The window graph frame. */
	private final WindowGraphFrame	windowGraphFrame;

	/**
	 * Instantiates a new close graph window controller.
	 *
	 * @param windowGraphFrame
	 *            the window graph frame
	 */
	public CloseGraphWindowController(WindowGraphFrame windowGraphFrame) {
		this.windowGraphFrame = windowGraphFrame;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		windowGraphFrame.dispatchEvent(new WindowEvent(windowGraphFrame, WindowEvent.WINDOW_CLOSING));
	}

}
