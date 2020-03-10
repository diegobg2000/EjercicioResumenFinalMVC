package com.diego.ejercicioFinal.usuario;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.diego.ejercicioFinal.Crypt.GeneradorCrypt;
import com.diego.ejercicioFinal.rol.Rol;
import com.diego.ejercicioFinal.rol.RolDAO;

@Controller
class UsuarioRutas {
	
	@Autowired
	private UsuarioDAO usuarioDAO;
	
	@Autowired
	private RolDAO rolDAO;
	
	
	@Autowired
	private GeneradorCrypt generadorCrypt;
	
	
		
			
	@GetMapping("/usuarios")
	public ModelAndView usuarios() {
		ModelAndView model = new ModelAndView();
		
		model.setViewName("usuarios");
		
		model.addObject("usuario", new Usuario());
		
		List<Usuario> listaUsuarios = (List<Usuario>)usuarioDAO.findAll();
		model.addObject("usuarios", listaUsuarios);	
		
		
		model.addObject("rol", new Rol());
		
		List<Rol> listaRoles = (List<Rol>)rolDAO.findAll();
		model.addObject("roles", listaRoles);
		
		
		return model;		
	}
	

	
	@PostMapping("/usuarios/anadir")
	public String nuevoUsuario(@ModelAttribute Usuario usuario,
								Error errores) {
		//if(errores.hasErrors()) {
		usuario.setContrasena(generadorCrypt.encriptador().encode(usuario.getContrasena()));
	
		//}
		usuarioDAO.save(usuario);
		
		
		return "redirect:/usuarios";
	}
	
	
	
	@GetMapping("/usuarios/eliminar/{usuario}")
	public String eleiminarUsuario(@PathVariable String usuario) {
	
		usuarioDAO.deleteById(usuario);
			
		return "redirect:/usuarios";
	}
	


}
