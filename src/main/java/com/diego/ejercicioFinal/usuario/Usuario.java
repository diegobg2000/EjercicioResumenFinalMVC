package com.diego.ejercicioFinal.usuario;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.diego.ejercicioFinal.mensaje.Mensaje;
import com.diego.ejercicioFinal.rol.Rol;

@Entity
@Table(name="usuarios")
public class Usuario implements UserDetails {
	/*Atributos*/
	@Id
	@Column
	private String usuario;

	@Column
	@Size(min=1, message="El nombre de usuario tiene que tener mas de 1 letra")
	@Size(min=10, message="El nombre de usuario tiene que tener menos de 10 letra")
	private String nombre;
	
	@Column
	private String contrasena;
	
	@Column
	private String apellidos;
	
	@Column 
	private String email;


	
	/*Relaciones entre tablas*/
	@ManyToOne
	private Rol rol = new Rol();
	
	@OneToMany(fetch=FetchType.EAGER, mappedBy = "usuarioMensaje")
	List<Mensaje> mensajes = new ArrayList<Mensaje>();
	
	
	
	/*Getters and Setters*/
	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Rol getRol() {
		return rol;
	}

	public void setRol(Rol rol) {
		this.rol = rol;
	}
	
	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	/*Metodos implementados de la clase UserDetails*/
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<GrantedAuthority> grantedAutorities = new ArrayList<>();
		grantedAutorities.add(new SimpleGrantedAuthority(rol.getCredencial()));
		
		return grantedAutorities;
		
	}



	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return this.usuario;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return this.contrasena;
	}
	
	
	
	
	
	
	

}
