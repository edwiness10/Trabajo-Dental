package com.dent.Int;

 

import static com.dent.Int.IntFactura.xml;

import com.dent.clases.*;

import com.dent.dato.Conexion;

import com.dent.dato.Validaciones;

import java.awt.Color;

import java.awt.event.KeyEvent;

import static java.lang.Double.parseDouble;

import java.net.InetAddress;

import java.text.DateFormat;

import java.text.DecimalFormat;

import java.text.SimpleDateFormat;

import java.util.Date;

import java.util.Stack;

import java.util.regex.Matcher;

import java.util.regex.Pattern;

import javax.swing.JFrame;

import javax.swing.JOptionPane;

import javax.swing.table.DefaultTableModel;



/**

 *

 * @author DELL

 */

public class IntPri extends javax.swing.JFrame {



    /**

     * Creates new form IntP

     */

  DefaultTableModel modelo=new DefaultTableModel();

  String  marcaUbi="";

  String datos[]={"","","1"};

  ConexionMySQL mysql = new ConexionMySQL();

  public String[] moG= {"","",""};

  double total=0;

  String ipUser;

  String maquinaUser;

  String nombreUser;

   static boolean facturas;

   

  double monedasAnterior; 

   

 public static void main(String args[]) {

        /* Set the Nimbus look and feel */

        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">

        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.

         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 

         */

        try {

            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {

                if ("Nimbus".equals(info.getName())) {

                    javax.swing.UIManager.setLookAndFeel(info.getClassName());

                    break;

                }

            }

        } catch (ClassNotFoundException ex) {

            java.util.logging.Logger.getLogger(IntPri.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {

            java.util.logging.Logger.getLogger(IntPri.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {

            java.util.logging.Logger.getLogger(IntPri.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {

            java.util.logging.Logger.getLogger(IntPri.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);

        }

        //</editor-fold>

        //</editor-fold>



        /* Create and display the form */

        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {

                new IntPri().setVisible(true);

            }

        });

    }



    public static String ipRegistro;

    String fechaCompra = "";

    String fechaFactura = "";



    public IntPri() {

        initComponents();

         facturas= true;

         ipRegistro= maquina();

         String titu[]={"Codigo","Ubicacion","Cantidad","Stock ","Bodega","Tienda"};

         this.setLocationRelativeTo(null);

         

         modelo.setColumnIdentifiers(titu);

//        Tabla.setModel(modelo);

        

        

        }

    

    public String maquina(){

       String maquina="";

       try {

            InetAddress localHost = InetAddress.getLocalHost();



            ipUser = localHost.getHostAddress();

            maquinaUser = localHost.getHostName();

            nombreUser = System.getProperty("user.name");

            

            maquina=ipUser+" "+maquinaUser+" ("+nombreUser+")";

            

            NOMBRE.setText(maquinaUser+" ("+nombreUser+")"+" "+ ipUser);

            

            

            System.out.println(ipUser);

            System.out.println(maquinaUser);

            System.out.println(nombreUser);

            

        } catch (Exception e) {

                 JOptionPane.showMessageDialog(null, "Se genero un error al obtener los datos de la red.\n Error: e ");

        }

        

        

        

        

        

       return maquina ; 

    }

    

    

    

    



   

    @SuppressWarnings("unchecked")

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        Alta3 = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        Alta4 = new javax.swing.JButton();
        jLabel17 = new javax.swing.JLabel();
        Alta5 = new javax.swing.JButton();
        jLabel29 = new javax.swing.JLabel();
        Alta6 = new javax.swing.JButton();
        jLabel30 = new javax.swing.JLabel();
        jPanel13 = new javax.swing.JPanel();
        NOMBRE = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        Alta1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        Baja = new javax.swing.JButton();
        Alta = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        Alta2 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        jCheckBoxMenuItem1 = new javax.swing.JCheckBoxMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Dentitodo Inventario");
        setMaximumSize(new java.awt.Dimension(991, 631));
        setMinimumSize(new java.awt.Dimension(991, 631));
        setPreferredSize(new java.awt.Dimension(991, 631));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/dent/imag/LOGO_DENTITODO2.fw.png"))); // NOI18N
        jLabel2.setText("jLabel2");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 260, 130));

        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Herramientas", javax.swing.border.TitledBorder.RIGHT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 0, 18), new java.awt.Color(255, 255, 255))); // NOI18N
        jPanel8.setForeground(new java.awt.Color(255, 255, 255));
        jPanel8.setToolTipText("Inventario");
        jPanel8.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel8.setOpaque(false);
        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Alta3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Alta3.setForeground(new java.awt.Color(255, 255, 255));
        Alta3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/dent/iconos/mone1.fw.png"))); // NOI18N
        Alta3.setContentAreaFilled(false);
        Alta3.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        Alta3.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/com/dent/iconos/mone2.fw.png"))); // NOI18N
        Alta3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Alta3ActionPerformed(evt);
            }
        });
        jPanel8.add(Alta3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, -1, -1));

        jLabel16.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Conteo de monedas");
        jPanel8.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, 140, 20));

        Alta4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Alta4.setForeground(new java.awt.Color(255, 255, 255));
        Alta4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/dent/iconos/fact_1.png"))); // NOI18N
        Alta4.setContentAreaFilled(false);
        Alta4.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        Alta4.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/com/dent/iconos/fact_1.fw.png"))); // NOI18N
        Alta4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Alta4ActionPerformed(evt);
            }
        });
        jPanel8.add(Alta4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 150, -1, -1));

        jLabel17.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("Reporte General");
        jPanel8.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 120, 120, 20));

        Alta5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Alta5.setForeground(new java.awt.Color(255, 255, 255));
        Alta5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/dent/iconos/Sin-título-1.gif"))); // NOI18N
        Alta5.setContentAreaFilled(false);
        Alta5.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        Alta5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Alta5ActionPerformed(evt);
            }
        });
        jPanel8.add(Alta5, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 30, -1, -1));

        jLabel29.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(255, 255, 255));
        jLabel29.setText("Facturas");
        jPanel8.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 240, 60, 20));

        Alta6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Alta6.setForeground(new java.awt.Color(255, 255, 255));
        Alta6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/dent/iconos/top-1.png"))); // NOI18N
        Alta6.setContentAreaFilled(false);
        Alta6.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        Alta6.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/com/dent/iconos/top-2.fw.png"))); // NOI18N
        Alta6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Alta6ActionPerformed(evt);
            }
        });
        jPanel8.add(Alta6, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 150, -1, -1));

        jLabel30.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(255, 255, 255));
        jLabel30.setText("Top");
        jPanel8.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 240, 60, 20));

        getContentPane().add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 240, 420, 280));

        jPanel13.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Detalles", javax.swing.border.TitledBorder.RIGHT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 0, 18), new java.awt.Color(255, 255, 255))); // NOI18N
        jPanel13.setForeground(new java.awt.Color(255, 255, 255));
        jPanel13.setToolTipText("Inventario");
        jPanel13.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel13.setOpaque(false);
        jPanel13.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        NOMBRE.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        NOMBRE.setForeground(new java.awt.Color(255, 255, 255));
        NOMBRE.setText("Usuario");
        jPanel13.add(NOMBRE, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 400, 20));

        getContentPane().add(jPanel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 180, 420, 50));

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Inventario", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 0, 18), new java.awt.Color(255, 255, 255))); // NOI18N
        jPanel2.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.setToolTipText("Inventario");
        jPanel2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel2.setOpaque(false);
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Alta1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Alta1.setForeground(new java.awt.Color(255, 255, 255));
        Alta1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/dent/iconos/iconocom.1.fw.png"))); // NOI18N
        Alta1.setContentAreaFilled(false);
        Alta1.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        Alta1.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/com/dent/iconos/iconocom.2.fw.png"))); // NOI18N
        Alta1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Alta1ActionPerformed(evt);
            }
        });
        jPanel2.add(Alta1, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 30, -1, -1));

        jLabel3.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Importar");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, 190, 50));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 380, 420, 140));

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Gestion de Inventario", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 0, 18), new java.awt.Color(255, 255, 255))); // NOI18N
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.setToolTipText("Gestion de Inventario");
        jPanel1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel1.setOpaque(false);
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Baja.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Baja.setForeground(new java.awt.Color(255, 255, 255));
        Baja.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/dent/iconos/bajas.fw.png"))); // NOI18N
        Baja.setText("Baja");
        Baja.setContentAreaFilled(false);
        Baja.setEnabled(false);
        Baja.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/com/dent/iconos/bajas.s.fw.png"))); // NOI18N
        Baja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BajaActionPerformed(evt);
            }
        });
        jPanel1.add(Baja, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 50, -1, -1));

        Alta.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Alta.setForeground(new java.awt.Color(255, 255, 255));
        Alta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/dent/iconos/alta.fw.png"))); // NOI18N
        Alta.setText("Alta");
        Alta.setContentAreaFilled(false);
        Alta.setEnabled(false);
        Alta.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        Alta.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/com/dent/iconos/alta.s.fw.png"))); // NOI18N
        Alta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AltaActionPerformed(evt);
            }
        });
        jPanel1.add(Alta, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 50, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 40, 420, 160));

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Inventario", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 0, 18), new java.awt.Color(255, 255, 255))); // NOI18N
        jPanel3.setForeground(new java.awt.Color(255, 255, 255));
        jPanel3.setToolTipText("Inventario");
        jPanel3.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel3.setOpaque(false);
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Alta2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Alta2.setForeground(new java.awt.Color(255, 255, 255));
        Alta2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/dent/iconos/Modificacion.fw.png"))); // NOI18N
        Alta2.setContentAreaFilled(false);
        Alta2.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        Alta2.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/com/dent/iconos/Modificacion.s.fw.png"))); // NOI18N
        Alta2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Alta2ActionPerformed(evt);
            }
        });
        jPanel3.add(Alta2, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 30, -1, -1));

        jLabel4.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Inventario");
        jPanel3.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, 190, 50));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 230, 420, 130));

        jLabel25.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(255, 255, 255));
        jLabel25.setText("v3.6.0");
        getContentPane().add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 140, 70, 20));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/dent/imag/red-simple-wallpapers-1920x1080.jpg"))); // NOI18N
        jLabel1.setRequestFocusEnabled(false);
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-640, -160, 1760, 780));

        jMenu1.setText("Opciones");

        jMenuItem1.setText("Online");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);
        jMenu1.add(jSeparator1);

        jMenu3.setText("Facturas");

        jMenuItem3.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem3.setText("Agregar");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem3);

        jMenu1.add(jMenu3);

        jMenu4.setText("Conteo de monedas");

        jCheckBoxMenuItem1.setSelected(true);
        jCheckBoxMenuItem1.setText("Borrar cantidad al seleccionar");
        jMenu4.add(jCheckBoxMenuItem1);

        jMenu1.add(jMenu4);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents



    private void AltaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AltaActionPerformed

    

        

       

             new IntGest().setVisible(true);

             new IntGest().setMarcaTipo(true);

         

           

               

        

        

        

        

