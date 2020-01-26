/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;


/**
 *
 * @author NICOLE
 */
public class Entrega{
    private String Cliente;
    private String Direccion;
    private String Descripcion;
    private String Repartidor;
    private String Estado;

    public Entrega(String Cliente, String Direccion, String Descripcion, String Repartidor, String Estado) {
        this.Cliente = Cliente;
        this.Direccion = Direccion;
        this.Descripcion = Descripcion;
        this.Repartidor = Repartidor;
        this.Estado = Estado;
    }

    public String getCliente() {
        return Cliente;
    }

    public void setCliente(String Cliente) {
        this.Cliente = Cliente;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String Direccion) {
        this.Direccion = Direccion;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    public String getRepartidor() {
        return Repartidor;
    }

    public void setRepartidor(String Repartidor) {
        this.Repartidor = Repartidor;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String Estado) {
        this.Estado = Estado;
    }
    
    
    
    
}
