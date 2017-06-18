/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dent.Int;
 
import com.dent.dato.Conexion;
import static com.dent.dato.Conexion.actualizarTabla_S_O;
import static com.dent.dato.Conexion.actualizarTabla_S_O_Borar;
import static com.dent.dato.Conexion.actualizarTabla_S_O_TEMPORAL;
import static com.dent.dato.Conexion.conectarOra;
import static com.dent.dato.Conexion.consultaOracle_Temp_des;
import static com.dent.dato.Conexion.consultarTabla;
import com.dent.dato.Validaciones;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author DELL
 */
public class IntCons extends javax.swing.JFrame {

    /**
     * Creates new form IntP
     */
  DefaultTableModel modelo=new DefaultTableModel();
  String  marcaUbi_Tienda="";
  String  marcaUbi_Bodega="";
  int exi_Bodega = 0;
  int exi_Tienda = 0;
  boolean marcaUbi = false; 
  String datos[]={"","","1","","","0","0"};
    public IntCons() {
        initComponents();
        
        String titu[]={"Codigo","Ubicacion","Stock","Nombre","Precio Compra","Bodega","Tienda"};
        modelo.setColumnIdentifiers(titu);
         this.setLocationRelativeTo(null);
        Tabla.setModel(modelo);
        
        

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
         Conexion.cn.close();
         Conexion.rs.close();
      } catch (SQLException ex) {
         JOptionPane.showMessageDialog(null, " Error al consultar datos "+ ex);
        
      }
        
