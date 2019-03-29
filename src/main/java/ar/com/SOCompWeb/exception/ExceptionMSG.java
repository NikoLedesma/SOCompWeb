package ar.com.SOCompWeb.exception;

public enum ExceptionMSG {
	EXCEPTION_LETTERS_COMPRESSION("Value should contains only upper letters for compressing"),
	EXCEPTION_EMPTY_COMPRESSION("Value should't be empty");

	private String MSG;

	ExceptionMSG(String msg) {
		this.MSG = msg;
	}

	public String msg() {
		return MSG;
	}
}
