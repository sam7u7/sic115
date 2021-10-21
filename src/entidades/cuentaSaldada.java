package entidades;

/**
 *
 * @author felix
 */
public class cuentaSaldada {
    //Variables de la entidad cuenta saldada
    private int id_cuenta_saldada;
    private int id_cuenta;
    private int id_periodo;
    private double saldo_cuenta_saldada_debe;
    private double saldo_cuenta_saldada_haber;

    public int getId_cuenta_saldada() {
        return id_cuenta_saldada;
    }

    public void setId_cuenta_saldada(int id_cuenta_saldada) {
        this.id_cuenta_saldada = id_cuenta_saldada;
    }

    public int getId_cuenta() {
        return id_cuenta;
    }

    public void setId_cuenta(int id_cuenta) {
        this.id_cuenta = id_cuenta;
    }

    public int getId_periodo() {
        return id_periodo;
    }

    public void setId_periodo(int id_periodo) {
        this.id_periodo = id_periodo;
    }

    public double getSaldo_cuenta_saldada_debe() {
        return saldo_cuenta_saldada_debe;
    }

    public void setSaldo_cuenta_saldada_debe(double saldo_cuenta_saldada_debe) {
        this.saldo_cuenta_saldada_debe = saldo_cuenta_saldada_debe;
    }

    public double getSaldo_cuenta_saldada_haber() {
        return saldo_cuenta_saldada_haber;
    }

    public void setSaldo_cuenta_saldada_haber(double saldo_cuenta_saldada_haber) {
        this.saldo_cuenta_saldada_haber = saldo_cuenta_saldada_haber;
    }
}
