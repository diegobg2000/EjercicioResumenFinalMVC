package com.diego.ejercicioFinal.rol;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.diego.ejercicioFinal.usuario.Usuario;

@Entity
@Table(name="rol")
public class Rol {

	@Id
	@Column
	private String credencial;
	
	/*Relaciones entre tablas*/
	@OneToMany(fetch=FetchType.EAGER, mappedBy = "rol")
	private List<Usuario> usuarios = new ArrayList<Usuario>();
	
		
	/*Getter & Setters*/
	public String getCredencial() {
		return credencial;
	}

	public void setCredencial(String credencial) {
		this.credencial = credencial;
	}

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}
	
	
}
