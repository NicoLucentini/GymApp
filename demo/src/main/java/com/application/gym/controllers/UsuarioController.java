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

import com.application.gym.dtos.UsuarioDto;
import com.application.gym.services.UsuarioService;


@CrossOrigin(origins= "http://localhost:4200")
@Controller
@RequestMapping("/usuarios")
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;
	
	@PostMapping("/add")
	public ResponseEntity<UsuarioDto> registrar(@RequestBody UsuarioDto request){
		System.out.println("registrar alumno");
		return ResponseEntity.ok(usuarioService.add(request));
	}
	@GetMapping("/remove/{id}")
	public ResponseEntity<UsuarioDto> registar(@PathVariable String id){
		return ResponseEntity.ok(usuarioService.remove(id));
	}
	@GetMapping("/getAll")
	public ResponseEntity<List<UsuarioDto>> getAll(){
		return ResponseEntity.ok(usuarioService.getAll());
	}
	@GetMapping("/getProfesores")
	public ResponseEntity<List<UsuarioDto>> getProfesores(){
		return ResponseEntity.ok(usuarioService.getAllProfesores());
	}
	@GetMapping("/getAlumnos")
	public ResponseEntity<List<UsuarioDto>> getAlumnos(){
		return ResponseEntity.ok(usuarioService.getAllAlumnos());
	}
	@GetMapping("/getAdministradores")
	public ResponseEntity<List<UsuarioDto>> getAdministradores(){
		return ResponseEntity.ok(usuarioService.getAllAdministradores());
	}
	@PostMapping("/login")
	public ResponseEntity<UsuarioDto> login(@RequestBody UsuarioDto request){
		System.out.println("login usuario");
		return ResponseEntity.ok(usuarioService.login(request));
	}
}
