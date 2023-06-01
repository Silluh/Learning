/**
 * Package crawler.util.system.api
 *
 **/
package com.daniel.robot7.swing.common.ui.api;

import java.awt.Dimension;
import java.awt.Font;

/**
 * The Interface IOperatingSystemUI.
 *
 * @author Daniel Žažo
 * @date 30. 3. 2015
 */
public interface IOperatingSystemUI {

	/**
	 * Gets the dimension main window.
	 *
	 * @return the dimension main window
	 */
	Dimension getDimensionMainWindow();

	/**
	 * Gets the dimension button switch layout.
	 *
	 * @return the dimension button switch layout
	 */
	Dimension getDimensionButtonSwitchLayout();

	/**
	 * Gets the dimension are log panel.
	 *
	 * @return the dimension are log panel
	 */
	Dimension getDimensionAreLogPanel();

	/**
	 * Gets the dimension result panel.
	 *
	 * @return the dimension result panel
	 */
	Dimension getDimensionResultPanel();

	/**
	 * Gets the dimension button open graph in new window.
	 *
	 * @return the dimension button open graph in new window
	 */
	Dimension getDimensionButtonOpenGraphInNewWindow();

	/**
	 * Gets the dimension panel mouse modes.
	 *
	 * @return the dimension panel mouse modes
	 */
	Dimension getDimensionPanelMouseModes();

	/**
	 * Gets the font text area serached phrases.
	 *
	 * @return the font text area serached phrases
	 */
	Font getFontTextAreaSerachedPhrases();

	/**
	 * Gets the font text area log.
	 *
	 * @return the font text area log
	 */
	Font getFontTextAreaLog();

	/**
	 * Gets the font label statistics.
	 *
	 * @return the font label statistics
	 */
	Font getFontLabelStatistics();

}
