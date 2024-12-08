package datos;

/**
 *
 * @author oscar
 */
import java.util.Date;
public class Cliente {
    private int idCliente;
    private String dui;
    private String nombre;
    private String apellido;
    private String correo;
    private String telefono;
    private String direccion;
    private Date fechaNacimiento;
    private Date fechaCreacion;
    private Usuario usuario;

    public Cliente() {
        this.idCliente = 0;
        this.dui = "";
        this.nombre = "";
        this.apellido = "";
        this.correo = "";
        this.telefono = "";
        this.direccion = "";
        this.fechaNacimiento = new Date();
        this.fechaCreacion = new Date();
        this.usuario = new Usuario();
    }
    public Cliente(int idCliente, String dui, String nombre, String apellido, String correo, String telefono, String direccion,Date fechaNacimiento, Date fechaCreacion, Usuario usuario) {
        this.idCliente = idCliente;
        this.dui = dui;
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.telefono = telefono;
        this.direccion = direccion;
        this.fechaNacimiento = fechaNacimiento;
        this.fechaCreacion = fechaCreacion;
        this.usuario = usuario;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getDui() {
        return dui;
    }

    public void setDui(String dui) {
        this.dui = dui;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    
}
