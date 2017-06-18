/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dent.Int;

import com.dent.dato.BoardListener;
import com.dent.clases.ConexionMySQL;
import com.dent.clases.ManipulaArchivos;
import com.dent.clases.ProXML;
import java.awt.Color;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author DELL
 */
public class IntFactura extends javax.swing.JFrame {

    /**
     * Creates new form IntP
     */
    DefaultTableModel modelo = new DefaultTableModel();

    int opcion;

    private String idUserF;
    private String contraUserF;
    
    

    static ProXML xml = new ProXML();
    
    ManipulaArchivos mani = new ManipulaArchivos();

    private int estadoLogin;

    String datos[] = {"", "", "", "", ""};

    public IntFactura() {
        initComponents();
        System.out.println(IntPri.ipRegistro);
        
        String titu[] = {"Cantidad", "Codigo", "Concepto", "Precio Unitario", "Importe"};
        modelo.setColumnIdentifiers(titu);
        ConSicar.setVisible(false);
        this.setLocationRelativeTo(null);
        Tabla.setModel(modelo);

    }
    public void Inicio(String idUser, String idPass) {
        IntPri.facturas=false;
        this.idUserF = idUser;
        this.contraUserF = idPass;
        userLabel.setText("Usuario: "+idUserF);
        this.setVisible(true);

    }
   
    public boolean InsetDatoArti_xxx(){
            boolean estado=true;
            ConexionMySQL mysql = new ConexionMySQL();
            
            String aux="";
            
            String getCantidad="";
            String getCodigo="";
            String getArticulo="";
            String getValor="";
            
            
            for (int i = 0; i < xml.tamañoLista(); i++) {
 
              
            getCantidad = String.valueOf(xml.lista.get(i).getCantidad());
            getCodigo = xml.lista.get(i).getCodigo();
            getArticulo = xml.lista.get(i).getArticulo();
            getValor = String.valueOf(xml.lista.get(i).getValor());
            
            aux=getCantidad+getCodigo+getArticulo+getValor;
            System.out.println(aux);
            String consulta="call dentitodo.prueba2('"+ aux +"')";
                if (mysql.Ejecuta(idUserF, contraUserF,consulta )) {
                    estado=true;
                }else{
                    estado=false;
                    break;
                }

            

        }
        System.out.println("sicar Exito");
        return estado;
        
    }
    
    public boolean InsetDatoArti(){
            boolean estado=true;
            ConexionMySQL mysql = new ConexionMySQL();
            
            String aux="";
            
            String getCantidad="";
            String getCodigo="";
            String getArticulo="";
            String getValor="";
            
            
            for (int i = 0; i < xml.tamañoLista(); i++) {
 
              
            getCantidad = String.valueOf(xml.lista.get(i).getCantidad());
            getCodigo = xml.lista.get(i).getCodigo();
            getArticulo = xml.lista.get(i).getArticulo();
            getValor = String.valueOf(xml.lista.get(i).getValor());
            
           
            char[] cPalabra = getCodigo.toCharArray();
                         String aux3 = "";
                        for (int j = 0; j < cPalabra.length; j++) {
                            if (cPalabra[j] != '$' && cPalabra[j] != '-' && cPalabra[j] != '"') {
                                aux3 = aux3 + cPalabra[j];
                            }}
                        
            aux=xml.getNoFactura()+"','"+getCodigo+"','"+getArticulo+"','"+getValor+"','30','"+getCantidad+"','"+xml.getRfc()+"','"+IntPri.ipRegistro+" "+idUserF+"','"+aux3;
            System.out.println(aux);
            
           // call sicar.registroArti('AB-2075','Pruebaprueba2','esto es una prueba Smith generada auto',10000,150,1,'DDV890119HC9','ip');
           // String.valueOf(xml.getTotalCIVA()) + "','" + xml.getNoFactura() + " Esta Factura se añadio via software','" + xml.getRfc();
            
            String consulta="call sicar.registroArti('"+ aux +"')";
                if (mysql.Ejecuta(idUserF, contraUserF,consulta )) {
                    estado=true;
                }else{
                    estado=false;
                    break;
                }

            

        }
            
        System.out.println("sicar Exito");
        return estado;
        
    }
    
    
    
    
    public boolean InsetDatoPedi() {
        boolean estado=true;
        ConexionMySQL mysql = new ConexionMySQL();

        String aux = String.valueOf(xml.getTotalCIVA()) + "','" + xml.getNoFactura() + " Esta Factura se añadio via software','" + xml.getRfc();

        String consulta = "call sicar.CreacionPedido ('" + aux + "')";
       
        estado = mysql.Ejecuta(idUserF, contraUserF, consulta);
        
         
        return estado;

  
    }

    
    
