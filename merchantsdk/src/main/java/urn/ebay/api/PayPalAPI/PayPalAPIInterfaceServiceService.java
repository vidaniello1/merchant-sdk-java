package urn.ebay.api.PayPalAPI;
import java.io.*;
import java.util.Properties;
import com.paypal.core.BaseService;
import com.paypal.exception.*;
import com.paypal.core.credential.ICredential;
import com.paypal.core.APICallPreHandler;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;
import org.xml.sax.InputSource;
import javax.xml.parsers.ParserConfigurationException;
import urn.ebay.apis.eBLBaseComponents.AbstractRequestType;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import com.paypal.core.DefaultSOAPAPICallHandler;
import com.paypal.core.soap.MerchantAPICallPreHandler;
import urn.ebay.api.PayPalAPI.RefundTransactionReq;
import urn.ebay.api.PayPalAPI.RefundTransactionResponseType;
import urn.ebay.api.PayPalAPI.InitiateRecoupReq;
import urn.ebay.api.PayPalAPI.InitiateRecoupResponseType;
import urn.ebay.api.PayPalAPI.CompleteRecoupReq;
import urn.ebay.api.PayPalAPI.CompleteRecoupResponseType;
import urn.ebay.api.PayPalAPI.CancelRecoupReq;
import urn.ebay.api.PayPalAPI.CancelRecoupResponseType;
import urn.ebay.api.PayPalAPI.GetTransactionDetailsReq;
import urn.ebay.api.PayPalAPI.GetTransactionDetailsResponseType;
import urn.ebay.api.PayPalAPI.BillUserReq;
import urn.ebay.api.PayPalAPI.BillUserResponseType;
import urn.ebay.api.PayPalAPI.TransactionSearchReq;
import urn.ebay.api.PayPalAPI.TransactionSearchResponseType;
import urn.ebay.api.PayPalAPI.MassPayReq;
import urn.ebay.api.PayPalAPI.MassPayResponseType;
import urn.ebay.api.PayPalAPI.BillAgreementUpdateReq;
import urn.ebay.api.PayPalAPI.BAUpdateResponseType;
import urn.ebay.api.PayPalAPI.AddressVerifyReq;
import urn.ebay.api.PayPalAPI.AddressVerifyResponseType;
import urn.ebay.api.PayPalAPI.EnterBoardingReq;
import urn.ebay.api.PayPalAPI.EnterBoardingResponseType;
import urn.ebay.api.PayPalAPI.GetBoardingDetailsReq;
import urn.ebay.api.PayPalAPI.GetBoardingDetailsResponseType;
import urn.ebay.api.PayPalAPI.CreateMobilePaymentReq;
import urn.ebay.api.PayPalAPI.CreateMobilePaymentResponseType;
import urn.ebay.api.PayPalAPI.GetMobileStatusReq;
import urn.ebay.api.PayPalAPI.GetMobileStatusResponseType;
import urn.ebay.api.PayPalAPI.SetMobileCheckoutReq;
import urn.ebay.api.PayPalAPI.SetMobileCheckoutResponseType;
import urn.ebay.api.PayPalAPI.DoMobileCheckoutPaymentReq;
import urn.ebay.api.PayPalAPI.DoMobileCheckoutPaymentResponseType;
import urn.ebay.api.PayPalAPI.GetBalanceReq;
import urn.ebay.api.PayPalAPI.GetBalanceResponseType;
import urn.ebay.api.PayPalAPI.GetPalDetailsReq;
import urn.ebay.api.PayPalAPI.GetPalDetailsResponseType;
import urn.ebay.api.PayPalAPI.DoExpressCheckoutPaymentReq;
import urn.ebay.api.PayPalAPI.DoExpressCheckoutPaymentResponseType;
import urn.ebay.api.PayPalAPI.DoUATPExpressCheckoutPaymentReq;
import urn.ebay.api.PayPalAPI.DoUATPExpressCheckoutPaymentResponseType;
import urn.ebay.api.PayPalAPI.SetAuthFlowParamReq;
import urn.ebay.api.PayPalAPI.SetAuthFlowParamResponseType;
import urn.ebay.api.PayPalAPI.GetAuthDetailsReq;
import urn.ebay.api.PayPalAPI.GetAuthDetailsResponseType;
import urn.ebay.api.PayPalAPI.SetAccessPermissionsReq;
import urn.ebay.api.PayPalAPI.SetAccessPermissionsResponseType;
import urn.ebay.api.PayPalAPI.UpdateAccessPermissionsReq;
import urn.ebay.api.PayPalAPI.UpdateAccessPermissionsResponseType;
import urn.ebay.api.PayPalAPI.GetAccessPermissionDetailsReq;
import urn.ebay.api.PayPalAPI.GetAccessPermissionDetailsResponseType;
import urn.ebay.api.PayPalAPI.GetIncentiveEvaluationReq;
import urn.ebay.api.PayPalAPI.GetIncentiveEvaluationResponseType;
import urn.ebay.api.PayPalAPI.SetExpressCheckoutReq;
import urn.ebay.api.PayPalAPI.SetExpressCheckoutResponseType;
import urn.ebay.api.PayPalAPI.ExecuteCheckoutOperationsReq;
import urn.ebay.api.PayPalAPI.ExecuteCheckoutOperationsResponseType;
import urn.ebay.api.PayPalAPI.GetExpressCheckoutDetailsReq;
import urn.ebay.api.PayPalAPI.GetExpressCheckoutDetailsResponseType;
import urn.ebay.api.PayPalAPI.DoDirectPaymentReq;
import urn.ebay.api.PayPalAPI.DoDirectPaymentResponseType;
import urn.ebay.api.PayPalAPI.ManagePendingTransactionStatusReq;
import urn.ebay.api.PayPalAPI.ManagePendingTransactionStatusResponseType;
import urn.ebay.api.PayPalAPI.DoCancelReq;
import urn.ebay.api.PayPalAPI.DoCancelResponseType;
import urn.ebay.api.PayPalAPI.DoCaptureReq;
import urn.ebay.api.PayPalAPI.DoCaptureResponseType;
import urn.ebay.api.PayPalAPI.DoReauthorizationReq;
import urn.ebay.api.PayPalAPI.DoReauthorizationResponseType;
import urn.ebay.api.PayPalAPI.DoVoidReq;
import urn.ebay.api.PayPalAPI.DoVoidResponseType;
import urn.ebay.api.PayPalAPI.DoAuthorizationReq;
import urn.ebay.api.PayPalAPI.DoAuthorizationResponseType;
import urn.ebay.api.PayPalAPI.SetCustomerBillingAgreementReq;
import urn.ebay.api.PayPalAPI.SetCustomerBillingAgreementResponseType;
import urn.ebay.api.PayPalAPI.GetBillingAgreementCustomerDetailsReq;
import urn.ebay.api.PayPalAPI.GetBillingAgreementCustomerDetailsResponseType;
import urn.ebay.api.PayPalAPI.CreateBillingAgreementReq;
import urn.ebay.api.PayPalAPI.CreateBillingAgreementResponseType;
import urn.ebay.api.PayPalAPI.DoReferenceTransactionReq;
import urn.ebay.api.PayPalAPI.DoReferenceTransactionResponseType;
import urn.ebay.api.PayPalAPI.DoNonReferencedCreditReq;
import urn.ebay.api.PayPalAPI.DoNonReferencedCreditResponseType;
import urn.ebay.api.PayPalAPI.DoUATPAuthorizationReq;
import urn.ebay.api.PayPalAPI.DoUATPAuthorizationResponseType;
import urn.ebay.api.PayPalAPI.CreateRecurringPaymentsProfileReq;
import urn.ebay.api.PayPalAPI.CreateRecurringPaymentsProfileResponseType;
import urn.ebay.api.PayPalAPI.GetRecurringPaymentsProfileDetailsReq;
import urn.ebay.api.PayPalAPI.GetRecurringPaymentsProfileDetailsResponseType;
import urn.ebay.api.PayPalAPI.ManageRecurringPaymentsProfileStatusReq;
import urn.ebay.api.PayPalAPI.ManageRecurringPaymentsProfileStatusResponseType;
import urn.ebay.api.PayPalAPI.BillOutstandingAmountReq;
import urn.ebay.api.PayPalAPI.BillOutstandingAmountResponseType;
import urn.ebay.api.PayPalAPI.UpdateRecurringPaymentsProfileReq;
import urn.ebay.api.PayPalAPI.UpdateRecurringPaymentsProfileResponseType;
import urn.ebay.api.PayPalAPI.ReverseTransactionReq;
import urn.ebay.api.PayPalAPI.ReverseTransactionResponseType;
import urn.ebay.api.PayPalAPI.ExternalRememberMeOptOutReq;
import urn.ebay.api.PayPalAPI.ExternalRememberMeOptOutResponseType;
import com.paypal.sdk.exceptions.OAuthException;

public class PayPalAPIInterfaceServiceService extends BaseService {


	// Service Version
	public static final String SERVICE_VERSION = "98.0";

	// Service Name
	public static final String SERVICE_NAME = "PayPalAPIInterfaceService";

	//SDK Name
	private static final String SDK_NAME="merchant-java-sdk";
	
	//SDK Version
	private static final String SDK_VERSION="2.2.98";

	
	public PayPalAPIInterfaceServiceService(File configFile) throws IOException {
		initConfig(configFile);
	}		

	public PayPalAPIInterfaceServiceService(InputStream config) throws IOException {
		initConfig(config);
	}

	public PayPalAPIInterfaceServiceService(String configFilePath) throws IOException {
		initConfig(configFilePath);
	}
	
	public PayPalAPIInterfaceServiceService(Properties properties) {
		initConfig(properties);
	}



	
	private void setStandardParams(AbstractRequestType request) {
		if (request.getVersion() == null) {
			request.setVersion(SERVICE_VERSION);
		}
	}
	/**	
	 * AUTO_GENERATED
	 * @throws SSLConfigurationException
	 * @throws InvalidCredentialException
	 * @throws UnsupportedEncodingException
	 * @throws IOException
	 * @throws HttpErrorException
	 * @throws InvalidResponseDataException
	 * @throws ClientActionRequiredException
	 * @throws MissingCredentialException
	 * @throws InterruptedException
	 * @throws OAuthException
	 */
	 public RefundTransactionResponseType refundTransaction(RefundTransactionReq refundTransactionReq, String apiUsername) throws SSLConfigurationException, InvalidCredentialException, IOException, HttpErrorException, InvalidResponseDataException, ClientActionRequiredException, MissingCredentialException, InterruptedException, OAuthException, ParserConfigurationException, SAXException, IOException {
	 	APICallPreHandler apiCallPreHandler = null;
	 	String portName = "PayPalAPI";
		setStandardParams(refundTransactionReq.getRefundTransactionRequest());
		DefaultSOAPAPICallHandler defaultHandler = new DefaultSOAPAPICallHandler(refundTransactionReq.toXMLString(null, "RefundTransactionReq"), null, null);
		apiCallPreHandler = new MerchantAPICallPreHandler(defaultHandler, apiUsername, getAccessToken(), getTokenSecret());
		((MerchantAPICallPreHandler) apiCallPreHandler).setSdkName(SDK_NAME);
		((MerchantAPICallPreHandler) apiCallPreHandler).setSdkVersion(SDK_VERSION);
		((MerchantAPICallPreHandler) apiCallPreHandler).setPortName(portName);
	 	String response = call(apiCallPreHandler);
		DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = builderFactory.newDocumentBuilder();
		InputSource inStream = new InputSource();
		inStream.setCharacterStream(new StringReader((String) response));
		Document document = builder.parse(inStream);
		XPathFactory factory = XPathFactory.newInstance();
		XPath xpath = factory.newXPath();
		try {
			Node node = (Node) xpath.evaluate("Envelope/Body/RefundTransactionResponse", document, XPathConstants.NODE);
			return new RefundTransactionResponseType(node);
		} catch (XPathExpressionException exe) {
			throw new RuntimeException("Unable to parse response", exe);
		}
	 }
	 
	/** 
	 * AUTO_GENERATED
	 * @throws SSLConfigurationException
	 * @throws InvalidCredentialException
	 * @throws UnsupportedEncodingException
	 * @throws IOException
	 * @throws HttpErrorException
	 * @throws InvalidResponseDataException
	 * @throws ClientActionRequiredException
	 * @throws MissingCredentialException
	 * @throws InterruptedException
	 * @throws OAuthException
	 */
	 public RefundTransactionResponseType refundTransaction(RefundTransactionReq refundTransactionReq) throws SSLConfigurationException, InvalidCredentialException, IOException, HttpErrorException, InvalidResponseDataException, ClientActionRequiredException, MissingCredentialException, InterruptedException, OAuthException, ParserConfigurationException, SAXException  {
	 	return refundTransaction(refundTransactionReq, (String) null);
	 }

	/** 
	 * AUTO_GENERATED
	 * @throws SSLConfigurationException
	 * @throws InvalidCredentialException
	 * @throws UnsupportedEncodingException
	 * @throws IOException
	 * @throws HttpErrorException
	 * @throws InvalidResponseDataException
	 * @throws ClientActionRequiredException
	 * @throws MissingCredentialException
	 * @throws InterruptedException
	 * @throws OAuthException
	 */
	 public RefundTransactionResponseType refundTransaction(RefundTransactionReq refundTransactionReq, ICredential credential) throws SSLConfigurationException, InvalidCredentialException, IOException, HttpErrorException, InvalidResponseDataException, ClientActionRequiredException, MissingCredentialException, InterruptedException, OAuthException, ParserConfigurationException, SAXException  {
	 	APICallPreHandler apiCallPreHandler = null;
	 	String portName = "PayPalAPI";
		setStandardParams(refundTransactionReq.getRefundTransactionRequest());
		DefaultSOAPAPICallHandler defaultHandler = new DefaultSOAPAPICallHandler(refundTransactionReq.toXMLString(null, "RefundTransactionReq"), null, null);
		apiCallPreHandler = new MerchantAPICallPreHandler(defaultHandler, credential);
		((MerchantAPICallPreHandler) apiCallPreHandler).setSdkName(SDK_NAME);
		((MerchantAPICallPreHandler) apiCallPreHandler).setSdkVersion(SDK_VERSION);
		((MerchantAPICallPreHandler) apiCallPreHandler).setPortName(portName);
	 	String response = call(apiCallPreHandler);
 	
		DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = builderFactory.newDocumentBuilder();
		InputSource inStream = new InputSource();
		inStream.setCharacterStream(new StringReader((String) response));
		Document document = builder.parse(inStream);
		XPathFactory factory = XPathFactory.newInstance();
		XPath xpath = factory.newXPath();
		try {
			Node node = (Node) xpath.evaluate(
					"Envelope/Body/RefundTransactionResponse", document,
					XPathConstants.NODE);
			return new RefundTransactionResponseType(node);
		} catch (XPathExpressionException exe) {
			throw new RuntimeException("Unable to parse response", exe);
		}	
	}
	/**	
	 * AUTO_GENERATED
	 * @throws SSLConfigurationException
	 * @throws InvalidCredentialException
	 * @throws UnsupportedEncodingException
	 * @throws IOException
	 * @throws HttpErrorException
	 * @throws InvalidResponseDataException
	 * @throws ClientActionRequiredException
	 * @throws MissingCredentialException
	 * @throws InterruptedException
	 * @throws OAuthException
	 */
	 public InitiateRecoupResponseType initiateRecoup(InitiateRecoupReq initiateRecoupReq, String apiUsername) throws SSLConfigurationException, InvalidCredentialException, IOException, HttpErrorException, InvalidResponseDataException, ClientActionRequiredException, MissingCredentialException, InterruptedException, OAuthException, ParserConfigurationException, SAXException, IOException {
	 	APICallPreHandler apiCallPreHandler = null;
	 	String portName = "PayPalAPI";
		setStandardParams(initiateRecoupReq.getInitiateRecoupRequest());
		DefaultSOAPAPICallHandler defaultHandler = new DefaultSOAPAPICallHandler(initiateRecoupReq.toXMLString(null, "InitiateRecoupReq"), null, null);
		apiCallPreHandler = new MerchantAPICallPreHandler(defaultHandler, apiUsername, getAccessToken(), getTokenSecret());
		((MerchantAPICallPreHandler) apiCallPreHandler).setSdkName(SDK_NAME);
		((MerchantAPICallPreHandler) apiCallPreHandler).setSdkVersion(SDK_VERSION);
		((MerchantAPICallPreHandler) apiCallPreHandler).setPortName(portName);
	 	String response = call(apiCallPreHandler);
		DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = builderFactory.newDocumentBuilder();
		InputSource inStream = new InputSource();
		inStream.setCharacterStream(new StringReader((String) response));
		Document document = builder.parse(inStream);
		XPathFactory factory = XPathFactory.newInstance();
		XPath xpath = factory.newXPath();
		try {
			Node node = (Node) xpath.evaluate("Envelope/Body/InitiateRecoupResponse", document, XPathConstants.NODE);
			return new InitiateRecoupResponseType(node);
		} catch (XPathExpressionException exe) {
			throw new RuntimeException("Unable to parse response", exe);
		}
	 }
	 
	/** 
	 * AUTO_GENERATED
	 * @throws SSLConfigurationException
	 * @throws InvalidCredentialException
	 * @throws UnsupportedEncodingException
	 * @throws IOException
	 * @throws HttpErrorException
	 * @throws InvalidResponseDataException
	 * @throws ClientActionRequiredException
	 * @throws MissingCredentialException
	 * @throws InterruptedException
	 * @throws OAuthException
	 */
	 public InitiateRecoupResponseType initiateRecoup(InitiateRecoupReq initiateRecoupReq) throws SSLConfigurationException, InvalidCredentialException, IOException, HttpErrorException, InvalidResponseDataException, ClientActionRequiredException, MissingCredentialException, InterruptedException, OAuthException, ParserConfigurationException, SAXException  {
	 	return initiateRecoup(initiateRecoupReq, (String) null);
	 }

	/** 
	 * AUTO_GENERATED
	 * @throws SSLConfigurationException
	 * @throws InvalidCredentialException
	 * @throws UnsupportedEncodingException
	 * @throws IOException
	 * @throws HttpErrorException
	 * @throws InvalidResponseDataException
	 * @throws ClientActionRequiredException
	 * @throws MissingCredentialException
	 * @throws InterruptedException
	 * @throws OAuthException
	 */
	 public InitiateRecoupResponseType initiateRecoup(InitiateRecoupReq initiateRecoupReq, ICredential credential) throws SSLConfigurationException, InvalidCredentialException, IOException, HttpErrorException, InvalidResponseDataException, ClientActionRequiredException, MissingCredentialException, InterruptedException, OAuthException, ParserConfigurationException, SAXException  {
	 	APICallPreHandler apiCallPreHandler = null;
	 	String portName = "PayPalAPI";
		setStandardParams(initiateRecoupReq.getInitiateRecoupRequest());
		DefaultSOAPAPICallHandler defaultHandler = new DefaultSOAPAPICallHandler(initiateRecoupReq.toXMLString(null, "InitiateRecoupReq"), null, null);
		apiCallPreHandler = new MerchantAPICallPreHandler(defaultHandler, credential);
		((MerchantAPICallPreHandler) apiCallPreHandler).setSdkName(SDK_NAME);
		((MerchantAPICallPreHandler) apiCallPreHandler).setSdkVersion(SDK_VERSION);
		((MerchantAPICallPreHandler) apiCallPreHandler).setPortName(portName);
	 	String response = call(apiCallPreHandler);
 	
		DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = builderFactory.newDocumentBuilder();
		InputSource inStream = new InputSource();
		inStream.setCharacterStream(new StringReader((String) response));
		Document document = builder.parse(inStream);
		XPathFactory factory = XPathFactory.newInstance();
		XPath xpath = factory.newXPath();
		try {
			Node node = (Node) xpath.evaluate(
					"Envelope/Body/InitiateRecoupResponse", document,
					XPathConstants.NODE);
			return new InitiateRecoupResponseType(node);
		} catch (XPathExpressionException exe) {
			throw new RuntimeException("Unable to parse response", exe);
		}	
	}
	/**	
	 * AUTO_GENERATED
	 * @throws SSLConfigurationException
	 * @throws InvalidCredentialException
	 * @throws UnsupportedEncodingException
	 * @throws IOException
	 * @throws HttpErrorException
	 * @throws InvalidResponseDataException
	 * @throws ClientActionRequiredException
	 * @throws MissingCredentialException
	 * @throws InterruptedException
	 * @throws OAuthException
	 */
	 public CompleteRecoupResponseType completeRecoup(CompleteRecoupReq completeRecoupReq, String apiUsername) throws SSLConfigurationException, InvalidCredentialException, IOException, HttpErrorException, InvalidResponseDataException, ClientActionRequiredException, MissingCredentialException, InterruptedException, OAuthException, ParserConfigurationException, SAXException, IOException {
	 	APICallPreHandler apiCallPreHandler = null;
	 	String portName = "PayPalAPI";
		setStandardParams(completeRecoupReq.getCompleteRecoupRequest());
		DefaultSOAPAPICallHandler defaultHandler = new DefaultSOAPAPICallHandler(completeRecoupReq.toXMLString(null, "CompleteRecoupReq"), null, null);
		apiCallPreHandler = new MerchantAPICallPreHandler(defaultHandler, apiUsername, getAccessToken(), getTokenSecret());
		((MerchantAPICallPreHandler) apiCallPreHandler).setSdkName(SDK_NAME);
		((MerchantAPICallPreHandler) apiCallPreHandler).setSdkVersion(SDK_VERSION);
		((MerchantAPICallPreHandler) apiCallPreHandler).setPortName(portName);
	 	String response = call(apiCallPreHandler);
		DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = builderFactory.newDocumentBuilder();
		InputSource inStream = new InputSource();
		inStream.setCharacterStream(new StringReader((String) response));
		Document document = builder.parse(inStream);
		XPathFactory factory = XPathFactory.newInstance();
		XPath xpath = factory.newXPath();
		try {
			Node node = (Node) xpath.evaluate("Envelope/Body/CompleteRecoupResponse", document, XPathConstants.NODE);
			return new CompleteRecoupResponseType(node);
		} catch (XPathExpressionException exe) {
			throw new RuntimeException("Unable to parse response", exe);
		}
	 }
	 
	/** 
	 * AUTO_GENERATED
	 * @throws SSLConfigurationException
	 * @throws InvalidCredentialException
	 * @throws UnsupportedEncodingException
	 * @throws IOException
	 * @throws HttpErrorException
	 * @throws InvalidResponseDataException
	 * @throws ClientActionRequiredException
	 * @throws MissingCredentialException
	 * @throws InterruptedException
	 * @throws OAuthException
	 */
	 public CompleteRecoupResponseType completeRecoup(CompleteRecoupReq completeRecoupReq) throws SSLConfigurationException, InvalidCredentialException, IOException, HttpErrorException, InvalidResponseDataException, ClientActionRequiredException, MissingCredentialException, InterruptedException, OAuthException, ParserConfigurationException, SAXException  {
	 	return completeRecoup(completeRecoupReq, (String) null);
	 }

	/** 
	 * AUTO_GENERATED
	 * @throws SSLConfigurationException
	 * @throws InvalidCredentialException
	 * @throws UnsupportedEncodingException
	 * @throws IOException
	 * @throws HttpErrorException
	 * @throws InvalidResponseDataException
	 * @throws ClientActionRequiredException
	 * @throws MissingCredentialException
	 * @throws InterruptedException
	 * @throws OAuthException
	 */
	 public CompleteRecoupResponseType completeRecoup(CompleteRecoupReq completeRecoupReq, ICredential credential) throws SSLConfigurationException, InvalidCredentialException, IOException, HttpErrorException, InvalidResponseDataException, ClientActionRequiredException, MissingCredentialException, InterruptedException, OAuthException, ParserConfigurationException, SAXException  {
	 	APICallPreHandler apiCallPreHandler = null;
	 	String portName = "PayPalAPI";
		setStandardParams(completeRecoupReq.getCompleteRecoupRequest());
		DefaultSOAPAPICallHandler defaultHandler = new DefaultSOAPAPICallHandler(completeRecoupReq.toXMLString(null, "CompleteRecoupReq"), null, null);
		apiCallPreHandler = new MerchantAPICallPreHandler(defaultHandler, credential);
		((MerchantAPICallPreHandler) apiCallPreHandler).setSdkName(SDK_NAME);
		((MerchantAPICallPreHandler) apiCallPreHandler).setSdkVersion(SDK_VERSION);
		((MerchantAPICallPreHandler) apiCallPreHandler).setPortName(portName);
	 	String response = call(apiCallPreHandler);
 	
		DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = builderFactory.newDocumentBuilder();
		InputSource inStream = new InputSource();
		inStream.setCharacterStream(new StringReader((String) response));
		Document document = builder.parse(inStream);
		XPathFactory factory = XPathFactory.newInstance();
		XPath xpath = factory.newXPath();
		try {
			Node node = (Node) xpath.evaluate(
					"Envelope/Body/CompleteRecoupResponse", document,
					XPathConstants.NODE);
			return new CompleteRecoupResponseType(node);
		} catch (XPathExpressionException exe) {
			throw new RuntimeException("Unable to parse response", exe);
		}	
	}
	/**	
	 * AUTO_GENERATED
	 * @throws SSLConfigurationException
	 * @throws InvalidCredentialException
	 * @throws UnsupportedEncodingException
	 * @throws IOException
	 * @throws HttpErrorException
	 * @throws InvalidResponseDataException
	 * @throws ClientActionRequiredException
	 * @throws MissingCredentialException
	 * @throws InterruptedException
	 * @throws OAuthException
	 */
	 public CancelRecoupResponseType cancelRecoup(CancelRecoupReq cancelRecoupReq, String apiUsername) throws SSLConfigurationException, InvalidCredentialException, IOException, HttpErrorException, InvalidResponseDataException, ClientActionRequiredException, MissingCredentialException, InterruptedException, OAuthException, ParserConfigurationException, SAXException, IOException {
	 	APICallPreHandler apiCallPreHandler = null;
	 	String portName = "PayPalAPI";
		setStandardParams(cancelRecoupReq.getCancelRecoupRequest());
		DefaultSOAPAPICallHandler defaultHandler = new DefaultSOAPAPICallHandler(cancelRecoupReq.toXMLString(null, "CancelRecoupReq"), null, null);
		apiCallPreHandler = new MerchantAPICallPreHandler(defaultHandler, apiUsername, getAccessToken(), getTokenSecret());
		((MerchantAPICallPreHandler) apiCallPreHandler).setSdkName(SDK_NAME);
		((MerchantAPICallPreHandler) apiCallPreHandler).setSdkVersion(SDK_VERSION);
		((MerchantAPICallPreHandler) apiCallPreHandler).setPortName(portName);
	 	String response = call(apiCallPreHandler);
		DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = builderFactory.newDocumentBuilder();
		InputSource inStream = new InputSource();
		inStream.setCharacterStream(new StringReader((String) response));
		Document document = builder.parse(inStream);
		XPathFactory factory = XPathFactory.newInstance();
		XPath xpath = factory.newXPath();
		try {
			Node node = (Node) xpath.evaluate("Envelope/Body/CancelRecoupResponse", document, XPathConstants.NODE);
			return new CancelRecoupResponseType(node);
		} catch (XPathExpressionException exe) {
			throw new RuntimeException("Unable to parse response", exe);
		}
	 }
	 
	/** 
	 * AUTO_GENERATED
	 * @throws SSLConfigurationException
	 * @throws InvalidCredentialException
	 * @throws UnsupportedEncodingException
	 * @throws IOException
	 * @throws HttpErrorException
	 * @throws InvalidResponseDataException
	 * @throws ClientActionRequiredException
	 * @throws MissingCredentialException
	 * @throws InterruptedException
	 * @throws OAuthException
	 */
	 public CancelRecoupResponseType cancelRecoup(CancelRecoupReq cancelRecoupReq) throws SSLConfigurationException, InvalidCredentialException, IOException, HttpErrorException, InvalidResponseDataException, ClientActionRequiredException, MissingCredentialException, InterruptedException, OAuthException, ParserConfigurationException, SAXException  {
	 	return cancelRecoup(cancelRecoupReq, (String) null);
	 }

	/** 
	 * AUTO_GENERATED
	 * @throws SSLConfigurationException
	 * @throws InvalidCredentialException
	 * @throws UnsupportedEncodingException
	 * @throws IOException
	 * @throws HttpErrorException
	 * @throws InvalidResponseDataException
	 * @throws ClientActionRequiredException
	 * @throws MissingCredentialException
	 * @throws InterruptedException
	 * @throws OAuthException
	 */
	 public CancelRecoupResponseType cancelRecoup(CancelRecoupReq cancelRecoupReq, ICredential credential) throws SSLConfigurationException, InvalidCredentialException, IOException, HttpErrorException, InvalidResponseDataException, ClientActionRequiredException, MissingCredentialException, InterruptedException, OAuthException, ParserConfigurationException, SAXException  {
	 	APICallPreHandler apiCallPreHandler = null;
	 	String portName = "PayPalAPI";
		setStandardParams(cancelRecoupReq.getCancelRecoupRequest());
		DefaultSOAPAPICallHandler defaultHandler = new DefaultSOAPAPICallHandler(cancelRecoupReq.toXMLString(null, "CancelRecoupReq"), null, null);
		apiCallPreHandler = new MerchantAPICallPreHandler(defaultHandler, credential);
		((MerchantAPICallPreHandler) apiCallPreHandler).setSdkName(SDK_NAME);
		((MerchantAPICallPreHandler) apiCallPreHandler).setSdkVersion(SDK_VERSION);
		((MerchantAPICallPreHandler) apiCallPreHandler).setPortName(portName);
	 	String response = call(apiCallPreHandler);
 	
		DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = builderFactory.newDocumentBuilder();
		InputSource inStream = new InputSource();
		inStream.setCharacterStream(new StringReader((String) response));
		Document document = builder.parse(inStream);
		XPathFactory factory = XPathFactory.newInstance();
		XPath xpath = factory.newXPath();
		try {
			Node node = (Node) xpath.evaluate(
					"Envelope/Body/CancelRecoupResponse", document,
					XPathConstants.NODE);
			return new CancelRecoupResponseType(node);
		} catch (XPathExpressionException exe) {
			throw new RuntimeException("Unable to parse response", exe);
		}	
	}
	/**	
	 * AUTO_GENERATED
	 * @throws SSLConfigurationException
	 * @throws InvalidCredentialException
	 * @throws UnsupportedEncodingException
	 * @throws IOException
	 * @throws HttpErrorException
	 * @throws InvalidResponseDataException
	 * @throws ClientActionRequiredException
	 * @throws MissingCredentialException
	 * @throws InterruptedException
	 * @throws OAuthException
	 */
	 public GetTransactionDetailsResponseType getTransactionDetails(GetTransactionDetailsReq getTransactionDetailsReq, String apiUsername) throws SSLConfigurationException, InvalidCredentialException, IOException, HttpErrorException, InvalidResponseDataException, ClientActionRequiredException, MissingCredentialException, InterruptedException, OAuthException, ParserConfigurationException, SAXException, IOException {
	 	APICallPreHandler apiCallPreHandler = null;
	 	String portName = "PayPalAPI";
		setStandardParams(getTransactionDetailsReq.getGetTransactionDetailsRequest());
		DefaultSOAPAPICallHandler defaultHandler = new DefaultSOAPAPICallHandler(getTransactionDetailsReq.toXMLString(null, "GetTransactionDetailsReq"), null, null);
		apiCallPreHandler = new MerchantAPICallPreHandler(defaultHandler, apiUsername, getAccessToken(), getTokenSecret());
		((MerchantAPICallPreHandler) apiCallPreHandler).setSdkName(SDK_NAME);
		((MerchantAPICallPreHandler) apiCallPreHandler).setSdkVersion(SDK_VERSION);
		((MerchantAPICallPreHandler) apiCallPreHandler).setPortName(portName);
	 	String response = call(apiCallPreHandler);
		DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = builderFactory.newDocumentBuilder();
		InputSource inStream = new InputSource();
		inStream.setCharacterStream(new StringReader((String) response));
		Document document = builder.parse(inStream);
		XPathFactory factory = XPathFactory.newInstance();
		XPath xpath = factory.newXPath();
		try {
			Node node = (Node) xpath.evaluate("Envelope/Body/GetTransactionDetailsResponse", document, XPathConstants.NODE);
			return new GetTransactionDetailsResponseType(node);
		} catch (XPathExpressionException exe) {
			throw new RuntimeException("Unable to parse response", exe);
		}
	 }
	 
	/** 
	 * AUTO_GENERATED
	 * @throws SSLConfigurationException
	 * @throws InvalidCredentialException
	 * @throws UnsupportedEncodingException
	 * @throws IOException
	 * @throws HttpErrorException
	 * @throws InvalidResponseDataException
	 * @throws ClientActionRequiredException
	 * @throws MissingCredentialException
	 * @throws InterruptedException
	 * @throws OAuthException
	 */
	 public GetTransactionDetailsResponseType getTransactionDetails(GetTransactionDetailsReq getTransactionDetailsReq) throws SSLConfigurationException, InvalidCredentialException, IOException, HttpErrorException, InvalidResponseDataException, ClientActionRequiredException, MissingCredentialException, InterruptedException, OAuthException, ParserConfigurationException, SAXException  {
	 	return getTransactionDetails(getTransactionDetailsReq, (String) null);
	 }

