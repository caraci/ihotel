package com.iHotel.persistence;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import com.db4o.config.EmbeddedConfiguration;
import com.db4o.query.Predicate;
import com.iHotel.model.Albergo.PrenotazioneSubject;
import com.iHotel.model.Albergo.ServizioInterno;
import com.iHotel.model.State.CameraContext;
import com.iHotel.model.State.CameraState;
import com.iHotel.model.State.CameraStateOccupata;

public class PersistentManager {
	/* --------------- Attributi e costruttore ------------------- */
	/**
	 * Attributo rappresentante la connessione alla base dati. Per le sue tecnologie, � necessario
	 * che la connessione resti sempre attiva.
	 */
	protected static ObjectContainer _db = null;
	/**
	 * Costruttore che serve ad ottenere la connessione al db.
	 */
	protected PersistentManager(){		
		getConnection();
	}
	/* --------------------------- Metodi di classe ------------------------------ */
	protected static void getConnection() {
		// Se la connessione non � aperta, la si va ad aprire.
		if (_db==null) {
			EmbeddedConfiguration config = Db4oEmbedded.newConfiguration();
			// Configurazioni per l'aggiornamento in cascata degli oggetti delle seguenti classi.
			config.common().objectClass(PrenotazioneSubject.class).cascadeOnUpdate(true);
			config.common().objectClass(CameraContext.class).cascadeOnUpdate(true);
			config.common().objectClass(CameraState.class).cascadeOnUpdate(true);
			config.common().objectClass(CameraStateOccupata.class).cascadeOnUpdate(true);
			config.common().objectClass(ServizioInterno.class).cascadeOnUpdate(true);
			// Configurazione per tirare su l'oggetto completo
			config.common().objectClass(CameraContext.class).minimumActivationDepth(20);
			// Posizione del file contenente la base dati.
			_db=Db4oEmbedded.openFile(config, "dbihotel");
		}
	}
	/* ------------------------- Metodi di instanza ------------------------------ */
	/**
	* Store di un oggetto.
	* 
	* @param arg0
	*/
	public void store(Object arg0) {
		_db.store(arg0);
	}
	/** 
	* Metodo per caricare oggetti dal DB.
	*/
	public <T> ObjectSet<T> query(Predicate<T> arg0) {
		return _db.query(arg0);
	}
	/**
	 * Metodo per chiudere la connessione con il DB.
	 */
	public void close() {
		_db.close();
	}
}
