/**
 * Package crawler.gui.swing.tab
 *
 **/
package robot.gui.swing.tab.log;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;

import robot.gui.swing.MainWindow;
import robot.gui.swing.common.ui.AbstractOperatingSystemUI;
import robot.gui.swing.tab.AbstractTab;

/**
 * The Class ErrorLogTab.
 *
 * @author Daniel Žažo
 * @date 5. 3. 2015
 */
public class ErrorLogTab extends AbstractTab {

	/** The j text area. */
	private JTextArea						jTextArea;

	/** The operating system ui. */
	private final AbstractOperatingSystemUI	operatingSystemUI;

	/**
	 * Gets the j text area.
	 *
	 * @return the j text area
	 */
	public JTextArea getjTextArea() {
		return jTextArea;
	}

	/**
	 * Sets the j text area.
	 *
	 * @param jTextArea
	 *            the new j text area
	 */
	public void setjTextArea(JTextArea jTextArea) {
		this.jTextArea = jTextArea;
	}

	/**
	 * Instantiates a new error log tab.
	 *
	 * @param mainWindow
	 *            the main window
	 */
	public ErrorLogTab(MainWindow mainWindow) {
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
		this.panel.add(getJPanelJTextAreaComponent(), gbc);
	}

	/**
	 * Gets the j panel j text area component.
	 *
	 * @return the j panel j text area component
	 */
	private JPanel getJPanelJTextAreaComponent() {
		jTextArea = new JTextArea();
		jTextArea.setFont(this.operatingSystemUI.getFontTextAreaLog());

		final JPanel jPanel = new JPanel();
		final JScrollPane scrollPane = new JScrollPane(jTextArea);
		scrollPane.setPreferredSize(this.operatingSystemUI.getDimensionAreLogPanel());
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		jPanel.add(scrollPane);

		return jPanel;
	}
}
