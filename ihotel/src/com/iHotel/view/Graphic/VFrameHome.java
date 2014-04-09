package com.iHotel.view.Graphic;


import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.iHotel.view.View;
import com.iHotel.view.Event.CaricaCreaNuovaPrenotazioneListener;
import com.iHotel.view.Event.CaricaGestionePrenotazioneListener;

@SuppressWarnings("serial")
public class VFrameHome extends View {

	/* Singleton */
	private static VFrameHome instance = null;
	private JPanel _contentPane;
	private JPanel _panelTop, _panelBottom;
	private JButton _btnCreaPrenotazione;
	private JButton _btnModificaPrenotazione;

	/**
     * Costruttore privato - pattern Singleton
     */
	private VFrameHome() {
		super();
	}
	/**
	 * Metodo per ottenere l'instanza di questa classe - Pattern Singleton.
	 * 
	 * @return VFrameHome Instanza unica di questa classe.
	 */
    public static VFrameHome getInstance() {
    	if(instance == null) {
            instance = new VFrameHome();
         }
         return instance;
    }
	/**
	 * Create the frame.
	 */
	public void creaFrame() {
		setTitle("iHotel - Home");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		set_contentPane(new JPanel());		
		get_contentPane().setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(get_contentPane());
		get_contentPane().setLayout(new GridLayout(2, 1, 10, 10));
		
		
		_panelTop = new JPanel();
		get_panelTop().setLayout(new GridLayout(1, 1, 20, 20));
		_panelBottom = new JPanel();
		get_panelBottom().setLayout(new GridLayout(1, 1, 20, 20));
		
		_btnCreaPrenotazione = new JButton();
		get_btnCreaPrenotazione().setText("Crea nuova prenotazione");
		
		_btnModificaPrenotazione = new JButton();
		get_btnModificaPrenotazione().setText("Gestisci prenotazione");

		get_panelTop().add(get_btnCreaPrenotazione());		
		get_panelBottom().add(get_btnModificaPrenotazione());
		get_contentPane().add(get_panelTop());
		get_contentPane().add(get_panelBottom());
		
		// Assegniamo l'eventListener al JButton btnCreaPrenotazione
		get_btnCreaPrenotazione().addMouseListener(new CaricaCreaNuovaPrenotazioneListener());	
		// Assegniamo l'eventListener al JButton btnModificaPrenotazione
		get_btnModificaPrenotazione().addMouseListener(new CaricaGestionePrenotazioneListener());
	}
	/* ------------------------ Getter, Setter -------------------------------- */
	/**
	 * @return the _contentPane
	 */
	public JPanel get_contentPane() {
		return _contentPane;
	}
	/**
	 * @param _contentPane the _contentPane to set
	 */
	public void set_contentPane(JPanel _contentPane) {
		this._contentPane = _contentPane;
	}
	/**
	 * @return the _panelTop
	 */
	public JPanel get_panelTop() {
		return _panelTop;
	}
	/**
	 * @param _panelTop the _panelTop to set
	 */
	public void set_panelTop(JPanel _panelTop) {
		this._panelTop = _panelTop;
	}
	/**
	 * @return the _panelBottom
	 */
	public JPanel get_panelBottom() {
		return _panelBottom;
	}
	/**
	 * @param _panelBottom the _panelBottom to set
	 */
	public void set_panelBottom(JPanel _panelBottom) {
		this._panelBottom = _panelBottom;
	}
	/**
	 * @return the _btnCreaPrenotazione
	 */
	public JButton get_btnCreaPrenotazione() {
		return _btnCreaPrenotazione;
	}
	/**
	 * @param _btnCreaPrenotazione the _btnCreaPrenotazione to set
	 */
	public void set_btnCreaPrenotazione(JButton _btnCreaPrenotazione) {
		this._btnCreaPrenotazione = _btnCreaPrenotazione;
	}
	/**
	 * @return the _btnModificaPrenotazione
	 */
	public JButton get_btnModificaPrenotazione() {
		return _btnModificaPrenotazione;
	}
	/**
	 * @param _btnModificaPrenotazione the _btnModificaPrenotazione to set
	 */
	public void set_btnModificaPrenotazione(JButton _btnModificaPrenotazione) {
		this._btnModificaPrenotazione = _btnModificaPrenotazione;
	}
	
	

}
