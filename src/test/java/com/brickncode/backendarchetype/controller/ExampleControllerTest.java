package com.brickncode.backendarchetype.controller;

import com.brickncode.backendarchetype.common.GenericResponse;
import com.brickncode.backendarchetype.common.URLConstant;
import com.brickncode.backendarchetype.data.model.Example;
import com.brickncode.backendarchetype.data.model.input.ExamplePostInput;
import com.brickncode.backendarchetype.data.model.output.ExamplePostOutput;
import com.brickncode.backendarchetype.service.interfaces.ExampleService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.Date;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class ExampleControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private ExampleService service;

	@Test
	void getAllExamples_hasData_thenReturnStatus200() throws Exception {
		//Given
		String uri = "/backend-archetype" + URLConstant.EXAMPLE + URLConstant.GETALL;

		Example ex1 = new Example(1, "mail@mail.com", "password", "name", "surname", new Date());
		Example ex2 = new Example(2, "mail2@mail.com", "password2", "name2", "surname2", new Date());
		GenericResponse response = new GenericResponse(200,"OK", Arrays.asList(ex1, ex2));
		doReturn(response).when(service).getAllExamples();

		//When
		mockMvc.perform(get(uri))

		//Then
			.andExpect(status().isOk())
			.andExpect(content().contentType(MediaType.APPLICATION_JSON))
			.andExpect(jsonPath("$.status", is(200)))
			.andExpect(jsonPath("$.data", is(hasSize(2))));
	}

	@Test
	void getAllExamples_hasNotData_thenReturnStatus404() throws Exception {
		//Given
		String uri = "/backend-archetype" + URLConstant.EXAMPLE + URLConstant.GETALL;

		GenericResponse response = new GenericResponse(404,"NOK");
		doReturn(response).when(service).getAllExamples();

		//When
		mockMvc.perform(get(uri))

		//Then
			.andExpect(status().isOk())
			.andExpect(content().contentType(MediaType.APPLICATION_JSON))
			.andExpect(jsonPath("$.status", is(404)));
	}

	@Test
	void getOneExampleByID_hasData_thenReturnStatus200() throws Exception {
		//Given
		String uri = "/backend-archetype" + URLConstant.EXAMPLE + URLConstant.GETONE + URLConstant.ID_VARIABLE;

		Example ex1 = new Example(1, "mail@mail.com", "password", "name", "surname", new Date());
		GenericResponse response = new GenericResponse(200,"OK", ex1);
		doReturn(response).when(service).getExampleByID(1);

		//When
		mockMvc.perform(get(uri, 1))

		//Then
			.andExpect(status().isOk())
			.andExpect(content().contentType(MediaType.APPLICATION_JSON))
			.andExpect(jsonPath("$.status", is(200)));
	}

	@Test
	void getOneExampleByID_whenInvalidId_thenReturnStatus400() throws Exception {
		//Given
		String uri = "/backend-archetype" + URLConstant.EXAMPLE + URLConstant.GETONE + URLConstant.ID_VARIABLE;

		GenericResponse response = new GenericResponse(400,"NOK");
		doReturn(response).when(service).getExampleByID(null);

		//When
		mockMvc.perform(get(uri, -1))

		//Then
			.andExpect(status().isOk())
			.andExpect(content().contentType(MediaType.APPLICATION_JSON))
			.andExpect(jsonPath("$.status", is(400)));
	}

	@Test
	void postExample_whenValidInput_thenReturnStatus201() throws Exception {
		//Given
		//String uri = "/backend-archetype" + URLConstant.EXAMPLE + URLConstant.POST;

		//ExamplePostInput input = new ExamplePostInput("name", "surname", "mail", "password", "2020/09/30");
		//ExamplePostOutput output = new ExamplePostOutput(1,"name", "mail");
		//GenericResponse response = new GenericResponse(201, "OK", output);
		//doReturn(response).when(service).postExample(any());

		//When
		//mockMvc.perform(post(uri)
			//.contentType(MediaType.APPLICATION_JSON)
			//.content(asJsonString(input)))

		//Then
			//.andExpect(status().isOk())
			//.andExpect(content().contentType(MediaType.APPLICATION_JSON))
			//.andExpect(jsonPath("$.status", is(201)));
	}

	@Test
	void putExample() {
		//Given

		//When

		//Then
	}

	@Test
	void deleteExample() {
		//Given

		//When

		//Then
	}

	static String asJsonString(final Object obj) {
		try {
			return new ObjectMapper().writeValueAsString(obj);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}