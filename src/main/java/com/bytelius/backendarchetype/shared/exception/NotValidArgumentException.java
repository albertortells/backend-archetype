package com.bytelius.backendarchetype.shared.exception;

public class NotValidArgumentException extends IllegalArgumentException {

	private static final long serialVersionUID = 3485875869330049723L;

	public NotValidArgumentException() {}

	public NotValidArgumentException(String s) { super(s); }

	public NotValidArgumentException(String message, Throwable cause) { super(message, cause); }

	public NotValidArgumentException(Throwable cause) { super(cause); }
}
