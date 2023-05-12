/**
 * Package crawler.util.system.api
 *
 **/
package robot.gui.swing.common.ui.system;

import java.awt.Dimension;

import robot.gui.swing.common.ui.AbstractOperatingSystemUI;

/**
 * The Class OtherUIComponent.
 *
 * @author Daniel Žažo
 * @date 30. 3. 2015
 */
public class OtherUIComponent extends AbstractOperatingSystemUI {

	/** The dimension of main window. */
	private final Dimension	dimensionOfMainWindow			= new Dimension(900, 800);

	/** The dimension of button switch layout. */
	private final Dimension	dimensionOfButtonSwitchLayout	= new Dimension(150, 60);

	/** The dimension of area log panel. */
	private final Dimension	dimensionOfAreaLogPanel			= new Dimension(820, 440);

	/** The dimension of result panel. */
	private final Dimension	dimensionOfResultPanel			= new Dimension(815, 440);

	/** The dimension of open graph in new window. */
	private final Dimension	dimensionOfOpenGraphInNewWindow	= new Dimension(380, 50);

	/** The dimension of panel mouse modes. */
	private final Dimension	dimensionOfPanelMouseModes		= new Dimension(170, 60);

	/*
	 * (non-Javadoc)
	 * 
	 * @see robot.gui.swing.common.ui.api.IOperatingSystemUI#getDimensionAreLogPanel()
	 */
	@Override
	public Dimension getDimensionAreLogPanel() {
		return dimensionOfAreaLogPanel;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see robot.gui.swing.common.ui.api.IOperatingSystemUI#getDimensionMainWindow()
	 */
	@Override
	public Dimension getDimensionMainWindow() {
		return dimensionOfMainWindow;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see robot.gui.swing.common.ui.api.IOperatingSystemUI#getDimensionButtonSwitchLayout()
	 */
	@Override
	public Dimension getDimensionButtonSwitchLayout() {
		return this.dimensionOfButtonSwitchLayout;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see robot.gui.swing.common.ui.api.IOperatingSystemUI#getDimensionResultPanel()
	 */
	@Override
	public Dimension getDimensionResultPanel() {
		return dimensionOfResultPanel;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see robot.gui.swing.common.ui.api.IOperatingSystemUI#getDimensionButtonOpenGraphInNewWindow()
	 */
	@Override
	public Dimension getDimensionButtonOpenGraphInNewWindow() {
		return this.dimensionOfOpenGraphInNewWindow;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see robot.gui.swing.common.ui.api.IOperatingSystemUI#getDimensionPanelMouseModes()
	 */
	@Override
	public Dimension getDimensionPanelMouseModes() {
		return this.dimensionOfPanelMouseModes;
	}

}