//        if (dep.isSelected() ) {

//            new VtnDpto().setVisible(true);

//        }

//

//        if (Pro.isSelected() ) {

//            new VtnSec().setVisible(true);

//        }

//

//        if (res.isSelected() ) {

//            new VtnResp().setVisible(true);

//        }



    }//GEN-LAST:event_AltaActionPerformed



    private void BajaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BajaActionPerformed

        // TODO add your handling code here:

             new IntGest().setVisible(true);

             new IntGest().setMarcaTipo(false);

           

        

    }//GEN-LAST:event_BajaActionPerformed



    private void Alta1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Alta1ActionPerformed

        // TODO add your handling code here:

       // System.out.println("55");       

       

        if (facturas) {

            facturas=false;

             new IntLogin().setVisible(true);

        }else{

            JOptionPane.showMessageDialog(rootPane, "Solo se puede abrir una ventana de Importar ala vez. ", "Aviso", JOptionPane.INFORMATION_MESSAGE  );

        }

      

        

        

    }//GEN-LAST:event_Alta1ActionPerformed



    private void Alta2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Alta2ActionPerformed

        // TODO add your handling code here:



        IntCons nue = new IntCons();



        nue.show();

    }//GEN-LAST:event_Alta2ActionPerformed



    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed

        // TODO add your handling code here:



        new IntOnline().setVisible(true);





    }//GEN-LAST:event_jMenuItem1ActionPerformed



    private void Alta3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Alta3ActionPerformed

        // TODO add your handling code here

        IntAltaFac fac = new IntAltaFac();

        fac.Calculadora();

        

    }//GEN-LAST:event_Alta3ActionPerformed



   

    

    

    private void Alta4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Alta4ActionPerformed

        // TODO add your handling code here:

        

         IntAltaFac fac = new IntAltaFac();

        fac.show();

       

    }//GEN-LAST:event_Alta4ActionPerformed



    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed

        // TODO add your handling code here:



    }//GEN-LAST:event_jMenuItem3ActionPerformed



    private void Alta5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Alta5ActionPerformed

        // TODO add your handling code here:    



        IntResumen resumen = new IntResumen();

        resumen.setVisible(true);





    }//GEN-LAST:event_Alta5ActionPerformed



    private void Alta6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Alta6ActionPerformed

        // TODO add your handling code here:
        
        
        IntAnaliz An =new IntAnaliz();
        An.show();

    }//GEN-LAST:event_Alta6ActionPerformed



    private void veriNumero(){

       

        

    }

    

    

    

    /**

     * @param args the command line arguments

     */

    

    public String getIpUser() {

        return ipUser;

    }



    public void setIpUser(String ipUser) {

        this.ipUser = ipUser;

    }



    public String getMaquinaUser() {

        return maquinaUser;

    }



    public void setMaquinaUser(String maquinaUser) {

        this.maquinaUser = maquinaUser;

    }



    public String getNombreUser() {

        return nombreUser;

    }



    public void setNombreUser(String nombreUser) {

        this.nombreUser = nombreUser;

    }

    public String getIpRegistro() {

        return ipRegistro;

    }



    public void setIpRegistro(String ipRegistro) {

        this.ipRegistro = ipRegistro;

    }

    public static boolean isFacturas() {

        return facturas;

    }



    public static void setFacturas(boolean facturas) {

        IntPri.facturas = facturas;

    }

     

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Alta;
    private javax.swing.JButton Alta1;
    private javax.swing.JButton Alta2;
    private javax.swing.JButton Alta3;
    private javax.swing.JButton Alta4;
    private javax.swing.JButton Alta5;
    private javax.swing.JButton Alta6;
    private javax.swing.JButton Baja;
    private javax.swing.JLabel NOMBRE;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    // End of variables declaration//GEN-END:variables

}