        return descripcion ;
    }
    public Object[] consultaOracle (String codigo ){
      Object[]  descripcion = null  ;
        Conexion.conectarOra();
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
         Conexion.cn.close();
         Conexion.rs.close();
      } catch (SQLException ex) {
         JOptionPane.showMessageDialog(null, " Error al consultar datos "+ ex);
        
      }
        
       
        return descripcion ;
    }
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        espera = new javax.swing.JPanel();
        dato = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        Tabla = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        Ubica = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        Borrar = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        Fondo = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        Buscar = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        OracleDB = new javax.swing.JCheckBoxMenuItem();
        jMenu3 = new javax.swing.JMenu();
        StockS = new javax.swing.JCheckBoxMenuItem();
        UbicacionS = new javax.swing.JCheckBoxMenuItem();
        jMenu4 = new javax.swing.JMenu();
        SicarBD = new javax.swing.JCheckBoxMenuItem();
        jCheckBoxMenuItem1 = new javax.swing.JCheckBoxMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        jMenuItem1 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Dentitodo Inventario");
        setMaximumSize(new java.awt.Dimension(1920, 1080));
        setMinimumSize(new java.awt.Dimension(1400, 900));
        setPreferredSize(new java.awt.Dimension(1400, 900));
        setSize(new java.awt.Dimension(1400, 900));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        espera.setOpaque(false);
        getContentPane().add(espera, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 190, 450, 190));

        dato.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                datoActionPerformed(evt);
            }
        });
        dato.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                datoKeyTyped(evt);
            }
        });
        getContentPane().add(dato, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 100, 290, -1));

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
        ));
        Tabla.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        Tabla.setMaximumSize(new java.awt.Dimension(1500, 64));
        Tabla.setMinimumSize(new java.awt.Dimension(300, 64));
        jScrollPane1.setViewportView(Tabla);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, 1330, 620));

        jButton2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/dent/iconos/Buscar.fw.png"))); // NOI18N
        jButton2.setText("Consultar datos");
        jButton2.setToolTipText("");
        jButton2.setContentAreaFilled(false);
        jButton2.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/com/dent/iconos/Buscar2.fw.png"))); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 70, -1, -1));

        Ubica.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        Ubica.setForeground(new java.awt.Color(255, 255, 255));
        Ubica.setText("Ubicacion");
        getContentPane().add(Ubica, new org.netbeans.lib.awtextra.AbsoluteConstraints(1230, 60, 170, 30));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Codigo");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 50, -1, -1));

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/dent/iconos/Actu.fw.png"))); // NOI18N
        jButton1.setText("Actualizar Datos");
        jButton1.setContentAreaFilled(false);
        jButton1.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/com/dent/iconos/Actu2.fw.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 70, -1, -1));

        Borrar.setBackground(new java.awt.Color(0, 0, 0));
        Borrar.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        Borrar.setForeground(new java.awt.Color(255, 255, 255));
        Borrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/dent/iconos/GarbageBin.png"))); // NOI18N
        Borrar.setText("Borrar ");
        Borrar.setBorderPainted(false);
        Borrar.setContentAreaFilled(false);
        Borrar.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/com/dent/iconos/GarbageBin2.fw.png"))); // NOI18N
        Borrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BorrarActionPerformed(evt);
            }
        });
        getContentPane().add(Borrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 80, 170, 60));

        jButton3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/dent/iconos/save.fw.png"))); // NOI18N
        jButton3.setText("Guardar");
        jButton3.setContentAreaFilled(false);
        jButton3.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/com/dent/iconos/save2.fw.png"))); // NOI18N
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 80, -1, -1));

        jButton4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/dent/iconos/open.fw.png"))); // NOI18N
        jButton4.setText("Abrir");
        jButton4.setContentAreaFilled(false);
        jButton4.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/com/dent/iconos/open2.fw.png"))); // NOI18N
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1100, 80, -1, -1));

        jLabel3.setBackground(new java.awt.Color(195, 67, 66));
        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Gestor de Inventario.");
        jLabel3.setOpaque(true);
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1420, 40));

        Fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/dent/imag/red-simple-wallpapers-1920x1080.jpg"))); // NOI18N
        getContentPane().add(Fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(-20, 0, -1, -1));

        jMenu1.setText("Opciones");
        jMenu1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu1ActionPerformed(evt);
            }
        });

        Buscar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_B, java.awt.event.InputEvent.CTRL_MASK));
        Buscar.setText("Buscar");
        Buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BuscarActionPerformed(evt);
            }
        });
        jMenu1.add(Buscar);

        jMenu2.setText("Base de datos");

        OracleDB.setSelected(true);
        OracleDB.setText("Base Local");
        OracleDB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OracleDBActionPerformed(evt);
            }
        });
        jMenu2.add(OracleDB);

        jMenu1.add(jMenu2);

        jMenu3.setText("Datos");

        StockS.setText("Stock");
        StockS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                StockSActionPerformed(evt);
            }
        });
        jMenu3.add(StockS);

        UbicacionS.setSelected(true);
        UbicacionS.setText("Ubicacion");
        UbicacionS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UbicacionSActionPerformed(evt);
            }
        });
        jMenu3.add(UbicacionS);

        jMenu1.add(jMenu3);

        jMenuBar1.add(jMenu1);

        jMenu4.setText("Sicar");

        SicarBD.setSelected(true);
        SicarBD.setText("Actualizar");
        jMenu4.add(SicarBD);

        jCheckBoxMenuItem1.setText("Restablecer Stock");
        jCheckBoxMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxMenuItem1ActionPerformed(evt);
            }
        });
        jMenu4.add(jCheckBoxMenuItem1);
        jMenu4.add(jSeparator1);

        jMenuItem1.setText("Comprobar Conexión ");
        jMenu4.add(jMenuItem1);

        jMenuBar1.add(jMenu4);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void datoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_datoKeyTyped
      // Validaciones.alfabetico(evt); 
     Object[]  descripcion = null  ;
      
       if(evt.getKeyChar() == '\n'){
           
                
           
             datos[0]=dato.getText(); 
             String ubicacion= " ", texto;
             Pattern pattern = Pattern.compile( "^(M|A|C|B|m|a|b|c)+[0-9]([0-9]*)'[0-9]([0-9]*)$");// atomata tienda
             
             Matcher matcher = pattern.matcher(dato.getText());
             Pattern pattern2 = Pattern.compile( "^(B|b)+[0-9]([0-9]*)'[0-9]([0-9]*)$"); // automata  Bodega
             Matcher matcher2 = pattern2.matcher(marcaUbi_Tienda);
             if (matcher2.find()) {
               marcaUbi=true;
            } else{
                 marcaUbi=false;
             }
             
             
             
              if(matcher.find()){
//                 JOptionPane.showMessageDialog(this, "Campos Vacíos");

                 marcaUbi_Tienda = dato.getText();
                 datos[1]=marcaUbi_Tienda; 
                 Ubica.setText(marcaUbi_Tienda);
                 
              }   else{
//                  if (marcaUbi != "") {
//                     
//                      datos[1]=marcaUbi; 
//                  }
                      Ubica.setText(marcaUbi_Tienda);
                  
                   int pos=0, cantidad=0,ubi=0;
                   boolean marca=false;    
                    System.out.println("op");
                    
                    
                    
                 if (modelo.getRowCount()!=0) {
                       
                  for (int i = 0; i <= modelo.getRowCount()-1; i++) {
                       
//                        System.out.println( );
//                        System.out.println(modelo.getValueAt(i, 0)+" "+ dato.getText() );
                    if (String.valueOf(modelo.getValueAt(i, 0 )).equals(String.valueOf((dato.getText())))) {
                        System.out.println("ok");
                        if(modelo.getValueAt(i,2) != null){
                            
                           //int P =  Integer.parseInt(String.valueOf(modelo.getValueAt(i, 2)))+1;
                          
                            System.out.println(marcaUbi);
                           if (marcaUbi== true) {
                        int U =  Integer.parseInt(String.valueOf(modelo.getValueAt(i, 5)))+1;
                           modelo.setValueAt(U, i, 5);
                           int P= Integer.parseInt(String.valueOf(modelo.getValueAt(i, 5)))+Integer.parseInt(String.valueOf(modelo.getValueAt(i, 6)));
                           System.out.println("fffff "+ modelo.getValueAt(i, 5)+""+modelo.getValueAt(i, 6));
                            
                           modelo.setValueAt(P, i, 2);
                                    
                                }else{
                           int U = 
                           Integer.parseInt(String.valueOf(modelo.getValueAt(i, 6)))+1;
                           modelo.setValueAt(U, i, 6);
                           int P= Integer.parseInt(String.valueOf(modelo.getValueAt(i, 5)))+Integer.parseInt(String.valueOf(modelo.getValueAt(i, 6)));
                           System.out.println("fffff "+ modelo.getValueAt(i, 5)+""+modelo.getValueAt(i, 6));
                            
                           modelo.setValueAt(P, i, 2);
                               
                           }
                           
                           String UbicacionCompa = (String) modelo.getValueAt(i, 1);
                           Pattern pattern5 = Pattern.compile(marcaUbi_Tienda );// atomata ubicacion general
             
                           Matcher matcher5 = pattern5.matcher(UbicacionCompa); 
                           
                            if (matcher5.find()) {
//                                                               JOptionPane.showMessageDialog(null, " Ya se encuentra la ubicacion ");
                            }else{
                                
                                 modelo.setValueAt(modelo.getValueAt(i, 1 ) +" / "+ marcaUbi_Tienda, i, 1);
                            }
                           
                           
                           
                          
                         
                    }
                      
                      
                       marca =true;                                          
                   } 
//                    else{
//                        
//                        
//                        datos[5]=marcaUbi_Tienda;
//                        
//                        
//                        
//                    }
                      
//                       System.out.println(modelo.getValueAt(i, 0 ));
////                     if (String.valueOf(modelo.getValueAt(i, 0 )).equals(String.valueOf((dato.getText())))) {
////                         System.out.println(modelo.getValueAt(i, 0 )+ "i"+ i);
////                         cantidad = cantidad +1;
//////                         System.out.println(cantidad);
////                         
////                     }



                  }
                  
                  if (marca== false){
//                      descripcion= consultaSicar (dato.getText() );
                      System.out.println("entro aqui "+ Arrays.toString(datos) + marcaUbi);
                      if (marcaUbi== true) {
                         datos[5] = "1";
                         datos[6]= "0";
                                 }else{
                         datos[5]= "0";
                         datos[6] = "1";
                     }
                      
                      
                      modelo.addRow(datos);
                  }
                  }else{
                     if (marcaUbi== true) {
                         datos[5] = "1";
                                 }else{
                         datos[6] = "1";
                     }
//                        descripcion= consultaSicar (dato.getText() );
                        System.out.println("entro aqui 2 "+ Arrays.toString(datos));
                        modelo.addRow(datos); 
                        
                        
                        
                    }
                  
                  
                       
                   
              }    
                    
                     
              
             
             dato.setText("");
             
        }else{
              
      }
      
       
       
       
    }//GEN-LAST:event_datoKeyTyped

    
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
      
        String texto="";
        
      try {
            
            
        
        if (modelo.getRowCount()!=0){
            
            
         
           Object[]  descripcion = null  ;
           Conexion.conectarSicar();
           String CodigoBD="";
           for (int i = 0; i < modelo.getRowCount(); i++) {
               
               CodigoBD=(String) modelo.getValueAt(i, 0 );
               texto=modelo.getValueAt(i, 3 ).toString();
               System.out.println(texto);
               
               if (CodigoBD!=""|| CodigoBD!=null ) {
                   
                   descripcion = consultaSicar (CodigoBD );
               
               System.out.println("si" + Arrays.toString(descripcion));
               
               
              
               
               if (descripcion== null) {
                    Object[]  descripcion2 = {"", ""}  ;
                   descripcion= descripcion2;
               }
            
               
               modelo.setValueAt(descripcion[0], i, 3);
               
               
               modelo.setValueAt(descripcion[1], i, 4);
                   
               }
               
               
               
               
               
           }     
       }else{
           JOptionPane.showMessageDialog(null, " No hay datos Para obtener datos");
       }
             
      
      }catch (Exception e) {
          JOptionPane.showMessageDialog(null, " Erro al guardar \n " + e);}
