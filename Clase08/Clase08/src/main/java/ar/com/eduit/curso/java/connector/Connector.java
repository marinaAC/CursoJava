package ar.com.eduit.curso.java.connector;

import java.sql.Connection;
import java.sql.DriverManager;

public class Connector {
    //Driver maven version 8.0.11
    private static String driver = "com.mysql.cj.jdbc.Driver";
    //Version 5
    //private static String driver = "com.mysql.jdbc.Driver";
    
    private static String vendor = "mysql";
    private static String server = "localhost";
    private static String port = "3306";
    private static String db = "colegio";
    private static String user = "root";
    private static String params ="?serverTimezone=UTC";
    private static String pass= "";
    
    private static String url = "jdbc:"+vendor+"://"+server+":"+port+"/"+db+params;
    private static Connection conn = null;
    
    //Con el constructor privado, me aseguro que nadie pueda hacerun new Connector
    private Connector(){ }
    
    public static Connection getConecction(){
        if(conn==null){
            try {
                //estodevuelve el objeto clase del string que yo le diga
               Class.forName(driver);
               conn=DriverManager.getConnection(url,user,pass);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return conn;
    }
}
