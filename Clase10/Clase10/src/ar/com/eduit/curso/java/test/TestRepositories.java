package ar.com.eduit.curso.java.test;

import ar.com.eduit.curso.java.connector.Connector;
import ar.com.eduit.curso.java.dao.repositorios.AlumnoR;
import ar.com.eduit.curso.java.dao.repositorios.CursoR;
import ar.com.eduit.curso.java.entities.Alumno;
import ar.com.eduit.curso.java.entities.Curso;

public class TestRepositories {
    public static void main(String[] args) {
        CursoR cr=new CursoR(Connector.getConnection());
        Curso curso=new Curso("HTML","Garcia","Lunes","Noche");
        cr.save(curso);
        System.out.println(curso);
        
        cr.remove(cr.getById(10));
        
        curso=cr.getById(6);
        if(curso!=null){
            curso.setDia("Martes");
            cr.update(curso);
        }
        
        
        System.out.println("-------------------------------------------------");
        cr.getAll().forEach(System.out::println);
        //cr.getLikeProfesor("Go").forEach(System.out::println);
        
        AlumnoR ar=new AlumnoR(Connector.getConnection());
        Alumno alumno=new Alumno("Carla","Diaz",22,1);
        ar.save(alumno);
        System.out.println(alumno);
        ar.save(new Alumno("Laura","Diaz",24,2));
        ar.save(new Alumno("Mario","Loza",44,2));
        ar.save(new Alumno("Mirta","Perez",35,5));
        ar.save(new Alumno("Lautaro","Borgia",33,3));
        ar.save(new Alumno("Mauro","Ayala",21,2));
        ar.save(new Alumno("Roberto","Carlos",66,5));
        
        alumno=ar.getById(11);
        ar.remove(alumno);
        System.out.println(alumno);
        
        alumno=ar.getById(8);
        if(alumno!=null){
            alumno.setNombre("Carolina");
            ar.update(alumno);
        }
        
        ar.getAll().forEach(System.out::println);
        //ar.getByCurso(2).forEach(System.out::println);
        //ar.getByCurso(curso).forEach(System.out::println);
        //ar.getLikeApellido("per").forEach(System.out::println);
        
    }
}
