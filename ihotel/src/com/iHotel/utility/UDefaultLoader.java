package com.iHotel.utility;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class UDefaultLoader {
	
	/* -------------------------- Attributi e costruttore ----------------------- */
	private String _pathToConfigs = "/configs/";
	private static UDefaultLoader instance = null;
	/**
	 * Costruttore privato - Pattern singleton
	 */
	private UDefaultLoader(){}
	/**
	 * Metodo per ottenere l'instanza unica di questa classe - Pattern singleton
	 * @return
	 */
	/* ----------------------- Metodi di classe -------------------------------- */
	public static UDefaultLoader getInstance(){
		if (instance == null){
			instance = new UDefaultLoader();
		}
		return instance;
	}
	/* ------------------------- Metodi di instanza ------------------------------ */
	/**
	 * Metodo per andare a leggere in un file di configurazione i valori relativi a nome, telefono, PIVA e eMail della
	 * classe MAlbergo.
	 * 
	 * @return Collezione contenente nome, telefono, PIVA e eMail.
	 */
	public ArrayList<String> getInformazioniAlbergo(){
		// Variabili nelle quali andremo a memorizzare gli attributi dell'albergo.
		String nome, telefono, PIVA, eMail;
		// Ricavo il path assoluto.
		String filePath = new File("").getAbsolutePath();
		// Provo ad aprire il file di testo. Se non riesco setto degli attributi di default.
		try (BufferedReader albergoReader = new BufferedReader(new FileReader(filePath + _pathToConfigs + "albergo.txt"))) {  
			// Inizializzo gli attributi
			nome = albergoReader.readLine();
			telefono = albergoReader.readLine();
			PIVA = albergoReader.readLine();
			eMail = albergoReader.readLine();
		} catch (IOException e) {
			nome = "Hotel Meraviglioso";
			telefono = "06808182";
			PIVA = "123456789ABCDEF";
			eMail = "info@hotelmeraviglioso.com";
        } 
		ArrayList<String> attributiAlbergo = new ArrayList<String>();
		// Aggiungi gli attributi all'ArrayList di stringhe.
		attributiAlbergo.add(nome);
		attributiAlbergo.add(telefono);
		attributiAlbergo.add(PIVA);
		attributiAlbergo.add(eMail);
		
		return attributiAlbergo;	
	}
	/**
	 * Metodo per andare a leggere in un file di configurazione che tipo di stile vogliamo assegnare all'interfaccia.
	 * 
	 * @return Stringa contenente lo stile da utilizzare.
	 */
	public String getStileInterfaccia(){
		// Variabile nelle quali andremo a memorizzare lo stile dell'interfaccia.
		String stile;
		// Ricavo il path assoluto.
		String filePath = new File("").getAbsolutePath();
		// Provo ad aprire il file di testo. Se non riesco setto degli attributi di default.
		try (BufferedReader interfacciaReader = new BufferedReader(new FileReader(filePath + _pathToConfigs + "interfaccia.txt"))) {  
			// Inizializzo gli attributi
			stile = interfacciaReader.readLine();
		} catch (IOException e) {
			stile = "light";
        }
		return stile;	
	}
	/**
	 * Metodo per andare a leggere in un file di configurazione quali sistemi esterni utilizzare in merito alla gestione dei servizi.
	 * 
	 * @return Lista contenente i sistemi esterni da utilizzare
	 */
	public ArrayList<String> getSistemiServiziEsterni() {
		// Variabili nelle quali andremo a memorizzare gli attributi dell'albergo.
			String payTvSystem, telephoneSystem;
			// Ricavo il path assoluto.
			String filePath = new File("").getAbsolutePath();
			// Provo ad aprire il file di testo. Se non riesco setto degli attributi di default.
			try (BufferedReader sistemiEsterniReader = new BufferedReader(new FileReader(filePath + _pathToConfigs + "sistemiEsterni.txt"))) {  
				// Inizializzo gli attributi
				payTvSystem = sistemiEsterniReader.readLine();
				telephoneSystem = sistemiEsterniReader.readLine();
			} catch (IOException e) {
				payTvSystem = "Sky";
				telephoneSystem = "Telecom";
	        } 
			ArrayList<String> sistemiEsterni = new ArrayList<String>();
			// Aggiungi gli attributi all'ArrayList di stringhe.
			sistemiEsterni.add(payTvSystem);
			sistemiEsterni.add(telephoneSystem);
			
			return sistemiEsterni;
	}
	/* --------------------------------- Getter, Setter ---------------------------------- */
	/**
	 * @return _pathToConfigs
	 */
	public String get_PathToConfigs() {
		return _pathToConfigs;
	}
	/**
	 * @param _pathToConfigs
	 */
	public void set_PathToConfigs(String _pathToConfigs) {
		this._pathToConfigs = _pathToConfigs;
	}

}
