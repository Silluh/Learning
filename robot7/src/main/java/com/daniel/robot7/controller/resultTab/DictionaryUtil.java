/**
 * Package crawler.controller.resultTab
 *
 **/
package robot.controller.resultTab;

import java.util.HashSet;
import java.util.Set;

import robot.util.CommonConstants;

/**
 * The Class DictionaryUtil.
 *
 * @author Daniel Žažo
 * @date 23. 3. 2015
 */
public class DictionaryUtil {

	/**
	 * Regular expression --> \p{Punct} Punctuation: One of !"#$%&'()*+,-./:;<=>?@[\]^_`{|}~ Added other special characters: „“
	 */
	private static final String	REGEX_SPECIAL_CHARACTERS	= "[\\p{Punct}„“]";

	/** The basic dictionary. */
	private final Set<String>	basicDictionary;

	/**
	 * Instantiates a new dictionary util.
	 *
	 * @param onlyWords
	 *            the only words
	 */
	public DictionaryUtil(Set<String> onlyWords) {
		this.basicDictionary = onlyWords;
	}

	/**
	 * This method replacing special characters empty space and creating new words *alois. --> alois soma. --> soma .somma. --> somma "s.f-ss --> [s, f, ss]
	 * koko/dd --> [koko, dd]
	 *
	 * @return the fixed dictionary
	 */
	public Set<String> getFixedDictionary() {
		final Set<String> resultSet = new HashSet<String>();

		for (final String word : basicDictionary) {
			final String resultWithSpaces = word.replaceAll(REGEX_SPECIAL_CHARACTERS, CommonConstants.SPACE);
			final String[] resultArray = resultWithSpaces.split(CommonConstants.SPACE);

			for (final String finalWord : resultArray) {
				if (!finalWord.equals(CommonConstants.EMPTY_STRING)) {
					resultSet.add(finalWord);
				}
			}
		}
		basicDictionary.addAll(resultSet);
		return basicDictionary;
	}
}
