/**
 * 
 */
package com.iHotel.model.StrategieSoggiorno.GiornoScadenza;


import com.iHotel.model.Albergo.Soggiorno.SoggiornoContextSubject;
import com.iHotel.model.Utility.Giorno;

/**
 * @author Eugenio
 *
 */
public class CompositeGiornoScadenzaMigliorePerHotelStrategy extends CompositeOttieniGiornoScadenzaStrategy {

	@Override
	public Giorno getGiornoScadenza(SoggiornoContextSubject soggiorno) {
		
		
		System.out.println("Giorno inizio soggiorno: " + soggiorno.get_periodo().get_dataInizio().toString());
		
		// Giorno di scadenza relativo alla prima strategia.
		Giorno giornoScadenzaPiuLontanoDaInizioSoggiorno = _strategie.get(0).getGiornoScadenza(soggiorno);
		
			
			System.out.println("0: " + giornoScadenzaPiuLontanoDaInizioSoggiorno.toString());
			System.out.println("Scelto: " + giornoScadenzaPiuLontanoDaInizioSoggiorno.toString());
		
		
		// Ciclo sulle restanti strategie.
		for (int i = 1; i < _strategie.size(); i++) {
			ComponentOttieniGiornoScadenzaStrategy strategia = _strategie.get(i);
			// Prendo il giorno relativo a questa strategia
			Giorno giornoScadenzaStrategia = strategia.getGiornoScadenza(soggiorno);
			
					System.out.println(i + ": " + giornoScadenzaStrategia.toString());
			
			
			/*
			 *  Controllo se il giornoScadenzaStrategia � pi� vicino all'inizio del soggiorno rispetto
			 *  al giorno attualmente scelto.
			 */
			if (giornoScadenzaStrategia.compara(giornoScadenzaPiuLontanoDaInizioSoggiorno) < 0) {
				// Assegno il nuovo valore per il giorno di scadenza
				giornoScadenzaPiuLontanoDaInizioSoggiorno=giornoScadenzaStrategia;
				
				
				System.out.println("Scelto: " + giornoScadenzaStrategia.toString());
				
			}
		}
		return giornoScadenzaPiuLontanoDaInizioSoggiorno;
	}


}
