package com.josedimash.tiempoaire.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.josedimash.tiempoaire.model.CatalagoPaquetesVO;

public interface PaquetesTelefoniaRepository extends JpaRepository<CatalagoPaquetesVO, Integer> {

	@Query(value = "CALL SPOBTPAQTIEMPOAIRE();", nativeQuery = true)
	List<CatalagoPaquetesVO> obtenerPaquetes();

	@Query(value = "CALL SPOBTPAQTIEMPOAIREXPROVEEDOR(:PA_IDPROVEEDOR);", nativeQuery = true)
	List<CatalagoPaquetesVO> obtenerPaquetes(@Param("PA_IDPROVEEDOR") Integer idProveedor);

}
