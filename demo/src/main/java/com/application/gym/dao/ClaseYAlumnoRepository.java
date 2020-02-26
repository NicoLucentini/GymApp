package com.application.gym.dao;

import java.util.List;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.application.gym.entities.Usuario;
import com.application.gym.entities.Clase;
import com.application.gym.entities.ClaseYAlumnos;

@Repository
public interface ClaseYAlumnoRepository extends JpaRepository<ClaseYAlumnos, Long>{
	
	@Query("SELECT t FROM ClaseYAlumnos t WHERE fk_alumno = ?1 and fk_clase = ?2")
    List<ClaseYAlumnos> findByClaseYAlumnos(@Param("fk_alumno") Usuario fk_alumno, @Param("fk_clase") Clase fk_clase );
	
	@Query("SELECT t FROM ClaseYAlumnos t WHERE  fk_clase = ?1")
    List<ClaseYAlumnos> findByClase( @Param("fk_clase") Clase fk_clase );
	
	@Query("SELECT t FROM ClaseYAlumnos t WHERE  fk_alumno = ?1")
    List<ClaseYAlumnos> findByAlumno( @Param("fk_alumno") Usuario fk_alumno );
}
