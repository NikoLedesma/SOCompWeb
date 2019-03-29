package ar.com.SOCompWeb.service;

import ar.com.SOCompWeb.exception.CompressionException;
import ar.com.SOCompWeb.exception.ExceptionMSG;

public class CompressorServiceImpl implements CompressorService {

	private static char CENTINEL = '$';

	@Override
	public String compress(String value) throws CompressionException {

		int count = 0;
		char currentChar = CENTINEL;
		String compressedValue = "";
		
		if (value.trim().isEmpty()) {
			throw new CompressionException(ExceptionMSG.EXCEPTION_EMPTY_COMPRESSION);
		}
		for (int i = 0; i < value.length(); i++) {
			char inChar = value.charAt(i);
			if (Character.isLetter(inChar) && Character.isUpperCase(inChar)) {
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
				throw new CompressionException(ExceptionMSG.EXCEPTION_LETTERS_COMPRESSION);
			}

		}
		compressedValue += "" + count + currentChar;

		return compressedValue;
	}

}
