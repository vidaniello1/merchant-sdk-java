This repository contains java sdk and samples for Merchant API.

Prerequisites:
---------------
*	Java jdk-1.5 or higher
*	Apache Maven 2 or higher

SDK Integration:
----------------
For Non-Maven Users:
--------------------
*   Create a new application.

*   Copy  all the jar files present inside 'lib' folder to your application.

For Maven Users:
----------------
*   Install all the jar files present inside 'lib' folder manually to local repository. 

        mvn install:install-file -Dfile=commons-codec-1.3.jar -DgroupId=commons-codec -DartifactId=commons-codec -Dversion=1.3 -Dpackaging=jar
        mvn install:install-file -Dfile=paypal-auth-signature-1.0.jar -DgroupId=com.paypal.sdk -DartifactId=paypal-auth-signature -Dversion=1.0 -Dpackaging=jar
        mvn install:install-file -Dfile=paypal-core-1.0.jar -DgroupId=com.paypal.sdk -DartifactId=paypal-core -Dversion=1.0 -Dpackaging=jar
		mvn install:install-file -Dfile=merchantsdk-2.0.96.jar -DgroupId=com.paypal.sdk -DartifactId=merchantsdk -Dversion=2.0.96 -Dpackaging=jar	

*	Create a new maven application.

*	Add dependency to sdk in your application's pom.xml as below.
		
		<dependency>
			<groupId>com.paypal.sdk</groupId>
			<artifactId>merchantsdk</artifactId>
			<version>2.0.96</version>
		</dependency>
		
To make an API call:
--------------------			
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




