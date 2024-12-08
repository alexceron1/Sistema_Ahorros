package procesos;

//import java.sql.*;
import datos.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
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
            tabla = instruccion.executeQuery("SELECT count(*), id_usuario, nombre, apellido FROM usuario where user = LOWER('" + usu + "') and clave = '" + cla + "' and activo = 1");
            tabla.next();
            if (tabla.getInt(1) == 0) {
                return false;
            } else {
                Usuario u = new Usuario();
                u.setIdUsuario(tabla.getInt(2));
                u.setNombre(tabla.getString(3));
                u.setApellido(tabla.getString(4));
                Sesion.setUsuario(u);
                return true;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

}
