
package ar.com.eduit.curso.java.dao.interfaces;

import ar.com.eduit.curso.java.entities.Curso;
import java.util.List;

/**
 * Curso repositorio
 */
public interface I_CursoR {
    ///Dao data access objects
    ///Abstrae al usuario de la base de datos
    ///Tambien habitualmente se le llaman dao a los repositorios
    void save(Curso curso);
    void remove(Curso curso);
    void update(Curso curso);
    Curso getById(int id);
    List<Curso>getAll();
    List<Curso>getByTitulo(String titulo);
    List<Curso>getByLikeTitulo(String titulo);
    List<Curso>getByProfesor(String profesor);
    List<Curso>getByLikeProfesor(String profesor);
    List<Curso>getByDia(String dia);
    List<Curso>getByTurno(String turno);
    
}
