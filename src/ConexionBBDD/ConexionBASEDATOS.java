
package ConexionBBDD;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

public class ConexionBASEDATOS {
    
    Connection connection=null;
    
    public Connection conexion01 (){
        try {
         Class.forName("com.mysql.jdbc.Driver");
         connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ventas2020?useTimezone=true&serverTimezone=America/La_Paz", "root","");
         
            //JOptionPane.showMessageDialog(null,"conexión existosa");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Error de conexión a base de Datos " + e.getMessage());

        }
        
        return connection;
    }
    
}
