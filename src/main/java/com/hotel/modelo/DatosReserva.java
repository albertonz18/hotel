package com.hotel.modelo;



public class DatosReserva {
	
	private Integer id;
	private Integer cliente;
	private String fechaEntrada;
	private String fechaSalida;
	private String formaDePago;
	private Integer diasHospedaje;
	private Double costoHospedaje;
	private String nReservacion;
	
	
	
	public DatosReserva() {
		super();
	}

	public DatosReserva(Integer id, Integer cliente, String fechaEntrada, String fechaSalida, String formaDePago,
			Integer diasHospedaje, Double costoHospedaje, String nReservacion) {
		super();
		this.id = id;
		this.cliente = cliente;
		this.fechaEntrada = fechaEntrada;
		this.fechaSalida = fechaSalida;
		this.formaDePago = formaDePago;
		this.diasHospedaje = diasHospedaje;
		this.costoHospedaje = costoHospedaje;
		this.nReservacion = nReservacion;
	}

	public DatosReserva(Integer id, String fechaEntrada, String fechaSalida, String formaDePago, Integer diasHospedaje,
			Double costoHospedaje, String nReservacion) {
		super();
		this.id = id;
		this.fechaEntrada = fechaEntrada;
		this.fechaSalida = fechaSalida;
		this.formaDePago = formaDePago;
		this.diasHospedaje = diasHospedaje;
		this.costoHospedaje = costoHospedaje;
		this.nReservacion = nReservacion;
	}

	public DatosReserva(String fechaEntrada, String fechaSalida, String formaDePago, Integer diasHospedaje,
			Double costoHospedaje, String nReservacion) {
		super();
		this.fechaEntrada = fechaEntrada;
		this.fechaSalida = fechaSalida;
		this.formaDePago = formaDePago;
		this.diasHospedaje = diasHospedaje;
		this.costoHospedaje = costoHospedaje;
		this.nReservacion = nReservacion;
	}
	
	

	public Integer getCliente() {
		return cliente;
	}

	public void setCliente(Integer cliente) {
		this.cliente = cliente;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFechaEntrada() {
		return fechaEntrada;
	}

	public void setFechaEntrada(String fechaEntrada) {
		this.fechaEntrada = fechaEntrada;
	}

	public String getFechaSalida() {
		return fechaSalida;
	}

	public void setFechaSalida(String fechaSalida) {
		this.fechaSalida = fechaSalida;
	}

	public String getFormaDePago() {
		return formaDePago;
	}

	public void setFormaDePago(String formaDePago) {
		this.formaDePago = formaDePago;
	}

	public Integer getDiasHospedaje() {
		return diasHospedaje;
	}

	public void setDiasHospedaje(Integer diasHospedaje) {
		this.diasHospedaje = diasHospedaje;
	}

	public Double getCostoHospedaje() {
		return costoHospedaje;
	}

	public void setCostoHospedaje(Double costoHospedaje) {
		this.costoHospedaje = costoHospedaje;
	}

	public String getnReservacion() {
		return nReservacion;
	}

	public void setnReservacion(String nReservacion) {
		this.nReservacion = nReservacion;
	}
	
	
	
}