//        
//        
//        
//}
        
        
        
        
        
        
        
        
        
        
        
        
        
        
//    SELECT precioCompra FROM sicar.articulo where clave=0112;
    
      
    
    }//GEN-LAST:event_jButton2ActionPerformed

    
    
    
    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
      
         dato.requestFocus();
    }//GEN-LAST:event_formWindowOpened

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing

        
        
    }//GEN-LAST:event_formWindowClosing

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        int opcionDatos=0;
        int auxD=3;
        if (StockS.getState() && UbicacionS.getState()){
           auxD=0; 
        }else{
            if (StockS.getState()){
            auxD=1;
        }
        if (UbicacionS.getState()){
            auxD=2;
        }
        }
        
        opcionDatos=auxD;
//actualizarTabla_S_O(String sku,String nombre,String ubicacion,float Existencia,float Exi_tienda,float Exi_bodega )
int opcion = JOptionPane.showConfirmDialog(null, "Realmente quiere actualizar las existencias.Esto sobre escribira los datos de Sicar. ", "Aviso", JOptionPane.YES_NO_OPTION);

if (SicarBD.getState()){
    System.out.println("activo activo");

try{
if (opcion == 0) { //The ISSUE is here
    if (modelo.getRowCount()!=0){
           try {
        Object[]  descripcion = null  ;
        Conexion.conectarSicar();
        String Codigo="",Ubicacion="",aux;
               float  Existencia=0,Exi_tienda=0,Exi_bodega=0;
        
        
        for (int i = 0; i < modelo.getRowCount(); i++) {
            
             Codigo=(String) modelo.getValueAt(i, 0 ); 
             Ubicacion=(String) modelo.getValueAt(i, 1 ); 
              
             
             System.out.println(modelo.getValueAt(i, 2 ));
             aux=   modelo.getValueAt(i, 2 ).toString(); 
             Existencia= Integer.parseInt(aux); 
             aux=   modelo.getValueAt(i, 6 ).toString(); 
             Exi_tienda= Integer.parseInt(aux);
             aux=   modelo.getValueAt(i, 5 ).toString(); 
             Exi_bodega=Integer.parseInt(aux);
              
            // Conexion.actualizarTabla_S_O(Codigo,Ubicacion, Existencia, Exi_tienda, Exi_bodega);
            // System.out.println("Se ingreso correctamente en oracle");
             
             Conexion.actualizarTabla_S_I(Codigo,Ubicacion, Existencia,opcionDatos);
             
             
             
             
             
             
             System.out.println("Se ingreso correctamente en sicar");
      }
        
        Conexion.cn.close();
        
      } catch (SQLException ex) {
          JOptionPane.showMessageDialog(null, " Se genero un error en la conexion de la case de datos \n  " +ex);
      } 
           JOptionPane.showMessageDialog(null, " Actualizacion Exitosa  en SICAR!! :)  ");
       }else{
           JOptionPane.showMessageDialog(null, " No hay datos que Actualizar \n   Porfavor Ingrese  ");
       }
} else {
   System.out.print("no");
}
}catch (Exception e) {
          JOptionPane.showMessageDialog(null, " Se produjo un error en la actualizacion de datos.  \n  " +e);
      } 
}
     //-----------------------------------------------------------------------------------------------------------------------------------------------------

     
     

