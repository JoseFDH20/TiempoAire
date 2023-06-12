package com.josedimash.tiempoaire.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.josedimash.tiempoaire.model.HistoricoVentaVO;
import com.josedimash.tiempoaire.model.TotalVentasPorProveedorMontoVo;
import com.josedimash.tiempoaire.model.TotalVentasPorProveedorVO;
import com.josedimash.tiempoaire.repository.HistoricoVentaRepository;
import com.josedimash.tiempoaire.repository.TotalVentaCadaMontoVentaRepository;
import com.josedimash.tiempoaire.repository.TotalVentaCadaProveedorVentaRepository;
import com.josedimash.tiempoaire.util.Utilerias;

@Service
public class HistoricoVentaServiceImpl implements HistoricoVentaService {
	private static final Logger LOGGER = LogManager.getLogger(ProveedoresServiceImpl.class);

	@Autowired
	private HistoricoVentaRepository historicoVentaRepository;
	
	@Autowired
	private TotalVentaCadaProveedorVentaRepository totalVentaCadaProveedorVentaRepository;
	
	@Autowired
	private TotalVentaCadaMontoVentaRepository totalVentaCadaMontoVentaRepository;

	@Override
	public List<HistoricoVentaVO> obtenerHistVentaXPeriodo(String fechaInicial, String fechaFin) {
		List<HistoricoVentaVO> lista = null;

		try {
			lista = historicoVentaRepository.obtenerHistVentaXPeriodo(fechaInicial, fechaFin);
		} catch (Exception ex) {
			LOGGER.info(ex);
		}

		return lista;
	}

	@Override
	public List<TotalVentasPorProveedorVO> obtenerTotalVentaXProveedor() {
		List<TotalVentasPorProveedorVO> lista = null;

		try {
			lista = totalVentaCadaProveedorVentaRepository.obtenerTotalVentaXProveedor();
		} catch (Exception ex) {
			LOGGER.info(ex);
		}

		return lista;
	}

	@Override
	public List<TotalVentasPorProveedorMontoVo> obtenerTotalVentaXProveedorMonto() {
		List<TotalVentasPorProveedorMontoVo> lista = null;

		try {
			lista = totalVentaCadaMontoVentaRepository.obtenerTotalVentaXProveedorMonto();
		} catch (Exception ex) {
			LOGGER.info(ex);
		}

		return lista;
	}

}
