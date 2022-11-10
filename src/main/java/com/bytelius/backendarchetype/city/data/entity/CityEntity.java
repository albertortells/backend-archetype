package com.bytelius.backendarchetype.city.data.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 *
 */
@Entity
@Table(name = "city", schema = "world")
public class CityEntity {

	@Id
	@Column(name = "id", nullable = false, updatable = false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Getter @Setter	private Integer id;

	@Column(name = "name", nullable = false, length = 35)
	@Getter @Setter private String name;

	@Column(name = "country_code", nullable = false, length = 3)
	//@OneToOne(targetEntity = CountryEntity.class)
	@JoinColumn(name = "code")
	@Getter @Setter private String countryCode;

	@Column(name = "district", nullable = false, length = 20)
	@Getter @Setter private String district;

	@Column(name = "population", nullable = false)
	@Getter @Setter private Integer population;

	public CityEntity() { }

	public CityEntity(String name, String countryCode, String district, Integer population) {
		this.name = name;
		this.countryCode = countryCode;
		this.district = district;
		this.population = population;
	}
}
