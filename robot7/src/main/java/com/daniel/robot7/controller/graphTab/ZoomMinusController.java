/**
 * Package crawler.controller.graphTab
 *
 **/
package com.daniel.robot7.controller.graphTab;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import edu.uci.ics.jung.visualization.VisualizationViewer;
import edu.uci.ics.jung.visualization.control.ScalingControl;

/**
 * The Class ZoomMinusController.
 *
 * @author Daniel Žažo
 * @date 13. 3. 2015
 */
public class ZoomMinusController implements ActionListener {

	/** The scaling control. */
	private final ScalingControl						scalingControl;

	/** The visualization viewer. */
	private final VisualizationViewer<String, String>	visualizationViewer;

	/**
	 * Instantiates a new zoom minus controller.
	 *
	 * @param visualizationViewer
	 *            the visualization viewer
	 * @param scalingControl
	 *            the scaling control
	 */
	public ZoomMinusController(VisualizationViewer<String, String> visualizationViewer, ScalingControl scalingControl) {
		this.visualizationViewer = visualizationViewer;
		this.scalingControl = scalingControl;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		scalingControl.scale(visualizationViewer, 1 / 1.1f, visualizationViewer.getCenter());
	}

}
