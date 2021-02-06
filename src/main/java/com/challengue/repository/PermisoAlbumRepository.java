package com.challengue.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.challengue.entity.PermisoAlbum;

public interface PermisoAlbumRepository extends CrudRepository<PermisoAlbum, Long> {

	@Query("SELECT a FROM PermisoAlbum a WHERE a.idUser=:idUser AND a.idAlbum=:idAlbum")
	public  PermisoAlbum findPermisoAlbumCompartidoByUserAlbum(@Param("idUser") Long idUser,
			@Param("idAlbum") Long idAlbum);
 

	@Query("SELECT a FROM PermisoAlbum a WHERE  a.idAlbum=:idAlbum")
	public  List<PermisoAlbum> findAllAlbumCompartidoByAlbum(@Param("idAlbum") Long idAlbum);
	
}
