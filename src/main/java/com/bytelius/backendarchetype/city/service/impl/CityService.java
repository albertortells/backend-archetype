package com.bytelius.backendarchetype.city.service.impl;


import com.bytelius.backendarchetype.city.data.dto.CityClass;
import com.bytelius.backendarchetype.city.data.dto.input.NewCityInput;
import com.bytelius.backendarchetype.city.data.dto.input.UpdateCityInput;
import com.bytelius.backendarchetype.city.data.dto.output.NewCityOutput;
import com.bytelius.backendarchetype.city.data.dto.output.UpdateCityOutput;
import com.bytelius.backendarchetype.city.data.entity.CityEntity;
import com.bytelius.backendarchetype.city.data.mapper.ICityMapper;
import com.bytelius.backendarchetype.city.repository.ICityRepository;
import com.bytelius.backendarchetype.city.service.ICityService;
import com.bytelius.backendarchetype.shared.GenericResponse;
import com.bytelius.backendarchetype.shared.exception.NotFoundException;
import com.bytelius.backendarchetype.shared.exception.WriteDBException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CityService implements ICityService {

	private final ICityRepository iCityRepository;

	private final ICityMapper iCityMapper;

	private CityClass cityClass;

	private CityEntity cityEntity;

	private GenericResponse genericResponse;

	@Autowired
	public CityService(ICityRepository iCityRepository, ICityMapper iCityMapper) {
		this.iCityRepository = iCityRepository;
		this.iCityMapper = iCityMapper;
	}

	@Override
	public GenericResponse getAllCityMethod() throws NotFoundException {

		List<CityEntity> entities = iCityRepository.findAll();

		if(entities == null || entities.isEmpty()) {
			throw new NotFoundException("Sorry, we can't response your petition");
		}

		List<CityClass> classes = new ArrayList<>();
		for(CityEntity e : entities) {
			cityClass = iCityMapper.cityEntityToCityClass(e);
			classes.add(cityClass);
		}
		genericResponse = new GenericResponse(HttpStatus.OK, "Here you have all cities saved in database", classes);

		return genericResponse;
	}

	@Override
	public GenericResponse getCityByPathVariableIDMethod(Integer data) throws NotFoundException {
		cityEntity = iCityRepository.findCityEntityById(data);

		if(cityEntity == null) { throw new NotFoundException("", new Throwable("")); }

		cityClass = iCityMapper.cityEntityToCityClass(cityEntity);

		genericResponse = new GenericResponse(HttpStatus.OK, "Here you have your city search by id using path variable.", cityClass);

		return genericResponse;
	}

	@Override
	public GenericResponse getCityByRequestIDParamMethod(Integer data) throws NotFoundException {
		cityEntity = iCityRepository.findCityEntityById(data);

		if(cityEntity == null) { throw new NotFoundException("", new Throwable("")); }

		cityClass = iCityMapper.cityEntityToCityClass(cityEntity);

		genericResponse = new GenericResponse(HttpStatus.OK, "Here you have your city search by id using request params.", cityClass);

		return genericResponse;
	}

	@Override
	public GenericResponse saveCityMethod(NewCityInput dto) /*throws WriteDBException*/ {

		cityClass = iCityMapper.newCityInputToCityClass(dto);
		cityEntity = iCityMapper.cityClassToCityEntity(cityClass);

		CityEntity saved = iCityRepository.save(cityEntity);
		iCityRepository.flush();

		cityClass = iCityMapper.cityEntityToCityClass(saved);
		NewCityOutput newCityOutput = iCityMapper.cityClassToNewCityOutput(cityClass);

		return new GenericResponse(HttpStatus.OK, "New city saved correctly.", newCityOutput);
	}

	@Override
	public GenericResponse updateCityMethod(UpdateCityInput dto) throws NotFoundException, WriteDBException {

		cityClass = iCityMapper.updateCityInputToCityClass(dto);
		cityEntity = iCityMapper.cityClassToCityEntity(cityClass);

		CityEntity exist = iCityRepository.findCityEntityById(cityEntity.getId());
		if(exist == null) { throw new NotFoundException("", new Throwable(""));	}

		int updated = iCityRepository.updatePopulationByID(cityEntity.getPopulation(), cityEntity.getId());
		if(updated == 0) { throw new WriteDBException("", new Throwable("")); }

		cityEntity = iCityRepository.findCityEntityById(cityEntity.getId());

		cityClass = iCityMapper.cityEntityToCityClass(cityEntity);
		UpdateCityOutput updateCityOutput = iCityMapper.cityClassToUpdateCityOutput(cityClass);

		return new GenericResponse(HttpStatus.OK, "New population value was added to the city.", updateCityOutput);
	}

	@Override
	public GenericResponse deleteCityByPathVariableIDMethod(Integer data) throws NotFoundException, WriteDBException {
		cityEntity = iCityRepository.findCityEntityById(data);

		if(cityEntity == null) { throw new NotFoundException("", new Throwable("")); }

		int deleted = iCityRepository.deleteCityById(cityEntity.getId());

		if(deleted == 0) { throw new WriteDBException("", new Throwable("")); }

		return new GenericResponse(HttpStatus.OK, "City was deleted successfully");
	}

	@Override
	public GenericResponse deleteCityByRequestIDParamMethod(Integer data) throws NotFoundException, WriteDBException {
		cityEntity = iCityRepository.findCityEntityById(data);

		if(cityEntity == null) { throw new NotFoundException("", new Throwable("")); }

		int deleted = iCityRepository.deleteCityById(cityEntity.getId());

		if(deleted == 0) { throw new WriteDBException("", new Throwable("")); }

		return new GenericResponse(HttpStatus.OK, "City was deleted successfully");
	}
}
