package com.diego.ejercicioFinal.mensaje;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.diego.ejercicioFinal.usuario.UsuarioDAO;

@Controller
public class RutasMensaje {
	
	@Autowired
	private MensajeDAO mensajeDAO;
	
	
	@GetMapping("/mensajes")
	public ModelAndView mensajes() {
		
		ModelAndView vista = new ModelAndView();
		vista.setViewName("mensajes");
		
		vista.addObject("mensaje", new Mensaje());
		
		List<Mensaje> listaMensajes = (List<Mensaje>)mensajeDAO.findAll();
		vista.addObject("mensajes", listaMensajes);
		
		
		
		return vista;
	}
	
	
	@PostMapping("/mensajes/anadir")
	public String nuevoMensaje(@ModelAttribute Mensaje mensaje) {
		
		mensajeDAO.save(mensaje);
		
		return "redirect:/mensajes";
		
	}
	
	
	
	
	@GetMapping("mensajes/borrar/{id}")
	public String borrarMensaje(@PathVariable Long id) {
		
		mensajeDAO.deleteById(id);
		
		return "redirect:/mensajes";
		
	}

}
