package com.iHotel.model.Albergo.Soggiorno;

import java.util.*;

import com.iHotel.model.Albergo.Camera.Camera;
import com.iHotel.model.Albergo.Cataloghi.CatalogoCamere;
import com.iHotel.model.Albergo.Cataloghi.DescrizioneCamera;
import com.iHotel.model.ForeignSystem.ServiceFactory;
import com.iHotel.model.Observer.IObserver;
import com.iHotel.model.Observer.ISubject;
import com.iHotel.model.Pagamento.Pagamento;
import com.iHotel.model.Persona.ClientePrenotante;
import com.iHotel.model.StrategieSoggiorno.AmmontareCaparra.ComponentOttieniAmmontareCaparraStrategy;
import com.iHotel.model.StrategieSoggiorno.AmmontareCaparra.StrategiaSoggiornoAmmontareCaparraFactory;
import com.iHotel.model.StrategieSoggiorno.GiornoScadenza.ComponentOttieniGiornoScadenzaStrategy;
import com.iHotel.model.StrategieSoggiorno.GiornoScadenza.StrategiaSoggiornoGiornoScadenzaFactory;
import com.iHotel.model.Utility.Giorno;
import com.iHotel.model.Utility.Periodo;
import com.iHotel.model.Utility.Prezzo;
/**
 * Questa classe rappresenta il concetto di "Prenotazione" di una stanza d'albergo del mondo reale. 
 * Poich� per necessit� di design era necessario aggiornare alcuni oggetti software in seguito al cambiamento di uno degli 
 * attributi di un'oggetto di questa classe (e.g.: si aggiunge una camera alla prenotazione, deve essere notificato un 
 * cambiamento di prezzo all'operatore che si trova davanti al pc) questa classe � stata realizzata sfruttando il design
 * pattern "Observer". In particolare implementa la classe ISubject.
 * 
 * @author Alessandro
 */
public class SoggiornoContextSubject implements ISubject {

	/* ---------------------- Atrributi e costruttore --------------------------------*/
	/**
	 * Lista delle camere prenotate per questo soggiorno.
	 */
	private ArrayList<Camera> _camerePrenotate;
	/**
	 * Lista degli osservatori di questo oggetto - Pattern Observer
	 */
	private ArrayList<IObserver> _osservatori;
	
	/**
	 * Lista dei pagamenti effettuati a favore del soggiorno.
	 */
	private ArrayList<Pagamento> _pagamenti;
	/**
	 * Il periodo della prenotazione va dal giorno in cui l'ospite inizia il soggiorno, al giorno in cui l'ospite 
	 * termina il soggiorno e lascia la struttura ricettiva.
	 */
	private Periodo _periodo;
	/**
	 * Cliente prenotante del soggiorno.
	 */
	private ClientePrenotante _prenotante;
	/**
	 * Importo totale per le camere riservate da questo soggiorno.
	 */
	private Prezzo _importoTotaleCamere;
	/**
	 * Codice identificativo del soggiorno.
	 */
	private String _codice;
	/**
	 * Giorno limite entro il quale deve essere fornito, o una carta di credito o un bonifico a favore della richiesta di soggiorno.
	 */
	private Giorno _giornoScadenzaInvioGaranzia;
	/**
	 * Ammontare della caparra da versare per garantire la prenotazione
	 */
	private Prezzo _ammontareCaparra;
	/**
	 * Stato in cui si trova il soggiorno - Pattern State
	 */
	private SoggiornoState _statoSoggiorno;
	/**
	 *  Importo rimanente da pagare per il soggiorno
	 */
	private Prezzo _importoRimanenteDaPagare;
	/**
	 * 	Importo totale pagamenti ricevuti per il soggiorno
	 */
	private Prezzo _importoTotalePagamenti;
	
	/**
	 * Costruttore.
	 */
	public SoggiornoContextSubject() {
		_camerePrenotate = new ArrayList<Camera>();
		_osservatori = new ArrayList<IObserver>();
		_importoTotaleCamere = new Prezzo();
		_pagamenti= new ArrayList<Pagamento>();
		_ammontareCaparra = new Prezzo();
		_statoSoggiorno = new SoggiornoPrenotato();
		_importoRimanenteDaPagare = new Prezzo();
		_importoTotalePagamenti = new Prezzo();
	}
	
	/* ----------------------------------- Metodi di classe ------------------------------------------- */
	/**
	 * Metodo per generare il codice della prenotazione.
	 * 
	 * @return Codice della prenotazione, legato al timestamp del sistema.
	 */
	public static String generaCodice(){
		long codice;
		codice = Calendar.getInstance().getTime().getTime();
		return String.valueOf(codice);
	}
	
	/* ----------------------------------- Metodi di instanza ----------------------------------------- */
	
