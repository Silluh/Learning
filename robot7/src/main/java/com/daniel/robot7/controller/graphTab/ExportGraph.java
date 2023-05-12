/**
 * Package crawler.controller.graphTab
 *
 **/
package robot.controller.graphTab;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.XMLEncoder;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

import robot.gui.swing.common.MessageWindow;
import robot.gui.swing.metadata.tab.GraphMetadata;
import robot.gui.swing.tab.graph.window.WindowGraph;
import robot.util.CommonConstants;

/**
 * The Class ExportGraph.
 *
 * @author Daniel Žažo
 * @param <V>
 *            the value type
 * @param <E>
 *            the element type
 * @date 14. 4. 2015
 */
public class ExportGraph<V, E> implements ActionListener {

	/** The window graph. */
	private final WindowGraph	windowGraph;

	/** The filename. */
	private String				filename;

	/**
	 * Instantiates a new export graph.
	 *
	 * @param windowGraph
	 *            the window graph
	 */
	public ExportGraph(WindowGraph windowGraph) {
		this.windowGraph = windowGraph;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent ee) {
		if (areSettedValues()) {
			saveFile();
		}
	}

	/**
	 * Save file.
	 */
	private void saveFile() {
		try {
			final XMLEncoder encoder = new XMLEncoder(new BufferedOutputStream(new FileOutputStream(filename + CommonConstants.XML_EXTENSION_DOT)));
			encoder.writeObject(windowGraph.getjTreeUrls());
			encoder.close();
			MessageWindow.showInfo(GraphMetadata.MESSAGE_INFO_SAVED_FILE);
		} catch (final IOException i) {
			MessageWindow.showError(GraphMetadata.MESSAGE_ERROR_IN_CREATING_NEW_FILE);
		}
	}

	/**
	 * Are setted values.
	 *
	 * @return true, if successful
	 */
	private boolean areSettedValues() {
		final JFileChooser fileChooser = new JFileChooser();
		fileChooser.setDialogTitle(GraphMetadata.LABEL_SPECIFY_FILE_TO_SAVE);
		final FileNameExtensionFilter xmlfilter = new FileNameExtensionFilter(GraphMetadata.LABEL_XML_FILTER, CommonConstants.XML_EXTENSION);
		fileChooser.setFileFilter(xmlfilter);

		final int chooserValue = fileChooser.showSaveDialog(this.windowGraph);
		if (chooserValue == JFileChooser.APPROVE_OPTION) {
			this.filename = fileChooser.getSelectedFile().toString();
			return true;
		}
		return false;
	}
}