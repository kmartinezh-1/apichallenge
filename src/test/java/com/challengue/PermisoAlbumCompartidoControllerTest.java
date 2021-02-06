package com.challengue;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Set;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.challengue.controller.PermisoAlbumController;
import com.challengue.entity.Permiso;
import com.challengue.entity.PermisoAlbum;
import com.challengue.repository.PermisoAlbumRepository;

import antlr.collections.List;

 
@SpringBootTest
public class PermisoAlbumCompartidoControllerTest {

	
	@Autowired
	private PermisoAlbumRepository repository;

	@Autowired
	private PermisoAlbumController controller;
	
	@Test
	public void savePermisoAlbumCompartido() {
		
		Permiso p1=new Permiso("ESCRITURA");
		Permiso p2=new Permiso("LECTURA");
		Set<Permiso> permisos=new HashSet<Permiso>();
		permisos.add(p1);
		permisos.add(p2);
		
		PermisoAlbum p = new PermisoAlbum(1L,1L,permisos);
		PermisoAlbum pr = repository.save(p);
		
		
		assertThat(p).isEqualTo(pr);
	}
	
	
	@Test
	public void getUsersByAlbumPermiso() {
		
		Permiso p1=new Permiso("ESCRITURA");
		Permiso p2=new Permiso("LECTURA");
		Set<Permiso> permisos=new HashSet<Permiso>();
		permisos.add(p1);
		permisos.add(p2);
		
		PermisoAlbum p = new PermisoAlbum(1L,1L,permisos);
		PermisoAlbum pr = repository.save(p);
		
		Set<Permiso> permisos2=new HashSet<Permiso>();
		permisos.add(p1);
	 
		
		PermisoAlbum pa2 = new PermisoAlbum(1L,2L,permisos);
		PermisoAlbum pra2 = repository.save(p);
		
		java.util.List<LinkedHashMap> usuarios=controller.getUsersByPermisoAlbum(1L,1L);
		
		
		assertThat(usuarios).hasSize(2);

	}
	
}
