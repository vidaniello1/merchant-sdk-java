package com.sample.ipn;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import urn.ebay.api.PayPalAPI.PayPalAPIInterfaceServiceService;

import com.paypal.core.LoggingManager;
import com.paypal.ipn.IPNMessage;

public class IPNListenerServlet extends HttpServlet {
	
	/* 
	 * receiver for PayPal ipn call back.
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		IPNMessage ipnlistener=null;
		PayPalAPIInterfaceServiceService service = new PayPalAPIInterfaceServiceService(this
				.getClass().getResourceAsStream("/sdk_config.properties"));
		try{
			
			ipnlistener = new IPNMessage(request);

		}catch(IOException io){
			LoggingManager.debug(IPNListenerServlet.class, io.getMessage());
		}
		
		
		boolean isIpnVerified = ipnlistener.isIpnVerified();
		String transactionType = ipnlistener.getTransactionType();
		Map<String,String> map = ipnlistener.getIpnParamValueMap();
		
		LoggingManager.info(IPNListenerServlet.class, "******* IPN (name:value) pair : "+ map + "  " +
				"######### TransactionType : "+transactionType+"  ======== IPN verified : "+ isIpnVerified);
	}
}
