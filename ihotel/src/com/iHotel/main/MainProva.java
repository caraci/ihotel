package com.iHotel.main;

import java.util.List;

import com.iHotel.model.Albergo.Storico;
import com.iHotel.model.Albergo.Soggiorno.SoggiornoContextSubject;
import com.iHotel.utility.UStartup;


public class MainProva {
	
	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) throws java.io.IOException {	
		UStartup.inizializza();
		
		List<SoggiornoContextSubject> soggiornifuturi = Storico.getInstance().recuperaSoggiorniFuturi();
		
		System.out.println(soggiornifuturi.size());
		
	}

}
