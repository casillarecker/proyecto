
package Controladores;

import Vista.*;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;


public class SistemaPrincipal_Controlador implements ActionListener{
    
    SistemaPrincipal sistemaPrincipal;
    JDesktopPane panelTrabajo;
    

    public SistemaPrincipal_Controlador() {}
    public SistemaPrincipal_Controlador(SistemaPrincipal principal) {
        
        this.sistemaPrincipal = principal;
        panelTrabajo = sistemaPrincipal.PanelTrabajossistem;
        
        principal.setExtendedState(JFrame.MAXIMIZED_BOTH);
        principal.setTitle("SISTEMA DE VENTAS");
        principal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        principal.setVisible(true);
        
        //***********************************añadiendo eventos a los botones*******************************************
        
        principal.menuAyuda.addActionListener(this);
        principal.menuSalir.addActionListener(this);
        principal.menuGenerarVen.addActionListener(this);
        principal.menuCliente.addActionListener(this);
        principal.menuVendedor.addActionListener(this);
        principal.menuProductos.addActionListener(this);
        
      
   }
    

    @Override
    public void actionPerformed(ActionEvent r) {
        
        if(sistemaPrincipal.menuSalir==r.getSource()){
         System.exit(0);
     }
        else if(sistemaPrincipal.menuVendedor==r.getSource()){
            agregarForVendedor();
        }
        else if (sistemaPrincipal.menuProductos==r.getSource()){
            agregarProducto();
        }else if (sistemaPrincipal.menuCliente==r.getSource()){
            agregarForCliente();
        }else if (sistemaPrincipal.menuGenerarVen==r.getSource()){
           agregarForGenerarVenta();
        }
         
        
        
        
    }
    
    
    
    
    public void agregarProducto(){
        From_Producto_Grafica producto_Froms = new From_Producto_Grafica();
       producto_Froms.setTitle("Producto");
        centrarVentana(producto_Froms);
        
       Producto_Controlador pc = new Producto_Controlador(producto_Froms);
        
    }
    public void agregarForVendedor (){
        Vendedor_froms vendedor_from = new Vendedor_froms();
        vendedor_from.setTitle("Registro de vendedor");
        centrarVentana(vendedor_from);
        
        Vendedor_Controlador vc = new Vendedor_Controlador(vendedor_from);
    }
    public  void agregarForCliente (){
        From_Cliente_Grafica fcg = new From_Cliente_Grafica();
        fcg.setTitle("Registro de Cliente");
        centrarVentana(fcg);
        
        Cliente_Controlador cc = new Cliente_Controlador(fcg);
    }
    
    public void agregarForGenerarVenta (){
        From_Ventas_Graficas ventas_Grafica = new From_Ventas_Graficas();
        ventas_Grafica.setTitle("Generador de venta");
        centrarVentana(ventas_Grafica);
        
        Venta_Controlador vc = new Venta_Controlador(ventas_Grafica);
    }
    
      public  void centrarVentana (JInternalFrame frame){
        
        panelTrabajo.add(frame);
        Dimension dimension = panelTrabajo.getSize();
        Dimension v = frame.getSize();
        frame.setLocation((dimension.width - v.width)/2,(dimension.height - v.height)/2);
        frame.show();
        
    }
}
