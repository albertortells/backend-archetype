package com.bytelius.backendarchetype.country.data.entity;

import com.bytelius.backendarchetype.country.data.entity.enums.Continent;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "country", schema = "world")
public class CountryEntity {

	@Id
	@Column(name = "code", nullable = false, updatable = false, length = 3)
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Getter @Setter private String code;

	@Column(name = "name", nullable = false, length = 52)
	@Getter @Setter private String name;

	@Column(name = "continent", nullable = false)
	@Getter @Setter private Continent continent;

	@Column(name = "region", nullable = false, length = 26)
	@Getter @Setter private String region;

	@Column(name = "surface_area", nullable = false)
	@Getter @Setter private Float surfaceArea;

	@Column(name = "indep_year", length = 6)
	@Getter @Setter private Integer indepYear;

	@Column(name = "population", nullable = false, length = 11)
	@Getter @Setter private Integer population;

	@Column(name = "life_expectancy")
	@Getter @Setter private Float lifeExpectancy;

	@Column(name = "gnp")
	@Getter @Setter private Float gnp;

	@Column(name = "gnp_old")
	@Getter @Setter private Float gnpOld;

	@Column(name = "local_name", nullable = false, length = 45)
	@Getter @Setter private String localName;

	@Column(name = "government_form", nullable = false, length = 45)
	@Getter @Setter private String governmentForm;

	@Column(name = "head_of_state", length = 60)
	@Getter @Setter private String headOfState;

	@Column(name = "capital", length = 11)
	@Getter @Setter private Integer capital;

	@Column(name = "code2", length = 2)
	@Getter @Setter private String code2;

	public CountryEntity() {}

	public CountryEntity(String code, String name, Continent continent, String region, Float surfaceArea,
	                     Integer indepYear, Integer population, Float lifeExpectancy, Float gnp, Float gnpOld,
	                     String localName, String governmentForm, String headOfState, Integer capital, String code2) {
		this.code = code;
		this.name = name;
		this.continent = continent;
		this.region = region;
		this.surfaceArea = surfaceArea;
		this.indepYear = indepYear;
		this.population = population;
		this.lifeExpectancy = lifeExpectancy;
		this.gnp = gnp;
		this.gnpOld = gnpOld;
		this.localName = localName;
		this.governmentForm = governmentForm;
		this.headOfState = headOfState;
		this.capital = capital;
		this.code2 = code2;
	}
}
