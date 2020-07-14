package com.brickncode.backendarchetype.data.mapper;

import com.brickncode.backendarchetype.data.entity.ExampleEntity;
import com.brickncode.backendarchetype.data.model.Example;
import com.brickncode.backendarchetype.data.model.input.ExamplePutInput;
import com.brickncode.backendarchetype.data.model.input.ExamplePostInput;
import com.brickncode.backendarchetype.data.model.output.ExampleGetOutput;
import com.brickncode.backendarchetype.data.model.output.ExamplePostOutput;
import com.brickncode.backendarchetype.data.model.output.ExamplePutOutput;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ExampleMapper {

	/**
	 * Method for parse a pojo object from front app to entity for database can understand the intel and do whatever needs
	 * @param pojo - object that comes from front app
	 * @return ExampleEntity
	 */
	ExampleEntity exampleToExampleEntity(Example pojo);

	/**
	 * Method for parse a entity object to front object to manipulate and send it safely to the front
	 * @param entity - object that comes from database
	 * @return Example
	 */
	Example exampleEntityToExample(ExampleEntity entity);

	/**
	 * Method for parse a complete object pojo to a minimized object for front app
	 * @param pojo - object that comes from database which is parsed a back object
	 * @return ExampleGetOutput
	 */
	ExampleGetOutput exampleToExampleGetOutput(Example pojo);

	/**
	 * Method for parse a complete object pojo to a minimized object for front app
	 * @param pojo - object that comes from database which is parsed a back object
	 * @return ExamplePutOutput
	 */
	ExamplePutOutput exampleToExamplePutOutput(Example pojo);

	/**
	 * Method for parse a minimized object to a complete pojo object for database can understand the information
	 * @param obj - object that comes from front app
	 * @return Example
	 */
	Example examplePostInputToExample(ExamplePostInput obj);

	/**
	 *
	 * @param pojo - object that comes from database which is parsed a back object
	 * @return ExamplePostOutput
	 */
	ExamplePostOutput exampleToExamplePostOutput(Example pojo);

	/**
	 *
	 * @param obj - object that comes from front app
	 * @return Example
	 */
	Example examplePutInputToExample(ExamplePutInput obj);
}
