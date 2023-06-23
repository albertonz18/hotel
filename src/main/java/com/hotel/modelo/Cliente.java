package com.hotel.modelo;


public class Cliente {
	
	private Integer id;
	private String nombre;
	private String apellido;
	private String fNacimiento;
	private String correoCliente;
	
	
	
	public Cliente() {
		
	}

	public Cliente(Integer id, String nombre, String apellido, String fNacimiento, String correoCliente) {
		
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.fNacimiento = fNacimiento;
		this.correoCliente = correoCliente;
	}
	
	public Cliente(String nombre, String apellido, String fNacimiento, String correoCliente) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.fNacimiento = fNacimiento;
		this.correoCliente = correoCliente;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getfNacimiento() {
		return fNacimiento;
	}

	public void setfNacimiento(String fNacimiento) {
		this.fNacimiento = fNacimiento;
	}

	public String getCorreoCliente() {
		return correoCliente;
	}

	public void setCorreoCliente(String correoCliente) {
		this.correoCliente = correoCliente;
	}
	
		
}
