package com.application.gym.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.application.gym.dao.CategoriaRepository;
import com.application.gym.dao.ClaseRepository;
import com.application.gym.dao.ClaseYAlumnoRepository;
import com.application.gym.dao.UsuarioRepository;
import com.application.gym.dtos.ClaseDto;
import com.application.gym.entities.Categoria;
import com.application.gym.entities.Clase;
import com.application.gym.entities.ClaseYAlumnos;
import com.application.gym.entities.Usuario;

@Service
public class ClaseService{

	
	
	@Autowired
	private CategoriaRepository categoriaDao;
	
	@Autowired
	private ClaseRepository claseDao;
	
	@Autowired
	private ClaseYAlumnoRepository claseYAlumnoDao;
	
	@Autowired
	private UsuarioRepository usuarioDao;
	public boolean agregarClase(ClaseDto request) {
		
		
		Long profId = new Long(request.getFk_profesor() );
		Long catId = new Long(request.getFk_categoria() );
		

		System.out.println(profId);
		
		Usuario prof = usuarioDao.findById(profId).get();
		if(prof == null)
			return false;
		Categoria cat = categoriaDao.findById(catId).get();
		if(cat == null)
			return false;
		
		Clase clase = new Clase();
		clase.setHorarioInicio(request.getHorarioInicio());
		clase.setHorarioFin(request.getHorarioFin());
		clase.setProfesor(prof);
		clase.setCategoria(cat);
		clase.setCantidadAlumnos(request.getCantidadAlumnos());
		
		
		claseDao.save(clase);
		
		return true;
	}
	
	public boolean eliminar(String id) {
		
		Clase clase = claseDao.findById(new Long(id)).get();
		List<ClaseYAlumnos> res =  claseYAlumnoDao.findByClase(clase);
		for (ClaseYAlumnos claseYAlumnos : res) {

			claseYAlumnoDao.deleteById(claseYAlumnos.getId());
		}
		claseDao.deleteById(new Long(id));
		return true;
	}
	
	
	public List<Clase> obtenerClases(Integer idGym){
		
		return  claseDao.findAll();
	}
	public ClaseDto getClase(Integer idClase){
		return null;
		//hacer algo..
	}
	public ClaseYAlumnos getClaseYAlumnos(Integer idClase){
		//hacer algo
		return null;
	}
	
	public boolean inscribirAlumno(String idClase, String idAlumno){
		
		Clase clase = claseDao.findById(new Long(idClase)).get();
		if(clase == null)
			return false;
		
		Usuario alumno = usuarioDao.findById(new Long(idAlumno)).get();
		if(alumno == null)
			return false;
		
		ClaseYAlumnos ca = new ClaseYAlumnos();
		ca.setFk_alumno(alumno);
		ca.setFk_clase(clase);
		
		claseYAlumnoDao.save(ca);
		return true;
		
	}
	public boolean desinscribirAlumno(String idClase, String idAlumno){		
		Clase clase = claseDao.findById(new Long(idClase)).get();
		if(clase == null)
			return false;
		
		Usuario alumno = usuarioDao.findById(new Long(idAlumno)).get();
		if(alumno == null)
			return false;
		
		List<ClaseYAlumnos> res = claseYAlumnoDao.findByClaseYAlumnos(alumno, clase);
		
		if(res == null || res.size() == 0 )
			return false;
		
		claseYAlumnoDao.deleteById(res.get(0).getId());
		return true;
		
	}
	
}
