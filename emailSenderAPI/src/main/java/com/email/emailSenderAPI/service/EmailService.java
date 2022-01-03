package com.email.emailSenderAPI.service;


import org.springframework.stereotype.Service;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.io.File;
import java.io.IOException;
import java.util.Properties;

@Service
public class EmailService {

    public void sendEmail(String subject, String message, String to) throws MessagingException, IOException {


        String from="shayuaa13013@gmail.com";
        //variable for gmail
        String host = "smtp.gmail.com";

        Properties properties= System.getProperties();

        //set host
        properties.put("mail.smtp.host",host);
        properties.put("mail.smtp.port","465");
        properties.put("mail.smtp.ssl.enable","true");
        properties.put("mail.smtp.auth","true");

        Session session= Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("shayuaa13013@gmail.com","Holmes@13.");
            }
        });

        session.setDebug(true);

        MimeMessage mimeMessage= new MimeMessage(session);

        mimeMessage.setFrom(from);

        mimeMessage.addRecipients(Message.RecipientType.TO,InternetAddress.parse(to));

        mimeMessage.setSubject(subject);
//        mimeMessage.setText(message);

        String path="C:\\Users\\aayush.soni\\Downloads\\41b26341992c2552c\\newYear.jpg";
        MimeMultipart mimeMultipart=new MimeMultipart();

        MimeBodyPart textMime = new MimeBodyPart();
        MimeBodyPart fileMime = new MimeBodyPart();

        textMime.setText(message);
        File file = new File(path);
        fileMime.attachFile(file);


        mimeMultipart.addBodyPart(textMime);
        mimeMultipart.addBodyPart(fileMime);

        mimeMessage.setContent(mimeMultipart);

        Transport.send(mimeMessage);
    }


}
