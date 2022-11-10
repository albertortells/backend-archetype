package com.bytelius.backendarchetype.city.repository;

import com.bytelius.backendarchetype.city.data.entity.CityEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface ICityRepository extends JpaRepository<CityEntity, Integer> {

	List<CityEntity> findAll();

	CityEntity findCityEntityById(Integer data);

	@Modifying
	@Transactional
	@Query(value = "UPDATE city c SET c.population = ? WHERE c.id = ?", nativeQuery = true)
	int updatePopulationByID(Integer population, Integer id);

	@Modifying
	@Transactional
	@Query(value = "DELETE FROM city c WHERE c.id = ?", nativeQuery = true)
	int deleteCityById(Integer id);
}
