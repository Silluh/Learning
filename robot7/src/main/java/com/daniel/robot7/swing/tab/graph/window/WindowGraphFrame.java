/**
 * Package crawler.gui.swing.tab.graph
 *
 **/
package com.daniel.robot7.swing.tab.graph.window;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JTree;

import com.daniel.robot7.swing.MainWindow;
import com.daniel.robot7.swing.metadata.tab.GraphMetadata;

/**
 * The Class WindowGraphFrame.
 *
 * @author Daniel Žažo
 * @date 11. 3. 2015
 */
public class WindowGraphFrame extends JFrame {

	/** The main window. */
	private final MainWindow	mainWindow;

	/**
	 * Gets the main window.
	 *
	 * @return the main window
	 */
	public MainWindow getMainWindow() {
		return mainWindow;
	}

	/** serialVersionUID. */
	private static final long	serialVersionUID	= 1L;

	/**
	 * Instantiates a new window graph frame.
	 *
	 * @param mainWindow
	 *            the main window
	 */
	public WindowGraphFrame(MainWindow mainWindow) {
		super(GraphMetadata.LABEL_WINDOW_NAME);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		pack();
		setLocationRelativeTo(null);
		setSize(getPercentDimension(80));
		setVisible(true);
		setPositionWindow();
		this.mainWindow = mainWindow;
	}

	/**
	 * Set position to middle of monitor.
	 */
	public void setPositionWindow() {
		final Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
		final int x = (int) ((dimension.getWidth() - this.getWidth()) / 2);
		final int y = (int) ((dimension.getHeight() - this.getHeight()) / 2);
		this.setLocation(x, y);
	}

	/**
	 * Gets the percent dimension.
	 *
	 * @param percent
	 *            the percent
	 * @return the percent dimension
	 */
	public Dimension getPercentDimension(int percent) {
		final Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		final double newWidth = screenSize.getWidth() / 100 * percent;
		final double newHeight = screenSize.getHeight() / 100 * percent;
		return new Dimension((int) newWidth, (int) newHeight);
	}

	/**
	 * Adding graph to JFrame and creating all graphs.
	 *
	 * @param jTreeUrls
	 *            the j tree urls
	 */
	public void createGraph(JTree jTreeUrls) {
		this.add(new WindowGraph(this, jTreeUrls));
	}

}
