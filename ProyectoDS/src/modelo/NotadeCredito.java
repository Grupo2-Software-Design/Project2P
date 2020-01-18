/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author Freddy
 */
public class NotadeCredito extends Documento{
    private String numNota;

    public NotadeCredito(String numNota) {
        this.numNota = numNota;
    }

    @Override
    public void enviarCorreo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
