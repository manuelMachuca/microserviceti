package com.aws.microserviceti.servicio.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aws.microserviceti.servicio.persistencia.entity.Operacion;
import com.aws.microserviceti.servicio.persistencia.entity.Pago;
import com.aws.microserviceti.servicio.persistencia.entity.Tarjeta;
import com.aws.microserviceti.servicio.service.TarjetaService;

@RestController
@RequestMapping("uri")
public class UserController {
	@Autowired
	TarjetaService tarjetaService;
	
	@GetMapping(path = "/consultar/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Tarjeta getConsultarTarjeta(@PathVariable String id) {
		return tarjetaService.consultarTarjeta(id);
	}
	
	@GetMapping(path = "/valMontoOperacion/{monto}")
	public ResponseEntity<?> getValidarMontoOperacion(@PathVariable String monto) {
		boolean resultado = tarjetaService.validarMontoOperacion(monto);
		return ResponseEntity.ok().body("¿Operacion valida?  " + resultado);
	}
	
	@GetMapping(path = "/valTarOperacion/{id}")
	public ResponseEntity<?> getValidarTarjetaOperacion(@PathVariable String id) {
		boolean resultado = tarjetaService.validarTarjetaOperacion(id);
		return ResponseEntity.ok().body("¿Tarjeta valida?  " + resultado);
	}
	
	@GetMapping(path = "/calcularTasaOperacion/{tipotarjeta}/{monto}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Operacion getTasaOperacion(@PathVariable String tipotarjeta,@PathVariable String monto) {
		return tarjetaService.calcularTasaOperacion(tipotarjeta,monto);
	}
	
	@GetMapping(path = "/ejecutarPago/{tarjeta}/{monto}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Pago procesoPago(@PathVariable String tarjeta,@PathVariable String monto) {
		return tarjetaService.procesarPago(tarjeta,monto);
	}
}