    public void limpiarTa() {
        if (modelo.getRowCount() != 0) {
            int aux = modelo.getRowCount();
            int aux2 = aux - 1;
            for (int i = 0; i < aux; i++) {
                if (aux2 - i > -1) {
                    modelo.removeRow(aux2 - i);
                }

            }
        }
    }

    public void cargaTabla() {

        for (int i = 0; i < xml.tamañoLista(); i++) {

            datos[0] = String.valueOf(xml.lista.get(i).getCantidad());
            datos[1] = xml.lista.get(i).getCodigo();
            datos[2] = xml.lista.get(i).getArticulo();
            datos[3] = String.valueOf(xml.lista.get(i).getValor());
            datos[4] = String.valueOf((xml.lista.get(i).getValor()) * xml.lista.get(i).getCantidad());

            modelo.addRow(datos);

        }

    }

    public void cargadatos() {

        xml.lista.clear();
        xml.setRuta("");
        File arch;
        JFileChooser jfC = new JFileChooser();
        jfC.setFileFilter( new FileNameExtensionFilter(" Archivo .XML", "xml"));
        
        int r = jfC.showOpenDialog(this);
        if (r == JFileChooser.APPROVE_OPTION) {
            arch = jfC.getSelectedFile();

            xml.setRuta(arch.toString());
            System.out.println(arch.toString());
            rutaTexto.setText(arch.toString());
        }
        limpiarTa();
        if (!"".equals(xml.getRuta())) {
            xml.LecturaXML();
            cargaTabla();
            double aux = xml.getTotalCIVA(); 
            String datosF = "No.: " + xml.getNoFactura() + "\n    Proveedor: " + xml.getRfc() + " " + xml.getRfcNombre();

            rfcFactura.setText(datosF);
            jLabel1.setText("$ " + String.valueOf(aux));
        }
        Arti_D.setText("No. de articulos cargados: "+xml.getArti_Carga());
        Arti_v.setText("No. de articulos Facturados: "+ xml.getArti_Fac());
        if (modelo.getRowCount() != 0) {
            ConSicar.setVisible(true);
        }
                

    }

    //se ingresa como usuario

