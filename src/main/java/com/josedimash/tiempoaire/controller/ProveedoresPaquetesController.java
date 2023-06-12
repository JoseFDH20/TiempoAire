package com.josedimash.tiempoaire.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.josedimash.tiempoaire.WSExternos.ServicioCompraTiempoAire;
import com.josedimash.tiempoaire.model.CatalagoPaquetesVO;
import com.josedimash.tiempoaire.model.CatalagoTelefoniaVO;
import com.josedimash.tiempoaire.model.CompraPaqueteRequestBody;
import com.josedimash.tiempoaire.model.GenericResponse;
import com.josedimash.tiempoaire.model.MensajeCompraResponse;
import com.josedimash.tiempoaire.service.ProveedoresService;
import com.josedimash.tiempoaire.util.Constantes;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping(value = "/proveedores")
@Tag(name = "Paquetes de Tiempo Aire", description = "WS para obtener todo lo relacionado a paquetes de Tiempo aire")
public class ProveedoresPaquetesController {
	
	@Autowired
	private ProveedoresService proveedoresService;
	
	@PostMapping("/obtenerCatalagoTelefonia")
    @Operation(
            summary = "Obtiene el catalago de proveedores de paquetes",
            description = "Usar este endpoint para obtener los proveedores registrados"
    )
	public ResponseEntity<GenericResponse> obtenerCatalagoTelefonias() {
		
		List<CatalagoTelefoniaVO> lista =  proveedoresService.obtenerProveedoresTelefonias();
		if(lista!=null) {
			return ResponseEntity.ok().body(
                    GenericResponse.builder()
                            .api("obtenerCatalagoTelefonia")
                            .httpStatus(HttpStatus.OK)
                            .backendStatus(Constantes.HTTP_BACKEND_CODE_OK)
                            .mensaje("Operación Exitosa")
                            .data(lista)
                            .build()
            );			
		} else {
			return ResponseEntity.badRequest().body(
                    GenericResponse.builder()
                            .api("obtenerCatalagoTelefonia")
                            .httpStatus(HttpStatus.BAD_REQUEST)
                            .backendStatus(Constantes.HTTP_BACKEND_CODE_BAD_REQUEST)
                            .mensaje("No se encontro información.")
                            .detalle("")
                            .build()
            );
		}
	}
	
	@PostMapping("/obtenerURLWSProveedor")
    @Operation(
            summary = "Obtiene la URL del servicio de compra de un proveedor",
            description = "Usar este endpointURL para obtener la URL del servicio de compra de un proveedor"
    )
	public ResponseEntity<GenericResponse> obtenerURLWSProveedor(@NonNull @RequestParam Integer idProveedor) {
		HashMap<String, String> item = new HashMap<>();
		CatalagoTelefoniaVO dataWS = proveedoresService.obtenerURLWSProveedor(idProveedor);
		
		if(dataWS!=null) {
			item.put("urlWSCompra", dataWS.getFcurlwscomprapaq());
			return ResponseEntity.ok().body(
                    GenericResponse.builder()
                            .api("obtenerURLWSProveedor")
                            .httpStatus(HttpStatus.OK)
                            .backendStatus(Constantes.HTTP_BACKEND_CODE_OK)
                            .mensaje("Operación Exitosa")
                            .data(item)
                            .build()
            );			
		} else {
			item.put("urlWSCompra", "No se encontró URL");
			return ResponseEntity.badRequest().body(
                    GenericResponse.builder()
                            .api("obtenerURLWSProveedor")
                            .httpStatus(HttpStatus.BAD_REQUEST)
                            .backendStatus(Constantes.HTTP_BACKEND_CODE_BAD_REQUEST)
                            .mensaje("No se encontro información.")
                            .data(item)
                            .build()
            );
		}
	}
	
