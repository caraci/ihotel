package com.iHotel.main;

import com.iHotel.utility.UStartup;
import com.iHotel.view.Access.ViewHandler;
import com.iHotel.view.Graphic.VFrameHome;

public class Main {
	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) throws java.io.IOException {	
		// Inizializzo lo strato di dominio.
		UStartup startup = new UStartup();
		startup.inizializza();
		// Apro il frame iniziale.
		VFrameHome frameHome = VFrameHome.getInstance();
		frameHome.creaFrame();
		//Passo l'interfaccia all'oggetto che la visualizzer� 
		ViewHandler.getInstance().showFrame(frameHome);
	}
}
