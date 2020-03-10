package com.diego.ejercicioFinal.carrito;

public class Carrito {

	private int productos = 0;

	
	
	
	/*GETTERS & SETTERS*/

	public int getProductos() {
		return productos;
	}

	/*Como no vamos a asignarle valores al atributo de este objeto sino
	 * que neceistamos sumar el metodo que requerimos un "add" no un "set"*/
	
	public void addProductos() {
		
		productos ++;
	}
}
