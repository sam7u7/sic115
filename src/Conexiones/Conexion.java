package Conexiones;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author felix
 */
public class Conexion {
    //Constantes de conexion
    private final String base = "SIC"; //Nombre de la BD
    private final String user = "postgres"; //Usuario del servidor
    private final String password = "admin"; //Contraseña del servidor
    private final String url = "jdbc:postgresql://localhost:5432/"+base; //url del servidor
    private Connection con = null;
    
    //Metodo de validacion de conexion a la BD
    public Connection getConexion(){
        try{
            Class.forName("org.postgresql.Driver");
            con = DriverManager.getConnection(url, user, password);
        }catch(ClassNotFoundException ex){
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex){
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return con;
    }
}