if (OracleDB.getState()){
    System.out.println("activo activo");

     try{
     

if (opcion == 0) { //The ISSUE is here
    
    
    Conexion.conectarOra();
    if (modelo.getRowCount()!=0){
        Object[]  descripcion = null  ;
        String CODIGO="",UBICACION="",NOMBRE="",aux;
        float  STOCK=0,TIENDA=0,BODEGA=0,PRECIO_COMPRA = 0,GUIA = 0;
        for (int i = 0; i < modelo.getRowCount(); i++) {
            
            CODIGO=(String) modelo.getValueAt(i, 0 );
            UBICACION=(String) modelo.getValueAt(i, 1 );
            NOMBRE=(String) modelo.getValueAt(i, 3 );
            System.out.println(modelo.getValueAt(i, 2 ));
            aux=   modelo.getValueAt(i, 2 ).toString();
            STOCK= Integer.parseInt(aux);
            aux=   modelo.getValueAt(i, 4 ).toString();
            if (aux== "") {
                aux ="0.0";
            }
            System.out.println(aux +" eror");
            PRECIO_COMPRA= Float.parseFloat(aux);
            aux=   modelo.getValueAt(i, 5 ).toString();
            BODEGA=Integer.parseInt(aux);
            aux=   modelo.getValueAt(i, 6 ).toString();
            TIENDA= Integer.parseInt(aux);
            
            
            
            
            actualizarTabla_S_O(CODIGO,UBICACION,NOMBRE,PRECIO_COMPRA, STOCK, TIENDA, BODEGA,i );
            
            System.out.println("Se ingreso correctamente en oracle");
            
        }
        JOptionPane.showMessageDialog(null, "Se guardo de forma correcta en la base de datos local !! :)  ");
       }else{
           JOptionPane.showMessageDialog(null, " No hay datos que Actualizar \n   Porfavor Ingrese  ");
       }
} else {
   System.out.print("no");
}
}
catch(Exception e){
    JOptionPane.showMessageDialog(null, " Se genero un error al guardar los datos   en oracle "+e);
} 
} 

     
       
    }//GEN-LAST:event_jButton1ActionPerformed
 
    private void BorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BorrarActionPerformed
        // TODO add your handling code here:
     //  int opcion = JOptionPane.showConfirmDialog(null, "Realmente quiere  ", "Aviso", JOptionPane.YES_NO_OPTION);
