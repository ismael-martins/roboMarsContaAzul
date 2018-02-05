package br.com.contaazul.exception;

public class ExceededAreaException extends Exception {

	private static final long serialVersionUID = 1L;

	public ExceededAreaException(String msg) {
		super(msg);
	}
	
	public ExceededAreaException(String msg, Throwable cause) {
		super(msg, cause);
	}
	
	public ExceededAreaException(int code, String msg, Throwable cause) {
		this(code + " " + msg);
	}
}
