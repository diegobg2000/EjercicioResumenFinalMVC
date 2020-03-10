package com.diego.ejercicioFinal.genericas;

import javax.servlet.http.HttpSession;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.diego.ejercicioFinal.carrito.Carrito;

@Controller
public class RutasGenericas {

	@GetMapping("/")
	public String principal(Authentication authentication) {
		
		
		return "principal.html";
	}
	
	
	@GetMapping("/login")
	public String seguridad(HttpSession session) {
		/*Le indicamos que lo que queremos guardar en la sesion es
		 * un objeto de tipo carrito*/
		session.setAttribute("carrito", new Carrito());
		System.out.println("ESTE ES EL MENU DE "
				+ "LOGIN QUE SE TIENE QUE ACTIVAR");
		
		return "signIn.html";
	}
	
	
	@GetMapping("/logout")
	public String finalizar(Authentication authentication) {
		
		return "ok";
	}
	
}