	/** 
	 * AUTO_GENERATED
	 * @throws SSLConfigurationException
	 * @throws InvalidCredentialException
	 * @throws UnsupportedEncodingException
	 * @throws IOException
	 * @throws HttpErrorException
	 * @throws InvalidResponseDataException
	 * @throws ClientActionRequiredException
	 * @throws MissingCredentialException
	 * @throws InterruptedException
	 * @throws OAuthException
	 */
	 public GetTransactionDetailsResponseType getTransactionDetails(GetTransactionDetailsReq getTransactionDetailsReq, ICredential credential) throws SSLConfigurationException, InvalidCredentialException, IOException, HttpErrorException, InvalidResponseDataException, ClientActionRequiredException, MissingCredentialException, InterruptedException, OAuthException, ParserConfigurationException, SAXException  {
	 	APICallPreHandler apiCallPreHandler = null;
	 	String portName = "PayPalAPI";
		setStandardParams(getTransactionDetailsReq.getGetTransactionDetailsRequest());
		DefaultSOAPAPICallHandler defaultHandler = new DefaultSOAPAPICallHandler(getTransactionDetailsReq.toXMLString(null, "GetTransactionDetailsReq"), null, null);
		apiCallPreHandler = new MerchantAPICallPreHandler(defaultHandler, credential);
		((MerchantAPICallPreHandler) apiCallPreHandler).setSdkName(SDK_NAME);
		((MerchantAPICallPreHandler) apiCallPreHandler).setSdkVersion(SDK_VERSION);
		((MerchantAPICallPreHandler) apiCallPreHandler).setPortName(portName);
	 	String response = call(apiCallPreHandler);
 	
		DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = builderFactory.newDocumentBuilder();
		InputSource inStream = new InputSource();
		inStream.setCharacterStream(new StringReader((String) response));
		Document document = builder.parse(inStream);
		XPathFactory factory = XPathFactory.newInstance();
		XPath xpath = factory.newXPath();
		try {
			Node node = (Node) xpath.evaluate(
					"Envelope/Body/GetTransactionDetailsResponse", document,
					XPathConstants.NODE);
			return new GetTransactionDetailsResponseType(node);
		} catch (XPathExpressionException exe) {
			throw new RuntimeException("Unable to parse response", exe);
		}	
	}
	/**	
	 * AUTO_GENERATED
	 * @throws SSLConfigurationException
	 * @throws InvalidCredentialException
	 * @throws UnsupportedEncodingException
	 * @throws IOException
	 * @throws HttpErrorException
	 * @throws InvalidResponseDataException
	 * @throws ClientActionRequiredException
	 * @throws MissingCredentialException
	 * @throws InterruptedException
	 * @throws OAuthException
	 */
	 public BillUserResponseType billUser(BillUserReq billUserReq, String apiUsername) throws SSLConfigurationException, InvalidCredentialException, IOException, HttpErrorException, InvalidResponseDataException, ClientActionRequiredException, MissingCredentialException, InterruptedException, OAuthException, ParserConfigurationException, SAXException, IOException {
	 	APICallPreHandler apiCallPreHandler = null;
	 	String portName = "PayPalAPI";
		setStandardParams(billUserReq.getBillUserRequest());
		DefaultSOAPAPICallHandler defaultHandler = new DefaultSOAPAPICallHandler(billUserReq.toXMLString(null, "BillUserReq"), null, null);
		apiCallPreHandler = new MerchantAPICallPreHandler(defaultHandler, apiUsername, getAccessToken(), getTokenSecret());
		((MerchantAPICallPreHandler) apiCallPreHandler).setSdkName(SDK_NAME);
		((MerchantAPICallPreHandler) apiCallPreHandler).setSdkVersion(SDK_VERSION);
		((MerchantAPICallPreHandler) apiCallPreHandler).setPortName(portName);
	 	String response = call(apiCallPreHandler);
		DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = builderFactory.newDocumentBuilder();
		InputSource inStream = new InputSource();
		inStream.setCharacterStream(new StringReader((String) response));
		Document document = builder.parse(inStream);
		XPathFactory factory = XPathFactory.newInstance();
		XPath xpath = factory.newXPath();
		try {
			Node node = (Node) xpath.evaluate("Envelope/Body/BillUserResponse", document, XPathConstants.NODE);
			return new BillUserResponseType(node);
		} catch (XPathExpressionException exe) {
			throw new RuntimeException("Unable to parse response", exe);
		}
	 }
	 
	/** 
	 * AUTO_GENERATED
	 * @throws SSLConfigurationException
	 * @throws InvalidCredentialException
	 * @throws UnsupportedEncodingException
	 * @throws IOException
	 * @throws HttpErrorException
	 * @throws InvalidResponseDataException
	 * @throws ClientActionRequiredException
	 * @throws MissingCredentialException
	 * @throws InterruptedException
	 * @throws OAuthException
	 */
	 public BillUserResponseType billUser(BillUserReq billUserReq) throws SSLConfigurationException, InvalidCredentialException, IOException, HttpErrorException, InvalidResponseDataException, ClientActionRequiredException, MissingCredentialException, InterruptedException, OAuthException, ParserConfigurationException, SAXException  {
	 	return billUser(billUserReq, (String) null);
	 }

	/** 
	 * AUTO_GENERATED
	 * @throws SSLConfigurationException
	 * @throws InvalidCredentialException
	 * @throws UnsupportedEncodingException
	 * @throws IOException
	 * @throws HttpErrorException
	 * @throws InvalidResponseDataException
	 * @throws ClientActionRequiredException
	 * @throws MissingCredentialException
	 * @throws InterruptedException
	 * @throws OAuthException
	 */
	 public BillUserResponseType billUser(BillUserReq billUserReq, ICredential credential) throws SSLConfigurationException, InvalidCredentialException, IOException, HttpErrorException, InvalidResponseDataException, ClientActionRequiredException, MissingCredentialException, InterruptedException, OAuthException, ParserConfigurationException, SAXException  {
	 	APICallPreHandler apiCallPreHandler = null;
	 	String portName = "PayPalAPI";
		setStandardParams(billUserReq.getBillUserRequest());
		DefaultSOAPAPICallHandler defaultHandler = new DefaultSOAPAPICallHandler(billUserReq.toXMLString(null, "BillUserReq"), null, null);
		apiCallPreHandler = new MerchantAPICallPreHandler(defaultHandler, credential);
		((MerchantAPICallPreHandler) apiCallPreHandler).setSdkName(SDK_NAME);
		((MerchantAPICallPreHandler) apiCallPreHandler).setSdkVersion(SDK_VERSION);
		((MerchantAPICallPreHandler) apiCallPreHandler).setPortName(portName);
	 	String response = call(apiCallPreHandler);
 	
		DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = builderFactory.newDocumentBuilder();
		InputSource inStream = new InputSource();
		inStream.setCharacterStream(new StringReader((String) response));
		Document document = builder.parse(inStream);
		XPathFactory factory = XPathFactory.newInstance();
		XPath xpath = factory.newXPath();
		try {
			Node node = (Node) xpath.evaluate(
					"Envelope/Body/BillUserResponse", document,
					XPathConstants.NODE);
			return new BillUserResponseType(node);
		} catch (XPathExpressionException exe) {
			throw new RuntimeException("Unable to parse response", exe);
		}	
	}
	/**	
	 * AUTO_GENERATED
	 * @throws SSLConfigurationException
	 * @throws InvalidCredentialException
	 * @throws UnsupportedEncodingException
	 * @throws IOException
	 * @throws HttpErrorException
	 * @throws InvalidResponseDataException
	 * @throws ClientActionRequiredException
	 * @throws MissingCredentialException
	 * @throws InterruptedException
	 * @throws OAuthException
	 */
	 public TransactionSearchResponseType transactionSearch(TransactionSearchReq transactionSearchReq, String apiUsername) throws SSLConfigurationException, InvalidCredentialException, IOException, HttpErrorException, InvalidResponseDataException, ClientActionRequiredException, MissingCredentialException, InterruptedException, OAuthException, ParserConfigurationException, SAXException, IOException {
	 	APICallPreHandler apiCallPreHandler = null;
	 	String portName = "PayPalAPI";
		setStandardParams(transactionSearchReq.getTransactionSearchRequest());
		DefaultSOAPAPICallHandler defaultHandler = new DefaultSOAPAPICallHandler(transactionSearchReq.toXMLString(null, "TransactionSearchReq"), null, null);
		apiCallPreHandler = new MerchantAPICallPreHandler(defaultHandler, apiUsername, getAccessToken(), getTokenSecret());
		((MerchantAPICallPreHandler) apiCallPreHandler).setSdkName(SDK_NAME);
		((MerchantAPICallPreHandler) apiCallPreHandler).setSdkVersion(SDK_VERSION);
		((MerchantAPICallPreHandler) apiCallPreHandler).setPortName(portName);
	 	String response = call(apiCallPreHandler);
		DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = builderFactory.newDocumentBuilder();
		InputSource inStream = new InputSource();
		inStream.setCharacterStream(new StringReader((String) response));
		Document document = builder.parse(inStream);
		XPathFactory factory = XPathFactory.newInstance();
		XPath xpath = factory.newXPath();
		try {
			Node node = (Node) xpath.evaluate("Envelope/Body/TransactionSearchResponse", document, XPathConstants.NODE);
			return new TransactionSearchResponseType(node);
		} catch (XPathExpressionException exe) {
			throw new RuntimeException("Unable to parse response", exe);
		}
	 }
	 
	/** 
	 * AUTO_GENERATED
	 * @throws SSLConfigurationException
	 * @throws InvalidCredentialException
	 * @throws UnsupportedEncodingException
	 * @throws IOException
	 * @throws HttpErrorException
	 * @throws InvalidResponseDataException
	 * @throws ClientActionRequiredException
	 * @throws MissingCredentialException
	 * @throws InterruptedException
	 * @throws OAuthException
	 */
	 public TransactionSearchResponseType transactionSearch(TransactionSearchReq transactionSearchReq) throws SSLConfigurationException, InvalidCredentialException, IOException, HttpErrorException, InvalidResponseDataException, ClientActionRequiredException, MissingCredentialException, InterruptedException, OAuthException, ParserConfigurationException, SAXException  {
	 	return transactionSearch(transactionSearchReq, (String) null);
	 }

	/** 
	 * AUTO_GENERATED
	 * @throws SSLConfigurationException
	 * @throws InvalidCredentialException
	 * @throws UnsupportedEncodingException
	 * @throws IOException
	 * @throws HttpErrorException
	 * @throws InvalidResponseDataException
	 * @throws ClientActionRequiredException
	 * @throws MissingCredentialException
	 * @throws InterruptedException
	 * @throws OAuthException
	 */
	 public TransactionSearchResponseType transactionSearch(TransactionSearchReq transactionSearchReq, ICredential credential) throws SSLConfigurationException, InvalidCredentialException, IOException, HttpErrorException, InvalidResponseDataException, ClientActionRequiredException, MissingCredentialException, InterruptedException, OAuthException, ParserConfigurationException, SAXException  {
	 	APICallPreHandler apiCallPreHandler = null;
	 	String portName = "PayPalAPI";
		setStandardParams(transactionSearchReq.getTransactionSearchRequest());
		DefaultSOAPAPICallHandler defaultHandler = new DefaultSOAPAPICallHandler(transactionSearchReq.toXMLString(null, "TransactionSearchReq"), null, null);
		apiCallPreHandler = new MerchantAPICallPreHandler(defaultHandler, credential);
		((MerchantAPICallPreHandler) apiCallPreHandler).setSdkName(SDK_NAME);
		((MerchantAPICallPreHandler) apiCallPreHandler).setSdkVersion(SDK_VERSION);
		((MerchantAPICallPreHandler) apiCallPreHandler).setPortName(portName);
	 	String response = call(apiCallPreHandler);
 	
		DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = builderFactory.newDocumentBuilder();
		InputSource inStream = new InputSource();
		inStream.setCharacterStream(new StringReader((String) response));
		Document document = builder.parse(inStream);
		XPathFactory factory = XPathFactory.newInstance();
		XPath xpath = factory.newXPath();
		try {
			Node node = (Node) xpath.evaluate(
					"Envelope/Body/TransactionSearchResponse", document,
					XPathConstants.NODE);
			return new TransactionSearchResponseType(node);
		} catch (XPathExpressionException exe) {
			throw new RuntimeException("Unable to parse response", exe);
		}	
	}
	/**	
	 * AUTO_GENERATED
	 * @throws SSLConfigurationException
	 * @throws InvalidCredentialException
	 * @throws UnsupportedEncodingException
	 * @throws IOException
	 * @throws HttpErrorException
	 * @throws InvalidResponseDataException
	 * @throws ClientActionRequiredException
	 * @throws MissingCredentialException
	 * @throws InterruptedException
	 * @throws OAuthException
	 */
	 public MassPayResponseType massPay(MassPayReq massPayReq, String apiUsername) throws SSLConfigurationException, InvalidCredentialException, IOException, HttpErrorException, InvalidResponseDataException, ClientActionRequiredException, MissingCredentialException, InterruptedException, OAuthException, ParserConfigurationException, SAXException, IOException {
	 	APICallPreHandler apiCallPreHandler = null;
	 	String portName = "PayPalAPI";
		setStandardParams(massPayReq.getMassPayRequest());
		DefaultSOAPAPICallHandler defaultHandler = new DefaultSOAPAPICallHandler(massPayReq.toXMLString(null, "MassPayReq"), null, null);
		apiCallPreHandler = new MerchantAPICallPreHandler(defaultHandler, apiUsername, getAccessToken(), getTokenSecret());
		((MerchantAPICallPreHandler) apiCallPreHandler).setSdkName(SDK_NAME);
		((MerchantAPICallPreHandler) apiCallPreHandler).setSdkVersion(SDK_VERSION);
		((MerchantAPICallPreHandler) apiCallPreHandler).setPortName(portName);
	 	String response = call(apiCallPreHandler);
		DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = builderFactory.newDocumentBuilder();
		InputSource inStream = new InputSource();
		inStream.setCharacterStream(new StringReader((String) response));
		Document document = builder.parse(inStream);
		XPathFactory factory = XPathFactory.newInstance();
		XPath xpath = factory.newXPath();
		try {
			Node node = (Node) xpath.evaluate("Envelope/Body/MassPayResponse", document, XPathConstants.NODE);
			return new MassPayResponseType(node);
		} catch (XPathExpressionException exe) {
			throw new RuntimeException("Unable to parse response", exe);
		}
	 }
	 
	/** 
	 * AUTO_GENERATED
	 * @throws SSLConfigurationException
	 * @throws InvalidCredentialException
	 * @throws UnsupportedEncodingException
	 * @throws IOException
	 * @throws HttpErrorException
	 * @throws InvalidResponseDataException
	 * @throws ClientActionRequiredException
	 * @throws MissingCredentialException
	 * @throws InterruptedException
	 * @throws OAuthException
	 */
	 public MassPayResponseType massPay(MassPayReq massPayReq) throws SSLConfigurationException, InvalidCredentialException, IOException, HttpErrorException, InvalidResponseDataException, ClientActionRequiredException, MissingCredentialException, InterruptedException, OAuthException, ParserConfigurationException, SAXException  {
	 	return massPay(massPayReq, (String) null);
	 }

	/** 
	 * AUTO_GENERATED
	 * @throws SSLConfigurationException
	 * @throws InvalidCredentialException
	 * @throws UnsupportedEncodingException
	 * @throws IOException
	 * @throws HttpErrorException
	 * @throws InvalidResponseDataException
	 * @throws ClientActionRequiredException
	 * @throws MissingCredentialException
	 * @throws InterruptedException
	 * @throws OAuthException
	 */
	 public MassPayResponseType massPay(MassPayReq massPayReq, ICredential credential) throws SSLConfigurationException, InvalidCredentialException, IOException, HttpErrorException, InvalidResponseDataException, ClientActionRequiredException, MissingCredentialException, InterruptedException, OAuthException, ParserConfigurationException, SAXException  {
	 	APICallPreHandler apiCallPreHandler = null;
	 	String portName = "PayPalAPI";
		setStandardParams(massPayReq.getMassPayRequest());
		DefaultSOAPAPICallHandler defaultHandler = new DefaultSOAPAPICallHandler(massPayReq.toXMLString(null, "MassPayReq"), null, null);
		apiCallPreHandler = new MerchantAPICallPreHandler(defaultHandler, credential);
		((MerchantAPICallPreHandler) apiCallPreHandler).setSdkName(SDK_NAME);
		((MerchantAPICallPreHandler) apiCallPreHandler).setSdkVersion(SDK_VERSION);
		((MerchantAPICallPreHandler) apiCallPreHandler).setPortName(portName);
	 	String response = call(apiCallPreHandler);
 	
		DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = builderFactory.newDocumentBuilder();
		InputSource inStream = new InputSource();
		inStream.setCharacterStream(new StringReader((String) response));
		Document document = builder.parse(inStream);
		XPathFactory factory = XPathFactory.newInstance();
		XPath xpath = factory.newXPath();
		try {
			Node node = (Node) xpath.evaluate(
					"Envelope/Body/MassPayResponse", document,
					XPathConstants.NODE);
			return new MassPayResponseType(node);
		} catch (XPathExpressionException exe) {
			throw new RuntimeException("Unable to parse response", exe);
		}	
	}
	/**	
	 * AUTO_GENERATED
	 * @throws SSLConfigurationException
	 * @throws InvalidCredentialException
	 * @throws UnsupportedEncodingException
	 * @throws IOException
	 * @throws HttpErrorException
	 * @throws InvalidResponseDataException
	 * @throws ClientActionRequiredException
	 * @throws MissingCredentialException
	 * @throws InterruptedException
	 * @throws OAuthException
	 */
	 public BAUpdateResponseType billAgreementUpdate(BillAgreementUpdateReq billAgreementUpdateReq, String apiUsername) throws SSLConfigurationException, InvalidCredentialException, IOException, HttpErrorException, InvalidResponseDataException, ClientActionRequiredException, MissingCredentialException, InterruptedException, OAuthException, ParserConfigurationException, SAXException, IOException {
	 	APICallPreHandler apiCallPreHandler = null;
	 	String portName = "PayPalAPI";
		setStandardParams(billAgreementUpdateReq.getBAUpdateRequest());
		DefaultSOAPAPICallHandler defaultHandler = new DefaultSOAPAPICallHandler(billAgreementUpdateReq.toXMLString(null, "BillAgreementUpdateReq"), null, null);
		apiCallPreHandler = new MerchantAPICallPreHandler(defaultHandler, apiUsername, getAccessToken(), getTokenSecret());
		((MerchantAPICallPreHandler) apiCallPreHandler).setSdkName(SDK_NAME);
		((MerchantAPICallPreHandler) apiCallPreHandler).setSdkVersion(SDK_VERSION);
		((MerchantAPICallPreHandler) apiCallPreHandler).setPortName(portName);
	 	String response = call(apiCallPreHandler);
		DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = builderFactory.newDocumentBuilder();
		InputSource inStream = new InputSource();
		inStream.setCharacterStream(new StringReader((String) response));
		Document document = builder.parse(inStream);
		XPathFactory factory = XPathFactory.newInstance();
		XPath xpath = factory.newXPath();
		try {
			Node node = (Node) xpath.evaluate("Envelope/Body/BAUpdateResponse", document, XPathConstants.NODE);
			return new BAUpdateResponseType(node);
		} catch (XPathExpressionException exe) {
			throw new RuntimeException("Unable to parse response", exe);
		}
	 }
	 
	/** 
	 * AUTO_GENERATED
	 * @throws SSLConfigurationException
	 * @throws InvalidCredentialException
	 * @throws UnsupportedEncodingException
	 * @throws IOException
	 * @throws HttpErrorException
	 * @throws InvalidResponseDataException
	 * @throws ClientActionRequiredException
	 * @throws MissingCredentialException
	 * @throws InterruptedException
	 * @throws OAuthException
	 */
	 public BAUpdateResponseType billAgreementUpdate(BillAgreementUpdateReq billAgreementUpdateReq) throws SSLConfigurationException, InvalidCredentialException, IOException, HttpErrorException, InvalidResponseDataException, ClientActionRequiredException, MissingCredentialException, InterruptedException, OAuthException, ParserConfigurationException, SAXException  {
	 	return billAgreementUpdate(billAgreementUpdateReq, (String) null);
	 }

	/** 
	 * AUTO_GENERATED
	 * @throws SSLConfigurationException
	 * @throws InvalidCredentialException
	 * @throws UnsupportedEncodingException
	 * @throws IOException
	 * @throws HttpErrorException
	 * @throws InvalidResponseDataException
	 * @throws ClientActionRequiredException
	 * @throws MissingCredentialException
	 * @throws InterruptedException
	 * @throws OAuthException
	 */
	 public BAUpdateResponseType billAgreementUpdate(BillAgreementUpdateReq billAgreementUpdateReq, ICredential credential) throws SSLConfigurationException, InvalidCredentialException, IOException, HttpErrorException, InvalidResponseDataException, ClientActionRequiredException, MissingCredentialException, InterruptedException, OAuthException, ParserConfigurationException, SAXException  {
	 	APICallPreHandler apiCallPreHandler = null;
	 	String portName = "PayPalAPI";
		setStandardParams(billAgreementUpdateReq.getBAUpdateRequest());
		DefaultSOAPAPICallHandler defaultHandler = new DefaultSOAPAPICallHandler(billAgreementUpdateReq.toXMLString(null, "BillAgreementUpdateReq"), null, null);
		apiCallPreHandler = new MerchantAPICallPreHandler(defaultHandler, credential);
		((MerchantAPICallPreHandler) apiCallPreHandler).setSdkName(SDK_NAME);
		((MerchantAPICallPreHandler) apiCallPreHandler).setSdkVersion(SDK_VERSION);
		((MerchantAPICallPreHandler) apiCallPreHandler).setPortName(portName);
	 	String response = call(apiCallPreHandler);
 	
		DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = builderFactory.newDocumentBuilder();
		InputSource inStream = new InputSource();
		inStream.setCharacterStream(new StringReader((String) response));
		Document document = builder.parse(inStream);
		XPathFactory factory = XPathFactory.newInstance();
		XPath xpath = factory.newXPath();
		try {
			Node node = (Node) xpath.evaluate(
					"Envelope/Body/BAUpdateResponse", document,
					XPathConstants.NODE);
			return new BAUpdateResponseType(node);
		} catch (XPathExpressionException exe) {
			throw new RuntimeException("Unable to parse response", exe);
		}	
	}
	/**	
	 * AUTO_GENERATED
	 * @throws SSLConfigurationException
	 * @throws InvalidCredentialException
	 * @throws UnsupportedEncodingException
	 * @throws IOException
	 * @throws HttpErrorException
	 * @throws InvalidResponseDataException
	 * @throws ClientActionRequiredException
	 * @throws MissingCredentialException
	 * @throws InterruptedException
	 * @throws OAuthException
	 */
	 public AddressVerifyResponseType addressVerify(AddressVerifyReq addressVerifyReq, String apiUsername) throws SSLConfigurationException, InvalidCredentialException, IOException, HttpErrorException, InvalidResponseDataException, ClientActionRequiredException, MissingCredentialException, InterruptedException, OAuthException, ParserConfigurationException, SAXException, IOException {
	 	APICallPreHandler apiCallPreHandler = null;
	 	String portName = "PayPalAPI";
		setStandardParams(addressVerifyReq.getAddressVerifyRequest());
		DefaultSOAPAPICallHandler defaultHandler = new DefaultSOAPAPICallHandler(addressVerifyReq.toXMLString(null, "AddressVerifyReq"), null, null);
		apiCallPreHandler = new MerchantAPICallPreHandler(defaultHandler, apiUsername, getAccessToken(), getTokenSecret());
		((MerchantAPICallPreHandler) apiCallPreHandler).setSdkName(SDK_NAME);
		((MerchantAPICallPreHandler) apiCallPreHandler).setSdkVersion(SDK_VERSION);
		((MerchantAPICallPreHandler) apiCallPreHandler).setPortName(portName);
	 	String response = call(apiCallPreHandler);
		DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = builderFactory.newDocumentBuilder();
		InputSource inStream = new InputSource();
		inStream.setCharacterStream(new StringReader((String) response));
		Document document = builder.parse(inStream);
		XPathFactory factory = XPathFactory.newInstance();
		XPath xpath = factory.newXPath();
		try {
			Node node = (Node) xpath.evaluate("Envelope/Body/AddressVerifyResponse", document, XPathConstants.NODE);
			return new AddressVerifyResponseType(node);
		} catch (XPathExpressionException exe) {
			throw new RuntimeException("Unable to parse response", exe);
		}
	 }
	 
	/** 
	 * AUTO_GENERATED
	 * @throws SSLConfigurationException
	 * @throws InvalidCredentialException
	 * @throws UnsupportedEncodingException
	 * @throws IOException
	 * @throws HttpErrorException
	 * @throws InvalidResponseDataException
	 * @throws ClientActionRequiredException
	 * @throws MissingCredentialException
	 * @throws InterruptedException
	 * @throws OAuthException
	 */
	 public AddressVerifyResponseType addressVerify(AddressVerifyReq addressVerifyReq) throws SSLConfigurationException, InvalidCredentialException, IOException, HttpErrorException, InvalidResponseDataException, ClientActionRequiredException, MissingCredentialException, InterruptedException, OAuthException, ParserConfigurationException, SAXException  {
	 	return addressVerify(addressVerifyReq, (String) null);
	 }

	/** 
	 * AUTO_GENERATED
	 * @throws SSLConfigurationException
	 * @throws InvalidCredentialException
	 * @throws UnsupportedEncodingException
	 * @throws IOException
	 * @throws HttpErrorException
	 * @throws InvalidResponseDataException
	 * @throws ClientActionRequiredException
	 * @throws MissingCredentialException
	 * @throws InterruptedException
	 * @throws OAuthException
	 */
	 public AddressVerifyResponseType addressVerify(AddressVerifyReq addressVerifyReq, ICredential credential) throws SSLConfigurationException, InvalidCredentialException, IOException, HttpErrorException, InvalidResponseDataException, ClientActionRequiredException, MissingCredentialException, InterruptedException, OAuthException, ParserConfigurationException, SAXException  {
	 	APICallPreHandler apiCallPreHandler = null;
	 	String portName = "PayPalAPI";
		setStandardParams(addressVerifyReq.getAddressVerifyRequest());
		DefaultSOAPAPICallHandler defaultHandler = new DefaultSOAPAPICallHandler(addressVerifyReq.toXMLString(null, "AddressVerifyReq"), null, null);
		apiCallPreHandler = new MerchantAPICallPreHandler(defaultHandler, credential);
		((MerchantAPICallPreHandler) apiCallPreHandler).setSdkName(SDK_NAME);
		((MerchantAPICallPreHandler) apiCallPreHandler).setSdkVersion(SDK_VERSION);
		((MerchantAPICallPreHandler) apiCallPreHandler).setPortName(portName);
	 	String response = call(apiCallPreHandler);
 	
		DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = builderFactory.newDocumentBuilder();
		InputSource inStream = new InputSource();
		inStream.setCharacterStream(new StringReader((String) response));
		Document document = builder.parse(inStream);
		XPathFactory factory = XPathFactory.newInstance();
		XPath xpath = factory.newXPath();
		try {
			Node node = (Node) xpath.evaluate(
					"Envelope/Body/AddressVerifyResponse", document,
					XPathConstants.NODE);
			return new AddressVerifyResponseType(node);
		} catch (XPathExpressionException exe) {
			throw new RuntimeException("Unable to parse response", exe);
		}	
	}
	/**	
	 * AUTO_GENERATED
	 * @throws SSLConfigurationException
	 * @throws InvalidCredentialException
	 * @throws UnsupportedEncodingException
	 * @throws IOException
	 * @throws HttpErrorException
	 * @throws InvalidResponseDataException
	 * @throws ClientActionRequiredException
	 * @throws MissingCredentialException
	 * @throws InterruptedException
	 * @throws OAuthException
	 */
	 public EnterBoardingResponseType enterBoarding(EnterBoardingReq enterBoardingReq, String apiUsername) throws SSLConfigurationException, InvalidCredentialException, IOException, HttpErrorException, InvalidResponseDataException, ClientActionRequiredException, MissingCredentialException, InterruptedException, OAuthException, ParserConfigurationException, SAXException, IOException {
	 	APICallPreHandler apiCallPreHandler = null;
	 	String portName = "PayPalAPI";
		setStandardParams(enterBoardingReq.getEnterBoardingRequest());
		DefaultSOAPAPICallHandler defaultHandler = new DefaultSOAPAPICallHandler(enterBoardingReq.toXMLString(null, "EnterBoardingReq"), null, null);
		apiCallPreHandler = new MerchantAPICallPreHandler(defaultHandler, apiUsername, getAccessToken(), getTokenSecret());
		((MerchantAPICallPreHandler) apiCallPreHandler).setSdkName(SDK_NAME);
		((MerchantAPICallPreHandler) apiCallPreHandler).setSdkVersion(SDK_VERSION);
		((MerchantAPICallPreHandler) apiCallPreHandler).setPortName(portName);
	 	String response = call(apiCallPreHandler);
		DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = builderFactory.newDocumentBuilder();
		InputSource inStream = new InputSource();
		inStream.setCharacterStream(new StringReader((String) response));
		Document document = builder.parse(inStream);
		XPathFactory factory = XPathFactory.newInstance();
		XPath xpath = factory.newXPath();
		try {
			Node node = (Node) xpath.evaluate("Envelope/Body/EnterBoardingResponse", document, XPathConstants.NODE);
			return new EnterBoardingResponseType(node);
		} catch (XPathExpressionException exe) {
			throw new RuntimeException("Unable to parse response", exe);
		}
	 }
	 
	/** 
	 * AUTO_GENERATED
	 * @throws SSLConfigurationException
	 * @throws InvalidCredentialException
	 * @throws UnsupportedEncodingException
	 * @throws IOException
	 * @throws HttpErrorException
	 * @throws InvalidResponseDataException
	 * @throws ClientActionRequiredException
	 * @throws MissingCredentialException
	 * @throws InterruptedException
	 * @throws OAuthException
	 */
	 public EnterBoardingResponseType enterBoarding(EnterBoardingReq enterBoardingReq) throws SSLConfigurationException, InvalidCredentialException, IOException, HttpErrorException, InvalidResponseDataException, ClientActionRequiredException, MissingCredentialException, InterruptedException, OAuthException, ParserConfigurationException, SAXException  {
	 	return enterBoarding(enterBoardingReq, (String) null);
	 }

	/** 
	 * AUTO_GENERATED
	 * @throws SSLConfigurationException
	 * @throws InvalidCredentialException
	 * @throws UnsupportedEncodingException
	 * @throws IOException
	 * @throws HttpErrorException
	 * @throws InvalidResponseDataException
	 * @throws ClientActionRequiredException
	 * @throws MissingCredentialException
	 * @throws InterruptedException
	 * @throws OAuthException
	 */
	 public EnterBoardingResponseType enterBoarding(EnterBoardingReq enterBoardingReq, ICredential credential) throws SSLConfigurationException, InvalidCredentialException, IOException, HttpErrorException, InvalidResponseDataException, ClientActionRequiredException, MissingCredentialException, InterruptedException, OAuthException, ParserConfigurationException, SAXException  {
	 	APICallPreHandler apiCallPreHandler = null;
	 	String portName = "PayPalAPI";
		setStandardParams(enterBoardingReq.getEnterBoardingRequest());
		DefaultSOAPAPICallHandler defaultHandler = new DefaultSOAPAPICallHandler(enterBoardingReq.toXMLString(null, "EnterBoardingReq"), null, null);
		apiCallPreHandler = new MerchantAPICallPreHandler(defaultHandler, credential);
		((MerchantAPICallPreHandler) apiCallPreHandler).setSdkName(SDK_NAME);
		((MerchantAPICallPreHandler) apiCallPreHandler).setSdkVersion(SDK_VERSION);
		((MerchantAPICallPreHandler) apiCallPreHandler).setPortName(portName);
	 	String response = call(apiCallPreHandler);
 	
		DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = builderFactory.newDocumentBuilder();
		InputSource inStream = new InputSource();
		inStream.setCharacterStream(new StringReader((String) response));
		Document document = builder.parse(inStream);
		XPathFactory factory = XPathFactory.newInstance();
		XPath xpath = factory.newXPath();
		try {
			Node node = (Node) xpath.evaluate(
					"Envelope/Body/EnterBoardingResponse", document,
					XPathConstants.NODE);
			return new EnterBoardingResponseType(node);
		} catch (XPathExpressionException exe) {
			throw new RuntimeException("Unable to parse response", exe);
		}	
	}
	/**	
	 * AUTO_GENERATED
	 * @throws SSLConfigurationException
	 * @throws InvalidCredentialException
	 * @throws UnsupportedEncodingException
	 * @throws IOException
	 * @throws HttpErrorException
	 * @throws InvalidResponseDataException
	 * @throws ClientActionRequiredException
	 * @throws MissingCredentialException
	 * @throws InterruptedException
	 * @throws OAuthException
	 */
	 public GetBoardingDetailsResponseType getBoardingDetails(GetBoardingDetailsReq getBoardingDetailsReq, String apiUsername) throws SSLConfigurationException, InvalidCredentialException, IOException, HttpErrorException, InvalidResponseDataException, ClientActionRequiredException, MissingCredentialException, InterruptedException, OAuthException, ParserConfigurationException, SAXException, IOException {
	 	APICallPreHandler apiCallPreHandler = null;
	 	String portName = "PayPalAPI";
		setStandardParams(getBoardingDetailsReq.getGetBoardingDetailsRequest());
		DefaultSOAPAPICallHandler defaultHandler = new DefaultSOAPAPICallHandler(getBoardingDetailsReq.toXMLString(null, "GetBoardingDetailsReq"), null, null);
		apiCallPreHandler = new MerchantAPICallPreHandler(defaultHandler, apiUsername, getAccessToken(), getTokenSecret());
		((MerchantAPICallPreHandler) apiCallPreHandler).setSdkName(SDK_NAME);
		((MerchantAPICallPreHandler) apiCallPreHandler).setSdkVersion(SDK_VERSION);
		((MerchantAPICallPreHandler) apiCallPreHandler).setPortName(portName);
	 	String response = call(apiCallPreHandler);
		DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = builderFactory.newDocumentBuilder();
		InputSource inStream = new InputSource();
		inStream.setCharacterStream(new StringReader((String) response));
		Document document = builder.parse(inStream);
		XPathFactory factory = XPathFactory.newInstance();
		XPath xpath = factory.newXPath();
		try {
			Node node = (Node) xpath.evaluate("Envelope/Body/GetBoardingDetailsResponse", document, XPathConstants.NODE);
			return new GetBoardingDetailsResponseType(node);
		} catch (XPathExpressionException exe) {
			throw new RuntimeException("Unable to parse response", exe);
		}
	 }
	 
