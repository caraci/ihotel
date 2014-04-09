/**
 * 
 */
package com.iHotel.view.Event;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import com.iHotel.controller.CCreaPrenotazione;

/**
 * @author Eugenio
 *
 */
public class CaricaCreaNuovaPrenotazioneListener extends MouseAdapter {
	
	@Override
	/**
	 * Con questo metodo si va a gestire l'evento relativo al click sul bottone per la creazione di una nuova 
	 * prenotazione.
	 */
	public void mouseClicked(MouseEvent e) {
		// Recupero il controllore e invoco il metodo relativo alla creazione di una nuova prenotazione.
		CCreaPrenotazione creatorePrenotazione = CCreaPrenotazione.getInstance();
		creatorePrenotazione.creaNuovaPrenotazione();
	}

}
