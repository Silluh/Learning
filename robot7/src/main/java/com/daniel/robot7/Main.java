/**
 * Package spider
 */
package com.daniel.robot7;

import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import robot.gui.swing.MainWindow;
import robot.gui.swing.common.MessageWindow;
import robot.gui.swing.common.ui.AbstractOperatingSystemUI;
import robot.gui.swing.common.ui.system.OtherUIComponent;
import robot.gui.swing.common.ui.system.WindowsUIComponent;
import robot.gui.swing.metadata.MainMetadata;

/**
 * The Class Main.
 *
 * @author Daniel Žažo
 * @date 7. 2. 2015
 */
public class Main {

	/**
	 * The main method.
	 *
	 * @param args
	 *            the arguments
	 */
	public static void main(final String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				final MainWindow mainWindow = new MainWindow(getDetectedOperatingSystem());
				mainWindow.initComponents();
			}
		});
	}

	/**
	 * Gets the detected operating system.
	 *
	 * @return the detected operating system
	 */
	private static AbstractOperatingSystemUI getDetectedOperatingSystem() {
		String systemLookAndFeelClassName = null;
		try {
			systemLookAndFeelClassName = UIManager.getSystemLookAndFeelClassName();
			UIManager.setLookAndFeel(systemLookAndFeelClassName);

		} catch (final UnsupportedLookAndFeelException e) {
			MessageWindow.showError(MainMetadata.ERROR_UNSUPPORTED_LOOK_AND_FEEL_EXCEPTION);
		} catch (final ClassNotFoundException e) {
			MessageWindow.showError(MainMetadata.ERROR_CLASS_NOT_FOUND_EXCEPTION);
		} catch (final InstantiationException e) {
			MessageWindow.showError(MainMetadata.ERROR_INSTANTION_EXCEPTION);
		} catch (final IllegalAccessException e) {
			MessageWindow.showError(MainMetadata.ERROR_ILLEGAL_ACCESS_EXCEPTION);
		}
		final AbstractOperatingSystemUI operatingSystem = getCurrentOperatingSystem(systemLookAndFeelClassName);
		return operatingSystem;
	}

	/**
	 * Gets the current operating system.
	 *
	 * @param systemLookAndFeelClassName
	 *            the system look and feel class name
	 * @return the current operating system
	 */
	private static AbstractOperatingSystemUI getCurrentOperatingSystem(String systemLookAndFeelClassName) {
		if (MainMetadata.OS_WINDOWS.equals(systemLookAndFeelClassName)) {
			return new WindowsUIComponent();
		}
		return new OtherUIComponent();
	}

}