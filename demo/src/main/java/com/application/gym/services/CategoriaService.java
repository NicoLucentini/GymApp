package com.application.gym.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.application.gym.dao.CategoriaRepository;
import com.application.gym.dtos.CategoriaDto;
import com.application.gym.entities.Categoria;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository categoriaDao;
	
	public CategoriaDto agregar(CategoriaDto dto) {
		Categoria cat = new Categoria();
		cat.setNombre(dto.getNombre());
		cat.setDescripcion(dto.getDescripcion());
		
		Categoria response =  categoriaDao.save(cat);
		
		return new CategoriaDto(response.getNombre(), response.getDescripcion());
	}
	
	public List<CategoriaDto> getAll(){
		
		List<Categoria> categorias = categoriaDao.findAll();
		
		List<CategoriaDto> categoriasResponse = new ArrayList<CategoriaDto>();
		
		for (Categoria cat : categorias) {
			categoriasResponse.add(new CategoriaDto(cat.getNombre(), cat.getDescripcion(), String.valueOf(cat.getId())));
		}
		return categoriasResponse;
	}
	
	public CategoriaDto remove(Long id) {
		Categoria cat = categoriaDao.getOne(id);
		CategoriaDto dto = new CategoriaDto(cat.getNombre(), cat.getDescripcion());
		categoriaDao.deleteById(id);
		return dto;
	}
}
