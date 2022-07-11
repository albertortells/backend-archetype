package com.brickncode.backendarchetype.data.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;

public class GenericResponse extends ResponseEntity {

	@Getter @Setter private String message;

	public GenericResponse(HttpStatus status, String message) {
		super(status);
		this.message = message;
	}

	public GenericResponse(HttpStatus status, String message, Object body) {
		super(body, status);
		this.message = message;
	}
}
