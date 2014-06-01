/**
 * 
 */
package com.iHotel.model.ForeignSystem.LettoreCarte;

import com.iHotel.model.Persona.Documenti.CartaDiCredito;

/**
 * Classe interfaccia a capo della gerarchia degli adattatori di lettori di carte di credito
 * 
 * @author Gabriele
 */
public interface ILettoreCarteAdapter {	
	/**
	* Metodo fittizio per leggere la carta. Nella realt� ci si collegher� con un sistema esterno.
	*/
	public CartaDiCredito leggiCarta();
}
