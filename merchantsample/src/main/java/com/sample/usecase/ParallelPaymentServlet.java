package com.sample.usecase;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import urn.ebay.api.PayPalAPI.PayPalAPIInterfaceServiceService;
import urn.ebay.api.PayPalAPI.SetExpressCheckoutReq;
import urn.ebay.api.PayPalAPI.SetExpressCheckoutRequestType;
import urn.ebay.api.PayPalAPI.SetExpressCheckoutResponseType;
import urn.ebay.apis.CoreComponentTypes.BasicAmountType;
import urn.ebay.apis.eBLBaseComponents.CurrencyCodeType;
import urn.ebay.apis.eBLBaseComponents.PaymentDetailsType;
import urn.ebay.apis.eBLBaseComponents.SellerDetailsType;
import urn.ebay.apis.eBLBaseComponents.SetExpressCheckoutRequestDetailsType;

import com.sample.util.Configuration;

public class ParallelPaymentServlet extends HttpServlet{
	
	private static final long serialVersionUID = 1239098098123L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		getServletConfig().getServletContext()
		.getRequestDispatcher("/usecase_jsp/ParallelPayment.jsp")
		.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		session.setAttribute("url", request.getRequestURI());
		response.setContentType("text/html");
			
		// Configuration map containing signature credentials and other required configuration.
		// For a full list of configuration parameters refer at 
		// [https://github.com/paypal/merchant-sdk-java/wiki/SDK-Configuration-Parameters]
		Map<String,String> configurationMap =  Configuration.getSignatureConfig();
		
		// Creating service wrapper object to make an API call by loading configuration map.
		PayPalAPIInterfaceServiceService service = new PayPalAPIInterfaceServiceService(configurationMap);
		
		//# SetExpressCheckout API
		// The SetExpressCheckout API operation initiates an Express Checkout
		// transaction.
		// This sample code uses Merchant Java SDK to make API call. You can
		// download the SDKs [here](https://github.com/paypal/sdk-packages/tree/gh-pages/merchant-sdk/java)
		SetExpressCheckoutRequestType setExpressCheckoutReq = new SetExpressCheckoutRequestType();
		SetExpressCheckoutRequestDetailsType details = new SetExpressCheckoutRequestDetailsType();

		StringBuffer url = new StringBuffer();
		url.append("http://");
		url.append(request.getServerName());
		url.append(":");
		url.append(request.getServerPort());
		url.append(request.getContextPath());

		String returnURL = url.toString() + "/DoExpressCheckout";
		String cancelURL = url.toString() + "/ParallelPayment";
		
		/*
		 *  (Required) URL to which the buyer's browser is returned after choosing 
		 *  to pay with PayPal. For digital goods, you must add JavaScript to this 
		 *  page to close the in-context experience.
		  Note:
			PayPal recommends that the value be the final review page on which the buyer 
			confirms the order and payment or billing agreement.
			Character length and limitations: 2048 single-byte characters
		 */
		details.setReturnURL(returnURL + "?currencyCodeType="+ request.getParameter("currencyCode"));

		details.setCancelURL(cancelURL);
		/*
		 *  (Optional) Email address of the buyer as entered during checkout.
		 *  PayPal uses this value to pre-fill the PayPal membership sign-up portion on the PayPal pages.
		 *	Character length and limitations: 127 single-byte alphanumeric characters
		 */
		details.setBuyerEmail(request.getParameter("buyerEmail"));
		
		/*
		 * How you want to obtain payment. When implementing parallel payments, 
		 * this field is required and must be set to Order.
		 *  When implementing digital goods, this field is required and must be set to Sale.
		 *   If the transaction does not include a one-time purchase, this field is ignored. 
		 *   It is one of the following values:

			Sale – This is a final sale for which you are requesting payment (default).
			Authorization – This payment is a basic authorization subject to settlement with PayPal Authorization and Capture.
			Order – This payment is an order authorization subject to settlement with PayPal Authorization and Capture.
		 */
		request.getSession().setAttribute("paymentType",request.getParameter("paymentType"));
		
		
		SellerDetailsType seller_1 = new SellerDetailsType();
		seller_1.setPayPalAccountID(request.getParameter("receiverEmail_0"));
		PaymentDetailsType paymentDetails_1 = new PaymentDetailsType();
		paymentDetails_1.setSellerDetails(seller_1);
		paymentDetails_1.setPaymentRequestID("CART286-PAYMENT1");
		BasicAmountType orderTotal_1 = new BasicAmountType();
		orderTotal_1.setCurrencyID(CurrencyCodeType.fromValue(request.getParameter("currencyCode")));
		orderTotal_1.setValue(request.getParameter("orderTotal"));
		paymentDetails_1.setOrderTotal(orderTotal_1);
		
		SellerDetailsType seller_2 = new SellerDetailsType();
		seller_2.setPayPalAccountID(request.getParameter("receiverEmail_1"));
		PaymentDetailsType paymentDetails_2 = new PaymentDetailsType();
		paymentDetails_2.setSellerDetails(seller_2);
		paymentDetails_2.setPaymentRequestID("CART286-PAYMENT2");
		BasicAmountType orderTotal_2 = new BasicAmountType();
		orderTotal_2.setCurrencyID(CurrencyCodeType.fromValue(request.getParameter("currencyCode")));
		orderTotal_2.setValue(request.getParameter("orderTotal"));
		paymentDetails_2.setOrderTotal(orderTotal_2);
		
		
		List<PaymentDetailsType> payDetails = new ArrayList<PaymentDetailsType>();
		payDetails.add(paymentDetails_1);
		payDetails.add(paymentDetails_2);
		
		details.setPaymentDetails(payDetails);
		
		setExpressCheckoutReq.setSetExpressCheckoutRequestDetails(details);

		SetExpressCheckoutReq expressCheckoutReq = new SetExpressCheckoutReq();
		expressCheckoutReq
				.setSetExpressCheckoutRequest(setExpressCheckoutReq);
		SetExpressCheckoutResponseType setExpressCheckoutResponse = null;
		
		try{
			setExpressCheckoutResponse = service.setExpressCheckout(expressCheckoutReq);
		}catch(Exception e){
			e.printStackTrace();
		}

		if (setExpressCheckoutResponse != null) {
			session.setAttribute("lastReq", service.getLastRequest());
			session.setAttribute("lastResp", service.getLastResponse());
			if (setExpressCheckoutResponse.getAck().toString()
					.equalsIgnoreCase("SUCCESS")) {
				Map<Object, Object> map = new LinkedHashMap<Object, Object>();
				map.put("Ack", setExpressCheckoutResponse.getAck());
				/*
				 * A time stamped token by which you identify to PayPal that you are processing 
				 * this payment with Express Checkout. The token expires after three hours. 
				 * If you set the token in the SetExpressCheckout request, the value of the 
				 * token in the response is identical to the value in the request.
					Character length and limitations: 20 single-byte characters
				 */
				map.put("Token", setExpressCheckoutResponse.getToken());
				map.put("Redirect URL",
						"<a href=https://www.sandbox.paypal.com/cgi-bin/webscr?cmd=_express-checkout&token="
								+ setExpressCheckoutResponse.getToken()
								+ ">Redirect To PayPal</a>");
				session.setAttribute("map", map);
				response.sendRedirect(this.getServletContext().getContextPath()+"/Response.jsp");
			} else {

				session.setAttribute("Error",
						setExpressCheckoutResponse.getErrors());
				response.sendRedirect(this.getServletContext().getContextPath()+"/Error.jsp");
			}
		}
	
	}
	
}
