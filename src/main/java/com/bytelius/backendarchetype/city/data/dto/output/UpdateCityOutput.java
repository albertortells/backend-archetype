package com.bytelius.backendarchetype.city.data.dto.output;

import lombok.Getter;
import lombok.Setter;

public class UpdateCityOutput {

	@Getter @Setter private Integer id;

	@Getter @Setter private String name;

	@Getter @Setter private Integer population;

	public UpdateCityOutput() { }

	public UpdateCityOutput(Integer id, String name, Integer population) {
		this.id = id;
		this.name = name;
		this.population = population;
	}
}
