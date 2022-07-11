package com.brickncode.backendarchetype.service.impl;

import com.brickncode.backendarchetype.data.dto.CityClass;
import com.brickncode.backendarchetype.data.dto.GenericResponse;
import com.brickncode.backendarchetype.data.dto.input.NewCityInput;
import com.brickncode.backendarchetype.data.dto.input.UpdateCityInput;
import com.brickncode.backendarchetype.data.dto.output.NewCityOutput;
import com.brickncode.backendarchetype.data.entity.CityEntity;
import com.brickncode.backendarchetype.data.mapper.ISampleMapper;
import com.brickncode.backendarchetype.repository.ISampleRepository;
import com.brickncode.backendarchetype.service.ISampleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SampleService implements ISampleService {

	private final ISampleRepository iSampleRepository;

	private final ISampleMapper iSampleMapper;

	private GenericResponse genericResponse;

	@Autowired
	public SampleService(ISampleRepository iSampleRepository, ISampleMapper iSampleMapper) {
		this.iSampleRepository = iSampleRepository;
		this.iSampleMapper = iSampleMapper;
	}

	@Override
	public GenericResponse getAllSampleCityMethod() {

		List<CityEntity> entities = iSampleRepository.findAll();
		List<CityClass> classes = new ArrayList<>();
		for(CityEntity e : entities) {
			CityClass c = iSampleMapper.cityEntityToCityClass(e);
			classes.add(c);
		}
		genericResponse = new GenericResponse(HttpStatus.OK, "Here you have all cities saved in database", classes);

		return genericResponse;
	}

	@Override
	public GenericResponse getSampleCityByPathVariableIDMethod(Integer data) {

		CityEntity cityEntity = iSampleRepository.findCityEntityById(data);

		CityClass cityClass = iSampleMapper.cityEntityToCityClass(cityEntity);

		genericResponse = new GenericResponse(HttpStatus.OK, "Here you have your city search by id using path variable.", cityClass);

		return genericResponse;
	}

	@Override
	public GenericResponse getSampleCityByRequestIDParamMethod(Integer data) {
		CityEntity cityEntity = iSampleRepository.findCityEntityById(data);

		CityClass cityClass = iSampleMapper.cityEntityToCityClass(cityEntity);

		genericResponse = new GenericResponse(HttpStatus.OK, "Here you have your city search by id using request params.", cityClass);

		return genericResponse;
	}

	@Override
	public GenericResponse saveSampleCityMethod(NewCityInput dto) {

		CityClass cityClass = iSampleMapper.newCityInputToCityClass(dto);
		CityEntity cityEntity = iSampleMapper.cityClassToCityEntity(cityClass);

		CityEntity saved = iSampleRepository.save(cityEntity);

		iSampleRepository.flush();

		CityClass outCityClass = iSampleMapper.cityEntityToCityClass(saved);
		NewCityOutput newCityOutput = iSampleMapper.cityClassToNewCityOutput(outCityClass);

		return new GenericResponse(HttpStatus.OK, "New city saved correctly.", newCityOutput);
	}

	@Override
	public GenericResponse updateSampleCityMethod(UpdateCityInput dto) {
		return null;
	}

	@Override
	public GenericResponse deleteSampleCityByPathVariableIDMethod(Integer data) {
		return null;
	}

	@Override
	public GenericResponse deleteSampleCityByRequestIDParamMethod(Integer data) {
		return null;
	}
}
