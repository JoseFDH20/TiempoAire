package com.josedimash.tiempoaire.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.josedimash.tiempoaire.model.HistoricoVentaVO;

public interface HistoricoVentaRepository extends JpaRepository<HistoricoVentaVO, Integer> {

	@Query(value = "CALL SPOBTDETALLEVENTAXPERIODOTIEMPO(:PA_DIAINICIO, :PA_DIAFIN);", nativeQuery = true)
	List<HistoricoVentaVO> obtenerHistVentaXPeriodo(@Param("PA_DIAINICIO") String fechaInicial,
			@Param("PA_DIAFIN") String fechaFin);

}
