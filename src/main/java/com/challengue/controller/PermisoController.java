package com.challengue.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.challengue.repository.PermisoRepository;
import com.challengue.entity.Permiso;


@RestController
@RequestMapping("/api")
public class PermisoController {

	@Autowired
	PermisoRepository permisoRepository;
	
	
	@RequestMapping(value="/savePermiso", method=RequestMethod.GET, params={"descripcion"})
	public  void savePermiso(@RequestParam(value="descripcion") String descripcion)
	{
		permisoRepository.save(new Permiso(descripcion));
	
	}
	
	@RequestMapping(value="/getAllPermisos", method=RequestMethod.GET)
	public Iterable<Permiso> getAllTipoPermisos()
	{
		Iterable<Permiso> permisos= permisoRepository.findAll();
	
		return permisos;
	}
	
	@RequestMapping(value="/getPermisoById", method=RequestMethod.GET, params={"id"})
	public Permiso getPermisoById(@RequestParam(value="id") Long id)
	{
		Permiso permiso= permisoRepository.findById(id).orElse(null);
		 
		return permiso;
	}
	
	
}
