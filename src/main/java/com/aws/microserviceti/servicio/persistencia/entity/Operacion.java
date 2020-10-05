package com.aws.microserviceti.servicio.persistencia.entity;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.aws.microserviceti.servicio.util.Constantes;

public class Operacion {

	private BigDecimal importe;
	private BigDecimal tasa;
	private BigDecimal montofinal;
	

	/**
	 * @return the montofinal
	 */
	public BigDecimal getMontofinal() {
		return montofinal;
	}

	/**
	 * @param montofinal the montofinal to set
	 */
	public void setMontofinal(BigDecimal montofinal) {
		this.montofinal = montofinal;
	}

	/**
	 * @return the tasa
	 */
	public BigDecimal getTasa() {
		return tasa;
	}

	/**
	 * @param tasa
	 *            the tasa to set
	 */
	public void setTasa(BigDecimal tasa) {
		this.tasa = tasa;
	}

	

	/**
	 * @return the importe
	 */
	public BigDecimal getImporte() {
		return importe;
	}

	/**
	 * @param importe the importe to set
	 */
	public void setImporte(BigDecimal importe) {
		this.importe = importe;
	}

	public boolean validarMontoOperacion() {

		if ((Constantes.IMPORTE_MAXIMO_OPERACION.compareTo(this.importe) == 1
				|| Constantes.IMPORTE_MAXIMO_OPERACION.compareTo(this.importe) == 0)
				&& this.importe.compareTo(Constantes.IMPORTE_MINIMO_OPERACION) == 1)
			return true;
		else
			return false;
	}

	/**
	 * Calculo de atributo tasa con marca de tarjeta
	 * @param tipoTarjeta
	 */
	public void calcularTasaMarca(TipoTarjeta tipoTarjeta) {

		if (tipoTarjeta != null) {
			SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
			String strDate= formatter.format(new Date());
			String[] campofecha = strDate.split("-");
			
			//Indican la posicion del campo de la fecha obtener el valor para la formula
			int parametro1 = tipoTarjeta.getPosiParametro1fecha();
			int parametro2 = tipoTarjeta.getPosiParametro2fecha();
			
			if (tipoTarjeta.getOperador().equals("mul")) {
				if (tipoTarjeta.getParametrosTasa() == 2) {
					tasa = new BigDecimal(campofecha[parametro1]).multiply(new BigDecimal(campofecha[parametro2]));
				} else if (tipoTarjeta.getParametrosTasa() == 1) {
					tasa = new BigDecimal(campofecha[parametro1]).multiply(tipoTarjeta.getConstateTasa());
				}
			} else if (tipoTarjeta.getOperador().equals("div")) {
				if (tipoTarjeta.getParametrosTasa() == 2) {
					tasa = new BigDecimal(campofecha[parametro1]).divide(new BigDecimal(campofecha[parametro2]));
				} else if (tipoTarjeta.getParametrosTasa() == 1) {
					tasa = new BigDecimal(campofecha[parametro1]).divide(tipoTarjeta.getConstateTasa());
				}
			}
		}
		if(tasa!=null)
			tasa = tasa.setScale(2, BigDecimal.ROUND_HALF_EVEN);
	}
	
	public void calcularMontofinal() {
		montofinal = importe.multiply(tasa);
	}
}
