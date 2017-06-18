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
import static com.dent.dato.Conexion.consultaOracle_des;
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
public class IntGest extends javax.swing.JFrame {

    /**
     * Creates new form IntP
     */
  DefaultTableModel modelo=new DefaultTableModel();
  private String  marcaUbi_Tienda="";
  private String  marcaUbi_Bodega="";
  int exi_Bodega = 0;
  int exi_Tienda = 0;
  private static boolean marcaUbi,sobreExi= false  ; 
  private static boolean marcaTipo ; 
  int opcion;
  
  static  Object[][]  Datos ;
   

   

  
  String datos[]={"","","1","",""};
   
  
  
    public IntGest() {
        initComponents();
        String titu[]={"Codigo","Ubicacion","Stock","Bodega","Tienda"};
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
         
      } catch (SQLException ex) {
         JOptionPane.showMessageDialog(null, " Error al consultar datos "+ ex);
        
      }
      try {
          Conexion.cn.close();
         
      } catch (SQLException ex) {
          Logger.getLogger(IntGest.class.getName()).log(Level.SEVERE, null, ex);
      }
         
        
        return descripcion ;
    }
    public Object[] consultaOracle_I (String codigo ){
      Object[]  descripcion = null  ;
        Conexion.conectarOra();
        try {  
           Conexion.st = Conexion.cn.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
          
           String result=" select clave,NOMBRE,EX_BODEGA,EX_TIENDA,EXISTENCIAS from administrador.ORA_INVENTARIO where ID_PRODUCTO_PK= '"+codigo+"'";
        
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
          Logger.getLogger(IntGest.class.getName()).log(Level.SEVERE, null, ex);
      }
        
       
        return descripcion ;
    }
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dato = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        Tabla = new javax.swing.JTable();
        Aceptar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        Ubica = new javax.swing.JLabel();
        Fondo = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Dentitodo Inventario");
        setMaximumSize(new java.awt.Dimension(1920, 1080));
        setMinimumSize(new java.awt.Dimension(900, 800));
        setPreferredSize(new java.awt.Dimension(900, 800));
        setResizable(false);
        setSize(new java.awt.Dimension(900, 800));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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
        getContentPane().add(dato, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 100, 290, -1));

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
        Tabla.setMaximumSize(new java.awt.Dimension(600, 64));
        Tabla.setMinimumSize(new java.awt.Dimension(300, 64));
        jScrollPane1.setViewportView(Tabla);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 150, 820, 570));

        Aceptar.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        Aceptar.setForeground(new java.awt.Color(255, 255, 255));
        Aceptar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/dent/iconos/Test.fw.png"))); // NOI18N
        Aceptar.setText("Aceptar");
        Aceptar.setToolTipText("");
        Aceptar.setContentAreaFilled(false);
        Aceptar.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/com/dent/iconos/Test2.fw.png"))); // NOI18N
        Aceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AceptarActionPerformed(evt);
            }
        });
        getContentPane().add(Aceptar, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 70, -1, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Codigo");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 50, -1, -1));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Cargando");
        jLabel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(255, 255, 255))); // NOI18N
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 80, 290, 40));

        jLabel3.setBackground(new java.awt.Color(0, 0, 204));
        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Modificacion de Inventario.");
        jLabel3.setOpaque(true);
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 880, 40));

        Ubica.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        Ubica.setForeground(new java.awt.Color(255, 255, 255));
        Ubica.setText("Ubicacion");
        getContentPane().add(Ubica, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 50, 170, 30));

        Fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/dent/imag/red-simple-wallpapers-1920x1080.jpg"))); // NOI18N
        getContentPane().add(Fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(-1000, 0, 1890, -1));

        jMenuBar1.add(jMenu1);
        jMenuBar1.add(jMenu2);

        jMenu3.setText("Opciones");

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Z, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem1.setText("Borrar");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem1);

        jMenuBar1.add(jMenu3);

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
//                  }                      Ubica.setText(marcaUbi_Tienda);
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
                        int U =  Integer.parseInt(String.valueOf(modelo.getValueAt(i, 3)))+1;
                           modelo.setValueAt(U, i, 3);
                           int P= Integer.parseInt(String.valueOf(modelo.getValueAt(i, 3)))+Integer.parseInt(String.valueOf(modelo.getValueAt(i, 4)));
                           System.out.println("fffff "+ modelo.getValueAt(i,3)+""+modelo.getValueAt(i, 4));
                            
                           modelo.setValueAt(P, i, 2);
                                    
                                }else{
                           int U = 
                           Integer.parseInt(String.valueOf(modelo.getValueAt(i, 4)))+1;
                           modelo.setValueAt(U, i, 4);
                           int P= Integer.parseInt(String.valueOf(modelo.getValueAt(i, 3)))+Integer.parseInt(String.valueOf(modelo.getValueAt(i, 4)));
                           System.out.println("fffff "+ modelo.getValueAt(i, 3)+""+modelo.getValueAt(i, 4));
                            
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
                         datos[3] = "1";
                         datos[4]= "0";
                                 }else{
                         datos[3]= "0";
                         datos[4] = "1";
                     }
                      
                      
                      modelo.addRow(datos);
                  }
                  }else{
                     if (marcaUbi== true) {
                         datos[3] = "1";
                         datos[4] = "0";
                                 }else{
                         datos[4] = "1";
                         datos[3] = "0";
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

    
    private void AceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AceptarActionPerformed
       
     String mensaje="";   
     
        
//     String   
         Object[]  Tamaño = null  ;
         Tamaño=Conexion.consultaOracle ();
        int ancho=Integer.parseInt(Tamaño[0].toString());
    try{
        
    Conexion.conectarOra();
    if (modelo.getRowCount()!=0){
        Object[]  descripcion = null  ;
        String CODIGO="",UBICACION="",NOMBRE="",aux;
        float  STOCK=0,TIENDA=0,BODEGA=0,PRECIO_COMPRA = 0,GUIA = 0;
        float auxSTOCK=0,auxTIENDA=0,auxBODEGA=0;
        for (int i = 0; i < modelo.getRowCount(); i++) {
            
            CODIGO=(String) modelo.getValueAt(i, 0 );
            UBICACION=(String) modelo.getValueAt(i, 1 );
         
         
            aux=   modelo.getValueAt(i, 2 ).toString();
            STOCK= Integer.parseInt(aux);
            
            aux=   modelo.getValueAt(i, 3 ).toString();
            BODEGA=Integer.parseInt(aux);
            aux=   modelo.getValueAt(i, 4 ).toString();
            TIENDA= Integer.parseInt(aux);
            System.out.println("tamaño es "+ ancho);
//            
     for (int j = 0; j < ancho; j++) {
           //  System.out.println(Datos[j][0]);
         if (modelo.getValueAt(i, 0 ).toString() == null ? Datos[j][0].toString() == null : modelo.getValueAt(i, 0 ).toString().equals(Datos[j][0].toString())) {
           System.out.println("Si se encontro existencia");
           
             auxSTOCK=Integer.parseInt(Datos[j][2].toString());
             auxTIENDA=Integer.parseInt(Datos[j][4].toString());
             auxBODEGA=Integer.parseInt(Datos[j][3].toString());
           
             System.out.println(Arrays.toString(Datos[j]));
           
         }
////         if (modelo.getValueAt(i, 0 ).toString() == Datos[j][0].toString()) {
//////             System.out.println("Si se encontro existencia"); 
//////              auxSTOCK=Integer.parseInt(Datos[j][2].toString());
//////              auxTIENDA=Integer.parseInt(Datos[j][3].toString());
////////              auxBODEGA=Integer.parseInt(Datos[j][4].toString());
////             
////         }
         
         
//                
           }
     
     
     
     
     switch (opcion){
        
         case 1:
            
            BODEGA = BODEGA + auxBODEGA;
            TIENDA = auxTIENDA + TIENDA;
            STOCK = BODEGA + TIENDA;
             System.out.println("0000000000000000000000      1");
             
         break;
         case 2:
             
             if(auxBODEGA<=0){
                  
                  TIENDA = auxTIENDA - TIENDA ;
                  BODEGA =  auxBODEGA;
                  STOCK = BODEGA + TIENDA;
                  
                  
                  
             }else{
                 System.out.println(" exitencias "+auxBODEGA +" "+BODEGA );
                               
                 if (auxBODEGA<BODEGA) {
                     
                     
                 System.out.println("no existe existencoas");   
                 sobreExi=true;
                
                     
                 }else{
                     
                 TIENDA = auxTIENDA - TIENDA + BODEGA;
                  BODEGA =  auxBODEGA-BODEGA;
                  STOCK = BODEGA + TIENDA;
                 }
             }
             
             
              
               System.out.println("0000000000000000000000      2");
         break;
        
         
         
     }
//            
//           
            System.out.println( CODIGO+UBICACION+NOMBRE+PRECIO_COMPRA+ STOCK+ TIENDA+ BODEGA);
            System.out.println("aux " +auxBODEGA  );
           mensaje = mensaje + "Codigo: "+CODIGO +" Existencias: " +STOCK +" Bodega: "+BODEGA +" Tienda: "+  TIENDA+"\n";
            
            if (sobreExi==false) {
                actualizarTabla_S_O(CODIGO,UBICACION,NOMBRE,PRECIO_COMPRA, STOCK, TIENDA, BODEGA,i ); 
            }else{
                 JOptionPane.showMessageDialog(null, "No hay suficientes existencias en bodega  ");
                 
            }
            
            
            
            System.out.println("Operacion exitosa");
            
        }
        JOptionPane.showMessageDialog(null, "Operacion exitosa  \n"+ mensaje);
        
         new IntPri().setFocusable(true);
         this.dispose();
         
         
         
      
       }else{
           JOptionPane.showMessageDialog(null, " No hay datos que Actualizar \n   Porfavor Ingrese  ");
       }

   System.out.print("no");

}
catch(Exception e){
    JOptionPane.showMessageDialog(null, " Se genero un error al guardar los datos   en oracle "+e);
}  

//        
////                  try {
//     Object[][]  datos = consultaOracle_Temp_des( ) ;
//         System.out.println(Arrays.toString(datos[0]));
//         System.out.println(Arrays.toString(datos[1]));
//        Object[]  Tamaño = null  ;
//         int aux=0,con=0;
//         String aux2="";
//        String datosV[]={"","","0","","","0","0"};
//        Tamaño=Conexion.consultaOracle_Temp();
//        
//        
//        System.out.println(Tamaño);
//        aux=Integer.parseInt(Tamaño[0].toString());
//        System.out.println(aux);
//        
//        
//            
//        
//      if (modelo.getRowCount()!=0){
//        System.out.println("ok");
//                
//        
//        
//        }else{
//          
//                  
//          for (int i = 0; i < aux; i++) {
//              
//              for (int j = 0; j <7 ; j++) {
//                  System.out.println(i+" "+j);
                  
//                  if (j==2 || j==4 ||j==5 ||j==6  ) {
//                       con=Integer.parseInt(datos[i][j].toString());                
//                  
//                       datosV[j] =Integer.toString(con);
//                      
//                      
//                  }else{
////                  
////                  }
//                 System.out.println(datos[i][j].toString());
//                 aux2=datos[i][j].toString();
//                 datosV[j] = aux2;
//                 
//                  System.out.println(aux2);
//                  
//              }
//               modelo.addRow(datosV);  
//               System.out.println(i);
//            }
//            
//            
//            
//        }
//        
//        marcaUbi=true;
//}catch(Exception e){
//    JOptionPane.showMessageDialog(null, " Se genero  un error al abrir los datos "+e);
//}

        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
//        if (modelo.getRowCount()!=0){
//           Object[]  descripcion = null  ;
//           
//           String CodigoBD="";
//           
//           float ex_tienda, ex_bodega;
//            
//           
//           
//           for (int i = 0; i < modelo.getRowCount(); i++) {
//               
//               CodigoBD=(String) modelo.getValueAt(i, 0 );
//               
//               descripcion = consultaOracle_I(CodigoBD);
//               
//               System.out.println(Arrays.toString(descripcion));
//               
//               modelo.setValueAt(descripcion[0], i, 3);
//               
//               modelo.setValueAt(descripcion[1], i, 4);  
//           }     
//       }else{
//           JOptionPane.showMessageDialog(null, " No hay datos Para obtener datos");
//       }
             
      
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
//    SELECT precioCompra FROM sicar.articulo where clave=0112;
    
      
    
    }//GEN-LAST:event_AceptarActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
        
        //getDatos();
       Datos = consultaOracle_des( ) ;
       
       
        System.out.println("Total de datos cargados "+ Datos );
         
        
        
        
        System.out.println(marcaTipo+" "+marcaUbi);
        
            if (marcaTipo) //alta
        {jLabel1.setText("Alta de productos"); 
        opcion=1;
        }
            else           //baja
        {jLabel1.setText("Baja de productos *");
        opcion=2;
        }
            
                
        
       
      
         dato.requestFocus();
    }//GEN-LAST:event_formWindowOpened

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing

        
        
    }//GEN-LAST:event_formWindowClosing

    private void datoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_datoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_datoActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
        
        int ubica_borrar = Tabla.getSelectedRow();
        if (ubica_borrar >= 0) {
        
        modelo.removeRow(ubica_borrar);
        
               }
    }//GEN-LAST:event_jMenuItem1ActionPerformed

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
    private javax.swing.JButton Aceptar;
    private javax.swing.JLabel Fondo;
    private javax.swing.JTable Tabla;
    private javax.swing.JLabel Ubica;
    private javax.swing.JTextField dato;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables

    public String getMarcaUbi_Tienda() {
        return marcaUbi_Tienda;
    }

    public void setMarcaUbi_Tienda(String marcaUbi_Tienda) {
        this.marcaUbi_Tienda = marcaUbi_Tienda;
    }

    public String getMarcaUbi_Bodega() {
        return marcaUbi_Bodega;
    }

    public void setMarcaUbi_Bodega(String marcaUbi_Bodega) {
        this.marcaUbi_Bodega = marcaUbi_Bodega;
    }

    public boolean isMarcaUbi() {
        return marcaUbi;
    }

    public void setMarcaUbi(boolean marcaUbi) {
        this.marcaUbi = marcaUbi;
    }

    public boolean isMarcaTipo() {
        return marcaTipo;
    }

    public void setMarcaTipo(boolean marcaTipo) {
        this.marcaTipo = marcaTipo;
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