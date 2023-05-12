/**
 * Package crawler.gui.swing.metadata
 *
 **/
package robot.gui.swing.metadata;

/**
 * The Class MainMetadata.
 *
 * @author Daniel Žažo
 * @date 30. 3. 2015
 */
public class MainMetadata {

	/** The Constant OS_WINDOWS. */
	public static final String	OS_WINDOWS									= "com.sun.java.swing.plaf.windows.WindowsLookAndFeel";

	/** The Constant ERROR_DETECT_OS. */
	public static final String	ERROR_DETECT_OS								= "ERROR in detecting current operating system: ";

	/** The Constant ERROR_UNSUPPORTED_LOOK_AND_FEEL_EXCEPTION. */
	public static final String	ERROR_UNSUPPORTED_LOOK_AND_FEEL_EXCEPTION	= ERROR_DETECT_OS + "unsupported look and feel exception";

	/** The Constant ERROR_CLASS_NOT_FOUND_EXCEPTION. */
	public static final String	ERROR_CLASS_NOT_FOUND_EXCEPTION				= ERROR_DETECT_OS + "class not found exception";

	/** The Constant ERROR_INSTANTION_EXCEPTION. */
	public static final String	ERROR_INSTANTION_EXCEPTION					= ERROR_DETECT_OS + "instantion exception.";

	/** The Constant ERROR_ILLEGAL_ACCESS_EXCEPTION. */
	public static final String	ERROR_ILLEGAL_ACCESS_EXCEPTION				= ERROR_DETECT_OS + "illegal access exception.";
}
