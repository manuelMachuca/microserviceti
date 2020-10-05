package com.aws.microserviceti.servicio.service;

import java.util.List;

import com.aws.microserviceti.servicio.persistencia.entity.Operacion;
import com.aws.microserviceti.servicio.persistencia.entity.Pago;
import com.aws.microserviceti.servicio.persistencia.entity.Tarjeta;
import com.aws.microserviceti.servicio.persistencia.entity.TipoTarjeta;

public interface TarjetaService {
	
	public Tarjeta consultarTarjeta(String identificador);
	public List<TipoTarjeta> getListaTipoTarjetas();
	public boolean validarMontoOperacion(String transaccion);
	public boolean validarTarjetaOperacion(String tarjeta);
	public Operacion calcularTasaOperacion(String tipotarjeta, String monto);
	public Pago procesarPago(String numerotarjeta, String monto);
	public void actualizarSaldo(String numerotarjeta, String monto);
	public void informarPago(String numerotarjeta, String monto);
	void imprimirFactura(String numerotarjeta, String monto);
	void enviarInfoTC(String numerotarjeta);
}
