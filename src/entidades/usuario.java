package entidades;

/**
 *
 * @author felix
 */
public class usuario {
    //Variables de la entidad usuario
    private int codigo_empleado;
    private String usuario;
    private String clave;

    //Metodo getter y setter
    public int getCodigo_empleado() {
        return codigo_empleado;
    }

    public void setCodigo_empleado(int codigo_empleado) {
        this.codigo_empleado = codigo_empleado;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }
    
    
}