	/* ----------- Pattern Observer -------- */
	@Override
	public void Attach(IObserver observer) {
		_osservatori.add(observer);
	}
	@Override
	public void Detach(IObserver observer) {
		_osservatori.remove(observer);
	}
	@Override
	public void Notify() {
		for (Iterator<IObserver> iterator = _osservatori.iterator(); iterator.hasNext();) {
			IObserver observer = (IObserver) iterator.next();
			observer.Update();
		}
	}
	/* ------------ /Pattern Observer -------- */
	/**
	 * Metodo per ottenere il prezzo dei servizi interni di una prenotazione.
	 * @return Prezzo dei servizi interni di una prenotazione.
	 */
	public Prezzo getPrezzoServiziInterni(){
		Prezzo prezzo = new Prezzo();
		// Ciclo su tutte le camere
		for (Iterator<Camera> iterator = _camerePrenotate.iterator(); iterator.hasNext();) {
			Camera camera = (Camera) iterator.next();
			prezzo.somma(camera.getPrezzoServiziInPeriodo(_periodo));
		}
		return prezzo;
	}
	/**
	 * Metodo per calcolare il totale di una prenotazione
	 */
	public void calcolaImportoTotaleCamere(){
		DescrizioneCamera descrizione;
		// Prendo l'ultima camera aggiunta.
		Camera cameraPrenotata;
		cameraPrenotata=_camerePrenotate.get(_camerePrenotate.size()-1);
		// Prendo la tipologia e carico la giusta descrizione.
		String tipologia=cameraPrenotata.get_tipologia();
		descrizione=CatalogoCamere.getInstance().getDescrizioneDaTipologia(tipologia);
		// Richiedo il prezzo totale nel periodo per la camera e lo sommo al totale.
		_importoTotaleCamere.somma(descrizione.calcolaPrezzoInPeriodo(_periodo));
		// Una volta calcolato il nuovo totale, mediante il pattern Observer, notifico a tutti gli osservatori il cambio
		// di stato della prenotazione.
		this.Notify();
	}
	/**
	 * Metodo per calcolare il rimanente importo da pagare
	 */
	public void calcolaTotaleDaPagare(){
		Prezzo importoDaPagare = new Prezzo();
		Prezzo totaleServiziEsterni = new Prezzo();
		
		totaleServiziEsterni = ServiceFactory.getInstance().getPrezzoServiziEsterniPrenotazione(this);
		// Aggiungo tutti i costi della prenotazione
		importoDaPagare.somma(_importoTotaleCamere);
		importoDaPagare.somma(totaleServiziEsterni);
		importoDaPagare.somma(this.getPrezzoServiziInterni());
		// Sottraggo i pagamenti pervenuti
		importoDaPagare.sottrai(this.get_importoTotalePagamenti());
		
		_importoRimanenteDaPagare=importoDaPagare;
	}
	/**
	 * Metodo per aggiungere una camera alla prenotazione.
	 * 
	 * @param camera Camera da aggiungere alla prenotazione.
	 */
	public void addCamera(Camera camera) {
		_camerePrenotate.add(camera);
	}
	/**
	 * Metodo per aggiungere l'ospite prenotante.
	 * 
	 * @param nome Nome del prenotante.
	 * @param cognome Cognome del prenotante
	 * @param eMail eMail del prenotante.
	 * @param telefono Telefono del prenotante.
	 */
	public void addPrenotante(String nome, String cognome, String eMail, String telefono) {
		_prenotante = new ClientePrenotante();
		_prenotante.set_nome(nome);		
		_prenotante.set_cognome(cognome);
		_prenotante.set_email(eMail);
		_prenotante.set_telefono(telefono);
	}
	/**
	 * Metodo per occupare le camere della prenotazione.
	 */
	public void occupaCamere() {
		for (Iterator<Camera> iterator = _camerePrenotate.iterator(); iterator.hasNext();) {
			Camera cameraPrenotata = (Camera) iterator.next();
			cameraPrenotata.occupaInPeriodoState(_periodo);
		}
	}
	/**
	 * Metodo per aggiungere un pagamento alla prenotazione.
	 * 
	 * @param pagamento Pagamento effettuato a favore del soggiorno.
	 */
	public void addPagamento(Pagamento pagamento) {
		//Aggiungo il pagamento alla lista di pagamenti.
		this._pagamenti.add(pagamento);
		//Sommo l'importo del pagamento al totale dei pagamenti
		this._importoTotalePagamenti.somma(pagamento.get_importo());
	}
	/**
	 * Metodo per concludere la richiesta di soggiorno.
	 * 
	 * @param nome Nome del prenotante.
	 * @param cognome Cognome del prenotante.
	 * @param eMail eMail del prenotante.
	 * @param telefono Telefono del prenotante.
	 */
	public void concludiPrenotazione(String nome, String cognome, String eMail, String telefono) {
		// Factory delle strategie.
		StrategiaSoggiornoGiornoScadenzaFactory strategiaGiornoScadenzaFactory = StrategiaSoggiornoGiornoScadenzaFactory.getInstance();
		StrategiaSoggiornoAmmontareCaparraFactory strategiaAmmontareCaparraFactory = StrategiaSoggiornoAmmontareCaparraFactory.getInstance();
		// Aggiungo l'ospite alla prenotazione
		this.addPrenotante(nome, cognome, eMail, telefono);
		// Occupo le camere scelte dall'utente
		this.occupaCamere();
		// Setto il codice alla prenotazione
		this.set_codice(SoggiornoContextSubject.generaCodice());
		// Strategia per il calcolo del giorno di scadenza
		ComponentOttieniGiornoScadenzaStrategy strategiaGiornoScadenza = strategiaGiornoScadenzaFactory.getStrategyCalcoloGiornoScadenza();
		// Setto il giorno di scadenza per l'invio della garanzia.
		this.set_giornoScadenzaInvioGaranzia(strategiaGiornoScadenza.getGiornoScadenza(this));
		// Strategia per il calcolo dell'ammontare della caparra
		ComponentOttieniAmmontareCaparraStrategy strategiaAmmontareCaparra = strategiaAmmontareCaparraFactory.getStrategyAmmontareCaparra();
		// Setto l'ammontare della caparra
		this.set_ammontareCaparra(strategiaAmmontareCaparra.getAmmontareCaparra(this));
	}
	
