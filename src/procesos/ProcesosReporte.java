package procesos;

/**
 *
 * @author oscar
 */
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;
public class ProcesosReporte {
    public void generarListadoClientes (String departamento, Date fechaInicio, Date fechaFin){
        try {
            //Ruta al archivo jasper
            String reportePath = getClass().getResource("/reportes/DemoClientes3.jasper").getPath();
            // Parámetros para el reporte
            Map<String, Object> parametros = new HashMap<>();
            parametros.put("direccion", departamento);
            parametros.put("fecha_inicio", fechaInicio);
            parametros.put("fecha_fin", fechaFin);

            JasperPrint jasperPrint = JasperFillManager.fillReport(reportePath, parametros, Conexion.getConexion());
            // Mostrar el reporte en un visor
            JasperViewer.viewReport(jasperPrint, false);
        } catch (JRException ex) {
            System.out.println(ex.getMessage());
        }
    }
    public void generarListadoDepartamentos (){
        try {
            //Ruta al archivo jasper
            String reportePath = getClass().getResource("/reportes/DemoDepartamentos.jasper").getPath();

            JasperPrint jasperPrint = JasperFillManager.fillReport(reportePath,null ,Conexion.getConexion());
            // Mostrar el reporte en un visor
            JasperViewer.viewReport(jasperPrint, false);
        } catch (JRException ex) {
            System.out.println(ex.getMessage());
        }
    }
    public void generarListadoEstados(){
        try {
            //Ruta al archivo jasper
            String reportePath = getClass().getResource("/reportes/DemoEstados.jasper").getPath();

            JasperPrint jasperPrint = JasperFillManager.fillReport(reportePath,null ,Conexion.getConexion());
            // Mostrar el reporte en un visor
            JasperViewer.viewReport(jasperPrint, false);
        } catch (JRException ex) {
            System.out.println(ex.getMessage());
        }
    }
    public void generarListadoTiposCuentas (){
        try {
            //Ruta al archivo jasper
            String reportePath = getClass().getResource("/reportes/DemoTipoCuenta2.jasper").getPath();

            JasperPrint jasperPrint = JasperFillManager.fillReport(reportePath,null ,Conexion.getConexion());
            // Mostrar el reporte en un visor
            JasperViewer.viewReport(jasperPrint, false);
        } catch (JRException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
