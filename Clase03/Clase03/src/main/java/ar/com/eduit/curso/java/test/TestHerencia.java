
package ar.com.eduit.curso.java.test;

import ar.com.eduit.curso.java.entities.Direccion;

/**
 * Donde se testeara las herencias
 */
public class TestHerencia {
    public static void main(String[] args) {
        
        
        System.out.println("--- Direccion ---");
        Direccion dir1 = new Direccion("Lima", "222", "2", "a");
        System.out.println(dir1);
        
        Direccion dir2 = new Direccion("Viel","350","3","b");
        System.out.println(dir2);
        
    }
}
