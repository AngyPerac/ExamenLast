
package controlador;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.ResultSet;
import javax.swing.JOptionPane;



public class EjecutaSQL {
       
    
     public static ResultSet devuelveRS(String consulta,String usu,
             String pas, String cad)
     {
         
         
        Connection con=Conecta.getConexion(usu,pas,cad);
       
         ResultSet rs=null;
         
            try {
                //Statement Ejecuta la acción contra la BD
                //TYPE_SCROLL_SENSITIVE me deja mover hacia delanta y hacía atrás
                //CONCUR_READ_ONLY es sólo de lectura
                Statement st=con.createStatement(
                        ResultSet.TYPE_SCROLL_SENSITIVE,
                        ResultSet.CONCUR_READ_ONLY);
                // ResultSet es donde se guarda el resultado de la consulta
                rs=st.executeQuery(consulta);
                        /*"select concat(first_name,' ',last_name) as Nombre,"
                        + "email as Correo,active as Activo,create_date as 'Fecha Alta' "
                        + "from customer");*/
                
                return rs;
            } catch (SQLException ex) {
                //System.out.println("Error: "+ex.getMessage());
                JOptionPane.showMessageDialog(null,ex.getMessage());
                return null;
            }
            //Cerrar objetos de Sql
            /*rs.close();
            st.close();
            con.close();*/
        } 
     
     //Método para ejecutar Insert, Delete o Update
     public static int ejecutaDms(String orden, String usu,String pas, String cad)
     {  
          Connection con=Conecta.getConexion(usu,pas,cad);
       
         
            try {
                //Statement Ejecuta la acción contra la BD
                Statement st=con.createStatement();
               
                return st.executeUpdate(orden);
            } catch (SQLException ex) {
                System.out.println("Error: "+ex.getMessage());
                return 0;
            }
         
     }
     
    

}
       

    

      

