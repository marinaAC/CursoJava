package ar.com.eduit.curso.java.dao.repositorios;
import ar.com.eduit.curso.java.connector.Connector;
import ar.com.eduit.curso.java.dao.interfaces.I_CursoR;
import ar.com.eduit.curso.java.entities.Curso;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
public class CursoR implements I_CursoR{
    private Connection conn;
    public CursoR(Connection conn) {
        this.conn = conn;
    }
    @Override
    public void save(Curso curso) {
        //String query="insert into cursos (titulo,profesor,dia,turno) values "
        //        + "('"+curso.getTitulo()+"','"+curso.getProfesor()
        //        + "','"+ curso.getDia()+"','"+curso.getTurno()+"')";
        if(curso==null) return;
        try {
            //a partir de java 6 existe PreparedStatement
            PreparedStatement ps=conn.prepareStatement(
                    "insert into cursos (titulo,profesor,dia,turno) values (?,?,?,?)",
                    PreparedStatement.RETURN_GENERATED_KEYS
            );
            ps.setString(1, curso.getTitulo());
            ps.setString(2, curso.getProfesor());
            ps.setString(3, curso.getDia());
            ps.setString(4, curso.getTurno());
            ps.execute();
            ResultSet rs=ps.getGeneratedKeys();
            if(rs.next()) curso.setIdCurso(rs.getInt(1));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Override
    public void remove(Curso curso) {
        if(curso==null) return;
        try {
            PreparedStatement ps=conn.prepareStatement("delete from cursos where idCurso=?");
            ps.setInt(1, curso.getIdCurso());
            ps.execute();
            curso=null;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Override
    public void update(Curso curso) {
        if(curso==null) return;
        try {
            PreparedStatement ps=conn.prepareStatement(
                "update cursos set titulo=?, profesor=?, dia=?, turno=? where idCurso=?"
            );
            ps.setString(1, curso.getTitulo());
            ps.setString(2, curso.getProfesor());
            ps.setString(3, curso.getDia());
            ps.setString(4, curso.getTurno());
            ps.setInt(5, curso.getIdCurso());
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private List<Curso> getByFiltro(String filtro){
        List<Curso> lista=new ArrayList();
        String query="select * from cursos where "+filtro;
        System.out.println(query);
        try( ResultSet rs=conn.createStatement().executeQuery(query); ) {
            while(rs.next()){
                lista.add(
                        new Curso(
                                rs.getInt("idCurso"),
                                rs.getString("titulo"),
                                rs.getString("profesor"),
                                rs.getString("dia"),
                                rs.getString("turno")
                        )
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lista;
    }
    @Override
    public Curso getById(int id) {
        List<Curso>lista=getByFiltro("idCurso="+id);
        return (lista.isEmpty())?null:lista.get(0);
    }
    @Override
    public List<Curso> getAll() {
        return getByFiltro("1=1");
    }
    @Override
    public List<Curso> getByTitulo(String titulo) {
        return getByFiltro("titulo='"+titulo+"'");
    }
    @Override
    public List<Curso> getLikeTitulo(String titulo) {
        return getByFiltro("titulo like '%"+titulo+"%'");
    }
    @Override
    public List<Curso> getByProfesor(String profesor) {
        return getByFiltro("profesor='"+profesor+"'");
    }
    @Override
    public List<Curso> getLikeProfesor(String profesor) {
        return getByFiltro("profesor like '%"+profesor+"%'");
    }
    @Override
    public List<Curso> getByDia(String dia) {
        return getByFiltro("dia='"+dia+"'");
    }
    @Override
    public List<Curso> getByTurno(String turno) {
        return getByFiltro("turno='"+turno+"'");
    } 
}
