package com.application.gym.controllers;

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

import com.application.gym.dtos.CategoriaDto;
import com.application.gym.services.CategoriaService;


@CrossOrigin(origins= "http://localhost:4200")
@Controller
@RequestMapping("categorias")
public class CategoriaController {

	@Autowired
	private CategoriaService categoriaService;
	
	
	@PostMapping("/add")
	public ResponseEntity<CategoriaDto> agregarProfesor(@RequestBody CategoriaDto request){		
		System.out.println("agregar Categoria");
		return ResponseEntity.ok(categoriaService.agregar(request));
	}
	
	@GetMapping("/getAll")
	public ResponseEntity<List<CategoriaDto>> obtenerTodos(){		
		System.out.println("obtenerTodos");
		return ResponseEntity.ok(categoriaService.getAll());
	}
	
	@GetMapping("/remove/{id}")
	public ResponseEntity<CategoriaDto> remove(@PathVariable Long id)
	{
		return ResponseEntity.ok(categoriaService.remove(id));
	}
}
