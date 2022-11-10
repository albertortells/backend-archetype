package com.bytelius.backendarchetype.city.controller;

import com.bytelius.backendarchetype.city.data.dto.input.NewCityInput;
import com.bytelius.backendarchetype.city.data.dto.input.UpdateCityInput;
import com.bytelius.backendarchetype.shared.GenericResponse;
import com.bytelius.backendarchetype.shared.URLConstant;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequestMapping(value = "${spring.data.rest.base-path}" + URLConstant.CONTROLLER_PREFIX)
public interface ICityController {

	/**
	 * Generic method to obtain all the data from the database in the form of a list,
	 * returning a generic object with the http status, a message and the data obtained.
	 * It does not require any input parameters.
	 * @return Object
	 */
	@GetMapping(path = URLConstant.GET_ALL, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody Object getAllCityMethod();

	/**
	 * Method to obtain a single record from the database sending only the id as a path variable,
	 * returning a generic object with the http status, a message and the data obtained.
	 * If you don't know what a path variable is, take a look (<a href="https://www.baeldung.com/spring-pathvariable">here</a>)
	 * or (<a href="https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/web/bind/annotation/PathVariable.html">here</a>)
	 * @param id - Integer send from user front-end
	 * @return Object
	 */
	@GetMapping(path = URLConstant.GET_ONE + URLConstant.PATH_ID_VARIABLE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody Object getCityByPathVariableIDMethod(@Valid @PathVariable Integer id);

	/**
	 * Method to obtain a single record from the database sending only the id as a request param,
	 * returning a generic object with the http status, a message and the data obtained.
	 * If you don't know what a request param is, take a look (<a href="https://www.baeldung.com/spring-request-param">here</a>)
	 * or (<a href="https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/web/bind/annotation/RequestParam.html">here</a>)
	 * @param id - Integer send from user front-end
	 * @return Object
	 */
	@GetMapping(path = URLConstant.GET_ONE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody Object getCityByRequestIDParamMethod(@Valid @RequestParam Integer id);

	/**
	 *
	 * @param dto -
	 * @return GenericResponse
	 */
	@PostMapping(path = URLConstant.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody Object saveCityMethod(@Valid @RequestBody NewCityInput dto);

	/**
	 *
	 * @param dto -
	 * @return Object
	 */
	@PutMapping(path = URLConstant.PUT, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody Object updateCityMethod(@Valid @RequestBody UpdateCityInput dto);

	/**
	 *
	 * @param id - Integer send from user front-end
	 * @return Object
	 */
	@DeleteMapping(path = URLConstant.DELETE + URLConstant.PATH_ID_VARIABLE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody Object deleteCityByPathVariableIDMethod(@Valid @PathVariable Integer id);

	/**
	 *
	 * @param id - Integer send from user front-end
	 * @return Object
	 */
	@DeleteMapping(path = URLConstant.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody Object deleteCityByRequestIDParamMethod(@Valid @RequestParam Integer id);
}
