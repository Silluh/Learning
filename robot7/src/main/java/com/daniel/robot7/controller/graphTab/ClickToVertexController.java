/**
 * Package crawler.controller.graphTab
 *
 **/
package com.daniel.robot7.controller.graphTab;

import java.awt.event.MouseEvent;

import com.daniel.robot7.controller.AbstractDataController;
import edu.uci.ics.jung.visualization.control.GraphMouseListener;

/**
 * The Class ClickToVertexController.
 *
 * @author Daniel Žažo
 * @date 29. 3. 2015
 */
public class ClickToVertexController extends AbstractDataController implements GraphMouseListener<String> {

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.uci.ics.jung.visualization.control.GraphMouseListener#graphClicked(java.lang.Object, java.awt.event.MouseEvent)
	 */
	@Override
	public void graphClicked(String urlOfNode, MouseEvent mouseEvent) {
		if (mouseEvent.getButton() == MouseEvent.BUTTON1 && mouseEvent.getClickCount() == 2) {
			openWebPage(urlOfNode);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.uci.ics.jung.visualization.control.GraphMouseListener#graphPressed(java.lang.Object, java.awt.event.MouseEvent)
	 */
	@Override
	public void graphPressed(String arg0, MouseEvent arg1) {
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.uci.ics.jung.visualization.control.GraphMouseListener#graphReleased(java.lang.Object, java.awt.event.MouseEvent)
	 */
	@Override
	public void graphReleased(String arg0, MouseEvent arg1) {
	}

}
