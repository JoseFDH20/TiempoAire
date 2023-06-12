package com.josedimash.tiempoaire.service;

import java.util.HashMap;
import java.util.List;

import com.josedimash.tiempoaire.model.CatalagoPaquetesVO;
import com.josedimash.tiempoaire.model.CatalagoTelefoniaVO;

public interface ProveedoresService {

	List<CatalagoTelefoniaVO> obtenerProveedoresTelefonias();

	CatalagoTelefoniaVO obtenerURLWSProveedor(Integer idProveedor);

	List<CatalagoPaquetesVO> obtenerPaquetesTiempoAire();

	List<CatalagoPaquetesVO> obtenerPaquetesTiempoAire(Integer idProveedor);

	HashMap<String, Object> comprarTiempoAire(Integer idProveedor, Integer monto, Long telefono);

}
