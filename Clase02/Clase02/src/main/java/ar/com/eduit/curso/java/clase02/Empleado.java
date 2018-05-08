//En que paquete esta la clase, este package es un subdirectorio
package ar.com.eduit.curso.java.clase02;


public class Empleado {
    private int legajo;
    private String nombre;
    private String apellido;
    private float basico;

    public Empleado(int legajo, String nombre, String apellido, float basico) {
        this.legajo = legajo;
        this.nombre = nombre;
        this.apellido = apellido;
        this.basico = basico;
    }
    
    //Paradigma de aspectos:
    //cuando algo se repite, no hay que encapsular en un metodo privado. Sino que se prepara para q esa linea sea inyectada
    //en tiempo de compilacion
    //Ej: java web lo realiza para inyectar la hoja de estilos

    @Override
    public String toString() {
        return "Empleado{" + "legajo=" + legajo + ", nombre=" + nombre + ", apellido=" + apellido + ", basico=" + basico + '}';
    }

    //encapsulate field, le pone privacidad a los atributo
    public int getLegajo() {
        return legajo;
    }

    public void setLegajo(int legajo) {
        this.legajo = legajo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public float getBasico() {
        return basico;
    }

    public void setBasico(float basico) {
        this.basico = basico;
    }
    
    
}
