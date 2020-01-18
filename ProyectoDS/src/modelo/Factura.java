package modelo;

import java.util.LinkedList;

/**
 *
 * @author Camilo
 */

public class Factura extends Documento{
    private String numFactura;
    private boolean domicilio;
    private LinkedList<Venta> ventas;
    private StrategyPay metodoPago;
    
    
}