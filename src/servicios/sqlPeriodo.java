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

/**
 *
 * @author felix
 */
public class sqlPeriodo extends Conexion{
    public void fechaPeriodo(JComboBox comb, int columna){
    //Variables para la preparacion de conexion con la BD
        PreparedStatement ps = null;
        ResultSet rs= null;
        Connection con = getConexion();
        //Sentencia sql 
        String sql = "SELECT fecha_inicio FROM periodo";
        //Validacion por errores de conexion
        try{
            //Utilizacion de variables, para obtener datos de la BD
            ps= con.prepareStatement(sql);
            rs= ps.executeQuery();
            //Recorrer la BD
            while(rs.next()){
                comb.addItem(rs.getString(columna));
            }
            //comb.setSelectedIndex(-1);
            rs.close();
        }catch (SQLException ex){
             Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }    
    }
}
