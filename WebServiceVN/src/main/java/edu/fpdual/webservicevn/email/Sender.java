package edu.fpdual.webservicevn.email;

import lombok.Getter;
import lombok.Setter;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.io.*;
import java.util.Properties;
public class Sender {
  @Getter
  @Setter
  Properties mailProp = new Properties();
  @Getter
  @Setter
  Properties credentialProp = new Properties();

  public Sender() {
    try {
      mailProp.load(getClass().getClassLoader().getResourceAsStream("mail.properties"));
      credentialProp.load(getClass().getClassLoader().getResourceAsStream("credentials.properties"));
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  /**
   * Send a simple email with from and recipient address, subject and a simple HTML format content.
   * @param from from email address
   * @param to recipient email address
   * @param subject email subject
   * @param content email content in html format
   * @return a {@link boolean} indicating if the email was sent or not.
   */
  public boolean send(String from, String to, String subject, String content) {
    // Get the Session object.// and pass username and password
    Session session = createSession();
    try {
      // Create a default MimeMessage object.
      MimeMessage message = new MimeMessage(session);

      // Set From: header field of the header.
      message.setFrom(new InternetAddress(from));

      // Set To: header field of the header.
      message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

      // Set Subject: header field
      message.setSubject(subject);

      // Now set the actual message
      message.setContent(content, "text/html");

      System.out.println("sending...");
      // Send message
      Transport.send(message);
      System.out.println("Sent message successfully....");
      return true;
    } catch (MessagingException mex) {
      mex.printStackTrace();
      return false;
    }
  }

    private Session createSession () {
      Session session = Session.getInstance(mailProp, new javax.mail.Authenticator() {
        protected PasswordAuthentication getPasswordAuthentication() {
          return new PasswordAuthentication(credentialProp.getProperty(CredentialConstants.USER),
              credentialProp.getProperty(CredentialConstants.PASSWD));
        }
      });
      // Used to debug SMTP issues
      session.setDebug(true);
      return session;
    }
  }

