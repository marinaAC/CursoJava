package ar.com.eduit.curso.java.test;

import ar.com.eduit.curso.java.connector.Connector;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class TestConnector {

    public static void main(String[] args) throws Exception {
        Connection conn = Connector.getConecction();
        Statement statement = conn.createStatement();
        String query = "insert into cursos (titulo,profesor,dia,turno) values" + "('Java','Rios','martes','mañana')";
        statement.execute(query);

        Connector.getConecction().createStatement().execute("insert into cursos (titulo,profesor,dia,turno) values " + "('PHP','Gomez','viernes','tarde')");

        /*
            Metodo execute(query) ejecuta sentencias inserts delete update y devuelve true si la sentencia no es insert, delete o update, por ej select devuelve false.
            Metodo executeUpdate(query) ejecuta sentencias insert delete update y deuelve un enetero con la cantidad de registro modificados
            Metodo executeQuery(query) ejecuta sentencias select y devuelve un resultset
         */
        ResultSet rs = Connector.getConecction().createStatement().executeQuery("select * from cursos");
        //El metodo next lanza excepcionsql, me devuelve true si hay un proximo registro y va el apuntador al proximo regitro, false cuando no encuentra nada
        while (rs.next()) {
            System.out.println(
                    rs.getInt("idCurso") + "\t"
                    + rs.getString("titulo") + "\t"
                    + rs.getString("profesor") + "\t"
                    + rs.getString("dia") + "\t"
                    + rs.getString("turno"));
        }
    }
}
