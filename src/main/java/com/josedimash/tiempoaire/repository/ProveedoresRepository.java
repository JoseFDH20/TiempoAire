package com.josedimash.tiempoaire.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.josedimash.tiempoaire.model.CatalagoTelefoniaVO;

@Repository
public interface ProveedoresRepository extends JpaRepository<CatalagoTelefoniaVO, Integer> {
	
	//@Procedure(procedureName ="SPOBTENERPROVEEDORES")
	@Query(value = "CALL SPOBTENERPROVEEDORES();", nativeQuery = true)
	List<CatalagoTelefoniaVO> obtenerProveedoresTelefonias();
	
	//@Procedure(procedureName ="SPOBTENERWSPROVEEDOR")
	@Query(value = "CALL SPOBTENERWSPROVEEDOR(:PA_IDPROVEEDOR);", nativeQuery = true)
	CatalagoTelefoniaVO obtenerURLWSProveedor(@Param("PA_IDPROVEEDOR") Integer idProveedor);
	
	
}
