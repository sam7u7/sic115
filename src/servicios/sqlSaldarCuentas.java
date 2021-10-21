package servicios;
import Conexiones.Conexion;
import entidades.cuenta;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import entidades.movimiento;
import entidades.periodo;
import java.util.ArrayList;
import java.sql.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.YES_NO_OPTION;
import modelos.ModeloNoEditable;
import vistas.RegistrarTransaccion;

/**
 *
 * @author felix
 */
public class sqlSaldarCuentas extends Conexion{
    //Listas de objetos a utilizar
    List<movimiento> movimientos = new ArrayList<movimiento>();
    List<Integer> idCuentas = new ArrayList<Integer>();
    
    //Obtener las cuentas
    public void obtenerCuentas(){
        int id;
        Connection con = getConexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT id_cuenta FROM cuenta";
        try{
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                id = rs.getInt(1);
                idCuentas.add(id);
            }
        }catch(SQLException ex){
        
        }
    }
    
    //Visualizar RegistrarTransaccion
    public int bandera = 0;
    
    //Obtener los movimientos
    public void obtenerMovimientos(String ini, String fin){
         //Variables para la preparacion de conexion con la BD
        PreparedStatement ps = null;
        ResultSet rs= null;
        Connection con = getConexion();
        //Sentencia sql 
        String sql = "SELECT * FROM movimiento WHERE fecha BETWEEN ? AND ?";
        String sql2 = "SELECT id_cuenta FROM cuenta";
        //Validacion por errores de conexion
        
        //id_cuentas
        try{
            ps = con.prepareCall(sql2);
            rs = ps.executeQuery();
            while(rs.next()){
                int cu;
                cu=rs.getInt(1);
                idCuentas.add(cu);
            }
            rs.close();
        }catch(SQLException ex){
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        try{
            //Utilizacion de variables, para obtener datos de la BD
            ps= con.prepareStatement(sql);
            ps.setDate(1, Date.valueOf(ini));
            ps.setDate(2, Date.valueOf(fin));
            rs= ps.executeQuery();
            //Recorrer la BD
            while(rs.next()){
                movimiento movi = new movimiento();
                movi.setId_movimiento(rs.getInt(1));
                movi.setId_cuenta(rs.getInt(2));
                movi.setFecha(rs.getString(3));
                movi.setTipo(rs.getString(4));
                movi.setDescripcion(rs.getString(5));
                movi.setCantidad_movimiento_debe(rs.getDouble(6));
                movi.setCantidad_movimiento_haber(rs.getDouble(7));
                movimientos.add(movi);  
            }
            rs.close();
            saldarCuentas(ini, fin, movimientos, idCuentas);
            movimientos.clear();
            idCuentas.clear();
            
        }catch (SQLException ex){
             Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void saldarCuentas(String ini, String fin, List<movimiento> movi, List<Integer> id){
        boolean res = true;
       // List<String> val = new ArrayList<String>();
        //List<String> val2 = new ArrayList<String>();
        
        Connection con = getConexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "INSERT INTO cuentasaldada (id_cuenta, saldo_cuenta_saldada_debe, saldo_cuenta_saldada_haber, fecha_inicio, fecha_fin) VALUES (?,?,?,?,?)";
        String sql2 = "SELECT fecha_inicio, fecha_fin FROM cuentasaldada where fecha_inicio=? and fecha_fin=?";
        
        
        try{
            String fechaValini= "", fechaValfin="";
            ps = con.prepareStatement(sql2);
            ps.setDate(1, Date.valueOf(ini));
            ps.setDate(2, Date.valueOf(fin));
            rs = ps.executeQuery();
            while(rs.next()){
                /*val.add(rs.getDate(1).toString());
                val2.add(rs.getDate(2).toString());*/
                fechaValini = rs.getDate(1).toString();
                fechaValfin = rs.getDate(2).toString();
            }
            double resultado = 0;
                if(fechaValini.equals(ini) || fechaValfin.equals(fin)){
                        JOptionPane.showMessageDialog(null, "El periodo que esta eligiendo ya fue saldado");      
                    }else if(movi.isEmpty()){
                        
                        int conf =  JOptionPane.showConfirmDialog(null, "No existen transacciones. ¿Desea ingresarlas?", "Ingresar", YES_NO_OPTION);
                        if(JOptionPane.OK_OPTION == conf){
                            bandera = 1;
                        }
                    }else{                
                        for(Integer aux1 : id){
                            double debe=0, haber=0;
                            for(movimiento aux2 : movi){
                                if(aux1.equals(aux2.getId_cuenta())){
                                    if(aux2.getTipo().equals("Cargar")){
                                        debe += aux2.getCantidad_movimiento_debe();
                                    }
                                    else{
                                        haber += aux2.getCantidad_movimiento_haber();
                                    }
                                }
                            }
                            ps = con.prepareStatement(sql);             


                                if(debe > haber){
                                    resultado = debe-haber;

                                    ps.setInt(1, aux1);
                                    ps.setDouble(2, resultado);
                                    ps.setDouble(3, 0);
                                    ps.setDate(4, Date.valueOf(ini));
                                    ps.setDate(5, Date.valueOf(fin));

                                }else if(debe < haber){
                                    resultado = haber-debe;

                                    ps.setInt(1, aux1);
                                    ps.setDouble(2, 0);
                                    ps.setDouble(3, resultado);
                                    ps.setDate(4, Date.valueOf(ini));
                                    ps.setDate(5, Date.valueOf(fin));

                                }else if(debe == haber){

                                    ps.setInt(1, aux1);
                                    ps.setDouble(2, 0);
                                    ps.setDouble(3, 0);
                                    ps.setDate(4, Date.valueOf(ini));
                                    ps.setDate(5, Date.valueOf(fin));
                                }
                               res = ps.execute();               
                            }
                }
            if(!res){
                JOptionPane.showMessageDialog(null, "Cuentas saldadas");
            }
        }catch(SQLException ex){
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "No se han podido saldar las cuentas");
        }
    }
    
    public void limpiarModelo(ModeloNoEditable mdt){
        while(mdt.getRowCount()>0){
            mdt.removeRow(0);
        }
    }
       
    public void llenarTabla(ModeloNoEditable md1, String ini, String fin, int cantColum){
        limpiarModelo(md1);
        int i = 0;
        String[] Data = new String[20];
        //Variables para la preparacion de conexion con la BD
        PreparedStatement ps = null;
        ResultSet rs= null;
        Connection con = getConexion();
        //Sentencia sql 
        String sql = "select cu.nombre_cuenta, cs.saldo_cuenta_saldada_debe, cs.saldo_cuenta_saldada_haber,\n" +
        "cs.fecha_inicio, cs.fecha_fin from cuenta cu inner join cuentasaldada cs on cu.id_cuenta = cs.id_cuenta where cs.fecha_inicio=? and cs.fecha_fin=?";
        //Validacion por errores de conexion
        try{
            //Utilizacion de variables, para obtener datos de la BD
            ps= con.prepareStatement(sql);
            ps.setDate(1, Date.valueOf(ini));
            ps.setDate(2, Date.valueOf(fin));
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
    
    public void llenarTablaMov(ModeloNoEditable md1, int cantColum, String ini, String fin){
        limpiarModelo(md1);
        int i = 0;
        String[] Data = new String[20];
        //Variables para la preparacion de conexion con la BD
        PreparedStatement ps = null;
        ResultSet rs= null;
        Connection con = getConexion();
        //Sentencia sql 
        String sql = "select cu.nombre_cuenta, tp.nombre_tipo_cuenta, mov.tipo, mov.descripcion, mov.fecha, mov.cantidad_debe, \n" +
                     "mov.cantidad_haber from movimiento mov inner join cuenta cu on mov.id_cuenta = cu.id_cuenta\n" +
                     "inner join tipocuenta tp on cu.id_tipo_cuenta = tp.id_tipo_cuenta where fecha between ? and ?";
        //Validacion por errores de conexion
        try{
            //Utilizacion de variables, para obtener datos de la BD
            ps= con.prepareStatement(sql);
            ps.setDate(1, Date.valueOf(ini));
            ps.setDate(2, Date.valueOf(fin));
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
    
    
        
  
}