	/** 
	 * AUTO_GENERATED
	 * @throws SSLConfigurationException
	 * @throws InvalidCredentialException
	 * @throws UnsupportedEncodingException
	 * @throws IOException
	 * @throws HttpErrorException
	 * @throws InvalidResponseDataException
	 * @throws ClientActionRequiredException
	 * @throws MissingCredentialException
	 * @throws InterruptedException
	 * @throws OAuthException
	 */
	 public GetBoardingDetailsResponseType getBoardingDetails(GetBoardingDetailsReq getBoardingDetailsReq) throws SSLConfigurationException, InvalidCredentialException, IOException, HttpErrorException, InvalidResponseDataException, ClientActionRequiredException, MissingCredentialException, InterruptedException, OAuthException, ParserConfigurationException, SAXException  {
	 	return getBoardingDetails(getBoardingDetailsReq, (String) null);
	 }

	/** 
	 * AUTO_GENERATED
	 * @throws SSLConfigurationException
	 * @throws InvalidCredentialException
	 * @throws UnsupportedEncodingException
	 * @throws IOException
	 * @throws HttpErrorException
	 * @throws InvalidResponseDataException
	 * @throws ClientActionRequiredException
	 * @throws MissingCredentialException
	 * @throws InterruptedException
	 * @throws OAuthException
	 */
	 public GetBoardingDetailsResponseType getBoardingDetails(GetBoardingDetailsReq getBoardingDetailsReq, ICredential credential) throws SSLConfigurationException, InvalidCredentialException, IOException, HttpErrorException, InvalidResponseDataException, ClientActionRequiredException, MissingCredentialException, InterruptedException, OAuthException, ParserConfigurationException, SAXException  {
	 	APICallPreHandler apiCallPreHandler = null;
	 	String portName = "PayPalAPI";
		setStandardParams(getBoardingDetailsReq.getGetBoardingDetailsRequest());
		DefaultSOAPAPICallHandler defaultHandler = new DefaultSOAPAPICallHandler(getBoardingDetailsReq.toXMLString(null, "GetBoardingDetailsReq"), null, null);
		apiCallPreHandler = new MerchantAPICallPreHandler(defaultHandler, credential);
		((MerchantAPICallPreHandler) apiCallPreHandler).setSdkName(SDK_NAME);
		((MerchantAPICallPreHandler) apiCallPreHandler).setSdkVersion(SDK_VERSION);
		((MerchantAPICallPreHandler) apiCallPreHandler).setPortName(portName);
	 	String response = call(apiCallPreHandler);
 	
		DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = builderFactory.newDocumentBuilder();
		InputSource inStream = new InputSource();
		inStream.setCharacterStream(new StringReader((String) response));
		Document document = builder.parse(inStream);
		XPathFactory factory = XPathFactory.newInstance();
		XPath xpath = factory.newXPath();
		try {
			Node node = (Node) xpath.evaluate(
					"Envelope/Body/GetBoardingDetailsResponse", document,
					XPathConstants.NODE);
			return new GetBoardingDetailsResponseType(node);
		} catch (XPathExpressionException exe) {
			throw new RuntimeException("Unable to parse response", exe);
		}	
	}
	/**	
	 * AUTO_GENERATED
	 * @throws SSLConfigurationException
	 * @throws InvalidCredentialException
	 * @throws UnsupportedEncodingException
	 * @throws IOException
	 * @throws HttpErrorException
	 * @throws InvalidResponseDataException
	 * @throws ClientActionRequiredException
	 * @throws MissingCredentialException
	 * @throws InterruptedException
	 * @throws OAuthException
	 */
	 public CreateMobilePaymentResponseType createMobilePayment(CreateMobilePaymentReq createMobilePaymentReq, String apiUsername) throws SSLConfigurationException, InvalidCredentialException, IOException, HttpErrorException, InvalidResponseDataException, ClientActionRequiredException, MissingCredentialException, InterruptedException, OAuthException, ParserConfigurationException, SAXException, IOException {
	 	APICallPreHandler apiCallPreHandler = null;
	 	String portName = "PayPalAPI";
		setStandardParams(createMobilePaymentReq.getCreateMobilePaymentRequest());
		DefaultSOAPAPICallHandler defaultHandler = new DefaultSOAPAPICallHandler(createMobilePaymentReq.toXMLString(null, "CreateMobilePaymentReq"), null, null);
		apiCallPreHandler = new MerchantAPICallPreHandler(defaultHandler, apiUsername, getAccessToken(), getTokenSecret());
		((MerchantAPICallPreHandler) apiCallPreHandler).setSdkName(SDK_NAME);
		((MerchantAPICallPreHandler) apiCallPreHandler).setSdkVersion(SDK_VERSION);
		((MerchantAPICallPreHandler) apiCallPreHandler).setPortName(portName);
	 	String response = call(apiCallPreHandler);
		DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = builderFactory.newDocumentBuilder();
		InputSource inStream = new InputSource();
		inStream.setCharacterStream(new StringReader((String) response));
		Document document = builder.parse(inStream);
		XPathFactory factory = XPathFactory.newInstance();
		XPath xpath = factory.newXPath();
		try {
			Node node = (Node) xpath.evaluate("Envelope/Body/CreateMobilePaymentResponse", document, XPathConstants.NODE);
			return new CreateMobilePaymentResponseType(node);
		} catch (XPathExpressionException exe) {
			throw new RuntimeException("Unable to parse response", exe);
		}
	 }
	 
	/** 
	 * AUTO_GENERATED
	 * @throws SSLConfigurationException
	 * @throws InvalidCredentialException
	 * @throws UnsupportedEncodingException
	 * @throws IOException
	 * @throws HttpErrorException
	 * @throws InvalidResponseDataException
	 * @throws ClientActionRequiredException
	 * @throws MissingCredentialException
	 * @throws InterruptedException
	 * @throws OAuthException
	 */
	 public CreateMobilePaymentResponseType createMobilePayment(CreateMobilePaymentReq createMobilePaymentReq) throws SSLConfigurationException, InvalidCredentialException, IOException, HttpErrorException, InvalidResponseDataException, ClientActionRequiredException, MissingCredentialException, InterruptedException, OAuthException, ParserConfigurationException, SAXException  {
	 	return createMobilePayment(createMobilePaymentReq, (String) null);
	 }

	/** 
	 * AUTO_GENERATED
	 * @throws SSLConfigurationException
	 * @throws InvalidCredentialException
	 * @throws UnsupportedEncodingException
	 * @throws IOException
	 * @throws HttpErrorException
	 * @throws InvalidResponseDataException
	 * @throws ClientActionRequiredException
	 * @throws MissingCredentialException
	 * @throws InterruptedException
	 * @throws OAuthException
	 */
	 public CreateMobilePaymentResponseType createMobilePayment(CreateMobilePaymentReq createMobilePaymentReq, ICredential credential) throws SSLConfigurationException, InvalidCredentialException, IOException, HttpErrorException, InvalidResponseDataException, ClientActionRequiredException, MissingCredentialException, InterruptedException, OAuthException, ParserConfigurationException, SAXException  {
	 	APICallPreHandler apiCallPreHandler = null;
	 	String portName = "PayPalAPI";
		setStandardParams(createMobilePaymentReq.getCreateMobilePaymentRequest());
		DefaultSOAPAPICallHandler defaultHandler = new DefaultSOAPAPICallHandler(createMobilePaymentReq.toXMLString(null, "CreateMobilePaymentReq"), null, null);
		apiCallPreHandler = new MerchantAPICallPreHandler(defaultHandler, credential);
		((MerchantAPICallPreHandler) apiCallPreHandler).setSdkName(SDK_NAME);
		((MerchantAPICallPreHandler) apiCallPreHandler).setSdkVersion(SDK_VERSION);
		((MerchantAPICallPreHandler) apiCallPreHandler).setPortName(portName);
	 	String response = call(apiCallPreHandler);
 	
		DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = builderFactory.newDocumentBuilder();
		InputSource inStream = new InputSource();
		inStream.setCharacterStream(new StringReader((String) response));
		Document document = builder.parse(inStream);
		XPathFactory factory = XPathFactory.newInstance();
		XPath xpath = factory.newXPath();
		try {
			Node node = (Node) xpath.evaluate(
					"Envelope/Body/CreateMobilePaymentResponse", document,
					XPathConstants.NODE);
			return new CreateMobilePaymentResponseType(node);
		} catch (XPathExpressionException exe) {
			throw new RuntimeException("Unable to parse response", exe);
		}	
	}
	/**	
	 * AUTO_GENERATED
	 * @throws SSLConfigurationException
	 * @throws InvalidCredentialException
	 * @throws UnsupportedEncodingException
	 * @throws IOException
	 * @throws HttpErrorException
	 * @throws InvalidResponseDataException
	 * @throws ClientActionRequiredException
	 * @throws MissingCredentialException
	 * @throws InterruptedException
	 * @throws OAuthException
	 */
	 public GetMobileStatusResponseType getMobileStatus(GetMobileStatusReq getMobileStatusReq, String apiUsername) throws SSLConfigurationException, InvalidCredentialException, IOException, HttpErrorException, InvalidResponseDataException, ClientActionRequiredException, MissingCredentialException, InterruptedException, OAuthException, ParserConfigurationException, SAXException, IOException {
	 	APICallPreHandler apiCallPreHandler = null;
	 	String portName = "PayPalAPI";
		setStandardParams(getMobileStatusReq.getGetMobileStatusRequest());
		DefaultSOAPAPICallHandler defaultHandler = new DefaultSOAPAPICallHandler(getMobileStatusReq.toXMLString(null, "GetMobileStatusReq"), null, null);
		apiCallPreHandler = new MerchantAPICallPreHandler(defaultHandler, apiUsername, getAccessToken(), getTokenSecret());
		((MerchantAPICallPreHandler) apiCallPreHandler).setSdkName(SDK_NAME);
		((MerchantAPICallPreHandler) apiCallPreHandler).setSdkVersion(SDK_VERSION);
		((MerchantAPICallPreHandler) apiCallPreHandler).setPortName(portName);
	 	String response = call(apiCallPreHandler);
		DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = builderFactory.newDocumentBuilder();
		InputSource inStream = new InputSource();
		inStream.setCharacterStream(new StringReader((String) response));
		Document document = builder.parse(inStream);
		XPathFactory factory = XPathFactory.newInstance();
		XPath xpath = factory.newXPath();
		try {
			Node node = (Node) xpath.evaluate("Envelope/Body/GetMobileStatusResponse", document, XPathConstants.NODE);
			return new GetMobileStatusResponseType(node);
		} catch (XPathExpressionException exe) {
			throw new RuntimeException("Unable to parse response", exe);
		}
	 }
	 
	/** 
	 * AUTO_GENERATED
	 * @throws SSLConfigurationException
	 * @throws InvalidCredentialException
	 * @throws UnsupportedEncodingException
	 * @throws IOException
	 * @throws HttpErrorException
	 * @throws InvalidResponseDataException
	 * @throws ClientActionRequiredException
	 * @throws MissingCredentialException
	 * @throws InterruptedException
	 * @throws OAuthException
	 */
	 public GetMobileStatusResponseType getMobileStatus(GetMobileStatusReq getMobileStatusReq) throws SSLConfigurationException, InvalidCredentialException, IOException, HttpErrorException, InvalidResponseDataException, ClientActionRequiredException, MissingCredentialException, InterruptedException, OAuthException, ParserConfigurationException, SAXException  {
	 	return getMobileStatus(getMobileStatusReq, (String) null);
	 }

	/** 
	 * AUTO_GENERATED
	 * @throws SSLConfigurationException
	 * @throws InvalidCredentialException
	 * @throws UnsupportedEncodingException
	 * @throws IOException
	 * @throws HttpErrorException
	 * @throws InvalidResponseDataException
	 * @throws ClientActionRequiredException
	 * @throws MissingCredentialException
	 * @throws InterruptedException
	 * @throws OAuthException
	 */
	 public GetMobileStatusResponseType getMobileStatus(GetMobileStatusReq getMobileStatusReq, ICredential credential) throws SSLConfigurationException, InvalidCredentialException, IOException, HttpErrorException, InvalidResponseDataException, ClientActionRequiredException, MissingCredentialException, InterruptedException, OAuthException, ParserConfigurationException, SAXException  {
	 	APICallPreHandler apiCallPreHandler = null;
	 	String portName = "PayPalAPI";
		setStandardParams(getMobileStatusReq.getGetMobileStatusRequest());
		DefaultSOAPAPICallHandler defaultHandler = new DefaultSOAPAPICallHandler(getMobileStatusReq.toXMLString(null, "GetMobileStatusReq"), null, null);
		apiCallPreHandler = new MerchantAPICallPreHandler(defaultHandler, credential);
		((MerchantAPICallPreHandler) apiCallPreHandler).setSdkName(SDK_NAME);
		((MerchantAPICallPreHandler) apiCallPreHandler).setSdkVersion(SDK_VERSION);
		((MerchantAPICallPreHandler) apiCallPreHandler).setPortName(portName);
	 	String response = call(apiCallPreHandler);
 	
		DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = builderFactory.newDocumentBuilder();
		InputSource inStream = new InputSource();
		inStream.setCharacterStream(new StringReader((String) response));
		Document document = builder.parse(inStream);
		XPathFactory factory = XPathFactory.newInstance();
		XPath xpath = factory.newXPath();
		try {
			Node node = (Node) xpath.evaluate(
					"Envelope/Body/GetMobileStatusResponse", document,
					XPathConstants.NODE);
			return new GetMobileStatusResponseType(node);
		} catch (XPathExpressionException exe) {
			throw new RuntimeException("Unable to parse response", exe);
		}	
	}
	/**	
	 * AUTO_GENERATED
	 * @throws SSLConfigurationException
	 * @throws InvalidCredentialException
	 * @throws UnsupportedEncodingException
	 * @throws IOException
	 * @throws HttpErrorException
	 * @throws InvalidResponseDataException
	 * @throws ClientActionRequiredException
	 * @throws MissingCredentialException
	 * @throws InterruptedException
	 * @throws OAuthException
	 */
	 public SetMobileCheckoutResponseType setMobileCheckout(SetMobileCheckoutReq setMobileCheckoutReq, String apiUsername) throws SSLConfigurationException, InvalidCredentialException, IOException, HttpErrorException, InvalidResponseDataException, ClientActionRequiredException, MissingCredentialException, InterruptedException, OAuthException, ParserConfigurationException, SAXException, IOException {
	 	APICallPreHandler apiCallPreHandler = null;
	 	String portName = "PayPalAPI";
		setStandardParams(setMobileCheckoutReq.getSetMobileCheckoutRequest());
		DefaultSOAPAPICallHandler defaultHandler = new DefaultSOAPAPICallHandler(setMobileCheckoutReq.toXMLString(null, "SetMobileCheckoutReq"), null, null);
		apiCallPreHandler = new MerchantAPICallPreHandler(defaultHandler, apiUsername, getAccessToken(), getTokenSecret());
		((MerchantAPICallPreHandler) apiCallPreHandler).setSdkName(SDK_NAME);
		((MerchantAPICallPreHandler) apiCallPreHandler).setSdkVersion(SDK_VERSION);
		((MerchantAPICallPreHandler) apiCallPreHandler).setPortName(portName);
	 	String response = call(apiCallPreHandler);
		DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = builderFactory.newDocumentBuilder();
		InputSource inStream = new InputSource();
		inStream.setCharacterStream(new StringReader((String) response));
		Document document = builder.parse(inStream);
		XPathFactory factory = XPathFactory.newInstance();
		XPath xpath = factory.newXPath();
		try {
			Node node = (Node) xpath.evaluate("Envelope/Body/SetMobileCheckoutResponse", document, XPathConstants.NODE);
			return new SetMobileCheckoutResponseType(node);
		} catch (XPathExpressionException exe) {
			throw new RuntimeException("Unable to parse response", exe);
		}
	 }
	 
	/** 
	 * AUTO_GENERATED
	 * @throws SSLConfigurationException
	 * @throws InvalidCredentialException
	 * @throws UnsupportedEncodingException
	 * @throws IOException
	 * @throws HttpErrorException
	 * @throws InvalidResponseDataException
	 * @throws ClientActionRequiredException
	 * @throws MissingCredentialException
	 * @throws InterruptedException
	 * @throws OAuthException
	 */
	 public SetMobileCheckoutResponseType setMobileCheckout(SetMobileCheckoutReq setMobileCheckoutReq) throws SSLConfigurationException, InvalidCredentialException, IOException, HttpErrorException, InvalidResponseDataException, ClientActionRequiredException, MissingCredentialException, InterruptedException, OAuthException, ParserConfigurationException, SAXException  {
	 	return setMobileCheckout(setMobileCheckoutReq, (String) null);
	 }

	/** 
	 * AUTO_GENERATED
	 * @throws SSLConfigurationException
	 * @throws InvalidCredentialException
	 * @throws UnsupportedEncodingException
	 * @throws IOException
	 * @throws HttpErrorException
	 * @throws InvalidResponseDataException
	 * @throws ClientActionRequiredException
	 * @throws MissingCredentialException
	 * @throws InterruptedException
	 * @throws OAuthException
	 */
	 public SetMobileCheckoutResponseType setMobileCheckout(SetMobileCheckoutReq setMobileCheckoutReq, ICredential credential) throws SSLConfigurationException, InvalidCredentialException, IOException, HttpErrorException, InvalidResponseDataException, ClientActionRequiredException, MissingCredentialException, InterruptedException, OAuthException, ParserConfigurationException, SAXException  {
	 	APICallPreHandler apiCallPreHandler = null;
	 	String portName = "PayPalAPI";
		setStandardParams(setMobileCheckoutReq.getSetMobileCheckoutRequest());
		DefaultSOAPAPICallHandler defaultHandler = new DefaultSOAPAPICallHandler(setMobileCheckoutReq.toXMLString(null, "SetMobileCheckoutReq"), null, null);
		apiCallPreHandler = new MerchantAPICallPreHandler(defaultHandler, credential);
		((MerchantAPICallPreHandler) apiCallPreHandler).setSdkName(SDK_NAME);
		((MerchantAPICallPreHandler) apiCallPreHandler).setSdkVersion(SDK_VERSION);
		((MerchantAPICallPreHandler) apiCallPreHandler).setPortName(portName);
	 	String response = call(apiCallPreHandler);
 	
		DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = builderFactory.newDocumentBuilder();
		InputSource inStream = new InputSource();
		inStream.setCharacterStream(new StringReader((String) response));
		Document document = builder.parse(inStream);
		XPathFactory factory = XPathFactory.newInstance();
		XPath xpath = factory.newXPath();
		try {
			Node node = (Node) xpath.evaluate(
					"Envelope/Body/SetMobileCheckoutResponse", document,
					XPathConstants.NODE);
			return new SetMobileCheckoutResponseType(node);
		} catch (XPathExpressionException exe) {
			throw new RuntimeException("Unable to parse response", exe);
		}	
	}
	/**	
	 * AUTO_GENERATED
	 * @throws SSLConfigurationException
	 * @throws InvalidCredentialException
	 * @throws UnsupportedEncodingException
	 * @throws IOException
	 * @throws HttpErrorException
	 * @throws InvalidResponseDataException
	 * @throws ClientActionRequiredException
	 * @throws MissingCredentialException
	 * @throws InterruptedException
	 * @throws OAuthException
	 */
	 public DoMobileCheckoutPaymentResponseType doMobileCheckoutPayment(DoMobileCheckoutPaymentReq doMobileCheckoutPaymentReq, String apiUsername) throws SSLConfigurationException, InvalidCredentialException, IOException, HttpErrorException, InvalidResponseDataException, ClientActionRequiredException, MissingCredentialException, InterruptedException, OAuthException, ParserConfigurationException, SAXException, IOException {
	 	APICallPreHandler apiCallPreHandler = null;
	 	String portName = "PayPalAPI";
		setStandardParams(doMobileCheckoutPaymentReq.getDoMobileCheckoutPaymentRequest());
		DefaultSOAPAPICallHandler defaultHandler = new DefaultSOAPAPICallHandler(doMobileCheckoutPaymentReq.toXMLString(null, "DoMobileCheckoutPaymentReq"), null, null);
		apiCallPreHandler = new MerchantAPICallPreHandler(defaultHandler, apiUsername, getAccessToken(), getTokenSecret());
		((MerchantAPICallPreHandler) apiCallPreHandler).setSdkName(SDK_NAME);
		((MerchantAPICallPreHandler) apiCallPreHandler).setSdkVersion(SDK_VERSION);
		((MerchantAPICallPreHandler) apiCallPreHandler).setPortName(portName);
	 	String response = call(apiCallPreHandler);
		DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = builderFactory.newDocumentBuilder();
		InputSource inStream = new InputSource();
		inStream.setCharacterStream(new StringReader((String) response));
		Document document = builder.parse(inStream);
		XPathFactory factory = XPathFactory.newInstance();
		XPath xpath = factory.newXPath();
		try {
			Node node = (Node) xpath.evaluate("Envelope/Body/DoMobileCheckoutPaymentResponse", document, XPathConstants.NODE);
			return new DoMobileCheckoutPaymentResponseType(node);
		} catch (XPathExpressionException exe) {
			throw new RuntimeException("Unable to parse response", exe);
		}
	 }
	 
	/** 
	 * AUTO_GENERATED
	 * @throws SSLConfigurationException
	 * @throws InvalidCredentialException
	 * @throws UnsupportedEncodingException
	 * @throws IOException
	 * @throws HttpErrorException
	 * @throws InvalidResponseDataException
	 * @throws ClientActionRequiredException
	 * @throws MissingCredentialException
	 * @throws InterruptedException
	 * @throws OAuthException
	 */
	 public DoMobileCheckoutPaymentResponseType doMobileCheckoutPayment(DoMobileCheckoutPaymentReq doMobileCheckoutPaymentReq) throws SSLConfigurationException, InvalidCredentialException, IOException, HttpErrorException, InvalidResponseDataException, ClientActionRequiredException, MissingCredentialException, InterruptedException, OAuthException, ParserConfigurationException, SAXException  {
	 	return doMobileCheckoutPayment(doMobileCheckoutPaymentReq, (String) null);
	 }

	/** 
	 * AUTO_GENERATED
	 * @throws SSLConfigurationException
	 * @throws InvalidCredentialException
	 * @throws UnsupportedEncodingException
	 * @throws IOException
	 * @throws HttpErrorException
	 * @throws InvalidResponseDataException
	 * @throws ClientActionRequiredException
	 * @throws MissingCredentialException
	 * @throws InterruptedException
	 * @throws OAuthException
	 */
	 public DoMobileCheckoutPaymentResponseType doMobileCheckoutPayment(DoMobileCheckoutPaymentReq doMobileCheckoutPaymentReq, ICredential credential) throws SSLConfigurationException, InvalidCredentialException, IOException, HttpErrorException, InvalidResponseDataException, ClientActionRequiredException, MissingCredentialException, InterruptedException, OAuthException, ParserConfigurationException, SAXException  {
	 	APICallPreHandler apiCallPreHandler = null;
	 	String portName = "PayPalAPI";
		setStandardParams(doMobileCheckoutPaymentReq.getDoMobileCheckoutPaymentRequest());
		DefaultSOAPAPICallHandler defaultHandler = new DefaultSOAPAPICallHandler(doMobileCheckoutPaymentReq.toXMLString(null, "DoMobileCheckoutPaymentReq"), null, null);
		apiCallPreHandler = new MerchantAPICallPreHandler(defaultHandler, credential);
		((MerchantAPICallPreHandler) apiCallPreHandler).setSdkName(SDK_NAME);
		((MerchantAPICallPreHandler) apiCallPreHandler).setSdkVersion(SDK_VERSION);
		((MerchantAPICallPreHandler) apiCallPreHandler).setPortName(portName);
	 	String response = call(apiCallPreHandler);
 	
		DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = builderFactory.newDocumentBuilder();
		InputSource inStream = new InputSource();
		inStream.setCharacterStream(new StringReader((String) response));
		Document document = builder.parse(inStream);
		XPathFactory factory = XPathFactory.newInstance();
		XPath xpath = factory.newXPath();
		try {
			Node node = (Node) xpath.evaluate(
					"Envelope/Body/DoMobileCheckoutPaymentResponse", document,
					XPathConstants.NODE);
			return new DoMobileCheckoutPaymentResponseType(node);
		} catch (XPathExpressionException exe) {
			throw new RuntimeException("Unable to parse response", exe);
		}	
	}
	/**	
	 * AUTO_GENERATED
	 * @throws SSLConfigurationException
	 * @throws InvalidCredentialException
	 * @throws UnsupportedEncodingException
	 * @throws IOException
	 * @throws HttpErrorException
	 * @throws InvalidResponseDataException
	 * @throws ClientActionRequiredException
	 * @throws MissingCredentialException
	 * @throws InterruptedException
	 * @throws OAuthException
	 */
	 public GetBalanceResponseType getBalance(GetBalanceReq getBalanceReq, String apiUsername) throws SSLConfigurationException, InvalidCredentialException, IOException, HttpErrorException, InvalidResponseDataException, ClientActionRequiredException, MissingCredentialException, InterruptedException, OAuthException, ParserConfigurationException, SAXException, IOException {
	 	APICallPreHandler apiCallPreHandler = null;
	 	String portName = "PayPalAPI";
		setStandardParams(getBalanceReq.getGetBalanceRequest());
		DefaultSOAPAPICallHandler defaultHandler = new DefaultSOAPAPICallHandler(getBalanceReq.toXMLString(null, "GetBalanceReq"), null, null);
		apiCallPreHandler = new MerchantAPICallPreHandler(defaultHandler, apiUsername, getAccessToken(), getTokenSecret());
		((MerchantAPICallPreHandler) apiCallPreHandler).setSdkName(SDK_NAME);
		((MerchantAPICallPreHandler) apiCallPreHandler).setSdkVersion(SDK_VERSION);
		((MerchantAPICallPreHandler) apiCallPreHandler).setPortName(portName);
	 	String response = call(apiCallPreHandler);
		DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = builderFactory.newDocumentBuilder();
		InputSource inStream = new InputSource();
		inStream.setCharacterStream(new StringReader((String) response));
		Document document = builder.parse(inStream);
		XPathFactory factory = XPathFactory.newInstance();
		XPath xpath = factory.newXPath();
		try {
			Node node = (Node) xpath.evaluate("Envelope/Body/GetBalanceResponse", document, XPathConstants.NODE);
			return new GetBalanceResponseType(node);
		} catch (XPathExpressionException exe) {
			throw new RuntimeException("Unable to parse response", exe);
		}
	 }
	 
	/** 
	 * AUTO_GENERATED
	 * @throws SSLConfigurationException
	 * @throws InvalidCredentialException
	 * @throws UnsupportedEncodingException
	 * @throws IOException
	 * @throws HttpErrorException
	 * @throws InvalidResponseDataException
	 * @throws ClientActionRequiredException
	 * @throws MissingCredentialException
	 * @throws InterruptedException
	 * @throws OAuthException
	 */
	 public GetBalanceResponseType getBalance(GetBalanceReq getBalanceReq) throws SSLConfigurationException, InvalidCredentialException, IOException, HttpErrorException, InvalidResponseDataException, ClientActionRequiredException, MissingCredentialException, InterruptedException, OAuthException, ParserConfigurationException, SAXException  {
	 	return getBalance(getBalanceReq, (String) null);
	 }

	/** 
	 * AUTO_GENERATED
	 * @throws SSLConfigurationException
	 * @throws InvalidCredentialException
	 * @throws UnsupportedEncodingException
	 * @throws IOException
	 * @throws HttpErrorException
	 * @throws InvalidResponseDataException
	 * @throws ClientActionRequiredException
	 * @throws MissingCredentialException
	 * @throws InterruptedException
	 * @throws OAuthException
	 */
	 public GetBalanceResponseType getBalance(GetBalanceReq getBalanceReq, ICredential credential) throws SSLConfigurationException, InvalidCredentialException, IOException, HttpErrorException, InvalidResponseDataException, ClientActionRequiredException, MissingCredentialException, InterruptedException, OAuthException, ParserConfigurationException, SAXException  {
	 	APICallPreHandler apiCallPreHandler = null;
	 	String portName = "PayPalAPI";
		setStandardParams(getBalanceReq.getGetBalanceRequest());
		DefaultSOAPAPICallHandler defaultHandler = new DefaultSOAPAPICallHandler(getBalanceReq.toXMLString(null, "GetBalanceReq"), null, null);
		apiCallPreHandler = new MerchantAPICallPreHandler(defaultHandler, credential);
		((MerchantAPICallPreHandler) apiCallPreHandler).setSdkName(SDK_NAME);
		((MerchantAPICallPreHandler) apiCallPreHandler).setSdkVersion(SDK_VERSION);
		((MerchantAPICallPreHandler) apiCallPreHandler).setPortName(portName);
	 	String response = call(apiCallPreHandler);
 	
		DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = builderFactory.newDocumentBuilder();
		InputSource inStream = new InputSource();
		inStream.setCharacterStream(new StringReader((String) response));
		Document document = builder.parse(inStream);
		XPathFactory factory = XPathFactory.newInstance();
		XPath xpath = factory.newXPath();
		try {
			Node node = (Node) xpath.evaluate(
					"Envelope/Body/GetBalanceResponse", document,
					XPathConstants.NODE);
			return new GetBalanceResponseType(node);
		} catch (XPathExpressionException exe) {
			throw new RuntimeException("Unable to parse response", exe);
		}	
	}
	/**	
	 * AUTO_GENERATED
	 * @throws SSLConfigurationException
	 * @throws InvalidCredentialException
	 * @throws UnsupportedEncodingException
	 * @throws IOException
	 * @throws HttpErrorException
	 * @throws InvalidResponseDataException
	 * @throws ClientActionRequiredException
	 * @throws MissingCredentialException
	 * @throws InterruptedException
	 * @throws OAuthException
	 */
	 public GetPalDetailsResponseType getPalDetails(GetPalDetailsReq getPalDetailsReq, String apiUsername) throws SSLConfigurationException, InvalidCredentialException, IOException, HttpErrorException, InvalidResponseDataException, ClientActionRequiredException, MissingCredentialException, InterruptedException, OAuthException, ParserConfigurationException, SAXException, IOException {
	 	APICallPreHandler apiCallPreHandler = null;
	 	String portName = "PayPalAPI";
		setStandardParams(getPalDetailsReq.getGetPalDetailsRequest());
		DefaultSOAPAPICallHandler defaultHandler = new DefaultSOAPAPICallHandler(getPalDetailsReq.toXMLString(null, "GetPalDetailsReq"), null, null);
		apiCallPreHandler = new MerchantAPICallPreHandler(defaultHandler, apiUsername, getAccessToken(), getTokenSecret());
		((MerchantAPICallPreHandler) apiCallPreHandler).setSdkName(SDK_NAME);
		((MerchantAPICallPreHandler) apiCallPreHandler).setSdkVersion(SDK_VERSION);
		((MerchantAPICallPreHandler) apiCallPreHandler).setPortName(portName);
	 	String response = call(apiCallPreHandler);
		DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = builderFactory.newDocumentBuilder();
		InputSource inStream = new InputSource();
		inStream.setCharacterStream(new StringReader((String) response));
		Document document = builder.parse(inStream);
		XPathFactory factory = XPathFactory.newInstance();
		XPath xpath = factory.newXPath();
		try {
			Node node = (Node) xpath.evaluate("Envelope/Body/GetPalDetailsResponse", document, XPathConstants.NODE);
			return new GetPalDetailsResponseType(node);
		} catch (XPathExpressionException exe) {
			throw new RuntimeException("Unable to parse response", exe);
		}
	 }
	 
	/** 
	 * AUTO_GENERATED
	 * @throws SSLConfigurationException
	 * @throws InvalidCredentialException
	 * @throws UnsupportedEncodingException
	 * @throws IOException
	 * @throws HttpErrorException
	 * @throws InvalidResponseDataException
	 * @throws ClientActionRequiredException
	 * @throws MissingCredentialException
	 * @throws InterruptedException
	 * @throws OAuthException
	 */
	 public GetPalDetailsResponseType getPalDetails(GetPalDetailsReq getPalDetailsReq) throws SSLConfigurationException, InvalidCredentialException, IOException, HttpErrorException, InvalidResponseDataException, ClientActionRequiredException, MissingCredentialException, InterruptedException, OAuthException, ParserConfigurationException, SAXException  {
	 	return getPalDetails(getPalDetailsReq, (String) null);
	 }

