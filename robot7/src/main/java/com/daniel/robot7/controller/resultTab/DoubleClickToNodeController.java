/**
 * Package spider.controller.resultTab
 *
 **/
package robot.controller.resultTab;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.Serializable;

import javax.swing.tree.TreePath;

import robot.controller.AbstractDataController;
import robot.gui.swing.tab.result.ResultTreeTab;

/**
 * The Class DoubleClickToNodeController.
 *
 * @author Daniel Žažo
 * @date 1. 3. 2015
 */
public class DoubleClickToNodeController extends AbstractDataController implements MouseListener, Serializable {

	/** serialVersionUID. */
	private static final long	serialVersionUID	= -7573990921857188845L;

	/** The result tab. */
	private ResultTreeTab		resultTab;

	/**
	 * Instantiates a new double click to node controller.
	 */
	public DoubleClickToNodeController() {
	}

	/**
	 * Instantiates a new double click to node controller.
	 *
	 * @param resultTab
	 *            the result tab
	 */
	public DoubleClickToNodeController(ResultTreeTab resultTab) {
		this.resultTab = resultTab;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.awt.event.MouseListener#mousePressed(java.awt.event.MouseEvent)
	 */
	@Override
	public void mousePressed(MouseEvent e) {
		final int selRow = resultTab.getjTreeUrls().getRowForLocation(e.getX(), e.getY());
		final TreePath selPath = resultTab.getjTreeUrls().getPathForLocation(e.getX(), e.getY());
		if (selRow != -1) {
			if (e.getClickCount() == 1) {
			} else if (e.getClickCount() == 2) {
				openWebPage(selPath.getLastPathComponent().toString());
			}
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.awt.event.MouseListener#mouseClicked(java.awt.event.MouseEvent)
	 */
	@Override
	public void mouseClicked(MouseEvent e) {
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.awt.event.MouseListener#mouseReleased(java.awt.event.MouseEvent)
	 */
	@Override
	public void mouseReleased(MouseEvent e) {
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.awt.event.MouseListener#mouseEntered(java.awt.event.MouseEvent)
	 */
	@Override
	public void mouseEntered(MouseEvent e) {
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.awt.event.MouseListener#mouseExited(java.awt.event.MouseEvent)
	 */
	@Override
	public void mouseExited(MouseEvent e) {
	}

}
