package com.bytelius.backendarchetype.city.data.mapper;


import com.bytelius.backendarchetype.city.data.dto.CityClass;
import com.bytelius.backendarchetype.city.data.dto.input.NewCityInput;
import com.bytelius.backendarchetype.city.data.dto.input.UpdateCityInput;
import com.bytelius.backendarchetype.city.data.dto.output.CityOutput;
import com.bytelius.backendarchetype.city.data.dto.output.NewCityOutput;
import com.bytelius.backendarchetype.city.data.dto.output.UpdateCityOutput;
import com.bytelius.backendarchetype.city.data.entity.CityEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ICityMapper {

	/**
	 *
	 * @param data
	 * @return
	 */
	CityEntity cityClassToCityEntity(CityClass data);

	/**
	 *
	 * @param entity
	 * @return
	 */
	CityClass cityEntityToCityClass(CityEntity entity);

	/**
	 *
	 * @param dto
	 * @return
	 */
	CityClass newCityInputToCityClass(NewCityInput dto);

	/**
	 *
	 * @param dto
	 * @return
	 */
	CityClass updateCityInputToCityClass(UpdateCityInput dto);

	/**
	 *
	 * @param data
	 * @return
	 */
	CityOutput cityClassToCityOutput(CityClass data);

	/**
	 *
	 * @param data
	 * @return
	 */
	NewCityOutput cityClassToNewCityOutput(CityClass data);

	/**
	 *
	 * @param data
	 * @return
	 */
	UpdateCityOutput cityClassToUpdateCityOutput(CityClass data);
}
