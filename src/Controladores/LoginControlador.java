
package Controladores;

import Datos_Clases.Vendedor_D;
import ConexionBBDD.*;
import ModelosDAO.*;
import Vista.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import javax.swing.JFrame;
import javax.swing.JOptionPane;



public class LoginControlador implements ActionListener{
    
    SistemaPrincipal_Controlador spc;
    LoginAcceso acceso;
    Vendedor_D datosV = new Vendedor_D();
    ValidarVendedor vendedor = new ValidarVendedor();

    public LoginControlador(LoginAcceso la) {
        
        this.acceso = la;
        la.setTitle("REGISTRO DE USUARIO");
        la.setLocationRelativeTo(null);
        la.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        la.setVisible(true);
        
        
        la.txtuser.setText("rec");
        la.txtpass.setText("123");
        //****************accion a los botones**********************
        
        la.btnIniciar.addActionListener(this);
        
    }
    
    
   

    @Override
    public void actionPerformed(ActionEvent e) {
        validar();
    }
    public void validar(){
        
        String ci=acceso.txtpass.getText();
        String user=acceso.txtuser.getText();

         if(user.equals("") || ci.equals("")){
           JOptionPane.showMessageDialog(acceso,"Ingrese datos caja de texto");
           acceso.txtuser.requestFocus();
           
         } else{
             
             datosV=vendedor.ValidarVen(ci, user);
             
               if (datosV.getUser() !=null && datosV.getCi() !=null){
                   
               SistemaPrincipal sistemaPrincipal = new SistemaPrincipal();
               SistemaPrincipal_Controlador principal_Controlador = new SistemaPrincipal_Controlador(sistemaPrincipal);
               acceso.dispose();      
           }else{
               JOptionPane.showMessageDialog(acceso,"Ingrese datos correctos"); 
               acceso.txtuser.requestFocus();
               }
         }
           
         
          
    }
    
    
    
}
    

