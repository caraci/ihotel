/**
 * 
 */
package com.iHotel.view.Event;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import com.iHotel.controller.CModificaSoggiorno;

/**
 * Classe addetta alla gestione dell'evento per gestire una prenotazione dalla lista presenta nella schermata iniziale.
 * @author Eugenio
 *
 */
public class CaricaGestionePrenotazioneFromList extends MouseAdapter {
	/**
	 * Codice della prenotazione da caricare.
	 */
	private String _codicePrenotazione;
	/**
	 * Costruttore.
	 * 
	 * @param codicePrenotazione Codice della prenotazione da recuperare.
	 */
	public CaricaGestionePrenotazioneFromList(String codicePrenotazione) {
		_codicePrenotazione = codicePrenotazione;
	}
	/**
	 * Con questo metodo si va a gestire l'evento relativo al click sul bottone per la gestione di una prenotazione.
	 */
	@Override
	public void mouseClicked(MouseEvent e) {		
		//Recupero la prenotazione dal codice
		CModificaSoggiorno.getInstance().recuperaSoggiornoDaCodice(_codicePrenotazione);
	}
}
