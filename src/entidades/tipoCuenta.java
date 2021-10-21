package entidades;

public class tipoCuenta {
    //Variables de la entidad tipo cuenta
    private int id_tipo_cuenta;
    private String nombre_tipo_cuenta;    
    
    //Metodos getter y setter
    public int getId_tipo_cuenta() {
        return id_tipo_cuenta;
    }

    public void setId_tipo_cuenta(int id_tipo_cuenta) {
        this.id_tipo_cuenta = id_tipo_cuenta;
    }

    public String getNombre_tipo_cuenta() {
        return nombre_tipo_cuenta;
    }

    public void setNombre_tipo_cuenta(String nombre_tipo_cuenta) {
        this.nombre_tipo_cuenta = nombre_tipo_cuenta;
    }
    
}
