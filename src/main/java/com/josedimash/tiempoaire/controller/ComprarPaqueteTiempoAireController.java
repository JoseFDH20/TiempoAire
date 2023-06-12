package com.josedimash.tiempoaire.controller;

import java.util.HashMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.josedimash.tiempoaire.model.CompraPaqueteRequestBody;
import com.josedimash.tiempoaire.model.MensajeCompraResponse;
import com.josedimash.tiempoaire.service.ProveedoresService;
import com.josedimash.tiempoaire.util.Utilerias;

import io.swagger.v3.oas.annotations.Hidden;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
/**
 * Esta clase contiene el proceso para registrar la compra de un paquete de tiempo aire.
 * Simula ser un servicio externo de cada proveedor registrado.<b>
 * 
 * 
 * 
 *
 */
@RestController
@RequestMapping(value = "/paqTiempoAire")
@Tag(name = "Simulador de WS Externo", description = "WS para simular la compra de un paquete de tiempo aire de un proveedor.")
@Hidden//No documentar
public class ComprarPaqueteTiempoAireController {
		
	@Autowired
	private ProveedoresService proveedoresService;

	@PostMapping("/{idTelefonia}/comprar")
    @Operation(
            summary = "Para realizar una compra de tiempo aire",
            description = "Usar este endpoint para realizar una compra de tiempo aire"
    )
	public MensajeCompraResponse comprarPaquete(@PathVariable Integer idTelefonia, @NonNull @RequestBody CompraPaqueteRequestBody requestBody) {
		MensajeCompraResponse mensajeResponse = new MensajeCompraResponse();
		if(!Utilerias.validaTelefono(requestBody.getTelefono())) {
			return new MensajeCompraResponse(-1, "Por favor, revise el número de teléfono");
		}
		
		Long numeroTelefono = Utilerias.toLong(requestBody.getTelefono());
		if(numeroTelefono==0) {
			return new MensajeCompraResponse(-1, "Por favor, revise el número de teléfono");
		}
		
		HashMap<String, Object> result = proveedoresService.comprarTiempoAire(requestBody.getIdTelefonia(), requestBody.getMontoPaquete(), numeroTelefono);
		
		if(result!=null) {
			mensajeResponse = new MensajeCompraResponse((Integer)result.get("code"), (String)result.get("mensaje"));	
		}
		else {
			mensajeResponse = new MensajeCompraResponse(-1, "Compra no realizada");	
		}
			
		return mensajeResponse;
	}
}
