package ar.com.SOCompWeb.service;

import org.springframework.stereotype.Service;

import ar.com.SOCompWeb.entity.SOCompression;
import ar.com.SOCompWeb.entity.SOText;
import ar.com.SOCompWeb.exception.CompressionException;
import ar.com.SOCompWeb.exception.ExceptionMSG;

@Service
public class CompressorServiceImpl implements CompressorService {

	private static char CENTINEL = '$';

	@Override
	public SOCompression compress(SOText soText) throws CompressionException {

		int count = 0;
		char currentChar = CENTINEL;
		String compressedValue = "";

		if (soText.getValue().trim().isEmpty()) {
			throw new CompressionException(ExceptionMSG.EXCEPTION_EMPTY_COMPRESSION);
		}
		for (int i = 0; i < soText.getValue().length(); i++) {
			char inChar = soText.getValue().charAt(i);
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
		return new SOCompression(compressedValue);
	}

}