	/** 
	 * AUTO_GENERATED
	 * @throws SSLConfigurationException
	 * @throws InvalidCredentialException
	 * @throws UnsupportedEncodingException
	 * @throws IOException
	 * @throws HttpErrorException
	 * @throws InvalidResponseDataException
	 * @throws ClientActionRequiredException
	 * @throws MissingCredentialException
	 * @throws InterruptedException
	 * @throws OAuthException
	 */
	 public GetPalDetailsResponseType getPalDetails(GetPalDetailsReq getPalDetailsReq, ICredential credential) throws SSLConfigurationException, InvalidCredentialException, IOException, HttpErrorException, InvalidResponseDataException, ClientActionRequiredException, MissingCredentialException, InterruptedException, OAuthException, ParserConfigurationException, SAXException  {
	 	APICallPreHandler apiCallPreHandler = null;
	 	String portName = "PayPalAPI";
		setStandardParams(getPalDetailsReq.getGetPalDetailsRequest());
		DefaultSOAPAPICallHandler defaultHandler = new DefaultSOAPAPICallHandler(getPalDetailsReq.toXMLString(null, "GetPalDetailsReq"), null, null);
		apiCallPreHandler = new MerchantAPICallPreHandler(defaultHandler, credential);
		((MerchantAPICallPreHandler) apiCallPreHandler).setSdkName(SDK_NAME);
		((MerchantAPICallPreHandler) apiCallPreHandler).setSdkVersion(SDK_VERSION);
		((MerchantAPICallPreHandler) apiCallPreHandler).setPortName(portName);
	 	String response = call(apiCallPreHandler);
 	
		DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = builderFactory.newDocumentBuilder();
		InputSource inStream = new InputSource();
		inStream.setCharacterStream(new StringReader((String) response));
		Document document = builder.parse(inStream);
		XPathFactory factory = XPathFactory.newInstance();
		XPath xpath = factory.newXPath();
		try {
			Node node = (Node) xpath.evaluate(
					"Envelope/Body/GetPalDetailsResponse", document,
					XPathConstants.NODE);
			return new GetPalDetailsResponseType(node);
		} catch (XPathExpressionException exe) {
			throw new RuntimeException("Unable to parse response", exe);
		}	
	}
	/**	
	 * AUTO_GENERATED
	 * @throws SSLConfigurationException
	 * @throws InvalidCredentialException
	 * @throws UnsupportedEncodingException
	 * @throws IOException
	 * @throws HttpErrorException
	 * @throws InvalidResponseDataException
	 * @throws ClientActionRequiredException
	 * @throws MissingCredentialException
	 * @throws InterruptedException
	 * @throws OAuthException
	 */
	 public DoExpressCheckoutPaymentResponseType doExpressCheckoutPayment(DoExpressCheckoutPaymentReq doExpressCheckoutPaymentReq, String apiUsername) throws SSLConfigurationException, InvalidCredentialException, IOException, HttpErrorException, InvalidResponseDataException, ClientActionRequiredException, MissingCredentialException, InterruptedException, OAuthException, ParserConfigurationException, SAXException, IOException {
	 	APICallPreHandler apiCallPreHandler = null;
	 	String portName = "PayPalAPIAA";
		setStandardParams(doExpressCheckoutPaymentReq.getDoExpressCheckoutPaymentRequest());
		DefaultSOAPAPICallHandler defaultHandler = new DefaultSOAPAPICallHandler(doExpressCheckoutPaymentReq.toXMLString(null, "DoExpressCheckoutPaymentReq"), null, null);
		apiCallPreHandler = new MerchantAPICallPreHandler(defaultHandler, apiUsername, getAccessToken(), getTokenSecret());
		((MerchantAPICallPreHandler) apiCallPreHandler).setSdkName(SDK_NAME);
		((MerchantAPICallPreHandler) apiCallPreHandler).setSdkVersion(SDK_VERSION);
		((MerchantAPICallPreHandler) apiCallPreHandler).setPortName(portName);
	 	String response = call(apiCallPreHandler);
		DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = builderFactory.newDocumentBuilder();
		InputSource inStream = new InputSource();
		inStream.setCharacterStream(new StringReader((String) response));
		Document document = builder.parse(inStream);
		XPathFactory factory = XPathFactory.newInstance();
		XPath xpath = factory.newXPath();
		try {
			Node node = (Node) xpath.evaluate("Envelope/Body/DoExpressCheckoutPaymentResponse", document, XPathConstants.NODE);
			return new DoExpressCheckoutPaymentResponseType(node);
		} catch (XPathExpressionException exe) {
			throw new RuntimeException("Unable to parse response", exe);
		}
	 }
	 
	/** 
	 * AUTO_GENERATED
	 * @throws SSLConfigurationException
	 * @throws InvalidCredentialException
	 * @throws UnsupportedEncodingException
	 * @throws IOException
	 * @throws HttpErrorException
	 * @throws InvalidResponseDataException
	 * @throws ClientActionRequiredException
	 * @throws MissingCredentialException
	 * @throws InterruptedException
	 * @throws OAuthException
	 */
	 public DoExpressCheckoutPaymentResponseType doExpressCheckoutPayment(DoExpressCheckoutPaymentReq doExpressCheckoutPaymentReq) throws SSLConfigurationException, InvalidCredentialException, IOException, HttpErrorException, InvalidResponseDataException, ClientActionRequiredException, MissingCredentialException, InterruptedException, OAuthException, ParserConfigurationException, SAXException  {
	 	return doExpressCheckoutPayment(doExpressCheckoutPaymentReq, (String) null);
	 }

	/** 
	 * AUTO_GENERATED
	 * @throws SSLConfigurationException
	 * @throws InvalidCredentialException
	 * @throws UnsupportedEncodingException
	 * @throws IOException
	 * @throws HttpErrorException
	 * @throws InvalidResponseDataException
	 * @throws ClientActionRequiredException
	 * @throws MissingCredentialException
	 * @throws InterruptedException
	 * @throws OAuthException
	 */
	 public DoExpressCheckoutPaymentResponseType doExpressCheckoutPayment(DoExpressCheckoutPaymentReq doExpressCheckoutPaymentReq, ICredential credential) throws SSLConfigurationException, InvalidCredentialException, IOException, HttpErrorException, InvalidResponseDataException, ClientActionRequiredException, MissingCredentialException, InterruptedException, OAuthException, ParserConfigurationException, SAXException  {
	 	APICallPreHandler apiCallPreHandler = null;
	 	String portName = "PayPalAPIAA";
		setStandardParams(doExpressCheckoutPaymentReq.getDoExpressCheckoutPaymentRequest());
		DefaultSOAPAPICallHandler defaultHandler = new DefaultSOAPAPICallHandler(doExpressCheckoutPaymentReq.toXMLString(null, "DoExpressCheckoutPaymentReq"), null, null);
		apiCallPreHandler = new MerchantAPICallPreHandler(defaultHandler, credential);
		((MerchantAPICallPreHandler) apiCallPreHandler).setSdkName(SDK_NAME);
		((MerchantAPICallPreHandler) apiCallPreHandler).setSdkVersion(SDK_VERSION);
		((MerchantAPICallPreHandler) apiCallPreHandler).setPortName(portName);
	 	String response = call(apiCallPreHandler);
 	
		DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = builderFactory.newDocumentBuilder();
		InputSource inStream = new InputSource();
		inStream.setCharacterStream(new StringReader((String) response));
		Document document = builder.parse(inStream);
		XPathFactory factory = XPathFactory.newInstance();
		XPath xpath = factory.newXPath();
		try {
			Node node = (Node) xpath.evaluate(
					"Envelope/Body/DoExpressCheckoutPaymentResponse", document,
					XPathConstants.NODE);
			return new DoExpressCheckoutPaymentResponseType(node);
		} catch (XPathExpressionException exe) {
			throw new RuntimeException("Unable to parse response", exe);
		}	
	}
	/**	
	 * AUTO_GENERATED
	 * @throws SSLConfigurationException
	 * @throws InvalidCredentialException
	 * @throws UnsupportedEncodingException
	 * @throws IOException
	 * @throws HttpErrorException
	 * @throws InvalidResponseDataException
	 * @throws ClientActionRequiredException
	 * @throws MissingCredentialException
	 * @throws InterruptedException
	 * @throws OAuthException
	 */
	 public DoUATPExpressCheckoutPaymentResponseType doUATPExpressCheckoutPayment(DoUATPExpressCheckoutPaymentReq doUATPExpressCheckoutPaymentReq, String apiUsername) throws SSLConfigurationException, InvalidCredentialException, IOException, HttpErrorException, InvalidResponseDataException, ClientActionRequiredException, MissingCredentialException, InterruptedException, OAuthException, ParserConfigurationException, SAXException, IOException {
	 	APICallPreHandler apiCallPreHandler = null;
	 	String portName = "PayPalAPIAA";
		setStandardParams(doUATPExpressCheckoutPaymentReq.getDoUATPExpressCheckoutPaymentRequest());
		DefaultSOAPAPICallHandler defaultHandler = new DefaultSOAPAPICallHandler(doUATPExpressCheckoutPaymentReq.toXMLString(null, "DoUATPExpressCheckoutPaymentReq"), null, null);
		apiCallPreHandler = new MerchantAPICallPreHandler(defaultHandler, apiUsername, getAccessToken(), getTokenSecret());
		((MerchantAPICallPreHandler) apiCallPreHandler).setSdkName(SDK_NAME);
		((MerchantAPICallPreHandler) apiCallPreHandler).setSdkVersion(SDK_VERSION);
		((MerchantAPICallPreHandler) apiCallPreHandler).setPortName(portName);
	 	String response = call(apiCallPreHandler);
		DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = builderFactory.newDocumentBuilder();
		InputSource inStream = new InputSource();
		inStream.setCharacterStream(new StringReader((String) response));
		Document document = builder.parse(inStream);
		XPathFactory factory = XPathFactory.newInstance();
		XPath xpath = factory.newXPath();
		try {
			Node node = (Node) xpath.evaluate("Envelope/Body/DoUATPExpressCheckoutPaymentResponse", document, XPathConstants.NODE);
			return new DoUATPExpressCheckoutPaymentResponseType(node);
		} catch (XPathExpressionException exe) {
			throw new RuntimeException("Unable to parse response", exe);
		}
	 }
	 
	/** 
	 * AUTO_GENERATED
	 * @throws SSLConfigurationException
	 * @throws InvalidCredentialException
	 * @throws UnsupportedEncodingException
	 * @throws IOException
	 * @throws HttpErrorException
	 * @throws InvalidResponseDataException
	 * @throws ClientActionRequiredException
	 * @throws MissingCredentialException
	 * @throws InterruptedException
	 * @throws OAuthException
	 */
	 public DoUATPExpressCheckoutPaymentResponseType doUATPExpressCheckoutPayment(DoUATPExpressCheckoutPaymentReq doUATPExpressCheckoutPaymentReq) throws SSLConfigurationException, InvalidCredentialException, IOException, HttpErrorException, InvalidResponseDataException, ClientActionRequiredException, MissingCredentialException, InterruptedException, OAuthException, ParserConfigurationException, SAXException  {
	 	return doUATPExpressCheckoutPayment(doUATPExpressCheckoutPaymentReq, (String) null);
	 }

	/** 
	 * AUTO_GENERATED
	 * @throws SSLConfigurationException
	 * @throws InvalidCredentialException
	 * @throws UnsupportedEncodingException
	 * @throws IOException
	 * @throws HttpErrorException
	 * @throws InvalidResponseDataException
	 * @throws ClientActionRequiredException
	 * @throws MissingCredentialException
	 * @throws InterruptedException
	 * @throws OAuthException
	 */
	 public DoUATPExpressCheckoutPaymentResponseType doUATPExpressCheckoutPayment(DoUATPExpressCheckoutPaymentReq doUATPExpressCheckoutPaymentReq, ICredential credential) throws SSLConfigurationException, InvalidCredentialException, IOException, HttpErrorException, InvalidResponseDataException, ClientActionRequiredException, MissingCredentialException, InterruptedException, OAuthException, ParserConfigurationException, SAXException  {
	 	APICallPreHandler apiCallPreHandler = null;
	 	String portName = "PayPalAPIAA";
		setStandardParams(doUATPExpressCheckoutPaymentReq.getDoUATPExpressCheckoutPaymentRequest());
		DefaultSOAPAPICallHandler defaultHandler = new DefaultSOAPAPICallHandler(doUATPExpressCheckoutPaymentReq.toXMLString(null, "DoUATPExpressCheckoutPaymentReq"), null, null);
		apiCallPreHandler = new MerchantAPICallPreHandler(defaultHandler, credential);
		((MerchantAPICallPreHandler) apiCallPreHandler).setSdkName(SDK_NAME);
		((MerchantAPICallPreHandler) apiCallPreHandler).setSdkVersion(SDK_VERSION);
		((MerchantAPICallPreHandler) apiCallPreHandler).setPortName(portName);
	 	String response = call(apiCallPreHandler);
 	
		DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = builderFactory.newDocumentBuilder();
		InputSource inStream = new InputSource();
		inStream.setCharacterStream(new StringReader((String) response));
		Document document = builder.parse(inStream);
		XPathFactory factory = XPathFactory.newInstance();
		XPath xpath = factory.newXPath();
		try {
			Node node = (Node) xpath.evaluate(
					"Envelope/Body/DoUATPExpressCheckoutPaymentResponse", document,
					XPathConstants.NODE);
			return new DoUATPExpressCheckoutPaymentResponseType(node);
		} catch (XPathExpressionException exe) {
			throw new RuntimeException("Unable to parse response", exe);
		}	
	}
	/**	
	 * AUTO_GENERATED
	 * @throws SSLConfigurationException
	 * @throws InvalidCredentialException
	 * @throws UnsupportedEncodingException
	 * @throws IOException
	 * @throws HttpErrorException
	 * @throws InvalidResponseDataException
	 * @throws ClientActionRequiredException
	 * @throws MissingCredentialException
	 * @throws InterruptedException
	 * @throws OAuthException
	 */
	 public SetAuthFlowParamResponseType setAuthFlowParam(SetAuthFlowParamReq setAuthFlowParamReq, String apiUsername) throws SSLConfigurationException, InvalidCredentialException, IOException, HttpErrorException, InvalidResponseDataException, ClientActionRequiredException, MissingCredentialException, InterruptedException, OAuthException, ParserConfigurationException, SAXException, IOException {
	 	APICallPreHandler apiCallPreHandler = null;
	 	String portName = "PayPalAPIAA";
		setStandardParams(setAuthFlowParamReq.getSetAuthFlowParamRequest());
		DefaultSOAPAPICallHandler defaultHandler = new DefaultSOAPAPICallHandler(setAuthFlowParamReq.toXMLString(null, "SetAuthFlowParamReq"), null, null);
		apiCallPreHandler = new MerchantAPICallPreHandler(defaultHandler, apiUsername, getAccessToken(), getTokenSecret());
		((MerchantAPICallPreHandler) apiCallPreHandler).setSdkName(SDK_NAME);
		((MerchantAPICallPreHandler) apiCallPreHandler).setSdkVersion(SDK_VERSION);
		((MerchantAPICallPreHandler) apiCallPreHandler).setPortName(portName);
	 	String response = call(apiCallPreHandler);
		DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = builderFactory.newDocumentBuilder();
		InputSource inStream = new InputSource();
		inStream.setCharacterStream(new StringReader((String) response));
		Document document = builder.parse(inStream);
		XPathFactory factory = XPathFactory.newInstance();
		XPath xpath = factory.newXPath();
		try {
			Node node = (Node) xpath.evaluate("Envelope/Body/SetAuthFlowParamResponse", document, XPathConstants.NODE);
			return new SetAuthFlowParamResponseType(node);
		} catch (XPathExpressionException exe) {
			throw new RuntimeException("Unable to parse response", exe);
		}
	 }
	 
	/** 
	 * AUTO_GENERATED
	 * @throws SSLConfigurationException
	 * @throws InvalidCredentialException
	 * @throws UnsupportedEncodingException
	 * @throws IOException
	 * @throws HttpErrorException
	 * @throws InvalidResponseDataException
	 * @throws ClientActionRequiredException
	 * @throws MissingCredentialException
	 * @throws InterruptedException
	 * @throws OAuthException
	 */
	 public SetAuthFlowParamResponseType setAuthFlowParam(SetAuthFlowParamReq setAuthFlowParamReq) throws SSLConfigurationException, InvalidCredentialException, IOException, HttpErrorException, InvalidResponseDataException, ClientActionRequiredException, MissingCredentialException, InterruptedException, OAuthException, ParserConfigurationException, SAXException  {
	 	return setAuthFlowParam(setAuthFlowParamReq, (String) null);
	 }

	/** 
	 * AUTO_GENERATED
	 * @throws SSLConfigurationException
	 * @throws InvalidCredentialException
	 * @throws UnsupportedEncodingException
	 * @throws IOException
	 * @throws HttpErrorException
	 * @throws InvalidResponseDataException
	 * @throws ClientActionRequiredException
	 * @throws MissingCredentialException
	 * @throws InterruptedException
	 * @throws OAuthException
	 */
	 public SetAuthFlowParamResponseType setAuthFlowParam(SetAuthFlowParamReq setAuthFlowParamReq, ICredential credential) throws SSLConfigurationException, InvalidCredentialException, IOException, HttpErrorException, InvalidResponseDataException, ClientActionRequiredException, MissingCredentialException, InterruptedException, OAuthException, ParserConfigurationException, SAXException  {
	 	APICallPreHandler apiCallPreHandler = null;
	 	String portName = "PayPalAPIAA";
		setStandardParams(setAuthFlowParamReq.getSetAuthFlowParamRequest());
		DefaultSOAPAPICallHandler defaultHandler = new DefaultSOAPAPICallHandler(setAuthFlowParamReq.toXMLString(null, "SetAuthFlowParamReq"), null, null);
		apiCallPreHandler = new MerchantAPICallPreHandler(defaultHandler, credential);
		((MerchantAPICallPreHandler) apiCallPreHandler).setSdkName(SDK_NAME);
		((MerchantAPICallPreHandler) apiCallPreHandler).setSdkVersion(SDK_VERSION);
		((MerchantAPICallPreHandler) apiCallPreHandler).setPortName(portName);
	 	String response = call(apiCallPreHandler);
 	
		DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = builderFactory.newDocumentBuilder();
		InputSource inStream = new InputSource();
		inStream.setCharacterStream(new StringReader((String) response));
		Document document = builder.parse(inStream);
		XPathFactory factory = XPathFactory.newInstance();
		XPath xpath = factory.newXPath();
		try {
			Node node = (Node) xpath.evaluate(
					"Envelope/Body/SetAuthFlowParamResponse", document,
					XPathConstants.NODE);
			return new SetAuthFlowParamResponseType(node);
		} catch (XPathExpressionException exe) {
			throw new RuntimeException("Unable to parse response", exe);
		}	
	}
	/**	
	 * AUTO_GENERATED
	 * @throws SSLConfigurationException
	 * @throws InvalidCredentialException
	 * @throws UnsupportedEncodingException
	 * @throws IOException
	 * @throws HttpErrorException
	 * @throws InvalidResponseDataException
	 * @throws ClientActionRequiredException
	 * @throws MissingCredentialException
	 * @throws InterruptedException
	 * @throws OAuthException
	 */
	 public GetAuthDetailsResponseType getAuthDetails(GetAuthDetailsReq getAuthDetailsReq, String apiUsername) throws SSLConfigurationException, InvalidCredentialException, IOException, HttpErrorException, InvalidResponseDataException, ClientActionRequiredException, MissingCredentialException, InterruptedException, OAuthException, ParserConfigurationException, SAXException, IOException {
	 	APICallPreHandler apiCallPreHandler = null;
	 	String portName = "PayPalAPIAA";
		setStandardParams(getAuthDetailsReq.getGetAuthDetailsRequest());
		DefaultSOAPAPICallHandler defaultHandler = new DefaultSOAPAPICallHandler(getAuthDetailsReq.toXMLString(null, "GetAuthDetailsReq"), null, null);
		apiCallPreHandler = new MerchantAPICallPreHandler(defaultHandler, apiUsername, getAccessToken(), getTokenSecret());
		((MerchantAPICallPreHandler) apiCallPreHandler).setSdkName(SDK_NAME);
		((MerchantAPICallPreHandler) apiCallPreHandler).setSdkVersion(SDK_VERSION);
		((MerchantAPICallPreHandler) apiCallPreHandler).setPortName(portName);
	 	String response = call(apiCallPreHandler);
		DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = builderFactory.newDocumentBuilder();
		InputSource inStream = new InputSource();
		inStream.setCharacterStream(new StringReader((String) response));
		Document document = builder.parse(inStream);
		XPathFactory factory = XPathFactory.newInstance();
		XPath xpath = factory.newXPath();
		try {
			Node node = (Node) xpath.evaluate("Envelope/Body/GetAuthDetailsResponse", document, XPathConstants.NODE);
			return new GetAuthDetailsResponseType(node);
		} catch (XPathExpressionException exe) {
			throw new RuntimeException("Unable to parse response", exe);
		}
	 }
	 
	/** 
	 * AUTO_GENERATED
	 * @throws SSLConfigurationException
	 * @throws InvalidCredentialException
	 * @throws UnsupportedEncodingException
	 * @throws IOException
	 * @throws HttpErrorException
	 * @throws InvalidResponseDataException
	 * @throws ClientActionRequiredException
	 * @throws MissingCredentialException
	 * @throws InterruptedException
	 * @throws OAuthException
	 */
	 public GetAuthDetailsResponseType getAuthDetails(GetAuthDetailsReq getAuthDetailsReq) throws SSLConfigurationException, InvalidCredentialException, IOException, HttpErrorException, InvalidResponseDataException, ClientActionRequiredException, MissingCredentialException, InterruptedException, OAuthException, ParserConfigurationException, SAXException  {
	 	return getAuthDetails(getAuthDetailsReq, (String) null);
	 }

	/** 
	 * AUTO_GENERATED
	 * @throws SSLConfigurationException
	 * @throws InvalidCredentialException
	 * @throws UnsupportedEncodingException
	 * @throws IOException
	 * @throws HttpErrorException
	 * @throws InvalidResponseDataException
	 * @throws ClientActionRequiredException
	 * @throws MissingCredentialException
	 * @throws InterruptedException
	 * @throws OAuthException
	 */
	 public GetAuthDetailsResponseType getAuthDetails(GetAuthDetailsReq getAuthDetailsReq, ICredential credential) throws SSLConfigurationException, InvalidCredentialException, IOException, HttpErrorException, InvalidResponseDataException, ClientActionRequiredException, MissingCredentialException, InterruptedException, OAuthException, ParserConfigurationException, SAXException  {
	 	APICallPreHandler apiCallPreHandler = null;
	 	String portName = "PayPalAPIAA";
		setStandardParams(getAuthDetailsReq.getGetAuthDetailsRequest());
		DefaultSOAPAPICallHandler defaultHandler = new DefaultSOAPAPICallHandler(getAuthDetailsReq.toXMLString(null, "GetAuthDetailsReq"), null, null);
		apiCallPreHandler = new MerchantAPICallPreHandler(defaultHandler, credential);
		((MerchantAPICallPreHandler) apiCallPreHandler).setSdkName(SDK_NAME);
		((MerchantAPICallPreHandler) apiCallPreHandler).setSdkVersion(SDK_VERSION);
		((MerchantAPICallPreHandler) apiCallPreHandler).setPortName(portName);
	 	String response = call(apiCallPreHandler);
 	
		DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = builderFactory.newDocumentBuilder();
		InputSource inStream = new InputSource();
		inStream.setCharacterStream(new StringReader((String) response));
		Document document = builder.parse(inStream);
		XPathFactory factory = XPathFactory.newInstance();
		XPath xpath = factory.newXPath();
		try {
			Node node = (Node) xpath.evaluate(
					"Envelope/Body/GetAuthDetailsResponse", document,
					XPathConstants.NODE);
			return new GetAuthDetailsResponseType(node);
		} catch (XPathExpressionException exe) {
			throw new RuntimeException("Unable to parse response", exe);
		}	
	}
	/**	
	 * AUTO_GENERATED
	 * @throws SSLConfigurationException
	 * @throws InvalidCredentialException
	 * @throws UnsupportedEncodingException
	 * @throws IOException
	 * @throws HttpErrorException
	 * @throws InvalidResponseDataException
	 * @throws ClientActionRequiredException
	 * @throws MissingCredentialException
	 * @throws InterruptedException
	 * @throws OAuthException
	 */
	 public SetAccessPermissionsResponseType setAccessPermissions(SetAccessPermissionsReq setAccessPermissionsReq, String apiUsername) throws SSLConfigurationException, InvalidCredentialException, IOException, HttpErrorException, InvalidResponseDataException, ClientActionRequiredException, MissingCredentialException, InterruptedException, OAuthException, ParserConfigurationException, SAXException, IOException {
	 	APICallPreHandler apiCallPreHandler = null;
	 	String portName = "PayPalAPIAA";
		setStandardParams(setAccessPermissionsReq.getSetAccessPermissionsRequest());
		DefaultSOAPAPICallHandler defaultHandler = new DefaultSOAPAPICallHandler(setAccessPermissionsReq.toXMLString(null, "SetAccessPermissionsReq"), null, null);
		apiCallPreHandler = new MerchantAPICallPreHandler(defaultHandler, apiUsername, getAccessToken(), getTokenSecret());
		((MerchantAPICallPreHandler) apiCallPreHandler).setSdkName(SDK_NAME);
		((MerchantAPICallPreHandler) apiCallPreHandler).setSdkVersion(SDK_VERSION);
		((MerchantAPICallPreHandler) apiCallPreHandler).setPortName(portName);
	 	String response = call(apiCallPreHandler);
		DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = builderFactory.newDocumentBuilder();
		InputSource inStream = new InputSource();
		inStream.setCharacterStream(new StringReader((String) response));
		Document document = builder.parse(inStream);
		XPathFactory factory = XPathFactory.newInstance();
		XPath xpath = factory.newXPath();
		try {
			Node node = (Node) xpath.evaluate("Envelope/Body/SetAccessPermissionsResponse", document, XPathConstants.NODE);
			return new SetAccessPermissionsResponseType(node);
		} catch (XPathExpressionException exe) {
			throw new RuntimeException("Unable to parse response", exe);
		}
	 }
	 
	/** 
	 * AUTO_GENERATED
	 * @throws SSLConfigurationException
	 * @throws InvalidCredentialException
	 * @throws UnsupportedEncodingException
	 * @throws IOException
	 * @throws HttpErrorException
	 * @throws InvalidResponseDataException
	 * @throws ClientActionRequiredException
	 * @throws MissingCredentialException
	 * @throws InterruptedException
	 * @throws OAuthException
	 */
	 public SetAccessPermissionsResponseType setAccessPermissions(SetAccessPermissionsReq setAccessPermissionsReq) throws SSLConfigurationException, InvalidCredentialException, IOException, HttpErrorException, InvalidResponseDataException, ClientActionRequiredException, MissingCredentialException, InterruptedException, OAuthException, ParserConfigurationException, SAXException  {
	 	return setAccessPermissions(setAccessPermissionsReq, (String) null);
	 }

	/** 
	 * AUTO_GENERATED
	 * @throws SSLConfigurationException
	 * @throws InvalidCredentialException
	 * @throws UnsupportedEncodingException
	 * @throws IOException
	 * @throws HttpErrorException
	 * @throws InvalidResponseDataException
	 * @throws ClientActionRequiredException
	 * @throws MissingCredentialException
	 * @throws InterruptedException
	 * @throws OAuthException
	 */
	 public SetAccessPermissionsResponseType setAccessPermissions(SetAccessPermissionsReq setAccessPermissionsReq, ICredential credential) throws SSLConfigurationException, InvalidCredentialException, IOException, HttpErrorException, InvalidResponseDataException, ClientActionRequiredException, MissingCredentialException, InterruptedException, OAuthException, ParserConfigurationException, SAXException  {
	 	APICallPreHandler apiCallPreHandler = null;
	 	String portName = "PayPalAPIAA";
		setStandardParams(setAccessPermissionsReq.getSetAccessPermissionsRequest());
		DefaultSOAPAPICallHandler defaultHandler = new DefaultSOAPAPICallHandler(setAccessPermissionsReq.toXMLString(null, "SetAccessPermissionsReq"), null, null);
		apiCallPreHandler = new MerchantAPICallPreHandler(defaultHandler, credential);
		((MerchantAPICallPreHandler) apiCallPreHandler).setSdkName(SDK_NAME);
		((MerchantAPICallPreHandler) apiCallPreHandler).setSdkVersion(SDK_VERSION);
		((MerchantAPICallPreHandler) apiCallPreHandler).setPortName(portName);
	 	String response = call(apiCallPreHandler);
 	
		DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = builderFactory.newDocumentBuilder();
		InputSource inStream = new InputSource();
		inStream.setCharacterStream(new StringReader((String) response));
		Document document = builder.parse(inStream);
		XPathFactory factory = XPathFactory.newInstance();
		XPath xpath = factory.newXPath();
		try {
			Node node = (Node) xpath.evaluate(
					"Envelope/Body/SetAccessPermissionsResponse", document,
					XPathConstants.NODE);
			return new SetAccessPermissionsResponseType(node);
		} catch (XPathExpressionException exe) {
			throw new RuntimeException("Unable to parse response", exe);
		}	
	}
	/**	
	 * AUTO_GENERATED
	 * @throws SSLConfigurationException
	 * @throws InvalidCredentialException
	 * @throws UnsupportedEncodingException
	 * @throws IOException
	 * @throws HttpErrorException
	 * @throws InvalidResponseDataException
	 * @throws ClientActionRequiredException
	 * @throws MissingCredentialException
	 * @throws InterruptedException
	 * @throws OAuthException
	 */
	 public UpdateAccessPermissionsResponseType updateAccessPermissions(UpdateAccessPermissionsReq updateAccessPermissionsReq, String apiUsername) throws SSLConfigurationException, InvalidCredentialException, IOException, HttpErrorException, InvalidResponseDataException, ClientActionRequiredException, MissingCredentialException, InterruptedException, OAuthException, ParserConfigurationException, SAXException, IOException {
	 	APICallPreHandler apiCallPreHandler = null;
	 	String portName = "PayPalAPIAA";
		setStandardParams(updateAccessPermissionsReq.getUpdateAccessPermissionsRequest());
		DefaultSOAPAPICallHandler defaultHandler = new DefaultSOAPAPICallHandler(updateAccessPermissionsReq.toXMLString(null, "UpdateAccessPermissionsReq"), null, null);
		apiCallPreHandler = new MerchantAPICallPreHandler(defaultHandler, apiUsername, getAccessToken(), getTokenSecret());
		((MerchantAPICallPreHandler) apiCallPreHandler).setSdkName(SDK_NAME);
		((MerchantAPICallPreHandler) apiCallPreHandler).setSdkVersion(SDK_VERSION);
		((MerchantAPICallPreHandler) apiCallPreHandler).setPortName(portName);
	 	String response = call(apiCallPreHandler);
		DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = builderFactory.newDocumentBuilder();
		InputSource inStream = new InputSource();
		inStream.setCharacterStream(new StringReader((String) response));
		Document document = builder.parse(inStream);
		XPathFactory factory = XPathFactory.newInstance();
		XPath xpath = factory.newXPath();
		try {
			Node node = (Node) xpath.evaluate("Envelope/Body/UpdateAccessPermissionsResponse", document, XPathConstants.NODE);
			return new UpdateAccessPermissionsResponseType(node);
		} catch (XPathExpressionException exe) {
			throw new RuntimeException("Unable to parse response", exe);
		}
	 }
	 
	/** 
	 * AUTO_GENERATED
	 * @throws SSLConfigurationException
	 * @throws InvalidCredentialException
	 * @throws UnsupportedEncodingException
	 * @throws IOException
	 * @throws HttpErrorException
	 * @throws InvalidResponseDataException
	 * @throws ClientActionRequiredException
	 * @throws MissingCredentialException
	 * @throws InterruptedException
	 * @throws OAuthException
	 */
	 public UpdateAccessPermissionsResponseType updateAccessPermissions(UpdateAccessPermissionsReq updateAccessPermissionsReq) throws SSLConfigurationException, InvalidCredentialException, IOException, HttpErrorException, InvalidResponseDataException, ClientActionRequiredException, MissingCredentialException, InterruptedException, OAuthException, ParserConfigurationException, SAXException  {
	 	return updateAccessPermissions(updateAccessPermissionsReq, (String) null);
	 }