if (SicarBD.getState()){
    System.out.println("activo activo");
}else {
    System.out.println("desactivio sicar");
}

//if (opcion == 0) { 
        int ubica_borrar = Tabla.getSelectedRow();
        if (ubica_borrar >= 0) {
        
        modelo.removeRow(ubica_borrar);
        
               }
//}
        
        
    }//GEN-LAST:event_BorrarActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
try{
      int opcion = JOptionPane.showConfirmDialog(null, "Se guardara toda la informacion actual de la tabla, por lo que se borrara la existente, Desea continuar ? ", "Aviso", JOptionPane.YES_NO_OPTION);

if (opcion == 0) { //The ISSUE is here
    
    actualizarTabla_S_O_Borar( "TEMPORAL" );
    Conexion.conectarOra();
    if (modelo.getRowCount()!=0){
        Object[]  descripcion = null  ;
        String CODIGO="",UBICACION="",NOMBRE="",aux;
        float  STOCK=0,TIENDA=0,BODEGA=0,PRECIO_COMPRA = 0,GUIA = 0;
        for (int i = 0; i < modelo.getRowCount(); i++) {
            
            CODIGO=(String) modelo.getValueAt(i, 0 );
            UBICACION=(String) modelo.getValueAt(i, 1 );
            NOMBRE=(String) modelo.getValueAt(i, 3 );
            System.out.println(modelo.getValueAt(i, 2 ));
            aux=   modelo.getValueAt(i, 2 ).toString();
            STOCK= Integer.parseInt(aux);
            aux=   modelo.getValueAt(i, 4 ).toString();
            if (aux== "") {
                aux ="0.0";
            }
            System.out.println(aux +" eror");
            PRECIO_COMPRA= Float.parseFloat(aux);
            aux=   modelo.getValueAt(i, 5 ).toString();
            BODEGA=Integer.parseInt(aux);
            aux=   modelo.getValueAt(i, 6 ).toString();
            TIENDA= Integer.parseInt(aux);
            
            
            
            
            actualizarTabla_S_O_TEMPORAL(CODIGO,UBICACION,NOMBRE,PRECIO_COMPRA, STOCK, TIENDA, BODEGA,i );
            
            System.out.println("Se ingreso correctamente en oracle");
            
        }
        JOptionPane.showMessageDialog(null, "Se guardo de forma correcta tus datos !! :)  ");
       }else{
           JOptionPane.showMessageDialog(null, " No hay datos que Actualizar \n   Porfavor Ingrese  ");
       }
} else {
   System.out.print("no");
}
}
catch(Exception e){
    JOptionPane.showMessageDialog(null, " Se genero un error al guardar los datos  "+e);
}  


    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
