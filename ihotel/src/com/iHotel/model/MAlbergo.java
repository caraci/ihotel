package com.iHotel.model;

import java.util.*;

public class MAlbergo {

	private MCatalogoCamere _catalogoCamere;
	private HashMap<String,MCamera> _camere;
	private Collection<MPrenotazione> _prenotazioni;
	private String _nome;
	private String _telefono;
	private String _PIVA;
	private String _eMail;

	/**
	 * @return the _catalogoCamere
	 */
	public MCatalogoCamere get_catalogoCamere() {
		return _catalogoCamere;
	}

	/**
	 * @param _catalogoCamere the _catalogoCamere to set
	 */
	public void set_catalogoCamere(MCatalogoCamere _catalogoCamere) {
		this._catalogoCamere = _catalogoCamere;
	}

	/**
	 * @return the _camere
	 */
	public HashMap<String,MCamera> get_camere() {
		return _camere;
	}

	/**
	 * @param _camere the _camere to set
	 */
	public void set_camere(HashMap<String,MCamera> _camere) {
		this._camere = _camere;
	}

	/**
	 * 
	 * @param prenotazione
	 */
	public void addPrenotazione(MPrenotazione prenotazione) {
		// TODO - implement MAlbergo.addPrenotazione
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param periodo
	 * @param Tipologie
	 */
	public void getPrezziCamere(MPeriodo periodo, java.util.List<java.lang.String> Tipologie) {
		// TODO - implement MAlbergo.getPrezziCamere
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param periodo
	 * @param Tipologie
	 */
	public void getCamereLibere(MPeriodo periodo, java.util.List<java.lang.String> Tipologie) {
		// TODO - implement MAlbergo.getCamereLibere
		throw new UnsupportedOperationException();
	}

	public String get_nome() {
		return this._nome;
	}

	/**
	 * 
	 * @param _nome
	 */
	public void set_nome(String _nome) {
		this._nome = _nome;
	}

	public String get_telefono() {
		return this._telefono;
	}

	/**
	 * 
	 * @param _telefono
	 */
	public void set_telefono(String _telefono) {
		this._telefono = _telefono;
	}

	public String get_PIVA() {
		return this._PIVA;
	}

	/**
	 * 
	 * @param _PIVA
	 */
	public void set_PIVA(String _PIVA) {
		this._PIVA = _PIVA;
	}

	public String get_eMail() {
		return this._eMail;
	}

	/**
	 * 
	 * @param _eMail
	 */
	public void set_eMail(String _eMail) {
		this._eMail = _eMail;
	}

}