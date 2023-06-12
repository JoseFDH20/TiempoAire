package com.josedimash.tiempoaire.model;

public class MensajeCompraResponse {

	private Integer status;
	private String mensaje;

	public MensajeCompraResponse() {
		super();
	}

	public MensajeCompraResponse(Integer status, String mensaje) {
		this.status = status;
		this.mensaje = mensaje;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

}
