import javax.mail.*;
import javax.mail.internet.*;
import java.util.*;

public class SendEmail {
final String myEmail = "testforme215@gmail.com";  
final String myPassword = "EasyPassword";		
final String emailSMTPserver = "smtp.gmail.com";
final String emailServerPort = "465";  


static String recepient = "";
static String emailSubject = "";
static String emailBody = "";


public SendEmail(String recepient,String Subject, String Body){  
   
  // Receiver Email Address
  SendEmail.recepient = recepient; 
  // Subject
  SendEmail.emailSubject=Subject;
  // Body
  SendEmail.emailBody=Body;
  
  
  Properties props = new Properties();
  props.put("mail.smtp.user",myEmail);
  props.put("mail.smtp.host", emailSMTPserver);
  props.put("mail.smtp.port", emailServerPort);
  props.put("mail.smtp.starttls.enable", "true");
  props.put("mail.smtp.auth", "true");
  props.put("mail.smtp.socketFactory.port", emailServerPort);
  props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
  props.put("mail.smtp.socketFactory.fallback", "false");
  Authenticator auth = new SMTPAuthenticator();
  
  try{  
  Session session = Session.getInstance(props, auth);
  MimeMessage msg = new MimeMessage(session);
  msg.setText(emailBody);
  msg.setSubject(emailSubject);
  msg.setFrom(new InternetAddress(myEmail));
  msg.addRecipient(Message.RecipientType.TO, new InternetAddress(recepient));
 
  Transport.send(msg);
  
  System.out.println("Message sent Successfully"); } 
  
  catch (Exception mex){
  mex.printStackTrace();}
  
  
  }
  public class SMTPAuthenticator extends javax.mail.Authenticator
  {
  public PasswordAuthentication getPasswordAuthentication()
  {
  return new PasswordAuthentication(myEmail, myPassword);
  }
  }
}
 