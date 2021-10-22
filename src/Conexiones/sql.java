/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Conexiones;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Sam
 */
public class sql {
    public int id_incrementable(){
        int id = 1;
        PreparedStatement ps = null;
        ResultSet rs =null;
        Conexion db  = new Conexion();
        try{
            ps = db.getConexion().prepareStatement("select max(id_movimiento) from movimiento");
            rs = ps.executeQuery();
            while(rs.next())
            {
                id = rs.getInt(1)+1;
            }
            
    }catch(Exception ex){
            System.out.print("error"+ ex.getMessage());
        }
        finally{
        try{
            ps.close();
            rs.close();
        }catch(Exception ex){
            System.out.print("error"+ ex.getMessage());
        }
        
    }
        
    return id;
    }
    public int id_incrementableSaldarCuenta(){
        int id = 1;
        PreparedStatement ps = null;
        ResultSet rs =null;
        Conexion db  = new Conexion();
        try{
            ps = db.getConexion().prepareStatement("select max(id_cuenta_saldada) from cuentasaldada");
            rs = ps.executeQuery();
            while(rs.next())
            {
                id = rs.getInt(1)+1;
            }
            
    }catch(Exception ex){
            System.out.print("error"+ ex.getMessage());
        }
        finally{
        try{
            ps.close();
            rs.close();
        }catch(Exception ex){
            System.out.print("error"+ ex.getMessage());
        }
        
    }
        
    return id;
    }
}
