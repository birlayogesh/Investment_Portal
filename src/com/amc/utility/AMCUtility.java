package com.amc.utility;

import java.security.Security;
import java.util.Collection;
import java.util.Properties;
import java.util.Random;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.amc.db.DBConnectivity;

public class AMCUtility {
	private static final String SMTP_HOST_NAME = "smtp.gmail.com";
	private static final String SMTP_PORT = "465";
	private static final String SSL_FACTORY = "javax.net.ssl.SSLSocketFactory";
	private static final String emailSubjectTxt = "AMC Login Credentials";
	private static final String emailFromAddress = "birlayogesh@gmail.com";
	private static String emailMsgTxt = null;
	private static final String[] sendTo = new String[1];
	
	public void sendEmail(String emailId){

		Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());
		String folio=new AMCUtility().generateFolio();
		String pin=new AMCUtility().generatePin();
		
		sendTo[0]=(String)emailId;
		
		emailMsgTxt="Your Folio is:"+folio+" and Your Pin is:"+pin+".";
		 try {
			new AMCUtility().sendSSLMessage(sendTo, emailSubjectTxt,
					 emailMsgTxt, emailFromAddress);
			DBConnectivity dc=new DBConnectivity();
			dc.insertUserRecord(folio, pin);
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void sendSSLMessage(String recipients[], String subject,
			String message, String from) throws MessagingException {
		boolean debug = true;

		Properties props = new Properties();
		props.put("mail.smtp.host", SMTP_HOST_NAME);
		props.put("mail.smtp.auth", "true");
		props.put("mail.debug", "true");
		props.put("mail.smtp.port", SMTP_PORT);
		props.put("mail.smtp.socketFactory.port", SMTP_PORT);
		props.put("mail.smtp.socketFactory.class", SSL_FACTORY);
		props.put("mail.smtp.socketFactory.fallback", "false");

		Session session = Session.getDefaultInstance(props,
				new javax.mail.Authenticator() {

					protected PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication(
								"birlayogesh@gmail.com", "Yog_20Bir");
					}
				});

		session.setDebug(debug);

		Message msg = new MimeMessage(session);
		InternetAddress addressFrom = new InternetAddress(from);
		msg.setFrom(addressFrom);

		InternetAddress[] addressTo = new InternetAddress[recipients.length];
		
		for (int i = 0; i < recipients.length; i++) {
		addressTo[i] = new InternetAddress(recipients[i]);
		}

		
		msg.setRecipients(Message.RecipientType.TO, addressTo);

		// Setting the Subject and Content Type
		msg.setSubject(subject);
		msg.setContent(message, "text/plain");
		Transport.send(msg);
	}

	public String generateFolio() {
		 String AB = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		 Random rnd = new Random();
		 StringBuilder sb = new StringBuilder(6);
		 for( int i = 0; i < 6; i++ ) 
		      sb.append( AB.charAt( rnd.nextInt(AB.length()) ) );
		   return sb.toString();
		
	}

	public String generatePin() {

		int randomNumber = ( int )( Math.random() * 9999 );

		if( randomNumber <= 1000 ) {
		    randomNumber = randomNumber + 1000;
		}		    
		return String.valueOf(randomNumber);
	}

	
}