package com.josedimash.tiempoaire.service;

import java.util.List;

import com.josedimash.tiempoaire.model.HistoricoVentaVO;
import com.josedimash.tiempoaire.model.TotalVentasPorProveedorMontoVo;
import com.josedimash.tiempoaire.model.TotalVentasPorProveedorVO;

public interface HistoricoVentaService {
	
	List<HistoricoVentaVO> obtenerHistVentaXPeriodo(String fechaInicial, String fechaFin);
	
	List<TotalVentasPorProveedorVO> obtenerTotalVentaXProveedor();

	List<TotalVentasPorProveedorMontoVo> obtenerTotalVentaXProveedorMonto();

}
