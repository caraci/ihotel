package com.iHotel.view.CreaPrenotazione;

import java.awt.Dimension;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import com.iHotel.controller.CCreaPrenotazione;
import com.iHotel.model.Albergo.PrenotazioneSubject;
import com.iHotel.model.Observer.IObserver;
import com.iHotel.model.Observer.ISubject;
import com.iHotel.model.State.CameraContext;
import com.iHotel.view.View;

import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

@SuppressWarnings("serial")
public class VFCP_SelezioneCamereDatiOspite_Observer extends View implements IObserver {

	/* ContentPane */
	private JPanel contentPane;
	/* Panel */
    private JPanel panelFinale;
    /* JList */
    private ArrayList<JLabel> lblNumeriCamereDisponibili;
    /* JButton */
    private ArrayList<JButton> btnNumeriCamereDisponibili;
    private JButton btnCompletaPrenotazione;
    /* JLabel */
    private JLabel lblNome, lblCognome, lbleMail, lblTelefono, lblPrezzoTotale, lblPrezzoScritto;
    /* JTextField */
    private JTextField txtNome, txtCognome, txteMail, txtTelefono;
    // Pattern Observer
    private PrenotazioneSubject _prenotazioneSubject;
    /* ----------------- Pattern Singleton  ---------------- */
	private static VFCP_SelezioneCamereDatiOspite_Observer instance = null;
   
