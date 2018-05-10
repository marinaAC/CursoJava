
package ar.com.eduit.curso.java.test;

import ar.com.eduit.curso.java.entities.Cliente;
import ar.com.eduit.curso.java.entities.Cuenta;
import ar.com.eduit.curso.java.entities.Empleado;
import ar.com.eduit.curso.java.entities.Direccion;
import ar.com.eduit.curso.java.entities.Persona;

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
        
        System.out.println("--- Test Persona---");
        /*Cuando pasa a ser abstracta no se puede incovar al constructor
        Persona p1 = new Persona("Juan", "Perez", dir1);
        System.out.println(p1);
        
        Persona p2 = new Persona("Laura","Salas",dir2);
        System.out.println(p2);*/
        
        System.out.println("---- Test Empleado ----");
        Empleado e1 = new Empleado(1, 35000, "Leonardo", "Seriotti", dir1);
        e1.Saludar();
        System.out.println(e1);
        
        System.out.println("---- Test Cliente ----");
        Cliente c1 = new Cliente(1, new Cuenta(20, "args"), "Jose", "Palma", dir2);
        c1.Saludar();
        c1.getCuenta().depositar(2000);
        System.out.println(c1);
        
        System.out.println("---- Polimorfismo ----");
        //Polimorfismo
        Persona p1 = new Empleado(2, 50000, "Ana", "Garcia", dir2);
        Persona p2 = new Cliente (2,new Cuenta(21,"args"),"Javier", "Larrosa", dir1);
        
        //no se podria hacer un getCuenta, ya que eso le pertenece al cliente
        p1.Saludar();
        p2.Saludar();
        //Hay que castear esto, ya que java lo interpreta el global como persona
        Empleado emp1 = (Empleado)p1;
        //operador ternario
        Cliente cli1 = (p2 instanceof Cliente)?(Cliente)p2:null;
    }
}
