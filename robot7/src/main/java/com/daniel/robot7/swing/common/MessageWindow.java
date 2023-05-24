/**
 * Package spider.gui.swing.common
 *
 **/
package com.daniel.robot7.swing.common;

import javax.swing.JOptionPane;

import com.daniel.robot7.swing.MainWindow;

/**
 * The Class MessageWindow.
 */
public class MessageWindow {

	/** The main window. */
	private static MainWindow	mainWindow	= null;

	/**
	 * Instantiates a new message window.
	 *
	 * @param mainWindow
	 *            the main window
	 */
	@SuppressWarnings("static-access")
	public MessageWindow(MainWindow mainWindow) {
		this.mainWindow = mainWindow;
	}

	/**
	 * Show.
	 *
	 * @param message
	 *            the message
	 */
	public static void showError(String message) {
		JOptionPane.showMessageDialog(mainWindow, message, null, JOptionPane.ERROR_MESSAGE);
	}

	/**
	 * Show info.
	 *
	 * @param message
	 *            the message
	 */
	public static void showInfo(String message) {
		JOptionPane.showMessageDialog(mainWindow, message);
	}
}
