package com.brickncode.backendarchetype.service;

import com.brickncode.backendarchetype.common.GenericResponse;
import com.brickncode.backendarchetype.data.entity.ExampleEntity;
import com.brickncode.backendarchetype.data.model.input.ExamplePostInput;
import com.brickncode.backendarchetype.data.model.input.ExamplePutInput;
import com.brickncode.backendarchetype.repository.ExampleRepository;
import com.brickncode.backendarchetype.service.interfaces.ExampleService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import javax.ws.rs.core.Response;
import java.util.Arrays;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doReturn;

@SpringBootTest
class ExampleServiceImplTest {

	@Autowired
	private ExampleService service;

	@MockBean
	private ExampleRepository repository;

	@Test
	void getAllExamples_isOk_thenReturnStatus200() {
		//Given
		ExampleEntity ex1 = new ExampleEntity("test1_h2@test.com", "password", "Test1", "H2_1", new Date());
		ExampleEntity ex2 = new ExampleEntity("test2_h2@test.com", "password", "Test2", "H2_2", new Date());

		//When
		doReturn(Arrays.asList(ex1,ex2)).when(repository).findAll();
		GenericResponse response = service.getAllExamples();

		//Then
		assertEquals(200, response.getStatus());
		assertEquals(Response.Status.OK.getReasonPhrase() + " - Examples found it.", response.getMessage());
	}

	@Test
	void getAllExamples_isNotOk_thenReturnStatus404() {
		//Given

		//When
		doReturn(null).when(repository).findAll();
		GenericResponse response = service.getAllExamples();

		//Then
		assertEquals(404, response.getStatus());
	}

	@Test
	void getExampleByID_isOk_thenReturnStatus200() {
		//Given
		ExampleEntity ex1 = new ExampleEntity("test1_h2@test.com", "password", "Test1", "H2_1", new Date());

		//When
		doReturn(ex1).when(repository).findExampleEntityById(ex1.getId());
		GenericResponse response = service.getExampleByID(ex1.getId());

		//Then
		assertEquals(200, response.getStatus());
	}

	@Test
	void getExampleByID_isNotOk_thenReturnStatus404() {
		//Given
		Integer id = 1;

		//When
		doReturn(null).when(repository).findExampleEntityById(id);
		GenericResponse response = service.getExampleByID(id);

		//Then
		assertEquals(404, response.getStatus());
	}

	@Test
	void postExample_isOk_thenReturnStatus200() {
		//Given
		ExamplePostInput exInput = new ExamplePostInput("Test1", "H2_1", "test1_h2@test.com", "password", "2020/09/30");
		ExampleEntity ex1 = new ExampleEntity("test1_h2@test.com", "password", "Test1", "H2_1", new Date());

		//When
		doReturn(ex1).when(repository).save(any());
		GenericResponse response = service.postExample(exInput);

		//Then
		assertEquals(201, response.getStatus());
	}

	@Test
	void postExample_isNotOk_thenReturnStatus500() {
		//Given
		ExamplePostInput exInput = new ExamplePostInput("Test1", "H2_1", "test1_h2@test.com", "password", "2020/09/30");

		//When
		doReturn(null).when(repository).save(any());
		GenericResponse response = service.postExample(exInput);

		//Then
		assertEquals(500, response.getStatus());
	}

	@Test
	void putExample_isOk_thenReturnStatus200() {
		//Given
		ExamplePutInput exInput = new ExamplePutInput(1, "Test1", "H2_1", "password", "2020/09/30");
		ExampleEntity ex1 = new ExampleEntity("test1_h2@test.com", "password", "Test1", "H2_1", new Date());

		//When
		doReturn(ex1).when(repository).findExampleEntityById(1);
		doReturn(ex1).when(repository).save(any());
		GenericResponse response = service.putExample(exInput);

		//Then
		assertEquals(201, response.getStatus());
	}

	@Test
	void putExample_isNotOk_thenReturnStatus500() {
		//Given
		ExamplePutInput exInput = new ExamplePutInput(1, "Test1", "H2_1", "password", "2020/09/30");
		ExampleEntity ex1 = new ExampleEntity("test1_h2@test.com", "password", "Test1", "H2_1", new Date());

		//When
		doReturn(ex1).when(repository).findExampleEntityById(1);
		doReturn(null).when(repository).save(any());
		GenericResponse response = service.putExample(exInput);

		//Then
		assertEquals(500, response.getStatus());
	}

	@Test
	void deleteExample_isOk_thenReturnStatus200() {
		//Given

		//When
		doNothing().when(repository).deleteById(any());
		GenericResponse response = service.deleteExample(1);

		//Then
		assertEquals(200, response.getStatus());
	}

	@Test
	void deleteExample_isNotOk_thenReturnStatus404() {
		//Given

		//When

		//Then
	}
}