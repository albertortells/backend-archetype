package com.bytelius.backendarchetype.city.data.dto.input;

import lombok.Getter;
import lombok.Setter;

public class NewCityInput {

	@Getter @Setter private String name;

	@Getter @Setter private String countryCode;

	@Getter @Setter private String district;

	@Getter @Setter private Integer population;

	public NewCityInput() { }

	public NewCityInput(String name, String countryCode, String district, Integer population) {
		this.name = name;
		this.countryCode = countryCode;
		this.district = district;
		this.population = population;
	}
}
