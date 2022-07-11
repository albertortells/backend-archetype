package com.brickncode.backendarchetype.service;

import com.brickncode.backendarchetype.data.dto.GenericResponse;
import com.brickncode.backendarchetype.data.dto.input.NewCityInput;
import com.brickncode.backendarchetype.data.dto.input.UpdateCityInput;

public interface ISampleService {

	/**
	 * Method for get all cities in database. This method no need any parameter, just the correct URL.
	 * @return GenericResponse
	 */
	GenericResponse getAllSampleCityMethod();

	/**
	 * Method for get the information for one example user using the id parameter from path variable.
	 * This method receive the id and find in database the whole information associated to this id.
	 * In return statement, put in the output object this information for show up in the front app.
	 * @param data - Example Id
	 * @return GenericResponse
	 */
	GenericResponse getSampleCityByPathVariableIDMethod(Integer data);

	/**
	 * Method for get the information for one example user using the id parameter from request param.
	 * This method receive the id and find in database the whole information associated to this id.
	 * In return statement, put in the output object this information for show up in the front app.
	 * @param data - Example Id
	 * @return GenericResponse
	 */
	GenericResponse getSampleCityByRequestIDParamMethod(Integer data);

	/**
	 *
	 * @param dto - object coming from the front app
	 * @return GenericResponse
	 */
	GenericResponse saveSampleCityMethod(NewCityInput dto);

	/**
	 *
	 * @param dto - object coming from the front app
	 * @return GenericResponse
	 */
	GenericResponse updateSampleCityMethod(UpdateCityInput dto);

	/**
	 *
	 * @param data - Example Id
	 * @return GenericResponse
	 */
	GenericResponse deleteSampleCityByPathVariableIDMethod(Integer data);

	/**
	 *
	 * @param data
	 * @return
	 */
	GenericResponse deleteSampleCityByRequestIDParamMethod(Integer data);
}
