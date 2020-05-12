
package Controladores;

import Datos_Clases.Cliente_DS;
import Modelos_BBDD.Cliente_Base;
import Vista.From_Cliente_Grafica;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


public class Cliente_Controlador extends MouseAdapter implements ActionListener{
    
    From_Cliente_Grafica Grafica_Fr ;
    Cliente_Base cliente_BDA = new Cliente_Base();
    Cliente_DS cliente = new Cliente_DS();
    DefaultTableModel tableModel = new DefaultTableModel();
    
    int id;

    public Cliente_Controlador(From_Cliente_Grafica grafica) {
        this.Grafica_Fr = grafica;
       //System.out.println("aqui estamos");
        listarCliente();
        
        this.Grafica_Fr.btnagregarcliente.addActionListener(this);
        grafica.btnnuevocliente.addActionListener(this);
        grafica.btnactualizarcliente.addActionListener(this);
        grafica.btneliminarcliente.addActionListener(this);
        
        grafica.tablacliente.addMouseListener(this);
        
        
    }

    
    @Override
    public void actionPerformed(ActionEvent r) {
            if(Grafica_Fr.btnagregarcliente==r.getSource()){
            try {
                agregar();
                limpiarTablaCliente(Grafica_Fr.tablacliente);
                listarCliente();
              
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "No se pudo agregar el cliente"); 
            }
        }else if(Grafica_Fr.btnactualizarcliente==r.getSource()){
            try {
                actulizarCliente();
                limpiarTablaCliente(Grafica_Fr.tablacliente);
                listarCliente();

            } catch (Exception e) {
               JOptionPane.showMessageDialog(null, "no se pudo actualizar el cliente");  
            }
        }else if(Grafica_Fr.btneliminarcliente==r.getSource()){
            try {
               eliminarCliente();
               limpiarTablaCliente(Grafica_Fr.tablacliente);
               listarCliente();
              
            } catch (Exception e) {
                 JOptionPane.showMessageDialog(null, "No se pudo eliminar el cliente");
            }
        }else if(Grafica_Fr.btnnuevocliente==r.getSource()){
            try {
                nuevoCliente();
            
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "No se pudo crear nuevo cliente");
            }
        }
        
    }
    
        
    
    
      @Override
    public void mouseClicked (MouseEvent e){
        int fila = Grafica_Fr.tablacliente.getSelectedRow();
        
        if(fila==-1){
            JOptionPane.showMessageDialog(null,"Debe seleccionar una fila");
        }else{
            id = Integer.parseInt(Grafica_Fr.tablacliente.getValueAt(fila,0).toString());
            //para actulizar 
            String ci=Grafica_Fr.tablacliente.getValueAt(fila, 1).toString();
            String nom=Grafica_Fr.tablacliente.getValueAt(fila,2).toString();
            String dir = Grafica_Fr.tablacliente.getValueAt(fila,3).toString();
            
            Grafica_Fr.txtcedulaidentidad.setText(ci);
            Grafica_Fr.txtnombres.setText(nom);
            Grafica_Fr.txtdireccion.setText(dir);
         
        }
        
    }
    
    
    
    
     public void agregar (){
        
         String ci = Grafica_Fr.txtcedulaidentidad.getText();
         String nom = Grafica_Fr.txtnombres.getText();
         String dir = Grafica_Fr.txtdireccion.getText();
         
         Object object []= new Object[3];
         //El id es autoincremet
         object[0]=ci;
         object[1]=nom;
         object[2]=dir;
         
         cliente_BDA.insertarCliente(object);
    }
     
     public void actulizarCliente (){
         int fila = Grafica_Fr.tablacliente.getSelectedRow();
         if(fila== - 1){
             JOptionPane.showMessageDialog(null, "Debe seleccionar un fila");
         }else{
         String ci = Grafica_Fr.txtcedulaidentidad.getText();
         String nom = Grafica_Fr.txtnombres.getText();
         String dir = Grafica_Fr.txtdireccion.getText();
         
          Object object []= new Object[4];
         //El id es autoincremet
         object[0]=ci;
         object[1]=nom;
         object[2]=dir;
         object[3]=id;
         
         cliente_BDA.actulizarCliente(object);
         
         }
     }
     public void eliminarCliente(){
         int fila = Grafica_Fr.tablacliente.getSelectedRow();
         //int ids = Integer.parseInt(tableModel.getValueAt(fila,0).toString());
         if(fila==-1){
             JOptionPane.showMessageDialog(null,"Debe seleccionar una fila");
         }else{
             cliente_BDA.eliminarCliente(id);
         }
     }
     public void nuevoCliente (){
         Grafica_Fr.txtcedulaidentidad.setText("");
         Grafica_Fr.txtnombres.setText("");
         Grafica_Fr.txtdireccion.setText("");
     }
     public void limpiarTablaCliente(JTable tablaex){
         try {
             int fila = tablaex.getRowCount();
             for(int i = 0 ; fila >i ; i++){
                 tableModel.removeRow(0);
             }
         } catch (Exception e) {
         JOptionPane.showMessageDialog(null,"Error al limpiar la tabla.");
         }
     }
     public void listarCliente (){
         
        
        List<Cliente_DS> listar = cliente_BDA.listarCliente();
        tableModel = (DefaultTableModel)Grafica_Fr.tablacliente.getModel();
        Object objects[] = new Object[4];
        for (int i = 0; i < listar.size(); i++){
            objects[0]=listar.get(i).getIdCli();
            objects[1]=listar.get(i).getCiCli();
            objects[2]=listar.get(i).getNom();
            objects[3]=listar.get(i).getDire();
            
            tableModel.addRow(objects);
            
        }
        
        Grafica_Fr.tablacliente.setModel(tableModel);
    }

    
    
    
    
    
}
