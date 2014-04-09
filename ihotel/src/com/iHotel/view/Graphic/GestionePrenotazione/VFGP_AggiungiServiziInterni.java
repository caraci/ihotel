/**
 * 
 */
package com.iHotel.view.Graphic.GestionePrenotazione;

import java.util.HashMap;
import java.util.Iterator;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.iHotel.model.Albergo.Cataloghi.DescrizioneServizioInterno;
import com.iHotel.view.View;
import com.iHotel.view.Event.GestionePrenotazione.MostraInformazioniServizioListener;

/**
 * @author Eugenio
 *
 */
@SuppressWarnings("serial")
public class VFGP_AggiungiServiziInterni extends View {
	/* ----------------------------- Attributi e Costruttore ----------------- */
	// Singleton
	private static VFGP_AggiungiServiziInterni instance=null;
	private HashMap<String,DescrizioneServizioInterno> _descrizioniServizi;
	
	/* JComboBox */
	private JComboBox<JLabel> _comboBoxServizi;
	/**
	 * Costruttore privato - Pattern Singleton
	 */
	private VFGP_AggiungiServiziInterni() {
		_comboBoxServizi=new JComboBox<>();
	}
	/* ------------------------------- Metodi di classe -------------------------- */
	/**
	 * Metodo per ottenere l'unica instanza di questa classe - Pattern singleton
	 */
	public static VFGP_AggiungiServiziInterni getInstance() {
    	if(instance == null) {
            instance = new VFGP_AggiungiServiziInterni();
         }
         return instance;
    }
	/* ------------------------------ Metodi di instanza ------------------------ */
	
	public JPanel creaListaServizi() {
		// Ciclo sui servizi interni.
		for (Iterator<String> iterator = _descrizioniServizi.keySet().iterator(); iterator.hasNext();) {
			String codiceServizio = (String) iterator.next();
			// Chiedo una nuova label alla factory e ne setto il testo.
			JLabel lblServizioInterno=_viewFactory.getLabel();
			lblServizioInterno.setText(_descrizioniServizi.get(codiceServizio).get_nome());
			// Aggiungo l'eventListener alla label, e fornisco il codice del servizio.
			lblServizioInterno.addMouseListener(new MostraInformazioniServizioListener(codiceServizio));
			// Aggiungo la label alla comboBox
			_comboBoxServizi.addItem(lblServizioInterno);
		}
		return null;
	}
	public void creaFrame(HashMap<String,DescrizioneServizioInterno> descrizioniServizi) {
		// Memorizzo come attributo dell'interfaccia il parametro ricevuto.
		_descrizioniServizi=descrizioniServizi;
		// Pannello per creare la lista dei servizi
		creaListaServizi();
	}
	/* ----------------------------- Getter, Setter ------------------------------- */
	/**
	 * @return the _descrizioniServizi
	 */
	public HashMap<String, DescrizioneServizioInterno> get_descrizioniServizi() {
		return _descrizioniServizi;
	}
	/**
	 * @param _descrizioniServizi the _descrizioniServizi to set
	 */
	public void set_descrizioniServizi(
			HashMap<String, DescrizioneServizioInterno> _descrizioniServizi) {
		this._descrizioniServizi = _descrizioniServizi;
	}
}
