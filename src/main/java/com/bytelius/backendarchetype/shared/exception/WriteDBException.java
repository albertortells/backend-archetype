package com.bytelius.backendarchetype.shared.exception;

public class WriteDBException extends RuntimeException {

	private static final long serialVersionUID = 4430418633623855291L;

	public WriteDBException() {}

	public WriteDBException(String message) { super(message); }

	public WriteDBException(String message, Throwable cause) { super(message, cause); }
}
