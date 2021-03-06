/**
 * 
 */
package com.iHotel.view.Event.GestioneSoggiorno.InformazioniSoggiorno;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import com.iHotel.controller.CModificaSoggiorno;

/**
 * Classe addetta alla gestione dell'evento click sul pulsante per aggiungere ospiti al soggiorno.
 * @author Alessandro
 *
 */
public class CheckInPrenotazioneListener extends MouseAdapter {
	/**
	 * Con questo metodo si gestisce l'evento scaturito dal click sul bottone per effettuare il check in degli ospiti.
	 */
	@Override
	public void mouseClicked(MouseEvent e) {
		// Recupero il controllore e invoco il metodo per aggiungere gli ospiti ad un soggiorno.
		CModificaSoggiorno.getInstance().aggiungiOspitiAllaPrenotazione();
	}
}
