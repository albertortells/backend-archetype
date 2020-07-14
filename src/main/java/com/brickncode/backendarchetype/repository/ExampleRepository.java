package com.brickncode.backendarchetype.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.brickncode.backendarchetype.data.entity.ExampleEntity;

import java.util.List;
import java.util.Optional;

@Repository
public interface ExampleRepository extends JpaRepository<ExampleEntity, Integer> {

	List<ExampleEntity> findAll();

	ExampleEntity findExampleEntityById(Integer id);
}
