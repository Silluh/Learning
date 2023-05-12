/**
 * Package crawler.gui.swing.tab.graph
 *
 **/
package robot.gui.swing.tab.graph;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;

import robot.controller.graphTab.CreateGraphFromFile;
import robot.controller.graphTab.CreateGraphInWindow;
import robot.gui.swing.MainWindow;
import robot.gui.swing.common.ui.CommonFonts;
import robot.gui.swing.metadata.tab.GraphMetadata;
import robot.gui.swing.tab.AbstractTab;

/**
 * The Class GraphTab.
 *
 * @author Daniel Žažo
 * @date 10. 3. 2015
 */
public class GraphTab extends AbstractTab {

	/** The btn create graph. */
	private JButton														btnCreateGraph;

	/** The btn open graph. */
	private JButton														btnOpenGraph;

	/** The lbl circle cyan. */
	private JLabel														lblCircleCyan;

	/** The lbl circle red. */
	private JLabel														lblCircleRed;

	/** The operating system ui. */
	private final robot.gui.swing.common.ui.AbstractOperatingSystemUI	operatingSystemUI;

	/**
	 * Instantiates a new graph tab.
	 *
	 * @param mainWindow
	 *            the main window
	 */
	public GraphTab(MainWindow mainWindow) {
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

		gbc.insets = new Insets(10, 10, 30, 10); // TOP - LEFT - BOTTOM - RIGHT
		gbc.gridwidth = 1;
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.anchor = GridBagConstraints.CENTER;
		this.panel.add(getBtnCreateGraphComponent(), gbc);

		gbc.insets = new Insets(10, 30, 30, 10); // TOP - LEFT - BOTTOM - RIGHT
		gbc.gridwidth = 1;
		gbc.gridx = 1;
		gbc.gridy = 0;
		this.panel.add(getBtnOpenGraphFromFile(), gbc);

		gbc.insets = new Insets(30, 10, 10, 0); // TOP - LEFT - BOTTOM - RIGHT
		gbc.gridwidth = 2;
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.anchor = GridBagConstraints.CENTER;
		this.panel.add(getLineWithCyan(), gbc);

		gbc.insets = new Insets(20, 10, 10, 0); // TOP - LEFT - BOTTOM - RIGHT
		gbc.gridwidth = 2;
		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.anchor = GridBagConstraints.CENTER;
		this.panel.add(getLineWithRed(), gbc);
	}

	/**
	 * Gets the line with red.
	 *
	 * @return the line with red
	 */
	private JPanel getLineWithRed() {
		final JPanel panel = new JPanel(new GridBagLayout());
		final GridBagConstraints gbc = new GridBagConstraints();

		gbc.insets = new Insets(10, 10, 10, 0); // TOP - LEFT - BOTTOM - RIGHT
		gbc.gridx = 0;
		gbc.gridy = 0;
		panel.add(getCircle(Color.RED), gbc);
		gbc.insets = new Insets(10, 10, 10, 0); // TOP - LEFT - BOTTOM - RIGHT

		gbc.gridx = 1;
		gbc.gridy = 0;
		panel.add(getJLabelRedComponent(), gbc);

		return panel;
	}

	/**
	 * Gets the line with cyan.
	 *
	 * @return the line with cyan
	 */
	private JPanel getLineWithCyan() {
		final JPanel panel = new JPanel(new GridBagLayout());
		final GridBagConstraints gbc = new GridBagConstraints();

		gbc.insets = new Insets(10, 10, 10, 0); // TOP - LEFT - BOTTOM - RIGHT
		gbc.gridx = 0;
		gbc.gridy = 0;
		panel.add(getCircle(Color.CYAN), gbc);
		gbc.insets = new Insets(10, 10, 10, 0); // TOP - LEFT - BOTTOM - RIGHT

		gbc.gridx = 1;
		gbc.gridy = 0;
		panel.add(getJLabelCyanComponent(), gbc);

		return panel;
	}

	/**
	 * Gets the btn open graph from file.
	 *
	 * @return the btn open graph from file
	 */
	private JButton getBtnOpenGraphFromFile() {
		btnOpenGraph = new JButton(GraphMetadata.LABEL_BUTTON_OPEN_GRAPH);
		btnOpenGraph.addActionListener(new CreateGraphFromFile(this.mainWindow));
		btnOpenGraph.setPreferredSize(operatingSystemUI.getDimensionButtonOpenGraphInNewWindow());
		btnOpenGraph.setFont(CommonFonts.fontSize20);
		return btnOpenGraph;
	}

	/**
	 * Gets the j label red component.
	 *
	 * @return the j label red component
	 */
	private JLabel getJLabelRedComponent() {
		lblCircleRed = new JLabel(GraphMetadata.LABEL_CRICLE_RED);
		lblCircleRed.setFont(CommonFonts.fontSize18);
		return lblCircleRed;
	}

	/**
	 * Gets the j label cyan component.
	 *
	 * @return the j label cyan component
	 */
	private JLabel getJLabelCyanComponent() {
		lblCircleCyan = new JLabel(GraphMetadata.LABEL_CRICLE_CYAN);
		lblCircleCyan.setFont(CommonFonts.fontSize18);
		return lblCircleCyan;
	}

	/**
	 * Gets the circle.
	 *
	 * @param color
	 *            the color
	 * @return the circle
	 */
	private JComponent getCircle(Color color) {
		final CircleComponent component = new CircleComponent(100, color);
		component.setSize(component.getPreferredSize());
		return component;
	}

	/**
	 * Gets the btn create graph component.
	 *
	 * @return the btn create graph component
	 */
	private JButton getBtnCreateGraphComponent() {
		btnCreateGraph = new JButton(GraphMetadata.LABEL_BUTTON_CREATE_GRAPH_IN_NEW_WINDOW);
		btnCreateGraph.addActionListener(new CreateGraphInWindow(this.mainWindow));
		btnCreateGraph.setPreferredSize(operatingSystemUI.getDimensionButtonOpenGraphInNewWindow());
		btnCreateGraph.setFont(CommonFonts.fontSize20);
		return btnCreateGraph;
	}

}
