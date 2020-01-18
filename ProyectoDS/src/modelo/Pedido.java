package modelo;

import java.util.LinkedList;

/**
 *
 * @author Camilo
 */

public class Pedido{
    private String numPedido;
    private LinkedList<Producto> productos = new LinkedList<>();
    private Sucursal sucursal;
}