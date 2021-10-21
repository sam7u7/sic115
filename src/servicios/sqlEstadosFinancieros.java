/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicios;

import Conexiones.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import entidades.estadoFinanciero;
import entidades.movimiento;
import java.sql.Date;
import java.time.LocalDate;

/**
 *
 * @author felix
 */
public class sqlEstadosFinancieros extends Conexion{
    public void nombreEstado(JComboBox cbo, int columna){
        //Variables para la preparacion de conexion con la BD
        PreparedStatement ps = null;
        ResultSet rs= null;
        Connection con = getConexion();
        //Sentencia sql 
        String sql = "SELECT nombre_estado_financiero FROM tipoestadofinanciero";
        //Validacion por errores de conexion
        try{
            //Utilizacion de variables, para obtener datos de la BD
            ps= con.prepareStatement(sql);
            rs= ps.executeQuery();
            //Recorrer la BD
            while(rs.next()){
                cbo.addItem(rs.getString(columna));
            }
            //cbo.setSelectedIndex(-1);
            rs.close();
        }catch (SQLException ex){
             Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }    
    }
    
    public boolean agregarEstado(estadoFinanciero estado){
        //Variables para la preparacion de conexion con la BD
        PreparedStatement ps = null;
        Connection con = getConexion();
        //Sentencia sql 
        String sql = "INSERT INTO estadofinanciero (fecha_inicio, fecha_fin, saldo_estado_financiero, id_tipo_estado_financiero) VALUES (?,?,?,?)";
        //Validacion por errores de conexion
        try{
            //Utilizacion de variables, para obtener datos de la BD
            ps = con.prepareStatement(sql);
            ps.setDate(1, Date.valueOf(estado.getFecha_inicio()));
            ps.setDate(2, Date.valueOf(estado.getFecha_fin()));
            ps.setDouble(3, estado.getSaldo_estado_financiero());
            ps.setInt(4, estado.getId_tipo_estado_financiero());
            ps.execute();
            return true;
        }catch (SQLException ex){
             Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
             return false;
        } 
    }
    
    public double obtenerSaldoTotal(String ini, String fin){
        double saldo = 0;
        //Variables para la preparacion de conexion con la BD
        PreparedStatement ps = null;
        ResultSet rs= null;
        Connection con = getConexion();
        //Sentencia sql 
        String sql = "SELECT SUM(saldo_cuenta_saldada_debe) FROM cuentasaldada WHERE fecha_inicio = ? AND fecha_fin = ? ";
        //Validacion por errores de conexion
        try{
            //Utilizacion de variables, para obtener datos de la BD
            ps= con.prepareStatement(sql);
            ps.setDate(1, Date.valueOf(ini));
            ps.setDate(2, Date.valueOf(fin));
            rs= ps.executeQuery();
            //Recorrer la BD
            while(rs.next()){
                saldo = rs.getDouble(1);
            }
            rs.close();
            return saldo;
        }catch (SQLException ex){
             Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        } 
        return saldo;
    }
}
