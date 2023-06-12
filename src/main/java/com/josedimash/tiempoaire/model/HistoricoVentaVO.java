package com.josedimash.tiempoaire.model;

import java.util.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

@Entity
public class HistoricoVentaVO {
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
	private Date fdfechaventa;

	@Column
	private Integer fisemana;

	@Column
	private Integer fianio;

	public HistoricoVentaVO() {
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

	public Date getFdfechaventa() {
		return fdfechaventa;
	}

	public void setFdfechaventa(Date fdfechaventa) {
		this.fdfechaventa = fdfechaventa;
	}

	public Integer getFisemana() {
		return fisemana;
	}

	public void setFisemana(Integer fisemana) {
		this.fisemana = fisemana;
	}

	public Integer getFianio() {
		return fianio;
	}

	public void setFianio(Integer fianio) {
		this.fianio = fianio;
	}

}
