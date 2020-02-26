package com.application.gym.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.application.gym.entities.Clase;


public interface ClaseRepository extends JpaRepository<Clase, Long> {

}
