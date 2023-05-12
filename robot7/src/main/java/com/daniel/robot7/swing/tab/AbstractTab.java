/**
 * Package spider.gui.swing.tab
 *
 **/
package robot.gui.swing.tab;

import javax.swing.JPanel;

import robot.gui.swing.MainWindow;

/**
 * The Class AbstractTab.
 *
 * @author Daniel Žažo
 * @date 19. 2. 2015
 */
public abstract class AbstractTab {

	/** The main window. */
	protected MainWindow	mainWindow;

	/** The panel. */
	protected JPanel		panel;

	/**
	 * Gets the main window.
	 *
	 * @return the main window
	 */
	public MainWindow getMainWindow() {
		return mainWindow;
	}

	/**
	 * Sets the main window.
	 *
	 * @param mainWindow
	 *            the new main window
	 */
	public void setMainWindow(MainWindow mainWindow) {
		this.mainWindow = mainWindow;
	}

	/**
	 * Gets the panel.
	 *
	 * @return the panel
	 */
	public JPanel getPanel() {
		return panel;
	}

	/**
	 * Sets the panel.
	 *
	 * @param panel
	 *            the new panel
	 */
	public void setPanel(JPanel panel) {
		this.panel = panel;
	}

}
