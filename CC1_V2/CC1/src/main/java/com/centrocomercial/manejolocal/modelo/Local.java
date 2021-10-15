package com.centrocomercial.manejolocal.modelo;

public class Local {
	
	private String nombre;
	private String numero;
	private String tama�o;
	private String vendeComida;
	private String ventas;
	
	public Local(String nombre, String numero, String tama�o, String vendeComida, String ventas) {
		super();
		this.nombre = nombre;
		this.numero = numero;
		this.tama�o = tama�o;
		this.vendeComida = vendeComida;
		this.ventas = ventas;
	}
	
	

	public Local(String nombre, String tama�o, String vendeComida, String ventas) {
		super();
		this.nombre = nombre;
		this.tama�o = tama�o;
		this.vendeComida = vendeComida;
		this.ventas = ventas;
	}



	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getTama�o() {
		return tama�o;
	}

	public void setTama�o(String tama�o) {
		this.tama�o = tama�o;
	}

	public String getVendeComida() {
		return vendeComida;
	}

	public void setVendeComida(String vendeComida) {
		this.vendeComida = vendeComida;
	}

	public String getVentas() {
		return ventas;
	}

	public void setVentas(String ventas) {
		this.ventas = ventas;
	}	
	
}
