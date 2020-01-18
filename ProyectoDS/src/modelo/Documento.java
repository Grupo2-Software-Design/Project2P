/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.Date;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author Freddy
 */
public abstract class Documento implements Sendable{    
    private Date fechaEmision; 
    private String descripcion;
    private Empleado personalCaja;
    private Cliente cliente;
    private DataMail datamail;

    @Override
    public void enviarCorreo() throws MessagingException{
        Message message = new MimeMessage(datamail.getSession(datamail.retrieveProperties()));
        message.setFrom(new InternetAddress(datamail.getUsername()));
        message.setRecipients(Message.RecipientType.TO,
                InternetAddress.parse(datamail.getUsername()));
        message.setSubject(datamail.getSubject());
        message.setText(datamail.getMessage());
        Transport.send(message);
    }

    
}
