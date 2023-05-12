/**
 * Package crawler.controller.mainButtonsPanel
 *
 **/
package robot.controller.mainButtonsPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;

import robot.gui.swing.MainWindow;

/**
 * The listener interface for receiving timerDefaultAction events. The class that is interested in processing a timerDefaultAction event implements this
 * interface, and the object created with that class is registered with a component using the component's <code>addTimerDefaultActionListener<code> method. When
 * the timerDefaultAction event occurs, that object's appropriate
 * method is invoked.
 *
 * @author Daniel Žažo
 * @date 7. 4. 2015
 */
public class TimerDefaultActionListener implements ActionListener {

	/** The clock tick. */
	private int				clockTick;

	/** The clock time. */
	private double			clockTime;

	/** The lbl timer. */
	private final JLabel	lblTimer;

	/**
	 * Instantiates a new timer default action listener.
	 *
	 * @param mainWindow
	 *            the main window
	 */
	public TimerDefaultActionListener(MainWindow mainWindow) {
		this.lblTimer = mainWindow.getLblTime();
		this.clockTick = 0; // initial clock setting in clock ticks
		this.clockTime = (clockTick) / 1.00;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		clockTick++;
		clockTime = (clockTick) / 100.0;
		final String clockTimeString = new Double(clockTime).toString();
		lblTimer.setText(clockTimeString);
	}

}
