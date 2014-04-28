/**
 * 
 */
package com.iHotel.main;

import java.util.ArrayList;
import java.util.LinkedList;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.iHotel.model.Albergo.Albergo;
import com.iHotel.model.Albergo.Cataloghi.CatalogoCamere;
import com.iHotel.model.Albergo.Cataloghi.DescrizioneCamera;
import com.iHotel.model.Albergo.Cataloghi.DescrizioneServizioInterno;
import com.iHotel.model.Albergo.Cataloghi.PrezzoCamera;
import com.iHotel.model.Albergo.Cataloghi.PrezzoServizioInterno;
import com.iHotel.model.State.CameraContext;
import com.iHotel.model.State.CameraStateLibera;
import com.iHotel.model.State.CameraStateOccupata;
import com.iHotel.model.State.CameraState;
import com.iHotel.model.Utility.Periodo;
import com.iHotel.model.Utility.Prezzo;

/**
 * @author Eugenio
 *
 */
public class MainPopolamentoDB {

	//metodi per inserire
	public static void aggiungiPeriodo(ObjectContainer db,Periodo periodo){
		db.store(periodo);		
	}
	
	public static void aggiungiDescrizioneCamera(ObjectContainer db,DescrizioneCamera descrizione){
		db.store(descrizione);
	}
	public static void aggiungiDescrizioneServizi(ObjectContainer db,DescrizioneServizioInterno descrizione){
		db.store(descrizione);
	}
	
	public static void aggiungiPrezzo(ObjectContainer db,PrezzoCamera prezzo){
		db.store(prezzo);
	}
	
	public static void aggiungiCamera(ObjectContainer db, CameraContext camera){
		db.store(camera);
	}
	
	public static void aggiungiAlbergo(ObjectContainer db, Albergo albergo){
		db.store(albergo);
	}
	
	public static void aggiungiCatalogo(ObjectContainer db, CatalogoCamere catalogo){
		db.store(catalogo);
	}
	
