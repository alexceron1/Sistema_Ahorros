package procesos;

/**
 *
 * @author oscar
 */
import datos.TipoCuenta;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
public class ProcesosTipoCuenta {
    private PreparedStatement ps;
    private ResultSet rs; //Es una tabla con los datos retornados por la consulta
    private Connection con;
    private TipoCuenta tc;
    
    public ProcesosTipoCuenta(){
        ps = null;
        rs = null;
        con = Conexion.getConexion();
    }
    // Consultar
    public List listar(){
        List<TipoCuenta> datos = new ArrayList<>();
        try{
            ps = con.prepareStatement("SELECT id_tipo_cuenta, nombre FROM tipo_cuenta");
            rs = ps.executeQuery();
            while (rs.next()){
                tc = new TipoCuenta();
                tc.setIdTipoCuenta(rs.getInt(1));//tipo de dato y posicion
                tc.setNombre(rs.getString(2));
                datos.add(tc);
            }
        } catch(Exception e){
        }
        return datos;
    }
    // Agregar Tipo cuenta
    public int agregar(TipoCuenta tCuenta){
        int resultado = 0;
        String sql = "INSERT INTO tipo_cuenta (id_tipo_cuenta,nombre) VALUES (?,?)";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, tCuenta.getIdTipoCuenta());
            ps.setString(2, tCuenta.getNombre());
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
    // Modificar tipo cuenta
    public int modificar(TipoCuenta tCuenta){
        int resultado = 0;
        String sql = "UPDATE tipo_cuenta SET nombre=? WHERE id_tipo_cuenta=?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, tCuenta.getNombre());
            ps.setInt(2, tCuenta.getIdTipoCuenta());
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
    // Eliminar tipo cuenta
    public int eliminar(int cod){
        int resultado = 0;
        String sql = "DELETE FROM tipo_cuenta WHERE id_tipo_cuenta="+cod;
        try {
            ps = con.prepareStatement(sql);
            resultado = ps.executeUpdate();
        } catch(Exception e){
        }
        return resultado;
    }
}
