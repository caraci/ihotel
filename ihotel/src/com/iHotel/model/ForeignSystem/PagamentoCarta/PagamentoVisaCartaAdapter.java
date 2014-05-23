/**
 * 
 */
package com.iHotel.model.ForeignSystem.PagamentoCarta;

import com.iHotel.model.Albergo.Soggiorno.SoggiornoContextSubject;
import com.iHotel.model.Pagamento.PagamentoConCarta;
import com.iHotel.model.Utility.Prezzo;

/**
 * @author Gabriele
 *
 */
public class PagamentoVisaCartaAdapter implements IPagamentoCartaAdapter {

	@Override
	public PagamentoConCarta eseguiPagamento(SoggiornoContextSubject soggiorno) {
		Prezzo totaleDaPagare=soggiorno.calcolaTotaleDaPagare();
		
		
		return null;
	}

}
