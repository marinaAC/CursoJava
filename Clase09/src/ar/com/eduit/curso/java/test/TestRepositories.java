/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.eduit.curso.java.test;

import ar.com.eduit.curso.java.connector.Connector;
import ar.com.eduit.curso.java.dao.repositorios.CursoR;
import ar.com.eduit.curso.java.entities.Curso;
import java.util.Set;

/**
 *
 * @author EducaciónIT
 */
public class TestRepositories {
    public static void main(String[] args) {
        CursoR cr = new CursoR(Connector.getConnection());
        Curso curso = new Curso("HTML","Garcia","Lunes","Noche");
        cr.save(curso);
        System.out.println(curso);
        cr.remove(cr.getById(10));
        
        curso=cr.getById(6);
        if(curso!=null){
            curso.setDia("Martes");
            cr.update(curso);
        }
        
        System.out.println("------------------------");
        cr.getAll().forEach(System.out::println);
       // cr.getLikeProfesor("Go").forEach(System.out::println);
        
    }
}