    public int loginUsuario() {
        int estado = 0;

        return estado;
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFrame1 = new javax.swing.JFrame();
        jScrollPane1 = new javax.swing.JScrollPane();
        Tabla = new javax.swing.JTable();
        ConSicar = new javax.swing.JButton();
        userLabel = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        rutaTexto = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        Aceptar1 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        rfcFactura = new javax.swing.JLabel();
        Arti_v = new javax.swing.JLabel();
        Arti_D = new javax.swing.JLabel();
        Fondo = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        util_v = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        jMenuItem5 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Compra Automatica");
        setLocationByPlatform(true);
        setMinimumSize(new java.awt.Dimension(880, 573));
        setResizable(false);
        setSize(new java.awt.Dimension(880, 573));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane1.setAutoscrolls(true);

        Tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        Tabla.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        Tabla.setFocusable(false);
        Tabla.setMaximumSize(new java.awt.Dimension(600, 64));
        Tabla.setMinimumSize(new java.awt.Dimension(300, 64));
        jScrollPane1.setViewportView(Tabla);
        if (Tabla.getColumnModel().getColumnCount() > 0) {
            Tabla.getColumnModel().getColumn(0).setResizable(false);
            Tabla.getColumnModel().getColumn(1).setResizable(false);
            Tabla.getColumnModel().getColumn(2).setResizable(false);
            Tabla.getColumnModel().getColumn(3).setResizable(false);
            Tabla.getColumnModel().getColumn(3).setPreferredWidth(50);
        }

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 200, 760, 240));

        ConSicar.setBackground(new java.awt.Color(153, 255, 153));
        ConSicar.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        ConSicar.setForeground(new java.awt.Color(255, 255, 255));
        ConSicar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/dent/iconos/Actu.fw.png"))); // NOI18N
        ConSicar.setText("Importar Factura");
        ConSicar.setToolTipText("");
        ConSicar.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        ConSicar.setContentAreaFilled(false);
        ConSicar.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/com/dent/iconos/Actu2.fw.png"))); // NOI18N
        ConSicar.setVerifyInputWhenFocusTarget(false);
        ConSicar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ConSicarActionPerformed(evt);
            }
        });
        getContentPane().add(ConSicar, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 460, 220, -1));

        userLabel.setForeground(new java.awt.Color(255, 255, 255));
        userLabel.setText("Usuario: ");
        getContentPane().add(userLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 40, 240, 20));

        jLabel3.setBackground(new java.awt.Color(0, 0, 204));
        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Compra Automatica");
        jLabel3.setOpaque(true);
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 880, 40));

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Ubicación de la Archivo XML", javax.swing.border.TitledBorder.RIGHT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 0, 18), new java.awt.Color(255, 255, 255))); // NOI18N
        jPanel2.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.setToolTipText("Inventario");
        jPanel2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel2.setOpaque(false);
        jPanel2.setLayout(new java.awt.BorderLayout());

        rutaTexto.setBackground(new java.awt.Color(242, 242, 242));
        rutaTexto.setFocusable(false);
        rutaTexto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rutaTextoActionPerformed(evt);
            }
        });
        jPanel2.add(rutaTexto, java.awt.BorderLayout.CENTER);

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 60, 540, 70));

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Total de factura sin IVA", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 0, 18), new java.awt.Color(255, 255, 255))); // NOI18N
        jPanel3.setForeground(new java.awt.Color(255, 255, 255));
        jPanel3.setToolTipText("Inventario");
        jPanel3.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel3.setOpaque(false);
        jPanel3.setLayout(new java.awt.BorderLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel3.add(jLabel1, java.awt.BorderLayout.CENTER);

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 460, 270, 70));

        Aceptar1.setBackground(new java.awt.Color(153, 255, 153));
        Aceptar1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        Aceptar1.setForeground(new java.awt.Color(255, 255, 255));
        Aceptar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/dent/iconos/icon-.fw.png"))); // NOI18N
        Aceptar1.setText("Cargar");
        Aceptar1.setToolTipText("");
        Aceptar1.setContentAreaFilled(false);
        Aceptar1.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/com/dent/iconos/icon-.fw2.fw.png"))); // NOI18N
        Aceptar1.setVerifyInputWhenFocusTarget(false);
        Aceptar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Aceptar1ActionPerformed(evt);
            }
        });
        getContentPane().add(Aceptar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 50, 190, -1));

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Datos de la factura", javax.swing.border.TitledBorder.RIGHT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 0, 14), new java.awt.Color(255, 255, 255))); // NOI18N
        jPanel4.setForeground(new java.awt.Color(255, 255, 255));
        jPanel4.setToolTipText("Inventario");
        jPanel4.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel4.setOpaque(false);
        jPanel4.setLayout(new java.awt.BorderLayout());

        rfcFactura.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        rfcFactura.setForeground(new java.awt.Color(255, 255, 255));
        rfcFactura.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jPanel4.add(rfcFactura, java.awt.BorderLayout.CENTER);

        getContentPane().add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 130, 760, 60));

        Arti_v.setForeground(new java.awt.Color(255, 255, 255));
        Arti_v.setText("No. de articulos Facturados:");
        getContentPane().add(Arti_v, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 470, -1, -1));

        Arti_D.setForeground(new java.awt.Color(255, 255, 255));
        Arti_D.setText("No. de articulos cargados:");
        getContentPane().add(Arti_D, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 490, -1, -1));

        Fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/dent/imag/red-simple-wallpapers-1920x1080.jpg"))); // NOI18N
        getContentPane().add(Fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(-870, -90, 1750, 640));

        jMenu3.setText("Opciones");

        jMenuItem3.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem3.setText("Importar Factura");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem3);

        jMenuItem2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_B, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem2.setText("Buscar");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem2);

        jMenuItem4.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem4.setText("Copiar");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem4);

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Z, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem1.setText("Borrar");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem1);

        jMenuBar1.add(jMenu3);

        jMenu4.setText("Datos");

        util_v.setText("Utilidad");
        util_v.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                util_vActionPerformed(evt);
            }
        });
        jMenu4.add(util_v);
        jMenu4.add(jSeparator1);

        jMenuItem5.setText("Productos nuevos");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem5);

        jMenuBar1.add(jMenu4);

        setJMenuBar(jMenuBar1);

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

      this.contraUserF="";
      this.idUserF  =""; 
      
      IntPri.facturas=true;
        
      
    }//GEN-LAST:event_formWindowClosing

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:

        int n = JOptionPane.showConfirmDialog(
                null,
                "En verdad quiere borrar todos los articulos?",
                "Compra Automatica",
                JOptionPane.YES_NO_OPTION);

        if (n == 0) {
            rutaTexto.setText("");
            xml.setRuta("");
            xml.lista.clear();
            limpiarTa();
            xml.setTotalCIVA(0);
//        aux=aux*1.16;
            Arti_D.setText("");
            Fondo.setText("");
            jLabel1.setText("");
            rfcFactura.setText("");
        } else {

        }


    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void rutaTextoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rutaTextoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rutaTextoActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed

        boolean estado = true;
        String buscar = JOptionPane.showInputDialog("Porfavor inserte codigo a buscar");
        buscar=buscar.toUpperCase();
        String aux = "";
        System.out.println("Buscar ");

        if (buscar != null) {
            System.out.println("ok");

            for (int i = 0; i < modelo.getRowCount(); i++) {
                aux = modelo.getValueAt(i, 1).toString().toUpperCase();
                System.out.println(" buscando en -" + aux + "- y es  -" + buscar + "-");

                if (null == buscar ? aux == null : buscar.equals(aux)) {

                    System.out.println("Es correcto");

                    Tabla.changeSelection(i, 1, false, false);
                    estado = false;

                } else {
                    //  JOptionPane.showMessageDialog(jMenu1, i);
                }

            }
            if (estado == true) {
                JOptionPane.showMessageDialog(null, "No se encontro dato " + buscar);
            }
        }

// TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        cargadatos();

    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void Aceptar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Aceptar1ActionPerformed
        // TODO add your handling code here:
        cargadatos();
    }//GEN-LAST:event_Aceptar1ActionPerformed

    private void ConSicarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ConSicarActionPerformed
        
        if (InsetDatoPedi()) {
            if (InsetDatoArti()) {
                try {
                    mani.copioArchivo(rutaTexto.getText(), xml.getNoFactura());
                } catch (IOException ex) {
                    System.out.println("Error al generar archivo");
                }
                JOptionPane.showMessageDialog(null, "Fue un Exito ");
                rutaTexto.setText("");
                xml.setRuta("");
                xml.lista.clear();
                limpiarTa();
                xml.setTotalCIVA(0);
//        aux=aux*1.16;
                jLabel1.setText("");
                rfcFactura.setText("");
                Arti_D.setText("");
                Fondo.setText("");
                ConSicar.setVisible(false);
            }
        }
        
        
        
//        InsetDatoArti_xxx();
        
        
        
        
        
        
    }//GEN-LAST:event_ConSicarActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        // TODO add your handling code here:
        String Aux ="";
        BoardListener copio =new BoardListener();
        for (int i = 0; i < xml.tamañoLista(); i++) {
            
            Aux = Aux + String.valueOf(xml.lista.get(i).getCantidad())+"\t";
            Aux = Aux +" "+xml.lista.get(i).getCodigo()+"\t";
            Aux = Aux +" "+xml.lista.get(i).getArticulo()+" ";
            Aux = Aux +" "+String.valueOf(xml.lista.get(i).getValor())+"\t";
            Aux = Aux +" "+String.valueOf((xml.lista.get(i).getValor()) * xml.lista.get(i).getCantidad())+"\n";

          

        }
        copio.setClipboard(Aux);
       
        
        
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void util_vActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_util_vActionPerformed
        // TODO add your handling code here:
        if (xml.getNoFactura()!=null) {
            String Utilidad = JOptionPane.showInputDialog("Utilida aplicar ala factura "+xml.getNoFactura());
        }else{
//             
             JOptionPane.showMessageDialog(rootPane, "Porfavor, seleccione una factura antes de cambiar la utilida", "Aviso", JOptionPane.INFORMATION_MESSAGE  );
        }        
        
        
        
    }//GEN-LAST:event_util_vActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem5ActionPerformed

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
    private javax.swing.JButton Aceptar1;
    private javax.swing.JLabel Arti_D;
    private javax.swing.JLabel Arti_v;
    private javax.swing.JButton ConSicar;
    private javax.swing.JLabel Fondo;
    private javax.swing.JTable Tabla;
    private javax.swing.JFrame jFrame1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel rfcFactura;
    private javax.swing.JTextField rutaTexto;
    private javax.swing.JLabel userLabel;
    private javax.swing.JMenuItem util_v;
    // End of variables declaration//GEN-END:variables

    public int getEstadoLogin() {
        return estadoLogin;
    }

    public void setEstadoLogin(int estadoLogin) {
        this.estadoLogin = estadoLogin;
    }

}

