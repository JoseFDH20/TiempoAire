package com.josedimash.tiempoaire.controller;

import java.util.Date;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.josedimash.tiempoaire.model.GenericResponse;
import com.josedimash.tiempoaire.model.HistoricoVentaVO;
import com.josedimash.tiempoaire.model.TotalVentasPorProveedorMontoVo;
import com.josedimash.tiempoaire.model.TotalVentasPorProveedorVO;
import com.josedimash.tiempoaire.service.HistoricoVentaService;
import com.josedimash.tiempoaire.util.Constantes;
import com.josedimash.tiempoaire.util.Utilerias;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping(value = "/proveedores/reporteria")
@Tag(name = "Reporteria", description = "WS de Reporteria")
public class ReporteriaController {
	
	@Autowired
	private HistoricoVentaService historicoVentaService;
	
	@PostMapping("/ventasDelDia")
    @Operation(
            summary = "Obtiene las ventas realizadas por un periodo de tiempo",
            description = "Usar este endpoint para obtener las ventas realizadas por un periodo de tiempo, "
            		+ "si desea un solo día favor de colocarlo en ambos campos la misma fecha."
            		+ "Ambos parametros deben contener el siguiente formato YYYY-MM-DD."
            		+ "El último registro que devuelva este EndPoint es el total de la venta de dicho periodo"
    )
	public ResponseEntity<GenericResponse> obtenerHistVentaXPeriodo(@RequestParam String fechaInicial
											   , @RequestParam String fechaFin) {
		List<HistoricoVentaVO> lista = new ArrayList<>();
		
		Date feInicial = Utilerias.convertYYYYMMDD(fechaInicial);
		Date feFin = Utilerias.convertYYYYMMDD(fechaFin);
		if(feInicial==null || feFin==null) {
			//No cumple con el formato
			return ResponseEntity.badRequest().body(
                    GenericResponse.builder()
                            .api("reporteria/ventasDelDia")
                            .httpStatus(HttpStatus.BAD_REQUEST)
                            .backendStatus(Constantes.HTTP_BACKEND_CODE_BAD_REQUEST)
                            .mensaje("Por favor valide que las fechas cumplas con el siguiente formato YYYY-MM-DD.")
                            .data(lista)
                            .build()
            );
		}

		lista = historicoVentaService.obtenerHistVentaXPeriodo(fechaInicial, fechaFin);

		if(lista!=null) {
			return ResponseEntity.ok().body(
                    GenericResponse.builder()
                            .api("reporteria/ventasDelDia")
                            .httpStatus(HttpStatus.OK)
                            .backendStatus(Constantes.HTTP_BACKEND_CODE_OK)
                            .mensaje("Operación Exitosa")
                            .data(lista)
                            .build()
            );			
		} else {
			return ResponseEntity.badRequest().body(
                    GenericResponse.builder()
                            .api("reporteria/ventasDelDia")
                            .httpStatus(HttpStatus.BAD_REQUEST)
                            .backendStatus(Constantes.HTTP_BACKEND_CODE_BAD_REQUEST)
                            .mensaje("No se encontro información.")
                            .data(lista)
                            .build()
            );
		}
	}
	
	@PostMapping("/totalVentasPorProveedor")
    @Operation(
            summary = "Obtiene el total de ventas de cada proveedor del dia en curso",
            description = "Usar este endpoint para obtener el total de ventas de cada proveedor realizadas en el dia en curso"
    )
	public ResponseEntity<GenericResponse> totalVentasPorProveedor() {
		List<TotalVentasPorProveedorVO> lista = new ArrayList<>();

		lista = historicoVentaService.obtenerTotalVentaXProveedor();
		
		if(lista!=null) {
			return ResponseEntity.ok().body(
                    GenericResponse.builder()
                            .api("reporteria/totalVentasPorProveedor")
                            .httpStatus(HttpStatus.OK)
                            .backendStatus(Constantes.HTTP_BACKEND_CODE_OK)
                            .mensaje("Operación Exitosa")
                            .data(lista)
                            .build()
            );			
		} else {
			return ResponseEntity.badRequest().body(
                    GenericResponse.builder()
                            .api("reporteria/totalVentasPorProveedor")
                            .httpStatus(HttpStatus.BAD_REQUEST)
                            .backendStatus(Constantes.HTTP_BACKEND_CODE_BAD_REQUEST)
                            .mensaje("No se encontro información.")
                            .data(lista)
                            .build()
            );
		}
	}
	
	@PostMapping("/totalVentasPorProveedorMonto")
    @Operation(
            summary = "Obtiene el total de ventas por monto de cada proveedor del dia en curso",
            description = "Usar este endpoint para obtener el total de ventas por monto de cada proveedor en el día en curso"
    )
	public ResponseEntity<GenericResponse> totalVentasPorProveedorMonto() {
		List<TotalVentasPorProveedorMontoVo> lista = new ArrayList<>();

		lista = historicoVentaService.obtenerTotalVentaXProveedorMonto();

		if(lista!=null) {
			return ResponseEntity.ok().body(
                    GenericResponse.builder()
                            .api("reporteria/totalVentasPorProveedorMonto")
                            .httpStatus(HttpStatus.OK)
                            .backendStatus(Constantes.HTTP_BACKEND_CODE_OK)
                            .mensaje("Operación Exitosa")
                            .data(lista)
                            .build()
            );			
		} else {
			return ResponseEntity.badRequest().body(
                    GenericResponse.builder()
                            .api("reporteria/totalVentasPorProveedorMonto")
                            .httpStatus(HttpStatus.BAD_REQUEST)
                            .backendStatus(Constantes.HTTP_BACKEND_CODE_BAD_REQUEST)
                            .mensaje("No se encontro información.")
                            .data(lista)
                            .build()
            );
		}
	}

}
