package com.application.gym.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.application.gym.entities.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long>{

}