//        for (int i = modelo.getRowCount(); i < 0; i--) {
//            modelo.removeRow(ubica_borrar);
//            
//        }


try {
     Object[][]  datos = consultaOracle_Temp_des( ) ;
         System.out.println(Arrays.toString(datos[0]));
         System.out.println(Arrays.toString(datos[1]));
        Object[]  Tamaño = null  ;
         int aux=0,con=0;
         String aux2="";
        String datosV[]={"","","0","","","0","0"};
        Tamaño=Conexion.consultaOracle_Temp();
        
        
        System.out.println(Tamaño);
        aux=Integer.parseInt(Tamaño[0].toString());
        System.out.println(aux);
        
        
            
        
      if (modelo.getRowCount()!=0){
        System.out.println("ok");
                
        
        
        }else{
          
                  
          for (int i = 0; i < aux; i++) {
              
              for (int j = 0; j <7 ; j++) {
                  System.out.println(i+" "+j);
                  
                  
//                  if (j==2 || j==4 ||j==5 ||j==6  ) {
//                       con=Integer.parseInt(datos[i][j].toString());                
//                  
//                       datosV[j] =Integer.toString(con);
//                      
//                      
//                  }else{
//                  
//                  }
                 System.out.println(datos[i][j].toString());
                 aux2=datos[i][j].toString();
                 datosV[j] = aux2;
                 
                  System.out.println(aux2);
                  
              }
               modelo.addRow(datosV);  
               System.out.println(i);
            }
            
            
            
        }
        
        marcaUbi=true;
}catch(Exception e){
    JOptionPane.showMessageDialog(null, " Se genero  un error al abrir los datos "+e);
}


       
        
        
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jMenu1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu1ActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_jMenu1ActionPerformed

    private void BuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BuscarActionPerformed
        // TODO add your handling code here:
        
        boolean estado=true;
        String buscar  = JOptionPane.showInputDialog("Porfavor inserte codigo a buscar");
        String  aux="";
        System.out.println("Buscar ");
    
        if (buscar !=null) {
            System.out.println("ok");
            
            
            for (int i = 0; i < modelo.getRowCount(); i++) {
                aux = modelo.getValueAt(i, 0).toString();
                System.out.println(" buscando en -"+aux+ "- y es  -" + buscar+ "-");
                
                if (null == buscar ? aux == null : buscar.equals(aux)) {
                    
                    System.out.println("Es correcto");
                    
                    Tabla.changeSelection(i, 1, false, false);
                    estado=false;
               
                }else {
                   //  JOptionPane.showMessageDialog(jMenu1, i);
                }
                
                
                
                
            }
            if (estado==true) {
                 JOptionPane.showMessageDialog(null,"No se encontro dato "  + buscar );
            }
 
            
            
            
            
            
        }
    }//GEN-LAST:event_BuscarActionPerformed

    private void datoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_datoActionPerformed
        // TODO add your handling code here:
        
        
        
        
    }//GEN-LAST:event_datoActionPerformed

    private void OracleDBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OracleDBActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_OracleDBActionPerformed

    private void jCheckBoxMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxMenuItem1ActionPerformed
        // TODO add your handling code here:
        
        
        
        
        
    }//GEN-LAST:event_jCheckBoxMenuItem1ActionPerformed

    private void UbicacionSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UbicacionSActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_UbicacionSActionPerformed

    private void StockSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_StockSActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_StockSActionPerformed

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
//            java.util.logging.Logger.getLogger(IntCons.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(IntCons.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(IntCons.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(IntCons.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new IntCons().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Borrar;
    private javax.swing.JMenuItem Buscar;
    private javax.swing.JLabel Fondo;
    private javax.swing.JCheckBoxMenuItem OracleDB;
    private javax.swing.JCheckBoxMenuItem SicarBD;
    private javax.swing.JCheckBoxMenuItem StockS;
    private javax.swing.JTable Tabla;
    private javax.swing.JLabel Ubica;
    private javax.swing.JCheckBoxMenuItem UbicacionS;
    private javax.swing.JTextField dato;
    private javax.swing.JPanel espera;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    // End of variables declaration//GEN-END:variables
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