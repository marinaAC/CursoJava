package ar.com.eduit.curso.java.dao.interfaces;

import ar.com.eduit.curso.java.entities.Curso;
import java.util.List;

public interface I_CursoR {
    void save(Curso curso);
    void remove(Curso curso);
    void update(Curso curso);
    Curso getById(int id);
    List<Curso>getAll();
    List<Curso>getByTitulo(String titulo);
    List<Curso>getLikeTitulo(String titulo);
    List<Curso>getByProfesor(String profesor);
    List<Curso>getLikeProfesor(String profesor);
    List<Curso>getByDia(String dia);
    List<Curso>getByTurno(String turno);
}
