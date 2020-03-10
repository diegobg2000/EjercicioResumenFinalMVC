package com.diego.ejercicioFinal.mensaje;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.diego.ejercicioFinal.usuario.Usuario;

@Entity
@Table(name="mensajes")
public class Mensaje {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column
	private String texto;

	
	/*RELACIONES ENTRE TABLAS*/
	@ManyToOne
	private Usuario usuarioMensaje = new Usuario();
	
	
	/*GETTERS & SETTERS*/

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Usuario getUsuarioMensaje() {
		return usuarioMensaje;
	}

	public void setUsuarioMensaje(Usuario usuarioMensaje) {
		this.usuarioMensaje = usuarioMensaje;
	}

	
	
	
	
	
	

}
