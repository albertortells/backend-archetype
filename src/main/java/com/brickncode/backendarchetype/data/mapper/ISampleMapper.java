package com.brickncode.backendarchetype.data.mapper;

import com.brickncode.backendarchetype.data.dto.CityClass;
import com.brickncode.backendarchetype.data.dto.input.NewCityInput;
import com.brickncode.backendarchetype.data.dto.input.UpdateCityInput;
import com.brickncode.backendarchetype.data.dto.output.CityOutput;
import com.brickncode.backendarchetype.data.dto.output.NewCityOutput;
import com.brickncode.backendarchetype.data.entity.CityEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ISampleMapper {

	CityEntity cityClassToCityEntity(CityClass data);

	CityClass cityEntityToCityClass(CityEntity entity);

	CityClass newCityInputToCityClass(NewCityInput dto);

	CityClass updateCityInputToCityClass(UpdateCityInput dto);

	CityOutput cityClassToCityOutput(CityClass data);

	NewCityOutput cityClassToNewCityOutput(CityClass data);
}
