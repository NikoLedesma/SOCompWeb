package ar.com.SOCompWeb.service;

public class CompressorServiceImpl implements CompressorService {

	private static char CENTINEL = '$';

	@Override
	public String compress(String value) {

		int count = 0;
		char currentChar = CENTINEL;
		String compressedValue = "";

		for (int i = 0; i < value.length(); i++) {
			char inChar = value.charAt(i);
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

		}
		compressedValue += "" + count + currentChar;

		return compressedValue;
	}

}
