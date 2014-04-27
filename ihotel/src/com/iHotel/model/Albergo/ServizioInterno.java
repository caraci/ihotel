/**
 * 
 */
package com.iHotel.model.Albergo;

import com.iHotel.model.Utility.Periodo;

/**
 * @author Gabriele
 *
 */
public class ServizioInterno {
	
	/*----------------------- Attributi e costruttore -----------------------*/
	private String _codice;
	private Periodo _data;
	/**
	 * Costruttore.
	 */
	public ServizioInterno(){}
	
	/*----------------------- Setter e getter -----------------------*/
	/**
	 * @return the _codice
	 */
	public String get_codice() {
		return _codice;
	}

	/**
	 * @param _codice the _codice to set
	 */
	public void set_codice(String _codice) {
		this._codice = _codice;
	}

	/**
	 * @return the _data
	 */
	public Periodo get_data() {
		return _data;
	}

	/**
	 * @param _data the _data to set
	 */
	public void set_data(Periodo _data) {
		this._data = _data;
	}

}
