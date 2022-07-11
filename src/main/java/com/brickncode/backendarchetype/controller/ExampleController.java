package com.brickncode.backendarchetype.controller;

import com.brickncode.backendarchetype.common.GenericResponse;
import com.brickncode.backendarchetype.common.URLConstant;
import com.brickncode.backendarchetype.data.model.input.ExamplePutInput;
import com.brickncode.backendarchetype.data.model.input.ExamplePostInput;
import com.brickncode.backendarchetype.service.interfaces.ExampleService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.ws.rs.core.Response;


@RestController
@RequestMapping(value = "${spring.data.rest.base-path}" + URLConstant.EXAMPLE)
@CrossOrigin(origins = "*")
public class ExampleController {

	@Autowired
	private ExampleService service;

	private static final Logger LOGGER = LogManager.getLogger(ExampleController.class);

	@GetMapping(path = URLConstant.GETALL, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody GenericResponse getAllExamples() {
		LOGGER.info("GetAll endpoint called.");
		return service.getAllExamples();
	}

	@GetMapping(path = URLConstant.GETONE + URLConstant.ID_VARIABLE, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody GenericResponse getOneExampleByID(@Valid @PathVariable Integer id) {
		LOGGER.info("GetOne endpoint called.");
		if(id == null || id < 0) {
			LOGGER.error("PathVariable id: {} is invalid. Or null o lower than 0.", id);
			return new GenericResponse(Response.Status.BAD_REQUEST.getStatusCode(), Response.Status.BAD_REQUEST.getReasonPhrase());
		}
		return service.getExampleByID(id);
	}

	@PostMapping(path = URLConstant.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody GenericResponse postExample(@Valid @RequestBody ExamplePostInput data) {
		if(data == null || data.getName() == null || data.getName().isEmpty() || data.getSurname() == null || data.getSurname().isEmpty() || data.getMail() == null
				|| data.getMail().isEmpty() || data.getPassword() == null || data.getPassword().isEmpty() || data.getStrBirthday() == null || data.getStrBirthday().isEmpty()) {
			return new GenericResponse(Response.Status.BAD_REQUEST.getStatusCode(), Response.Status.BAD_REQUEST.getReasonPhrase() + " - missing information.");
		}
		return service.postExample(data);
	}

	@PutMapping(path = URLConstant.PUT, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody GenericResponse putExample(@Valid @RequestBody ExamplePutInput data) {
		if(data == null || data.getId() == null || data.getId() < 0 || data.getName() == null || data.getName().isEmpty() || data.getSurname() == null || data.getSurname().isEmpty()
				|| data.getPassword() == null || data.getPassword().isEmpty() || data.getStrBirthday() == null || data.getStrBirthday().isEmpty()) {
			return new GenericResponse(Response.Status.BAD_REQUEST.getStatusCode(), Response.Status.BAD_REQUEST.getReasonPhrase() + " - missing information.");
		}
		return service.putExample(data);
	}

	@DeleteMapping(path = URLConstant.DELETE + URLConstant.ID_VARIABLE, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody GenericResponse deleteExample(@Valid @PathVariable Integer id) {
		if(id == null || id < 0) {
			return new GenericResponse(Response.Status.BAD_REQUEST.getStatusCode(), Response.Status.BAD_REQUEST.getReasonPhrase());
		}
		return service.deleteExample(id);
	}
}
