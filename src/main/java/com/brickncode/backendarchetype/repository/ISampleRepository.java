package com.brickncode.backendarchetype.repository;

import com.brickncode.backendarchetype.data.entity.CityEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ISampleRepository extends JpaRepository<CityEntity, Integer> {

	List<CityEntity> findAll();

	CityEntity findCityEntityById(Integer data);
}
