package com.aws.microserviceti.servicio.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aws.microserviceti.servicio.excepciones.NegocioExcepcion;
import com.aws.microserviceti.servicio.persistencia.dao.TarjetaDAO;
import com.aws.microserviceti.servicio.persistencia.entity.Operacion;
import com.aws.microserviceti.servicio.persistencia.entity.Pago;
import com.aws.microserviceti.servicio.persistencia.entity.Tarjeta;
import com.aws.microserviceti.servicio.persistencia.entity.TipoTarjeta;

@Service("tarjetaService")
public class TarjetaServiceImpl implements TarjetaService{
	
	@Autowired
	TarjetaDAO tarjetaDAO;
	
	@Override
	public Tarjeta consultarTarjeta(String identificador) {
		return tarjetaDAO.consultarTarjeta(identificador);
	}
	
	@Override
	public List<TipoTarjeta> getListaTipoTarjetas() {
		return tarjetaDAO.getListaTipoTarjetas();
	}

	@Override
	public boolean validarMontoOperacion(String importe) {
		Operacion operacion = new Operacion();
		operacion.setImporte(new BigDecimal(importe));
		return operacion.validarMontoOperacion();
	}

	@Override
	public boolean validarTarjetaOperacion(String numerotarjeta) {
		
		Tarjeta tarjeta = consultarTarjeta(numerotarjeta);
		return tarjeta.validarTarjetaOperacion();
	}

	@Override
	public Operacion calcularTasaOperacion(String tipotarjeta, String importe) {
		
		TipoTarjeta tipotarjetaBD = obtenerTipoTarjeta(tipotarjeta);
		Operacion operacion =  new Operacion();
		operacion.setImporte(new BigDecimal(importe));
		operacion.calcularTasaMarca(tipotarjetaBD);
		operacion.calcularMontofinal();
		return operacion;
	}
	
	public TipoTarjeta obtenerTipoTarjeta(String tipotarjeta) {
		
		List<TipoTarjeta> lista = tarjetaDAO.getListaTipoTarjetas();
		for (TipoTarjeta tipotarjetaBD : lista) {
			if (tipotarjetaBD.getIdtarjeta() == Integer.parseInt(tipotarjeta))
				return tipotarjetaBD;
		}
		return null;
	}
	
	@Override
	/*El metodo deberia ser Transaccional*/
	public Pago procesarPago(String numerotarjeta, String monto) {
		
		Pago pago = new Pago();
		pago.setMonto(new BigDecimal(monto));
		pago.setTarjeta(numerotarjeta);
		pago.setEstadopago(false);
		
		try {
			imprimirFactura(numerotarjeta,monto);
			enviarInfoTC(numerotarjeta);
			informarPago(numerotarjeta,monto);
			actualizarSaldo(numerotarjeta,monto);
			pago.setEstadopago(true);
			pago.setMensajepago("Pago ejecutado correcto!");
		}catch (NegocioExcepcion e) {
			pago.setMensajepago(e.getMessage());
		}catch (Exception e) {
			pago.setMensajepago(e.getMessage());
		}
		return pago;
	}

	@Override
	public void enviarInfoTC(String numerotarjeta) {
		try {
			//Envirar info
		}catch (Exception e) {
			throw new NegocioExcepcion("Error al informar pago a comercial",e);
		}
	}

	@Override
	public void imprimirFactura(String numerotarjeta, String monto) {
		try {
			//Imprimir
			int falla = Integer.parseInt("a");
		}catch (Exception e) {
			throw new NegocioExcepcion("Error al imprimir",e);
		}
	}
	
	@Override
	public void informarPago(String numerotarjeta, String monto) {
		try {
			tarjetaDAO.ejecutarPago(numerotarjeta,monto);
		}catch (Exception e) {
			throw new NegocioExcepcion("Sistema no atiende pedidos",e);
		}
	}
	
	@Override
	public void actualizarSaldo(String numerotarjeta, String monto) {
		try {
			tarjetaDAO.actualizarSaldo(numerotarjeta,monto);
		}catch (Exception e) {
			throw new NegocioExcepcion("Sistema no permite escribir saldos",e);
		}
	}
	
}
