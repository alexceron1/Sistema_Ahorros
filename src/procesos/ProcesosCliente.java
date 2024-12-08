package procesos;

/**
 *
 * @author oscar
 */
import datos.Cliente;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.sql.Timestamp;
import java.util.Date;
public class ProcesosCliente {
    private PreparedStatement ps;
    private ResultSet rs; //Es una tabla con los datos retornados por la consulta
    private Connection con;
    private Cliente c;
    private SimpleDateFormat formato;

    public ProcesosCliente() {
        this.ps = null;
        this.rs = null;
        this.con = Conexion.getConexion();
        formato = new SimpleDateFormat("yyyy-MM-dd");
    }
    // Consultar
    public List listar(){
        List<Cliente> datos = new ArrayList<>();
        try{
            ps = con.prepareStatement("select id_cliente, dui, nombre, apellido, correo, telefono, direccion, fecha_nacimiento, fecha_creacion, id_usuario from cliente");
            rs = ps.executeQuery();
            while (rs.next()){
                c = new Cliente();
                c.setIdCliente(rs.getInt(1));//tipo de dato y posicion
                c.setDui(rs.getString(2));
                c.setNombre(rs.getString(3));
                c.setApellido(rs.getString(4));
                c.setCorreo(rs.getString(5));
                c.setTelefono(rs.getString(6));
                c.setDireccion(rs.getString(7));
                c.setFechaNacimiento(rs.getDate(8));
                c.setFechaCreacion(rs.getDate(9));
                c.setUsuario(null);//corregir
                datos.add(c);
            }
        } catch(Exception e){
        }
        return datos;
    }
    // Agregar cliente
    public int agregar(Cliente cli){
        int resultado = 0;
        String sql = "INSERT INTO cliente(id_cliente, dui, nombre, apellido, correo, telefono, direccion, fecha_nacimiento, fecha_creacion, id_usuario)VALUES(?,?,?,?,?,?,?,?,?,?)";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, cli.getIdCliente());
            ps.setString(2, cli.getDui());
            ps.setString(3, cli.getNombre());
            ps.setString(4, cli.getApellido());
            ps.setString(5, cli.getCorreo());
            ps.setString(6, cli.getTelefono());
            ps.setString(7, cli.getDireccion());
            ps.setDate(8, new java.sql.Date(cli.getFechaNacimiento().getTime()));//(java.sql.Date)cli.getFechaNacimiento(
            ps.setTimestamp(9, new Timestamp(new Date().getTime()));
            //ps.setDate(9, new java.sql.Date(cli.getFechaCreacion().getTime()));
            ps.setInt(10, cli.getUsuario().getIdUsuario());//Arreglar la relaciontte
            resultado = ps.executeUpdate();
            if(resultado == 1){
                return 1;
            } else {
                return 0;
            }
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        return resultado;
    }
    // Modificar cliente
    public int modificar(Cliente cli){
        int resultado = 0;
        String sql = "UPDATE cliente SET dui=?,nombre=?,apellido=?,correo=?,telefono=?,direccion=?,fecha_nacimiento=?,id_usuario=? WHERE id_cliente=?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, cli.getDui());
            ps.setString(2, cli.getNombre());
            ps.setString(3, cli.getApellido());
            ps.setString(4, cli.getCorreo());
            ps.setString(5, cli.getTelefono());
            ps.setString(6, cli.getDireccion());
            ps.setDate(7, new java.sql.Date(cli.getFechaNacimiento().getTime())); //(java.sql.Date)cli.getFechaNacimiento()
            ps.setInt(8, 1);
            ps.setInt(9, cli.getIdCliente());
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
    // Eliminar cliente
    public int eliminar(int cod){
        int resultado = 0;
        String sql = "delete from cliente where id_cliente="+cod;
        try {
            ps = con.prepareStatement(sql);
            resultado = ps.executeUpdate();
        } catch(Exception e){
        }
        return resultado;
    }
    
}
