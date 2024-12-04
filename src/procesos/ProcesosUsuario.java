package procesos;

//import java.sql.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class ProcesosUsuario {    
    private Connection conexion;
    private Statement instruccion;
    private ResultSet tabla;

    public ProcesosUsuario() {
        tabla = null;
        try {
            conexion = Conexion.getConexion();
            instruccion = conexion.createStatement();
        } catch (SQLException ex) {
            System.out.println("Error");
        }
    }

    public boolean existeUsuario(String usu, String cla) {
        try {
            tabla = instruccion.executeQuery("SELECT count(*) FROM usuario where user = '" + usu + "' and clave = '" + cla + "' and activo = 1");
            tabla.next();
            if (tabla.getInt(1) == 0) {
                return false;
            } else {
                return true;
            }
        } catch (Exception ex) {
            return false;
        }
    }

}
