package com.aws.microserviceti.servicio.persistencia.entity;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Tarjeta {
	
	private String numerotarjeta;
	private String cardholder;
	private String fechavencimiento;
	private TipoTarjeta tipoTarjeta;
	
	/**
	 * @return the tipoTarjeta
	 */
	public TipoTarjeta getTipoTarjeta() {
		return tipoTarjeta;
	}
	/**
	 * @param tipoTarjeta the tipoTarjeta to set
	 */
	public void setTipoTarjeta(TipoTarjeta tipoTarjeta) {
		this.tipoTarjeta = tipoTarjeta;
	}
	/**
	 * @return the numerotarjeta
	 */
	public String getNumerotarjeta() {
		return numerotarjeta;
	}
	/**
	 * @param numerotarjeta the numerotarjeta to set
	 */
	public void setNumerotarjeta(String numerotarjeta) {
		this.numerotarjeta = numerotarjeta;
	}
	/**
	 * @return the cardholder
	 */
	public String getCardholder() {
		return cardholder;
	}
	/**
	 * @param cardholder the cardholder to set
	 */
	public void setCardholder(String cardholder) {
		this.cardholder = cardholder;
	}
	/**
	 * @return the fechavencimiento
	 */
	public String getFechavencimiento() {
		return fechavencimiento;
	}
	/**
	 * @param fechavencimiento the fechavencimiento to set
	 */
	public void setFechavencimiento(String fechavencimiento) {
		this.fechavencimiento = fechavencimiento;
	}
	
	public boolean validarTarjetaOperacion() {
		
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        boolean validar = false;
		
        try {
            
			Date date = formatter.parse(this.fechavencimiento);
            if(date.compareTo(new Date())>0)
            	validar=true;
            
        } catch (ParseException e) {
            e.printStackTrace();
        }
        
        return validar;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Tarjeta [numerotarjeta=" + numerotarjeta + ", cardholder=" + cardholder + ", fechavencimiento="
				+ fechavencimiento + ", tipoTarjeta=" + tipoTarjeta + "]";
	}
	
	
	
}
