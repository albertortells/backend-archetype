package com.brickncode.backendarchetype.controller;

import com.brickncode.backendarchetype.common.URLConstant;
import com.brickncode.backendarchetype.data.dto.GenericResponse;
import com.brickncode.backendarchetype.data.dto.input.NewCityInput;
import com.brickncode.backendarchetype.data.dto.input.UpdateCityInput;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequestMapping(value = "${spring.data.rest.base-path}" + URLConstant.CONTROLLER_PREFIX)
public interface ISampleController {

	/**
	 * Generic method to obtain all the data from the database in the form of a list,
	 * returning a generic object with the http status, a message and the data obtained.
	 * It does not require any input parameters.
	 * @return GenericResponse
	 */
	@GetMapping(path = URLConstant.GET_ALL, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody GenericResponse getAllSampleCityMethod();

	/**
	 * Method to obtain a single record from the database sending only the id as a path variable,
	 * returning a generic object with the http status, a message and the data obtained.
	 * If you don't know what a path variable is, take a look (<a href="https://www.baeldung.com/spring-pathvariable">here</a>)
	 * or (<a href="https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/web/bind/annotation/PathVariable.html">here</a>)
	 * @param id - Integer send from user front-end
	 * @return GenericResponse
	 */
	@GetMapping(path = URLConstant.GET_ONE + URLConstant.PATH_ID_VARIABLE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody GenericResponse getSampleCityByPathVariableIDMethod(@Valid @PathVariable Integer id);

	/**
	 * Method to obtain a single record from the database sending only the id as a request param,
	 * returning a generic object with the http status, a message and the data obtained.
	 * If you don't know what a request param is, take a look (<a href="https://www.baeldung.com/spring-request-param">here</a>)
	 * or (<a href="https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/web/bind/annotation/RequestParam.html">here</a>)
	 * @param id - Integer send from user front-end
	 * @return GenericResponse
	 */
	@GetMapping(path = URLConstant.GET_ONE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody GenericResponse getSampleCityByRequestIDParamMethod(@Valid @RequestParam Integer id);

	/**
	 *
	 * @param dto -
	 * @return GenericResponse
	 */
	@PostMapping(path = URLConstant.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody GenericResponse saveSampleCityMethod(@Valid @RequestBody NewCityInput dto);

	/**
	 *
	 * @param dto -
	 * @return GenericResponse
	 */
	@ResponseBody GenericResponse updateSampleCityMethod(@Valid @RequestBody UpdateCityInput dto);

	/**
	 *
	 * @param id
	 * @return
	 */
	@ResponseBody GenericResponse deleteSampleCityByPathVariableIDMethod(@Valid @PathVariable Integer id);

	/**
	 *
	 * @param id
	 * @return
	 */
	@ResponseBody GenericResponse deleteSampleCityByRequestIDParamMethod(@Valid @RequestParam Integer id);
}
