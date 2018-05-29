package ar.com.eduit.curso.java.test;

import ar.com.eduit.curso.java.connector.Connector;
import java.sql.Connection;
import java.sql.Statement;


public class TestConnector {
    public static void main(String[] args) throws Exception {
        Connection conn =Connector.getConecction();
        Statement statement = conn.createStatement();
        String query = "insert into cursos (titulo,profesor,dia,turno) values"+"('Java','Rios','martes','mañana')";
        statement.execute(query);
    }
}
