package com.nokia.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nokia.entity.LifoEntity;

@Repository
public interface LifoRepository extends JpaRepository<LifoEntity, Integer> {

	LifoEntity findTopByOrderByIdDesc();

}
