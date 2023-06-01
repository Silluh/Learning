/**
 * Package crawler.util.system
 *
 **/
package com.daniel.robot7.swing.common.ui;

import java.awt.Font;

import com.daniel.robot7.swing.common.ui.api.IOperatingSystemUI;
import com.daniel.robot7.util.CommonConstants;

/**
 * The Class AbstractOperatingSystemUI.
 *
 * @author Daniel Žažo
 * @date 30. 3. 2015
 */
public abstract class AbstractOperatingSystemUI implements IOperatingSystemUI {

	/** The font text area searched phrases. */
	private final Font	fontTextAreaSearchedPhrases	= new Font(CommonConstants.FONT_BOOK_ANTIQUA, Font.ROMAN_BASELINE, 13);

	/** The font text area log. */
	private final Font	fontTextAreaLog				= fontTextAreaSearchedPhrases;

	/** The font label statistics. */
	private final Font	fontLabelStatistics			= new Font(CommonConstants.FONT_BOOK_ANTIQUA, Font.ROMAN_BASELINE, 15);

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.daniel.robot7.swing.common.ui.api.IOperatingSystemUI#getFontTextAreaSerachedPhrases()
	 */
	@Override
	public Font getFontTextAreaSerachedPhrases() {
		return fontTextAreaSearchedPhrases;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.daniel.robot7.swing.common.ui.api.IOperatingSystemUI#getFontTextAreaLog()
	 */
	@Override
	public Font getFontTextAreaLog() {
		return fontTextAreaLog;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.daniel.robot7.swing.common.ui.api.IOperatingSystemUI#getFontLabelStatistics()
	 */
	@Override
	public Font getFontLabelStatistics() {
		return fontLabelStatistics;
	}

}