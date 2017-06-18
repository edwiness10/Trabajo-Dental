/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dent.Int;

import com.dent.clases.ConexionMySQL;
import com.dent.dato.Conexion;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


/**
 *
 * @author DELL
 */
public class IntLogin extends javax.swing.JFrame {

    
    int opcion;
    private String idUserF;
    private String contraUserF;

    public IntLogin() {
        initComponents();
        this.setLocationRelativeTo(null);
    }
    

 
    public void loginUsuario (){
  
            ConexionMySQL mysql = new ConexionMySQL();

            java.sql.Connection cn= mysql.Conectar(idUser.getText(),idContra.getText());
            try{

                   if(!cn.equals(null)){

                
                
                
                //mysql.Insertar(idUserI,idContraI);
                
                IntFactura factura =new IntFactura();
        
                this.dispose();
                
                factura.Inicio(idUser.getText(),idContra.getText());

                try{

                    cn.close();
                    
                }catch(SQLException ex){

                    System.out.println("Error al desconectar "+ex);
                    
                }

        }
                    
                }catch(Exception ex){

                    System.out.println("Error al desconectar "+ex);
                    System.out.println("error");
                    idContra.setForeground(Color.red);
                    idUser.setForeground(Color.red);
                    
                }
        
            
    }

    
    public Object[] consultaSicar (String codigo ){
        Object[]  descripcion = null  ;
        Conexion.conectarSicar();
        try {  
           Conexion.st = Conexion.cn.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
          
           String result="select descripcion ,precioCompra,precio1,margen1,existencia from sicar.articulo where clave =upper (\""+ codigo+"\");";
        
           Conexion.rs=Conexion.st.executeQuery(result);
           
           ResultSetMetaData stMD = Conexion.rs.getMetaData();
           
//           System.out.println(" ok");
           
         try {
            while(Conexion.rs.next()){
               Object [] fila = new Object[stMD.getColumnCount()];
               //Crea un vector
               //para almacenar los valores del ResultSet
            
                for (int j = 0; j < stMD.getColumnCount(); j++) {
                      
                  
                  
                fila[j] = Conexion.rs.getObject(j+1); 
                descripcion =  fila;
     // El primer indice en rs es el 1, no el cero, por eso se suma 1. 
              }//añado el modelo a la tabla
//                System.out.println(Arrays.toString(descripcion));
                
                
               fila=null;//limpia los datos de el vector de la memoria
            }
            
//            System.out.println("ok 2");
            //cerrar result-set
        } catch (SQLException ex) {
            
                JOptionPane.showMessageDialog(null, " Error al consultar datos "+ ex);
               
        }
         
      } catch (SQLException ex) {
         JOptionPane.showMessageDialog(null, " Error al consultar datos "+ ex);
        
      }
      try {
          Conexion.cn.close();
          Conexion.rs.close();
      } catch (SQLException ex) {
          Logger.getLogger(IntLogin.class.getName()).log(Level.SEVERE, null, ex);
      }
         
        
        return descripcion ;
    }
    
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        idContra = new javax.swing.JPasswordField();
        jLabel1 = new javax.swing.JLabel();
        idUser = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        Fondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Inicio de sesión");
        setLocationByPlatform(true);
        setMaximumSize(new java.awt.Dimension(300, 440));
        setMinimumSize(new java.awt.Dimension(300, 440));
        setPreferredSize(new java.awt.Dimension(300, 440));
        setResizable(false);
        setSize(new java.awt.Dimension(300, 440));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(227, 227, 227));
        jLabel2.setText("Contraseña");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 230, -1, -1));

        idContra.setForeground(new java.awt.Color(102, 102, 102));
        idContra.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        idContra.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                idContraFocusGained(evt);
            }
        });
        idContra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idContraActionPerformed(evt);
            }
        });
        idContra.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                idContraKeyPressed(evt);
            }
        });
        getContentPane().add(idContra, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 250, 170, 40));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/dent/iconos/USER-2.fw.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 40, -1, -1));

        idUser.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        idUser.setForeground(new java.awt.Color(102, 102, 102));
        idUser.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        idUser.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                idUserFocusGained(evt);
            }
        });
        idUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idUserActionPerformed(evt);
            }
        });
        idUser.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                idUserKeyPressed(evt);
            }
        });
        getContentPane().add(idUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 180, 170, 40));

        jButton2.setText("Conectar");
        jButton2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 340, 110, 30));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(226, 226, 226));
        jLabel3.setText("Usuario");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 160, -1, -1));

        Fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/dent/imag/red-simple-wallpapers-1920x1080.jpg"))); // NOI18N
        getContentPane().add(Fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(-1450, 0, 1750, 640));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
        
//        //getDatos();
//       Datos = consultaOracle_des( ) ;
//       
//       
//        System.out.println("Total de datos cargados "+ Datos );
//         
//        
//        
//        
//        System.out.println(marcaTipo+" "+marcaUbi);
//        
//            if (marcaTipo) //alta
//        {jLabel1.setText("Alta de productos"); 
//        opcion=1;
//        }
//            else           //baja
//        {jLabel1.setText("Baja de productos *");
//        opcion=2;
//        }
//            
//                
//        
//       
//      
//         dato.requestFocus();
    }//GEN-LAST:event_formWindowOpened

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing

        IntPri.facturas=true;
        
        
        
        
    }//GEN-LAST:event_formWindowClosing

    private void idUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idUserActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_idUserActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        
        loginUsuario ();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void idUserFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_idUserFocusGained
        // TODO add your handling code here:
        idUser.setText("");
        idUser.setForeground(Color.gray);
        
        
    }//GEN-LAST:event_idUserFocusGained

    private void idContraFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_idContraFocusGained
        // TODO add your handling code here:
        idContra.setText("");
         idContra.setForeground(Color.gray);
        
    }//GEN-LAST:event_idContraFocusGained

    private void idContraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idContraActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_idContraActionPerformed

    private void idUserKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_idUserKeyPressed
        // TODO add your handling code here:
     char c;
        c = evt.getKeyChar();
        if ( c == KeyEvent.VK_ENTER )
        {
            
            this.idUser.transferFocus();
//sout  
                    
        }
    }//GEN-LAST:event_idUserKeyPressed

    private void idContraKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_idContraKeyPressed
        // TODO add your handling code here:
        char c;
        c = evt.getKeyChar();
        if ( c == KeyEvent.VK_ENTER )
        {
            
            loginUsuario ();
           
        }
    }//GEN-LAST:event_idContraKeyPressed
public String getIdUser() {
        return idUserF;
    }

    public void setIdUser(String idUser) {
        this.idUserF = idUser;
    }

    public String getContraUser() {
        return contraUserF;
    }

    public void setContraUser(String contraUser) {
        this.contraUserF = contraUser;
    }
    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(IntGest.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(IntGest.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(IntGest.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(IntGest.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new IntGest().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Fondo;
    private javax.swing.JPasswordField idContra;
    private javax.swing.JTextField idUser;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    // End of variables declaration//GEN-END:variables

    public String getIdUserF() {
        return idUserF;
    }

    public void setIdUserF(String idUserF) {
        this.idUserF = idUserF;
    }

    public String getContraUserF() {
        return contraUserF;
    }

    public void setContraUserF(String contraUserF) {
        this.contraUserF = contraUserF;
    }

   
   
    
}
