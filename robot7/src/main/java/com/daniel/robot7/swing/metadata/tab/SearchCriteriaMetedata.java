/**
 * Package spider.gui.swing.tab.metadata
 *
 **/
package robot.gui.swing.metadata.tab;

/**
 * The Class SearchCriteriaMetedata.
 *
 * @author Daniel Žažo
 * @date 9. 2. 2015
 */
public class SearchCriteriaMetedata {

	// Labels
	/** The Constant TAB_SETTINGS. */
	public static final String		TAB_SETTINGS										= "Search criteria";

	/** The Constant LABEL_DEFAULT_URL. */
	public static final String		LABEL_DEFAULT_URL									= "*Default url:";

	/** The Constant LABEL_SEARCHED_DOMAINS. */
	public static final String		LABEL_SEARCHED_DOMAINS								= "*Searched domains:";

	/** The Constant LABEL_MAXIMUM_DEPTH. */
	public static final String		LABEL_MAXIMUM_DEPTH									= "*Maximum depth:";

	/** The Constant LABEL_MAXIMUM_VISITED_PAGES. */
	public static final String		LABEL_MAXIMUM_VISITED_PAGES							= "*Maximum visited pages:";

	/** The Constant LABEL_SEARCHED_WORDS. */
	public static final String		LABEL_SEARCHED_WORDS								= "<html>Searched words:<br><br>(Separator = new line)<br><br>(Searching is NOT case sensitive)</html>";

	/** The Constant LABEL_OTHER_MAX_DEPTH. */
	public static final String		LABEL_OTHER_MAX_DEPTH								= "Other maximum depth:";

	/** The Constant LABEL_OTHER_MAX_PAGES. */
	public static final String		LABEL_OTHER_MAX_PAGES								= "Other maximum visited pages:";

	/** The Constant LABEL_REQUIRED_ITEMS. */
	public static final String		LABEL_REQUIRED_ITEMS								= "Required items:";

	/** The Constant LABEL_SEARCH_ONLY_ON_DEFAULT_HOST. */
	public static final String		LABEL_SEARCH_ONLY_ON_DEFAULT_HOST					= "Search only on default host?";

	/** The Constant LABEL_SEARCH_SET_TIMEOUT_IN_SEARCHING. */
	public static final String		LABEL_SEARCH_SET_TIMEOUT_IN_SEARCHING				= "Set timeout for search?  (ms)";

	// Path to property file
	/** The Constant FILE_PATH_MAXIMUM_DEPTH. */
	public static final String		FILE_PATH_MAXIMUM_DEPTH								= "properties/maximumDepth.txt";

	/** The Constant FILE_PATH_MAXIMUM_PAGES. */
	public static final String		FILE_PATH_MAXIMUM_PAGES								= "properties/maximumPages.txt";

	/** The Constant FILE_PATH_DOMAINS. */
	public static final String		FILE_PATH_DOMAINS									= "properties/domains.txt";

	// Error messages in code
	/** The Constant ERROR_WRONG_ENCODING. */
	public static final String		ERROR_WRONG_ENCODING								= "File must be coded in UTF-8.";

	/** The Constant ERROR_LOAD_VALUES. */
	public static final String		ERROR_LOAD_VALUES									= "Problem in loading properties.";

	// Error/Info messages in actions (Mostly for MessagesWindow) - NEW DOMAIN
	/** The Constant ERROR_URL_IS_NOT_VALID. */
	public static final String		ERROR_URL_IS_NOT_VALID								= "Url is not valid!";

	/** The Constant ERROR_URL_CANT_BE_EMPTY. */
	public static final String		ERROR_URL_CANT_BE_EMPTY								= "Url can't be empty!";

	/** The Constant INFO_URL_IS_OK. */
	public static final String		INFO_URL_IS_OK										= "Url is OK!";

	// Error messages in actions (Mostly for MessagesWindow) - NEW DOMAIN
	/** The Constant ERROR_NEW_DOMAIN_CANT_BE_EMPTY. */
	public static final String		ERROR_NEW_DOMAIN_CANT_BE_EMPTY						= "New domain can't be empty!";

	/** The Constant ERROR_NEW_DOMAIN_MUST_START_BY_DOT. */
	public static final String		ERROR_NEW_DOMAIN_MUST_START_BY_DOT					= "New domain must start by dot (.)!";

	/** The Constant ERROR_NEW_DOMAIN_MUST_BE_BIGGER_THAN_1_LETTERS. */
	public static final String		ERROR_NEW_DOMAIN_MUST_BE_BIGGER_THAN_1_LETTERS		= "New domain must be bigger than 1 letters!";

	/** The Constant ERROR_NEW_DOMAIN_CANT_EXISTS. */
	public static final String		ERROR_NEW_DOMAIN_CANT_EXISTS						= "New domain can't exists!";

	// Error messages in actions (Mostly for MessagesWindow) - NEW MAXIMUM NUMBES
	/** The Constant ERROR_NEW_VALUE_MUST_BE_WHOLE_AND_POSITIVE_INTEGER. */
	public static final String		ERROR_NEW_VALUE_MUST_BE_WHOLE_AND_POSITIVE_INTEGER	= "New value must be whole and positive integer!";

	// ERROR IN FILES
	/** The Constant ERROR_IN_FILE_MAXIMUM_DEPTH_TXT. */
	public static final String		ERROR_IN_FILE_MAXIMUM_DEPTH_TXT						= "Probably you have wrong value in file maximumDepth.txt! For correct work you shoudl fix it.";

	/** The Constant ERROR_IN_FILE_MAXIMUM_VISITED_PAGES_TXT. */
	public static final String		ERROR_IN_FILE_MAXIMUM_VISITED_PAGES_TXT				= "Probably you have wrong value in file maximumPages.txt! For correct work you shoudl fix it.";

	// Buttons
	/** The Constant BUTTON_ADD_NEW_DOMAIN. */
	public static final String		BUTTON_ADD_NEW_DOMAIN								= "Add new domain";

	/** The Constant BUTTON_VALIDATE_URL. */
	public static final String		BUTTON_VALIDATE_URL									= "Validate url";

	/** The Constant WWW_SITES. */
	public static final String[]	WWW_SITES											= { "google.com", "amazon.com", "seznam.cz", "centrum.cz",
			"youtube.com", "twitter.com"												};

}
