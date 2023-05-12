/**
 * Package crawler.controller.graphTab
 *
 **/
package robot.controller.graphTab;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import robot.gui.swing.tab.graph.window.WindowGraph;
import edu.uci.ics.jung.algorithms.layout.BalloonLayout;
import edu.uci.ics.jung.algorithms.layout.TreeLayout;
import edu.uci.ics.jung.visualization.Layer;
import edu.uci.ics.jung.visualization.VisualizationServer.Paintable;
import edu.uci.ics.jung.visualization.VisualizationViewer;
import edu.uci.ics.jung.visualization.control.ScalingControl;
import edu.uci.ics.jung.visualization.layout.LayoutTransition;
import edu.uci.ics.jung.visualization.util.Animator;

/**
 * The Class ChangeLayoutController.
 *
 * @author Daniel Žažo
 * @date 13. 3. 2015
 */
public class ChangeLayoutController implements ItemListener {

	/** The tree layout. */
	private final TreeLayout<String, String>			treeLayout;

	/** The balloon layout. */
	private final BalloonLayout<String, String>			balloonLayout;

	/** The visualization viewer. */
	private final VisualizationViewer<String, String>	visualizationViewer;

	/** The rings. */
	private final Paintable								rings;

	/** The scaling control. */
	private final ScalingControl						scalingControl;

	/** The window graph. */
	private final WindowGraph							windowGraph;

	/**
	 * Instantiates a new change layout controller.
	 *
	 * @param windowGraph
	 *            the window graph
	 */
	public ChangeLayoutController(WindowGraph windowGraph) {
		this.windowGraph = windowGraph;
		this.treeLayout = windowGraph.getTreeLayout();
		this.balloonLayout = windowGraph.getBalloonLayout();
		this.visualizationViewer = windowGraph.getVisualizationViewer();
		this.rings = windowGraph.getRings();
		this.scalingControl = windowGraph.getScalingControl();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.awt.event.ItemListener#itemStateChanged(java.awt.event.ItemEvent)
	 */
	@Override
	public void itemStateChanged(ItemEvent e) {
		// Not possible minimaze - it must be both branch filled and instanced
		if (e.getStateChange() == ItemEvent.SELECTED) {
			final LayoutTransition<String, String> layoutTransition = new LayoutTransition<String, String>(visualizationViewer, treeLayout, balloonLayout);
			final Animator animator = new Animator(layoutTransition);
			animator.start();
			visualizationViewer.getRenderContext().getMultiLayerTransformer().getTransformer(Layer.LAYOUT).setToIdentity();
			visualizationViewer.addPreRenderPaintable(rings);
			windowGraph.setActiveBalloonLayout();
		} else {
			final LayoutTransition<String, String> layoutTransition = new LayoutTransition<String, String>(visualizationViewer, balloonLayout, treeLayout);
			final Animator animator = new Animator(layoutTransition);
			animator.start();
			visualizationViewer.getRenderContext().getMultiLayerTransformer().getTransformer(Layer.LAYOUT).setToIdentity();
			visualizationViewer.removePreRenderPaintable(rings);
			windowGraph.setActiveTreeLayout();
		}

		// Always stay the same size of graphs - nearly version (1 / 1.1f)
		scalingControl.scale(visualizationViewer, 1 / 1.0f, visualizationViewer.getCenter());
		visualizationViewer.repaint();
	}

}
