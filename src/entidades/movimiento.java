package entidades;


public class movimiento {
    //Variables de la entidad movimiento
    private int id_movimiento;
    private int id_cuenta;
    private String fecha;
    private String tipo;
    private double cantidad_movimiento_debe;
    private double cantidad_movimiento_haber;
    private String descripcion;
    //Metodos Getter y Setter
    public int getId_movimiento() {
        return id_movimiento;
    }

    public void setId_movimiento(int id_movimiento) {
        this.id_movimiento = id_movimiento;
    }

    public int getId_cuenta() {
        return id_cuenta;
    }

    public void setId_cuenta(int id_cuenta) {
        this.id_cuenta = id_cuenta;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public double getCantidad_movimiento_debe() {
        return cantidad_movimiento_debe;
    }

    public void setCantidad_movimiento_debe(double cantidad_movimiento_debe) {
        this.cantidad_movimiento_debe = cantidad_movimiento_debe;
    }
    
    public double getCantidad_movimiento_haber() {
        return cantidad_movimiento_haber;
    }

    public void setCantidad_movimiento_haber(double cantidad_movimiento_haber) {
        this.cantidad_movimiento_haber = cantidad_movimiento_haber;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    
}
