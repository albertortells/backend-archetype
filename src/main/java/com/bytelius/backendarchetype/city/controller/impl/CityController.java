package com.bytelius.backendarchetype.city.controller.impl;

import com.bytelius.backendarchetype.city.controller.ICityController;
import com.bytelius.backendarchetype.city.service.ICityService;
import com.bytelius.backendarchetype.city.data.dto.input.NewCityInput;
import com.bytelius.backendarchetype.city.data.dto.input.UpdateCityInput;
import com.bytelius.backendarchetype.shared.GenericResponse;
import com.bytelius.backendarchetype.shared.exception.ErrorResponse;
import com.bytelius.backendarchetype.shared.exception.NotFoundException;
import com.bytelius.backendarchetype.shared.exception.NotValidArgumentException;
import com.bytelius.backendarchetype.shared.exception.WriteDBException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
public class CityController implements ICityController {

	private static final Logger LOGGER = LoggerFactory.getLogger(CityController.class);

	private GenericResponse genericResponse;
	private ErrorResponse errorResponse;

	private final ICityService iCityService;

	@Autowired
	public CityController(ICityService iCityService) {
		this.iCityService = iCityService;
	}

	@Override
	public Object getAllCityMethod() {
		LOGGER.info("CityController - getAllCity endpoint called");
		try {
			genericResponse = iCityService.getAllCityMethod();
			LOGGER.info("CityController - getAllCity endpoint succeed");
			return genericResponse;
		} catch (NotFoundException ex) {
			LOGGER.error("CityController - getAllCity endpoint failed.");
			LOGGER.error("StackTrace: ", ex.fillInStackTrace());
			errorResponse = new ErrorResponse(HttpStatus.NOT_FOUND, ex.getMessage());
			return errorResponse;
		}
	}

	@Override
	public Object getCityByPathVariableIDMethod(@PathVariable Integer id) {
		LOGGER.info("CityController - getCityByPathVariableID endpoint called");
		try {
			if (id == null || id < 0) { throw new NotValidArgumentException("", new Throwable("")); }
			genericResponse = iCityService.getCityByPathVariableIDMethod(id);
			LOGGER.info("CityController - getCityByPathVariableID endpoint succeed");
			return genericResponse;
		} catch (NotFoundException ex) {
			LOGGER.error("CityController - getCityByPathVariableID endpoint failed" + ex.getCause());
			errorResponse = new ErrorResponse(HttpStatus.NOT_FOUND, ex.getMessage());
			return errorResponse;
		} catch (NotValidArgumentException ex) {
			LOGGER.error("");
			errorResponse = new ErrorResponse(HttpStatus.BAD_REQUEST, ex.getMessage());
			return errorResponse;
		}
	}

	@Override
	public Object getCityByRequestIDParamMethod(@RequestParam Integer id) {
		LOGGER.info("CityController - getCityByRequestIDParam endpoint called");
		try {
			if (id == null || id < 0) { throw new NotValidArgumentException("", new Throwable("")); }
			iCityService.getCityByRequestIDParamMethod(id);
			return genericResponse;
		} catch (NotFoundException ex) {
			LOGGER.error("CityController - getCityByRequestIDParam endpoint failed" + ex.getCause());
			errorResponse = new ErrorResponse(HttpStatus.NOT_FOUND, ex.getMessage());
			return errorResponse;
		} catch (NotValidArgumentException ex) {
			LOGGER.error("");
			errorResponse = new ErrorResponse(HttpStatus.BAD_REQUEST, ex.getMessage());
			return errorResponse;
		}
	}

	@Override
	public Object saveCityMethod(NewCityInput dto) {
		LOGGER.info("CityController - saveCity endpoint called");
		try {
			if (dto == null) {
				throw new NotValidArgumentException("", new Throwable(""));
			}
			return iCityService.saveCityMethod(dto);
		} catch (NotValidArgumentException ex) {
			errorResponse = new ErrorResponse(HttpStatus.BAD_REQUEST, ex.getMessage());
			return errorResponse;
		}
	}

	@Override
	public Object updateCityMethod(UpdateCityInput dto) {
		LOGGER.info("CityController - updateCity endpoint called");
		try {
			if (dto == null) {
				throw new NotValidArgumentException("", new Throwable(""));
			}
			return iCityService.updateCityMethod(dto);
		} catch (NotValidArgumentException ex) {
			errorResponse = new ErrorResponse(HttpStatus.BAD_REQUEST, ex.getMessage());
			return errorResponse;
		} catch (NotFoundException ex) {
			errorResponse = new ErrorResponse(HttpStatus.NOT_FOUND, ex.getMessage());
			return errorResponse;
		} catch (WriteDBException ex) {
			errorResponse = new ErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage());
			return errorResponse;
		}
	}

	@Override
	public Object deleteCityByPathVariableIDMethod(Integer id) {
		LOGGER.info("CityController - deleteCityByPathVariableID endpoint called");

		try {
			if (id == null || id < 0) { throw new NotValidArgumentException("", new Throwable("")); }
			genericResponse = iCityService.deleteCityByPathVariableIDMethod(id);
			LOGGER.info("CityController - getCityByPathVariableID endpoint succeed");
			return genericResponse;
		} catch (NotFoundException ex) {
			LOGGER.error("CityController - getCityByPathVariableID endpoint failed" + ex.getCause());
			errorResponse = new ErrorResponse(HttpStatus.NOT_FOUND, ex.getMessage());
			return errorResponse;
		} catch (WriteDBException ex) {
			LOGGER.error("");
			errorResponse = new ErrorResponse(HttpStatus.BAD_REQUEST, ex.getMessage());
			return errorResponse;
		}
	}

	@Override
	public Object deleteCityByRequestIDParamMethod(Integer id) {
		LOGGER.info("CityController - deleteCityByPathVariableID endpoint called");

		try {
			if (id == null || id < 0) { throw new NotValidArgumentException("", new Throwable("")); }
			genericResponse = iCityService.deleteCityByRequestIDParamMethod(id);
			LOGGER.info("CityController - getCityByPathVariableID endpoint succeed");
			return genericResponse;
		} catch (NotFoundException ex) {
			LOGGER.error("CityController - getCityByPathVariableID endpoint failed" + ex.getCause());
			errorResponse = new ErrorResponse(HttpStatus.NOT_FOUND, ex.getMessage());
			return errorResponse;
		} catch (WriteDBException ex) {
			LOGGER.error("");
			errorResponse = new ErrorResponse(HttpStatus.BAD_REQUEST, ex.getMessage());
			return errorResponse;
		}
	}
}
