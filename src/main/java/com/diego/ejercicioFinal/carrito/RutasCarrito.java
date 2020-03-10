package com.diego.ejercicioFinal.carrito;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RutasCarrito {
	
	/*Una vez tenemos la sesion inciada modificamos nuestro objeto*/

	@GetMapping("/addCarrito")
	public String addCarrito(HttpSession session) {
		
		Carrito carrito = (Carrito) session.getAttribute("carrito");
		if(carrito!= null) {
			carrito.addProductos();
		}
		
		return "redirect:/";
	}
}
