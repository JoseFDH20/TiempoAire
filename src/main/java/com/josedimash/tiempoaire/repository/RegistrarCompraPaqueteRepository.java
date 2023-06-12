package com.josedimash.tiempoaire.repository;

import java.util.Date;
import java.util.HashMap;
import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.josedimash.tiempoaire.service.ProveedoresServiceImpl;
import com.josedimash.tiempoaire.util.Utilerias;

@Repository
public class RegistrarCompraPaqueteRepository {
	private static final Logger LOGGER = LogManager.getLogger(RegistrarCompraPaqueteRepository.class);

	@PersistenceContext
	private EntityManager entityManager;

	public HashMap<String, Object> comprarTiempoAire(Integer idProveedor, Integer monto, Long telefono) {
		HashMap<String, Object> result = new HashMap<>();

		StoredProcedureQuery registrar = entityManager.createStoredProcedureQuery("SPCOMPRARTIEMPOAIRE");
		registrar.registerStoredProcedureParameter("PA_IDPROVEEDOR", Integer.class, ParameterMode.IN);
		registrar.registerStoredProcedureParameter("PA_MONTO", Integer.class, ParameterMode.IN);
		registrar.registerStoredProcedureParameter("PA_TELEFONO", Long.class, ParameterMode.IN);
		registrar.registerStoredProcedureParameter("PA_CODEERROR", Integer.class, ParameterMode.OUT);
		registrar.registerStoredProcedureParameter("PA_MENSAJE", String.class, ParameterMode.OUT);

		registrar.setParameter("PA_IDPROVEEDOR", idProveedor);
		registrar.setParameter("PA_MONTO", monto);
		registrar.setParameter("PA_TELEFONO", telefono);
		
		Integer codeError = (Integer) registrar.getOutputParameterValue("PA_CODEERROR");
		String mensajeQry = (String) registrar.getOutputParameterValue("PA_MENSAJE");

		if (codeError != 0) {
			//Falla
			result.put("code", codeError);
			result.put("mensaje", mensajeQry);
		} else {
			LOGGER.info("CompraRealizada Fecha de la Transacion: "+ Utilerias.formatYYYYMMDDHHmmss(new Date()) +", Telefono: "+ telefono);
			result.put("code", 0);
			result.put("mensaje", mensajeQry);
		}

		return result;
	}
}
