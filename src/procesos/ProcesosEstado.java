package procesos;

import datos.Estado;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author oscar
 */
public class ProcesosEstado {
    private PreparedStatement ps;
    private ResultSet rs; //Es una tabla con los datos retornados por la consulta
    private Connection con;
    private Estado es;
    
    public ProcesosEstado(){
        ps = null;
        rs = null;
        con = Conexion.getConexion();
    }
    
    // Consultar
    public List listar(){
        List<Estado> datos = new ArrayList<>();
        try{
            ps = con.prepareStatement("SELECT id_estado, nombre FROM estado");
            rs = ps.executeQuery();
            while (rs.next()){
                es = new Estado();
                es.setIdEstado(rs.getInt(1));//tipo de dato y posicion
                es.setNombre(rs.getString(2));
                datos.add(es);
            }
        } catch(Exception e){
        }
        return datos;
    }
    // Agregar estado
    public int Agregar(Estado est){
        int resultado = 0;
        String sql = "INSERT INTO estado (id_estado,nombre) VALUES (?,?)";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, est.getIdEstado());
            ps.setString(2, est.getNombre());
            resultado = ps.executeUpdate();
            if(resultado == 1){
                return 1;
            } else {
                return 0;
            }
        } catch (Exception e){
        }
        return resultado;
    }
    // Modificar estado
    public int modificar(Estado est){
        int resultado = 0;
        String sql = "UPDATE estado SET id_estado=?, nombre=?";
        try {
            ps.setInt(1, est.getIdEstado());
            ps.setString(2, est.getNombre());
            resultado = ps.executeUpdate();
            if(resultado == 1){
                return 1;
            } else {
                return 0;
            }
        } catch(Exception e){
            e.printStackTrace();
        }
        return resultado;
    }
    // Eliminar estado
    public int eliminar(int cod){
        int resultado = 0;
        String sql = "DELETE FROM estado WHERE id_estado="+cod;
        try {
            ps = con.prepareStatement(sql);
            resultado = ps.executeUpdate();
        } catch(Exception e){
        }
        return resultado;
    }
    
}
