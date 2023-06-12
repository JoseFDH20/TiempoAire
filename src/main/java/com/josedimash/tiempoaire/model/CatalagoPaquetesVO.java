package com.josedimash.tiempoaire.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

@Entity
public class CatalagoPaquetesVO {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer idrow;
	
	@Column
	private Integer fiidproveedor;
	@Column
	private String fcnombre;
	@Column
	private Integer fimonto;
	@Column
	private String fcdescripcion;
	@Column
	private Integer fiestatus;

	public CatalagoPaquetesVO() {
		super();
	}

	public Integer getFiidproveedor() {
		return fiidproveedor;
	}

	public void setFiidproveedor(Integer fiidproveedor) {
		this.fiidproveedor = fiidproveedor;
	}

	public String getFcnombre() {
		return fcnombre;
	}

	public void setFcnombre(String fcnombre) {
		this.fcnombre = fcnombre;
	}

	public Integer getFimonto() {
		return fimonto;
	}

	public void setFimonto(Integer fimonto) {
		this.fimonto = fimonto;
	}

	public String getFcdescripcion() {
		return fcdescripcion;
	}

	public void setFcdescripcion(String fcdescripcion) {
		this.fcdescripcion = fcdescripcion;
	}

	public Integer getFiestatus() {
		return fiestatus;
	}

	public void setFiestatus(Integer fiestatus) {
		this.fiestatus = fiestatus;
	}

}
