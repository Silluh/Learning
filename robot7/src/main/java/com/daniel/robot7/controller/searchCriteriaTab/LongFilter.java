/**
 * Package spider.controller.common
 *
 **/
package robot.controller.searchCriteriaTab;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.DocumentFilter;

import robot.gui.swing.common.MessageWindow;
import robot.gui.swing.metadata.tab.SearchCriteriaMetedata;
import robot.util.CommonConstants;

/**
 * The Class LongFilter.
 *
 * @author Daniel Žažo
 * @date 12. 2. 2015
 */
public class LongFilter extends DocumentFilter {

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.swing.text.DocumentFilter#insertString(javax.swing.text.DocumentFilter.FilterBypass, int, java.lang.String, javax.swing.text.AttributeSet)
	 */
	@Override
	public void insertString(FilterBypass fb, int offset, String string, AttributeSet attr) throws BadLocationException {
		final Document document = fb.getDocument();
		final StringBuilder sb = new StringBuilder();
		sb.append(document.getText(0, document.getLength()));
		sb.insert(offset, string);

		if (test(sb.toString(), false)) {
			super.insertString(fb, offset, string, attr);
		} else {
			showError();
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.swing.text.DocumentFilter#replace(javax.swing.text.DocumentFilter.FilterBypass, int, int, java.lang.String, javax.swing.text.AttributeSet)
	 */
	@Override
	public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
		final Document document = fb.getDocument();
		final StringBuilder sb = new StringBuilder();
		sb.append(document.getText(0, document.getLength()));
		sb.replace(offset, offset + length, text);

		if (test(sb.toString(), false)) {
			super.replace(fb, offset, length, text, attrs);
		} else {
			showError();
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.swing.text.DocumentFilter#remove(javax.swing.text.DocumentFilter.FilterBypass, int, int)
	 */
	@Override
	public void remove(FilterBypass fb, int offset, int length) throws BadLocationException {
		final Document document = fb.getDocument();
		final StringBuilder sb = new StringBuilder();
		sb.append(document.getText(0, document.getLength()));
		sb.delete(offset, offset + length);

		if (test(sb.toString(), true)) {
			super.remove(fb, offset, length);
		} else {
			showError();
		}
	}

	/**
	 * Test.
	 *
	 * @param text
	 *            the text
	 * @param remove
	 *            - allows remove also one last number and allows have empty textfield
	 * @return true, if successful
	 */
	private boolean test(String text, boolean remove) {
		if (!remove || text.length() != 0) {
			try {
				// if (text.charAt(0) == CommonConstants.OPERATOR_PLUS || Integer.parseInt(text) < 1) { // Remove "-" from beginning
				if (text.charAt(0) == CommonConstants.OPERATOR_PLUS.charAt(0) || Long.parseLong(text) < 1) { // Remove "-" from beginning
					return false;
				}
			} catch (final NumberFormatException e) {
				return false;
			}
		}
		return true;
	}

	/**
	 * Show error.
	 */
	private void showError() {
		MessageWindow.showError(SearchCriteriaMetedata.ERROR_NEW_VALUE_MUST_BE_WHOLE_AND_POSITIVE_INTEGER);
	}
}
