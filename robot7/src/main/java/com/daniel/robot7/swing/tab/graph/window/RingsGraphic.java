/**
 * Package crawler.gui.swing.tab.graph
 *
 **/
package robot.gui.swing.tab.graph.window;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Point2D;

import edu.uci.ics.jung.algorithms.layout.BalloonLayout;
import edu.uci.ics.jung.visualization.Layer;
import edu.uci.ics.jung.visualization.VisualizationServer.Paintable;
import edu.uci.ics.jung.visualization.VisualizationViewer;
import edu.uci.ics.jung.visualization.transform.MutableTransformer;
import edu.uci.ics.jung.visualization.transform.MutableTransformerDecorator;

/**
 * The Class RingsGraphic.
 *
 * @author Daniel Žažo
 * @date 11. 3. 2015
 */
public class RingsGraphic implements Paintable {

	/** The visualization viewer. */
	private final VisualizationViewer<String, String>	visualizationViewer;

	/** The balloon layout. */
	private final BalloonLayout<String, String>			balloonLayout;

	/**
	 * Instantiates a new rings graphic.
	 *
	 * @param visualizationViewer
	 *            the visualization viewer
	 * @param layout
	 *            the layout
	 */
	public RingsGraphic(VisualizationViewer<String, String> visualizationViewer, BalloonLayout<String, String> layout) {
		this.visualizationViewer = visualizationViewer;
		this.balloonLayout = layout;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.uci.ics.jung.visualization.VisualizationServer.Paintable#paint(java.awt.Graphics)
	 */
	@Override
	public void paint(Graphics graphics) {
		graphics.setColor(Color.GRAY);

		final Graphics2D graphics2D = (Graphics2D) graphics;

		final Ellipse2D ellipse = new Ellipse2D.Double();
		for (final String v : balloonLayout.getGraph().getVertices()) {
			final Double radius = balloonLayout.getRadii().get(v);
			if (radius == null) {
				continue;
			}
			final Point2D point2D = balloonLayout.transform(v);
			ellipse.setFrame(-radius, -radius, 2 * radius, 2 * radius);
			final AffineTransform at = AffineTransform.getTranslateInstance(point2D.getX(), point2D.getY());
			Shape shape = at.createTransformedShape(ellipse);

			final MutableTransformer viewTransformer = visualizationViewer.getRenderContext().getMultiLayerTransformer().getTransformer(Layer.VIEW);

			if (viewTransformer instanceof MutableTransformerDecorator) {
				shape = visualizationViewer.getRenderContext().getMultiLayerTransformer().transform(shape);
			} else {
				shape = visualizationViewer.getRenderContext().getMultiLayerTransformer().transform(Layer.LAYOUT, shape);
			}
			graphics2D.draw(shape);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.uci.ics.jung.visualization.VisualizationServer.Paintable#useTransform()
	 */
	@Override
	public boolean useTransform() {
		return true;
	}
}
