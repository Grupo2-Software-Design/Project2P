/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;


import javax.mail.MessagingException;
import modelo.Sendable;

/**
 *
 * @author andre
 */
public class ControladorCorreo {
    public void enviar(Sendable documento){
        try{
            documento.enviarCorreo();
        }catch(MessagingException e){
            e.printStackTrace();
        }
    }
}
