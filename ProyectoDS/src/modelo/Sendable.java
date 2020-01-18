/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import javax.mail.MessagingException;

/**
 *
 * @author Freddy
 */
public interface Sendable {
    public void enviarCorreo() throws MessagingException;
}