	/**
	 * Costruttore privato - pattern Singleton
	 */
	private VFCP_SelezioneCamereDatiOspite_Observer() {
		super();
		lblNumeriCamereDisponibili= new ArrayList<JLabel>();
		btnNumeriCamereDisponibili= new ArrayList<JButton>();
	}
	/**
	 * Metodo per ottenere l'instanza di questa classe - Pattern Singleton.
	 * 
	 * @return VFrameCreaPrenotazioneStep_2 Instanza unica di questa classe.
	 */
    public static VFCP_SelezioneCamereDatiOspite_Observer getInstance() {
    	if(instance == null) {
            instance = new VFCP_SelezioneCamereDatiOspite_Observer();
         }
         return instance;
    }
    /* ----------------- /Pattern Singleton  ---------------- */
    /* ------------- Pattern Observer ----------- */
    @Override
	public void Update() {
		String total=String.valueOf(_prenotazioneSubject.get_total().get_importo());	
		// Setto il prezzo della Label con il totale della prenotazione
		lblPrezzoTotale.setText(total + _prenotazioneSubject.get_total().get_valuta());
	}
    /* ------------- /Pattern Observer --------- */
    /**
     * Metodo per aggiungere una colonna contenente tipologie di camere dello stesso tipo.
     * 
     * @param arrayListCamere Struttura dati contenente tipologia della camera e numeri di camera.
     */
    private void addColonnaTipologiaCamere(String tipologia, ArrayList<CameraContext> arrayListCamere) {
	// Creo una colonna per mostrare i risultati della tipologia di camere
		JPanel panelColonna = new JPanel();
		panelColonna.setLayout(new  BoxLayout(panelColonna, BoxLayout.PAGE_AXIS));
		contentPane.add(panelColonna);  		
	// Aggiungo la label relativo alla tipologia alla colonna
		JLabel lblTipologia = new JLabel();
		lblTipologia.setText(tipologia + ":");
		panelColonna.add(lblTipologia);
	// Aggiungo spaziatura statica
		panelColonna.add(Box.createRigidArea(new Dimension(0,20)));
	// Ciclo sull'arrayList di String contenenti i numeri di camere ed aggiungo i numeri all'array di String creato sopra.
		for (Iterator<CameraContext> iterator = arrayListCamere.iterator(); iterator.hasNext();) {
			CameraContext cameraContext = (CameraContext) iterator.next();
			JLabel lblNumeroCamera = new JLabel(cameraContext.get_numero());
			JButton btnNumeroCamera = new JButton("Aggiungi camera");
			lblNumeriCamereDisponibili.add(lblNumeroCamera);
			btnNumeriCamereDisponibili.add(btnNumeroCamera);
			// Aggiungo label e button al panelColonna
			panelColonna.add(lblNumeroCamera);
			// Aggiungo uno spaziatore statica
			panelColonna.add(Box.createRigidArea(new Dimension(0,4)));
			panelColonna.add(btnNumeroCamera);
			// Aggiungo uno spaziatore statica
			panelColonna.add(Box.createRigidArea(new Dimension(0,10)));
		}
    }
    /**
     * Metodo per aggiungere il pannello dove si visualizza il prezzo della prenotazione.
     */
    private void addPanelPrezzo() {
    	// Creo un panel per far inserire all'utente i dati sul cliente
			JPanel panelPrezzo = new JPanel();
			panelPrezzo.setLayout(new  BoxLayout(panelPrezzo, BoxLayout.PAGE_AXIS));
		// Nome
			lblPrezzoScritto = new JLabel("Prezzo Totale:");
			lblPrezzoTotale = new JLabel("0�");
		// Aggiungo gli elementi al panelOspite
			panelPrezzo.add(lblPrezzoScritto);
			panelPrezzo.add(Box.createRigidArea(new Dimension(0,20)));
			panelPrezzo.add(lblPrezzoTotale);
		// Aggiungo il panelOspite a panelFinale
			panelFinale.add(panelPrezzo);
    }
    /**
     * Metodo per aggiungere il pannello dove si inseriscono le informazioni sul cliente e dove si mostra
     * il bottone per concludere la prenotazione.
     */
    private void addPanelOspite() {
    	// Creo un panel per far inserire all'utente i dati sul cliente
			JPanel panelOspite = new JPanel();
			panelOspite.setLayout(new  BoxLayout(panelOspite, BoxLayout.PAGE_AXIS));
		// Nome
			lblNome = new JLabel("Nome:");
			txtNome = new JTextField();
		// Cognome
			lblCognome = new JLabel("Cognome:");
			txtCognome = new JTextField();
		// eMail
			lbleMail = new JLabel("e-Mail:");
			txteMail = new JTextField();
		// telefono
			lblTelefono = new JLabel("Telefono:");
			txtTelefono = new JTextField();
		// Button completa prenotazione
			btnCompletaPrenotazione = new JButton("Completa Prenotazione");
		// Aggiungo gli elementi al panelOspite
			panelOspite.add(lblNome);
			panelOspite.add(Box.createVerticalGlue());
			panelOspite.add(txtNome);
			panelOspite.add(Box.createVerticalGlue());
			panelOspite.add(lblCognome);
			panelOspite.add(Box.createVerticalGlue());
			panelOspite.add(txtCognome);
			panelOspite.add(Box.createVerticalGlue());
			panelOspite.add(lbleMail);
			panelOspite.add(Box.createVerticalGlue());
			panelOspite.add(txteMail);
			panelOspite.add(Box.createVerticalGlue());
			panelOspite.add(lblTelefono);
			panelOspite.add(Box.createVerticalGlue());
			panelOspite.add(txtTelefono);
			panelOspite.add(Box.createRigidArea(new Dimension(0,20)));
			panelOspite.add(btnCompletaPrenotazione);
		// Aggiungo il panelOspite a panelFinale
			panelFinale.add(panelOspite);
    }
    /**
     * Metodo per creare il frame.
     */
    public void creaFrame(HashMap<String, ArrayList<CameraContext>> camereDisponibili) {
    	// Imposto il titolo e l'operazione in chiusura alla finestra
    		setTitle("iHotel - Crea nuova prenotazione - Step 2 di 2");
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// Imposto la posizione e la dimensione della finestra (x,y,width,height)
			setBounds(50, 50, 1024, 500);
			contentPane = new JPanel();
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			setContentPane(contentPane);
		// Tipologie di camere
			int numeroTipologie = camereDisponibili.size();
    	// Numero di colonne. Il +1 � dovuta alla colonna di gestione.
			int numeroColonne = numeroTipologie + 1;
    	// Setto Layout con il numero di colonne ricavato sulla base del risultato e con una riga.
			contentPane.setLayout(new GridLayout(1, numeroColonne, 0, 0));
    	// Ciclo sulle camere ottenute.
		for (Iterator<String> iterator = camereDisponibili.keySet().iterator(); iterator.hasNext();) {
			String tipologia = (String) iterator.next();
			// Aggiungo la colonna relativa a camere della stessa tipologia.
			addColonnaTipologiaCamere(tipologia, camereDisponibili.get(tipologia));
		}
			
    	// Aggiungo il pannello finale
	    	panelFinale = new JPanel();
	    	panelFinale.setLayout(new GridLayout(2, 1, 20, 20));
    	// Aggiungi i pezzi del panelFinale
	    	addPanelPrezzo();
	    	addPanelOspite();
	    	contentPane.add(panelFinale);
	    	
	    /* ---------- EVENTI --------- */

	    	for (Iterator<JButton> iterator = btnNumeriCamereDisponibili.iterator(); iterator.hasNext();) {
				JButton btnCameraDisponibile = (JButton) iterator.next();				
				// Assegniamo l'eventListener al JButton btnCameraDisponibile
				btnCameraDisponibile.addMouseListener(new MouseAdapter() {
					// La classe MouseAdapter implementa le interfacce MouseListener, MouseMotionListener e MouseWheelListener.
					@Override
					public void mouseClicked(MouseEvent e) {
						JButton btn = new JButton();
						// Ricavo il JButton che ha generato l'evento
						btn=(JButton) e.getComponent();
						// Ricavo la sua posizione nell'ArrayList di JButton
						int numeroLista=btnNumeriCamereDisponibili.indexOf(btn);
						// Recupero il controllore e invoco il metodo.
						CCreaPrenotazione gestisciPrenotazione = CCreaPrenotazione.getInstance();
						// Aggiungo la camera alla prenotazione e carico il totale.
						gestisciPrenotazione.aggiungiCameraAllaPrenotazione(lblNumeriCamereDisponibili.get(numeroLista).getText());
						// Cambio testo al bottone
						btn.setText("Rimuovi camera");
					}
				});
    		}
			// Assegniamo l'eventListener al JButton btnCompletaPrenotazione
			btnCompletaPrenotazione.addMouseListener(new MouseAdapter() {
				// La classe MouseAdapter implementa le interfacce MouseListener, MouseMotionListener e MouseWheelListener.
				@Override
				public void mouseClicked(MouseEvent e) {
					// Recupero il controllore e invoco il metodo.
					CCreaPrenotazione gestisciPrenotazione = CCreaPrenotazione.getInstance();
					// Invoco il metodo passando come parametro la stringa contenente il numero di camera.
					gestisciPrenotazione.concludiPrenotazione(txtNome.getText(), txtCognome.getText(), txteMail.getText(), txtTelefono.getText());
				}
			});		
    }
    /* ------------- Getter, Setter */
    public void set_prenotazioneSubject(ISubject subject) {
    	this._prenotazioneSubject=(PrenotazioneSubject) subject;
    }
}
