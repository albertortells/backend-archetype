package com.brickncode.backendarchetype.service.interfaces;

import com.brickncode.backendarchetype.common.GenericResponse;
import com.brickncode.backendarchetype.data.model.input.ExamplePutInput;
import com.brickncode.backendarchetype.data.model.input.ExamplePostInput;

public interface ExampleService {

	/**
	 * Method for get all example users in database. This method no need any parameter, just the correct URL.
	 * @return GenericResponse
	 */
	GenericResponse getAllExamples();

	/**
	 * Method for get the information for one example user using the id parameter.
	 * This method receive the id and find in database the whole information associated to this id.
	 * In return statement, put in the output object this information for show up in the front app.
	 * @param data - Example Id
	 * @return GenericResponse
	 */
	GenericResponse getExampleByID(Integer data);

	/**
	 *
	 * @param data - object coming from the front app
	 * @return GenericResponse
	 */
	GenericResponse postExample(ExamplePostInput data);

	/**
	 *
	 * @param data - object coming from the front app
	 * @return GenericResponse
	 */
	GenericResponse putExample(ExamplePutInput data);

	/**
	 *
	 * @param data - Example Id
	 * @return GenericResponse
	 */
	GenericResponse deleteExample(Integer data);
}
