package com.aws.microserviceti.servicio.persistencia.entity;

import java.math.BigDecimal;

public class Pago {
	
	private String tarjeta;
	private BigDecimal monto;
	private boolean estadopago;
	private String mensajepago;
	
	
	/**
	 * @return the estadopago
	 */
	public boolean isEstadopago() {
		return estadopago;
	}


	/**
	 * @param estadopago the estadopago to set
	 */
	public void setEstadopago(boolean estadopago) {
		this.estadopago = estadopago;
	}


	/**
	 * @return the mensajepago
	 */
	public String getMensajepago() {
		return mensajepago;
	}


	/**
	 * @param mensajepago the mensajepago to set
	 */
	public void setMensajepago(String mensajepago) {
		this.mensajepago = mensajepago;
	}

	/**
	 * @return the tarjeta
	 */
	public String getTarjeta() {
		return tarjeta;
	}


	/**
	 * @param tarjeta the tarjeta to set
	 */
	public void setTarjeta(String tarjeta) {
		this.tarjeta = tarjeta;
	}


	/**
	 * @return the monto
	 */
	public BigDecimal getMonto() {
		return monto;
	}


	/**
	 * @param monto the monto to set
	 */
	public void setMonto(BigDecimal monto) {
		this.monto = monto;
	}

	public boolean validarPago() {
		boolean resultado = false;
		
		return resultado;
	}
}
