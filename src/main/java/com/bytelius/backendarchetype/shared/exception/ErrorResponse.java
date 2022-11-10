package com.bytelius.backendarchetype.shared.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class ErrorResponse extends ResponseStatusException {

	private static final long serialVersionUID = -7210366756696866725L;

	public ErrorResponse(HttpStatus status) {
		super(status);
	}

	public ErrorResponse(HttpStatus status, String reason) {
		super(status, reason);
	}

	public ErrorResponse(HttpStatus status, String reason, Throwable cause) {
		super(status, reason, cause);
	}

	public ErrorResponse(int rawStatusCode, String reason, Throwable cause) {
		super(rawStatusCode, reason, cause);
	}
}