	/** 
	 * AUTO_GENERATED
	 * @throws SSLConfigurationException
	 * @throws InvalidCredentialException
	 * @throws UnsupportedEncodingException
	 * @throws IOException
	 * @throws HttpErrorException
	 * @throws InvalidResponseDataException
	 * @throws ClientActionRequiredException
	 * @throws MissingCredentialException
	 * @throws InterruptedException
	 * @throws OAuthException
	 */
	 public UpdateAccessPermissionsResponseType updateAccessPermissions(UpdateAccessPermissionsReq updateAccessPermissionsReq, ICredential credential) throws SSLConfigurationException, InvalidCredentialException, IOException, HttpErrorException, InvalidResponseDataException, ClientActionRequiredException, MissingCredentialException, InterruptedException, OAuthException, ParserConfigurationException, SAXException  {
	 	APICallPreHandler apiCallPreHandler = null;
	 	String portName = "PayPalAPIAA";
		setStandardParams(updateAccessPermissionsReq.getUpdateAccessPermissionsRequest());
		DefaultSOAPAPICallHandler defaultHandler = new DefaultSOAPAPICallHandler(updateAccessPermissionsReq.toXMLString(null, "UpdateAccessPermissionsReq"), null, null);
		apiCallPreHandler = new MerchantAPICallPreHandler(defaultHandler, credential);
		((MerchantAPICallPreHandler) apiCallPreHandler).setSdkName(SDK_NAME);
		((MerchantAPICallPreHandler) apiCallPreHandler).setSdkVersion(SDK_VERSION);
		((MerchantAPICallPreHandler) apiCallPreHandler).setPortName(portName);
	 	String response = call(apiCallPreHandler);
 	
		DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = builderFactory.newDocumentBuilder();
		InputSource inStream = new InputSource();
		inStream.setCharacterStream(new StringReader((String) response));
		Document document = builder.parse(inStream);
		XPathFactory factory = XPathFactory.newInstance();
		XPath xpath = factory.newXPath();
		try {
			Node node = (Node) xpath.evaluate(
					"Envelope/Body/UpdateAccessPermissionsResponse", document,
					XPathConstants.NODE);
			return new UpdateAccessPermissionsResponseType(node);
		} catch (XPathExpressionException exe) {
			throw new RuntimeException("Unable to parse response", exe);
		}	
	}
	/**	
	 * AUTO_GENERATED
	 * @throws SSLConfigurationException
	 * @throws InvalidCredentialException
	 * @throws UnsupportedEncodingException
	 * @throws IOException
	 * @throws HttpErrorException
	 * @throws InvalidResponseDataException
	 * @throws ClientActionRequiredException
	 * @throws MissingCredentialException
	 * @throws InterruptedException
	 * @throws OAuthException
	 */
	 public GetAccessPermissionDetailsResponseType getAccessPermissionDetails(GetAccessPermissionDetailsReq getAccessPermissionDetailsReq, String apiUsername) throws SSLConfigurationException, InvalidCredentialException, IOException, HttpErrorException, InvalidResponseDataException, ClientActionRequiredException, MissingCredentialException, InterruptedException, OAuthException, ParserConfigurationException, SAXException, IOException {
	 	APICallPreHandler apiCallPreHandler = null;
	 	String portName = "PayPalAPIAA";
		setStandardParams(getAccessPermissionDetailsReq.getGetAccessPermissionDetailsRequest());
		DefaultSOAPAPICallHandler defaultHandler = new DefaultSOAPAPICallHandler(getAccessPermissionDetailsReq.toXMLString(null, "GetAccessPermissionDetailsReq"), null, null);
		apiCallPreHandler = new MerchantAPICallPreHandler(defaultHandler, apiUsername, getAccessToken(), getTokenSecret());
		((MerchantAPICallPreHandler) apiCallPreHandler).setSdkName(SDK_NAME);
		((MerchantAPICallPreHandler) apiCallPreHandler).setSdkVersion(SDK_VERSION);
		((MerchantAPICallPreHandler) apiCallPreHandler).setPortName(portName);
	 	String response = call(apiCallPreHandler);
		DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = builderFactory.newDocumentBuilder();
		InputSource inStream = new InputSource();
		inStream.setCharacterStream(new StringReader((String) response));
		Document document = builder.parse(inStream);
		XPathFactory factory = XPathFactory.newInstance();
		XPath xpath = factory.newXPath();
		try {
			Node node = (Node) xpath.evaluate("Envelope/Body/GetAccessPermissionDetailsResponse", document, XPathConstants.NODE);
			return new GetAccessPermissionDetailsResponseType(node);
		} catch (XPathExpressionException exe) {
			throw new RuntimeException("Unable to parse response", exe);
		}
	 }
	 
	/** 
	 * AUTO_GENERATED
	 * @throws SSLConfigurationException
	 * @throws InvalidCredentialException
	 * @throws UnsupportedEncodingException
	 * @throws IOException
	 * @throws HttpErrorException
	 * @throws InvalidResponseDataException
	 * @throws ClientActionRequiredException
	 * @throws MissingCredentialException
	 * @throws InterruptedException
	 * @throws OAuthException
	 */
	 public GetAccessPermissionDetailsResponseType getAccessPermissionDetails(GetAccessPermissionDetailsReq getAccessPermissionDetailsReq) throws SSLConfigurationException, InvalidCredentialException, IOException, HttpErrorException, InvalidResponseDataException, ClientActionRequiredException, MissingCredentialException, InterruptedException, OAuthException, ParserConfigurationException, SAXException  {
	 	return getAccessPermissionDetails(getAccessPermissionDetailsReq, (String) null);
	 }

	/** 
	 * AUTO_GENERATED
	 * @throws SSLConfigurationException
	 * @throws InvalidCredentialException
	 * @throws UnsupportedEncodingException
	 * @throws IOException
	 * @throws HttpErrorException
	 * @throws InvalidResponseDataException
	 * @throws ClientActionRequiredException
	 * @throws MissingCredentialException
	 * @throws InterruptedException
	 * @throws OAuthException
	 */
	 public GetAccessPermissionDetailsResponseType getAccessPermissionDetails(GetAccessPermissionDetailsReq getAccessPermissionDetailsReq, ICredential credential) throws SSLConfigurationException, InvalidCredentialException, IOException, HttpErrorException, InvalidResponseDataException, ClientActionRequiredException, MissingCredentialException, InterruptedException, OAuthException, ParserConfigurationException, SAXException  {
	 	APICallPreHandler apiCallPreHandler = null;
	 	String portName = "PayPalAPIAA";
		setStandardParams(getAccessPermissionDetailsReq.getGetAccessPermissionDetailsRequest());
		DefaultSOAPAPICallHandler defaultHandler = new DefaultSOAPAPICallHandler(getAccessPermissionDetailsReq.toXMLString(null, "GetAccessPermissionDetailsReq"), null, null);
		apiCallPreHandler = new MerchantAPICallPreHandler(defaultHandler, credential);
		((MerchantAPICallPreHandler) apiCallPreHandler).setSdkName(SDK_NAME);
		((MerchantAPICallPreHandler) apiCallPreHandler).setSdkVersion(SDK_VERSION);
		((MerchantAPICallPreHandler) apiCallPreHandler).setPortName(portName);
	 	String response = call(apiCallPreHandler);
 	
		DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = builderFactory.newDocumentBuilder();
		InputSource inStream = new InputSource();
		inStream.setCharacterStream(new StringReader((String) response));
		Document document = builder.parse(inStream);
		XPathFactory factory = XPathFactory.newInstance();
		XPath xpath = factory.newXPath();
		try {
			Node node = (Node) xpath.evaluate(
					"Envelope/Body/GetAccessPermissionDetailsResponse", document,
					XPathConstants.NODE);
			return new GetAccessPermissionDetailsResponseType(node);
		} catch (XPathExpressionException exe) {
			throw new RuntimeException("Unable to parse response", exe);
		}	
	}
	/**	
	 * AUTO_GENERATED
	 * @throws SSLConfigurationException
	 * @throws InvalidCredentialException
	 * @throws UnsupportedEncodingException
	 * @throws IOException
	 * @throws HttpErrorException
	 * @throws InvalidResponseDataException
	 * @throws ClientActionRequiredException
	 * @throws MissingCredentialException
	 * @throws InterruptedException
	 * @throws OAuthException
	 */
	 public GetIncentiveEvaluationResponseType getIncentiveEvaluation(GetIncentiveEvaluationReq getIncentiveEvaluationReq, String apiUsername) throws SSLConfigurationException, InvalidCredentialException, IOException, HttpErrorException, InvalidResponseDataException, ClientActionRequiredException, MissingCredentialException, InterruptedException, OAuthException, ParserConfigurationException, SAXException, IOException {
	 	APICallPreHandler apiCallPreHandler = null;
	 	String portName = "PayPalAPIAA";
		setStandardParams(getIncentiveEvaluationReq.getGetIncentiveEvaluationRequest());
		DefaultSOAPAPICallHandler defaultHandler = new DefaultSOAPAPICallHandler(getIncentiveEvaluationReq.toXMLString(null, "GetIncentiveEvaluationReq"), null, null);
		apiCallPreHandler = new MerchantAPICallPreHandler(defaultHandler, apiUsername, getAccessToken(), getTokenSecret());
		((MerchantAPICallPreHandler) apiCallPreHandler).setSdkName(SDK_NAME);
		((MerchantAPICallPreHandler) apiCallPreHandler).setSdkVersion(SDK_VERSION);
		((MerchantAPICallPreHandler) apiCallPreHandler).setPortName(portName);
	 	String response = call(apiCallPreHandler);
		DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = builderFactory.newDocumentBuilder();
		InputSource inStream = new InputSource();
		inStream.setCharacterStream(new StringReader((String) response));
		Document document = builder.parse(inStream);
		XPathFactory factory = XPathFactory.newInstance();
		XPath xpath = factory.newXPath();
		try {
			Node node = (Node) xpath.evaluate("Envelope/Body/GetIncentiveEvaluationResponse", document, XPathConstants.NODE);
			return new GetIncentiveEvaluationResponseType(node);
		} catch (XPathExpressionException exe) {
			throw new RuntimeException("Unable to parse response", exe);
		}
	 }
	 
	/** 
	 * AUTO_GENERATED
	 * @throws SSLConfigurationException
	 * @throws InvalidCredentialException
	 * @throws UnsupportedEncodingException
	 * @throws IOException
	 * @throws HttpErrorException
	 * @throws InvalidResponseDataException
	 * @throws ClientActionRequiredException
	 * @throws MissingCredentialException
	 * @throws InterruptedException
	 * @throws OAuthException
	 */
	 public GetIncentiveEvaluationResponseType getIncentiveEvaluation(GetIncentiveEvaluationReq getIncentiveEvaluationReq) throws SSLConfigurationException, InvalidCredentialException, IOException, HttpErrorException, InvalidResponseDataException, ClientActionRequiredException, MissingCredentialException, InterruptedException, OAuthException, ParserConfigurationException, SAXException  {
	 	return getIncentiveEvaluation(getIncentiveEvaluationReq, (String) null);
	 }

	/** 
	 * AUTO_GENERATED
	 * @throws SSLConfigurationException
	 * @throws InvalidCredentialException
	 * @throws UnsupportedEncodingException
	 * @throws IOException
	 * @throws HttpErrorException
	 * @throws InvalidResponseDataException
	 * @throws ClientActionRequiredException
	 * @throws MissingCredentialException
	 * @throws InterruptedException
	 * @throws OAuthException
	 */
	 public GetIncentiveEvaluationResponseType getIncentiveEvaluation(GetIncentiveEvaluationReq getIncentiveEvaluationReq, ICredential credential) throws SSLConfigurationException, InvalidCredentialException, IOException, HttpErrorException, InvalidResponseDataException, ClientActionRequiredException, MissingCredentialException, InterruptedException, OAuthException, ParserConfigurationException, SAXException  {
	 	APICallPreHandler apiCallPreHandler = null;
	 	String portName = "PayPalAPIAA";
		setStandardParams(getIncentiveEvaluationReq.getGetIncentiveEvaluationRequest());
		DefaultSOAPAPICallHandler defaultHandler = new DefaultSOAPAPICallHandler(getIncentiveEvaluationReq.toXMLString(null, "GetIncentiveEvaluationReq"), null, null);
		apiCallPreHandler = new MerchantAPICallPreHandler(defaultHandler, credential);
		((MerchantAPICallPreHandler) apiCallPreHandler).setSdkName(SDK_NAME);
		((MerchantAPICallPreHandler) apiCallPreHandler).setSdkVersion(SDK_VERSION);
		((MerchantAPICallPreHandler) apiCallPreHandler).setPortName(portName);
	 	String response = call(apiCallPreHandler);
 	
		DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = builderFactory.newDocumentBuilder();
		InputSource inStream = new InputSource();
		inStream.setCharacterStream(new StringReader((String) response));
		Document document = builder.parse(inStream);
		XPathFactory factory = XPathFactory.newInstance();
		XPath xpath = factory.newXPath();
		try {
			Node node = (Node) xpath.evaluate(
					"Envelope/Body/GetIncentiveEvaluationResponse", document,
					XPathConstants.NODE);
			return new GetIncentiveEvaluationResponseType(node);
		} catch (XPathExpressionException exe) {
			throw new RuntimeException("Unable to parse response", exe);
		}	
	}
	/**	
	 * AUTO_GENERATED
	 * @throws SSLConfigurationException
	 * @throws InvalidCredentialException
	 * @throws UnsupportedEncodingException
	 * @throws IOException
	 * @throws HttpErrorException
	 * @throws InvalidResponseDataException
	 * @throws ClientActionRequiredException
	 * @throws MissingCredentialException
	 * @throws InterruptedException
	 * @throws OAuthException
	 */
	 public SetExpressCheckoutResponseType setExpressCheckout(SetExpressCheckoutReq setExpressCheckoutReq, String apiUsername) throws SSLConfigurationException, InvalidCredentialException, IOException, HttpErrorException, InvalidResponseDataException, ClientActionRequiredException, MissingCredentialException, InterruptedException, OAuthException, ParserConfigurationException, SAXException, IOException {
	 	APICallPreHandler apiCallPreHandler = null;
	 	String portName = "PayPalAPIAA";
		setStandardParams(setExpressCheckoutReq.getSetExpressCheckoutRequest());
		DefaultSOAPAPICallHandler defaultHandler = new DefaultSOAPAPICallHandler(setExpressCheckoutReq.toXMLString(null, "SetExpressCheckoutReq"), null, null);
		apiCallPreHandler = new MerchantAPICallPreHandler(defaultHandler, apiUsername, getAccessToken(), getTokenSecret());
		((MerchantAPICallPreHandler) apiCallPreHandler).setSdkName(SDK_NAME);
		((MerchantAPICallPreHandler) apiCallPreHandler).setSdkVersion(SDK_VERSION);
		((MerchantAPICallPreHandler) apiCallPreHandler).setPortName(portName);
	 	String response = call(apiCallPreHandler);
		DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = builderFactory.newDocumentBuilder();
		InputSource inStream = new InputSource();
		inStream.setCharacterStream(new StringReader((String) response));
		Document document = builder.parse(inStream);
		XPathFactory factory = XPathFactory.newInstance();
		XPath xpath = factory.newXPath();
		try {
			Node node = (Node) xpath.evaluate("Envelope/Body/SetExpressCheckoutResponse", document, XPathConstants.NODE);
			return new SetExpressCheckoutResponseType(node);
		} catch (XPathExpressionException exe) {
			throw new RuntimeException("Unable to parse response", exe);
		}
	 }
	 
	/** 
	 * AUTO_GENERATED
	 * @throws SSLConfigurationException
	 * @throws InvalidCredentialException
	 * @throws UnsupportedEncodingException
	 * @throws IOException
	 * @throws HttpErrorException
	 * @throws InvalidResponseDataException
	 * @throws ClientActionRequiredException
	 * @throws MissingCredentialException
	 * @throws InterruptedException
	 * @throws OAuthException
	 */
	 public SetExpressCheckoutResponseType setExpressCheckout(SetExpressCheckoutReq setExpressCheckoutReq) throws SSLConfigurationException, InvalidCredentialException, IOException, HttpErrorException, InvalidResponseDataException, ClientActionRequiredException, MissingCredentialException, InterruptedException, OAuthException, ParserConfigurationException, SAXException  {
	 	return setExpressCheckout(setExpressCheckoutReq, (String) null);
	 }

	/** 
	 * AUTO_GENERATED
	 * @throws SSLConfigurationException
	 * @throws InvalidCredentialException
	 * @throws UnsupportedEncodingException
	 * @throws IOException
	 * @throws HttpErrorException
	 * @throws InvalidResponseDataException
	 * @throws ClientActionRequiredException
	 * @throws MissingCredentialException
	 * @throws InterruptedException
	 * @throws OAuthException
	 */
	 public SetExpressCheckoutResponseType setExpressCheckout(SetExpressCheckoutReq setExpressCheckoutReq, ICredential credential) throws SSLConfigurationException, InvalidCredentialException, IOException, HttpErrorException, InvalidResponseDataException, ClientActionRequiredException, MissingCredentialException, InterruptedException, OAuthException, ParserConfigurationException, SAXException  {
	 	APICallPreHandler apiCallPreHandler = null;
	 	String portName = "PayPalAPIAA";
		setStandardParams(setExpressCheckoutReq.getSetExpressCheckoutRequest());
		DefaultSOAPAPICallHandler defaultHandler = new DefaultSOAPAPICallHandler(setExpressCheckoutReq.toXMLString(null, "SetExpressCheckoutReq"), null, null);
		apiCallPreHandler = new MerchantAPICallPreHandler(defaultHandler, credential);
		((MerchantAPICallPreHandler) apiCallPreHandler).setSdkName(SDK_NAME);
		((MerchantAPICallPreHandler) apiCallPreHandler).setSdkVersion(SDK_VERSION);
		((MerchantAPICallPreHandler) apiCallPreHandler).setPortName(portName);
	 	String response = call(apiCallPreHandler);
 	
		DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = builderFactory.newDocumentBuilder();
		InputSource inStream = new InputSource();
		inStream.setCharacterStream(new StringReader((String) response));
		Document document = builder.parse(inStream);
		XPathFactory factory = XPathFactory.newInstance();
		XPath xpath = factory.newXPath();
		try {
			Node node = (Node) xpath.evaluate(
					"Envelope/Body/SetExpressCheckoutResponse", document,
					XPathConstants.NODE);
			return new SetExpressCheckoutResponseType(node);
		} catch (XPathExpressionException exe) {
			throw new RuntimeException("Unable to parse response", exe);
		}	
	}
	/**	
	 * AUTO_GENERATED
	 * @throws SSLConfigurationException
	 * @throws InvalidCredentialException
	 * @throws UnsupportedEncodingException
	 * @throws IOException
	 * @throws HttpErrorException
	 * @throws InvalidResponseDataException
	 * @throws ClientActionRequiredException
	 * @throws MissingCredentialException
	 * @throws InterruptedException
	 * @throws OAuthException
	 */
	 public ExecuteCheckoutOperationsResponseType executeCheckoutOperations(ExecuteCheckoutOperationsReq executeCheckoutOperationsReq, String apiUsername) throws SSLConfigurationException, InvalidCredentialException, IOException, HttpErrorException, InvalidResponseDataException, ClientActionRequiredException, MissingCredentialException, InterruptedException, OAuthException, ParserConfigurationException, SAXException, IOException {
	 	APICallPreHandler apiCallPreHandler = null;
	 	String portName = "PayPalAPIAA";
		setStandardParams(executeCheckoutOperationsReq.getExecuteCheckoutOperationsRequest());
		DefaultSOAPAPICallHandler defaultHandler = new DefaultSOAPAPICallHandler(executeCheckoutOperationsReq.toXMLString(null, "ExecuteCheckoutOperationsReq"), null, null);
		apiCallPreHandler = new MerchantAPICallPreHandler(defaultHandler, apiUsername, getAccessToken(), getTokenSecret());
		((MerchantAPICallPreHandler) apiCallPreHandler).setSdkName(SDK_NAME);
		((MerchantAPICallPreHandler) apiCallPreHandler).setSdkVersion(SDK_VERSION);
		((MerchantAPICallPreHandler) apiCallPreHandler).setPortName(portName);
	 	String response = call(apiCallPreHandler);
		DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = builderFactory.newDocumentBuilder();
		InputSource inStream = new InputSource();
		inStream.setCharacterStream(new StringReader((String) response));
		Document document = builder.parse(inStream);
		XPathFactory factory = XPathFactory.newInstance();
		XPath xpath = factory.newXPath();
		try {
			Node node = (Node) xpath.evaluate("Envelope/Body/ExecuteCheckoutOperationsResponse", document, XPathConstants.NODE);
			return new ExecuteCheckoutOperationsResponseType(node);
		} catch (XPathExpressionException exe) {
			throw new RuntimeException("Unable to parse response", exe);
		}
	 }
	 
	/** 
	 * AUTO_GENERATED
	 * @throws SSLConfigurationException
	 * @throws InvalidCredentialException
	 * @throws UnsupportedEncodingException
	 * @throws IOException
	 * @throws HttpErrorException
	 * @throws InvalidResponseDataException
	 * @throws ClientActionRequiredException
	 * @throws MissingCredentialException
	 * @throws InterruptedException
	 * @throws OAuthException
	 */
	 public ExecuteCheckoutOperationsResponseType executeCheckoutOperations(ExecuteCheckoutOperationsReq executeCheckoutOperationsReq) throws SSLConfigurationException, InvalidCredentialException, IOException, HttpErrorException, InvalidResponseDataException, ClientActionRequiredException, MissingCredentialException, InterruptedException, OAuthException, ParserConfigurationException, SAXException  {
	 	return executeCheckoutOperations(executeCheckoutOperationsReq, (String) null);
	 }

	/** 
	 * AUTO_GENERATED
	 * @throws SSLConfigurationException
	 * @throws InvalidCredentialException
	 * @throws UnsupportedEncodingException
	 * @throws IOException
	 * @throws HttpErrorException
	 * @throws InvalidResponseDataException
	 * @throws ClientActionRequiredException
	 * @throws MissingCredentialException
	 * @throws InterruptedException
	 * @throws OAuthException
	 */
	 public ExecuteCheckoutOperationsResponseType executeCheckoutOperations(ExecuteCheckoutOperationsReq executeCheckoutOperationsReq, ICredential credential) throws SSLConfigurationException, InvalidCredentialException, IOException, HttpErrorException, InvalidResponseDataException, ClientActionRequiredException, MissingCredentialException, InterruptedException, OAuthException, ParserConfigurationException, SAXException  {
	 	APICallPreHandler apiCallPreHandler = null;
	 	String portName = "PayPalAPIAA";
		setStandardParams(executeCheckoutOperationsReq.getExecuteCheckoutOperationsRequest());
		DefaultSOAPAPICallHandler defaultHandler = new DefaultSOAPAPICallHandler(executeCheckoutOperationsReq.toXMLString(null, "ExecuteCheckoutOperationsReq"), null, null);
		apiCallPreHandler = new MerchantAPICallPreHandler(defaultHandler, credential);
		((MerchantAPICallPreHandler) apiCallPreHandler).setSdkName(SDK_NAME);
		((MerchantAPICallPreHandler) apiCallPreHandler).setSdkVersion(SDK_VERSION);
		((MerchantAPICallPreHandler) apiCallPreHandler).setPortName(portName);
	 	String response = call(apiCallPreHandler);
 	
		DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = builderFactory.newDocumentBuilder();
		InputSource inStream = new InputSource();
		inStream.setCharacterStream(new StringReader((String) response));
		Document document = builder.parse(inStream);
		XPathFactory factory = XPathFactory.newInstance();
		XPath xpath = factory.newXPath();
		try {
			Node node = (Node) xpath.evaluate(
					"Envelope/Body/ExecuteCheckoutOperationsResponse", document,
					XPathConstants.NODE);
			return new ExecuteCheckoutOperationsResponseType(node);
		} catch (XPathExpressionException exe) {
			throw new RuntimeException("Unable to parse response", exe);
		}	
	}
	/**	
	 * AUTO_GENERATED
	 * @throws SSLConfigurationException
	 * @throws InvalidCredentialException
	 * @throws UnsupportedEncodingException
	 * @throws IOException
	 * @throws HttpErrorException
	 * @throws InvalidResponseDataException
	 * @throws ClientActionRequiredException
	 * @throws MissingCredentialException
	 * @throws InterruptedException
	 * @throws OAuthException
	 */
	 public GetExpressCheckoutDetailsResponseType getExpressCheckoutDetails(GetExpressCheckoutDetailsReq getExpressCheckoutDetailsReq, String apiUsername) throws SSLConfigurationException, InvalidCredentialException, IOException, HttpErrorException, InvalidResponseDataException, ClientActionRequiredException, MissingCredentialException, InterruptedException, OAuthException, ParserConfigurationException, SAXException, IOException {
	 	APICallPreHandler apiCallPreHandler = null;
	 	String portName = "PayPalAPIAA";
		setStandardParams(getExpressCheckoutDetailsReq.getGetExpressCheckoutDetailsRequest());
		DefaultSOAPAPICallHandler defaultHandler = new DefaultSOAPAPICallHandler(getExpressCheckoutDetailsReq.toXMLString(null, "GetExpressCheckoutDetailsReq"), null, null);
		apiCallPreHandler = new MerchantAPICallPreHandler(defaultHandler, apiUsername, getAccessToken(), getTokenSecret());
		((MerchantAPICallPreHandler) apiCallPreHandler).setSdkName(SDK_NAME);
		((MerchantAPICallPreHandler) apiCallPreHandler).setSdkVersion(SDK_VERSION);
		((MerchantAPICallPreHandler) apiCallPreHandler).setPortName(portName);
	 	String response = call(apiCallPreHandler);
		DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = builderFactory.newDocumentBuilder();
		InputSource inStream = new InputSource();
		inStream.setCharacterStream(new StringReader((String) response));
		Document document = builder.parse(inStream);
		XPathFactory factory = XPathFactory.newInstance();
		XPath xpath = factory.newXPath();
		try {
			Node node = (Node) xpath.evaluate("Envelope/Body/GetExpressCheckoutDetailsResponse", document, XPathConstants.NODE);
			return new GetExpressCheckoutDetailsResponseType(node);
		} catch (XPathExpressionException exe) {
			throw new RuntimeException("Unable to parse response", exe);
		}
	 }
	 
	/** 
	 * AUTO_GENERATED
	 * @throws SSLConfigurationException
	 * @throws InvalidCredentialException
	 * @throws UnsupportedEncodingException
	 * @throws IOException
	 * @throws HttpErrorException
	 * @throws InvalidResponseDataException
	 * @throws ClientActionRequiredException
	 * @throws MissingCredentialException
	 * @throws InterruptedException
	 * @throws OAuthException
	 */
	 public GetExpressCheckoutDetailsResponseType getExpressCheckoutDetails(GetExpressCheckoutDetailsReq getExpressCheckoutDetailsReq) throws SSLConfigurationException, InvalidCredentialException, IOException, HttpErrorException, InvalidResponseDataException, ClientActionRequiredException, MissingCredentialException, InterruptedException, OAuthException, ParserConfigurationException, SAXException  {
	 	return getExpressCheckoutDetails(getExpressCheckoutDetailsReq, (String) null);
	 }

	/** 
	 * AUTO_GENERATED
	 * @throws SSLConfigurationException
	 * @throws InvalidCredentialException
	 * @throws UnsupportedEncodingException
	 * @throws IOException
	 * @throws HttpErrorException
	 * @throws InvalidResponseDataException
	 * @throws ClientActionRequiredException
	 * @throws MissingCredentialException
	 * @throws InterruptedException
	 * @throws OAuthException
	 */
	 public GetExpressCheckoutDetailsResponseType getExpressCheckoutDetails(GetExpressCheckoutDetailsReq getExpressCheckoutDetailsReq, ICredential credential) throws SSLConfigurationException, InvalidCredentialException, IOException, HttpErrorException, InvalidResponseDataException, ClientActionRequiredException, MissingCredentialException, InterruptedException, OAuthException, ParserConfigurationException, SAXException  {
	 	APICallPreHandler apiCallPreHandler = null;
	 	String portName = "PayPalAPIAA";
		setStandardParams(getExpressCheckoutDetailsReq.getGetExpressCheckoutDetailsRequest());
		DefaultSOAPAPICallHandler defaultHandler = new DefaultSOAPAPICallHandler(getExpressCheckoutDetailsReq.toXMLString(null, "GetExpressCheckoutDetailsReq"), null, null);
		apiCallPreHandler = new MerchantAPICallPreHandler(defaultHandler, credential);
		((MerchantAPICallPreHandler) apiCallPreHandler).setSdkName(SDK_NAME);
		((MerchantAPICallPreHandler) apiCallPreHandler).setSdkVersion(SDK_VERSION);
		((MerchantAPICallPreHandler) apiCallPreHandler).setPortName(portName);
	 	String response = call(apiCallPreHandler);
 	
		DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = builderFactory.newDocumentBuilder();
		InputSource inStream = new InputSource();
		inStream.setCharacterStream(new StringReader((String) response));
		Document document = builder.parse(inStream);
		XPathFactory factory = XPathFactory.newInstance();
		XPath xpath = factory.newXPath();
		try {
			Node node = (Node) xpath.evaluate(
					"Envelope/Body/GetExpressCheckoutDetailsResponse", document,
					XPathConstants.NODE);
			return new GetExpressCheckoutDetailsResponseType(node);
		} catch (XPathExpressionException exe) {
			throw new RuntimeException("Unable to parse response", exe);
		}	
	}
	/**	
	 * AUTO_GENERATED
	 * @throws SSLConfigurationException
	 * @throws InvalidCredentialException
	 * @throws UnsupportedEncodingException
	 * @throws IOException
	 * @throws HttpErrorException
	 * @throws InvalidResponseDataException
	 * @throws ClientActionRequiredException
	 * @throws MissingCredentialException
	 * @throws InterruptedException
	 * @throws OAuthException
	 */
	 public DoDirectPaymentResponseType doDirectPayment(DoDirectPaymentReq doDirectPaymentReq, String apiUsername) throws SSLConfigurationException, InvalidCredentialException, IOException, HttpErrorException, InvalidResponseDataException, ClientActionRequiredException, MissingCredentialException, InterruptedException, OAuthException, ParserConfigurationException, SAXException, IOException {
	 	APICallPreHandler apiCallPreHandler = null;
	 	String portName = "PayPalAPIAA";
		setStandardParams(doDirectPaymentReq.getDoDirectPaymentRequest());
		DefaultSOAPAPICallHandler defaultHandler = new DefaultSOAPAPICallHandler(doDirectPaymentReq.toXMLString(null, "DoDirectPaymentReq"), null, null);
		apiCallPreHandler = new MerchantAPICallPreHandler(defaultHandler, apiUsername, getAccessToken(), getTokenSecret());
		((MerchantAPICallPreHandler) apiCallPreHandler).setSdkName(SDK_NAME);
		((MerchantAPICallPreHandler) apiCallPreHandler).setSdkVersion(SDK_VERSION);
		((MerchantAPICallPreHandler) apiCallPreHandler).setPortName(portName);
	 	String response = call(apiCallPreHandler);
		DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = builderFactory.newDocumentBuilder();
		InputSource inStream = new InputSource();
		inStream.setCharacterStream(new StringReader((String) response));
		Document document = builder.parse(inStream);
		XPathFactory factory = XPathFactory.newInstance();
		XPath xpath = factory.newXPath();
		try {
			Node node = (Node) xpath.evaluate("Envelope/Body/DoDirectPaymentResponse", document, XPathConstants.NODE);
			return new DoDirectPaymentResponseType(node);
		} catch (XPathExpressionException exe) {
			throw new RuntimeException("Unable to parse response", exe);
		}
	 }
	 
	/** 
	 * AUTO_GENERATED
	 * @throws SSLConfigurationException
	 * @throws InvalidCredentialException
	 * @throws UnsupportedEncodingException
	 * @throws IOException
	 * @throws HttpErrorException
	 * @throws InvalidResponseDataException
	 * @throws ClientActionRequiredException
	 * @throws MissingCredentialException
	 * @throws InterruptedException
	 * @throws OAuthException
	 */
	 public DoDirectPaymentResponseType doDirectPayment(DoDirectPaymentReq doDirectPaymentReq) throws SSLConfigurationException, InvalidCredentialException, IOException, HttpErrorException, InvalidResponseDataException, ClientActionRequiredException, MissingCredentialException, InterruptedException, OAuthException, ParserConfigurationException, SAXException  {
	 	return doDirectPayment(doDirectPaymentReq, (String) null);
	 }

	/** 
	 * AUTO_GENERATED
	 * @throws SSLConfigurationException
	 * @throws InvalidCredentialException
	 * @throws UnsupportedEncodingException
	 * @throws IOException
	 * @throws HttpErrorException
	 * @throws InvalidResponseDataException
	 * @throws ClientActionRequiredException
	 * @throws MissingCredentialException
	 * @throws InterruptedException
	 * @throws OAuthException
	 */
	 public DoDirectPaymentResponseType doDirectPayment(DoDirectPaymentReq doDirectPaymentReq, ICredential credential) throws SSLConfigurationException, InvalidCredentialException, IOException, HttpErrorException, InvalidResponseDataException, ClientActionRequiredException, MissingCredentialException, InterruptedException, OAuthException, ParserConfigurationException, SAXException  {
	 	APICallPreHandler apiCallPreHandler = null;
	 	String portName = "PayPalAPIAA";
		setStandardParams(doDirectPaymentReq.getDoDirectPaymentRequest());
		DefaultSOAPAPICallHandler defaultHandler = new DefaultSOAPAPICallHandler(doDirectPaymentReq.toXMLString(null, "DoDirectPaymentReq"), null, null);
		apiCallPreHandler = new MerchantAPICallPreHandler(defaultHandler, credential);
		((MerchantAPICallPreHandler) apiCallPreHandler).setSdkName(SDK_NAME);
		((MerchantAPICallPreHandler) apiCallPreHandler).setSdkVersion(SDK_VERSION);
		((MerchantAPICallPreHandler) apiCallPreHandler).setPortName(portName);
	 	String response = call(apiCallPreHandler);
 	
		DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = builderFactory.newDocumentBuilder();
		InputSource inStream = new InputSource();
		inStream.setCharacterStream(new StringReader((String) response));
		Document document = builder.parse(inStream);
		XPathFactory factory = XPathFactory.newInstance();
		XPath xpath = factory.newXPath();
		try {
			Node node = (Node) xpath.evaluate(
					"Envelope/Body/DoDirectPaymentResponse", document,
					XPathConstants.NODE);
			return new DoDirectPaymentResponseType(node);
		} catch (XPathExpressionException exe) {
			throw new RuntimeException("Unable to parse response", exe);
		}	
	}
	/**	
	 * AUTO_GENERATED
	 * @throws SSLConfigurationException
	 * @throws InvalidCredentialException
	 * @throws UnsupportedEncodingException
	 * @throws IOException
	 * @throws HttpErrorException
	 * @throws InvalidResponseDataException
	 * @throws ClientActionRequiredException
	 * @throws MissingCredentialException
	 * @throws InterruptedException
	 * @throws OAuthException
	 */
	 public ManagePendingTransactionStatusResponseType managePendingTransactionStatus(ManagePendingTransactionStatusReq managePendingTransactionStatusReq, String apiUsername) throws SSLConfigurationException, InvalidCredentialException, IOException, HttpErrorException, InvalidResponseDataException, ClientActionRequiredException, MissingCredentialException, InterruptedException, OAuthException, ParserConfigurationException, SAXException, IOException {
	 	APICallPreHandler apiCallPreHandler = null;
	 	String portName = "PayPalAPIAA";
		setStandardParams(managePendingTransactionStatusReq.getManagePendingTransactionStatusRequest());
		DefaultSOAPAPICallHandler defaultHandler = new DefaultSOAPAPICallHandler(managePendingTransactionStatusReq.toXMLString(null, "ManagePendingTransactionStatusReq"), null, null);
		apiCallPreHandler = new MerchantAPICallPreHandler(defaultHandler, apiUsername, getAccessToken(), getTokenSecret());
		((MerchantAPICallPreHandler) apiCallPreHandler).setSdkName(SDK_NAME);
		((MerchantAPICallPreHandler) apiCallPreHandler).setSdkVersion(SDK_VERSION);
		((MerchantAPICallPreHandler) apiCallPreHandler).setPortName(portName);
	 	String response = call(apiCallPreHandler);
		DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = builderFactory.newDocumentBuilder();
		InputSource inStream = new InputSource();
		inStream.setCharacterStream(new StringReader((String) response));
		Document document = builder.parse(inStream);
		XPathFactory factory = XPathFactory.newInstance();
		XPath xpath = factory.newXPath();
		try {
			Node node = (Node) xpath.evaluate("Envelope/Body/ManagePendingTransactionStatusResponse", document, XPathConstants.NODE);
			return new ManagePendingTransactionStatusResponseType(node);
		} catch (XPathExpressionException exe) {
			throw new RuntimeException("Unable to parse response", exe);
		}
	 }
	 
