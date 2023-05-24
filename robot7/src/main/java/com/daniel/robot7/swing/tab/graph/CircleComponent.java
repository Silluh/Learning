/**
 * Package crawler.gui.swing.tab.graph.window
 *
 **/
package com.daniel.robot7.swing.tab.graph;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Ellipse2D;

import javax.swing.JComponent;

/**
 * The Class CircleComponent.
 *
 * @author Daniel Žažo
 * @date 24. 3. 2015
 */
public class CircleComponent extends JComponent {

	/** serialVersionUID. */
	private static final long		serialVersionUID	= 8586299001616878952L;

	/** The circle. */
	private final Ellipse2D.Double	circle;

	/** The color. */
	private final Color				color;

	/**
	 * Instantiates a new circle component.
	 *
	 * @param radius
	 *            the radius
	 * @param color
	 *            the color
	 */
	public CircleComponent(int radius, Color color) {
		this.circle = new Ellipse2D.Double(0, 0, radius, radius);
		this.color = color;
		setOpaque(false);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.swing.JComponent#getPreferredSize()
	 */
	@Override
	public Dimension getPreferredSize() {
		final Rectangle bounds = circle.getBounds();
		return new Dimension(bounds.width, bounds.height);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.swing.JComponent#paintComponent(java.awt.Graphics)
	 */
	@Override
	public void paintComponent(Graphics graphics) {
		super.paintComponent(graphics);
		final Graphics2D graphics2D = (Graphics2D) graphics;
		graphics2D.setColor(this.color);
		graphics2D.fill(circle);

	}
}
