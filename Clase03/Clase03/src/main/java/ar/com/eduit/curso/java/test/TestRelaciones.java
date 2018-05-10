package ar.com.eduit.curso.java.test;
import ar.com.eduit.curso.java.entities.ClienteEmpresa;
import ar.com.eduit.curso.java.entities.ClientePersona;
import ar.com.eduit.curso.java.entities.Cuenta;

import java.util.List;

public class TestRelaciones {
    public static void main(String[] args) {
        System.out.println("-- Cuentas --");
        Cuenta cuenta1=new Cuenta(1,"arg$");
        cuenta1.depositar(45000);
        cuenta1.depositar(12000);
        cuenta1.debitar(18000);
        System.out.println(cuenta1);
        
        Cuenta cuenta2=new Cuenta(2,"Reales");
        cuenta2.depositar(20000);
        System.out.println(cuenta2);
        
        System.out.println("-- Clientes Personas --");
        ClientePersona cp1=new ClientePersona(1, "Juan", "Perez", 3);
        Cuenta cuentaCli1=cp1.getCuenta();
        cuentaCli1.depositar(30000);
        cp1.getCuenta().depositar(20000);
        System.out.println(cp1);
        System.out.println(cp1.getCuenta());
        //cp1.setCuenta(cuenta2);
        
        System.out.println("-- Clientes Empresas --");
        ClienteEmpresa ce1=new ClienteEmpresa(1,"Todo Limpio srl", "Larrea 222");
        List<Cuenta> cuentas=ce1.getCuentas();
        cuentas.add(new Cuenta(10,"arg$"));
        cuentas.add(new Cuenta(11,"reales"));
        cuentas.add(new Cuenta(12,"u$s"));
        cuentas.get(0).depositar(30000);
        cuentas.get(0).debitar(13000);
        cuentas.get(1).depositar(10000);
        cuentas.get(1).depositar(5000);
        cuentas.get(2).depositar(12000);
        
        System.out.println(ce1);
        //recorrido por indices
        //for(int a=0;a<cuentas.size();a++) System.out.println(cuentas.get(a));
        
        //forEach
        //for(Cuenta c:cuentas) System.out.println(c);
        
        //Recorrido Java 8
        cuentas.forEach(System.out::println);
        
        
    }
}
