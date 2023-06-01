/**
 * Package spider.controller.resultTab
 *
 **/
package com.daniel.robot7.controller.resultTab;

import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;

/**
 * The Class AdjustmentListenerVerticalUpdate.
 *
 * @author Daniel Žažo
 * @date 2. 3. 2015
 */
public class AdjustmentListenerVerticalUpdate implements AdjustmentListener {

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.awt.event.AdjustmentListener#adjustmentValueChanged(java.awt.event.AdjustmentEvent)
	 */
	@Override
	public void adjustmentValueChanged(AdjustmentEvent e) {
		e.getAdjustable().setValue(e.getAdjustable().getMaximum());
	}

}
