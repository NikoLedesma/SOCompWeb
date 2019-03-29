package ar.com.SOCompWeb.exception;

public class CompressionException extends RuntimeException {

	private static final long serialVersionUID = -4865430413903150099L;

	public CompressionException(String exception) {
		super(exception);
	}

	public CompressionException(ExceptionMSG exceptionItemStock) {
		super(exceptionItemStock.msg());
	}
}
