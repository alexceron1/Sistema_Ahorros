package datos;

/**
 *
 * @author oscar
 */
public class Departamento {
    private int idDepartamento;
    private String nombre;

    public Departamento() {
        this.idDepartamento = 0;
        this.nombre = "";
    }
    public Departamento(int idDepartamento, String nombre) {
        this.idDepartamento = idDepartamento;
        this.nombre = nombre;
    }

    public int getIdDepartamento() {
        return idDepartamento;
    }

    public void setIdDepartamento(int idDepartamento) {
        this.idDepartamento = idDepartamento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    
}
