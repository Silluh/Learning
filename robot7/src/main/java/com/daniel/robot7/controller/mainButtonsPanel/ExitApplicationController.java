/**
 * Package spider.controller.buttons
 *
 **/
package robot.controller.mainButtonsPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * The Class ExitApplicationController.
 *
 * @author Daniel Žažo
 * @date 13. 2. 2015
 */
public class ExitApplicationController implements ActionListener {

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		System.exit(0);
	}

}
