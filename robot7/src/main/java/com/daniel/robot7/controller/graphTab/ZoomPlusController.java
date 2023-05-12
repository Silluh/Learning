/**
 * Package crawler.controller.graphTab
 *
 **/
package robot.controller.graphTab;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import edu.uci.ics.jung.visualization.VisualizationViewer;
import edu.uci.ics.jung.visualization.control.ScalingControl;

/**
 * The Class ZoomPlusController.
 *
 * @author Daniel Žažo
 * @date 13. 3. 2015
 */
public class ZoomPlusController implements ActionListener {

	/** The scaling control. */
	private final ScalingControl						scalingControl;

	/** The visualization viewer. */
	private final VisualizationViewer<String, String>	visualizationViewer;

	/**
	 * Instantiates a new zoom plus controller.
	 *
	 * @param visualizationViewer
	 *            the visualization viewer
	 * @param scalingControl
	 *            the scaling control
	 */
	public ZoomPlusController(VisualizationViewer<String, String> visualizationViewer, ScalingControl scalingControl) {
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
		scalingControl.scale(visualizationViewer, 1.1f, visualizationViewer.getCenter());
	}

}
