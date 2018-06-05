package ar.com.eduit.curso.java.connector;

import java.sql.Connection;
import java.sql.DriverManager;

public class Connector {
    //driver version 5
    private static String driver="com.mysql.jdbc.Driver";
    //driver version 6 o superior
    //private static String driver="com.mysql.cj.jdbc.Driver";
    private static String vendor="mysql";
    private static String server="localhost";
    private static String port="3306";
    private static String db="colegio";
    private static String params="";
    //private static String params="?serverTimezone=UTC"; //para driver mysql6 o superior
    private static String user="root";
    private static String pass="";
    private static String url="jdbc:"+vendor+"://"+server+":"+port+"/"+db+params;
    private static Connection conn=null;
    private Connector(){}
    
    public static Connection getConnection(){
        if(conn==null){
            try {
                Class.forName(driver);
                conn=DriverManager.getConnection(url, user, pass);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return conn;
    }
    
}
