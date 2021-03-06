package dataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBManager {
    // JDBC driver name and database URL
    private final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  //donde va a quedar alojado
    private final String DB_URL = "jdbc:mysql://localhost:3306/serpiente?useSSL=false";//identificar la base de datos
    
    //  Database credentials
    private static final String USER = "root";
    private static final String PASS = "";
    
    private Connection conn = null;
    //archivo de conexion 
    //abrrir la conexion
    public Connection open() {
        try {
            Class.forName(JDBC_DRIVER);
            try {
            	conn = DriverManager.getConnection(DB_URL, USER, PASS);
            } catch (SQLException ex) {
                // log an exception. fro example:
                System.out.println("No se pudo conectar a la base de datos"); 
            }
        } catch (ClassNotFoundException ex) {
            // log an exception. for example:
            System.out.println("Driver no encontrado"); 
        }
        return conn;
    }
    
    //cerrar el puerto de conexion 
    public void close(){
    	try {
			conn.close();
		} catch (SQLException e) {
            System.out.println("No se pudo cerrar la conexi�n"); 
		}
    }
}

