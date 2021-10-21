package servicios;
import Conexiones.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import entidades.usuario;

/**
 *
 * @author felix
 */
public class sqlUsuario extends Conexion {
    //Metodo para varificacion de existencia de usuario
    public boolean login(usuario usr){
        //Variables para la preparacion de conexion con la BD
        PreparedStatement ps = null;
        ResultSet rs= null;
        Connection con = getConexion();
        //Sentencia sql 
        String sql = "SELECT codigo_empleado, usuario, clave FROM usuario WHERE usuario = ?";
        //Validacion por errores de conexion
        try{
            //Utilizacion de variables, para obtener datos de la BD
            ps= con.prepareStatement(sql);
            ps.setString(1, usr.getUsuario());
            rs= ps.executeQuery();
            //Recorrer la BD
            if(rs.next()){
                if(usr.getClave().equals(rs.getString(3))){ //Comparar la clave ingresada con la de la BD
                    //Utilizar metodos para el envio de datos de la BD
                    usr.setCodigo_empleado(rs.getInt(1));
                    usr.setUsuario(rs.getString(2));
                    usr.setClave(rs.getString(3));
                    return true;
                }else{
                    return false;
                }
            }
            return false;
        }catch (SQLException ex){
             Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
             return false;
        }
    }
}
