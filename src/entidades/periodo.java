package entidades;

import java.sql.Date;

/**
 *
 * @author felix
 */
public class periodo {
    //Variables de la entidad periodo
   
    private Date fecha_inicio;
    private Date fecha_fin;
    private String activo;

    
    public Date getFecha_inicio() {
        return fecha_inicio;
    }

    public void setFecha_inicio(Date fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }

    public Date getFecha_fin() {
        return fecha_fin;
    }

    public void setFecha_fin(Date fecha_fin) {
        this.fecha_fin = fecha_fin;
    }

    public String getActivo() {
        return activo;
    }

    public void setActivo(String activo) {
        this.activo = activo;
    }
}
    
  
   