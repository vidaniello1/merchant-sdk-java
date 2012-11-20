This repository contains java sdk and samples for Merchant API.

Prerequisities:
---------------
*	Java jdk-1.5 or higher
*	Apache Maven 2 or higher

SDK Integration:
----------------
*	Create a new maven web application.

*	Add dependency to sdk in your application's pom.xml as below.
		
		<dependency>
			<groupId>com.paypal.sdk</groupId>
			<artifactId>merchantsdk</artifactId>
			<version>1.0-SNAPSHOT</version>
		</dependency>
		
*	Import PayPalAPIInterfaceServiceService.java into your code.
		
*	Copy the configuration file 'sdk_config.properties' in 'merchantsample/src/main/resources' folder to your application 'src/main/resources'. And load it using,  
		  
		new PayPalAPIInterfaceServiceService(this.getClass().getResourceAsStream("/sdk_config.properties"));
	
*	Or load the configuration file from any location using absolute path with the below method calls as required.

          new PayPalAPIInterfaceServiceService(new File(" .../sdk_config.properties"));
                                 Or
		  new PayPalAPIInterfaceServiceService(new InputStream(new File(" .../sdk_config.properties")));
                                 Or
          new PayPalAPIInterfaceServiceService(" .../sdk_config.properties");
  
*	Create a service wrapper object.

*	Create a request object as per your project needs. 

*	Invoke the appropriate method on the service wrapper object.

For example,

          
	  import urn.ebay.api.PayPalAPI.PayPalAPIInterfaceServiceService;
	  import urn.ebay.api.PayPalAPI.TransactionSearchReq;
	  import urn.ebay.api.PayPalAPI.TransactionSearchRequestType;
	  import urn.ebay.api.PayPalAPI.TransactionSearchResponseType;
	  ...
	  
          
          
      TransactionSearchReq txnreq = new TransactionSearchReq();
	  TransactionSearchRequestType requestType = new TransactionSearchRequestType();
	  
	  requestType.setStartDate("2011-10-04T00:00:00.000Z"); 
	  requestType.setEndDate("2011-10-05T23:59:59.000Z"); 
	  requestType.setVersion("95.0");
	  requestType.setTransactionID(request.getParameter("transactionID"));
	  txnreq.setTransactionSearchRequest(requestType);
	  
      PayPalAPIInterfaceServiceService service = new PayPalAPIInterfaceServiceService(this.getClass().getResourceAsStream("/sdk_config.properties"));
	  //username is optional
	  TransactionSearchResponseType txnresponse = service.transactionSearch(txnreq, username);
		  

SDK Logging:
------------
*	For logging - java.util.logging has been used. To change the default configuration, edit the logging.properties file in 'jre/lib' folder under your JDK root.		  

		  
SDK Configuration:
------------------
The SDK uses .properties format configuration file. Sample of this file is at 
 
'merchantsample/src/main/resources/'. You can use the 'sdk_config.properties' configuration file to configure

*	(Multiple) API account credentials.

*	HTTP connection parameters.

*	Service configuration.


For additional information on Merchant API, please refer to https://www.x.com/developers/paypal/documentation-tools/api




