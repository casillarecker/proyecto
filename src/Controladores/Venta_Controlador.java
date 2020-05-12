
package Controladores;

import Datos_Clases.*;
import Modelos_BBDD.*;
import Vista.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class Venta_Controlador implements ActionListener{
    
    From_Ventas_Graficas fvg;
    Cliente_Base cliente_BD = new Cliente_Base();//conexion BD cliente
    Producto_base producto_BD = new Producto_base();//conexion BD producto
    
    Producto_D pd = new Producto_D();
   //estamos llamando a la venta sus clases y conexion
    
    Ventas_D ventas_D = new Ventas_D();
    Ventas_Base_Datos ventas_Base_Datos = new Ventas_Base_Datos();
    Detalle_Venta_D dvd = new Detalle_Venta_D(0, 0, 0, 0, 0);
   
    double totalPagar;
    double precio;
    int cant;
    
    DefaultTableModel tableModel = new DefaultTableModel();
    
    Cliente_DS cliente= new Cliente_DS();
    
     int idProd;

    public Venta_Controlador(From_Ventas_Graficas grafica) {
    
        this.fvg = grafica;
        
        agregarFecha();
        
        grafica.btnBuscarCeCliente.addActionListener(this);
        grafica.btnBuscarProducto.addActionListener(this);
        grafica.btnAgregar.addActionListener(this);
        grafica.btnCancelar.addActionListener(this);
        grafica.btnGenerarVenta.addActionListener(this);
        grafica.cerrar.addActionListener(this);
        
    
    }
  
    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(fvg.cerrar==e.getSource()){
        System.exit(0);
        }else
        if(fvg.btnBuscarCeCliente==e.getSource()){
            buscarCliente();
        }else if(fvg.btnBuscarProducto==e.getSource()){
            
            buscarProducto();
        }else if(fvg.btnAgregar==e.getSource()){
            agregarProducto();
        }else if(fvg.btnGenerarVenta==e.getSource()){
            if(fvg.txtTotalPago.getText().equals("")){
            JOptionPane.showMessageDialog(fvg,"Debe ingresar datos");
            }else{
                guargarVenta();
                guardarDetalle();
                actualizar();
                JOptionPane.showMessageDialog(fvg,"Se realizo la venta con exito");
            }
        }
        
    }
     
    
    //metodo del evento
    public void buscarCliente (){
        int res;
        String cod=fvg.txtCelulaCliente.getText();
        if(fvg.txtCelulaCliente.getText().equals("")){
            JOptionPane.showMessageDialog(fvg,"Debe ingresar el CI del Cliente");
        }else{
            cliente=cliente_BD.listarID(cod);
            if(cliente.getCiCli()!=null){
                fvg.txtceluda.setText(cliente.getNom());
            }else{
                res=JOptionPane.showConfirmDialog(fvg,"Cliente no esta registrado,desea registrar?");
                if(res==0){
                From_Cliente_Grafica ventas_Graficas = new From_Cliente_Grafica();
                    SistemaPrincipal.PanelTrabajossistem.add(ventas_Graficas);
                    Cliente_Controlador cc = new Cliente_Controlador(ventas_Graficas);
                    ventas_Graficas.setVisible(true);
                }
            }
        }
    }
    //metodo producto
    public void buscarProducto (){
    
        idProd=Integer.parseInt(fvg.txtcodiProducto.getText());
        if(fvg.txtcodiProducto.getText().equals("")){
           JOptionPane.showMessageDialog(fvg,"Debe ingresar el codigo del producto");
           
        }else{
        
            Producto_D d= producto_BD.listarId(idProd);
            if(d.getIdPro()!=0){
                fvg.txtProducto.setText(d.getNom());
                fvg.txtPrecio.setText(d.getPrecio()+"");
                fvg.txtStrock.setText(d.getStock()+"");
            }else{
                //JOptionPane.showMessageDialog(fvg,"Producto no registrado");
                JOptionPane.showMessageDialog(fvg,"Producto no registrado");
                fvg.txtcodiProducto.requestFocus();
            }
        }
    }
    //metodo agragar producto
    /*public void agregarProducto (){
      double total;
      int item=0;
      tableModel =(DefaultTableModel) fvg.TablaVenta.getModel();
      item++;
      int idProd=Integer.parseInt(fvg.txtcodiProducto.getText());
      String nomProd =fvg.txtProducto.getText();
      precio=Double.parseDouble(fvg.txtPrecio.getText());
      cant= Integer.parseInt(fvg.txtspenner.getValue().toString());
      int stock=Integer.parseInt(fvg.txtStrock.getText());
      total=cant*precio;
      
        ArrayList list = new ArrayList();
        
        if(stock>0){
            list.add(item);
            list.add(idProd);
            list.add(nomProd);
            list.add(cant);
            list.add(precio);
            list.add(total);
            
            Object o[] = new Object[6];
            o[0]=list.get(0);
            o[1]=list.get(1);
            o[2]=list.get(2);
            o[3]=list.get(3);
            o[4]=list.get(4);
            o[5]=list.get(5);
            
            tableModel.addRow(o);
            fvg.TablaVenta.setModel(tableModel);
        }else{
            JOptionPane.showMessageDialog(fvg,"Stock producto no disponible");
        }
    }*/
    
    public void agregarProducto (){
      double total;
      int item=0;
      tableModel =(DefaultTableModel) fvg.TablaVenta.getModel();
      item = item + 1;
      idProd=pd.getIdPro();
      
      String nomProd =fvg.txtProducto.getText();
      double precio=Double.parseDouble(fvg.txtPrecio.getText());
      int  cant= Integer.parseInt(fvg.txtspenner.getValue().toString());
      int stock=Integer.parseInt(fvg.txtStrock.getText());
      
      total=cant*precio;
      
        ArrayList list = new ArrayList();
        
        if(stock > 0){
            list.add(item);
            list.add(idProd);
            list.add(nomProd);
            list.add(cant);
            list.add(precio);
            list.add(total);
            
            Object []o = new Object[6];
            o[0]=list.get(0);
            o[1]=list.get(1);
            o[2]=list.get(2);
            o[3]=list.get(3);
            o[4]=list.get(4);
            o[5]=list.get(5);
            
            tableModel.addRow(o);
            fvg.TablaVenta.setModel(tableModel);
        }else{
            JOptionPane.showMessageDialog(fvg,"Stock producto no disponible");
        }
    }
    
    
    
    
    
    
    
    
    public void calcularTotal (){
        totalPagar = 0;
        for(int i = 0 ; i < fvg.TablaVenta.getRowCount();i++){
        cant=Integer.parseInt(fvg.TablaVenta.getValueAt(i, 3).toString());
        precio=Double.parseDouble(fvg.TablaVenta.getValueAt(i,4).toString());
        totalPagar=totalPagar + (cant*precio);
        }
        fvg.txtTotalPago.setText(totalPagar+"");
    }
    public void agregarFecha (){
        Calendar calen = new GregorianCalendar();
        int año=calen.get(Calendar.YEAR);
        int mes=calen.get(Calendar.MONTH);
        int dia=calen.get(Calendar.DAY_OF_MONTH);
        fvg.txtFecha.setText(año + "-" + mes + "-" + dia);
        
    }
    // public void agregarFecha (){
      
        //Calendar calendar = new GregorianCalendar();
        //fvg.txtFecha.setText("" + calendar.get(calendar.YEAR)+"-"+calendar.get(calendar.MONTH)+"-"+calendar.get(calendar.DAY_OF_MONTH));
        
    //}
    
    public void guargarVenta (){
    
        int idVendedor=1;
        int idCliente = cliente.getIdCli();
        String fecha = fvg.txtFecha.getText();
        double monto = totalPagar;
        
        ventas_D.setIdCli(idCliente);
        ventas_D.setIdVende(idVendedor);
        ventas_D.setFecVen(fecha);
        ventas_D.setMonto(monto);
        
        ventas_Base_Datos.agregarVentas(ventas_D);
    }
    public void guardarDetalle (){
    
        int idVen = Integer.parseInt(ventas_Base_Datos.IdVenta());
        for(int i = 0 ; i < fvg.TablaVenta.getRowCount(); i++){
        
            int idProd = Integer.parseInt(fvg.TablaVenta.getValueAt(i,1).toString());
            int cant = Integer.parseInt(fvg.TablaVenta.getValueAt(i,3).toString());
            double precio = Double.parseDouble(fvg.TablaVenta.getValueAt(i,4).toString());
            
            dvd.setIdVenta(idVen);
            dvd.setIdProd(idProd);
            dvd.setCant(cant);
            dvd.setPrecVenta(precio);
            
            ventas_Base_Datos.agregarDetalleVentas(dvd);
        }
        
    }
    
    ///Aqui actulizamos
    public void actualizar(){
    
        for(int i = 0; i < tableModel.getRowCount(); i ++ ){
            
            Producto_D producto = new Producto_D();
            idProd= Integer.parseInt(fvg.TablaVenta.getValueAt(i,1).toString());
            cant = Integer.parseInt(fvg.TablaVenta.getValueAt(i,3).toString());
            producto = producto_BD.listarId(idProd);
            int stockActual = producto.getStock()-cant;
            
            producto_BD.modificadoStock(stockActual, idProd);
            
        }
    }
    
    public void nuevo (){
        limpiarTabla();
        
        fvg.txtceluda.setText("");
        fvg.txtCelulaCliente.setText("");
        fvg.txtcodiProducto.setText("");
        fvg.txtProducto.setText("");
        fvg.txtvendedor.setText("");
        fvg.txtTotalPago.setText("");
        fvg.txtPrecio.setText("");
        fvg.txtFecha.setText("");
        fvg.txtStrock.setText("");
        fvg.txtspenner.setToolTipText("");
        
    }
    
    public void limpiarTabla (){
    
        for(int i = 0; i < tableModel.getRowCount(); i ++){
    
        tableModel.removeRow(i);
        i=i-1;
    }
        
    }
    
}















