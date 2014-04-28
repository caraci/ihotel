/**
 * 
 */
package com.iHotel.persistence;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.db4o.query.Predicate;
import com.iHotel.model.State.CameraContext;

/**
 * Classe addetta alla persistenza per la classe CameraContext.
 * 
 * @author Eugenio
 */
public class PCamera extends PersistentManager {
	
	/* -------------------- Attributi e costruttore ---------------------- */
	private static PCamera instance=null;
	/**
	 * Costruttore privato - Pattern Singleton
	 */
	private PCamera(){}
	/* ------------------ Metodi di classe ----------------------------- */
	/**
	 * Metodo per ottenere l'instanza della classe - Pattern Singleton
	 */
	public static PCamera getInstance(){
		if(instance == null) {
            instance = new PCamera();
         }
         return instance;
	}
	/* ------------------- Metodi di instanza -------------------------- */
	/**
	 * Metodo per caricare tutte le camere presenti nella base dati.
	 * 
	 * @return L'insieme delle camere dell'albergo.
	 */
	public ArrayList<CameraContext> caricaCamere() {
		@SuppressWarnings("serial")
		List<CameraContext> camere = query(new Predicate<CameraContext>() {
			public boolean match(CameraContext candidate) {
				return true;
			}
		});
		// Creo la lista di camere
		ArrayList<CameraContext> _camere = new ArrayList<CameraContext>();
		for (Iterator<CameraContext> iterator = camere.iterator(); iterator.hasNext();) {
			CameraContext camera = (CameraContext) iterator.next();
			_camere.add(camera);
		}
		return _camere;
	}
}