	/** 
	 * AUTO_GENERATED
	 * @throws SSLConfigurationException
	 * @throws InvalidCredentialException
	 * @throws UnsupportedEncodingException
	 * @throws IOException
	 * @throws HttpErrorException
	 * @throws InvalidResponseDataException
	 * @throws ClientActionRequiredException
	 * @throws MissingCredentialException
	 * @throws InterruptedException
	 * @throws OAuthException
	 */
	 public ManagePendingTransactionStatusResponseType managePendingTransactionStatus(ManagePendingTransactionStatusReq managePendingTransactionStatusReq) throws SSLConfigurationException, InvalidCredentialException, IOException, HttpErrorException, InvalidResponseDataException, ClientActionRequiredException, MissingCredentialException, InterruptedException, OAuthException, ParserConfigurationException, SAXException  {
	 	return managePendingTransactionStatus(managePendingTransactionStatusReq, (String) null);
	 }

	/** 
	 * AUTO_GENERATED
	 * @throws SSLConfigurationException
	 * @throws InvalidCredentialException
	 * @throws UnsupportedEncodingException
	 * @throws IOException
	 * @throws HttpErrorException
	 * @throws InvalidResponseDataException
	 * @throws ClientActionRequiredException
	 * @throws MissingCredentialException
	 * @throws InterruptedException
	 * @throws OAuthException
	 */
	 public ManagePendingTransactionStatusResponseType managePendingTransactionStatus(ManagePendingTransactionStatusReq managePendingTransactionStatusReq, ICredential credential) throws SSLConfigurationException, InvalidCredentialException, IOException, HttpErrorException, InvalidResponseDataException, ClientActionRequiredException, MissingCredentialException, InterruptedException, OAuthException, ParserConfigurationException, SAXException  {
	 	APICallPreHandler apiCallPreHandler = null;
	 	String portName = "PayPalAPIAA";
		setStandardParams(managePendingTransactionStatusReq.getManagePendingTransactionStatusRequest());
		DefaultSOAPAPICallHandler defaultHandler = new DefaultSOAPAPICallHandler(managePendingTransactionStatusReq.toXMLString(null, "ManagePendingTransactionStatusReq"), null, null);
		apiCallPreHandler = new MerchantAPICallPreHandler(defaultHandler, credential);
		((MerchantAPICallPreHandler) apiCallPreHandler).setSdkName(SDK_NAME);
		((MerchantAPICallPreHandler) apiCallPreHandler).setSdkVersion(SDK_VERSION);
		((MerchantAPICallPreHandler) apiCallPreHandler).setPortName(portName);
	 	String response = call(apiCallPreHandler);
 	
		DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = builderFactory.newDocumentBuilder();
		InputSource inStream = new InputSource();
		inStream.setCharacterStream(new StringReader((String) response));
		Document document = builder.parse(inStream);
		XPathFactory factory = XPathFactory.newInstance();
		XPath xpath = factory.newXPath();
		try {
			Node node = (Node) xpath.evaluate(
					"Envelope/Body/ManagePendingTransactionStatusResponse", document,
					XPathConstants.NODE);
			return new ManagePendingTransactionStatusResponseType(node);
		} catch (XPathExpressionException exe) {
			throw new RuntimeException("Unable to parse response", exe);
		}	
	}
	/**	
	 * AUTO_GENERATED
	 * @throws SSLConfigurationException
	 * @throws InvalidCredentialException
	 * @throws UnsupportedEncodingException
	 * @throws IOException
	 * @throws HttpErrorException
	 * @throws InvalidResponseDataException
	 * @throws ClientActionRequiredException
	 * @throws MissingCredentialException
	 * @throws InterruptedException
	 * @throws OAuthException
	 */
	 public DoCancelResponseType doCancel(DoCancelReq doCancelReq, String apiUsername) throws SSLConfigurationException, InvalidCredentialException, IOException, HttpErrorException, InvalidResponseDataException, ClientActionRequiredException, MissingCredentialException, InterruptedException, OAuthException, ParserConfigurationException, SAXException, IOException {
	 	APICallPreHandler apiCallPreHandler = null;
	 	String portName = "PayPalAPIAA";
		setStandardParams(doCancelReq.getDoCancelRequest());
		DefaultSOAPAPICallHandler defaultHandler = new DefaultSOAPAPICallHandler(doCancelReq.toXMLString(null, "DoCancelReq"), null, null);
		apiCallPreHandler = new MerchantAPICallPreHandler(defaultHandler, apiUsername, getAccessToken(), getTokenSecret());
		((MerchantAPICallPreHandler) apiCallPreHandler).setSdkName(SDK_NAME);
		((MerchantAPICallPreHandler) apiCallPreHandler).setSdkVersion(SDK_VERSION);
		((MerchantAPICallPreHandler) apiCallPreHandler).setPortName(portName);
	 	String response = call(apiCallPreHandler);
		DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = builderFactory.newDocumentBuilder();
		InputSource inStream = new InputSource();
		inStream.setCharacterStream(new StringReader((String) response));
		Document document = builder.parse(inStream);
		XPathFactory factory = XPathFactory.newInstance();
		XPath xpath = factory.newXPath();
		try {
			Node node = (Node) xpath.evaluate("Envelope/Body/DoCancelResponse", document, XPathConstants.NODE);
			return new DoCancelResponseType(node);
		} catch (XPathExpressionException exe) {
			throw new RuntimeException("Unable to parse response", exe);
		}
	 }
	 
	/** 
	 * AUTO_GENERATED
	 * @throws SSLConfigurationException
	 * @throws InvalidCredentialException
	 * @throws UnsupportedEncodingException
	 * @throws IOException
	 * @throws HttpErrorException
	 * @throws InvalidResponseDataException
	 * @throws ClientActionRequiredException
	 * @throws MissingCredentialException
	 * @throws InterruptedException
	 * @throws OAuthException
	 */
	 public DoCancelResponseType doCancel(DoCancelReq doCancelReq) throws SSLConfigurationException, InvalidCredentialException, IOException, HttpErrorException, InvalidResponseDataException, ClientActionRequiredException, MissingCredentialException, InterruptedException, OAuthException, ParserConfigurationException, SAXException  {
	 	return doCancel(doCancelReq, (String) null);
	 }

	/** 
	 * AUTO_GENERATED
	 * @throws SSLConfigurationException
	 * @throws InvalidCredentialException
	 * @throws UnsupportedEncodingException
	 * @throws IOException
	 * @throws HttpErrorException
	 * @throws InvalidResponseDataException
	 * @throws ClientActionRequiredException
	 * @throws MissingCredentialException
	 * @throws InterruptedException
	 * @throws OAuthException
	 */
	 public DoCancelResponseType doCancel(DoCancelReq doCancelReq, ICredential credential) throws SSLConfigurationException, InvalidCredentialException, IOException, HttpErrorException, InvalidResponseDataException, ClientActionRequiredException, MissingCredentialException, InterruptedException, OAuthException, ParserConfigurationException, SAXException  {
	 	APICallPreHandler apiCallPreHandler = null;
	 	String portName = "PayPalAPIAA";
		setStandardParams(doCancelReq.getDoCancelRequest());
		DefaultSOAPAPICallHandler defaultHandler = new DefaultSOAPAPICallHandler(doCancelReq.toXMLString(null, "DoCancelReq"), null, null);
		apiCallPreHandler = new MerchantAPICallPreHandler(defaultHandler, credential);
		((MerchantAPICallPreHandler) apiCallPreHandler).setSdkName(SDK_NAME);
		((MerchantAPICallPreHandler) apiCallPreHandler).setSdkVersion(SDK_VERSION);
		((MerchantAPICallPreHandler) apiCallPreHandler).setPortName(portName);
	 	String response = call(apiCallPreHandler);
 	
		DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = builderFactory.newDocumentBuilder();
		InputSource inStream = new InputSource();
		inStream.setCharacterStream(new StringReader((String) response));
		Document document = builder.parse(inStream);
		XPathFactory factory = XPathFactory.newInstance();
		XPath xpath = factory.newXPath();
		try {
			Node node = (Node) xpath.evaluate(
					"Envelope/Body/DoCancelResponse", document,
					XPathConstants.NODE);
			return new DoCancelResponseType(node);
		} catch (XPathExpressionException exe) {
			throw new RuntimeException("Unable to parse response", exe);
		}	
	}
	/**	
	 * AUTO_GENERATED
	 * @throws SSLConfigurationException
	 * @throws InvalidCredentialException
	 * @throws UnsupportedEncodingException
	 * @throws IOException
	 * @throws HttpErrorException
	 * @throws InvalidResponseDataException
	 * @throws ClientActionRequiredException
	 * @throws MissingCredentialException
	 * @throws InterruptedException
	 * @throws OAuthException
	 */
	 public DoCaptureResponseType doCapture(DoCaptureReq doCaptureReq, String apiUsername) throws SSLConfigurationException, InvalidCredentialException, IOException, HttpErrorException, InvalidResponseDataException, ClientActionRequiredException, MissingCredentialException, InterruptedException, OAuthException, ParserConfigurationException, SAXException, IOException {
	 	APICallPreHandler apiCallPreHandler = null;
	 	String portName = "PayPalAPIAA";
		setStandardParams(doCaptureReq.getDoCaptureRequest());
		DefaultSOAPAPICallHandler defaultHandler = new DefaultSOAPAPICallHandler(doCaptureReq.toXMLString(null, "DoCaptureReq"), null, null);
		apiCallPreHandler = new MerchantAPICallPreHandler(defaultHandler, apiUsername, getAccessToken(), getTokenSecret());
		((MerchantAPICallPreHandler) apiCallPreHandler).setSdkName(SDK_NAME);
		((MerchantAPICallPreHandler) apiCallPreHandler).setSdkVersion(SDK_VERSION);
		((MerchantAPICallPreHandler) apiCallPreHandler).setPortName(portName);
	 	String response = call(apiCallPreHandler);
		DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = builderFactory.newDocumentBuilder();
		InputSource inStream = new InputSource();
		inStream.setCharacterStream(new StringReader((String) response));
		Document document = builder.parse(inStream);
		XPathFactory factory = XPathFactory.newInstance();
		XPath xpath = factory.newXPath();
		try {
			Node node = (Node) xpath.evaluate("Envelope/Body/DoCaptureResponse", document, XPathConstants.NODE);
			return new DoCaptureResponseType(node);
		} catch (XPathExpressionException exe) {
			throw new RuntimeException("Unable to parse response", exe);
		}
	 }
	 
	/** 
	 * AUTO_GENERATED
	 * @throws SSLConfigurationException
	 * @throws InvalidCredentialException
	 * @throws UnsupportedEncodingException
	 * @throws IOException
	 * @throws HttpErrorException
	 * @throws InvalidResponseDataException
	 * @throws ClientActionRequiredException
	 * @throws MissingCredentialException
	 * @throws InterruptedException
	 * @throws OAuthException
	 */
	 public DoCaptureResponseType doCapture(DoCaptureReq doCaptureReq) throws SSLConfigurationException, InvalidCredentialException, IOException, HttpErrorException, InvalidResponseDataException, ClientActionRequiredException, MissingCredentialException, InterruptedException, OAuthException, ParserConfigurationException, SAXException  {
	 	return doCapture(doCaptureReq, (String) null);
	 }

	/** 
	 * AUTO_GENERATED
	 * @throws SSLConfigurationException
	 * @throws InvalidCredentialException
	 * @throws UnsupportedEncodingException
	 * @throws IOException
	 * @throws HttpErrorException
	 * @throws InvalidResponseDataException
	 * @throws ClientActionRequiredException
	 * @throws MissingCredentialException
	 * @throws InterruptedException
	 * @throws OAuthException
	 */
	 public DoCaptureResponseType doCapture(DoCaptureReq doCaptureReq, ICredential credential) throws SSLConfigurationException, InvalidCredentialException, IOException, HttpErrorException, InvalidResponseDataException, ClientActionRequiredException, MissingCredentialException, InterruptedException, OAuthException, ParserConfigurationException, SAXException  {
	 	APICallPreHandler apiCallPreHandler = null;
	 	String portName = "PayPalAPIAA";
		setStandardParams(doCaptureReq.getDoCaptureRequest());
		DefaultSOAPAPICallHandler defaultHandler = new DefaultSOAPAPICallHandler(doCaptureReq.toXMLString(null, "DoCaptureReq"), null, null);
		apiCallPreHandler = new MerchantAPICallPreHandler(defaultHandler, credential);
		((MerchantAPICallPreHandler) apiCallPreHandler).setSdkName(SDK_NAME);
		((MerchantAPICallPreHandler) apiCallPreHandler).setSdkVersion(SDK_VERSION);
		((MerchantAPICallPreHandler) apiCallPreHandler).setPortName(portName);
	 	String response = call(apiCallPreHandler);
 	
		DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = builderFactory.newDocumentBuilder();
		InputSource inStream = new InputSource();
		inStream.setCharacterStream(new StringReader((String) response));
		Document document = builder.parse(inStream);
		XPathFactory factory = XPathFactory.newInstance();
		XPath xpath = factory.newXPath();
		try {
			Node node = (Node) xpath.evaluate(
					"Envelope/Body/DoCaptureResponse", document,
					XPathConstants.NODE);
			return new DoCaptureResponseType(node);
		} catch (XPathExpressionException exe) {
			throw new RuntimeException("Unable to parse response", exe);
		}	
	}
	/**	
	 * AUTO_GENERATED
	 * @throws SSLConfigurationException
	 * @throws InvalidCredentialException
	 * @throws UnsupportedEncodingException
	 * @throws IOException
	 * @throws HttpErrorException
	 * @throws InvalidResponseDataException
	 * @throws ClientActionRequiredException
	 * @throws MissingCredentialException
	 * @throws InterruptedException
	 * @throws OAuthException
	 */
	 public DoReauthorizationResponseType doReauthorization(DoReauthorizationReq doReauthorizationReq, String apiUsername) throws SSLConfigurationException, InvalidCredentialException, IOException, HttpErrorException, InvalidResponseDataException, ClientActionRequiredException, MissingCredentialException, InterruptedException, OAuthException, ParserConfigurationException, SAXException, IOException {
	 	APICallPreHandler apiCallPreHandler = null;
	 	String portName = "PayPalAPIAA";
		setStandardParams(doReauthorizationReq.getDoReauthorizationRequest());
		DefaultSOAPAPICallHandler defaultHandler = new DefaultSOAPAPICallHandler(doReauthorizationReq.toXMLString(null, "DoReauthorizationReq"), null, null);
		apiCallPreHandler = new MerchantAPICallPreHandler(defaultHandler, apiUsername, getAccessToken(), getTokenSecret());
		((MerchantAPICallPreHandler) apiCallPreHandler).setSdkName(SDK_NAME);
		((MerchantAPICallPreHandler) apiCallPreHandler).setSdkVersion(SDK_VERSION);
		((MerchantAPICallPreHandler) apiCallPreHandler).setPortName(portName);
	 	String response = call(apiCallPreHandler);
		DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = builderFactory.newDocumentBuilder();
		InputSource inStream = new InputSource();
		inStream.setCharacterStream(new StringReader((String) response));
		Document document = builder.parse(inStream);
		XPathFactory factory = XPathFactory.newInstance();
		XPath xpath = factory.newXPath();
		try {
			Node node = (Node) xpath.evaluate("Envelope/Body/DoReauthorizationResponse", document, XPathConstants.NODE);
			return new DoReauthorizationResponseType(node);
		} catch (XPathExpressionException exe) {
			throw new RuntimeException("Unable to parse response", exe);
		}
	 }
	 
	/** 
	 * AUTO_GENERATED
	 * @throws SSLConfigurationException
	 * @throws InvalidCredentialException
	 * @throws UnsupportedEncodingException
	 * @throws IOException
	 * @throws HttpErrorException
	 * @throws InvalidResponseDataException
	 * @throws ClientActionRequiredException
	 * @throws MissingCredentialException
	 * @throws InterruptedException
	 * @throws OAuthException
	 */
	 public DoReauthorizationResponseType doReauthorization(DoReauthorizationReq doReauthorizationReq) throws SSLConfigurationException, InvalidCredentialException, IOException, HttpErrorException, InvalidResponseDataException, ClientActionRequiredException, MissingCredentialException, InterruptedException, OAuthException, ParserConfigurationException, SAXException  {
	 	return doReauthorization(doReauthorizationReq, (String) null);
	 }

	/** 
	 * AUTO_GENERATED
	 * @throws SSLConfigurationException
	 * @throws InvalidCredentialException
	 * @throws UnsupportedEncodingException
	 * @throws IOException
	 * @throws HttpErrorException
	 * @throws InvalidResponseDataException
	 * @throws ClientActionRequiredException
	 * @throws MissingCredentialException
	 * @throws InterruptedException
	 * @throws OAuthException
	 */
	 public DoReauthorizationResponseType doReauthorization(DoReauthorizationReq doReauthorizationReq, ICredential credential) throws SSLConfigurationException, InvalidCredentialException, IOException, HttpErrorException, InvalidResponseDataException, ClientActionRequiredException, MissingCredentialException, InterruptedException, OAuthException, ParserConfigurationException, SAXException  {
	 	APICallPreHandler apiCallPreHandler = null;
	 	String portName = "PayPalAPIAA";
		setStandardParams(doReauthorizationReq.getDoReauthorizationRequest());
		DefaultSOAPAPICallHandler defaultHandler = new DefaultSOAPAPICallHandler(doReauthorizationReq.toXMLString(null, "DoReauthorizationReq"), null, null);
		apiCallPreHandler = new MerchantAPICallPreHandler(defaultHandler, credential);
		((MerchantAPICallPreHandler) apiCallPreHandler).setSdkName(SDK_NAME);
		((MerchantAPICallPreHandler) apiCallPreHandler).setSdkVersion(SDK_VERSION);
		((MerchantAPICallPreHandler) apiCallPreHandler).setPortName(portName);
	 	String response = call(apiCallPreHandler);
 	
		DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = builderFactory.newDocumentBuilder();
		InputSource inStream = new InputSource();
		inStream.setCharacterStream(new StringReader((String) response));
		Document document = builder.parse(inStream);
		XPathFactory factory = XPathFactory.newInstance();
		XPath xpath = factory.newXPath();
		try {
			Node node = (Node) xpath.evaluate(
					"Envelope/Body/DoReauthorizationResponse", document,
					XPathConstants.NODE);
			return new DoReauthorizationResponseType(node);
		} catch (XPathExpressionException exe) {
			throw new RuntimeException("Unable to parse response", exe);
		}	
	}
	/**	
	 * AUTO_GENERATED
	 * @throws SSLConfigurationException
	 * @throws InvalidCredentialException
	 * @throws UnsupportedEncodingException
	 * @throws IOException
	 * @throws HttpErrorException
	 * @throws InvalidResponseDataException
	 * @throws ClientActionRequiredException
	 * @throws MissingCredentialException
	 * @throws InterruptedException
	 * @throws OAuthException
	 */
	 public DoVoidResponseType doVoid(DoVoidReq doVoidReq, String apiUsername) throws SSLConfigurationException, InvalidCredentialException, IOException, HttpErrorException, InvalidResponseDataException, ClientActionRequiredException, MissingCredentialException, InterruptedException, OAuthException, ParserConfigurationException, SAXException, IOException {
	 	APICallPreHandler apiCallPreHandler = null;
	 	String portName = "PayPalAPIAA";
		setStandardParams(doVoidReq.getDoVoidRequest());
		DefaultSOAPAPICallHandler defaultHandler = new DefaultSOAPAPICallHandler(doVoidReq.toXMLString(null, "DoVoidReq"), null, null);
		apiCallPreHandler = new MerchantAPICallPreHandler(defaultHandler, apiUsername, getAccessToken(), getTokenSecret());
		((MerchantAPICallPreHandler) apiCallPreHandler).setSdkName(SDK_NAME);
		((MerchantAPICallPreHandler) apiCallPreHandler).setSdkVersion(SDK_VERSION);
		((MerchantAPICallPreHandler) apiCallPreHandler).setPortName(portName);
	 	String response = call(apiCallPreHandler);
		DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = builderFactory.newDocumentBuilder();
		InputSource inStream = new InputSource();
		inStream.setCharacterStream(new StringReader((String) response));
		Document document = builder.parse(inStream);
		XPathFactory factory = XPathFactory.newInstance();
		XPath xpath = factory.newXPath();
		try {
			Node node = (Node) xpath.evaluate("Envelope/Body/DoVoidResponse", document, XPathConstants.NODE);
			return new DoVoidResponseType(node);
		} catch (XPathExpressionException exe) {
			throw new RuntimeException("Unable to parse response", exe);
		}
	 }
	 
	/** 
	 * AUTO_GENERATED
	 * @throws SSLConfigurationException
	 * @throws InvalidCredentialException
	 * @throws UnsupportedEncodingException
	 * @throws IOException
	 * @throws HttpErrorException
	 * @throws InvalidResponseDataException
	 * @throws ClientActionRequiredException
	 * @throws MissingCredentialException
	 * @throws InterruptedException
	 * @throws OAuthException
	 */
	 public DoVoidResponseType doVoid(DoVoidReq doVoidReq) throws SSLConfigurationException, InvalidCredentialException, IOException, HttpErrorException, InvalidResponseDataException, ClientActionRequiredException, MissingCredentialException, InterruptedException, OAuthException, ParserConfigurationException, SAXException  {
	 	return doVoid(doVoidReq, (String) null);
	 }

	/** 
	 * AUTO_GENERATED
	 * @throws SSLConfigurationException
	 * @throws InvalidCredentialException
	 * @throws UnsupportedEncodingException
	 * @throws IOException
	 * @throws HttpErrorException
	 * @throws InvalidResponseDataException
	 * @throws ClientActionRequiredException
	 * @throws MissingCredentialException
	 * @throws InterruptedException
	 * @throws OAuthException
	 */
	 public DoVoidResponseType doVoid(DoVoidReq doVoidReq, ICredential credential) throws SSLConfigurationException, InvalidCredentialException, IOException, HttpErrorException, InvalidResponseDataException, ClientActionRequiredException, MissingCredentialException, InterruptedException, OAuthException, ParserConfigurationException, SAXException  {
	 	APICallPreHandler apiCallPreHandler = null;
	 	String portName = "PayPalAPIAA";
		setStandardParams(doVoidReq.getDoVoidRequest());
		DefaultSOAPAPICallHandler defaultHandler = new DefaultSOAPAPICallHandler(doVoidReq.toXMLString(null, "DoVoidReq"), null, null);
		apiCallPreHandler = new MerchantAPICallPreHandler(defaultHandler, credential);
		((MerchantAPICallPreHandler) apiCallPreHandler).setSdkName(SDK_NAME);
		((MerchantAPICallPreHandler) apiCallPreHandler).setSdkVersion(SDK_VERSION);
		((MerchantAPICallPreHandler) apiCallPreHandler).setPortName(portName);
	 	String response = call(apiCallPreHandler);
 	
		DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = builderFactory.newDocumentBuilder();
		InputSource inStream = new InputSource();
		inStream.setCharacterStream(new StringReader((String) response));
		Document document = builder.parse(inStream);
		XPathFactory factory = XPathFactory.newInstance();
		XPath xpath = factory.newXPath();
		try {
			Node node = (Node) xpath.evaluate(
					"Envelope/Body/DoVoidResponse", document,
					XPathConstants.NODE);
			return new DoVoidResponseType(node);
		} catch (XPathExpressionException exe) {
			throw new RuntimeException("Unable to parse response", exe);
		}	
	}
	/**	
	 * AUTO_GENERATED
	 * @throws SSLConfigurationException
	 * @throws InvalidCredentialException
	 * @throws UnsupportedEncodingException
	 * @throws IOException
	 * @throws HttpErrorException
	 * @throws InvalidResponseDataException
	 * @throws ClientActionRequiredException
	 * @throws MissingCredentialException
	 * @throws InterruptedException
	 * @throws OAuthException
	 */
	 public DoAuthorizationResponseType doAuthorization(DoAuthorizationReq doAuthorizationReq, String apiUsername) throws SSLConfigurationException, InvalidCredentialException, IOException, HttpErrorException, InvalidResponseDataException, ClientActionRequiredException, MissingCredentialException, InterruptedException, OAuthException, ParserConfigurationException, SAXException, IOException {
	 	APICallPreHandler apiCallPreHandler = null;
	 	String portName = "PayPalAPIAA";
		setStandardParams(doAuthorizationReq.getDoAuthorizationRequest());
		DefaultSOAPAPICallHandler defaultHandler = new DefaultSOAPAPICallHandler(doAuthorizationReq.toXMLString(null, "DoAuthorizationReq"), null, null);
		apiCallPreHandler = new MerchantAPICallPreHandler(defaultHandler, apiUsername, getAccessToken(), getTokenSecret());
		((MerchantAPICallPreHandler) apiCallPreHandler).setSdkName(SDK_NAME);
		((MerchantAPICallPreHandler) apiCallPreHandler).setSdkVersion(SDK_VERSION);
		((MerchantAPICallPreHandler) apiCallPreHandler).setPortName(portName);
	 	String response = call(apiCallPreHandler);
		DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = builderFactory.newDocumentBuilder();
		InputSource inStream = new InputSource();
		inStream.setCharacterStream(new StringReader((String) response));
		Document document = builder.parse(inStream);
		XPathFactory factory = XPathFactory.newInstance();
		XPath xpath = factory.newXPath();
		try {
			Node node = (Node) xpath.evaluate("Envelope/Body/DoAuthorizationResponse", document, XPathConstants.NODE);
			return new DoAuthorizationResponseType(node);
		} catch (XPathExpressionException exe) {
			throw new RuntimeException("Unable to parse response", exe);
		}
	 }
	 
	/** 
	 * AUTO_GENERATED
	 * @throws SSLConfigurationException
	 * @throws InvalidCredentialException
	 * @throws UnsupportedEncodingException
	 * @throws IOException
	 * @throws HttpErrorException
	 * @throws InvalidResponseDataException
	 * @throws ClientActionRequiredException
	 * @throws MissingCredentialException
	 * @throws InterruptedException
	 * @throws OAuthException
	 */
	 public DoAuthorizationResponseType doAuthorization(DoAuthorizationReq doAuthorizationReq) throws SSLConfigurationException, InvalidCredentialException, IOException, HttpErrorException, InvalidResponseDataException, ClientActionRequiredException, MissingCredentialException, InterruptedException, OAuthException, ParserConfigurationException, SAXException  {
	 	return doAuthorization(doAuthorizationReq, (String) null);
	 }

	/** 
	 * AUTO_GENERATED
	 * @throws SSLConfigurationException
	 * @throws InvalidCredentialException
	 * @throws UnsupportedEncodingException
	 * @throws IOException
	 * @throws HttpErrorException
	 * @throws InvalidResponseDataException
	 * @throws ClientActionRequiredException
	 * @throws MissingCredentialException
	 * @throws InterruptedException
	 * @throws OAuthException
	 */
	 public DoAuthorizationResponseType doAuthorization(DoAuthorizationReq doAuthorizationReq, ICredential credential) throws SSLConfigurationException, InvalidCredentialException, IOException, HttpErrorException, InvalidResponseDataException, ClientActionRequiredException, MissingCredentialException, InterruptedException, OAuthException, ParserConfigurationException, SAXException  {
	 	APICallPreHandler apiCallPreHandler = null;
	 	String portName = "PayPalAPIAA";
		setStandardParams(doAuthorizationReq.getDoAuthorizationRequest());
		DefaultSOAPAPICallHandler defaultHandler = new DefaultSOAPAPICallHandler(doAuthorizationReq.toXMLString(null, "DoAuthorizationReq"), null, null);
		apiCallPreHandler = new MerchantAPICallPreHandler(defaultHandler, credential);
		((MerchantAPICallPreHandler) apiCallPreHandler).setSdkName(SDK_NAME);
		((MerchantAPICallPreHandler) apiCallPreHandler).setSdkVersion(SDK_VERSION);
		((MerchantAPICallPreHandler) apiCallPreHandler).setPortName(portName);
	 	String response = call(apiCallPreHandler);
 	
		DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = builderFactory.newDocumentBuilder();
		InputSource inStream = new InputSource();
		inStream.setCharacterStream(new StringReader((String) response));
		Document document = builder.parse(inStream);
		XPathFactory factory = XPathFactory.newInstance();
		XPath xpath = factory.newXPath();
		try {
			Node node = (Node) xpath.evaluate(
					"Envelope/Body/DoAuthorizationResponse", document,
					XPathConstants.NODE);
			return new DoAuthorizationResponseType(node);
		} catch (XPathExpressionException exe) {
			throw new RuntimeException("Unable to parse response", exe);
		}	
	}
	/**	
	 * AUTO_GENERATED
	 * @throws SSLConfigurationException
	 * @throws InvalidCredentialException
	 * @throws UnsupportedEncodingException
	 * @throws IOException
	 * @throws HttpErrorException
	 * @throws InvalidResponseDataException
	 * @throws ClientActionRequiredException
	 * @throws MissingCredentialException
	 * @throws InterruptedException
	 * @throws OAuthException
	 */
	 public SetCustomerBillingAgreementResponseType setCustomerBillingAgreement(SetCustomerBillingAgreementReq setCustomerBillingAgreementReq, String apiUsername) throws SSLConfigurationException, InvalidCredentialException, IOException, HttpErrorException, InvalidResponseDataException, ClientActionRequiredException, MissingCredentialException, InterruptedException, OAuthException, ParserConfigurationException, SAXException, IOException {
	 	APICallPreHandler apiCallPreHandler = null;
	 	String portName = "PayPalAPIAA";
		setStandardParams(setCustomerBillingAgreementReq.getSetCustomerBillingAgreementRequest());
		DefaultSOAPAPICallHandler defaultHandler = new DefaultSOAPAPICallHandler(setCustomerBillingAgreementReq.toXMLString(null, "SetCustomerBillingAgreementReq"), null, null);
		apiCallPreHandler = new MerchantAPICallPreHandler(defaultHandler, apiUsername, getAccessToken(), getTokenSecret());
		((MerchantAPICallPreHandler) apiCallPreHandler).setSdkName(SDK_NAME);
		((MerchantAPICallPreHandler) apiCallPreHandler).setSdkVersion(SDK_VERSION);
		((MerchantAPICallPreHandler) apiCallPreHandler).setPortName(portName);
	 	String response = call(apiCallPreHandler);
		DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = builderFactory.newDocumentBuilder();
		InputSource inStream = new InputSource();
		inStream.setCharacterStream(new StringReader((String) response));
		Document document = builder.parse(inStream);
		XPathFactory factory = XPathFactory.newInstance();
		XPath xpath = factory.newXPath();
		try {
			Node node = (Node) xpath.evaluate("Envelope/Body/SetCustomerBillingAgreementResponse", document, XPathConstants.NODE);
			return new SetCustomerBillingAgreementResponseType(node);
		} catch (XPathExpressionException exe) {
			throw new RuntimeException("Unable to parse response", exe);
		}
	 }
	 
	/** 
	 * AUTO_GENERATED
	 * @throws SSLConfigurationException
	 * @throws InvalidCredentialException
	 * @throws UnsupportedEncodingException
	 * @throws IOException
	 * @throws HttpErrorException
	 * @throws InvalidResponseDataException
	 * @throws ClientActionRequiredException
	 * @throws MissingCredentialException
	 * @throws InterruptedException
	 * @throws OAuthException
	 */
	 public SetCustomerBillingAgreementResponseType setCustomerBillingAgreement(SetCustomerBillingAgreementReq setCustomerBillingAgreementReq) throws SSLConfigurationException, InvalidCredentialException, IOException, HttpErrorException, InvalidResponseDataException, ClientActionRequiredException, MissingCredentialException, InterruptedException, OAuthException, ParserConfigurationException, SAXException  {
	 	return setCustomerBillingAgreement(setCustomerBillingAgreementReq, (String) null);
	 }

