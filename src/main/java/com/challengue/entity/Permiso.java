package com.challengue.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Permiso")
public class Permiso implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@Column
	private String descripcion;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	 
 
	public Permiso() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Permiso(Long id, String descripcion) {
		super();
		this.id = id;
		this.descripcion = descripcion;
	}
	public Permiso(String descripcion2) {
		this.descripcion = descripcion2;
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Permiso [id=" + id + ", descripcion=" + descripcion + "]";
	}
	
}
