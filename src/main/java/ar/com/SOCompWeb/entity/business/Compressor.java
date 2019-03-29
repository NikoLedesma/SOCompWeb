package ar.com.SOCompWeb.entity.business;

import ar.com.SOCompWeb.exception.CompressionException;

public class Compressor {

	private static char CENTINEL = '$';

	public String compress(String valueText, CompressionCriteria comCriteria) {
		int count = 0;
		char currentChar = CENTINEL;
		String compressedValue = "";
		for (int i = 0; i < valueText.length(); i++) {
			char inChar = valueText.charAt(i);
			if (comCriteria.complyCriteria(inChar)) {
				inChar = comCriteria.convertCharacter(inChar);
				if (currentChar == CENTINEL) {
					currentChar = inChar;
					count += 1;
				} else if (currentChar == inChar) {
					count += 1;
				} else {
					compressedValue += "" + count + currentChar;
					currentChar = inChar;
					count = 1;
				}
			} else {
				throw new CompressionException(comCriteria.getExceptionMessage());
			}

		}
		compressedValue += "" + count + currentChar;
		return compressedValue;

	}

}
