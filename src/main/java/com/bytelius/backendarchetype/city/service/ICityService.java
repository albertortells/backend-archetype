package com.bytelius.backendarchetype.city.service;

import com.bytelius.backendarchetype.shared.GenericResponse;
import com.bytelius.backendarchetype.city.data.dto.input.NewCityInput;
import com.bytelius.backendarchetype.city.data.dto.input.UpdateCityInput;
import com.bytelius.backendarchetype.shared.exception.NotFoundException;
import com.bytelius.backendarchetype.shared.exception.NotValidArgumentException;
import com.bytelius.backendarchetype.shared.exception.WriteDBException;

public interface ICityService {

	/**
	 * Method for get all cities in database. This method no need any parameter, just the correct URL.
	 * @return GenericResponse
	 */
	GenericResponse getAllCityMethod() throws NotFoundException;

	/**
	 * Method for get the information for one example user using the id parameter from path variable.
	 * This method receive the id and find in database the whole information associated to this id.
	 * In return statement, put in the output object this information for show up in the front app.
	 * @param data - Example Id
	 * @return GenericResponse
	 */
	GenericResponse getCityByPathVariableIDMethod(Integer data) throws NotFoundException;

	/**
	 * Method for get the information for one example user using the id parameter from request param.
	 * This method receive the id and find in database the whole information associated to this id.
	 * In return statement, put in the output object this information for show up in the front app.
	 * @param data - Example Id
	 * @return GenericResponse
	 */
	GenericResponse getCityByRequestIDParamMethod(Integer data) throws NotFoundException;

	/**
	 *
	 * @param dto - object coming from the front app
	 * @return GenericResponse
	 */
	GenericResponse saveCityMethod(NewCityInput dto) throws NotValidArgumentException, WriteDBException;

	/**
	 *
	 * @param dto - object coming from the front app
	 * @return GenericResponse
	 */
	GenericResponse updateCityMethod(UpdateCityInput dto) throws NotFoundException, WriteDBException;

	/**
	 *
	 * @param data - Example Id
	 * @return GenericResponse
	 */
	GenericResponse deleteCityByPathVariableIDMethod(Integer data) throws NotFoundException, WriteDBException;

	/**
	 *
	 * @param data
	 * @return
	 */
	GenericResponse deleteCityByRequestIDParamMethod(Integer data) throws NotFoundException, WriteDBException;
}
