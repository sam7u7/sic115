package servicios;

import Conexiones.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import entidades.movimiento;
import java.sql.Date;
import java.util.List;
import modelos.ModeloNoEditable;


public class sqlMovimiento extends Conexion {
       public void cuenta(JComboBox cbo, int columna){
        //Variables para la preparacion de conexion con la BD
        PreparedStatement ps = null;
        ResultSet rs= null;
        Connection con = getConexion();
        String sql = "SELECT id_cuenta, nombre_cuenta FROM cuenta";
        //Validacion por errores de conexion
        try{
            //Utilizacion de variables, para obtener datos de la BD
            ps= con.prepareStatement(sql);
            rs= ps.executeQuery();
            //Recorrer la BD
            while(rs.next()){
                cbo.addItem(rs.getString(2));
            }
            cbo.setSelectedIndex(-1);
            rs.close();
        }catch (SQLException ex){
             Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
       
        public boolean agregar(List<movimiento> mov){
       //Variables para la preparacion de conexion con la BD
        PreparedStatement ps = null;
        Connection con = getConexion();
        String sql = "INSERT INTO movimiento (id_cuenta, fecha, tipo, descripcion, cantidad_debe, cantidad_haber) VALUES (?,?,?,?,?,?)";
        //Validacion por errores de conexion
        try{
            //Utilizacion de variables, para obtener datos de la BD
            for(int i=0; i < mov.size();i++){
                ps = con.prepareStatement(sql);
                ps.setInt(1, mov.get(i).getId_cuenta());
                ps.setDate(2, Date.valueOf(mov.get(i).getFecha()));
                ps.setString(3, mov.get(i).getTipo());
                ps.setString(4, mov.get(i).getDescripcion());
                ps.setDouble(5, mov.get(i).getCantidad_movimiento_debe());
                ps.setDouble(6, mov.get(i).getCantidad_movimiento_haber());
                ps.execute();
                ps = null;
            }
            return true;
        }catch (SQLException ex){
             Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
             return false;
        }
        
    }
        
        public int obtenerId(String nom){
        int id=0;
        //Variables para la preparacion de conexion con la BD
        PreparedStatement ps = null;
        ResultSet rs= null;
        Connection con = getConexion();
        String sql = "SELECT id_cuenta FROM cuenta WHERE nombre_cuenta=?";
        //Validacion por errores de conexion
        try{
            //Utilizacion de variables, para obtener datos de la BD
            ps= con.prepareStatement(sql);
            ps.setString(1, nom);
            rs= ps.executeQuery();
            while(rs.next()){
                id = rs.getInt(1);
            }
            return id;
        }catch (SQLException ex){
             Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return id;
    }
        
    public void limpiarModelo(ModeloNoEditable mdt){
    while(mdt.getRowCount()>0){
        mdt.removeRow(0);
    }
}
}
