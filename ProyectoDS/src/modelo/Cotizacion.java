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
public class Cotizacion extends Documento{
    private String numCorizacion;

    public Cotizacion(String numCorizacion) {
        this.numCorizacion = numCorizacion;
    }
    
    @Override
    public void enviarCorreo() {
    
    }
    
}
