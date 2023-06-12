package com.josedimash.tiempoaire.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

@Entity
public class TotalVentasPorProveedorVO {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer idrow;

	@Column
	private Integer fiidproveedor;

	@Column
	private String fcnombre;

	@Column
	private Integer ficantpaquetesvendidos;

	@Column
	private Integer fitotalventa;

	public TotalVentasPorProveedorVO() {
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
