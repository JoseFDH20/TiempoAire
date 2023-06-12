package com.josedimash.tiempoaire.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

@Entity
public class TotalVentasPorProveedorMontoVo {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer idrow;

	@Column
	private Integer fiidproveedor;

	@Column
	private String fcnombre;

	@Column
	private Integer fipaquete;

	@Column
	private Integer ficantpaquetesvendidos;

	@Column
	private Integer fitotalventa;

	public TotalVentasPorProveedorMontoVo() {
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

	public Integer getFipaquete() {
		return fipaquete;
	}

	public void setFipaquete(Integer fipaquete) {
		this.fipaquete = fipaquete;
	}

	public Integer getFicantpaquetesvendidos() {
		return ficantpaquetesvendidos;
	}

	public void setFicantpaquetesvendidos(Integer ficantpaquetesvendidos) {
		this.ficantpaquetesvendidos = ficantpaquetesvendidos;
	}

	public Integer getFitotalventa() {
		return fitotalventa;
	}

	public void setFitotalventa(Integer fitotalventa) {
		this.fitotalventa = fitotalventa;
	}

}
