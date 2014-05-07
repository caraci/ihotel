package com.iHotel.model.Albergo.Cataloghi;


import com.iHotel.model.Utility.*;
/**
 * Questa classe rappresenta il prezzo che pu� avere un servizio interno. Poich� nella realt� un servizio pu� avere prezzi 
 * differenti da periodo a periodo, � stato legato al prezzo un periodo di validit�. (e.g.: Il servizio X costa P1 nel periodo 1
 * ma costa P2 nel periodo 2).
 *  
 * @author Alessandro
 */
public class PrezzoServizioInterno {

	/* -------------------------- Attributi ----------------------------------- */
	//Periodo di validit� del prezzo
	private Periodo _periodo;
	private Prezzo _prezzo;
	/* -------------------------- Metodi di instanza ----------------------------------- */
	
	/**
	 * Metodo per ottenere il prezzo relativo al servizio, se il periodo di richiesta � contenuto
	 * in quello dell'instanza su cui si invoca il metodo.
	 * 
	 * @param dataServizio Periodo di richiesta
	 * @return Prezzo relativo al servizo se il periodo � valido. Null altrimenti.
	 */
	public Prezzo getPrezzoInData(Periodo dataServizio) {
		Prezzo prezzo = null;
		if (_periodo.contiene(dataServizio)==true) {
			prezzo=_prezzo;
		}
		return prezzo;
	}
	
	/* -------------------------- Getter, Setter ----------------------------------- */
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
	 * @return the _prezzo
	 */
	public Prezzo get_prezzo() {
		return _prezzo;
	}
	/**
	 * @param _prezzo the _prezzo to set
	 */
	public void set_prezzo(Prezzo _prezzo) {
		this._prezzo = _prezzo;
	}

}