package ar.com.eduit.curso.java.test;

import ar.com.eduit.curso.java.entities.Cuenta;

public class TestRelaciones {
    public static void main(String[] args) {
        Cuenta cuenta1 = new Cuenta(1,"arg$");
        cuenta1.depositar(45000);
        cuenta1.depositar(12000);
        cuenta1.debitar(18000);
        System.out.println(cuenta1);
        
        Cuenta cuenta2 = new Cuenta(2,"Reales");
        cuenta2.depositar(20000);
        System.out.println(cuenta2);
    }
}
