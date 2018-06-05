package ar.com.eduit.curso.java.dao.repositorios;
import ar.com.eduit.curso.java.dao.interfaces.I_AlumnoR;
import ar.com.eduit.curso.java.entities.Alumno;
import ar.com.eduit.curso.java.entities.Curso;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
public class AlumnoR implements I_AlumnoR{
    private Connection conn;
    public AlumnoR(Connection conn) {
        this.conn = conn;
    }    
    @Override
    public void save(Alumno alumno) {
        if(alumno==null) return;
        try {
            PreparedStatement ps=conn.prepareStatement(
                "insert into alumnos (nombre,apellido,edad,idCurso) values (?,?,?,?)", 1
            );
            ps.setString(1, alumno.getNombre());
            ps.setString(2, alumno.getApellido());
            ps.setInt(3, alumno.getEdad());
            ps.setInt(4, alumno.getIdCurso());
            ps.execute();
            ResultSet rs=ps.getGeneratedKeys();
            if(rs.next()) alumno.setIdAlumno(rs.getInt(1));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Override
    public void remove(Alumno alumno) {
        if(alumno==null) return;
        try {
            PreparedStatement ps=conn.prepareStatement("delete from alumnos where idAlumno=?");
            ps.setInt(1, alumno.getIdAlumno());
            ps.execute();
            //alumno=new Alumno();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Override
    public void update(Alumno alumno) {
        if(alumno==null) return;
         try {
            PreparedStatement ps=conn.prepareStatement(
                    "update alumnos set nombre=?, apellido=?, edad=?, idCurso=? where idAlumno=?"
            );
            ps.setString(1, alumno.getNombre());
            ps.setString(2, alumno.getApellido());
            ps.setInt(3, alumno.getEdad());
            ps.setInt(4, alumno.getIdCurso());
            ps.setInt(5, alumno.getIdAlumno());
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private List<Alumno>getByFiltro(String filtro){
        List<Alumno>lista=new ArrayList();
        String query="select * from alumnos where "+filtro;
        System.out.println(query);
        try(ResultSet rs=conn.createStatement().executeQuery(query);){
            while(rs.next()){
                lista.add(
                        new Alumno(
                                rs.getInt("idAlumno"),
                                rs.getString("nombre"),
                                rs.getString("apellido"),
                                rs.getInt("edad"),
                                rs.getInt("idCurso")
                        )
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lista;
    }
    @Override
    public Alumno getById(int id) {
        List<Alumno>lista=getByFiltro("idAlumno="+id);
        return (lista.isEmpty())?null:lista.get(0);
    }
    @Override
    public Curso getCurso(Alumno alumno) {
        CursoR cr=new CursoR(conn);
        return cr.getById(alumno.getIdCurso());
    }
    @Override
    public List<Alumno> getAll() {
        return getByFiltro("1=1");
    }
    @Override
    public List<Alumno> getByApellido(String apellido) {
        return getByFiltro("apellido='"+apellido+"'");
    }
    @Override
    public List<Alumno> getLikeApellido(String apellido) {
        return getByFiltro("apellido like '%"+apellido+"%'");
    }
    @Override
    public List<Alumno> getByApellidoNombre(String apellido, String nombre) {
        return getByFiltro("apellido='"+apellido+"' and nombre='"+nombre+"'");
    }
    @Override
    public List<Alumno> getByCurso(Curso curso) {
        return getByFiltro("idCurso="+curso.getIdCurso());
    }
    @Override
    public List<Alumno> getByCurso(int idCurso) {
        return getByFiltro("idCurso="+idCurso);
    }    
}
