package org.serratec.java2backend.biblioteca.exception;

public class LivroException extends Exception {
	
	private static final long serialVersionUID = 1L;
	
	public LivroException() {
		super();
	}
	
	public LivroException(String message) {
		super(message);
	}
	
	public LivroException(String message, Exception cause) {
		super(message, cause);
	}
	
	public LivroException(Exception e) {
		super(e);
	}
}
