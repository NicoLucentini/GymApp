package com.application.gym.controllers;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.application.gym.dtos.ClaseDto;
import com.application.gym.dtos.InscribirDtoRequest;
import com.application.gym.entities.Categoria;
import com.application.gym.entities.Clase;
import com.application.gym.services.ClaseService;


@CrossOrigin(origins= "http://localhost:4200")
@Controller
@RequestMapping("/clases")
public class ClaseController{
		
	@Autowired
	private ClaseService claseService;
	
	
	@PostMapping("/add")
	public ResponseEntity<Boolean> agregarClase(@RequestBody ClaseDto request) {
		
		return ResponseEntity.ok(claseService.agregarClase(request));
	}
	
	@GetMapping("/getAll")
	public ResponseEntity<List<Clase>> obtenerClases(){
		return ResponseEntity.ok(claseService.obtenerClases(1));		
	}
	
	@GetMapping("/eliminar/{id}")
	public ResponseEntity<String> eliminar(@PathVariable String id){
		if(claseService.eliminar(id))
			return ResponseEntity.ok("Clase eliminada");
		
		return ResponseEntity.ok("Fallo al eliminar clase");
	}
	
	@GetMapping("get/{id}")
	public String getClase(@PathVariable Integer id){
		System.out.println("getClase " + id);
		return "todo ok";
		//return new ClaseDto(new Date(), new Date(), new Profesor(), new Categoria(), 5);
		//return claseService.getClase(id);
	}
	
	@GetMapping("/holaMundo")
	public ResponseEntity<String> getHolaMundo()
	{
		System.out.println("holaMundo");
		return ResponseEntity.ok("hola mundo");
	}
	
	
	@PostMapping("/inscribir")
	public ResponseEntity<String> inscribir(@RequestBody InscribirDtoRequest request){
		if(claseService.inscribirAlumno(request.getIdClase(), request.getIdAlumno()))
				return ResponseEntity.ok("Inscripto");
		return ResponseEntity.ok("Fallo");
	}
	
	@PostMapping("/desinscribir")
	public ResponseEntity<String> desinscribirAlumno(@RequestBody InscribirDtoRequest request){
	 if(	claseService.desinscribirAlumno(request.getIdClase(), request.getIdAlumno()))
		 return ResponseEntity.ok("Desinscripto");
	return ResponseEntity.ok("Fallo");
	}
	

}
