package com.application.gym.services;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.application.gym.dao.UsuarioRepository;
import com.application.gym.dtos.UsuarioDto;
import com.application.gym.entities.Usuario;

@Service
public class UsuarioService {

	@Autowired
	private ModelMapper mapper;
	
	@Autowired
	private UsuarioRepository usuarioDao;
	
	public UsuarioDto add(UsuarioDto dto)
	{
		List<Usuario> users = usuarioDao.findByEmail(dto.getEmail());
		if(!users.isEmpty())
			return null;
		Usuario usuario = mapper.map(dto, Usuario.class);
		Usuario response = usuarioDao.save(usuario);
		return mapper.map(response,UsuarioDto.class);
	}
	public UsuarioDto login(UsuarioDto dto)
	{
		List<Usuario> response = usuarioDao.findByEmailYPassword(dto.getEmail(), dto.getPassword());
		Usuario usuario = null;
		
		if(response.isEmpty())
			return null;
			
		usuario = response.get(0);
		return mapper.map(usuario,UsuarioDto.class);
	}
	public UsuarioDto remove(String id) {
		Usuario user = usuarioDao.findById(new Long(id)).get();
		 if(user == null)
			 return null;
		 
		 usuarioDao.delete(user);
		 return mapper.map(user, UsuarioDto.class);
	}
	public List<UsuarioDto> getAll(){		
		List<UsuarioDto> dtos = new ArrayList<UsuarioDto>();
		for (Usuario user : usuarioDao.findAll()) {
			dtos.add(mapper.map(user, UsuarioDto.class));
		}
		return dtos;
	}
	public List<UsuarioDto> getAllAlumnos(){		
		List<UsuarioDto> dtos = new ArrayList<UsuarioDto>();
		for (Usuario user : usuarioDao.findAllAlumnos()) {
			dtos.add(mapper.map(user, UsuarioDto.class));
		}
		return dtos;
	}
	public List<UsuarioDto> getAllProfesores(){		
		List<UsuarioDto> dtos = new ArrayList<UsuarioDto>();
		for (Usuario user : usuarioDao.findAllProfesores()) {
			dtos.add(mapper.map(user, UsuarioDto.class));
		}
		return dtos;
	}
	public List<UsuarioDto> getAllAdministradores(){		
		List<UsuarioDto> dtos = new ArrayList<UsuarioDto>();
		for (Usuario user : usuarioDao.findAllAdministradores()) {
			dtos.add(mapper.map(user, UsuarioDto.class));
		}
		return dtos;
	}
}
