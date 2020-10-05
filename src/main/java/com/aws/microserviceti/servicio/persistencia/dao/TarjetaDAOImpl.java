package com.aws.microserviceti.servicio.persistencia.dao;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.aws.microserviceti.servicio.persistencia.entity.Tarjeta;
import com.aws.microserviceti.servicio.persistencia.entity.TipoTarjeta;

@Repository("tarjetaDAO")
public class TarjetaDAOImpl implements TarjetaDAO{


	@Override
	public String ejecutarPago(String numerotarjeta, String monto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean actualizarSaldo(String numerotarjeta, String monto) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public Tarjeta consultarTarjeta(String identificador) {
		// TODO Auto-generated method stub
		
		TipoTarjeta tipo1 = new TipoTarjeta();
		tipo1.setIdtarjeta(1);
		tipo1.setNombre("Tasa SQUA");
		tipo1.setOperador("div");
		tipo1.setParametrosTasa(2);
		tipo1.setPosiParametro1fecha(2);
		tipo1.setPosiParametro2fecha(1);
		tipo1.setConstateTasa(new BigDecimal(1));
		
		TipoTarjeta tipo2 = new TipoTarjeta();
		tipo2.setIdtarjeta(2);
		tipo2.setNombre("Tasa SCO");  
		tipo2.setOperador("mul");
		tipo2.setParametrosTasa(1);
		tipo2.setPosiParametro1fecha(0);
		//tipo2.setPosiParametro2fecha(0);
		tipo2.setConstateTasa(new BigDecimal(0.5));
		
		TipoTarjeta tipo3 = new TipoTarjeta();
		tipo3.setIdtarjeta(3);
		tipo3.setNombre("Tasa PERE");
		tipo3.setOperador("mul");
		tipo3.setParametrosTasa(1);
		tipo3.setPosiParametro1fecha(1);
		//tipo3.setPosiParametro2fecha(0);
		tipo3.setConstateTasa(new BigDecimal(0.1));
		
		List<Tarjeta> listaBD = new ArrayList<Tarjeta>();
		
		Tarjeta object1 = new Tarjeta();
		object1.setCardholder("12233");
		object1.setNumerotarjeta("447410123458748569");
		object1.setFechavencimiento("10-05-2021");
		object1.setTipoTarjeta(tipo1);
		
		listaBD.add(object1);
		
		Tarjeta object2 = new Tarjeta();
		object2.setCardholder("87951");
		object2.setNumerotarjeta("447409986558748587");
		object2.setFechavencimiento("10-05-2018");
		object2.setTipoTarjeta(tipo2);
		listaBD.add(object2);
		
		Tarjeta object3 = new Tarjeta();
		object3.setCardholder("98574");
		object3.setNumerotarjeta("447411986558748587");
		object3.setFechavencimiento("10-05-2024");
		object3.setTipoTarjeta(tipo3);
		listaBD.add(object3);
		
		for (Tarjeta tarjeta : listaBD) {
			if(identificador.equals(tarjeta.getNumerotarjeta()))
				return tarjeta;
		}
		return null;
	}

	@Override
	public List<TipoTarjeta> getListaTipoTarjetas() {
		
		List<TipoTarjeta> listaBD = new ArrayList<TipoTarjeta>();
		TipoTarjeta object = new TipoTarjeta();
		
		object.setIdtarjeta(1);
		object.setNombre("Tasa SQUA");
		object.setOperador("div"); //Formula dividir
		object.setParametrosTasa(2);
		object.setPosiParametro1fecha(2);
		object.setPosiParametro2fecha(1);
		object.setConstateTasa(new BigDecimal(1));
		listaBD.add(object);
		
		object = new TipoTarjeta();
		object.setIdtarjeta(2);
		object.setNombre("Tasa SCO");  
		object.setOperador("mul"); //Formula multiplicar
		object.setParametrosTasa(1);
		object.setPosiParametro1fecha(0);
//		object.setPosiParametro2fecha(0);
		object.setConstateTasa(new BigDecimal(0.5));
		listaBD.add(object);
		
		object = new TipoTarjeta();
		object.setIdtarjeta(3);
		object.setNombre("Tasa PERE");
		object.setOperador("mul"); //Formula multiplicar
		object.setParametrosTasa(1);
		object.setPosiParametro1fecha(1);
//		object.setPosiParametro2fecha(0);
		object.setConstateTasa(new BigDecimal(0.1));
		listaBD.add(object);
		
		return listaBD;
	}

}
