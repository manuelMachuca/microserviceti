package com.aws.microserviceti.servicio.persistencia.dao;

import java.util.List;

import com.aws.microserviceti.servicio.persistencia.entity.Tarjeta;
import com.aws.microserviceti.servicio.persistencia.entity.TipoTarjeta;

public interface TarjetaDAO {
	
	public Tarjeta consultarTarjeta(String identificador);
	public List<TipoTarjeta> getListaTipoTarjetas();
	public String ejecutarPago(String numerotarjeta, String monto);
	public boolean actualizarSaldo(String numerotarjeta, String monto);
}
