/**
 * Package crawler.controller.graphTab
 *
 **/
package com.daniel.robot7.controller.graphTab;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.XMLDecoder;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javax.swing.JFileChooser;
import javax.swing.JTree;
import javax.swing.filechooser.FileNameExtensionFilter;

import com.daniel.robot7.swing.MainWindow;
import com.daniel.robot7.swing.common.MessageWindow;
import com.daniel.robot7.swing.metadata.tab.GraphMetadata;
import com.daniel.robot7.swing.tab.graph.window.WindowGraphFrame;
import com.daniel.robot7.util.CommonConstants;

/**
 * The Class CreateGraphFromFile.
 *
 * @author Daniel Žažo
 * @date 14. 4. 2015
 */
public class CreateGraphFromFile implements ActionListener {

	/** The main window. */
	private final MainWindow	mainWindow;

	/** The j tree urls. */
	private JTree				jTreeUrls;

	/** The file path. */
	private String				filePath;

	/**
	 * Instantiates a new creates the graph from file.
	 *
	 * @param mainWindow
	 *            the main window
	 */
	public CreateGraphFromFile(MainWindow mainWindow) {
		this.mainWindow = mainWindow;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if (isSelectedFile()) {
			if (isFileOpened()) {
				loadGraph();
			}
		}
	}

	/**
	 * Load graph.
	 */
	private void loadGraph() {
		final WindowGraphFrame windowGraphFrame = new WindowGraphFrame(this.mainWindow);
		windowGraphFrame.createGraph(jTreeUrls);
	}

	/**
	 * Checks if is file opened.
	 *
	 * @return true, if is file opened
	 */
	private boolean isFileOpened() {
		XMLDecoder decoder;
		try {
			decoder = new XMLDecoder(new BufferedInputStream(new FileInputStream(filePath)));
			this.jTreeUrls = (JTree) decoder.readObject();
			decoder.close();
			return true;
		} catch (final FileNotFoundException e) {
			MessageWindow.showError(GraphMetadata.MESSAGE_ERROR_FILE_NOT_FOUND);
			return false;
		}
	}

	/**
	 * Checks if is selected file.
	 *
	 * @return true, if is selected file
	 */
	private boolean isSelectedFile() {
		final JFileChooser fileChooser = new JFileChooser();
		fileChooser.setDialogTitle(GraphMetadata.LABEL_SPECIFY_FILE_TO_SAVE);
		final FileNameExtensionFilter xmlfilter = new FileNameExtensionFilter(GraphMetadata.LABEL_XML_FILTER, CommonConstants.XML_EXTENSION);
		fileChooser.setFileFilter(xmlfilter);

		final int chooserValue = fileChooser.showOpenDialog(this.mainWindow);
		if (chooserValue == JFileChooser.APPROVE_OPTION) {
			this.filePath = fileChooser.getSelectedFile().toString();
			return true;
		}
		return false;
	}

}
