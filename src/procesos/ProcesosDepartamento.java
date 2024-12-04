package procesos;

import datos.Departamento;
import java.sql.Connection;
import java.sql.PreparedStatement; 
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author oscar
 */
public class ProcesosDepartamento {
    private PreparedStatement ps;
    private ResultSet rs; //Es una tabla con los datos retornados por la consulta
    private Connection con;
    private Departamento d;
    
    public ProcesosDepartamento(){
        ps = null;
        rs = null;
        con = Conexion.getConexion();
    }
    
    // Consultar
    public List listar(){
        List<Departamento> datos = new ArrayList<>();
        try{
            ps = con.prepareStatement("SELECT id_departamento, nombre FROM departamento");
            rs = ps.executeQuery();
            while (rs.next()){
                d = new Departamento();
                d.setIdDepartamento(rs.getInt(1));//tipo de dato y posicion
                d.setNombre(rs.getString(2));
                datos.add(d);
            }
        } catch(Exception e){
        }
        return datos;
    }
    // Agregar departamento
    public int Agregar(Departamento dep){
        int resultado = 0;
        String sql = "INSERT INTO departamento (id_departamento,nombre) VALUES (?,?)";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, dep.getIdDepartamento());
            ps.setString(2, dep.getNombre());
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
    // Modificar departamento
    public int modificar(Departamento dep){
        int resultado = 0;
        String sql = "UPDATE departamento SET id_departamento=?, nombre=?";
        try {
            ps.setInt(1, dep.getIdDepartamento());
            ps.setString(2, dep.getNombre());
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
    // Eliminar departamento
    public int eliminar(int cod){
        int resultado = 0;
        String sql = "DELETE FROM departamento WHERE id_departamento="+cod;
        try {
            ps = con.prepareStatement(sql);
            resultado = ps.executeUpdate();
        } catch(Exception e){
        }
        return resultado;
    }
}
