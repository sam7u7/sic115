/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

public class estadoFinanciero {
    private int id_tipo_estado_financiero;
    private String fecha_inicio;
    private String fecha_fin;
    private double saldo_estado_financiero;
    //Metodos getter y setter
    public int getId_tipo_estado_financiero() {
        return id_tipo_estado_financiero;
    }

    public void setId_tipo_estado_financiero(int id_tipo_estado_financiero) {
        this.id_tipo_estado_financiero = id_tipo_estado_financiero;
    }

    public String getFecha_inicio() {
        return fecha_inicio;
    }

    public void setFecha_inicio(String fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }

    public String getFecha_fin() {
        return fecha_fin;
    }

    public void setFecha_fin(String fecha_fin) {
        this.fecha_fin = fecha_fin;
    }

    public double getSaldo_estado_financiero() {
        return saldo_estado_financiero;
    }

    public void setSaldo_estado_financiero(double saldo_estado_financiero) {
        this.saldo_estado_financiero = saldo_estado_financiero;
    }
    
}
