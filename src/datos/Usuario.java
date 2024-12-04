package datos;

public class Usuario {
    private int idUsuario;
    private String nombre;
    private String apellido;
    private String user;
    private String clave;
    private String telefono;
    private boolean activo;
    
    public Usuario(){
        this.idUsuario = 0;
        this.nombre = "";
        this.apellido = "";
        this.user = "";
        this.clave = "";
        this.telefono = "";
        this.activo = false;
        
    }
    public Usuario(int idUsuario, String nombre, String apellido, String user, String clave, String telefono, boolean activo){
        this.idUsuario = idUsuario;
        this.nombre = nombre;
        this.apellido = apellido;
        this.user = user;
        this.clave = clave;
        this.telefono = telefono;
        this.activo = activo;
    }
    //Agregar metodos get y set para todos los atributos
    /*
    * Java Bean: una clase que contiene todas sus variables encapsuladas
    * a las cuales solo se puede acceder por medio de los metodos get y set
    */

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
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

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }
    
}
