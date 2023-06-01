/**
 * Package spider.gui.swing.tab
 *
 **/
package com.daniel.robot7.swing.tab.result;

import java.awt.FlowLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.ScrollPaneConstants;

import com.daniel.robot7.controller.resultTab.DoubleClickToNodeController;
import com.daniel.robot7.swing.MainWindow;
import com.daniel.robot7.swing.common.ui.AbstractOperatingSystemUI;
import com.daniel.robot7.swing.metadata.tab.ResultMetadata;
import com.daniel.robot7.swing.tab.AbstractTab;

/**
 * The Class ResultTreeTab.
 *
 * @author Daniel Žažo
 * @date 9. 2. 2015
 */
public class ResultTreeTab extends AbstractTab {

	/** The lbl first info. */
	private JLabel							lblFirstInfo;

	/** The j tree urls. */
	private JTree							jTreeUrls;

	/** The operating system ui. */
	private final AbstractOperatingSystemUI	operatingSystemUI;

	/**
	 * Gets the j tree urls.
	 *
	 * @return the j tree urls
	 */
	public JTree getjTreeUrls() {
		return jTreeUrls;
	}

	/**
	 * Sets the j tree urls.
	 *
	 * @param jTreeUrls
	 *            the new j tree urls
	 */
	public void setjTreeUrls(JTree jTreeUrls) {
		this.jTreeUrls = jTreeUrls;
	}

	/**
	 * Instantiates a new result tree tab.
	 *
	 * @param mainWindow
	 *            the main window
	 */
	public ResultTreeTab(MainWindow mainWindow) {
		this.mainWindow = mainWindow;
		this.operatingSystemUI = this.mainWindow.getOperatingSystemUI();
		initComponents();
	}

	/**
	 * Inits the components.
	 */
	private void initComponents() {
		panel = new JPanel();
		panel.setLayout(new FlowLayout(FlowLayout.LEFT));
		lblFirstInfo = new JLabel(ResultMetadata.LABEL_FILL_SERACH_CRITERIA_AND_START_SEARCH);
		panel.add(lblFirstInfo);
	}

	/**
	 * Creates the tree.
	 */
	public void createTree() {
		panel.remove(lblFirstInfo);
		panel.updateUI();
		jTreeUrls = new JTree();
		jTreeUrls.addMouseListener(new DoubleClickToNodeController(this));

		final JPanel jPanel = new JPanel();
		final JScrollPane scrollPane = new JScrollPane(jTreeUrls);

		scrollPane.setPreferredSize(operatingSystemUI.getDimensionResultPanel());
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		jPanel.add(scrollPane);

		panel.add(jPanel);
	}
}
