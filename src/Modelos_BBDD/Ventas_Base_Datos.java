
package Modelos_BBDD;

import ConexionBBDD.*;
import Datos_Clases.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Ventas_Base_Datos { 
    
    ConexionBASEDATOS conexionBBDD = new ConexionBASEDATOS();
    Connection c;
    PreparedStatement ps;
    ResultSet rs;
    int res=0;
    
    public String IdVenta(){
        String idVenta="";
        String sql ="select max(idVenta) from venta";
        try {
            c=conexionBBDD.conexion01();
            ps=c.prepareStatement(sql);
            rs=ps.executeQuery();
            while (rs.next()){
                idVenta=rs.getString(1);
            }
        } catch (Exception e) {
        }
        return idVenta;
    }
    public int agregarVentas (Ventas_D ventas_D){
        Vendedor_D vd = new Vendedor_D();
        String sql= "insert into venta (idCliente,idVendedor,fechaVenta,monto) values (?,?,?,?)";
        try {
            c=conexionBBDD.conexion01();
            ps=c.prepareStatement(sql);
            ps.setInt(1, ventas_D.getIdCli());
            ps.setInt(2,ventas_D.getIdVende());
            ps.setString(3,ventas_D.getFecVen());
            ps.setDouble(4,ventas_D.getMonto());
            
            res=ps.executeUpdate();
        } catch (Exception e) {
        }
        return res;
    }
    public int agregarDetalleVentas (Detalle_Venta_D detlle){
        String sgl="insert into detalleventa (idVenta,idProducto,cantidad,precioVenta) values (?,?,?,?)";
        try {
            c=conexionBBDD.conexion01();
            ps=c.prepareStatement(sgl);
            ps.setInt(1, detlle.getIdVenta());
            ps.setInt(2,detlle.getIdProd());
            ps.setInt(3,detlle.getCant());
            ps.setDouble(4,detlle.getPrecVenta());
            
            res=ps.executeUpdate();
            
        } catch (Exception e) {
        }
        return res;
    }
    
   
}
