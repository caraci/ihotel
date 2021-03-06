/**
 * 
 */
package com.iHotel.view.Graphic.GestioneSoggiorno.InformazioniSoggiorno;

import java.util.HashMap;

import javax.swing.JButton;

import com.iHotel.view.Event.GestioneSoggiorno.InformazioniSoggiorno.EffettuaCheckOutListener;
import com.iHotel.view.Event.GestioneSoggiorno.InformazioniSoggiorno.GestisciPagamentoListener;
import com.iHotel.view.Event.GestioneSoggiorno.InformazioniSoggiorno.TerminaModifichePrenotazione;

/**
 * Classe addetta alla realizzazione della finestra per mostrare le informazioni di una prenotazione in corso
 * 
 * @author Eugenio
 *
 */
@SuppressWarnings("serial")
public class VPGP_InfoSoggiorno_InCorso extends VPGP_InfoSoggiorno {
	
	private JButton _btnCheckOut;
	/**
	 * Costruttore
	 */
	public VPGP_InfoSoggiorno_InCorso() {
		super();
		// JButton
		_btnCheckOut = _viewFactory.getButton();
	}
	
	@Override
	protected void setLblStatoSoggiorno(){
		_lblStatoSoggiorno.setText("Soggiorno in corso");
	}
	
	@Override
	protected void creaPanelBottom(){
		/*Setto il testo del bottone checkin*/
		_btnCheckOut.setText("CheckOut");
		/*Aggiungo il listener al click*/
		_btnCheckOut.addMouseListener(new EffettuaCheckOutListener(_soggiorno));
		/*Setto il testo del bottone Gestione pagamenti*/
		_btnGestionePagamenti.setText("Gestisci pagamenti");
		/*Aggiungo il listener all'evento*/
		_btnGestionePagamenti.addMouseListener(new GestisciPagamentoListener(_soggiorno));
		/*Setto il testo del bottone*/
		_btnTerminaModifichePrenotazione.setText("Indietro");
		/*Aggiungo il listener al click sul pulsante*/
		_btnTerminaModifichePrenotazione.addMouseListener(new TerminaModifichePrenotazione());
		// Struttura dati dove si salvano i bottoni con la relativa posizione.
		HashMap<Integer, JButton> Bottoni = new HashMap<Integer, JButton>();		
		// Aggiungo i bottoni alla struttura.
		//Colonna 0, sarebbe la 1
		Bottoni.put(0,_btnTerminaModifichePrenotazione);		
		//Colonna 2, sarebbe la 3
		Bottoni.put(2, _btnGestionePagamenti);
		//Colonna 4, sarebbe la 5
		Bottoni.put(4, _btnCheckOut);
		// Creo la pulsantiera.
		Integer numeroColonne = 5;
		creaPanelPulsanti(_panelBottom, numeroColonne, Bottoni);		
	}
	

}
