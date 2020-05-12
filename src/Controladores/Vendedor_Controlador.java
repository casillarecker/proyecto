
package Controladores;

import Modelos_BBDD.Vendedor_Insert;
import Datos_Clases.Vendedor_D;
import ModelosDAO.*;
import Vista.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


public class Vendedor_Controlador extends MouseAdapter implements ActionListener{
    
    Vendedor_froms vendedor_from;
    ValidarVendedor validarVendedor = new ValidarVendedor();
    Vendedor_D vdatos = new Vendedor_D();
    DefaultTableModel tableModel = new DefaultTableModel();
    Vendedor_Insert vendedor_Infor = new Vendedor_Insert();
    int id;

    public Vendedor_Controlador(Vendedor_froms vendedor) {
        
        this.vendedor_from = vendedor;
        
        listarVendedor();
        
       vendedor_from.btnAgregar.addActionListener(this);
       
        vendedor.btnNuevo.addActionListener(this);
        vendedor.btnActualizar.addActionListener(this);
        vendedor.btnEliminar.addActionListener(this);
         
        vendedor.tablaVendedor.addMouseListener(this);
    }
    
    
    

    @Override
    public void actionPerformed(ActionEvent p) {
        if(vendedor_from.btnAgregar==p.getSource()){
            try {
                AgregarVendedor();
                limpiarTablaVendedor(vendedor_from.tablaVendedor);
                listarVendedor();
            } catch (Exception t) {
                 JOptionPane.showMessageDialog(null,"No se pudo agregar el vendedor");
            }
            
        }else if (vendedor_from.btnActualizar==p.getSource()){;
            try {
                actualizarVendedor();
                limpiarTablaVendedor(vendedor_from.tablaVendedor);
                listarVendedor();
            } catch (Exception e) {
            }
            
        }else if (vendedor_from.btnEliminar==p.getSource()){;
            try {
                eliminarVendedor();
                limpiarTablaVendedor(vendedor_from.tablaVendedor);
                listarVendedor();
            } catch (Exception e) {
            }
            
        }else if (vendedor_from.btnNuevo==p.getSource()){;
            try {
                nuevoVendedor();
            } catch (Exception e) {
            }
            
        }
        
    }
    
    
        @Override
    public void mouseClicked (MouseEvent c){
        
        int fila = vendedor_from.tablaVendedor.getSelectedRow();
          if(fila ==-1){
            JOptionPane.showMessageDialog(null,"Debe seleccionar una fila");
        }else{
            id = Integer.parseInt(vendedor_from.tablaVendedor.getValueAt(fila,0).toString());
            //para actulizar y eliminar
            String ci=vendedor_from.tablaVendedor.getValueAt(fila, 1).toString();
            String nom=vendedor_from.tablaVendedor.getValueAt(fila,2).toString();
            String telf = vendedor_from.tablaVendedor.getValueAt(fila,3).toString();
            String usua = vendedor_from.tablaVendedor.getValueAt(fila,4).toString();
            String estado = vendedor_from.tablaVendedor.getValueAt(fila,5).toString();
            
            
            
           vendedor_from.txtidentidad.setText(ci);
           vendedor_from.txtNombres.setText(nom);
           vendedor_from.txtTelefono.setText(telf);
           vendedor_from.txtUsuario.setText(usua);
           vendedor_from.boxEstado.setToolTipText(estado);
           
        }
      
    }
    //*************************metodo de eventos********************************
    public void AgregarVendedor (){
        
        String ci = vendedor_from.txtidentidad.getText();
        String nom = vendedor_from.txtNombres.getText();
        String tel = vendedor_from.txtTelefono.getText();
        String est = vendedor_from.boxEstado.getSelectedItem().toString();
        String user = vendedor_from.txtUsuario.getText();
        
        Object o[] = new Object[5];
        //El id es autoincrementable
        o[0]=ci;
        o[1]=nom;
        o[2]=tel;
        o[3]=est;
        o[4]=user;
        vendedor_Infor.insertarVendedor(o);
    }
    public void actualizarVendedor (){
      
        int fila = Vendedor_froms.tablaVendedor.getSelectedRow();
        if(fila == -1){
            JOptionPane.showMessageDialog(null, "Debe seleccionar una fila");
        }else{
            String ci = vendedor_from.txtidentidad.getText();
            String nom = vendedor_from.txtNombres.getText();
            String tel = vendedor_from.txtTelefono.getText();
            String estado = vendedor_from.boxEstado.getSelectedItem().toString();
            String user = vendedor_from.txtUsuario.getText();
            
            Object ob [] = new Object[6];
            ob[0]=ci;
            ob[1]=nom;
            ob[2]=tel;
            ob[3]=estado;
            ob[4]=user;
            ob[5]=id;
            vendedor_Infor.actualizarVendedor(ob);
        }
        
        
    }
    
    public void eliminarVendedor (){
        int fila = Vendedor_froms.tablaVendedor.getSelectedRow();
        if (fila == - 1){
            JOptionPane.showMessageDialog(null,"Debe seleccionar una fila para eliminar");
        }else{
            vendedor_Infor.eliminarVendedor(id);
        }
    }
    
    public void nuevoVendedor (){
      
        vendedor_from.txtidentidad.setText("");
        vendedor_from.txtNombres.setText("");
        vendedor_from.txtTelefono.setText("");
        vendedor_from.txtUsuario.setText("");
        
     }
    public void limpiarTablaVendedor(JTable table){
      
        try {
            int fila = table.getRowCount();
            for( int i = 0 ; fila > i;i++){
                tableModel.removeRow(0);
               
            }
            //JOptionPane.showMessageDialog(null, "Tabla limpiado con exito");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al limpiar la tabla");
        }
    }
    public void listarVendedor (){
        
        List<Vendedor_D> listar = vendedor_Infor.listarVendedor();
        tableModel = (DefaultTableModel) vendedor_from.tablaVendedor.getModel();
        Object objec [] = new Object[6];
        for (int i = 0 ; i <  listar.size(); i++ ){
            objec[0] = listar.get(i).getIdven();
            objec[1] = listar.get(i).getCi();
            objec[2] = listar.get(i).getNom();
            objec[3] = listar.get(i).getTel();
            objec[4] = listar.get(i).getUser();
            objec[5] = listar.get(i).getEstado();
            tableModel.addRow(objec);
        }
       vendedor_from.tablaVendedor.setModel(tableModel);
    }
}
