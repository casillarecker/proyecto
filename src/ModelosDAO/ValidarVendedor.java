
package ModelosDAO;

import Datos_Clases.Vendedor_D;
import ConexionBBDD.*;
import Vista.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class ValidarVendedor {
    
    PreparedStatement ps;
    ResultSet rs;
    
    ConexionBASEDATOS conexionBASEDATOS = new ConexionBASEDATOS();
    Connection con;
    
    LoginAcceso loginAcceso;
    
    

    public Vendedor_D ValidarVen(String ci, String user) {
        
            Vendedor_D dt = new Vendedor_D();

        
        String sql = "select * from vendedor where civendedor=? and usuario=?";
        
        try {
            con=conexionBASEDATOS.conexion01();
            ps=con.prepareStatement(sql);
            ps.setString(1, ci);
            ps.setString(2, user);
            rs=ps.executeQuery();
            
            while (rs.next()){
                dt.setIdven(rs.getInt(1));
                dt.setCi(rs.getString(2));
                dt.setNom(rs.getString(3));
                dt.setTel(rs.getString(4));
                dt.setEstado(rs.getString(5));
                dt.setUser(rs.getString(6));
            }
            
        } catch (Exception e) {
            
        }
    
       return dt;
    }
    
   
}
