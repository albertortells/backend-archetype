package com.brickncode.backendarchetype.data.dto.output;

import com.brickncode.backendarchetype.data.dto.CountryClass;
import com.brickncode.backendarchetype.data.entity.CountryEntity;
import lombok.Getter;
import lombok.Setter;

public class NewCityOutput {

	@Getter @Setter private Integer id;

	@Getter @Setter private String name;

	@Getter @Setter private String countryCode;

	@Getter @Setter private String district;

	@Getter @Setter private Integer population;

	public NewCityOutput() { }

	public NewCityOutput(Integer id, String name, String countryCode, String district, Integer population) {
		this.id = id;
		this.name = name;
		this.countryCode = countryCode;
		this.district = district;
		this.population = population;
	}
}
