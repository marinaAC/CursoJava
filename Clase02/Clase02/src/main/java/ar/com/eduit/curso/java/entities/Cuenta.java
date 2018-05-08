package ar.com.eduit.curso.java.entities;

public class Cuenta {

    private int nro;

    private String moneda;

    private float saldo;

    public Cuenta(int nro, String moneda) {
    }

    public float depositar(float monto) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public float debitar(float monto) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