	public static void main(String[] args) {
		//Inizializzazioni 
		
		//periodi

		// periodo_1 - 1 Gennaio 2014 - 31 Gennaio 2014
				Periodo periodo_1 = new Periodo();
				int giornoInizio_1 = 1;
				int meseInizio_1 = 0;
				int annoInizio_1 = 2014;
				int giornoFine_1 = 31;
				int meseFine_1 = 0;
				int annoFine_1 = 2014;
				// Inizio 
				periodo_1.set_giornoInizio(giornoInizio_1);
				periodo_1.set_meseInizio(meseInizio_1);
				periodo_1.set_annoInizio(annoInizio_1);
				// Fine
				periodo_1.set_giornoFine(giornoFine_1);
				periodo_1.set_meseFine(meseFine_1);
				periodo_1.set_annoFine(annoFine_1);
				
				
			// periodo_2 - 31 Gennaio 2014 - 28 Febbraio 2014				
				Periodo periodo_2 = new Periodo();
				int giornoInizio_2 = 31;
				int meseInizio_2 = 0;
				int annoInizio_2 = 2014;
				int giornoFine_2 = 28;
				int meseFine_2 = 1;
				int annoFine_2 = 2014;
				// Inizio
				periodo_2.set_giornoInizio(giornoInizio_2);
				periodo_2.set_meseInizio(meseInizio_2);
				periodo_2.set_annoInizio(annoInizio_2);
				// Fine
				periodo_2.set_giornoFine(giornoFine_2);
				periodo_2.set_meseFine(meseFine_2);
				periodo_2.set_annoFine(annoFine_2);
				
				
			// periodo_3 - 28 Febbraio 2014 - 31 Marzo 2014
				Periodo periodo_3 = new Periodo();
				int giornoInizio_3 = 28;
				int meseInizio_3 = 1;
				int annoInizio_3 = 2014;
				int giornoFine_3 = 31;
				int meseFine_3 = 2;
				int annoFine_3 = 2014;
				// Inizio
				periodo_3.set_giornoInizio(giornoInizio_3);
				periodo_3.set_meseInizio(meseInizio_3);
				periodo_3.set_annoInizio(annoInizio_3);
				// Fine
				periodo_3.set_giornoFine(giornoFine_3);
				periodo_3.set_meseFine(meseFine_3);
				periodo_3.set_annoFine(annoFine_3);
				
			// periodo_4 - 31 Gennaio 2014 - 31 Marzo 2014
				Periodo periodo_4 = new Periodo();
				int giornoInizio_4 = 31;
				int meseInizio_4 = 0;
				int annoInizio_4 = 2014;
				int giornoFine_4 = 31;
				int meseFine_4 = 2;
				int annoFine_4 = 2014;
				// Inizio
				periodo_4.set_giornoInizio(giornoInizio_4);
				periodo_4.set_meseInizio(meseInizio_4);
				periodo_4.set_annoInizio(annoInizio_4);
				// Fine
				periodo_4.set_giornoFine(giornoFine_4);
				periodo_4.set_meseFine(meseFine_4);
				periodo_4.set_annoFine(annoFine_4);
				
			// periodo_5 - 1 Gennaio 2014 - 31 Marzo 2014
				Periodo periodo_5 = new Periodo();
				int giornoInizio_5 = 1;
				int meseInizio_5 = 0;
				int annoInizio_5 = 2014;
				int giornoFine_5 = 31;
				int meseFine_5 = 2;
				int annoFine_5 = 2014;
				// Inizio
				periodo_5.set_giornoInizio(giornoInizio_5);
				periodo_5.set_meseInizio(meseInizio_5);
				periodo_5.set_annoInizio(annoInizio_5);
				// Fine
				periodo_5.set_giornoFine(giornoFine_5);
				periodo_5.set_meseFine(meseFine_5);
				periodo_5.set_annoFine(annoFine_5);
				
			// periodo_6 - 31 Marzo 2014 - 31 Maggio 2014
				Periodo periodo_6 = new Periodo();
				int giornoInizio_6 = 31;
				int meseInizio_6 = 2;
				int annoInizio_6 = 2014;
				int giornoFine_6 = 31;
				int meseFine_6 = 5;
				int annoFine_6 = 2014;
				// Inizio
				periodo_6.set_giornoInizio(giornoInizio_6);
				periodo_6.set_meseInizio(meseInizio_6);
				periodo_6.set_annoInizio(annoInizio_6);
				// Fine
				periodo_6.set_giornoFine(giornoFine_6);
				periodo_6.set_meseFine(meseFine_6);
				periodo_6.set_annoFine(annoFine_6);
				
		//fine periodi
		
		//Creo le camere
		//Camere singole
				
		// Camera 101
		CameraContext camera_101 = new CameraContext();
		camera_101.set_numero("101");
		camera_101.set_tipologia("Singola");
		
		// Camera 102
		CameraContext camera_102 = new CameraContext();
		camera_102.set_numero("102");
		camera_102.set_tipologia("Singola");
		
		// Camera 103
		CameraContext camera_103 = new CameraContext();
		camera_103.set_numero("103");
		camera_103.set_tipologia("Singola");
		
		//Camere doppie
		// Camera 201
		CameraContext camera_201 = new CameraContext();
		camera_201.set_numero("201");
		camera_201.set_tipologia("Doppia");
		
		// Camera 202
		CameraContext camera_202 = new CameraContext();
		camera_202.set_numero("202");
		camera_202.set_tipologia("Doppia");
		
		// Camera 203
		CameraContext camera_203 = new CameraContext();
		camera_203.set_numero("203");
		camera_203.set_tipologia("Doppia");
		
		// Camere triple
		// Camera 301
		CameraContext camera_301 = new CameraContext();
		camera_301.set_numero("301");
		camera_301.set_tipologia("Tripla");
		
		// Camera 302
		CameraContext camera_302 = new CameraContext();
		camera_302.set_numero("302");
		camera_302.set_tipologia("Tripla");
		
		// Camera 303
		CameraContext camera_303 = new CameraContext();
		camera_303.set_numero("303");
		camera_303.set_tipologia("Tripla");
		
		
		/* --------------------------- stati camere SINGOLE ------------------------------- */
		
		// StatoCamera_101_Periodo_1
		CameraState statoCamera_101_Periodo1 = new CameraStateLibera();
		statoCamera_101_Periodo1.set_periodo(periodo_1);
		// StatoCamera_102_Periodo_1
		CameraState statoCamera_102_Periodo1 = new CameraStateLibera();
		statoCamera_102_Periodo1.set_periodo(periodo_1);
		// StatoCamera_103_Periodo_1
		CameraState statoCamera_103_Periodo1 = new CameraStateLibera();
		statoCamera_103_Periodo1.set_periodo(periodo_1);
		
		// StatoCamera_101_Periodo_4
		CameraState statoCamera_101_Periodo4 = new CameraStateOccupata();
		statoCamera_101_Periodo4.set_periodo(periodo_4);
		// StatoCamera_102_Periodo_4
		CameraState statoCamera_102_Periodo4 = new CameraStateOccupata();
		statoCamera_102_Periodo4.set_periodo(periodo_4);
		// StatoCamera_103_Periodo_4
		CameraState statoCamera_103_Periodo4 = new CameraStateOccupata();
		statoCamera_103_Periodo4.set_periodo(periodo_4);
		
		// StatoCamera_101_Periodo_6
		CameraState statoCamera_101_Periodo6 = new CameraStateLibera();
		statoCamera_101_Periodo6.set_periodo(periodo_6);
		// StatoCamera_102_Periodo_6
		CameraState statoCamera_102_Periodo6 = new CameraStateLibera();
		statoCamera_102_Periodo6.set_periodo(periodo_6);
		// StatoCamera_103_Periodo_6
		CameraState statoCamera_103_Periodo6 = new CameraStateLibera();
		statoCamera_103_Periodo6.set_periodo(periodo_6);
		
		/* --------------------------- stati camere DOPPIE ------------------------------- */
		
		//Stati camere doppie periodo 5
		
		// StatoCamera_201_Periodo_5
		CameraState statoCamera_201_Periodo5 = new CameraStateLibera();
		statoCamera_201_Periodo5.set_periodo(periodo_5);
		// StatoCamera_202_Periodo_5
		CameraState statoCamera_202_Periodo5 = new CameraStateLibera();
		statoCamera_202_Periodo5.set_periodo(periodo_5);
		// StatoCamera_203_Periodo_5
		CameraState statoCamera_203_Periodo5 = new CameraStateLibera();
		statoCamera_203_Periodo5.set_periodo(periodo_5);
		
		// StatoCamera_201_Periodo_6
		CameraState statoCamera_201_Periodo6 = new CameraStateLibera();
		statoCamera_201_Periodo6.set_periodo(periodo_6);
		// StatoCamera_202_Periodo_6
		CameraState statoCamera_202_Periodo6 = new CameraStateLibera();
		statoCamera_202_Periodo6.set_periodo(periodo_5);
		// StatoCamera_203_Periodo_6
		CameraState statoCamera_203_Periodo6 = new CameraStateLibera();
		statoCamera_203_Periodo6.set_periodo(periodo_6);
		
		/* --------------------------- stati camere TRIPLE ------------------------------- */
		
		// StatoCamera_301_Periodo_1
		CameraState statoCamera_301_Periodo1 = new CameraStateLibera();
		statoCamera_301_Periodo1.set_periodo(periodo_1);
		// StatoCamera_302_Periodo_1
		CameraState statoCamera_302_Periodo1 = new CameraStateLibera();
		statoCamera_302_Periodo1.set_periodo(periodo_1);
		// StatoCamera_303_Periodo_1
		CameraState statoCamera_303_Periodo1 = new CameraStateLibera();
		statoCamera_303_Periodo1.set_periodo(periodo_1);
		
		
		// StatoCamera_301_Periodo_2
		CameraState statoCamera_301_Periodo2 = new CameraStateOccupata();
		statoCamera_301_Periodo2.set_periodo(periodo_2);
		// StatoCamera_302_Periodo_2
		CameraState statoCamera_302_Periodo2 = new CameraStateOccupata();
		statoCamera_302_Periodo2.set_periodo(periodo_2);
		// StatoCamera_303_Periodo_2
		CameraState statoCamera_303_Periodo2 = new CameraStateOccupata();
		statoCamera_303_Periodo2.set_periodo(periodo_2);
		
		// StatoCamera_301_Periodo_3
		CameraState statoCamera_301_Periodo3 = new CameraStateLibera();
		statoCamera_301_Periodo3.set_periodo(periodo_3);
		// StatoCamera_302_Periodo_3
		CameraState statoCamera_302_Periodo3 = new CameraStateLibera();
		statoCamera_302_Periodo3.set_periodo(periodo_3);
		// StatoCamera_303_Periodo_3
		CameraState statoCamera_303_Periodo3 = new CameraStateLibera();
		statoCamera_303_Periodo3.set_periodo(periodo_3);
		
		// StatoCamera_301_Periodo_6
		CameraState statoCamera_301_Periodo6 = new CameraStateLibera();
		statoCamera_301_Periodo6.set_periodo(periodo_6);
		// StatoCamera_302_Periodo_6
		CameraState statoCamera_302_Periodo6 = new CameraStateLibera();
		statoCamera_302_Periodo6.set_periodo(periodo_6);
		// StatoCamera_303_Periodo_3
		CameraState statoCamera_303_Periodo6 = new CameraStateLibera();
		statoCamera_303_Periodo6.set_periodo(periodo_6);

		//Creo le map di stati di camere
		//map di stati camere singole
		// Stati occupazione Camera 101
		LinkedList<CameraState> statiCamera_101 = new LinkedList<CameraState>();
		statiCamera_101.add(statoCamera_101_Periodo1);
		statiCamera_101.add(statoCamera_101_Periodo4);
		statiCamera_101.add(statoCamera_101_Periodo6);
		
		// Stati occupazione Camera 102
		LinkedList<CameraState> statiCamera_102 = new LinkedList<CameraState>();
		statiCamera_102.add(statoCamera_102_Periodo1);
		statiCamera_102.add(statoCamera_102_Periodo4);
		statiCamera_102.add(statoCamera_102_Periodo6);
		
		// Stati occupazione Camera 103
		LinkedList<CameraState> statiCamera_103 = new LinkedList<CameraState>();
		statiCamera_103.add(statoCamera_103_Periodo1);
		statiCamera_103.add(statoCamera_103_Periodo4);
		statiCamera_103.add(statoCamera_103_Periodo6);
		
		//map di stati camere doppie
		// Stati occupazione Camera 201
		LinkedList<CameraState> statiCamera_201 = new LinkedList<CameraState>();
		statiCamera_201.add(statoCamera_201_Periodo5);
		statiCamera_201.add(statoCamera_201_Periodo6);
		
		// Stati occupazione Camera 202
		LinkedList<CameraState> statiCamera_202 = new LinkedList<CameraState>();
		statiCamera_202.add(statoCamera_202_Periodo5);
		statiCamera_202.add(statoCamera_202_Periodo6);
		
		// Stati occupazione Camera 203
		LinkedList<CameraState> statiCamera_203 = new LinkedList<CameraState>();
		statiCamera_203.add(statoCamera_203_Periodo5);
		statiCamera_203.add(statoCamera_203_Periodo6);
		
		//map di stati camere triple
		// Stati occupazione Camera 201
		LinkedList<CameraState> statiCamera_301 = new LinkedList<CameraState>();
		statiCamera_301.add(statoCamera_301_Periodo1);
		statiCamera_301.add(statoCamera_301_Periodo2);
		statiCamera_301.add(statoCamera_301_Periodo3);
		statiCamera_301.add(statoCamera_301_Periodo6);
		
		// Stati occupazione Camera 201
		LinkedList<CameraState> statiCamera_302 = new LinkedList<CameraState>();
		statiCamera_302.add(statoCamera_302_Periodo1);
		statiCamera_302.add(statoCamera_302_Periodo2);
		statiCamera_302.add(statoCamera_302_Periodo3);
		statiCamera_302.add(statoCamera_302_Periodo6);
		
		// Stati occupazione Camera 201
		LinkedList<CameraState> statiCamera_303 = new LinkedList<CameraState>();
		statiCamera_303.add(statoCamera_303_Periodo1);
		statiCamera_303.add(statoCamera_303_Periodo2);
		statiCamera_303.add(statoCamera_303_Periodo3);
		statiCamera_303.add(statoCamera_303_Periodo6);
		
		// Aggiungo stati alle rispettive camere
		
		camera_101.set_statiCamera(statiCamera_101);
		camera_102.set_statiCamera(statiCamera_102);
		camera_103.set_statiCamera(statiCamera_103);
		camera_201.set_statiCamera(statiCamera_201);
		camera_202.set_statiCamera(statiCamera_202);
		camera_203.set_statiCamera(statiCamera_203);
		camera_301.set_statiCamera(statiCamera_301);
		camera_302.set_statiCamera(statiCamera_302);
		camera_303.set_statiCamera(statiCamera_303);	
		
		//prezzi camere
		String valuta = "Euro";
		
		Prezzo singola = new Prezzo();
		singola.set_importo(10);
		singola.set_valuta(valuta);
		
		Prezzo doppia = new Prezzo();
		doppia.set_importo(20);
		doppia.set_valuta(valuta);
		
		Prezzo tripla = new Prezzo();
		tripla.set_importo(30);
		tripla.set_valuta(valuta);
		
		PrezzoCamera p_singola_1 = new PrezzoCamera();
		p_singola_1.set_prezzo(singola);
		p_singola_1.set_periodo(periodo_1);
		
		PrezzoCamera p_singola_2 = new PrezzoCamera();
		p_singola_2.set_prezzo(singola);
		p_singola_2.set_periodo(periodo_2);
		
		PrezzoCamera p_singola_3 = new PrezzoCamera();
		p_singola_3.set_prezzo(singola);
		p_singola_3.set_periodo(periodo_3);
		
		PrezzoCamera p_singola_6 = new PrezzoCamera();
		p_singola_6.set_prezzo(singola);
		p_singola_6.set_periodo(periodo_6);
		
		PrezzoCamera p_doppia_1 = new PrezzoCamera();
		p_doppia_1.set_prezzo(doppia);
		p_doppia_1.set_periodo(periodo_1);
		
		PrezzoCamera p_doppia_2 = new PrezzoCamera();
		p_doppia_2.set_prezzo(doppia);
		p_doppia_2.set_periodo(periodo_2);
		
		PrezzoCamera p_doppia_3 = new PrezzoCamera();
		p_doppia_3.set_prezzo(doppia);
		p_doppia_3.set_periodo(periodo_3);
		
		PrezzoCamera p_doppia_6 = new PrezzoCamera();
		p_doppia_6.set_prezzo(doppia);
		p_doppia_6.set_periodo(periodo_6);
		
		PrezzoCamera p_tripla_1 = new PrezzoCamera();
		p_tripla_1.set_prezzo(tripla);
		p_tripla_1.set_periodo(periodo_1);
		
		PrezzoCamera p_tripla_2 = new PrezzoCamera();
		p_tripla_2.set_prezzo(tripla);
		p_tripla_2.set_periodo(periodo_2);
		
		PrezzoCamera p_tripla_3 = new PrezzoCamera();
		p_tripla_3.set_prezzo(tripla);
		p_tripla_3.set_periodo(periodo_3);
		
		PrezzoCamera p_tripla_6 = new PrezzoCamera();
		p_tripla_6.set_prezzo(tripla);
		p_tripla_6.set_periodo(periodo_6);
		
		//fine prezzi camere
		
		//inizializzazione map prezzi camere
		
		//singola
		ArrayList<PrezzoCamera> prezzi_singola = new ArrayList<PrezzoCamera>();
		prezzi_singola.add(p_singola_1);
		prezzi_singola.add(p_singola_2);
		prezzi_singola.add(p_singola_3);
		prezzi_singola.add(p_singola_6);
		//doppia
		ArrayList<PrezzoCamera> prezzi_doppia = new ArrayList<PrezzoCamera>();
		prezzi_doppia.add(p_doppia_1);
		prezzi_doppia.add(p_doppia_2);
		prezzi_doppia.add(p_doppia_3);
		prezzi_doppia.add(p_doppia_6);
		//tripla
		ArrayList<PrezzoCamera> prezzi_tripla = new ArrayList<PrezzoCamera>();
		prezzi_tripla.add(p_tripla_1);
		prezzi_tripla.add(p_tripla_2);
		prezzi_tripla.add(p_tripla_3);
		prezzi_tripla.add(p_tripla_6);
		
		//inizializzazione descrizioni camere
		DescrizioneCamera d1 = new DescrizioneCamera();
		d1.set_tipologia("Singola");
		d1.set_prezziCamera(prezzi_singola);
				
		DescrizioneCamera d2 = new DescrizioneCamera();
		d2.set_tipologia("Doppia");
		d2.set_prezziCamera(prezzi_doppia);
		
		DescrizioneCamera d3 = new DescrizioneCamera();
		d3.set_tipologia("Tripla");
		d3.set_prezziCamera(prezzi_tripla);
		
		// Catalogo Servizi Interni
		
		// CHAMPAGNE
		Prezzo pChampagne = new Prezzo();
		pChampagne.set_importo(35);
		// Prezzi Champagne
		PrezzoServizioInterno psiChampagne = new PrezzoServizioInterno();
		psiChampagne.set_periodo(periodo_5);
		psiChampagne.set_prezzo(pChampagne);
		// Lista Prezzi Champagne
		LinkedList<PrezzoServizioInterno> prezziChampagne = new LinkedList<PrezzoServizioInterno>();
		prezziChampagne.add(psiChampagne);
		
		// Descrizione Servizio Interno Champagne
		
		DescrizioneServizioInterno dsChampagne = new DescrizioneServizioInterno();
		dsChampagne.set_codice("A012");
		dsChampagne.set_descrizione("Un'ottimo champagne di annata, per una notte speciale.");
		dsChampagne.set_nome("Champagne in camera");
		dsChampagne.set_prezziServizio(prezziChampagne);
		
		// ROSE
		Prezzo pRose = new Prezzo();
		pRose.set_importo(15);
		// Prezzi Rose
		PrezzoServizioInterno psiRose = new PrezzoServizioInterno();
		psiRose.set_periodo(periodo_5);
		psiRose.set_prezzo(pRose);
		// Lista Prezzi Rose
		LinkedList<PrezzoServizioInterno> prezziRose = new LinkedList<PrezzoServizioInterno>();
		prezziRose.add(psiRose);
		
		// Descrizione Servizio Interno Rose
		
		DescrizioneServizioInterno dsRose = new DescrizioneServizioInterno();
		dsRose.set_codice("A013");
		dsRose.set_descrizione("Fiori maravigliosi.");
		dsRose.set_nome("Fiori in camera");
		dsRose.set_prezziServizio(prezziRose);
		
		ObjectContainer db=Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), "dbihotel");
		try {
		
			//aggiunta dei periodi
			aggiungiPeriodo(db,periodo_1);
			aggiungiPeriodo(db,periodo_2);
			aggiungiPeriodo(db,periodo_3);
			
			//aggiunta prezzi
			aggiungiPrezzo(db,p_singola_1);
			aggiungiPrezzo(db,p_singola_2);
			aggiungiPrezzo(db,p_singola_3);
			aggiungiPrezzo(db,p_doppia_1);
			aggiungiPrezzo(db,p_doppia_2);
			aggiungiPrezzo(db,p_doppia_3);
			aggiungiPrezzo(db,p_tripla_1);
			aggiungiPrezzo(db,p_tripla_2);
			aggiungiPrezzo(db,p_tripla_3);
			
			//aggiunta descrizioni camere
			aggiungiDescrizioneCamera(db,d1);
			aggiungiDescrizioneCamera(db,d2);
			aggiungiDescrizioneCamera(db,d3);
			
			//aggiunta servizi interni
			aggiungiDescrizioneServizi(db,dsChampagne);
			aggiungiDescrizioneServizi(db,dsRose);
			
			//aggiunta camere
			aggiungiCamera(db,camera_101);
			aggiungiCamera(db,camera_102);
			aggiungiCamera(db,camera_103);
			aggiungiCamera(db,camera_201);
			aggiungiCamera(db,camera_202);
			aggiungiCamera(db,camera_203);
			aggiungiCamera(db,camera_301);
			aggiungiCamera(db,camera_302);
			aggiungiCamera(db,camera_303);
			
		}
		
		finally {
		db.close();
			}
		

	}

}
