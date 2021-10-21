/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemacontable;
import java.sql.*;
import java.lang.Exception;
import java.io.*;
/**
 *
 * @author felix
 */
public class SistemaContable {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        //Conexion con la BD
        //Datos de la BD
        String url = "jdbc:postgresql://localhost:5432/SIC";
        String usuario = "postgres";
        String contrasenia = "170398";
        //Validacion
        try{
            //Tipo de lenguaje de BD
            Class.forName("org.postgresql.Driver");
            //Creacion de la conexion
            Connection conexion = DriverManager.getConnection(url,usuario,contrasenia);
            java.sql.Statement st = conexion.createStatement();
            //Sentencia sql
            String sql = "SELECT * FROM empleado";
            //Ejecucion del sql
            ResultSet result = st.executeQuery(sql);
            //Recorrido de la BD
            while(result.next()){
                String codigo = result.getString("codigo_empleado");
                String nombres = result.getString("nombres");
                String apellidos = result.getString("apellidos");
                String dui = result.getString("dui");
                String sexo = result.getString("sexo");
                System.out.println("codigo: "+codigo+" nombres: "+nombres+" apellidos: "+apellidos+" dui: "+dui+" sexo: "+sexo);
            }
            //Cierre de conexion con la BD
            result.close();
            st.close();
            conexion.close();
        }catch (Exception e){
            System.out.println("Error de conexion"+e.getMessage());
        }
    }
    
}
