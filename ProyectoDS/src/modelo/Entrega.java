/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author NICOLE
 */
public class Entrega implements Iterator{
    private ConformidadCliente conformidad;
    private Cliente cliente;
    private List<Producto> productos = new LinkedList<>();
    private Empleado empleado;
    

    @Override
    public boolean hasNext() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object next() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
