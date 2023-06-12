package com.josedimash.tiempoaire.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.josedimash.tiempoaire.model.CatalagoPaquetesVO;
import com.josedimash.tiempoaire.model.CatalagoTelefoniaVO;
import com.josedimash.tiempoaire.repository.PaquetesTelefoniaRepository;
import com.josedimash.tiempoaire.repository.ProveedoresRepository;
import com.josedimash.tiempoaire.repository.RegistrarCompraPaqueteRepository;

@Service
public class ProveedoresServiceImpl implements ProveedoresService {
	private static final Logger LOGGER = LogManager.getLogger(ProveedoresServiceImpl.class);

	@Autowired
	private ProveedoresRepository proveedoresRepository;
	
	@Autowired
	private PaquetesTelefoniaRepository paquetesTelefoniaRepository;
	
	@Autowired
	private RegistrarCompraPaqueteRepository registrarCompraPaqueteRepository;
	
	@Override
	public List<CatalagoTelefoniaVO> obtenerProveedoresTelefonias(){
		List<CatalagoTelefoniaVO> list = new ArrayList<>();
		
		try {
			list = proveedoresRepository.obtenerProveedoresTelefonias();
		} catch(Exception ex) {
			LOGGER.info(ex);
		}
		
		return list;
	}
	
	@Override
	public CatalagoTelefoniaVO obtenerURLWSProveedor(Integer idProveedor) {
		CatalagoTelefoniaVO item = new CatalagoTelefoniaVO();
		
		try {
			item = proveedoresRepository.obtenerURLWSProveedor(idProveedor);
		} catch(Exception ex) {
			LOGGER.info(ex);
		}
		
		return item;
	}
	
	@Override
	public List<CatalagoPaquetesVO> obtenerPaquetesTiempoAire() {
		List<CatalagoPaquetesVO> item = new ArrayList<>();
		
		try {
			item = paquetesTelefoniaRepository.obtenerPaquetes();
		} catch(Exception ex) {
			LOGGER.info(ex);
		}
		
		return item;
	}
	
	@Override
	public List<CatalagoPaquetesVO> obtenerPaquetesTiempoAire(Integer idProveedor) {
		List<CatalagoPaquetesVO> item = new ArrayList<>();
		
		try {
			item = paquetesTelefoniaRepository.obtenerPaquetes(idProveedor);
		} catch(Exception ex) {
			LOGGER.info(ex);
		}
		
		return item;
	}

	@Override
	public HashMap<String, Object> comprarTiempoAire(Integer idProveedor, Integer monto, Long telefono) {
		HashMap<String, Object> result = new HashMap<>();

		try {
			result = registrarCompraPaqueteRepository.comprarTiempoAire(idProveedor, monto, telefono);
		} catch (Exception ex) {
			result.put("code", -1);
			result.put("mensaje", "No se pudo realizar la compra");
			LOGGER.info(ex);
		}
		
		return result;
	}
	
}
