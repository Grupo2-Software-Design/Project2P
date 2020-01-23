/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.Date;
import java.util.List;
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
    protected Date fechaEmision; 
    protected String descripcion;
    protected Empleado personalCaja;
    protected Cliente cliente;
    protected DataMail datamail;

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

    public abstract void agregar();
    public abstract void update(String argNuevo,String var,String argViejo);
    public abstract List<Documento> searchProducto(String arg,String var);
    public abstract void delete();
}
