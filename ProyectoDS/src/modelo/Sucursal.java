package modelo;


/**
 *
 * @author Camilo
 */

public class Sucursal{
    private String numSucursal;
    private String direccion;
    private String telefono;

    public Sucursal(String numSucursal, String direccion, String telefono) {
        this.numSucursal = numSucursal;
        this.direccion = direccion;
        this.telefono = telefono;
    }

    public String getNumSucursal() {
        return numSucursal;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getTelefono() {
        return telefono;
    }
    
    
}