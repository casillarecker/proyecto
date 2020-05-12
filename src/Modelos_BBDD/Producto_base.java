
package Modelos_BBDD;

import ConexionBBDD.ConexionBASEDATOS;
import Datos_Clases.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class Producto_base {
     Connection connec;
    ConexionBASEDATOS tOS = new ConexionBASEDATOS();
    PreparedStatement ps;
    ResultSet rs;
    
    int id;
    
    public List listarProducto (){
       List <Producto_D> listarPro = new ArrayList<>();
       String sql="select * from producto";
        try {
            connec=tOS.conexion01();
            ps=connec.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                
                Producto_D p = new Producto_D();
                p.setIdPro(rs.getInt(1));
                p.setNom(rs.getString(2));
                p.setPrecio(rs.getDouble(3));
                p.setStock(rs.getInt(4));
                listarPro.add(p);
                 
            }
        } catch (Exception e) {
        }
       return listarPro;
    }
    public int insertarProducto(Object obj[]){
         int re = 0;
        String sql = "insert into producto (nombre,precio,stock) values (?,?,?)";
        try {
            connec=tOS.conexion01();
            ps= connec.prepareStatement(sql);
            ps.setObject(1, obj[0]);
            ps.setObject(2, obj[1]);
            ps.setObject(3, obj[2]);
            
            re = ps.executeUpdate();
           
        } catch (Exception e) {
        }
        return re;
    }
            public int actulizarProducto(Object []objs) {
        int r = 0;
       String sql = "update producto set nombre=?,precio=?,stock=? where idProducto=?";
        try {
            connec=tOS.conexion01();
            ps =connec.prepareStatement(sql);
            ps.setObject(1, objs[0]);
            ps.setObject(2, objs[1]);
            ps.setObject(3, objs[2]);
            ps.setObject(4, objs[3]);
            
            r= ps.executeUpdate();
            
        } catch (Exception e) {
        }
        return r;
    }
            
    public void eliminarProducto(int idPro) { 
        String sql = "delete from producto where idProducto=?";
        
        try {
            
            connec=tOS.conexion01();
            ps=connec.prepareStatement(sql);
            ps.setInt(1, idPro);
            ps.executeUpdate();
            
        } catch (Exception e) {
        }
      
    }
            
            
            
    public  Producto_D listarId (int idProducto){
        Producto_D producto = new Producto_D();
       String sql = "selec * from producto where IdProducto=?";
        try {
            connec=tOS.conexion01();
            ps=connec.prepareStatement(sql);
            ps.setInt(1,idProducto);
            rs=ps.executeQuery();
            while (rs.next()){
                producto.setIdPro(rs.getInt(1));
                producto.setNom(rs.getString(2));
                producto.setPrecio(rs.getDouble(3));
                producto.setStock(rs.getInt(4));
            }
        } catch (Exception e) {
        }
        return producto;
    }
    public int modificadoStock (int cant, int idProd){
        String sgl = "update producto set stock=? where idProducto=?";
        try {
            connec=tOS.conexion01();
            ps=connec.prepareStatement(sgl);
            ps.setInt(1,cant);
            ps.setInt(2,idProd);
            id=ps.executeUpdate();
        } catch (Exception e) {
        }
        return id;
    }
    
}
