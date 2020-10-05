package com.aws.microserviceti.servicio.persistencia.entity;

import java.math.BigDecimal;

public class TipoTarjeta {
	
	private int idtarjeta; 
	private String nombre;
	private BigDecimal tasa;
	private String operador;
	private int parametrosTasa;
	private int posiParametro1fecha;
	private int posiParametro2fecha;
	private BigDecimal constateTasa;
	
	
	/**
	 * @return the constateTasa
	 */
	public BigDecimal getConstateTasa() {
		return constateTasa;
	}
	/**
	 * @param constateTasa the constateTasa to set
	 */
	public void setConstateTasa(BigDecimal constateTasa) {
		this.constateTasa = constateTasa;
	}
	/**
	 * @return the posiParametro1fecha
	 */
	public int getPosiParametro1fecha() {
		return posiParametro1fecha;
	}
	/**
	 * @param posiParametro1fecha the posiParametro1fecha to set
	 */
	public void setPosiParametro1fecha(int posiParametro1fecha) {
		this.posiParametro1fecha = posiParametro1fecha;
	}
	/**
	 * @return the posiParametro2fecha
	 */
	public int getPosiParametro2fecha() {
		return posiParametro2fecha;
	}
	/**
	 * @param posiParametro2fecha the posiParametro2fecha to set
	 */
	public void setPosiParametro2fecha(int posiParametro2fecha) {
		this.posiParametro2fecha = posiParametro2fecha;
	}
	/**
	 * @return the parametrosTasa
	 */
	public int getParametrosTasa() {
		return parametrosTasa;
	}
	/**
	 * @param parametrosTasa the parametrosTasa to set
	 */
	public void setParametrosTasa(int parametrosTasa) {
		this.parametrosTasa = parametrosTasa;
	}
	/**
	 * @return the operador
	 */
	public String getOperador() {
		return operador;
	}
	/**
	 * @param operador the operador to set
	 */
	public void setOperador(String operador) {
		this.operador = operador;
	}
	/**
	 * @return the idtarjeta
	 */
	public int getIdtarjeta() {
		return idtarjeta;
	}
	/**
	 * @param idtarjeta the idtarjeta to set
	 */
	public void setIdtarjeta(int idtarjeta) {
		this.idtarjeta = idtarjeta;
	}
	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}
	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	/**
	 * @return the tasa
	 */
	public BigDecimal getTasa() {
		return tasa;
	}

}
