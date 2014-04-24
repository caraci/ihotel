/**
 * 
 */
package com.iHotel.model.State;

import java.util.*;

import com.iHotel.model.Albergo.Ospite;
import com.iHotel.model.Albergo.ServizioInterno;
import com.iHotel.model.Utility.Periodo;
import com.iHotel.model.Utility.Prezzo;

/**
 * @author Eugenio
 *
 */
public abstract class CameraState {
	/* -------------------------- Attributi ---------------------------------- */
	protected Periodo _periodo;
	protected ArrayList<Ospite> _ospiti;
	protected ArrayList<ServizioInterno> _serviziInterni;
	protected Prezzo _prezzoServizi;
	/**
	 * Costruttore
	 */
	protected CameraState() {
		_serviziInterni=new ArrayList<ServizioInterno>();
		_ospiti=new ArrayList<Ospite>();
		_prezzoServizi=new Prezzo();
	}
	/* ------------------------ Metodi di instanza --------------------------- */
	/**
	 * Metodo per occupare la camera in un periodo.
	 * 
	 * @param periodo Periodo in cui occupare la camera.
	 * @return Lista di stati della camera in seguito all'occupazione.
	 */
	public abstract LinkedList<CameraState> occupaInPeriodo(Periodo periodo);
	/**
	 * Metodo per controllare se la camera � libera in un periodo.
	 * 
	 * @param periodo Periodo da analizzare.
	 * @return True se libera. False altrimenti.
	 */
	public abstract boolean isLiberaInPeriodo(Periodo periodo);
	/**
	 * Metodo per ottenere il prezzo totale dei servizi interni della camera nel periodo.
	 * 
	 * @param periodo Periodo da analizzare.
	 * @return Prezzo totale dei servizi.
	 */
	public abstract Prezzo getPrezzoTotaleServizi(Periodo periodo);
	/**
	 * Metodo per aggiungere un servizio interno in un periodo alla camera.
	 * 
	 * @param servizio Servizio da aggiungere.
	 * @param periodo Periodo in cui aggiungere il servizio.
	 */
	public abstract void aggiungiServizioInPeriodo(ServizioInterno servizio, Periodo periodo);
	/**
	 * Metodo per ottenere la lista dei servizi interni della camera.
	 * 
	 * @return Lista dei servizi interni della camera.
	 */
	public abstract ArrayList<ServizioInterno> getServiziInterni();
	/**
	 * Metodo per ottenere la lista degli ospiti della camera.
	 * 
	 * @return Lista degli ospiti della camera.
	 */
	public abstract ArrayList<Ospite> getOspiti();
	
	/* -------------------------- Getter, Setter ----------------------------- */
	/**
	 * @return the _periodo
	 */
	public Periodo get_periodo() {
		return _periodo;
	}
	/**
	 * @param _periodo the _periodo to set
	 */
	public void set_periodo(Periodo _periodo) {
		this._periodo = _periodo;
	}
	/**
	 * @return the _prezzoServizi
	 */
	public Prezzo get_prezzoServizi() {
		return _prezzoServizi;
	}
	/**
	 * @param _prezzoServizi the _prezzoServizi to set
	 */
	public void set_prezzoServizi(Prezzo _prezzoServizi) {
		this._prezzoServizi = _prezzoServizi;
	}
}

