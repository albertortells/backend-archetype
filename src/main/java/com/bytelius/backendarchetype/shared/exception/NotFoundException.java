package com.bytelius.backendarchetype.shared.exception;

import java.io.IOException;

public class NotFoundException extends IOException {

	private static final long serialVersionUID = 6022219428024988916L;

	public NotFoundException() {}

	public NotFoundException(String message) { super(message); }

	public NotFoundException(String message, Throwable cause) { super(message, cause); }
}
