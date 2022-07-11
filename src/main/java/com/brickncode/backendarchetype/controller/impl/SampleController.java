package com.brickncode.backendarchetype.controller.impl;

import com.brickncode.backendarchetype.controller.ISampleController;
import com.brickncode.backendarchetype.data.dto.GenericResponse;
import com.brickncode.backendarchetype.data.dto.input.NewCityInput;
import com.brickncode.backendarchetype.data.dto.input.UpdateCityInput;
import com.brickncode.backendarchetype.service.ISampleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
public class SampleController implements ISampleController {

	private static final Logger LOGGER = LoggerFactory.getLogger(SampleController.class);

	private final ISampleService iSampleService;

	@Autowired
	public SampleController(ISampleService iSampleService) {
		this.iSampleService = iSampleService;
	}

	@Override
	public GenericResponse getAllSampleCityMethod() {
		LOGGER.info("SampleController - getAllMethod endpoint called");
		return iSampleService.getAllSampleCityMethod();
	}

	@Override
	public GenericResponse getSampleCityByPathVariableIDMethod(@PathVariable Integer id) {
		LOGGER.info("SampleController - getSampleByPathVariableID endpoint called");
		return iSampleService.getSampleCityByPathVariableIDMethod(id);
	}

	@Override
	public GenericResponse getSampleCityByRequestIDParamMethod(@RequestParam Integer id) {
		LOGGER.info("SampleController - getSampleByRequestIDParam endpoint called");
		return iSampleService.getSampleCityByRequestIDParamMethod(id);
	}

	@Override
	public GenericResponse saveSampleCityMethod(NewCityInput dto) {
		LOGGER.info("SampleController - saveCity endpoint called");
		return iSampleService.saveSampleCityMethod(dto);
	}

	@Override
	public GenericResponse updateSampleCityMethod(UpdateCityInput dto) {
		return null;
	}

	@Override
	public GenericResponse deleteSampleCityByPathVariableIDMethod(Integer id) {
		return null;
	}

	@Override
	public GenericResponse deleteSampleCityByRequestIDParamMethod(Integer id) {
		return null;
	}
}
