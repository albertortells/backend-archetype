package com.brickncode.backendarchetype.service;

import com.brickncode.backendarchetype.common.GenericResponse;
import com.brickncode.backendarchetype.common.utils.Parsers;
import com.brickncode.backendarchetype.data.entity.ExampleEntity;
import com.brickncode.backendarchetype.data.mapper.ExampleMapper;
import com.brickncode.backendarchetype.data.model.Example;
import com.brickncode.backendarchetype.data.model.input.ExamplePutInput;
import com.brickncode.backendarchetype.data.model.input.ExamplePostInput;
import com.brickncode.backendarchetype.data.model.output.ExampleGetOutput;
import com.brickncode.backendarchetype.data.model.output.ExamplePostOutput;
import com.brickncode.backendarchetype.data.model.output.ExamplePutOutput;
import com.brickncode.backendarchetype.repository.ExampleRepository;
import com.brickncode.backendarchetype.service.interfaces.ExampleService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.ws.rs.core.Response.Status;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class ExampleServiceImpl implements ExampleService {

	@Autowired
	private ExampleRepository repository;

	@Autowired
	private ExampleMapper mapper;

	@Override
	public GenericResponse getAllExamples() {

		List<ExampleEntity> entities = repository.findAll();
		List<Example> examples = new ArrayList<>();

		//Validate if query return an object not null
		//If null -> return GenericResponse with status 404 Not Found
		if(entities == null) {
			return new GenericResponse(Status.NOT_FOUND.getStatusCode(), Status.NOT_FOUND.getReasonPhrase() + " - There is no examples in database");
		}

		GenericResponse response;
		for (ExampleEntity entity : entities) {
			Example example = mapper.exampleEntityToExample(entity);
			examples.add(example);
		}

		int status = Status.OK.getStatusCode();
		String message = Status.OK.getReasonPhrase() + " - Examples found it.";

		response = new GenericResponse(status, message, examples);

		return response;
	}

	@Override
	public GenericResponse getExampleByID(Integer data) {
		ExampleEntity entity = repository.findExampleEntityById(data);

		//Validate if query return an object not null
		//If null -> return GenericResponse with status 404 Not Found
		if(entity == null) {
			return new GenericResponse(Status.NOT_FOUND.getStatusCode(), Status.NOT_FOUND.getReasonPhrase() + " - Incorrect id. Example user not found.");
		}

		Example example = mapper.exampleEntityToExample(entity);
		GenericResponse response;

		ExampleGetOutput out = mapper.exampleToExampleGetOutput(example);

		//Generate response object
		int status = Status.OK.getStatusCode();
		String message = Status.OK.getReasonPhrase() + " - Example user found.";
		response = new GenericResponse(status, message, out);

		return response;
	}

	@Override
	public GenericResponse postExample(ExamplePostInput data) {

		//Mapping string birthday to date object and set up to input object
		Date birthday = Parsers.parseStringToDate(data.getStrBirthday());
		data.setBirthday(birthday);

		//Mapping front object to a extended back object and later mapping to a entity
		Example example = mapper.examplePostInputToExample(data);
		ExampleEntity entity = fillExampleEntity(example);

		//Save the entity
		ExampleEntity saved = repository.save(entity);

		//Check if entity saved is not null
		if (saved == null) {
			return new GenericResponse(Status.INTERNAL_SERVER_ERROR.getStatusCode(), Status.INTERNAL_SERVER_ERROR.getReasonPhrase() + " - Probably sql error.");
		}
		//Save changes to DB
		repository.flush();

		//Mapping saved object to back object again and later to a minimized object
		Example exOut = mapper.exampleEntityToExample(saved);
		ExamplePostOutput out = mapper.exampleToExamplePostOutput(exOut);

		//Generate the response
		GenericResponse response;

		int status = Status.CREATED.getStatusCode();
		String message = Status.CREATED.getReasonPhrase() + " - Example user saved.";
		response = new GenericResponse(status, message, out);

		return response;
	}

	@Override
	public GenericResponse putExample(ExamplePutInput data) {

		//Mapping string birthday to date object and set up to input object
		Date birthday = Parsers.parseStringToDate(data.getStrBirthday());
		data.setBirthday(birthday);

		//Mapping front object to a extended back object
		Example example = mapper.examplePutInputToExample(data);

		//First find the whole information of this coach
		ExampleEntity entity = repository.findExampleEntityById(example.getId());

		//Set the new values to entity
		entity.setName(example.getName());
		entity.setSurname(example.getSurname());
		entity.setPassword(example.getPassword());
		entity.setBirthday(example.getBirthday());

		//Save the entity
		ExampleEntity saved = repository.save(entity);

		//Check if entity saved is not null
		if (saved == null) {
			return new GenericResponse(Status.INTERNAL_SERVER_ERROR.getStatusCode(), Status.INTERNAL_SERVER_ERROR.getReasonPhrase() + " - Probably sql error.");
		}
		//Save changes to DB
		repository.flush();

		//Mapping saved object to back object again and later to a minimized object
		Example ex = mapper.exampleEntityToExample(saved);
		ExamplePutOutput out = mapper.exampleToExamplePutOutput(ex);

		//Generate the response
		GenericResponse response;

		int status = Status.CREATED.getStatusCode();
		String message = Status.CREATED.getReasonPhrase() + " - Example user updated.";
		response = new GenericResponse(status, message, out);

		return response;
	}

	@Override
	public GenericResponse deleteExample(Integer data) {
		//TODO: If you want, you first can check if the id was receive it, it's correct and belongs to some object in database
		//TODO: Actually is the best way to proceed, so I suggest you to apply it.

		repository.deleteById(data);

		GenericResponse response;

		int status = Status.OK.getStatusCode();
		String message = Status.OK.getReasonPhrase() + " - Example user deleted.";
		response = new GenericResponse(status, message, true);

		return response;
	}

	/**
	 * This method is for add the info to the object which let us know who and when modify this object in and for database
	 * @param pojo - object parsed coming from the front app
	 * @return ExampleEntity
	 */
	private ExampleEntity fillExampleEntity(Example pojo) {
		ExampleEntity ee = mapper.exampleToExampleEntity(pojo);

		ee.setCreatedBy("Admin");
		ee.setLastModifiedBy("Admin");
		ee.setCreatedDate(new Date());
		ee.setLastModifiedDate(new Date());

		return ee;
	}
}
