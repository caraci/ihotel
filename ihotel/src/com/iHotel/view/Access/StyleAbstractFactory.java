/**
 * 
 */
package com.iHotel.view.Access;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * Interfaccia che definisce gli elementi grafici che si utilizzano nell'applicazione.
 * 
 * @author Eugenio
 */
public interface StyleAbstractFactory {
	/**
	 * Metodo per ottenere un generico Pannello.
	 * 
	 * @return Pannello generico.
	 */
	public JPanel getPanel();
	/**
	 * Metodo per ottenere un generico Pannello, con o senza bordo.
	 * 
	 * @param bordo Se true fornisce un pannello con bordo. Se false un pannello senza bordo.
	 * @return Pannello generico, con o senza bordo, in base al parametro fornito.
	 */
	public JPanel getPanel(boolean bordo);
	/**
	 * Metodo per ottenere il contentPanel.
	 * 
	 * @return Pannello per il contentPanel.
	 */
	public JPanel getContentPane();
	/**
	 * Metodo per ottenere il middlePanel.
	 * 
	 * @return Pannello per il middlePanel.
	 */
	public JPanel getPanelMiddle();
	/**
	 * Metodo per ottenere un generico JScrollPane.
	 * 
	 * @return JScrollPane generico.
	 */
	public JScrollPane getScrollPane();
	/**
	 * Metodo per ottenere un generico JTabbedPane.
	 * 
	 * @return JTabbedPane generico.
	 */
	public JTabbedPane getTabbedPane();
	/**
	 * Metodo per ottenere una label normale.
	 * 
	 * @return Label normale.
	 */
	public JLabel getLabel();
	/**
	 * Metodo per ottenere una label di una dimensione molto grande.
	 * 
	 * @return Label molto grande.
	 */
	public JLabel getLabelIntestazione_1();
	/**
	 * Metodo per ottenere una label di una dimensione grande.
	 * 
	 * @return Label grande.
	 */
	public JLabel getLabelIntestazione_2();
	/**
	 * Metodo per ottenere un bottone.
	 * 
	 * @return Bottone normale.
	 */
	public JButton getButton();
	/**
	 * Metodo per ottenere un bottone di accettazione.
	 * 
	 * @return Bottone di accettazione.
	 */
	public JButton getButtonAvanti();
	/**
	 * Metodo per ottenere un textField.
	 * 
	 * @return TextField normale.
	 */
	public JTextField getTextField();
	/**
	 * Metodo per ottenere un checkBox.
	 * 
	 * @return CheckBox normale.
	 */
	public JCheckBox getCheckBox();
	/**
	 * Metodo per ottenere il colore di sfondo del contentPane.
	 * 
	 * @return Colore di sfondo del contentPane.
	 */
	public Color getColorContentPane();
	/**
	 * Metodo per ottenere il colore di sfondo di un generico contenitore.
	 * 
	 * @return Colore di sfondo del generico contenitore.
	 */
	public Color getColorGeneralPanel();
	/**
	 * Metodo per ottenere un JSeparator.
	 * @return Jseparator.
	 */
	public JSeparator getSeparator();
	/**
	 * Metodo che restituisce una JTextArea.
	 * @return JTextArea
	 */
	public JTextArea getTextArea();
	
}
