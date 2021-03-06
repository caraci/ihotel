/**
 * 
 */
package com.iHotel.model.ForeignSystem.SchedePS;

import com.iHotel.model.Albergo.Soggiorno.SoggiornoContextSubject;

/**
 * Classe interfaccia a capo della gerarchia degli adattatori dei sistemi esterni per la generazione 
 * delle schedine di pubblica sicurezza
 * 
 * @author Alessandro
 *
 */
public interface ISchedePSAdapter {
	/**
	 * Metodo per generare ed inviare le schedine di pubblica sicurezza.+
	 * 
	 * @param soggiorno Soggiorno in analisi.
	 */
	public void generaSchedePubblicaSicurezza(SoggiornoContextSubject soggiorno);
}
