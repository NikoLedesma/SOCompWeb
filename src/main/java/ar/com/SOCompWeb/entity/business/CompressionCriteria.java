package ar.com.SOCompWeb.entity.business;

import ar.com.SOCompWeb.exception.ExceptionMSG;

public interface CompressionCriteria {

	boolean complyCriteria(char inChar);

	ExceptionMSG getExceptionMessage();
	
	char convertCharacter(char inChar);
}
