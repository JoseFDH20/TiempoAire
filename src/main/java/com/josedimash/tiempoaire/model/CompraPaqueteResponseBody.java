package com.josedimash.tiempoaire.model;

public class CompraPaqueteResponseBody {
	private Integer status;
	private String mensaje;
	
	public CompraPaqueteResponseBody() {
		super();
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
