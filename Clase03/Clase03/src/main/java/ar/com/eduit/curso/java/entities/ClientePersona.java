package ar.com.eduit.curso.java.entities;

public class ClientePersona {
    private int nro;
    private String nombre;
    private String apellido;
    private Cuenta cuenta;
    public ClientePersona(int nro, String nombre, String apellido, int nroCuenta) {
        this.nro=nro;
        this.nombre=nombre;
        this.apellido=apellido;
        this.cuenta=new Cuenta(nroCuenta,"arg$");
    }
    @Override
    public String toString() {
        return "ClientePersona{" + "nro=" + nro + ", nombre=" + nombre + ", apellido=" + apellido + ", cuenta=" + cuenta + '}';
    }
    public int getNro() {
        return nro;
    }
    public void setNro(int nro) {
        this.nro = nro;
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
    public Cuenta getCuenta() {
        return cuenta;
    }
    public void setCuenta(Cuenta cuenta) {
        this.cuenta = cuenta;
    }
}