	@PostMapping("/obtenerPaquetesTiempoAire")
    @Operation(
            summary = "Obtiene los paquetes de tiempo aire de los proveedores",
            description = "Usar este endpoint para obtener una lista de los paquetes que manejan cada proveedor"
    )
	public ResponseEntity<GenericResponse> obtenerPaquetesTiempoAire(@RequestParam(required = false) Integer idProveedor) {
		List<CatalagoPaquetesVO> item = new ArrayList<>();
		
		if(idProveedor==null) {
			item = proveedoresService.obtenerPaquetesTiempoAire();
		}
		else {
			item = proveedoresService.obtenerPaquetesTiempoAire(idProveedor);
		}

		if(item!=null) {
			return ResponseEntity.ok().body(
                    GenericResponse.builder()
                            .api("obtenerPaquetesTiempoAire")
                            .httpStatus(HttpStatus.OK)
                            .backendStatus(Constantes.HTTP_BACKEND_CODE_OK)
                            .mensaje("Operación Exitosa")
                            .data(item)
                            .build()
            );			
		} else {
			return ResponseEntity.badRequest().body(
                    GenericResponse.builder()
                            .api("obtenerCatalagoTelefonia")
                            .httpStatus(HttpStatus.BAD_REQUEST)
                            .backendStatus(Constantes.HTTP_BACKEND_CODE_BAD_REQUEST)
                            .mensaje("No se encontro información.")
                            .data(item)
                            .build()
            );
		}
	}
	
	@PostMapping("/comprarPaquete")
    @Operation(
            summary = "Para realizar una compra de tiempo aire",
            description = "Usar este endpoint para realizar una compra de tiempo aire.\n"
            		+ "Internamente se obtendra la URL del proveedor y se realizara la peticion."
    )
	public ResponseEntity<GenericResponse> comprarPaquete(@NonNull @RequestBody CompraPaqueteRequestBody requestBody) {
		MensajeCompraResponse mensajeResponse = new MensajeCompraResponse();
		CatalagoTelefoniaVO proveedorData = proveedoresService.obtenerURLWSProveedor(requestBody.getIdTelefonia());
		if(proveedorData==null) {
			//Retornamos mensaje que el proveedor no esta disponible.
			//Porque no esta registrado en el catalago o no se encuentra activo en el catalago
			return ResponseEntity.badRequest().body(
                    GenericResponse.builder()
                            .api("comprarPaquete")
                            .httpStatus(HttpStatus.BAD_REQUEST)
                            .backendStatus(Constantes.HTTP_BACKEND_CODE_BAD_REQUEST)
                            .mensaje("No se encontro el proveedor con identificador: "+ requestBody.getIdTelefonia())
                            .build()
            );
		}
		
		try {
			mensajeResponse = ServicioCompraTiempoAire.sendGet(proveedorData.getFcurlwscomprapaq(), requestBody);
			if(mensajeResponse!=null) {
				return ResponseEntity.ok().body(
	                    GenericResponse.builder()
	                            .api("comprarPaquete")
	                            .httpStatus(HttpStatus.OK)
	                            .backendStatus(Constantes.HTTP_BACKEND_CODE_OK)
	                            .mensaje("Operación Exitosa")//Esto se refiere a que el WSExterno se ejecuto sin problema
	                            .data(mensajeResponse)
	                            .build()
	            );
			} else {
				return ResponseEntity.badRequest().body(
	                    GenericResponse.builder()
	                            .api("comprarPaquete")
	                            .httpStatus(HttpStatus.BAD_REQUEST)
	                            .backendStatus(Constantes.HTTP_BACKEND_CODE_BAD_REQUEST)
	                            .mensaje("No se logro realizar la compra, IDProveedor: "+ requestBody.getIdTelefonia())
	                            .build()
	            );
			}
		} catch (Exception e) {
			//No se logro hacer la compra
			e.printStackTrace();
			return ResponseEntity.badRequest().body(
                    GenericResponse.builder()
                            .api("comprarPaquete")
                            .httpStatus(HttpStatus.BAD_REQUEST)
                            .backendStatus(Constantes.HTTP_BACKEND_CODE_BAD_REQUEST)
                            .mensaje("El servicio del proveedor (IDProveedor: "+ requestBody.getIdTelefonia() +") presenta fallas")
                            .build()
            );
		}
	}

}
