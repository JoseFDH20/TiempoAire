package com.josedimash.tiempoaire.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

@Entity
public class CatalagoTelefoniaVO {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer idrow;
	
	@Column
	private Integer fiidproveedor;
	@Column
	private String fcnombre;
	@Column
	private String fcurlwscomprapaq;
	@Column
	private Integer fiestatus;
//	@Column
	private Date fdfechaalta;

	public CatalagoTelefoniaVO() {
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

	public String getFcurlwscomprapaq() {
		return fcurlwscomprapaq;
	}

	public void setFcurlwscomprapaq(String fcurlwscomprapaq) {
		this.fcurlwscomprapaq = fcurlwscomprapaq;
	}

	public Integer getFiestatus() {
		return fiestatus;
	}

	public void setFiestatus(Integer fiestatus) {
		this.fiestatus = fiestatus;
	}

	public Date getFdfechaalta() {
		return fdfechaalta;
	}

	public void setFdfechaalta(Date fdfechaalta) {
		this.fdfechaalta = fdfechaalta;
	}

}
