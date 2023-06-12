package com.josedimash.tiempoaire.model;

public class CompraPaqueteRequestBody {
	private Integer idTelefonia;
	private Integer montoPaquete;
	private String telefono;
	
	public CompraPaqueteRequestBody() {
		super();
	}

	public Integer getIdTelefonia() {
		return idTelefonia;
	}

	public void setIdTelefonia(Integer idTelefonia) {
		this.idTelefonia = idTelefonia;
	}

	public Integer getMontoPaquete() {
		return montoPaquete;
	}

	public void setMontoPaquete(Integer montoPaquete) {
		this.montoPaquete = montoPaquete;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

}