//try {  
//           Conexion.st = Conexion.cn.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
//          
//           String result="select clave, localizacion,existencia,descripcion ,precioCompra from sicar.articulo where clave =upper (\""+ dato.getText()+"\");";
//        
//           Conexion.rs=Conexion.st.executeQuery(result);
//           
//           ResultSetMetaData stMD = Conexion.rs.getMetaData();
//           
//           System.out.println(" ok");
//           
//         try {
//            while(Conexion.rs.next()){
//               Object [] fila = new Object[stMD.getColumnCount()];
//               //Crea un vector
//               //para almacenar los valores del ResultSet
//            
//                for (int j = 0; j < stMD.getColumnCount(); j++) {
//                      
//                  
//                  
//                fila[j] = Conexion.rs.getObject(j+1); // El primer indice en rs es el 1, no el cero, por eso se suma 1. 
//              }//añado el modelo a la tabla
//                System.out.println(Arrays.toString(fila));
//                
//                modelo.addRow(fila);
//               fila=null;//limpia los datos de el vector de la memoria
//            }
//            
//            System.out.println("ok 2");
//            //cerrar result-set
//        } catch (SQLException ex) {
//            
//                JOptionPane.showMessageDialog(null, " Error al consultar datos "+ ex);
//        }
//      } catch (SQLException ex) {
//         JOptionPane.showMessageDialog(null, " Error al consultar datos "+ ex);
//        
//      }
//
