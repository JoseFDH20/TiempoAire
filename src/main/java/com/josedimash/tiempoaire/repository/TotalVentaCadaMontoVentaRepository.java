package com.josedimash.tiempoaire.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.josedimash.tiempoaire.model.TotalVentasPorProveedorMontoVo;

public interface TotalVentaCadaMontoVentaRepository extends JpaRepository<TotalVentasPorProveedorMontoVo, Integer> {

	@Query(value = "CALL SPOBTVENTASXPROVEEDORMONTODELDIA();", nativeQuery = true)
	List<TotalVentasPorProveedorMontoVo> obtenerTotalVentaXProveedorMonto();

}
