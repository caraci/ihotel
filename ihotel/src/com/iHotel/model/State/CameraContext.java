package com.iHotel.model.State;

import java.util.*;

import com.iHotel.model.Albergo.Ospite;
import com.iHotel.model.Albergo.ServizioInterno;
import com.iHotel.model.Utility.Periodo;
import com.iHotel.model.Utility.Prezzo;

public class CameraContext {

	/* --------------------------- Attributi e Costruttore ---------------------- */
	private LinkedList<CameraState> _statiCameraState;
	private String _numero;
	private String _tipologia;

	public CameraContext() {
		_statiCameraState = new LinkedList<CameraState>();
	}
	/* -------------------------- Metodi di istanza ----------------------- */
	/**
	 * Metodo per aggiungere un servizio alla camera in un determinato periodo.
	 * @param servizio Servizio da aggiungere.
	 * @param periodo Periodo in cui aggiungere il servizio.
	 */
	public void aggiungiServizioInPeriodo(ServizioInterno servizio, Periodo periodo){
		for (Iterator<CameraState> iterator = _statiCameraState.iterator(); iterator.hasNext();) {
			CameraState statoCamera = (CameraState) iterator.next();
			statoCamera.aggiungiServizioInPeriodo(servizio, periodo);
		}
	}
	/**
	 * Metodo per ottenere il prezzo dei servizi interni della camera in un certo periodo.
	 * 
	 * @param periodo Periodo per il quale si vuole ricercare il totale.
	 * @return Prezzo dei servizi della camera nel periodo.
	 */
	public Prezzo getPrezzoServiziInPeriodo(Periodo periodo){
		Prezzo prezzo = new Prezzo();
		// Ciclo sugli stati della camera
		for (Iterator<CameraState> iterator = _statiCameraState.iterator(); iterator.hasNext();) {
			CameraState cameraState = (CameraState) iterator.next();
			// Controllo che non mi venga fornito un null
			if(cameraState.getPrezzoTotaleServizi(periodo)!=null) {
				prezzo=cameraState.getPrezzoTotaleServizi(periodo);
			}
		}
		return prezzo;
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
	/**
	 * metodo per recuperare i servizi interni associati ad una camera in un periodo
	 * */
	public ArrayList<ServizioInterno> getServiziInterniInPeriodo(Periodo periodo){
		ArrayList<ServizioInterno> serviziInterni=new ArrayList<ServizioInterno>() ;
		for (Iterator<CameraState> iterator = _statiCameraState.iterator(); iterator.hasNext();) {
			CameraState statoCamera = iterator.next();
			if(statoCamera.get_periodo().coincideCon(periodo)){
				serviziInterni=statoCamera.getServiziInterni();
			}
		}
		return serviziInterni;
	}
	/**
	 * Metodo per recuperare gli ospiti ossoociati ad una camera in un periodo
	 * */
	public ArrayList<Ospite> getOspitiInPeriodo(Periodo periodo){
		ArrayList<Ospite> ospiti=new ArrayList<Ospite>() ;
		for (Iterator<CameraState> iterator = _statiCameraState.iterator(); iterator.hasNext();) {
			CameraState statoCamera = iterator.next();
			if(statoCamera.get_periodo().coincideCon(periodo)){
				ospiti=statoCamera.getOspiti();
			}
		}
		return ospiti;
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
