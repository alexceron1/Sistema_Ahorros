package procesos;

import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;

import java.sql.SQLException;

public class Conexion {
       
        // La url para conectar a la base de datos
    private static String url = "jdbc:mysql://localhost/ahorros?caharacterEncoding=UTF8";

    // El usuario de la base de datos
    private static String user = "root";
    //La clave del usuario de la base de datos
    private static String password = "";

    //Metodo para obtener la conexion con la base de datos          
    public static synchronized Connection getConexion() {
        Connection cn = null;
        try {
            //Cargamos el driver y le decimos que vamos a usar una conexion con mysql
            //Class.forName("com.mysql.jdbc.Driver");
            Class.forName("com.mysql.cj.jdbc.Driver");
            //Obtenemos la conexion
            cn = DriverManager.getConnection(url, user, password);
        } catch (Exception e) {
            cn = null;
        } finally {
            return cn;
        }
    }

    //Metodo utilizado para cerrar la conexion
    public static synchronized void cerrarConexion(Connection cn) {
        try {
            cn.close();
        } catch (Exception e) {
        }
    }
}