	/** 
	 * AUTO_GENERATED
	 * @throws SSLConfigurationException
	 * @throws InvalidCredentialException
	 * @throws UnsupportedEncodingException
	 * @throws IOException
	 * @throws HttpErrorException
	 * @throws InvalidResponseDataException
	 * @throws ClientActionRequiredException
	 * @throws MissingCredentialException
	 * @throws InterruptedException
	 * @throws OAuthException
	 */
	 public SetCustomerBillingAgreementResponseType setCustomerBillingAgreement(SetCustomerBillingAgreementReq setCustomerBillingAgreementReq, ICredential credential) throws SSLConfigurationException, InvalidCredentialException, IOException, HttpErrorException, InvalidResponseDataException, ClientActionRequiredException, MissingCredentialException, InterruptedException, OAuthException, ParserConfigurationException, SAXException  {
	 	APICallPreHandler apiCallPreHandler = null;
	 	String portName = "PayPalAPIAA";
		setStandardParams(setCustomerBillingAgreementReq.getSetCustomerBillingAgreementRequest());
		DefaultSOAPAPICallHandler defaultHandler = new DefaultSOAPAPICallHandler(setCustomerBillingAgreementReq.toXMLString(null, "SetCustomerBillingAgreementReq"), null, null);
		apiCallPreHandler = new MerchantAPICallPreHandler(defaultHandler, credential);
		((MerchantAPICallPreHandler) apiCallPreHandler).setSdkName(SDK_NAME);
		((MerchantAPICallPreHandler) apiCallPreHandler).setSdkVersion(SDK_VERSION);
		((MerchantAPICallPreHandler) apiCallPreHandler).setPortName(portName);
	 	String response = call(apiCallPreHandler);
 	
		DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = builderFactory.newDocumentBuilder();
		InputSource inStream = new InputSource();
		inStream.setCharacterStream(new StringReader((String) response));
		Document document = builder.parse(inStream);
		XPathFactory factory = XPathFactory.newInstance();
		XPath xpath = factory.newXPath();
		try {
			Node node = (Node) xpath.evaluate(
					"Envelope/Body/SetCustomerBillingAgreementResponse", document,
					XPathConstants.NODE);
			return new SetCustomerBillingAgreementResponseType(node);
		} catch (XPathExpressionException exe) {
			throw new RuntimeException("Unable to parse response", exe);
		}	
	}
	/**	
	 * AUTO_GENERATED
	 * @throws SSLConfigurationException
	 * @throws InvalidCredentialException
	 * @throws UnsupportedEncodingException
	 * @throws IOException
	 * @throws HttpErrorException
	 * @throws InvalidResponseDataException
	 * @throws ClientActionRequiredException
	 * @throws MissingCredentialException
	 * @throws InterruptedException
	 * @throws OAuthException
	 */
	 public GetBillingAgreementCustomerDetailsResponseType getBillingAgreementCustomerDetails(GetBillingAgreementCustomerDetailsReq getBillingAgreementCustomerDetailsReq, String apiUsername) throws SSLConfigurationException, InvalidCredentialException, IOException, HttpErrorException, InvalidResponseDataException, ClientActionRequiredException, MissingCredentialException, InterruptedException, OAuthException, ParserConfigurationException, SAXException, IOException {
	 	APICallPreHandler apiCallPreHandler = null;
	 	String portName = "PayPalAPIAA";
		setStandardParams(getBillingAgreementCustomerDetailsReq.getGetBillingAgreementCustomerDetailsRequest());
		DefaultSOAPAPICallHandler defaultHandler = new DefaultSOAPAPICallHandler(getBillingAgreementCustomerDetailsReq.toXMLString(null, "GetBillingAgreementCustomerDetailsReq"), null, null);
		apiCallPreHandler = new MerchantAPICallPreHandler(defaultHandler, apiUsername, getAccessToken(), getTokenSecret());
		((MerchantAPICallPreHandler) apiCallPreHandler).setSdkName(SDK_NAME);
		((MerchantAPICallPreHandler) apiCallPreHandler).setSdkVersion(SDK_VERSION);
		((MerchantAPICallPreHandler) apiCallPreHandler).setPortName(portName);
	 	String response = call(apiCallPreHandler);
		DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = builderFactory.newDocumentBuilder();
		InputSource inStream = new InputSource();
		inStream.setCharacterStream(new StringReader((String) response));
		Document document = builder.parse(inStream);
		XPathFactory factory = XPathFactory.newInstance();
		XPath xpath = factory.newXPath();
		try {
			Node node = (Node) xpath.evaluate("Envelope/Body/GetBillingAgreementCustomerDetailsResponse", document, XPathConstants.NODE);
			return new GetBillingAgreementCustomerDetailsResponseType(node);
		} catch (XPathExpressionException exe) {
			throw new RuntimeException("Unable to parse response", exe);
		}
	 }
	 
	/** 
	 * AUTO_GENERATED
	 * @throws SSLConfigurationException
	 * @throws InvalidCredentialException
	 * @throws UnsupportedEncodingException
	 * @throws IOException
	 * @throws HttpErrorException
	 * @throws InvalidResponseDataException
	 * @throws ClientActionRequiredException
	 * @throws MissingCredentialException
	 * @throws InterruptedException
	 * @throws OAuthException
	 */
	 public GetBillingAgreementCustomerDetailsResponseType getBillingAgreementCustomerDetails(GetBillingAgreementCustomerDetailsReq getBillingAgreementCustomerDetailsReq) throws SSLConfigurationException, InvalidCredentialException, IOException, HttpErrorException, InvalidResponseDataException, ClientActionRequiredException, MissingCredentialException, InterruptedException, OAuthException, ParserConfigurationException, SAXException  {
	 	return getBillingAgreementCustomerDetails(getBillingAgreementCustomerDetailsReq, (String) null);
	 }

	/** 
	 * AUTO_GENERATED
	 * @throws SSLConfigurationException
	 * @throws InvalidCredentialException
	 * @throws UnsupportedEncodingException
	 * @throws IOException
	 * @throws HttpErrorException
	 * @throws InvalidResponseDataException
	 * @throws ClientActionRequiredException
	 * @throws MissingCredentialException
	 * @throws InterruptedException
	 * @throws OAuthException
	 */
	 public GetBillingAgreementCustomerDetailsResponseType getBillingAgreementCustomerDetails(GetBillingAgreementCustomerDetailsReq getBillingAgreementCustomerDetailsReq, ICredential credential) throws SSLConfigurationException, InvalidCredentialException, IOException, HttpErrorException, InvalidResponseDataException, ClientActionRequiredException, MissingCredentialException, InterruptedException, OAuthException, ParserConfigurationException, SAXException  {
	 	APICallPreHandler apiCallPreHandler = null;
	 	String portName = "PayPalAPIAA";
		setStandardParams(getBillingAgreementCustomerDetailsReq.getGetBillingAgreementCustomerDetailsRequest());
		DefaultSOAPAPICallHandler defaultHandler = new DefaultSOAPAPICallHandler(getBillingAgreementCustomerDetailsReq.toXMLString(null, "GetBillingAgreementCustomerDetailsReq"), null, null);
		apiCallPreHandler = new MerchantAPICallPreHandler(defaultHandler, credential);
		((MerchantAPICallPreHandler) apiCallPreHandler).setSdkName(SDK_NAME);
		((MerchantAPICallPreHandler) apiCallPreHandler).setSdkVersion(SDK_VERSION);
		((MerchantAPICallPreHandler) apiCallPreHandler).setPortName(portName);
	 	String response = call(apiCallPreHandler);
 	
		DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = builderFactory.newDocumentBuilder();
		InputSource inStream = new InputSource();
		inStream.setCharacterStream(new StringReader((String) response));
		Document document = builder.parse(inStream);
		XPathFactory factory = XPathFactory.newInstance();
		XPath xpath = factory.newXPath();
		try {
			Node node = (Node) xpath.evaluate(
					"Envelope/Body/GetBillingAgreementCustomerDetailsResponse", document,
					XPathConstants.NODE);
			return new GetBillingAgreementCustomerDetailsResponseType(node);
		} catch (XPathExpressionException exe) {
			throw new RuntimeException("Unable to parse response", exe);
		}	
	}
	/**	
	 * AUTO_GENERATED
	 * @throws SSLConfigurationException
	 * @throws InvalidCredentialException
	 * @throws UnsupportedEncodingException
	 * @throws IOException
	 * @throws HttpErrorException
	 * @throws InvalidResponseDataException
	 * @throws ClientActionRequiredException
	 * @throws MissingCredentialException
	 * @throws InterruptedException
	 * @throws OAuthException
	 */
	 public CreateBillingAgreementResponseType createBillingAgreement(CreateBillingAgreementReq createBillingAgreementReq, String apiUsername) throws SSLConfigurationException, InvalidCredentialException, IOException, HttpErrorException, InvalidResponseDataException, ClientActionRequiredException, MissingCredentialException, InterruptedException, OAuthException, ParserConfigurationException, SAXException, IOException {
	 	APICallPreHandler apiCallPreHandler = null;
	 	String portName = "PayPalAPIAA";
		setStandardParams(createBillingAgreementReq.getCreateBillingAgreementRequest());
		DefaultSOAPAPICallHandler defaultHandler = new DefaultSOAPAPICallHandler(createBillingAgreementReq.toXMLString(null, "CreateBillingAgreementReq"), null, null);
		apiCallPreHandler = new MerchantAPICallPreHandler(defaultHandler, apiUsername, getAccessToken(), getTokenSecret());
		((MerchantAPICallPreHandler) apiCallPreHandler).setSdkName(SDK_NAME);
		((MerchantAPICallPreHandler) apiCallPreHandler).setSdkVersion(SDK_VERSION);
		((MerchantAPICallPreHandler) apiCallPreHandler).setPortName(portName);
	 	String response = call(apiCallPreHandler);
		DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = builderFactory.newDocumentBuilder();
		InputSource inStream = new InputSource();
		inStream.setCharacterStream(new StringReader((String) response));
		Document document = builder.parse(inStream);
		XPathFactory factory = XPathFactory.newInstance();
		XPath xpath = factory.newXPath();
		try {
			Node node = (Node) xpath.evaluate("Envelope/Body/CreateBillingAgreementResponse", document, XPathConstants.NODE);
			return new CreateBillingAgreementResponseType(node);
		} catch (XPathExpressionException exe) {
			throw new RuntimeException("Unable to parse response", exe);
		}
	 }
	 
	/** 
	 * AUTO_GENERATED
	 * @throws SSLConfigurationException
	 * @throws InvalidCredentialException
	 * @throws UnsupportedEncodingException
	 * @throws IOException
	 * @throws HttpErrorException
	 * @throws InvalidResponseDataException
	 * @throws ClientActionRequiredException
	 * @throws MissingCredentialException
	 * @throws InterruptedException
	 * @throws OAuthException
	 */
	 public CreateBillingAgreementResponseType createBillingAgreement(CreateBillingAgreementReq createBillingAgreementReq) throws SSLConfigurationException, InvalidCredentialException, IOException, HttpErrorException, InvalidResponseDataException, ClientActionRequiredException, MissingCredentialException, InterruptedException, OAuthException, ParserConfigurationException, SAXException  {
	 	return createBillingAgreement(createBillingAgreementReq, (String) null);
	 }

	/** 
	 * AUTO_GENERATED
	 * @throws SSLConfigurationException
	 * @throws InvalidCredentialException
	 * @throws UnsupportedEncodingException
	 * @throws IOException
	 * @throws HttpErrorException
	 * @throws InvalidResponseDataException
	 * @throws ClientActionRequiredException
	 * @throws MissingCredentialException
	 * @throws InterruptedException
	 * @throws OAuthException
	 */
	 public CreateBillingAgreementResponseType createBillingAgreement(CreateBillingAgreementReq createBillingAgreementReq, ICredential credential) throws SSLConfigurationException, InvalidCredentialException, IOException, HttpErrorException, InvalidResponseDataException, ClientActionRequiredException, MissingCredentialException, InterruptedException, OAuthException, ParserConfigurationException, SAXException  {
	 	APICallPreHandler apiCallPreHandler = null;
	 	String portName = "PayPalAPIAA";
		setStandardParams(createBillingAgreementReq.getCreateBillingAgreementRequest());
		DefaultSOAPAPICallHandler defaultHandler = new DefaultSOAPAPICallHandler(createBillingAgreementReq.toXMLString(null, "CreateBillingAgreementReq"), null, null);
		apiCallPreHandler = new MerchantAPICallPreHandler(defaultHandler, credential);
		((MerchantAPICallPreHandler) apiCallPreHandler).setSdkName(SDK_NAME);
		((MerchantAPICallPreHandler) apiCallPreHandler).setSdkVersion(SDK_VERSION);
		((MerchantAPICallPreHandler) apiCallPreHandler).setPortName(portName);
	 	String response = call(apiCallPreHandler);
 	
		DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = builderFactory.newDocumentBuilder();
		InputSource inStream = new InputSource();
		inStream.setCharacterStream(new StringReader((String) response));
		Document document = builder.parse(inStream);
		XPathFactory factory = XPathFactory.newInstance();
		XPath xpath = factory.newXPath();
		try {
			Node node = (Node) xpath.evaluate(
					"Envelope/Body/CreateBillingAgreementResponse", document,
					XPathConstants.NODE);
			return new CreateBillingAgreementResponseType(node);
		} catch (XPathExpressionException exe) {
			throw new RuntimeException("Unable to parse response", exe);
		}	
	}
	/**	
	 * AUTO_GENERATED
	 * @throws SSLConfigurationException
	 * @throws InvalidCredentialException
	 * @throws UnsupportedEncodingException
	 * @throws IOException
	 * @throws HttpErrorException
	 * @throws InvalidResponseDataException
	 * @throws ClientActionRequiredException
	 * @throws MissingCredentialException
	 * @throws InterruptedException
	 * @throws OAuthException
	 */
	 public DoReferenceTransactionResponseType doReferenceTransaction(DoReferenceTransactionReq doReferenceTransactionReq, String apiUsername) throws SSLConfigurationException, InvalidCredentialException, IOException, HttpErrorException, InvalidResponseDataException, ClientActionRequiredException, MissingCredentialException, InterruptedException, OAuthException, ParserConfigurationException, SAXException, IOException {
	 	APICallPreHandler apiCallPreHandler = null;
	 	String portName = "PayPalAPIAA";
		setStandardParams(doReferenceTransactionReq.getDoReferenceTransactionRequest());
		DefaultSOAPAPICallHandler defaultHandler = new DefaultSOAPAPICallHandler(doReferenceTransactionReq.toXMLString(null, "DoReferenceTransactionReq"), null, null);
		apiCallPreHandler = new MerchantAPICallPreHandler(defaultHandler, apiUsername, getAccessToken(), getTokenSecret());
		((MerchantAPICallPreHandler) apiCallPreHandler).setSdkName(SDK_NAME);
		((MerchantAPICallPreHandler) apiCallPreHandler).setSdkVersion(SDK_VERSION);
		((MerchantAPICallPreHandler) apiCallPreHandler).setPortName(portName);
	 	String response = call(apiCallPreHandler);
		DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = builderFactory.newDocumentBuilder();
		InputSource inStream = new InputSource();
		inStream.setCharacterStream(new StringReader((String) response));
		Document document = builder.parse(inStream);
		XPathFactory factory = XPathFactory.newInstance();
		XPath xpath = factory.newXPath();
		try {
			Node node = (Node) xpath.evaluate("Envelope/Body/DoReferenceTransactionResponse", document, XPathConstants.NODE);
			return new DoReferenceTransactionResponseType(node);
		} catch (XPathExpressionException exe) {
			throw new RuntimeException("Unable to parse response", exe);
		}
	 }
	 
	/** 
	 * AUTO_GENERATED
	 * @throws SSLConfigurationException
	 * @throws InvalidCredentialException
	 * @throws UnsupportedEncodingException
	 * @throws IOException
	 * @throws HttpErrorException
	 * @throws InvalidResponseDataException
	 * @throws ClientActionRequiredException
	 * @throws MissingCredentialException
	 * @throws InterruptedException
	 * @throws OAuthException
	 */
	 public DoReferenceTransactionResponseType doReferenceTransaction(DoReferenceTransactionReq doReferenceTransactionReq) throws SSLConfigurationException, InvalidCredentialException, IOException, HttpErrorException, InvalidResponseDataException, ClientActionRequiredException, MissingCredentialException, InterruptedException, OAuthException, ParserConfigurationException, SAXException  {
	 	return doReferenceTransaction(doReferenceTransactionReq, (String) null);
	 }

	/** 
	 * AUTO_GENERATED
	 * @throws SSLConfigurationException
	 * @throws InvalidCredentialException
	 * @throws UnsupportedEncodingException
	 * @throws IOException
	 * @throws HttpErrorException
	 * @throws InvalidResponseDataException
	 * @throws ClientActionRequiredException
	 * @throws MissingCredentialException
	 * @throws InterruptedException
	 * @throws OAuthException
	 */
	 public DoReferenceTransactionResponseType doReferenceTransaction(DoReferenceTransactionReq doReferenceTransactionReq, ICredential credential) throws SSLConfigurationException, InvalidCredentialException, IOException, HttpErrorException, InvalidResponseDataException, ClientActionRequiredException, MissingCredentialException, InterruptedException, OAuthException, ParserConfigurationException, SAXException  {
	 	APICallPreHandler apiCallPreHandler = null;
	 	String portName = "PayPalAPIAA";
		setStandardParams(doReferenceTransactionReq.getDoReferenceTransactionRequest());
		DefaultSOAPAPICallHandler defaultHandler = new DefaultSOAPAPICallHandler(doReferenceTransactionReq.toXMLString(null, "DoReferenceTransactionReq"), null, null);
		apiCallPreHandler = new MerchantAPICallPreHandler(defaultHandler, credential);
		((MerchantAPICallPreHandler) apiCallPreHandler).setSdkName(SDK_NAME);
		((MerchantAPICallPreHandler) apiCallPreHandler).setSdkVersion(SDK_VERSION);
		((MerchantAPICallPreHandler) apiCallPreHandler).setPortName(portName);
	 	String response = call(apiCallPreHandler);
 	
		DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = builderFactory.newDocumentBuilder();
		InputSource inStream = new InputSource();
		inStream.setCharacterStream(new StringReader((String) response));
		Document document = builder.parse(inStream);
		XPathFactory factory = XPathFactory.newInstance();
		XPath xpath = factory.newXPath();
		try {
			Node node = (Node) xpath.evaluate(
					"Envelope/Body/DoReferenceTransactionResponse", document,
					XPathConstants.NODE);
			return new DoReferenceTransactionResponseType(node);
		} catch (XPathExpressionException exe) {
			throw new RuntimeException("Unable to parse response", exe);
		}	
	}
	/**	
	 * AUTO_GENERATED
	 * @throws SSLConfigurationException
	 * @throws InvalidCredentialException
	 * @throws UnsupportedEncodingException
	 * @throws IOException
	 * @throws HttpErrorException
	 * @throws InvalidResponseDataException
	 * @throws ClientActionRequiredException
	 * @throws MissingCredentialException
	 * @throws InterruptedException
	 * @throws OAuthException
	 */
	 public DoNonReferencedCreditResponseType doNonReferencedCredit(DoNonReferencedCreditReq doNonReferencedCreditReq, String apiUsername) throws SSLConfigurationException, InvalidCredentialException, IOException, HttpErrorException, InvalidResponseDataException, ClientActionRequiredException, MissingCredentialException, InterruptedException, OAuthException, ParserConfigurationException, SAXException, IOException {
	 	APICallPreHandler apiCallPreHandler = null;
	 	String portName = "PayPalAPIAA";
		setStandardParams(doNonReferencedCreditReq.getDoNonReferencedCreditRequest());
		DefaultSOAPAPICallHandler defaultHandler = new DefaultSOAPAPICallHandler(doNonReferencedCreditReq.toXMLString(null, "DoNonReferencedCreditReq"), null, null);
		apiCallPreHandler = new MerchantAPICallPreHandler(defaultHandler, apiUsername, getAccessToken(), getTokenSecret());
		((MerchantAPICallPreHandler) apiCallPreHandler).setSdkName(SDK_NAME);
		((MerchantAPICallPreHandler) apiCallPreHandler).setSdkVersion(SDK_VERSION);
		((MerchantAPICallPreHandler) apiCallPreHandler).setPortName(portName);
	 	String response = call(apiCallPreHandler);
		DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = builderFactory.newDocumentBuilder();
		InputSource inStream = new InputSource();
		inStream.setCharacterStream(new StringReader((String) response));
		Document document = builder.parse(inStream);
		XPathFactory factory = XPathFactory.newInstance();
		XPath xpath = factory.newXPath();
		try {
			Node node = (Node) xpath.evaluate("Envelope/Body/DoNonReferencedCreditResponse", document, XPathConstants.NODE);
			return new DoNonReferencedCreditResponseType(node);
		} catch (XPathExpressionException exe) {
			throw new RuntimeException("Unable to parse response", exe);
		}
	 }
	 
	/** 
	 * AUTO_GENERATED
	 * @throws SSLConfigurationException
	 * @throws InvalidCredentialException
	 * @throws UnsupportedEncodingException
	 * @throws IOException
	 * @throws HttpErrorException
	 * @throws InvalidResponseDataException
	 * @throws ClientActionRequiredException
	 * @throws MissingCredentialException
	 * @throws InterruptedException
	 * @throws OAuthException
	 */
	 public DoNonReferencedCreditResponseType doNonReferencedCredit(DoNonReferencedCreditReq doNonReferencedCreditReq) throws SSLConfigurationException, InvalidCredentialException, IOException, HttpErrorException, InvalidResponseDataException, ClientActionRequiredException, MissingCredentialException, InterruptedException, OAuthException, ParserConfigurationException, SAXException  {
	 	return doNonReferencedCredit(doNonReferencedCreditReq, (String) null);
	 }

	/** 
	 * AUTO_GENERATED
	 * @throws SSLConfigurationException
	 * @throws InvalidCredentialException
	 * @throws UnsupportedEncodingException
	 * @throws IOException
	 * @throws HttpErrorException
	 * @throws InvalidResponseDataException
	 * @throws ClientActionRequiredException
	 * @throws MissingCredentialException
	 * @throws InterruptedException
	 * @throws OAuthException
	 */
	 public DoNonReferencedCreditResponseType doNonReferencedCredit(DoNonReferencedCreditReq doNonReferencedCreditReq, ICredential credential) throws SSLConfigurationException, InvalidCredentialException, IOException, HttpErrorException, InvalidResponseDataException, ClientActionRequiredException, MissingCredentialException, InterruptedException, OAuthException, ParserConfigurationException, SAXException  {
	 	APICallPreHandler apiCallPreHandler = null;
	 	String portName = "PayPalAPIAA";
		setStandardParams(doNonReferencedCreditReq.getDoNonReferencedCreditRequest());
		DefaultSOAPAPICallHandler defaultHandler = new DefaultSOAPAPICallHandler(doNonReferencedCreditReq.toXMLString(null, "DoNonReferencedCreditReq"), null, null);
		apiCallPreHandler = new MerchantAPICallPreHandler(defaultHandler, credential);
		((MerchantAPICallPreHandler) apiCallPreHandler).setSdkName(SDK_NAME);
		((MerchantAPICallPreHandler) apiCallPreHandler).setSdkVersion(SDK_VERSION);
		((MerchantAPICallPreHandler) apiCallPreHandler).setPortName(portName);
	 	String response = call(apiCallPreHandler);
 	
		DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = builderFactory.newDocumentBuilder();
		InputSource inStream = new InputSource();
		inStream.setCharacterStream(new StringReader((String) response));
		Document document = builder.parse(inStream);
		XPathFactory factory = XPathFactory.newInstance();
		XPath xpath = factory.newXPath();
		try {
			Node node = (Node) xpath.evaluate(
					"Envelope/Body/DoNonReferencedCreditResponse", document,
					XPathConstants.NODE);
			return new DoNonReferencedCreditResponseType(node);
		} catch (XPathExpressionException exe) {
			throw new RuntimeException("Unable to parse response", exe);
		}	
	}
	/**	
	 * AUTO_GENERATED
	 * @throws SSLConfigurationException
	 * @throws InvalidCredentialException
	 * @throws UnsupportedEncodingException
	 * @throws IOException
	 * @throws HttpErrorException
	 * @throws InvalidResponseDataException
	 * @throws ClientActionRequiredException
	 * @throws MissingCredentialException
	 * @throws InterruptedException
	 * @throws OAuthException
	 */
	 public DoUATPAuthorizationResponseType doUATPAuthorization(DoUATPAuthorizationReq doUATPAuthorizationReq, String apiUsername) throws SSLConfigurationException, InvalidCredentialException, IOException, HttpErrorException, InvalidResponseDataException, ClientActionRequiredException, MissingCredentialException, InterruptedException, OAuthException, ParserConfigurationException, SAXException, IOException {
	 	APICallPreHandler apiCallPreHandler = null;
	 	String portName = "PayPalAPIAA";
		setStandardParams(doUATPAuthorizationReq.getDoUATPAuthorizationRequest());
		DefaultSOAPAPICallHandler defaultHandler = new DefaultSOAPAPICallHandler(doUATPAuthorizationReq.toXMLString(null, "DoUATPAuthorizationReq"), null, null);
		apiCallPreHandler = new MerchantAPICallPreHandler(defaultHandler, apiUsername, getAccessToken(), getTokenSecret());
		((MerchantAPICallPreHandler) apiCallPreHandler).setSdkName(SDK_NAME);
		((MerchantAPICallPreHandler) apiCallPreHandler).setSdkVersion(SDK_VERSION);
		((MerchantAPICallPreHandler) apiCallPreHandler).setPortName(portName);
	 	String response = call(apiCallPreHandler);
		DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = builderFactory.newDocumentBuilder();
		InputSource inStream = new InputSource();
		inStream.setCharacterStream(new StringReader((String) response));
		Document document = builder.parse(inStream);
		XPathFactory factory = XPathFactory.newInstance();
		XPath xpath = factory.newXPath();
		try {
			Node node = (Node) xpath.evaluate("Envelope/Body/DoUATPAuthorizationResponse", document, XPathConstants.NODE);
			return new DoUATPAuthorizationResponseType(node);
		} catch (XPathExpressionException exe) {
			throw new RuntimeException("Unable to parse response", exe);
		}
	 }
	 
	/** 
	 * AUTO_GENERATED
	 * @throws SSLConfigurationException
	 * @throws InvalidCredentialException
	 * @throws UnsupportedEncodingException
	 * @throws IOException
	 * @throws HttpErrorException
	 * @throws InvalidResponseDataException
	 * @throws ClientActionRequiredException
	 * @throws MissingCredentialException
	 * @throws InterruptedException
	 * @throws OAuthException
	 */
	 public DoUATPAuthorizationResponseType doUATPAuthorization(DoUATPAuthorizationReq doUATPAuthorizationReq) throws SSLConfigurationException, InvalidCredentialException, IOException, HttpErrorException, InvalidResponseDataException, ClientActionRequiredException, MissingCredentialException, InterruptedException, OAuthException, ParserConfigurationException, SAXException  {
	 	return doUATPAuthorization(doUATPAuthorizationReq, (String) null);
	 }

	/** 
	 * AUTO_GENERATED
	 * @throws SSLConfigurationException
	 * @throws InvalidCredentialException
	 * @throws UnsupportedEncodingException
	 * @throws IOException
	 * @throws HttpErrorException
	 * @throws InvalidResponseDataException
	 * @throws ClientActionRequiredException
	 * @throws MissingCredentialException
	 * @throws InterruptedException
	 * @throws OAuthException
	 */
	 public DoUATPAuthorizationResponseType doUATPAuthorization(DoUATPAuthorizationReq doUATPAuthorizationReq, ICredential credential) throws SSLConfigurationException, InvalidCredentialException, IOException, HttpErrorException, InvalidResponseDataException, ClientActionRequiredException, MissingCredentialException, InterruptedException, OAuthException, ParserConfigurationException, SAXException  {
	 	APICallPreHandler apiCallPreHandler = null;
	 	String portName = "PayPalAPIAA";
		setStandardParams(doUATPAuthorizationReq.getDoUATPAuthorizationRequest());
		DefaultSOAPAPICallHandler defaultHandler = new DefaultSOAPAPICallHandler(doUATPAuthorizationReq.toXMLString(null, "DoUATPAuthorizationReq"), null, null);
		apiCallPreHandler = new MerchantAPICallPreHandler(defaultHandler, credential);
		((MerchantAPICallPreHandler) apiCallPreHandler).setSdkName(SDK_NAME);
		((MerchantAPICallPreHandler) apiCallPreHandler).setSdkVersion(SDK_VERSION);
		((MerchantAPICallPreHandler) apiCallPreHandler).setPortName(portName);
	 	String response = call(apiCallPreHandler);
 	
		DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = builderFactory.newDocumentBuilder();
		InputSource inStream = new InputSource();
		inStream.setCharacterStream(new StringReader((String) response));
		Document document = builder.parse(inStream);
		XPathFactory factory = XPathFactory.newInstance();
		XPath xpath = factory.newXPath();
		try {
			Node node = (Node) xpath.evaluate(
					"Envelope/Body/DoUATPAuthorizationResponse", document,
					XPathConstants.NODE);
			return new DoUATPAuthorizationResponseType(node);
		} catch (XPathExpressionException exe) {
			throw new RuntimeException("Unable to parse response", exe);
		}	
	}
	/**	
	 * AUTO_GENERATED
	 * @throws SSLConfigurationException
	 * @throws InvalidCredentialException
	 * @throws UnsupportedEncodingException
	 * @throws IOException
	 * @throws HttpErrorException
	 * @throws InvalidResponseDataException
	 * @throws ClientActionRequiredException
	 * @throws MissingCredentialException
	 * @throws InterruptedException
	 * @throws OAuthException
	 */
	 public CreateRecurringPaymentsProfileResponseType createRecurringPaymentsProfile(CreateRecurringPaymentsProfileReq createRecurringPaymentsProfileReq, String apiUsername) throws SSLConfigurationException, InvalidCredentialException, IOException, HttpErrorException, InvalidResponseDataException, ClientActionRequiredException, MissingCredentialException, InterruptedException, OAuthException, ParserConfigurationException, SAXException, IOException {
	 	APICallPreHandler apiCallPreHandler = null;
	 	String portName = "PayPalAPIAA";
		setStandardParams(createRecurringPaymentsProfileReq.getCreateRecurringPaymentsProfileRequest());
		DefaultSOAPAPICallHandler defaultHandler = new DefaultSOAPAPICallHandler(createRecurringPaymentsProfileReq.toXMLString(null, "CreateRecurringPaymentsProfileReq"), null, null);
		apiCallPreHandler = new MerchantAPICallPreHandler(defaultHandler, apiUsername, getAccessToken(), getTokenSecret());
		((MerchantAPICallPreHandler) apiCallPreHandler).setSdkName(SDK_NAME);
		((MerchantAPICallPreHandler) apiCallPreHandler).setSdkVersion(SDK_VERSION);
		((MerchantAPICallPreHandler) apiCallPreHandler).setPortName(portName);
	 	String response = call(apiCallPreHandler);
		DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = builderFactory.newDocumentBuilder();
		InputSource inStream = new InputSource();
		inStream.setCharacterStream(new StringReader((String) response));
		Document document = builder.parse(inStream);
		XPathFactory factory = XPathFactory.newInstance();
		XPath xpath = factory.newXPath();
		try {
			Node node = (Node) xpath.evaluate("Envelope/Body/CreateRecurringPaymentsProfileResponse", document, XPathConstants.NODE);
			return new CreateRecurringPaymentsProfileResponseType(node);
		} catch (XPathExpressionException exe) {
			throw new RuntimeException("Unable to parse response", exe);
		}
	 }
	 
	/** 
	 * AUTO_GENERATED
	 * @throws SSLConfigurationException
	 * @throws InvalidCredentialException
	 * @throws UnsupportedEncodingException
	 * @throws IOException
	 * @throws HttpErrorException
	 * @throws InvalidResponseDataException
	 * @throws ClientActionRequiredException
	 * @throws MissingCredentialException
	 * @throws InterruptedException
	 * @throws OAuthException
	 */
	 public CreateRecurringPaymentsProfileResponseType createRecurringPaymentsProfile(CreateRecurringPaymentsProfileReq createRecurringPaymentsProfileReq) throws SSLConfigurationException, InvalidCredentialException, IOException, HttpErrorException, InvalidResponseDataException, ClientActionRequiredException, MissingCredentialException, InterruptedException, OAuthException, ParserConfigurationException, SAXException  {
	 	return createRecurringPaymentsProfile(createRecurringPaymentsProfileReq, (String) null);
	 }

