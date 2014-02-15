package com.iHotel.model;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class MPeriodo {

	/* ----------------------------------------- Attributi ------------------------------------- */
	private int _giornoInizio;
	private int _meseInizio;
	private int _annoInizio;
	private int _oraInizio = 16;
	private int _minutoInizio= 0;
	
	private int _giornoFine;
	private int _meseFine;
	private int _annoFine;
	private int _oraFine = 10;
	private int _minutoFine =0;
	
	
	/* --------------------- Metodi di instanza ----------------------------------------- */
	/**
	 * Metodo per verificare che il periodo passato come paramentro � contenuto all'interno del periodo relativo all'oggetto
	 * sul quale si sta invocando il metodo.
	 * @param periodoRichiesta Periodo da confrontare
	 * @return True se il periodo � contenuto. False altrimenti.
	 */
	public boolean contiene (MPeriodo periodoRichiesta) {
		boolean esito;
		// Periodo richiesta
		GregorianCalendar dataInizioRichiesta = new GregorianCalendar();
		GregorianCalendar dataFineRichiesta = new GregorianCalendar();
		dataInizioRichiesta.set(periodoRichiesta.get_annoInizio(), periodoRichiesta.get_meseInizio(), periodoRichiesta.get_giornoInizio(), periodoRichiesta.get_oraInizio(), periodoRichiesta.get_minutoInizio(),1);
		dataFineRichiesta.set(periodoRichiesta.get_annoFine(), periodoRichiesta.get_meseFine(), periodoRichiesta.get_giornoFine(), periodoRichiesta.get_oraFine(), periodoRichiesta.get_minutoFine(),0);
		// Periodo dell'instanza
		GregorianCalendar dataInizioPeriodo = new GregorianCalendar();
		GregorianCalendar dataFinePeriodo = new GregorianCalendar();
		dataInizioPeriodo.set(_annoInizio, _meseInizio, _giornoInizio, _oraInizio, _minutoInizio,0);
		dataFinePeriodo.set(_annoFine, _meseFine, _giornoFine, _oraFine, _minutoFine,59);
		// Controllo se il periodoRichiesta � contenuto in periodo.
		if(dataInizioPeriodo.compareTo(dataInizioRichiesta)<=0 && dataFinePeriodo.compareTo(dataFineRichiesta) >=0) {
			esito = true;
		} else {
			esito = false;
		}
		return esito;
	}
	/**
	 * Metodo per verificare che il periodo passato come parametro si sovrappone con quello passato come parametro 
	 * @param periodoRichiesta Periodo da confrontare
	 * @return True se il periodo si sovrappone. False altrimenti.
	 */
	public boolean sovrappone (MPeriodo periodoRichiesta) {
		boolean esito;
		// Periodo richiesta
		GregorianCalendar dataInizioRichiesta = new GregorianCalendar();
		GregorianCalendar dataFineRichiesta = new GregorianCalendar();
		dataInizioRichiesta.set(periodoRichiesta.get_annoInizio(), periodoRichiesta.get_meseInizio(), periodoRichiesta.get_giornoInizio(), periodoRichiesta.get_oraInizio(), periodoRichiesta.get_minutoInizio());
		dataFineRichiesta.set(periodoRichiesta.get_annoFine(), periodoRichiesta.get_meseFine(), periodoRichiesta.get_giornoFine(), periodoRichiesta.get_oraFine(), periodoRichiesta.get_minutoFine());
		// Periodo dell'instanza
		GregorianCalendar dataInizioPeriodo = new GregorianCalendar();
		GregorianCalendar dataFinePeriodo = new GregorianCalendar();
		dataInizioPeriodo.set(_annoInizio, _meseInizio, _giornoInizio, _oraInizio, _minutoInizio);
		dataFinePeriodo.set(_annoFine, _meseFine, _giornoFine, _oraFine, _minutoFine);
		// Controllo se periodoRichiesta si sovrapponde con periodo.
		if(dataInizioPeriodo.compareTo(dataFineRichiesta)<=0 && dataFinePeriodo.compareTo(dataInizioRichiesta) >=0) {
			esito = true;
		} else {
			esito = false;
		}
		return esito;
	}
	/**
	 * Metodo per verificare che il periodo dell'instanza segue quello del periodo passato come parametro.
	 * @param periodoRichiesta Periodo da analizzare.
	 * @return True se il periodo dell'instanza precede quello passato per parametro. False altrimenti.
	 */
	public boolean segue (MPeriodo periodoRichiesta) {
		boolean esito;
		// Periodo richiesta
		GregorianCalendar dataFineRichiesta = new GregorianCalendar();
		dataFineRichiesta.set(periodoRichiesta.get_annoFine(), periodoRichiesta.get_meseFine(), periodoRichiesta.get_giornoFine());
		// Periodo dell'instanza
		GregorianCalendar dataInizioPeriodo = new GregorianCalendar();
		dataInizioPeriodo.set(_annoInizio, _meseInizio, _giornoInizio);
		// Controllo se il periodo della instanza segue quello della richiesta.
		if (
		   dataInizioPeriodo.get(Calendar.DATE) == dataFineRichiesta.get(Calendar.DATE) &&
		   dataInizioPeriodo.get(Calendar.MONTH) == dataFineRichiesta.get(Calendar.MONTH) &&
		   dataInizioPeriodo.get(Calendar.YEAR) == dataFineRichiesta.get(Calendar.YEAR)
		   ) {
			esito = true;
		} else {
			esito = false;
		}
		return esito;
	}
	/**
	 * Metodo per verificare che il periodo dell'instanza anticipa quello del periodo passato come parametro.
	 * @param periodoRichiesta Periodo da analizzare.
	 * @return True se il periodo dell'instanza anticipa quello passato per parametro. False altrimenti.
	 */
	public boolean anticipa (MPeriodo periodoRichiesta) {
		boolean esito;
		// Periodo richiesta
		GregorianCalendar dataInizioRichiesta = new GregorianCalendar();
		dataInizioRichiesta.set(periodoRichiesta.get_annoInizio(), periodoRichiesta.get_meseInizio(), periodoRichiesta.get_giornoInizio());
		// Periodo dell'instanza
		GregorianCalendar dataFinePeriodo = new GregorianCalendar();
		dataFinePeriodo.set(_annoFine, _meseFine, _giornoFine);
		// Controllo se il periodo della instanza segue quello della richiesta.
		if (
		   dataInizioRichiesta.get(Calendar.DATE) == dataFinePeriodo.get(Calendar.DATE) &&
		   dataInizioRichiesta.get(Calendar.MONTH) == dataFinePeriodo.get(Calendar.MONTH) &&
		   dataInizioRichiesta.get(Calendar.YEAR) == dataFinePeriodo.get(Calendar.YEAR)
		   ) {
			esito = true;
		} else {
			esito = false;
		}
		return esito;
	}
	/**
	 * Metodo per verificare che il periodo dell'instanza � esattamente compreso tra due periodi. 
	 * Per esattamente si intende che non sono presenti "buchi" tra il periodo precedente e quello antecedente.
	 * @param periodoPrecedente Periodo che precede quello dell'instanza.
	 * @param periodoSuccessivo Periodo che antecede quello dell'instanza.
	 * @return True se il periodo dell'instanza � esattamente contenuto. False altrimenti.
	 */
	public boolean contenutoTraPeriodi (MPeriodo periodoPrecedente, MPeriodo periodoSuccessivo) {
		boolean esito;
		// Controllo se il periodo � esattamente contenuto tra due periodi
		if(this.segue(periodoPrecedente) && this.anticipa(periodoSuccessivo)) {
			esito = true;
		} else {
			esito = false;
		}
		return esito;
	}
	/**
	 * Metodo che setta la data inizio dell'istanza su cui � invocato, alla data di inizio del periodo
	 * passato come parametro
	 * @param periodo
	 */
	public void setDataInizioPeriodoDaDataInizioPeriodo(MPeriodo periodo){
		this.set_minutoInizio(periodo.get_minutoInizio());
		this.set_oraInizio(periodo.get_oraInizio());
		this.set_giornoInizio(periodo.get_giornoInizio());
		this.set_meseInizio(periodo.get_meseInizio());
		this.set_annoInizio(periodo.get_annoInizio());
	}
	/**
	 * Metodo che setta la data di inizio dell'istanza su cui � invocato, alla data di fine del periodo
	 * passato come parameto. Per ora e minuto si prendono i parametri di "default" _minutoInizio e _oraInizio,
	 * altrimenti il periodo comincerebbe in un orario sbagliato
	 * @param periodo
	 */
	public void setDataInizioPeriodoDaDataFinePeriodo(MPeriodo periodo){
		this.set_minutoInizio(this.get_minutoInizio());
		this.set_oraInizio(this.get_oraInizio());
		this.set_giornoInizio(periodo.get_giornoFine());
		this.set_meseInizio(periodo.get_meseFine());
		this.set_annoInizio(periodo.get_annoFine());
	}
	/**
	 * Metodo che setta la data di fine del periodo dell'istanza su cui � invocato, alla fine del periodo
	 * passato come parametro.
	 * @param periodo
	 */
	public void setDataFinePeriodoDaDataFinePeriodo(MPeriodo periodo){
		
		this.set_minutoFine(periodo.get_minutoFine());
		this.set_oraFine(periodo.get_oraFine());
		this.set_giornoFine(periodo.get_giornoFine());
		this.set_meseFine(periodo.get_meseFine());
		this.set_annoFine(periodo.get_annoFine());
		
	}	
	/**
	 * Metodo che setta la data di fine del periodo su cui � invocato, alla data di inizio del periodo
	 * passato come parametro. Per ora e minuto si assegnano i valori di default presi da _oraFine, _minutoFine
	 * altrimenti la data di fine sarebbe sbagliata.
	 * @param periodo
	 */
	public void setDataFinePeriodoDaDataInizioPeriodo(MPeriodo periodo){
		this.set_minutoFine(this.get_minutoFine());
		this.set_oraFine(this.get_oraFine());
		this.set_giornoFine(periodo.get_giornoInizio());
		this.set_meseFine(periodo.get_meseInizio());
		this.set_annoFine(periodo.get_annoInizio());
	}
	
	
	/* ------------------------- Getter, Setter ------------------------------------- */
	/**
	 * @return _annoFine
	 * Metodo che restituisce l'intero che rappresenta l'anno della data di fine periodo
	 */
	public int get_annoFine() {
		return _annoFine;
	}
	/**
	 * @param _annoFine 
	 * Metodo che setta l'intero che rappresenta l'anno della data di fine periodo
	 */
	public void set_annoFine(int _annoFine) {
		this._annoFine = _annoFine;
	}
	/**
	 * @return _meseFine
	 * metodo che restituisce l'intero che rappresenta il mese della data di fine periodo
	 */
	public int get_meseFine() {
		return _meseFine;
	}
	/**
	 * @param _meseFine 
	 * Metodo che setta l'intero che rappresenta il mese della data di fine periodo
	 */
	public void set_meseFine(int _meseFine) {
		this._meseFine = _meseFine;
	}
	/**
	 * @return the _giornoFine
	 * Metodo che restituisce l'intero che rappresenta il giorno della data di fine periodo
	 */
	public int get_giornoFine() {
		return _giornoFine;
	}
	/**
	 * @param _giornoFine
	 * Metodo che setta l'intero che rappresenta il giorno della data di fine periodo
	 */
	public void set_giornoFine(int _giornoFine) {
		this._giornoFine = _giornoFine;
	}
	/**
	 * @return the _annoInizio
	 * Metodo che restituisce l'intero che rappresenta l'anno della data di inizio periodo
	 */
	public int get_annoInizio() {
		return _annoInizio;
	}
	/**
	 * @param _annoInizio the _annoInizio to set
	 * Metodo che setta l'intero che rappresenta l'anno della data di inizio periodo
	 */
	public void set_annoInizio(int _annoInizio) {
		this._annoInizio = _annoInizio;
	}
	/**
	 * @return the _meseInizio
	 * Metodo che restituisce l'intero che rappresenta il mese della data di inizio periodo
	 */
	public int get_meseInizio() {
		return _meseInizio;
	}
	/**
	 * @param _meseInizio
	 * Metodo che setta l'intero che rappresenta il mese della data di inizio periodo 
	 */
	public void set_meseInizio(int _meseInizio) {
		this._meseInizio = _meseInizio;
	}
	/**
	 * @return the _giornoInizio
	 * Metodo che restituisce l'intero che rappresenta il giorno della data di inizio periodo
	 */
	public int get_giornoInizio() {
		return _giornoInizio;
	}
	/**
	 * @param _giornoInizio
	 * Metodo che setta l'intero che rappresenta il giorno della data di inizio periodo 
	 */
	public void set_giornoInizio(int _giornoInizio) {
		this._giornoInizio = _giornoInizio;
	}
	/**
	 * @return the _oraInizio
	 * Metodo che restituisce l'intero che rappresenta l'ora della data di inizio periodo
	 */
	public int get_oraInizio() {
		return _oraInizio;
	}
	/**
	 * @param _oraInizio
	 * Metodo che setta l'intero che rappresenta l'ora della data di inizio periodo 
	 */
	public void set_oraInizio(int _oraInizio) {
		this._oraInizio = _oraInizio;
	}
	/**
	 * @param _oraFine
	 * Metodo che setta l'intero che rappresenta l'ora della data di fine periodo 
	 */
	public void set_oraFine(int _oraFine) {
		this._oraFine = _oraFine;
	}
	/**
	 * @return the _oraFine
	 * Metodo che restituisce l'intero che rappresenta l'ora della data di fine periodo
	 */
	public int get_oraFine() {
		return _oraFine;
	}
	/**
	 * @param _minutoInizio
	 * Metodo che setta l'intero che rappresenta il minuto della data di inizio periodo 
	 */
	public void set_minutoInizio(int _minutoInizio) {
		this._minutoInizio = _minutoInizio;
	}
	/**
	 * @return the _minutoInizio
	 * Metodo che restituisce l'intero che rappresenta il minuto della data di inizio periodo
	 */
	public int get_minutoInizio() {
		return _minutoInizio;
	}
	/**
	 * @param _minutoFine
	 * Metodo che setta l'intero che rappresenta il minuto della data di fine periodo 
	 */
	public void set_minutoFine(int _minutoFine) {
		this._minutoFine= _minutoFine;
	}
	/**
	 * @return the _minutoFine
	 * Metodo che restituisce l'intero che rappresenta il minuto della data di fine periodo
	 */
	public int get_minutoFine() {
		return _minutoFine;
	}
	
	
	

	
	
	

}