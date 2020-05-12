
package Modelos_BBDD;

import ConexionBBDD.*;
import Datos_Clases.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class Cliente_Base {
    
    Connection c;
    ConexionBASEDATOS conexionBD = new ConexionBASEDATOS();
    PreparedStatement ps;
    ResultSet rs;
   
  
    public List listarCliente (){   
        //System.out.println("aqui estamos");
        List<Cliente_DS> listacli=new ArrayList<>();
        
        String sql = "select * from cliente";
        try {
            c=conexionBD.conexion01();
            ps = c.prepareStatement(sql);
            rs = ps.executeQuery();
           // System.out.println("aqui estamos");
            while(rs.next()){
                
                Cliente_DS clien = new Cliente_DS();
                clien.setIdCli(rs.getInt(1));
                clien.setCiCli(rs.getString(2));
                clien.setNom(rs.getString(3));
                clien.setDire(rs.getString(4));
                
                listacli.add(clien);
                 
            }
        } catch (Exception e) {
        }
        return listacli;
    }
    
    public int insertarCliente(Object []o) {
        
        int r = 0;
        String sql = "insert into cliente (ciCliente,nombres,direccion) values (?,?,?)";
        try {
            c=conexionBD.conexion01();
            ps= c.prepareStatement(sql);
            ps.setObject(1, o[0]);
            ps.setObject(2, o[1]);
            ps.setObject(3, o[2]);
            
            r = ps.executeUpdate();
          
        } catch (Exception e) {
        }
        return r;
    }
    
        public int actulizarCliente(Object []objs) {
        int res = 0;
       String sql = "update cliente set ciCliente=?,nombres=?,direccion=? where idCliente=?";
        try {
            c=conexionBD.conexion01();
            ps =c.prepareStatement(sql);
            ps.setObject(1, objs[0]);
            ps.setObject(2, objs[1]);
            ps.setObject(3, objs[2]);
            ps.setObject(4, objs[3]);
            
            res= ps.executeUpdate();
            
        } catch (Exception e) {
        }
        return res;
    }
      
        
       public void eliminarCliente(int idCl) {
      
        String sql = "delete from cliente where idCliente=?";
        
        try {
            
            c=conexionBD.conexion01();
            ps=c.prepareStatement(sql);
            ps.setInt(1, idCl);
            ps.executeUpdate();
            
        } catch (Exception e) {
        }
      
    }
     
        
    public  Cliente_DS listarID (String ci){
       Cliente_DS clien = new Cliente_DS();
       String sql = "select * from cliente where ciCliente=?";
        try {
            c=conexionBD.conexion01();
            ps=c.prepareStatement(sql);
            ps.setString(1, ci);
            rs=ps.executeQuery();
            while (rs.next()){
                clien.setIdCli(rs.getInt(1));
                clien.setCiCli(rs.getString(2));
                clien.setNom(rs.getString(3));
                clien.setDire(rs.getString(4));
                
            }
        } catch (Exception e) {
        }
        return clien;
    }
        
}
