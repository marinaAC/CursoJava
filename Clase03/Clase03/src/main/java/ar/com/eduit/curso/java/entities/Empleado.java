package ar.com.eduit.curso.java.entities;

public class Empleado extends Persona {
    private int legajo;
    private float sBasico;

    public Empleado(int legajo, float sBasico, String nombre, String apellido, Direccion direccion) {
        super(nombre, apellido, direccion);
        this.legajo = legajo;
        this.sBasico = sBasico;
    }
    
    @Override
    public void Saludar(){
    
        System.out.println("Hola soy un empleado");
    }

    //Tambien se puede utilizar el super para llamar al metodo de la clase padre
    @Override
    public String toString() {
        return "Empleado{" + "legajo=" + legajo + ", sBasico=" + sBasico + '}'+super.toString();
    }

    public int getLegajo() {
        return legajo;
    }

    public void setLegajo(int legajo) {
        this.legajo = legajo;
    }

    public float getsBasico() {
        return sBasico;
    }

    public void setsBasico(float sBasico) {
        this.sBasico = sBasico;
    }
    
    
}
