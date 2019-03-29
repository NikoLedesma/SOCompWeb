package ar.com.SOCompWeb.entity.business;

import ar.com.SOCompWeb.exception.ExceptionMSG;

public class CompressionExtraCriteria implements CompressionCriteria {

	public boolean complyCriteria(char inChar) {
		return Character.isLetter(inChar);
	}

	public ExceptionMSG getExceptionMessage() {
		return ExceptionMSG.EXCEPTION_LETTERS_EXTRA_COMPRESSION;
	}

	@Override
	public char convertCharacter(char inChar) {
		return Character.toUpperCase(inChar);
	}

}
