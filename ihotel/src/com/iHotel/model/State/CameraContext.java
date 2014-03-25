package com.iHotel.model.State;

import java.util.*;

import com.iHotel.model.Albergo.ServizioInterno;
import com.iHotel.model.Utility.Periodo;
import com.iHotel.model.Utility.Prezzo;

public class CameraContext {

	/* --------------------------- Attributi ---------------------- */
	
	private LinkedList<CameraState> _statiCameraState;
	private String _numero;
	private String _tipologia;

	/* -------------------------- Metodi di istanza ----------------------- */
	
	public void aggiungiServizioInPeriodo(ServizioInterno servizio, Periodo periodo){
		
	}
	
	public Prezzo getPrezzoServiziInPeriodo(Periodo periodo){
		return null;
	}
	
	/**
	 * Metodo per controllare se una camera � libera in un periodo.
	 * 
	 * @param periodoRichiesta Periodo nel quale si vuole prenotare la camera.
	 * @return True se la camera � libera nel periodo. False altrimenti.
	 */
	public boolean isLiberaInPeriodo(Periodo periodoRichiesta) {	
		boolean esito=false;
		for (Iterator<CameraState> iterator = _statiCameraState.iterator(); iterator.hasNext();) {
			CameraState statoCamera = iterator.next();				
			if(statoCamera.isLiberaInPeriodo(periodoRichiesta)==true) {					
				esito=true;	
			}
		}
		return esito; 
	}
	/**
	 * Metodo per occupare una camera in un periodo. 
	 * @param periodo Periodo in cui si vuole occupare la camera.
	 */
	public void occupaInPeriodoState(Periodo periodo) {
		// Lista degli stati camera che vengono restituiti dallo stato della camera
		List<CameraState> statiCameraDopoOccupazione;
		// Ciclo su tutti gli stati della camera
		for (int i = 0; i < _statiCameraState.size(); i++) {
			CameraState cameraState = _statiCameraState.get(i);
			// Controllo se mi viene restituita una lista di stati.
			// Solo uno stato pu� restituire la lista.
			// Assegno il risultato alla variabile statiCameraDopoOccupazione		
			statiCameraDopoOccupazione=cameraState.occupaInPeriodo(periodo);
			if(statiCameraDopoOccupazione!=null) {	
				// Rimuovo il vecchio stato camera.
				_statiCameraState.remove(i);
				// Aggiungo la lista ricavata dallo stato partendo dalla sua vecchia posizione.
				_statiCameraState.addAll(i, statiCameraDopoOccupazione);
			}
		}
	}	
	/*------------------ Getter e Setter --------------*/
	/**
	 * @return _statiCameraState 
	 */
	public LinkedList<CameraState> get_statiCamera() {
		return _statiCameraState;
	}
	/**
	 * @param _statiCameraState
	 */
	public void set_statiCamera(LinkedList<CameraState> _statiCameraState) {
		this._statiCameraState = _statiCameraState;
	}
	/**
	 * @return _numero
	 */
	public String get_numero() {
		return this._numero;
	}

	/**
	 * @param _numero
	 */
	public void set_numero(String _numero) {
		this._numero = _numero;
	}
	/**
	 * @return _tipologia
	 */
	public String get_tipologia() {
		return this._tipologia;
	}

	/**
	 * @param _tipologia
	 */
	public void set_tipologia(String _tipologia) {
		this._tipologia = _tipologia;
	}
}
