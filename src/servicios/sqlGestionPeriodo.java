
package servicios;
import Conexiones.Conexion;
import entidades.periodo;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JComboBox;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import modelos.ModeloNoEditable;
import org.postgresql.util.PSQLException;



public class sqlGestionPeriodo extends Conexion{
    
    List<periodo> perList = new ArrayList<periodo>();
    public void recuperarPeriodos(){
        periodo per = new periodo();
        Connection con = getConexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM periodo";
        try{
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                per.setFecha_inicio(rs.getDate(1));
                per.setFecha_fin(rs.getDate(2));
                per.setActivo(rs.getString(3));
                perList.add(per);
            }
        }catch(SQLException ex){
        
        }
    }
    
    
    public void llenarListaMeses(JComboBox cb, int col){
        Connection con = getConexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        String sql = "SELECT nombre_mes FROM mes";
        try{
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            
            while(rs.next()){
                cb.addItem(rs.getString(1));
            }
            cb.setSelectedIndex(-1);
            rs.close();
        }catch(SQLException ex){
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void ingresarPeriodo(Date ini, Date fin, String activo){
        Connection con = getConexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        String sql = "INSERT INTO periodo (fecha_inicio, fecha_fin, activo) values (?, ?, ?)";
        String sql2 = "SELECT * FROM periodo where fecha_inicio=? and fecha_fin=?";
        
        ResultSet rs2 = null;
        PreparedStatement ps2 = null;
        String validar1="", validar2="";
        try{
          
           ps2 = con.prepareStatement(sql2);
           ps2.setDate(1, ini);
           ps2.setDate(2, fin);
           rs2 = ps2.executeQuery();
             
           while(rs2.next()){
                validar1 = rs2.getDate(1).toString();
                validar2 = rs2.getDate(2).toString();
           }
           
           if(!validar2.isEmpty() || !validar1.isEmpty()){        
               JOptionPane.showMessageDialog(null, "Ya existe este periodo");
           }else{
               ps = con.prepareStatement(sql);
               ps.setDate(1, ini);
               ps.setDate(2, fin);
               ps.setString(3,activo);
               ps.execute();
               JOptionPane.showMessageDialog(null, "Se ha guardado el periodo");   
           }            
            
        }catch(SQLException ex){
           Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void limpiarModelo(ModeloNoEditable mdt){
        while(mdt.getRowCount()>0){
            mdt.removeRow(0);
        }
    }
    
    public void llenarTabla(ModeloNoEditable mdl, int col){
        limpiarModelo(mdl);
        String[] fila = new String[col];
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        //Variables para la preparacion de conexion con la BD
        PreparedStatement ps = null;
        ResultSet rs= null;
        
        Connection con = getConexion();
        String sql = "SELECT * from periodo order by fecha_inicio";
        //Validacion por errores de conexion
        try{
            //Utilizacion de variables, para obtener datos de la BD
            ps= con.prepareStatement(sql);
            rs= ps.executeQuery();
            //Recorrer la BD
            while(rs.next()){
               fila[0] = formato.format(rs.getDate(1));
               fila[1] = formato.format(rs.getDate(2)); 
               fila[2] = rs.getString(3);
               mdl.addRow(fila);
            }
            rs.close();
        }catch (SQLException ex){
             Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }  
    }
}
        
    
