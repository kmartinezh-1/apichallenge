package com.challengue.controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.challengue.entity.Permiso;
import com.challengue.entity.PermisoAlbum;
import com.challengue.repository.PermisoAlbumRepository;
import com.challengue.repository.PermisoRepository;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class PermisoAlbumController {

	@Autowired
	PermisoAlbumRepository permisoAlbumRepository;

	@Autowired
	PermisoRepository permisoRepository;

	@RequestMapping(value = "/savePermisoAlbumCompartido", method = RequestMethod.POST, params = { "idUser", "idAlbum",
			"idPermisos" })
	public void savePermisoAlbumCompartido(@RequestParam(value = "idUser") Long idUser,
			@RequestParam(value = "idAlbum") Long idAlbum, @RequestParam(value = "idPermisos") String idPermisos) {
		Set<Permiso> permisos = new HashSet<Permiso>();

		String[] listId = idPermisos.split(",");
		for (String id : listId) {
			Permiso permiso = permisoRepository.findById(Long.valueOf(id)).orElse(null);
			if (permiso != null) {
				permisos.add(permiso);
			}
		}
		permisoAlbumRepository.save(new PermisoAlbum(idAlbum, idUser, permisos));

	}

	@RequestMapping(value = "/updatePermisoAlbumCompartido", method = RequestMethod.POST, params = { "idUser",
			"idAlbum", "idPermisos" })
	public void updatePermisoAlbumCompartido(@RequestParam(value = "idUser") Long idUser,
			@RequestParam(value = "idAlbum") Long idAlbum, @RequestParam(value = "idPermisos") String idPermisos) {

		Set<Permiso> permisos = new HashSet<Permiso>();

		String[] listId = idPermisos.split(",");
		for (String id : listId) {
			Permiso permiso = permisoRepository.findById(Long.valueOf(id)).orElse(null);
			if (permiso != null) {
				permisos.add(permiso);
			}
		}

		PermisoAlbum permisosAlbumUser = permisoAlbumRepository.findPermisoAlbumCompartidoByUserAlbum(idUser, idAlbum);
		if (permisosAlbumUser != null) {
			permisosAlbumUser.setPermisos(permisos);
			permisoAlbumRepository.save(permisosAlbumUser);

		}

	}

	@RequestMapping(value = "/getAllPermisosAlbumsCompartidos", method = RequestMethod.POST)
	public Iterable<PermisoAlbum> getAllPermisosAlbumsCompartidos() {
		Iterable<PermisoAlbum> permisosAlbums = permisoAlbumRepository.findAll();

		return permisosAlbums;
	}

	@RequestMapping(value = "/getUsersByPermisoAlbum", method = RequestMethod.GET, params = { "idAlbum", "idPermiso" })
	public List<LinkedHashMap> getUsersByPermisoAlbum(@RequestParam(value = "idAlbum") Long idAlbum,
			@RequestParam(value = "idPermiso") Long idPermiso) {

		List<LinkedHashMap> listaUsuarios = new ArrayList<LinkedHashMap>();
		List<PermisoAlbum> listaPermisos = permisoAlbumRepository.findAllAlbumCompartidoByAlbum(idAlbum);

		Permiso permiso = permisoRepository.findById(idPermiso).orElse(null);

		List<PermisoAlbum> lista = listaPermisos.stream().filter(x -> x.getPermisos().contains(permiso))
				.collect(Collectors.toList());
	 

		for (PermisoAlbum p : lista) {
			Long idUser = p.getIdUser();

			LinkedHashMap usuario = APIFotosController.getUserById(idUser);

			listaUsuarios.add(usuario);

		}

	 
		return listaUsuarios;

	}
}
