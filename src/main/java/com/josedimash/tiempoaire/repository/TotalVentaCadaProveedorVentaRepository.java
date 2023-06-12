package com.josedimash.tiempoaire.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.josedimash.tiempoaire.model.TotalVentasPorProveedorVO;

public interface TotalVentaCadaProveedorVentaRepository extends JpaRepository<TotalVentasPorProveedorVO, Integer> {

	@Query(value = "CALL SPOBTVENTASXPROVEEDORDELDIA();", nativeQuery = true)
	List<TotalVentasPorProveedorVO> obtenerTotalVentaXProveedor();

}
