package modelo;

/**
 *
 * @author Camilo
 */

public class Mascota{
    private Cliente owner;
    private String nombre;
    private String raza;
    private int edad;
    private float peso;
    private float altura;
    private String tipo;
    private String size;


    public Mascota(Cliente owner, String nombre, String raza, int edad, float peso, float altura, String tipo, String size) {
        this.owner = owner;
        this.nombre = nombre;
        this.raza = raza;
        this.edad = edad;
        this.peso = peso;
        this.altura = altura;
        this.tipo = tipo;
        this.size = size;
    }

    public Cliente getOwner() {
        return this.owner;
    }

    public void setOwner(Cliente owner) {
        this.owner = owner;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRaza() {
        return this.raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public int getEdad() {
        return this.edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public float getPeso() {
        return this.peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public float getAltura() {
        return this.altura;
    }

    public void setAltura(float altura) {
        this.altura = altura;
    }

    public String getTipo() {
        return this.tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getSize() {
        return this.size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    
    

}