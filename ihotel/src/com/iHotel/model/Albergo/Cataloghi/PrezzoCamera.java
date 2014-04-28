package com.iHotel.model.Albergo.Cataloghi;

import com.iHotel.model.Utility.Periodo;
import com.iHotel.model.Utility.Prezzo;
/**
 * Questa classe rappresenta il prezzo che pu� avere una camera. Poich� nella realt� una camera assume prezzi 
 * differenti da periodo a periodo, � stato legato al prezzo un periodo di validit�. (e.g.: La camera X costa Y nel periodo Z
 * ma costa W nel periodo T) 
 * @author Alessandro
 *
 */
public class PrezzoCamera {

	/* -------------------------- Attributi ------------------------------- */
	//Periodo di validit� del prezzo
	private Periodo _periodo;
	private Prezzo _prezzo;
	
	/* ---------------------- Metodi di instanza --------------------------- */ 
	/**
	 * Metodo per farsi restituire un PrezzoCamera, se il periodo passato come parametro, ha almeno un giorno in comune 
	 * con quello relativo all'oggetto su cui si invoca il metodo.
	 * 
	 * @param periodo Periodo per il quale si vuole ottenere l' MPrezzoCamera corretto.
	 * @return Prezzo relativo al periodo richiesto.
	 */
	public PrezzoCamera getPrezzoInPeriodo(Periodo periodo){
		if(this.get_periodo().contiene(periodo) || this.get_periodo().sovrappone(periodo)) {
			return this;
		} else{
			return null;
		}
	}
	/* ------------------------------------- Getter, Setter ------------------------------- */
	/**
	 * @return double
	 */
	public Prezzo get_prezzo() {
		return this._prezzo;
	}

	/**
	 * @param _prezzo
	 */
	public void set_prezzo(Prezzo _prezzo) {
		this._prezzo = _prezzo;
	}

	/**
	 * @return double
	 */
	public Periodo get_periodo() {
		return _periodo;
	}
	
	/** 
	 * @param _periodo 
	 */
	public void set_periodo(Periodo _periodo) {
		this._periodo = _periodo;
	}
	

}