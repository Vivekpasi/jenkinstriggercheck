package com.inforcepro.app;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;



//import crm_test.sending_email_java;

public class send_email_api_output {
	
   public static StringBuilder sb_email_text = new StringBuilder();
   public static String name;
   public static int response_code;

	 
	
	
	public static void  exception_method (Exception e) throws IOException
	{
		
		  StringWriter writer = new StringWriter();
	 		 e.printStackTrace( new PrintWriter(writer,true ));
	 		 System. out.println("Exeption stack is :\n"+writer.toString());
	          
	       /* String emessage =  e.getMessage();
			 System.out.println(e);
			 */
	 		// driver.close();
	 		 System.out.println(name);
					auto_email_error_notification(writer.toString(),name);
					 				System.exit(1);
	}
	
	public static void auto_email () throws IOException

	{
		
		final String 	username = "vivek@inforcepro.com";
		final String password = "login1-2";

		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");

		Session session = Session.getInstance(props,
		  new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		  });

		try {

			
			 
			//String[] toEmails = {"vivekpasi.limetray@gmail.com","gaurav.sahai.limetray@gmail.com"};
			Message message = new MimeMessage(session);
			
			message.setFrom(new InternetAddress("vivek@inforcepro.com"));

         message.setRecipients(Message.RecipientType.TO, InternetAddress.parse("vivek@inforcepro.com"));
       //  String address = "gaurav.sahai.limetray@gmail.com,yashbir.limetray@gmail.com,himanshu.limetray@gmail.com,yashwant@limetray.com";
         String address = "vivek@inforcepro.com";
         InternetAddress[] iAdressArray = InternetAddress.parse(address);
         message.setRecipients(Message.RecipientType.CC, iAdressArray);
		SimpleDateFormat dateformat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
          String current_date_time = dateformat.format(new Date());
          
         message.setSubject("Test server notification"+" " +"at" +" " + current_date_time );
        // StringBuilder sb = new StringBuilder();
         //sb.append(resetLink).append(System.lineSeparator());
         //sb.append("1236547").append(System.lineSeparator());
        // sb.append("Here is another text");

         message.setText(sb_email_text.toString());  
	//message.setText("Method name exception occur :"+" "+ method_name + " \n\n"+a);
         
          Transport.send(message);
			
			System.out.println(" Email Sent");
			
            // return a;
             
		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}

		catch(Exception e){}
	
	
	}

	public static String auto_email_error_notification (String a, String method_name)

	{
		
		final String username = "vivek@inforcepro.com";
		final String password = "login1-2";

		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");

		Session session = Session.getInstance(props,
		  new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		  });

		try {

			
			
			//String[] toEmails = {"vivekpasi.limetray@gmail.com","gaurav.sahai.limetray@gmail.com"};
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("vivek@inforcepro.com"));

         message.setRecipients(Message.RecipientType.TO, InternetAddress.parse("vivek@inforcepro.com"));
        // String address = "gaurav.sahai.limetray@gmail.com,yashbir.limetray@gmail.com,himanshu.limetray@gmail.com,yashwant@limetray.com";
         String address = "vivek@inforcepro.com";
         
         InternetAddress[] iAdressArray = InternetAddress.parse(address);
         message.setRecipients(Message.RecipientType.CC, iAdressArray);
		
         SimpleDateFormat dateformat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
         String current_date_time = dateformat.format(new Date());
         
        message.setSubject("Error notification of Test server (mars.inforcepro.com) "+" " +"at" +" " + current_date_time );
        
       		message.setText("Method name exception occur :"+" "+ method_name + " \n\n"+a);
        message.setText(sb_email_text.toString());  

			Transport.send(message);
			
			System.out.println("Done");
			
             return a;
             
		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}

	
	
}
