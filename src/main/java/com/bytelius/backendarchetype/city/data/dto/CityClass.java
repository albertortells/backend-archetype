package com.bytelius.backendarchetype.city.data.dto;

import lombok.Getter;
import lombok.Setter;

public class CityClass {
	@Getter @Setter private Integer id;

	@Getter @Setter private String name;

	@Getter @Setter private String countryCode;

	@Getter @Setter private String district;

	@Getter @Setter private Integer population;

	public CityClass() {}

	public CityClass(Integer id, String name, String countryCode, String district, Integer population) {
		this.id = id;
		this.name = name;
		this.countryCode = countryCode;
		this.district = district;
		this.population = population;
	}
}
