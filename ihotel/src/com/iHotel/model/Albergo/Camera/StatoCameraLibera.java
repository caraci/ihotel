package com.iHotel.model.Albergo.Camera;

import java.util.*;

import com.iHotel.model.Persona.Ospite;
import com.iHotel.model.Albergo.ServizioInterno;
import com.iHotel.model.Strategy.CreaStatiCameraStrategy;
import com.iHotel.model.Strategy.CreaStatiCameraStrategyFactory;
import com.iHotel.model.Utility.Periodo;
import com.iHotel.model.Utility.Prezzo;

/**
 * Classe che realizza uno stato camera "libero".
 * 
 * @author Eugenio
 */
public class StatoCameraLibera extends StatoCamera {

	@Override
	public LinkedList<StatoCamera> occupaInPeriodo(Periodo periodoRichiesta) {
		// Lista degli stati da restituire alla camera.
		LinkedList<StatoCamera> nuoviStatiCamera=null;
		// Controllo che il periodo della richiesta � contenuto nel periodo dell'instanza.
		if (_periodo.contiene(periodoRichiesta)) {
			CreaStatiCameraStrategy creaStatiCameraStrategy = CreaStatiCameraStrategyFactory.getInstance().getStrategy(_periodo, periodoRichiesta);
			nuoviStatiCamera=creaStatiCameraStrategy.creaNuoviStati(this, periodoRichiesta);
		}
		return nuoviStatiCamera;
	}
	@Override
	public boolean isLiberaInPeriodo(Periodo periodo) {
		boolean esito;
		if(this.get_periodo().contiene(periodo)) {
			esito=true;
		} else {
			esito=false;
		}
		return esito;
	}
	@Override
	public Prezzo getPrezzoTotaleServizi(Periodo periodo) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void aggiungiServizioInPeriodo(ServizioInterno servizio,	Periodo periodo) {
		// TODO Auto-generated method stub
	}
	@Override
	public ArrayList<ServizioInterno> getServiziInterniInPeriodo(Periodo periodo) {
		return null;
	}
	@Override
	public ArrayList<Ospite> getOspitiInPeriodo(Periodo periodo) {
		return null;
	}
	@Override
	public void aggiungiOspite(Ospite ospite) {
		// TODO Auto-generated method stub
	}	
}