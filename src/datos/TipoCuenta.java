package datos;

/**
 *
 * @author oscar
 */

public class TipoCuenta {
    private int idTipoCuenta;
    private String nombre;
    public TipoCuenta (){
        idTipoCuenta = 0;
        nombre = "";
    }
    public TipoCuenta(int idTipoCuenta, String nombre){
        this.idTipoCuenta = idTipoCuenta;
        this.nombre = nombre;
    }

    public int getIdTipoCuenta() {
        return idTipoCuenta;
    }

    public void setIdTipoCuenta(int idTipoCuenta) {
        this.idTipoCuenta = idTipoCuenta;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}

