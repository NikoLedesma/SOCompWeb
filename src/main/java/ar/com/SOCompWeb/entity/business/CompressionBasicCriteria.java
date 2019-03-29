package ar.com.SOCompWeb.entity.business;

import ar.com.SOCompWeb.exception.ExceptionMSG;

public class CompressionBasicCriteria implements CompressionCriteria {
	public boolean complyCriteria(char inChar) {
		return Character.isLetter(inChar) && Character.isUpperCase(inChar);
	}

	public ExceptionMSG getExceptionMessage() {
		return ExceptionMSG.EXCEPTION_LETTERS_COMPRESSION;
	}

	@Override
	public char convertCharacter(char inChar) {
		return inChar;
	}

}
