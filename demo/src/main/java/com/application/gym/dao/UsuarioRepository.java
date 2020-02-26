package com.application.gym.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.application.gym.entities.Usuario;


public interface UsuarioRepository  extends JpaRepository<Usuario, Long>{
	
	@Query("SELECT t FROM Usuario t WHERE  nivel = 2")
    List<Usuario> findAllAlumnos();
	
	@Query("SELECT t FROM Usuario t WHERE  nivel = 1")
    List<Usuario> findAllProfesores();
	
	@Query("SELECT t FROM Usuario t WHERE  nivel = 0")
    List<Usuario> findAllAdministradores();
	
	@Query("SELECT t FROM Usuario t WHERE  email = ?1 and password = ?2")
    List<Usuario> findByEmailYPassword( @Param("email") String email , @Param("password") String password );
	
	@Query("SELECT t FROM Usuario t WHERE  email = ?1")
    List<Usuario> findByEmail (@Param("email") String email );
}
