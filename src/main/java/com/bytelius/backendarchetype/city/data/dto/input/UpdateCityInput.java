package com.bytelius.backendarchetype.city.data.dto.input;

import lombok.Getter;
import lombok.Setter;

public class UpdateCityInput {

	@Getter @Setter private Integer id;

	@Getter @Setter private Integer population;

	public UpdateCityInput() {}

	public UpdateCityInput(Integer id, Integer population) {
		this.id = id;
		this.population = population;
	}
}
