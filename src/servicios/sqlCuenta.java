package servicios;

import Conexiones.*;
import entidades.*;
import modelos.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JList;

public class sqlCuenta extends Conexion {
    public void tipoCuenta(JComboBox cbo, int columna){
    //Variables para la preparacion de conexion con la BD
        PreparedStatement ps = null;
        ResultSet rs= null;
        Connection con = getConexion();
        //Sentencia sql 
        String sql = "SELECT nombre_tipo_cuenta FROM tipocuenta";
        //Validacion por errores de conexion
        try{
            //Utilizacion de variables, para obtener datos de la BD
            ps= con.prepareStatement(sql);
            rs= ps.executeQuery();
            while(rs.next()){
                cbo.addItem(rs.getString(columna));
            }
            cbo.setSelectedIndex(-1);
            rs.close();
        }catch (SQLException ex){
             Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }    
    }
    
    public boolean agregar(cuenta cuen){
       //Variables para la preparacion de conexion con la BD
        PreparedStatement ps = null;
        Connection con = getConexion();
        String sql = "INSERT INTO cuenta (id_cuenta, id_tipo_cuenta, nombre_cuenta) VALUES (?,?,?)";
        //Validacion por errores de conexion
        try{
            //Utilizacion de variables, para obtener datos de la BD
            ps = con.prepareStatement(sql);
            ps.setInt(1, cuen.getId_cuenta());
            ps.setInt(2, cuen.getId_tipo_cuenta());
            ps.setString(3, cuen.getNombre_cuenta());
            ps.execute();
            return true;
        }catch (SQLException ex){
             Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
             return false;
        }  
    }
    
    public boolean actualizar(cuenta cuen, int id){
       //Variables para la preparacion de conexion con la BD
        PreparedStatement ps = null;
        Connection con = getConexion();
        String sql = "UPDATE cuenta SET id_cuenta=? ,id_tipo_cuenta=? ,nombre_cuenta=? WHERE id_cuenta=?";
        //Validacion por errores de conexion
        try{
            //Utilizacion de variables, para obtener datos de la BD
            ps = con.prepareStatement(sql);
            ps.setInt(1, cuen.getId_cuenta());
            ps.setInt(2, cuen.getId_tipo_cuenta());
            ps.setString(3, cuen.getNombre_cuenta());
            ps.setInt(4, id);
            ps.execute();
            return true;
        }catch (SQLException ex){
             Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
             return false;
        }  
    }
    
    public void limpiarModelo(ModeloNoEditable mdt){
        while(mdt.getRowCount()>0){
            mdt.removeRow(0);
        }
    }
       
    public void llenarTabla(ModeloNoEditable md1, int cantColum){
        limpiarModelo(md1);
        int i = 0;
        String[] Data = new String[20];
        //Variables para la preparacion de conexion con la BD
        PreparedStatement ps = null;
        ResultSet rs= null;
        Connection con = getConexion();
        String sql = "SELECT c.id_cuenta, t.nombre_tipo_cuenta, c.nombre_cuenta FROM cuenta c inner join tipocuenta t on c.id_tipo_cuenta=t.id_tipo_cuenta";
        //Validacion por errores de conexion
        try{
            //Utilizacion de variables, para obtener datos de la BD
            ps= con.prepareStatement(sql);
            rs= ps.executeQuery();
            //Recorrer la BD
            while(rs.next()){
                for(i=1;i<=cantColum;i++){
                    Data[i-1] = rs.getString(i);
                }
                md1.addRow(Data);
            }
            rs.close();
        }catch (SQLException ex){
             Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }  
    }
    
    public void obtenerDatos(JTextField id,JTextField nombre,JComboBox tipo, String codigo){
        //Variables para la preparacion de conexion con la BD
        PreparedStatement ps = null;
        ResultSet rs= null;
        String sql = "SELECT id_cuenta, id_tipo_cuenta, nombre_cuenta FROM cuenta WHERE id_cuenta=?"; 
        //Validacion por errores de conexion
        try{
            //Utilizacion de variables, para interactuar con la BD
            Connection con = getConexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, Integer.parseInt(codigo));
            rs = ps.executeQuery();
            //Recorrer la BD
            while(rs.next()){
                id.setText(rs.getString("id_cuenta"));
                nombre.setText(rs.getString("nombre_cuenta"));
                tipo.setSelectedIndex(rs.getInt("id_tipo_cuenta")-1);
            }
        }catch (SQLException ex){
             Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
    
    public void eliminarDato(String codigo){
        //Variables para la preparacion de conexion con la BD
        PreparedStatement ps = null;
        String sql = "DELETE FROM cuenta WHERE id_cuenta=?";
        try{
            //Utilizacion de variables, para interactuar con la BD
            Connection con = getConexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, Integer.parseInt(codigo));
            ps.execute();
        }catch (SQLException ex){
             Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void mostrarSubCuenta(JList lista, String nombre, String text){
        //Variables para la preparacion de conexion con la BD
        PreparedStatement ps = null;
        ResultSet rs= null;
        Connection con = getConexion();
        DefaultListModel modelo = new DefaultListModel();
        //List<String> cuentas = new ArrayList<>();
        int id = 0;
        //Sentencia sql 
        String sql = "SELECT id_tipo_cuenta FROM tipocuenta WHERE nombre_tipo_cuenta=?";
        //Validacion por errores de conexion
        try{
            //Utilizacion de variables, para obtener datos de la BD
            ps= con.prepareStatement(sql);
            ps.setString(1, nombre);
            rs= ps.executeQuery();
            //Recorrer la BD
            while(rs.next()){
                //cbo.addItem(rs.getString(columna));
                id = rs.getInt(1);
            }
            rs.close();
            sql = "SELECT s.id_sub_tipo_cuenta, s.nombre_sub_tipo_cuenta \n" +
                    "FROM tipocuenta t inner join subtipocuenta s on s.id_tipo_cuenta = t.id_tipo_cuenta\n" +
                    "WHERE t.id_tipo_cuenta = ? AND s.id_sub_tipo_cuenta ::TEXT LIKE '"+text+"%'";
            //Utilizacion de variables, para obtener datos de la BD
            ps= con.prepareStatement(sql);
            ps.setInt(1, id);
            //ps.setString(2, text);
            rs= ps.executeQuery();
            //Recorrer la BD
            while(rs.next()){
                //cuentas.add(rs.getString(1) +" "+ rs.getString(2));
                modelo.addElement(rs.getString(1) +" "+ rs.getString(2));
            }
            lista.setVisible(true);
            lista.setModel(modelo);
        }catch (SQLException ex){
             Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
}
