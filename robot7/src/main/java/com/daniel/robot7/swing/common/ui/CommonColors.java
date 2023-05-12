/**
 * Package crawler.util
 *
 **/
package robot.gui.swing.common.ui;

import java.awt.Color;

import javax.swing.UIManager;

import robot.util.CommonConstants;

/**
 * The Class CommonColors.
 *
 * @author Daniel Žažo
 * @date 12. 3. 2015
 */
public class CommonColors {

	/** The light green. */
	public static Color	LIGHT_GREEN				= new Color(127, 255, 174);

	/** The light blue. */
	public static Color	LIGHT_BLUE				= new Color(153, 205, 255);

	/** The default color of panel. */
	public static Color	DEFAULT_COLOR_OF_PANEL	= UIManager.getColor(CommonConstants.PROPERTY_PANEL_BACKGROUND);

	/** The dark green. */
	public static Color	DARK_GREEN				= new Color(0, 102, 0);
}
