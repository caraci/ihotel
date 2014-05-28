/**
 * 
 */
package com.iHotel.view.Graphic.GestionePrenotazione;

import java.util.HashMap;

import javax.swing.JButton;

import com.iHotel.view.Event.GestionePrenotazione.CheckInPrenotazioneListener;
import com.iHotel.view.Event.GestionePrenotazione.GestisciPagamentoListener;
import com.iHotel.view.Event.GestionePrenotazione.TerminaModifichePrenotazione;

/**
 * @author Eugenio
 *
 */
@SuppressWarnings("serial")
public class VPGP_InfoSoggiorno_Prenotato extends VPGP_InfoPrenotazione {

	/**
	 * Costruttore
	 */
	public VPGP_InfoSoggiorno_Prenotato() {
		super();
	}
	
	@Override
	protected void creaPanelBottom(){
		/*Setto il testo del bottone checkin*/
		_btnCheckIn.setText("CheckIn");
		/*Aggiungo il listener al click*/
		_btnCheckIn.addMouseListener(new CheckInPrenotazioneListener());
		/*Setto il testo del bottone Gestione pagamenti*/
		_btnGestionePagamenti.setText("Gestisci pagamenti");
		/*Aggiungo il listener all'evento*/
		_btnGestionePagamenti.addMouseListener(new GestisciPagamentoListener(_prenotazione));
		/*Setto il testo del bottone*/
		_btnTerminaModifichePrenotazione.setText("Termina modifiche");
		/*Aggiungo il listener al click sul pulsante*/
		_btnTerminaModifichePrenotazione.addMouseListener(new TerminaModifichePrenotazione());
		// Struttura dati dove si salvano i bottoni con la relativa posizione.
		HashMap<Integer, JButton> Bottoni = new HashMap<Integer, JButton>();		
		// Aggiungo i bottoni alla struttura.
		//Colonna 0, sarebbe la 1
		Bottoni.put(0, _btnCheckIn);
		//Colonna 3, sarebbe la 4
		Bottoni.put(3, _btnGestionePagamenti);
		//Colonna 6, sarebbe la 7
		Bottoni.put(6,_btnTerminaModifichePrenotazione);
		// Creo la pulsantiera.
		Integer numeroColonne = 7;
		creaPanelPulsanti(_panelBottom, numeroColonne, Bottoni);		
	}

}
