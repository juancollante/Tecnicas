package com.centrocomercial.manejolocal.modelo;

public class Local {
	
	private String nombre;
	private String numero;
	private String tamaño;
	private String vendeComida;
	private String ventas;
	
	public Local(String nombre, String numero, String tamaño, String vendeComida, String ventas) {
		super();
		this.nombre = nombre;
		this.numero = numero;
		this.tamaño = tamaño;
		this.vendeComida = vendeComida;
		this.ventas = ventas;
	}
	
	

	public Local(String nombre, String tamaño, String vendeComida, String ventas) {
		super();
		this.nombre = nombre;
		this.tamaño = tamaño;
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

	public String getTamaño() {
		return tamaño;
	}

	public void setTamaño(String tamaño) {
		this.tamaño = tamaño;
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
