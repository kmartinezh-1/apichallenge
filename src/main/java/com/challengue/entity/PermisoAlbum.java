package com.challengue.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.ManyToAny;

@Entity
@Table(name="PermisoAlbum")
public class PermisoAlbum implements Serializable{

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@Column
	Long idAlbum;
	
	@Column
	Long idUser;
		
	
	@ManyToMany
	Set<Permiso> permisos;

	public Long getIdUser() {
		return idUser;
	}

	public void setIdUser(Long idUser) {
		this.idUser = idUser;
	}

	public Long getIdAlbum() {
		return idAlbum;
	}

	public void setIdAlbum(Long idAlbum) {
		this.idAlbum = idAlbum;
	}
 

	public PermisoAlbum() {
		super();
		// TODO Auto-generated constructor stub
	}

 
	@Override
	public String toString() {
		return "PermisoAlbum [idUser=" + idUser + ", idAlbum=" + idAlbum + ", permiso=" + permisos + "]";
	}

	public Set<Permiso> getPermisos() {
		return permisos;
	}

	public void setPermisos(Set<Permiso> permisos) {
		this.permisos = permisos;
	}

	public PermisoAlbum(Long idAlbum, Long idUser, Set<Permiso> permisos) {
		super();
		this.idAlbum = idAlbum;
		this.idUser = idUser;
		this.permisos = permisos;
	}
	
	
	
}
