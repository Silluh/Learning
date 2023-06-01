/**
 * Package crawler.controller.graphTab
 *
 **/
package com.daniel.robot7.controller.graphTab;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import edu.uci.ics.jung.visualization.transform.LensSupport;

/**
 * The Class ChangeCheckboxShowHyperbolController.
 *
 * @author Daniel Žažo
 * @date 16. 3. 2015
 */
public class ChangeCheckboxShowHyperbolController implements ItemListener {

	/** The hyperbolic view support. */
	private final LensSupport	hyperbolicViewSupport;

	/**
	 * Instantiates a new change checkbox show hyperbol controller.
	 *
	 * @param hyperbolicViewSupport
	 *            the hyperbolic view support
	 */
	public ChangeCheckboxShowHyperbolController(LensSupport hyperbolicViewSupport) {
		this.hyperbolicViewSupport = hyperbolicViewSupport;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.awt.event.ItemListener#itemStateChanged(java.awt.event.ItemEvent)
	 */
	@Override
	public void itemStateChanged(ItemEvent e) {
		hyperbolicViewSupport.activate(e.getStateChange() == ItemEvent.SELECTED);
	}

}
