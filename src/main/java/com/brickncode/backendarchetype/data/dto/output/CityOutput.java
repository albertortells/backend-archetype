package com.brickncode.backendarchetype.data.dto.output;

import lombok.Getter;
import lombok.Setter;

public class CityOutput {

	@Getter @Setter private Integer id;

	@Getter @Setter private String name;

	public CityOutput() { }

	public CityOutput(Integer id, String name) {
		this.id = id;
		this.name = name;
	}
}
