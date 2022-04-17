/*
* @文 件 名:  AuthServer.java 
* @版     权:  灭霸指挥中心. Copyright 2014-2020,  All rights reserved
* @描     述:  (用一句话描述该文件做什么) 
* @版     本: 1.0
* @创 建 人:  0216000799
* @创建时间: 2018年8月7日 下午2:25:12 
*/
package com.auth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Map;

import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.NameCallback;
import javax.security.auth.callback.PasswordCallback;
import javax.security.auth.callback.TextOutputCallback;
import javax.security.auth.callback.UnsupportedCallbackException;
import javax.security.sasl.Sasl;
import javax.security.sasl.SaslException;
import javax.security.sasl.SaslServer;

/**   
 * @文 件 名:  AuthServer.java 
 * @版     权:  灭霸指挥中心. Copyright 2014-2020,  All rights reserved
 * @描     述:  
 * @版     本:  1.0
 * @创 建 人:  0216000799
 * @创建时间: 2018年8月7日 下午2:25:12 
 */
public class AuthServer {
	public static void main(String[] args) {
//		String mechanism = "CRAM-MD5";
//		String myFQDN = "authserver";
//		Map<String,?> props = null;
//		int status;
//		byte[] response;
//		 SaslServer ss = Sasl.createSaslServer(mechanism,
//			     "ldap", myFQDN, props, new CallBack());
//			 while (!ss.isComplete()) {
//			     try {
//			         byte[] challenge = ss.evaluateResponse(response);
//			         if (ss.isComplete()) {
//			             status = ldap.sendBindResponse(mechanism, challenge, SUCCESS);
//			         } else {
//			             status = ldap.sendBindResponse(mechanism, challenge, 
//			                   SASL_BIND_IN_PROGRESS);
//			             response = ldap.readBindRequest();
//			         }
//			     } catch (SaslException e) {
//			            status = ldap.sendErrorResponse(e);
//			            break;
//			     }
//			 }
//			 if (ss.isComplete() && status == SUCCESS) {
//			    String qop = (String) sc.getNegotiatedProperty(Sasl.QOP);
//			    if (qop != null 
//			        && (qop.equalsIgnoreCase("auth-int") 
//			            || qop.equalsIgnoreCase("auth-conf"))) {
//
//			      // Use SaslServer.wrap() and SaslServer.unwrap() for future
//			      // communication with client
//			        ldap.in = new SecureInputStream(ss, ldap.in);
//			        ldap.out = new SecureOutputStream(ss, ldap.out);
//			    }
//			 }

		
		
		
		
	}
	
	  class  CallBack implements CallbackHandler {
		  public void handle(Callback[] callbacks)
				  throws IOException, UnsupportedCallbackException {

				          for (int i = 0; i < callbacks.length; i++) {
				             if (callbacks[i] instanceof TextOutputCallback) {
				  
				                 // display the message according to the specified type
				                 TextOutputCallback toc = (TextOutputCallback)callbacks[i];
				                 switch (toc.getMessageType()) {
				                 case TextOutputCallback.INFORMATION:
				                     System.out.println(toc.getMessage());
				                     break;
				                 case TextOutputCallback.ERROR:
				                     System.out.println("ERROR: " + toc.getMessage());
				                     break;
				                 case TextOutputCallback.WARNING:
				                     System.out.println("WARNING: " + toc.getMessage());
				                     break;
				                 default:
				                     throw new IOException("Unsupported message type: " +
				                                         toc.getMessageType());
				                 }

				             } else if (callbacks[i] instanceof NameCallback) {
				  
				                 // prompt the user for a username
				                 NameCallback nc = (NameCallback)callbacks[i];
				  
				                 // ignore the provided defaultName
				                 System.err.print(nc.getPrompt());
				                 System.err.flush();
				                 nc.setName((new BufferedReader
				                         (new InputStreamReader(System.in))).readLine());

				             } else if (callbacks[i] instanceof PasswordCallback) {
				  
				                 // prompt the user for sensitive information
				                 PasswordCallback pc = (PasswordCallback)callbacks[i];
				                 System.err.print(pc.getPrompt());
				                 System.err.flush();
				                 pc.setPassword(readPassword(System.in));
				  
				             } else {
				                 throw new UnsupportedCallbackException
				                         (callbacks[i], "Unrecognized Callback");
				             }
				          }
				  }
				   
				  // Reads user password from given input stream.
				  private char[] readPassword(InputStream in) throws IOException {
				    return null;
				  }

	  }
	
	
}
