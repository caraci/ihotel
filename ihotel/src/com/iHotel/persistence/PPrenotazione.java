/**
 * 
 */
package com.iHotel.persistence;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import com.db4o.query.Predicate;
import com.iHotel.model.Albergo.Soggiorno.SoggiornoContextSubject;

/**
 * Classe addetta alla persistenza per la classe PrenotazioneSubject.
 * 
 * @author Eugenio
 */
public class PPrenotazione extends PersistentManager {
	
	/* -------------------- Attributi e costruttore ---------------------- */
	private static PPrenotazione instance=null;
	/**
	 * Costruttore privato - Pattern Singleton.
	 */
	private PPrenotazione(){}
	/* ------------------ Metodi di classe ----------------------------- */
	/**
	 * Metodo per ottenere l'instanza della classe - Pattern Singleton.
	 */
	public static PPrenotazione getInstance(){
		if(instance == null) {
            instance = new PPrenotazione();
         }
         return instance;
	}
	/* ----------------------- Metodi di instanza ----------------------- */
	/**
	 * Metodo per caricare tutte le prenotazioni presenti nella base dati.
	 * 
	 * @return L'insieme delle prenotazioni dell'albergo.
	 */
	public List<SoggiornoContextSubject> caricaPrenotazioni() {
		@SuppressWarnings("serial")
		List<SoggiornoContextSubject> prenotazioni = query(new Predicate<SoggiornoContextSubject>() {
			public boolean match(SoggiornoContextSubject candidate) {
				return true;
			}
		});
		return prenotazioni;
	}
	/**
	 * Metodo per caricare la mappa delle prenotazioni.
	 * 
	 * @return Mappa delle prenotazioni dove la chiave � il codice della prenotazione, e il valore � la prenotazione.
	 */
	public HashMap<String, SoggiornoContextSubject> caricaMappaCodicePrenotazione() {
		@SuppressWarnings("serial")
		List<SoggiornoContextSubject> listPrenotazioni = query(new Predicate<SoggiornoContextSubject>() {
			public boolean match(SoggiornoContextSubject candidate) {
				return true;
			}
		});
		// Creo la mappa.
		HashMap<String,SoggiornoContextSubject> mappaPrenotazioni = new HashMap<String,SoggiornoContextSubject>();
		// Ciclo sulle prenotazioni.
		for (Iterator<SoggiornoContextSubject> iterator = listPrenotazioni.iterator(); iterator.hasNext();) {
			SoggiornoContextSubject prenotazioneSubject = (SoggiornoContextSubject) iterator.next();
			mappaPrenotazioni.put(prenotazioneSubject.get_codice(), prenotazioneSubject);				
		}
		
		return mappaPrenotazioni;
	}
}