	/* -------------------------------- Getter, Setter ------------------------------------------ */
	/**
	 * @return _elementiPrenotazione
	 */
	public ArrayList<Camera> get_camerePrenotate() {
		return _camerePrenotate;
	}

	/**
	 * @param _elementiPrenotazione
	 */
	public void set_camerePrenotate(ArrayList<Camera> _elementiPrenotazione) {
		this._camerePrenotate = _elementiPrenotazione;
	}

	/**
	 * @return  _periodo
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
	/**
	 * @return _prenotante
	 */
	public ClientePrenotante get_prenotante(){
		return this._prenotante;
	}
	/**
	 * @return _total 
	 */
	public Prezzo get_importoTotaleCamere() {
		return this._importoTotaleCamere;
	}
	/**
	 * @param _total the total to set
	 */
	public void set_importoTotaleCamere(Prezzo _total) {
		this._importoTotaleCamere = _total;
	}

	/**
	 * @return the _codice
	 */
	public String get_codice() {
		return _codice;
	}

	/**
	 * @param _codice the _codice to set
	 */
	public void set_codice(String _codice) {
		this._codice = _codice;
	}

	/**
	 * @return the _giornoScadenzaInvioGaranzia
	 */
	public Giorno get_giornoScadenzaInvioGaranzia() {
		return _giornoScadenzaInvioGaranzia;
	}
	
	/**
	 * @param _giornoScadenzaInvioGaranzia the _giornoScadenzaInvioGaranzia to set
	 */
	public void set_giornoScadenzaInvioGaranzia(Giorno _giornoScadenzaInvioGaranzia) {
		this._giornoScadenzaInvioGaranzia = _giornoScadenzaInvioGaranzia;
	}

	/**
	 * @return the _pagamenti
	 */
	public ArrayList<Pagamento> get_pagamenti() {
		return _pagamenti;
	}

	/**
	 * @param _pagamenti the _pagamenti to set
	 */
	public void set_pagamenti(ArrayList<Pagamento> _pagamenti) {
		this._pagamenti = _pagamenti;
	}

	/**
	 * @return the _ammontareCaparra
	 */
	public Prezzo get_ammontareCaparra() {
		return _ammontareCaparra;
	}

	/**
	 * @param _ammontareCaparra the _ammontareCaparra to set
	 */
	public void set_ammontareCaparra(Prezzo _ammontareCaparra) {
		this._ammontareCaparra = _ammontareCaparra;
	}

	/**
	 * @return the _statoSoggiorno
	 */
	public SoggiornoState get_statoSoggiorno() {
		return _statoSoggiorno;
	}

	/**
	 * @param _statoSoggiorno the _statoSoggiorno to set
	 */
	public void set_statoSoggiorno(SoggiornoState _statoSoggiorno) {
		this._statoSoggiorno = _statoSoggiorno;
	}

	public Prezzo get_importoRimanenteDaPagare() {
		return _importoRimanenteDaPagare;
	}

	public void set_importoRimanenteDaPagare(Prezzo _importoRimanenteDaPagare) {
		this._importoRimanenteDaPagare = _importoRimanenteDaPagare;
	}

	/**
	 * @return the _importoTotalePagamenti
	 */
	public Prezzo get_importoTotalePagamenti() {
		return _importoTotalePagamenti;
	}

	/**
	 * @param _importoTotalePagamenti the _importoTotalePagamenti to set
	 */
	public void set_importoTotalePagamenti(Prezzo _importoTotalePagamenti) {
		this._importoTotalePagamenti = _importoTotalePagamenti;
	}
}