

package Modelos_BBDD;

import Datos_Clases.Vendedor_D;
import ConexionBBDD.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class Vendedor_Insert {
    
    Connection connec;
    ConexionBASEDATOS dATOS = new ConexionBASEDATOS();
    PreparedStatement ps;
    ResultSet rs;
    
    public List listarVendedor (){
        List <Vendedor_D> listar = new ArrayList<>() ;
        
        String s = "select * from vendedor";
        try {
            connec = dATOS.conexion01();
            ps=connec.prepareStatement(s);
            rs=ps.executeQuery();
            
            while (rs.next()){
                Vendedor_D vdatos = new Vendedor_D();
                vdatos.setIdven(rs.getInt(1));
                vdatos.setCi(rs.getString(2));
                vdatos.setNom(rs.getString(3));
                vdatos.setTel(rs.getString(4));
                vdatos.setEstado(rs.getString(5));
                vdatos.setUser(rs.getString(6));
                listar.add(vdatos);
            }
            
        } catch (Exception e) {
        }
        return listar;
    }
      public int insertarVendedor(Object obj[]){
          int rey = 0;
        String sql = "insert into vendedor (ciVendedor,nombres,telefono,estado,usuario) values (?,?,?,?,?)";
        try {
            connec=dATOS.conexion01();
            ps= connec.prepareStatement(sql);
            ps.setObject(1, obj[0]);
            ps.setObject(2, obj[1]);
            ps.setObject(3, obj[2]);
            ps.setObject(4, obj[3]);
            ps.setObject(5, obj[4]);
       
            rey = ps.executeUpdate();
           
        } catch (Exception e) {
        }
        return rey;
    
    }
       public int actualizarVendedor(Object []objs) {
        int r = 0;
       String sql = "update vendedor set ciVendedor=?,nombres=?,telefono=?,estado=?,usuario=? where idVendedor=?";
        try {
            connec=dATOS.conexion01();
            ps =connec.prepareStatement(sql);
            ps.setObject(1, objs[0]);
            ps.setObject(2, objs[1]);
            ps.setObject(3, objs[2]);
            ps.setObject(4, objs[3]);
            ps.setObject(5, objs[4]);//id
            ps.setObject(6, objs[5]);
            
            r=ps.executeUpdate();
            
        } catch (Exception e) {
        }
        return r;
    }
        public void eliminarVendedor(int idVen) {
        
        String sql = "delete from vendedor where idVendedor=?";
        
        try {
            
            connec=dATOS.conexion01();
            ps=connec.prepareStatement(sql);
            ps.setInt(1, idVen);
            ps.executeUpdate();
            
        } catch (Exception e) {
            
        }
    }
        //**********************************************************************id***************************************************
        public Vendedor_D ListarIdven(String ci){
            Vendedor_D vendedorDATOS = new Vendedor_D();
            String sql="select * from vendedor where idVendedor=?";
            try {
                connec=dATOS.conexion01();
                ps=connec.prepareStatement(sql);
                ps.setString(1, ci);
                rs=ps.executeQuery();
                while(rs.next()){
                    vendedorDATOS.setIdven(rs.getInt(1));
                    vendedorDATOS.setCi(rs.getString(2));
                    vendedorDATOS.setNom(rs.getString(3));
                    vendedorDATOS.setTel(rs.getString(4));
                    vendedorDATOS.setUser(rs.getString(5));
                    vendedorDATOS.setEstado(rs.getString(6));
                    
                }
            } catch (Exception e) {
            }
        return vendedorDATOS;
        }
        
    }
   
