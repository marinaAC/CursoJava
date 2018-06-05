package ar.com.eduit.curso.java.test;

import ar.com.eduit.curso.java.connector.Connector;
import ar.com.eduit.curso.java.dao.generic.GenericR;
import ar.com.eduit.curso.java.entities.Alumno;
import ar.com.eduit.curso.java.entities.Curso;

public class TestGeneric {
    public static void main(String[] args) {
        GenericR<Alumno> ar=new GenericR(Connector.getConnection(),Alumno.class);
        GenericR<Curso>  cr=new GenericR(Connector.getConnection(),Curso.class);
        
        ar.save(new Alumno("Nicolas","Lodo",22,1));
        cr.save(new Curso("git","Soto","Jueves","Tarde"));
        
        ar.getAll().forEach(System.out::println);
        cr.getAll().forEach(System.out::println);
        System.out.println("---------------------------");
        ar.getByFiltro("nombre like '%nic%'").forEach(System.out::println);
    }
}