	/** 
	 * AUTO_GENERATED
	 * @throws SSLConfigurationException
	 * @throws InvalidCredentialException
	 * @throws UnsupportedEncodingException
	 * @throws IOException
	 * @throws HttpErrorException
	 * @throws InvalidResponseDataException
	 * @throws ClientActionRequiredException
	 * @throws MissingCredentialException
	 * @throws InterruptedException
	 * @throws OAuthException
	 */
	 public CreateRecurringPaymentsProfileResponseType createRecurringPaymentsProfile(CreateRecurringPaymentsProfileReq createRecurringPaymentsProfileReq, ICredential credential) throws SSLConfigurationException, InvalidCredentialException, IOException, HttpErrorException, InvalidResponseDataException, ClientActionRequiredException, MissingCredentialException, InterruptedException, OAuthException, ParserConfigurationException, SAXException  {
	 	APICallPreHandler apiCallPreHandler = null;
	 	String portName = "PayPalAPIAA";
		setStandardParams(createRecurringPaymentsProfileReq.getCreateRecurringPaymentsProfileRequest());
		DefaultSOAPAPICallHandler defaultHandler = new DefaultSOAPAPICallHandler(createRecurringPaymentsProfileReq.toXMLString(null, "CreateRecurringPaymentsProfileReq"), null, null);
		apiCallPreHandler = new MerchantAPICallPreHandler(defaultHandler, credential);
		((MerchantAPICallPreHandler) apiCallPreHandler).setSdkName(SDK_NAME);
		((MerchantAPICallPreHandler) apiCallPreHandler).setSdkVersion(SDK_VERSION);
		((MerchantAPICallPreHandler) apiCallPreHandler).setPortName(portName);
	 	String response = call(apiCallPreHandler);
 	
		DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = builderFactory.newDocumentBuilder();
		InputSource inStream = new InputSource();
		inStream.setCharacterStream(new StringReader((String) response));
		Document document = builder.parse(inStream);
		XPathFactory factory = XPathFactory.newInstance();
		XPath xpath = factory.newXPath();
		try {
			Node node = (Node) xpath.evaluate(
					"Envelope/Body/CreateRecurringPaymentsProfileResponse", document,
					XPathConstants.NODE);
			return new CreateRecurringPaymentsProfileResponseType(node);
		} catch (XPathExpressionException exe) {
			throw new RuntimeException("Unable to parse response", exe);
		}	
	}
	/**	
	 * AUTO_GENERATED
	 * @throws SSLConfigurationException
	 * @throws InvalidCredentialException
	 * @throws UnsupportedEncodingException
	 * @throws IOException
	 * @throws HttpErrorException
	 * @throws InvalidResponseDataException
	 * @throws ClientActionRequiredException
	 * @throws MissingCredentialException
	 * @throws InterruptedException
	 * @throws OAuthException
	 */
	 public GetRecurringPaymentsProfileDetailsResponseType getRecurringPaymentsProfileDetails(GetRecurringPaymentsProfileDetailsReq getRecurringPaymentsProfileDetailsReq, String apiUsername) throws SSLConfigurationException, InvalidCredentialException, IOException, HttpErrorException, InvalidResponseDataException, ClientActionRequiredException, MissingCredentialException, InterruptedException, OAuthException, ParserConfigurationException, SAXException, IOException {
	 	APICallPreHandler apiCallPreHandler = null;
	 	String portName = "PayPalAPIAA";
		setStandardParams(getRecurringPaymentsProfileDetailsReq.getGetRecurringPaymentsProfileDetailsRequest());
		DefaultSOAPAPICallHandler defaultHandler = new DefaultSOAPAPICallHandler(getRecurringPaymentsProfileDetailsReq.toXMLString(null, "GetRecurringPaymentsProfileDetailsReq"), null, null);
		apiCallPreHandler = new MerchantAPICallPreHandler(defaultHandler, apiUsername, getAccessToken(), getTokenSecret());
		((MerchantAPICallPreHandler) apiCallPreHandler).setSdkName(SDK_NAME);
		((MerchantAPICallPreHandler) apiCallPreHandler).setSdkVersion(SDK_VERSION);
		((MerchantAPICallPreHandler) apiCallPreHandler).setPortName(portName);
	 	String response = call(apiCallPreHandler);
		DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = builderFactory.newDocumentBuilder();
		InputSource inStream = new InputSource();
		inStream.setCharacterStream(new StringReader((String) response));
		Document document = builder.parse(inStream);
		XPathFactory factory = XPathFactory.newInstance();
		XPath xpath = factory.newXPath();
		try {
			Node node = (Node) xpath.evaluate("Envelope/Body/GetRecurringPaymentsProfileDetailsResponse", document, XPathConstants.NODE);
			return new GetRecurringPaymentsProfileDetailsResponseType(node);
		} catch (XPathExpressionException exe) {
			throw new RuntimeException("Unable to parse response", exe);
		}
	 }
	 
	/** 
	 * AUTO_GENERATED
	 * @throws SSLConfigurationException
	 * @throws InvalidCredentialException
	 * @throws UnsupportedEncodingException
	 * @throws IOException
	 * @throws HttpErrorException
	 * @throws InvalidResponseDataException
	 * @throws ClientActionRequiredException
	 * @throws MissingCredentialException
	 * @throws InterruptedException
	 * @throws OAuthException
	 */
	 public GetRecurringPaymentsProfileDetailsResponseType getRecurringPaymentsProfileDetails(GetRecurringPaymentsProfileDetailsReq getRecurringPaymentsProfileDetailsReq) throws SSLConfigurationException, InvalidCredentialException, IOException, HttpErrorException, InvalidResponseDataException, ClientActionRequiredException, MissingCredentialException, InterruptedException, OAuthException, ParserConfigurationException, SAXException  {
	 	return getRecurringPaymentsProfileDetails(getRecurringPaymentsProfileDetailsReq, (String) null);
	 }

	/** 
	 * AUTO_GENERATED
	 * @throws SSLConfigurationException
	 * @throws InvalidCredentialException
	 * @throws UnsupportedEncodingException
	 * @throws IOException
	 * @throws HttpErrorException
	 * @throws InvalidResponseDataException
	 * @throws ClientActionRequiredException
	 * @throws MissingCredentialException
	 * @throws InterruptedException
	 * @throws OAuthException
	 */
	 public GetRecurringPaymentsProfileDetailsResponseType getRecurringPaymentsProfileDetails(GetRecurringPaymentsProfileDetailsReq getRecurringPaymentsProfileDetailsReq, ICredential credential) throws SSLConfigurationException, InvalidCredentialException, IOException, HttpErrorException, InvalidResponseDataException, ClientActionRequiredException, MissingCredentialException, InterruptedException, OAuthException, ParserConfigurationException, SAXException  {
	 	APICallPreHandler apiCallPreHandler = null;
	 	String portName = "PayPalAPIAA";
		setStandardParams(getRecurringPaymentsProfileDetailsReq.getGetRecurringPaymentsProfileDetailsRequest());
		DefaultSOAPAPICallHandler defaultHandler = new DefaultSOAPAPICallHandler(getRecurringPaymentsProfileDetailsReq.toXMLString(null, "GetRecurringPaymentsProfileDetailsReq"), null, null);
		apiCallPreHandler = new MerchantAPICallPreHandler(defaultHandler, credential);
		((MerchantAPICallPreHandler) apiCallPreHandler).setSdkName(SDK_NAME);
		((MerchantAPICallPreHandler) apiCallPreHandler).setSdkVersion(SDK_VERSION);
		((MerchantAPICallPreHandler) apiCallPreHandler).setPortName(portName);
	 	String response = call(apiCallPreHandler);
 	
		DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = builderFactory.newDocumentBuilder();
		InputSource inStream = new InputSource();
		inStream.setCharacterStream(new StringReader((String) response));
		Document document = builder.parse(inStream);
		XPathFactory factory = XPathFactory.newInstance();
		XPath xpath = factory.newXPath();
		try {
			Node node = (Node) xpath.evaluate(
					"Envelope/Body/GetRecurringPaymentsProfileDetailsResponse", document,
					XPathConstants.NODE);
			return new GetRecurringPaymentsProfileDetailsResponseType(node);
		} catch (XPathExpressionException exe) {
			throw new RuntimeException("Unable to parse response", exe);
		}	
	}
	/**	
	 * AUTO_GENERATED
	 * @throws SSLConfigurationException
	 * @throws InvalidCredentialException
	 * @throws UnsupportedEncodingException
	 * @throws IOException
	 * @throws HttpErrorException
	 * @throws InvalidResponseDataException
	 * @throws ClientActionRequiredException
	 * @throws MissingCredentialException
	 * @throws InterruptedException
	 * @throws OAuthException
	 */
	 public ManageRecurringPaymentsProfileStatusResponseType manageRecurringPaymentsProfileStatus(ManageRecurringPaymentsProfileStatusReq manageRecurringPaymentsProfileStatusReq, String apiUsername) throws SSLConfigurationException, InvalidCredentialException, IOException, HttpErrorException, InvalidResponseDataException, ClientActionRequiredException, MissingCredentialException, InterruptedException, OAuthException, ParserConfigurationException, SAXException, IOException {
	 	APICallPreHandler apiCallPreHandler = null;
	 	String portName = "PayPalAPIAA";
		setStandardParams(manageRecurringPaymentsProfileStatusReq.getManageRecurringPaymentsProfileStatusRequest());
		DefaultSOAPAPICallHandler defaultHandler = new DefaultSOAPAPICallHandler(manageRecurringPaymentsProfileStatusReq.toXMLString(null, "ManageRecurringPaymentsProfileStatusReq"), null, null);
		apiCallPreHandler = new MerchantAPICallPreHandler(defaultHandler, apiUsername, getAccessToken(), getTokenSecret());
		((MerchantAPICallPreHandler) apiCallPreHandler).setSdkName(SDK_NAME);
		((MerchantAPICallPreHandler) apiCallPreHandler).setSdkVersion(SDK_VERSION);
		((MerchantAPICallPreHandler) apiCallPreHandler).setPortName(portName);
	 	String response = call(apiCallPreHandler);
		DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = builderFactory.newDocumentBuilder();
		InputSource inStream = new InputSource();
		inStream.setCharacterStream(new StringReader((String) response));
		Document document = builder.parse(inStream);
		XPathFactory factory = XPathFactory.newInstance();
		XPath xpath = factory.newXPath();
		try {
			Node node = (Node) xpath.evaluate("Envelope/Body/ManageRecurringPaymentsProfileStatusResponse", document, XPathConstants.NODE);
			return new ManageRecurringPaymentsProfileStatusResponseType(node);
		} catch (XPathExpressionException exe) {
			throw new RuntimeException("Unable to parse response", exe);
		}
	 }
	 
	/** 
	 * AUTO_GENERATED
	 * @throws SSLConfigurationException
	 * @throws InvalidCredentialException
	 * @throws UnsupportedEncodingException
	 * @throws IOException
	 * @throws HttpErrorException
	 * @throws InvalidResponseDataException
	 * @throws ClientActionRequiredException
	 * @throws MissingCredentialException
	 * @throws InterruptedException
	 * @throws OAuthException
	 */
	 public ManageRecurringPaymentsProfileStatusResponseType manageRecurringPaymentsProfileStatus(ManageRecurringPaymentsProfileStatusReq manageRecurringPaymentsProfileStatusReq) throws SSLConfigurationException, InvalidCredentialException, IOException, HttpErrorException, InvalidResponseDataException, ClientActionRequiredException, MissingCredentialException, InterruptedException, OAuthException, ParserConfigurationException, SAXException  {
	 	return manageRecurringPaymentsProfileStatus(manageRecurringPaymentsProfileStatusReq, (String) null);
	 }

	/** 
	 * AUTO_GENERATED
	 * @throws SSLConfigurationException
	 * @throws InvalidCredentialException
	 * @throws UnsupportedEncodingException
	 * @throws IOException
	 * @throws HttpErrorException
	 * @throws InvalidResponseDataException
	 * @throws ClientActionRequiredException
	 * @throws MissingCredentialException
	 * @throws InterruptedException
	 * @throws OAuthException
	 */
	 public ManageRecurringPaymentsProfileStatusResponseType manageRecurringPaymentsProfileStatus(ManageRecurringPaymentsProfileStatusReq manageRecurringPaymentsProfileStatusReq, ICredential credential) throws SSLConfigurationException, InvalidCredentialException, IOException, HttpErrorException, InvalidResponseDataException, ClientActionRequiredException, MissingCredentialException, InterruptedException, OAuthException, ParserConfigurationException, SAXException  {
	 	APICallPreHandler apiCallPreHandler = null;
	 	String portName = "PayPalAPIAA";
		setStandardParams(manageRecurringPaymentsProfileStatusReq.getManageRecurringPaymentsProfileStatusRequest());
		DefaultSOAPAPICallHandler defaultHandler = new DefaultSOAPAPICallHandler(manageRecurringPaymentsProfileStatusReq.toXMLString(null, "ManageRecurringPaymentsProfileStatusReq"), null, null);
		apiCallPreHandler = new MerchantAPICallPreHandler(defaultHandler, credential);
		((MerchantAPICallPreHandler) apiCallPreHandler).setSdkName(SDK_NAME);
		((MerchantAPICallPreHandler) apiCallPreHandler).setSdkVersion(SDK_VERSION);
		((MerchantAPICallPreHandler) apiCallPreHandler).setPortName(portName);
	 	String response = call(apiCallPreHandler);
 	
		DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = builderFactory.newDocumentBuilder();
		InputSource inStream = new InputSource();
		inStream.setCharacterStream(new StringReader((String) response));
		Document document = builder.parse(inStream);
		XPathFactory factory = XPathFactory.newInstance();
		XPath xpath = factory.newXPath();
		try {
			Node node = (Node) xpath.evaluate(
					"Envelope/Body/ManageRecurringPaymentsProfileStatusResponse", document,
					XPathConstants.NODE);
			return new ManageRecurringPaymentsProfileStatusResponseType(node);
		} catch (XPathExpressionException exe) {
			throw new RuntimeException("Unable to parse response", exe);
		}	
	}
	/**	
	 * AUTO_GENERATED
	 * @throws SSLConfigurationException
	 * @throws InvalidCredentialException
	 * @throws UnsupportedEncodingException
	 * @throws IOException
	 * @throws HttpErrorException
	 * @throws InvalidResponseDataException
	 * @throws ClientActionRequiredException
	 * @throws MissingCredentialException
	 * @throws InterruptedException
	 * @throws OAuthException
	 */
	 public BillOutstandingAmountResponseType billOutstandingAmount(BillOutstandingAmountReq billOutstandingAmountReq, String apiUsername) throws SSLConfigurationException, InvalidCredentialException, IOException, HttpErrorException, InvalidResponseDataException, ClientActionRequiredException, MissingCredentialException, InterruptedException, OAuthException, ParserConfigurationException, SAXException, IOException {
	 	APICallPreHandler apiCallPreHandler = null;
	 	String portName = "PayPalAPIAA";
		setStandardParams(billOutstandingAmountReq.getBillOutstandingAmountRequest());
		DefaultSOAPAPICallHandler defaultHandler = new DefaultSOAPAPICallHandler(billOutstandingAmountReq.toXMLString(null, "BillOutstandingAmountReq"), null, null);
		apiCallPreHandler = new MerchantAPICallPreHandler(defaultHandler, apiUsername, getAccessToken(), getTokenSecret());
		((MerchantAPICallPreHandler) apiCallPreHandler).setSdkName(SDK_NAME);
		((MerchantAPICallPreHandler) apiCallPreHandler).setSdkVersion(SDK_VERSION);
		((MerchantAPICallPreHandler) apiCallPreHandler).setPortName(portName);
	 	String response = call(apiCallPreHandler);
		DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = builderFactory.newDocumentBuilder();
		InputSource inStream = new InputSource();
		inStream.setCharacterStream(new StringReader((String) response));
		Document document = builder.parse(inStream);
		XPathFactory factory = XPathFactory.newInstance();
		XPath xpath = factory.newXPath();
		try {
			Node node = (Node) xpath.evaluate("Envelope/Body/BillOutstandingAmountResponse", document, XPathConstants.NODE);
			return new BillOutstandingAmountResponseType(node);
		} catch (XPathExpressionException exe) {
			throw new RuntimeException("Unable to parse response", exe);
		}
	 }
	 
	/** 
	 * AUTO_GENERATED
	 * @throws SSLConfigurationException
	 * @throws InvalidCredentialException
	 * @throws UnsupportedEncodingException
	 * @throws IOException
	 * @throws HttpErrorException
	 * @throws InvalidResponseDataException
	 * @throws ClientActionRequiredException
	 * @throws MissingCredentialException
	 * @throws InterruptedException
	 * @throws OAuthException
	 */
	 public BillOutstandingAmountResponseType billOutstandingAmount(BillOutstandingAmountReq billOutstandingAmountReq) throws SSLConfigurationException, InvalidCredentialException, IOException, HttpErrorException, InvalidResponseDataException, ClientActionRequiredException, MissingCredentialException, InterruptedException, OAuthException, ParserConfigurationException, SAXException  {
	 	return billOutstandingAmount(billOutstandingAmountReq, (String) null);
	 }

	/** 
	 * AUTO_GENERATED
	 * @throws SSLConfigurationException
	 * @throws InvalidCredentialException
	 * @throws UnsupportedEncodingException
	 * @throws IOException
	 * @throws HttpErrorException
	 * @throws InvalidResponseDataException
	 * @throws ClientActionRequiredException
	 * @throws MissingCredentialException
	 * @throws InterruptedException
	 * @throws OAuthException
	 */
	 public BillOutstandingAmountResponseType billOutstandingAmount(BillOutstandingAmountReq billOutstandingAmountReq, ICredential credential) throws SSLConfigurationException, InvalidCredentialException, IOException, HttpErrorException, InvalidResponseDataException, ClientActionRequiredException, MissingCredentialException, InterruptedException, OAuthException, ParserConfigurationException, SAXException  {
	 	APICallPreHandler apiCallPreHandler = null;
	 	String portName = "PayPalAPIAA";
		setStandardParams(billOutstandingAmountReq.getBillOutstandingAmountRequest());
		DefaultSOAPAPICallHandler defaultHandler = new DefaultSOAPAPICallHandler(billOutstandingAmountReq.toXMLString(null, "BillOutstandingAmountReq"), null, null);
		apiCallPreHandler = new MerchantAPICallPreHandler(defaultHandler, credential);
		((MerchantAPICallPreHandler) apiCallPreHandler).setSdkName(SDK_NAME);
		((MerchantAPICallPreHandler) apiCallPreHandler).setSdkVersion(SDK_VERSION);
		((MerchantAPICallPreHandler) apiCallPreHandler).setPortName(portName);
	 	String response = call(apiCallPreHandler);
 	
		DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = builderFactory.newDocumentBuilder();
		InputSource inStream = new InputSource();
		inStream.setCharacterStream(new StringReader((String) response));
		Document document = builder.parse(inStream);
		XPathFactory factory = XPathFactory.newInstance();
		XPath xpath = factory.newXPath();
		try {
			Node node = (Node) xpath.evaluate(
					"Envelope/Body/BillOutstandingAmountResponse", document,
					XPathConstants.NODE);
			return new BillOutstandingAmountResponseType(node);
		} catch (XPathExpressionException exe) {
			throw new RuntimeException("Unable to parse response", exe);
		}	
	}
	/**	
	 * AUTO_GENERATED
	 * @throws SSLConfigurationException
	 * @throws InvalidCredentialException
	 * @throws UnsupportedEncodingException
	 * @throws IOException
	 * @throws HttpErrorException
	 * @throws InvalidResponseDataException
	 * @throws ClientActionRequiredException
	 * @throws MissingCredentialException
	 * @throws InterruptedException
	 * @throws OAuthException
	 */
	 public UpdateRecurringPaymentsProfileResponseType updateRecurringPaymentsProfile(UpdateRecurringPaymentsProfileReq updateRecurringPaymentsProfileReq, String apiUsername) throws SSLConfigurationException, InvalidCredentialException, IOException, HttpErrorException, InvalidResponseDataException, ClientActionRequiredException, MissingCredentialException, InterruptedException, OAuthException, ParserConfigurationException, SAXException, IOException {
	 	APICallPreHandler apiCallPreHandler = null;
	 	String portName = "PayPalAPIAA";
		setStandardParams(updateRecurringPaymentsProfileReq.getUpdateRecurringPaymentsProfileRequest());
		DefaultSOAPAPICallHandler defaultHandler = new DefaultSOAPAPICallHandler(updateRecurringPaymentsProfileReq.toXMLString(null, "UpdateRecurringPaymentsProfileReq"), null, null);
		apiCallPreHandler = new MerchantAPICallPreHandler(defaultHandler, apiUsername, getAccessToken(), getTokenSecret());
		((MerchantAPICallPreHandler) apiCallPreHandler).setSdkName(SDK_NAME);
		((MerchantAPICallPreHandler) apiCallPreHandler).setSdkVersion(SDK_VERSION);
		((MerchantAPICallPreHandler) apiCallPreHandler).setPortName(portName);
	 	String response = call(apiCallPreHandler);
		DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = builderFactory.newDocumentBuilder();
		InputSource inStream = new InputSource();
		inStream.setCharacterStream(new StringReader((String) response));
		Document document = builder.parse(inStream);
		XPathFactory factory = XPathFactory.newInstance();
		XPath xpath = factory.newXPath();
		try {
			Node node = (Node) xpath.evaluate("Envelope/Body/UpdateRecurringPaymentsProfileResponse", document, XPathConstants.NODE);
			return new UpdateRecurringPaymentsProfileResponseType(node);
		} catch (XPathExpressionException exe) {
			throw new RuntimeException("Unable to parse response", exe);
		}
	 }
	 
	/** 
	 * AUTO_GENERATED
	 * @throws SSLConfigurationException
	 * @throws InvalidCredentialException
	 * @throws UnsupportedEncodingException
	 * @throws IOException
	 * @throws HttpErrorException
	 * @throws InvalidResponseDataException
	 * @throws ClientActionRequiredException
	 * @throws MissingCredentialException
	 * @throws InterruptedException
	 * @throws OAuthException
	 */
	 public UpdateRecurringPaymentsProfileResponseType updateRecurringPaymentsProfile(UpdateRecurringPaymentsProfileReq updateRecurringPaymentsProfileReq) throws SSLConfigurationException, InvalidCredentialException, IOException, HttpErrorException, InvalidResponseDataException, ClientActionRequiredException, MissingCredentialException, InterruptedException, OAuthException, ParserConfigurationException, SAXException  {
	 	return updateRecurringPaymentsProfile(updateRecurringPaymentsProfileReq, (String) null);
	 }

	/** 
	 * AUTO_GENERATED
	 * @throws SSLConfigurationException
	 * @throws InvalidCredentialException
	 * @throws UnsupportedEncodingException
	 * @throws IOException
	 * @throws HttpErrorException
	 * @throws InvalidResponseDataException
	 * @throws ClientActionRequiredException
	 * @throws MissingCredentialException
	 * @throws InterruptedException
	 * @throws OAuthException
	 */
	 public UpdateRecurringPaymentsProfileResponseType updateRecurringPaymentsProfile(UpdateRecurringPaymentsProfileReq updateRecurringPaymentsProfileReq, ICredential credential) throws SSLConfigurationException, InvalidCredentialException, IOException, HttpErrorException, InvalidResponseDataException, ClientActionRequiredException, MissingCredentialException, InterruptedException, OAuthException, ParserConfigurationException, SAXException  {
	 	APICallPreHandler apiCallPreHandler = null;
	 	String portName = "PayPalAPIAA";
		setStandardParams(updateRecurringPaymentsProfileReq.getUpdateRecurringPaymentsProfileRequest());
		DefaultSOAPAPICallHandler defaultHandler = new DefaultSOAPAPICallHandler(updateRecurringPaymentsProfileReq.toXMLString(null, "UpdateRecurringPaymentsProfileReq"), null, null);
		apiCallPreHandler = new MerchantAPICallPreHandler(defaultHandler, credential);
		((MerchantAPICallPreHandler) apiCallPreHandler).setSdkName(SDK_NAME);
		((MerchantAPICallPreHandler) apiCallPreHandler).setSdkVersion(SDK_VERSION);
		((MerchantAPICallPreHandler) apiCallPreHandler).setPortName(portName);
	 	String response = call(apiCallPreHandler);
 	
		DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = builderFactory.newDocumentBuilder();
		InputSource inStream = new InputSource();
		inStream.setCharacterStream(new StringReader((String) response));
		Document document = builder.parse(inStream);
		XPathFactory factory = XPathFactory.newInstance();
		XPath xpath = factory.newXPath();
		try {
			Node node = (Node) xpath.evaluate(
					"Envelope/Body/UpdateRecurringPaymentsProfileResponse", document,
					XPathConstants.NODE);
			return new UpdateRecurringPaymentsProfileResponseType(node);
		} catch (XPathExpressionException exe) {
			throw new RuntimeException("Unable to parse response", exe);
		}	
	}
	/**	
	 * AUTO_GENERATED
	 * @throws SSLConfigurationException
	 * @throws InvalidCredentialException
	 * @throws UnsupportedEncodingException
	 * @throws IOException
	 * @throws HttpErrorException
	 * @throws InvalidResponseDataException
	 * @throws ClientActionRequiredException
	 * @throws MissingCredentialException
	 * @throws InterruptedException
	 * @throws OAuthException
	 */
	 public ReverseTransactionResponseType reverseTransaction(ReverseTransactionReq reverseTransactionReq, String apiUsername) throws SSLConfigurationException, InvalidCredentialException, IOException, HttpErrorException, InvalidResponseDataException, ClientActionRequiredException, MissingCredentialException, InterruptedException, OAuthException, ParserConfigurationException, SAXException, IOException {
	 	APICallPreHandler apiCallPreHandler = null;
	 	String portName = "PayPalAPIAA";
		setStandardParams(reverseTransactionReq.getReverseTransactionRequest());
		DefaultSOAPAPICallHandler defaultHandler = new DefaultSOAPAPICallHandler(reverseTransactionReq.toXMLString(null, "ReverseTransactionReq"), null, null);
		apiCallPreHandler = new MerchantAPICallPreHandler(defaultHandler, apiUsername, getAccessToken(), getTokenSecret());
		((MerchantAPICallPreHandler) apiCallPreHandler).setSdkName(SDK_NAME);
		((MerchantAPICallPreHandler) apiCallPreHandler).setSdkVersion(SDK_VERSION);
		((MerchantAPICallPreHandler) apiCallPreHandler).setPortName(portName);
	 	String response = call(apiCallPreHandler);
		DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = builderFactory.newDocumentBuilder();
		InputSource inStream = new InputSource();
		inStream.setCharacterStream(new StringReader((String) response));
		Document document = builder.parse(inStream);
		XPathFactory factory = XPathFactory.newInstance();
		XPath xpath = factory.newXPath();
		try {
			Node node = (Node) xpath.evaluate("Envelope/Body/ReverseTransactionResponse", document, XPathConstants.NODE);
			return new ReverseTransactionResponseType(node);
		} catch (XPathExpressionException exe) {
			throw new RuntimeException("Unable to parse response", exe);
		}
	 }
	 
	/** 
	 * AUTO_GENERATED
	 * @throws SSLConfigurationException
	 * @throws InvalidCredentialException
	 * @throws UnsupportedEncodingException
	 * @throws IOException
	 * @throws HttpErrorException
	 * @throws InvalidResponseDataException
	 * @throws ClientActionRequiredException
	 * @throws MissingCredentialException
	 * @throws InterruptedException
	 * @throws OAuthException
	 */
	 public ReverseTransactionResponseType reverseTransaction(ReverseTransactionReq reverseTransactionReq) throws SSLConfigurationException, InvalidCredentialException, IOException, HttpErrorException, InvalidResponseDataException, ClientActionRequiredException, MissingCredentialException, InterruptedException, OAuthException, ParserConfigurationException, SAXException  {
	 	return reverseTransaction(reverseTransactionReq, (String) null);
	 }

	/** 
	 * AUTO_GENERATED
	 * @throws SSLConfigurationException
	 * @throws InvalidCredentialException
	 * @throws UnsupportedEncodingException
	 * @throws IOException
	 * @throws HttpErrorException
	 * @throws InvalidResponseDataException
	 * @throws ClientActionRequiredException
	 * @throws MissingCredentialException
	 * @throws InterruptedException
	 * @throws OAuthException
	 */
	 public ReverseTransactionResponseType reverseTransaction(ReverseTransactionReq reverseTransactionReq, ICredential credential) throws SSLConfigurationException, InvalidCredentialException, IOException, HttpErrorException, InvalidResponseDataException, ClientActionRequiredException, MissingCredentialException, InterruptedException, OAuthException, ParserConfigurationException, SAXException  {
	 	APICallPreHandler apiCallPreHandler = null;
	 	String portName = "PayPalAPIAA";
		setStandardParams(reverseTransactionReq.getReverseTransactionRequest());
		DefaultSOAPAPICallHandler defaultHandler = new DefaultSOAPAPICallHandler(reverseTransactionReq.toXMLString(null, "ReverseTransactionReq"), null, null);
		apiCallPreHandler = new MerchantAPICallPreHandler(defaultHandler, credential);
		((MerchantAPICallPreHandler) apiCallPreHandler).setSdkName(SDK_NAME);
		((MerchantAPICallPreHandler) apiCallPreHandler).setSdkVersion(SDK_VERSION);
		((MerchantAPICallPreHandler) apiCallPreHandler).setPortName(portName);
	 	String response = call(apiCallPreHandler);
 	
		DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = builderFactory.newDocumentBuilder();
		InputSource inStream = new InputSource();
		inStream.setCharacterStream(new StringReader((String) response));
		Document document = builder.parse(inStream);
		XPathFactory factory = XPathFactory.newInstance();
		XPath xpath = factory.newXPath();
		try {
			Node node = (Node) xpath.evaluate(
					"Envelope/Body/ReverseTransactionResponse", document,
					XPathConstants.NODE);
			return new ReverseTransactionResponseType(node);
		} catch (XPathExpressionException exe) {
			throw new RuntimeException("Unable to parse response", exe);
		}	
	}
	/**	
	 * AUTO_GENERATED
	 * @throws SSLConfigurationException
	 * @throws InvalidCredentialException
	 * @throws UnsupportedEncodingException
	 * @throws IOException
	 * @throws HttpErrorException
	 * @throws InvalidResponseDataException
	 * @throws ClientActionRequiredException
	 * @throws MissingCredentialException
	 * @throws InterruptedException
	 * @throws OAuthException
	 */
	 public ExternalRememberMeOptOutResponseType externalRememberMeOptOut(ExternalRememberMeOptOutReq externalRememberMeOptOutReq, String apiUsername) throws SSLConfigurationException, InvalidCredentialException, IOException, HttpErrorException, InvalidResponseDataException, ClientActionRequiredException, MissingCredentialException, InterruptedException, OAuthException, ParserConfigurationException, SAXException, IOException {
	 	APICallPreHandler apiCallPreHandler = null;
	 	String portName = "PayPalAPIAA";
		setStandardParams(externalRememberMeOptOutReq.getExternalRememberMeOptOutRequest());
		DefaultSOAPAPICallHandler defaultHandler = new DefaultSOAPAPICallHandler(externalRememberMeOptOutReq.toXMLString(null, "ExternalRememberMeOptOutReq"), null, null);
		apiCallPreHandler = new MerchantAPICallPreHandler(defaultHandler, apiUsername, getAccessToken(), getTokenSecret());
		((MerchantAPICallPreHandler) apiCallPreHandler).setSdkName(SDK_NAME);
		((MerchantAPICallPreHandler) apiCallPreHandler).setSdkVersion(SDK_VERSION);
		((MerchantAPICallPreHandler) apiCallPreHandler).setPortName(portName);
	 	String response = call(apiCallPreHandler);
		DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = builderFactory.newDocumentBuilder();
		InputSource inStream = new InputSource();
		inStream.setCharacterStream(new StringReader((String) response));
		Document document = builder.parse(inStream);
		XPathFactory factory = XPathFactory.newInstance();
		XPath xpath = factory.newXPath();
		try {
			Node node = (Node) xpath.evaluate("Envelope/Body/ExternalRememberMeOptOutResponse", document, XPathConstants.NODE);
			return new ExternalRememberMeOptOutResponseType(node);
		} catch (XPathExpressionException exe) {
			throw new RuntimeException("Unable to parse response", exe);
		}
	 }
	 
	/** 
	 * AUTO_GENERATED
	 * @throws SSLConfigurationException
	 * @throws InvalidCredentialException
	 * @throws UnsupportedEncodingException
	 * @throws IOException
	 * @throws HttpErrorException
	 * @throws InvalidResponseDataException
	 * @throws ClientActionRequiredException
	 * @throws MissingCredentialException
	 * @throws InterruptedException
	 * @throws OAuthException
	 */
	 public ExternalRememberMeOptOutResponseType externalRememberMeOptOut(ExternalRememberMeOptOutReq externalRememberMeOptOutReq) throws SSLConfigurationException, InvalidCredentialException, IOException, HttpErrorException, InvalidResponseDataException, ClientActionRequiredException, MissingCredentialException, InterruptedException, OAuthException, ParserConfigurationException, SAXException  {
	 	return externalRememberMeOptOut(externalRememberMeOptOutReq, (String) null);
	 }

	/** 
	 * AUTO_GENERATED
	 * @throws SSLConfigurationException
	 * @throws InvalidCredentialException
	 * @throws UnsupportedEncodingException
	 * @throws IOException
	 * @throws HttpErrorException
	 * @throws InvalidResponseDataException
	 * @throws ClientActionRequiredException
	 * @throws MissingCredentialException
	 * @throws InterruptedException
	 * @throws OAuthException
	 */
	 public ExternalRememberMeOptOutResponseType externalRememberMeOptOut(ExternalRememberMeOptOutReq externalRememberMeOptOutReq, ICredential credential) throws SSLConfigurationException, InvalidCredentialException, IOException, HttpErrorException, InvalidResponseDataException, ClientActionRequiredException, MissingCredentialException, InterruptedException, OAuthException, ParserConfigurationException, SAXException  {
	 	APICallPreHandler apiCallPreHandler = null;
	 	String portName = "PayPalAPIAA";
		setStandardParams(externalRememberMeOptOutReq.getExternalRememberMeOptOutRequest());
		DefaultSOAPAPICallHandler defaultHandler = new DefaultSOAPAPICallHandler(externalRememberMeOptOutReq.toXMLString(null, "ExternalRememberMeOptOutReq"), null, null);
		apiCallPreHandler = new MerchantAPICallPreHandler(defaultHandler, credential);
		((MerchantAPICallPreHandler) apiCallPreHandler).setSdkName(SDK_NAME);
		((MerchantAPICallPreHandler) apiCallPreHandler).setSdkVersion(SDK_VERSION);
		((MerchantAPICallPreHandler) apiCallPreHandler).setPortName(portName);
	 	String response = call(apiCallPreHandler);
 	
		DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = builderFactory.newDocumentBuilder();
		InputSource inStream = new InputSource();
		inStream.setCharacterStream(new StringReader((String) response));
		Document document = builder.parse(inStream);
		XPathFactory factory = XPathFactory.newInstance();
		XPath xpath = factory.newXPath();
		try {
			Node node = (Node) xpath.evaluate(
					"Envelope/Body/ExternalRememberMeOptOutResponse", document,
					XPathConstants.NODE);
			return new ExternalRememberMeOptOutResponseType(node);
		} catch (XPathExpressionException exe) {
			throw new RuntimeException("Unable to parse response", exe);
		}	
	}

}