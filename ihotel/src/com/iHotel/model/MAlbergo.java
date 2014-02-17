package com.iHotel.model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;


public class MAlbergo {
    
	/* -------------------- Attributi e costruttore --------------------------*/
	
 	private MCatalogoCamere _catalogoCamere;
	private ArrayList<MCamera> _camere;
	private ArrayList<MPrenotazione> _prenotazioni = new ArrayList<MPrenotazione>();
	private String _nome;
	private String _telefono;
	private String _PIVA;
	private String _eMail;
	// Singleton 
	private static MAlbergo instance = null;
	
	/**
	 * Costruttore privato - pattern Singleton
	 * @throws IOException 
	 */
	private MAlbergo() throws IOException {
		String filePath = new File("").getAbsolutePath();
        System.out.println (filePath);
		try (BufferedReader albergoReader = new BufferedReader(new FileReader(filePath + "/configs/Albergo.txt"))) {  
			// Inizializzo gli attributi
			_nome = albergoReader.readLine();
			_telefono = albergoReader.readLine();
			_PIVA = albergoReader.readLine();
			_eMail = albergoReader.readLine();
		} catch (IOException e) {
			_nome = "Hotel Meraviglioso";
			_telefono = "06808182";
			_PIVA = "123456789ABCDEF";
			_eMail = "info@hotelmeraviglioso.com";
        } 
	}
	
	/* ----------------------------- Metodi di classe -----------------------*/
	
	/**
	 * 
	 * @return instance
	 * @throws IOException 
	 */
	public static MAlbergo getInstance() throws IOException {
    	if(instance == null) {
            instance = new MAlbergo();
         }
         return instance;
    }
	
	/* -------------------- Metodi di instanza ----------------------*/
	
	/**
	 * Metodo per ricavare l'oggetto MCamera a partire dalla stringa contenente il suo numero.
	 * 
	 * @param numeroCamera Stringa contenente il numero della camera da ricavare.
	 * @return cameraRicercata Camera che ha il numero passato come parametro.
	 */
	public MCamera getCameraDaNumero(String numeroCamera) {
		MCamera cameraRicercata = new MCamera();
		for (Iterator<MCamera> iterator = _camere.iterator(); iterator.hasNext();) {
			MCamera camera = (MCamera) iterator.next();
			if (camera.get_numero().equals(numeroCamera)) {
				cameraRicercata = camera;
			}
		}
		return cameraRicercata;
	}
	/**
	 * Restituisce una lista di camere libere data una tipologia e un periodo.
	 * 
	 * @param periodo il periodo per cui si vogliono ricercare le camere libere
	 * @param tipologia � la tipologia delle camere da ricercare
	 * @return lista_camere lista contenente le camere libere della tipologia indicata, nel periodo indicato
	 */
	public ArrayList<MCamera> cercaCamereLibereInPeriodoDaTipologia(MPeriodo periodo, String tipologia){
		ArrayList<MCamera> lista_camere = new ArrayList<MCamera>();
		for (Iterator<MCamera> iterator = _camere.iterator(); iterator.hasNext();) {
			MCamera camera = iterator.next();
			if (camera.get_tipologia().equals(tipologia)){
				if(camera.isLiberaInPeriodo(periodo)==true){
					lista_camere.add(camera);
				}
			}
		}
		return lista_camere;
	}
	/**
	 * Metodo che restituisce una HashMap in cui la chiave � la tipolgia della camera e il valore
	 * � un arraylist di MPrezzoCamera.
	 * 
	 * @param periodo � il periodo per cui si stanno richiedendo i prezzi
	 * @param tipologia � la tipologia per cui si richiedono i prezzi
	 * @return catalogoCamere.getPrezziInPeriodoDaTipologia(MPeriodo,String) mappa contenente l'insieme dei prezzi delle camere 
	 * della tipologia data nel periodo dato
	 */
	public HashMap<String,ArrayList<MPrezzoCamera>> getPrezziInPeriodoDaTipologia(MPeriodo periodo, String tipologia){
		MCatalogoCamere catalogoCamere =MCatalogoCamere.getInstance();
		return catalogoCamere.getPrezziInPeriodoDaTipologia(periodo, tipologia);
	}

	/*---------------------- Getter e Setter --------------------*/
	/**
	 * @return _catalogoCamere
	 */
	public MCatalogoCamere get_catalogoCamere() {
		return _catalogoCamere;
	}

	/**
	 * @param _catalogoCamere 
	 */
	public void set_catalogoCamere(MCatalogoCamere _catalogoCamere) {
		this._catalogoCamere = _catalogoCamere;
	}


	/**
	 * @return _camere
	 */
	public ArrayList<MCamera> get_camere() {
		return _camere;
	}

	/**
	 * @param _camere
	 */
	public void set_camere(ArrayList<MCamera> _camere) {
		this._camere = _camere;
	}

	/**
	 * @return _prenotazioni	 
	 */
	public ArrayList<MPrenotazione> get_prenotazioni() {
		return _prenotazioni;
	}

	/**
	 * @param _prenotazioni 
	 */
	public void set_prenotazioni(ArrayList<MPrenotazione> _prenotazioni) {
		this._prenotazioni = _prenotazioni;
	}

	/**
	 * @param prenotazione 
	 */
	public void addPrenotazione(MPrenotazione prenotazione) {
		this._prenotazioni.add(prenotazione);
	}
	/**
	 * @return _nome
	 */
	public String get_nome() {
		return this._nome;
	}

	/**
	 * @param _nome 
	 */
	public void set_nome(String _nome) {
		this._nome = _nome;
	}
	/**
	 * @return _telefono 
	 */
	public String get_telefono() {
		return this._telefono;
	}

	/**
	 * @param _telefono 
	 */
	public void set_telefono(String _telefono) {
		this._telefono = _telefono;
	}
	/**
	 * @return _PIVA 
	 */
	public String get_PIVA() {
		return this._PIVA;
	}

	/**
	 * @param _PIVA 
	 */
	public void set_PIVA(String _PIVA) {
		this._PIVA = _PIVA;
	}
	/**
	 * @return _email 
	 */
	public String get_eMail() {
		return this._eMail;
	}

	/**
	 * @param _eMail 
	 */
	public void set_eMail(String _eMail) {
		this._eMail = _eMail;
	}	 

}