/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dent.clases;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Ventas
 */
public class Temporal extends javax.swing.JFrame {

    /**
     * Creates new form Temporal
     */
    public Temporal() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        salida = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        entrada = new javax.swing.JTextArea();
        jButton2 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        salida1 = new javax.swing.JTextArea();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setText("jButton1");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        salida.setColumns(20);
        salida.setRows(5);
        jScrollPane1.setViewportView(salida);

        jLabel1.setText("Copiar cadena");

        entrada.setColumns(20);
        entrada.setRows(5);
        jScrollPane2.setViewportView(entrada);

        jButton2.setText("jButton2");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        salida1.setColumns(20);
        salida1.setRows(5);
        jScrollPane3.setViewportView(salida1);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane4.setViewportView(jTable1);

        jButton3.setText("jButton1");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 622, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(62, 62, 62)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(368, 368, 368))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 641, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(382, 382, 382))))
            .addGroup(layout.createSequentialGroup()
                .addGap(98, 98, 98)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 1773, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(93, 93, 93)
                        .addComponent(jLabel1)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(66, 66, 66)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(210, 210, 210)
                        .addComponent(jButton2)
                        .addContainerGap(76, Short.MAX_VALUE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        //        BoardListener aux =new BoardListener();
        //        String aux2 = aux.getClipboard();
        //
        //        salida.setText(aux2);
        //        String[] archivo = {"aesftwar ","ewtewt"};

        ArrayList<Articulo> al = new ArrayList();

        Articulo artiNue = new Articulo("como1", "este es el 1", 3, 1);
        Articulo artiNue2 = new Articulo("como3", "este es el 2", 3, 1);
        Articulo artiNue3 = new Articulo("como5", "este es el 3", 3, 1);
        Articulo artiNue4 = new Articulo("como5", "este es el 4", 3, 1);

        al.add(artiNue);
        al.add(artiNue2);
        al.add(artiNue3);
        al.add(artiNue4);

        System.out.println("Index of 'AB': " + al.indexOf(artiNue.getArticulo()));
        System.out.println("Index of 'KL': " + al.indexOf("KL"));
        System.out.println("Index of 'AA': " + al.indexOf("AA"));
        System.out.println("Index of 'EF': " + al.indexOf("EF"));

//        
//        String aux1="";
//        
//        char[] cPalabra = Entra.toCharArray();
//        for (int i = 0; i < cPalabra.length; i++) {
//            if (i == cPalabra.length - 1 && cPalabra[i] == '\n') {
//            } else {
//                if (cPalabra[i] == '\n') {
//                    aux1 = aux1 + ";" + cPalabra[i];
//                } else {
//                    aux1 = aux1 + cPalabra[i];
//                }
//            }
//
//        }
//        System.out.println(aux1);
//        Entra= aux1;        
//        StringTokenizer st = new StringTokenizer(Entra,"\t,\n");
//        String aux2="";
//        String sale="";
//        while(st.hasMoreTokens()){
//            aux2=st.nextToken();          
//            System.out.println(aux2);    
//            sale=sale+aux2+";";
//        }
        // System.out.println(Final);
//        salida1.setText(Final);
//        
//        char[] cPalabraAux = Entra.toCharArray();
//                        String aux4 = "";
//                        for (int j = 0; j < cPalabraAux.length; j++) {
//                            
//                            if (j < cPalabraAux.length-1) {
//                                                            
//                            if (cPalabraAux[j] == '"'&& cPalabraAux[j+1] =='"' ) {
//                                  aux4 = aux4 + cPalabraAux[j]+"~";
//                            }else{
//                                aux4 = aux4 + cPalabraAux[j];
//                            }
//                            }else{
//                                aux4 = aux4 + cPalabraAux[j];
//                            }
//                        }
//        
//        Entra=aux4;
//////        String archivo = "C:\\Users\\Edwin\\Documents\\Dentitodo\\Programa\\pagina\\Archivo cvs\\export_product-2017_03_31-00_59_08-25117945.csv";
//////        
//////        
//////        String cadena;
//////        String Final="";
//////        
//////        FileReader f;
//////        try {
//////            f = new FileReader(archivo);
//////            BufferedReader b = new BufferedReader(f);
//////            b.readLine();
//////            b.readLine();
//////            while ((cadena = b.readLine()) != null) {
//////                Final = Final+cadena+"\n";
//////               
//////            }
//////            b.close();
//////        } catch (FileNotFoundException ex) {
//////            Logger.getLogger(Temporal.class.getName()).log(Level.SEVERE, null, ex);
//////        } catch (IOException ex) {
//////            Logger.getLogger(Temporal.class.getName()).log(Level.SEVERE, null, ex);
//////        }
//////   
//////        String Entra=Final;
//////        StringTokenizer st = new StringTokenizer(Entra,"~\n");
//////        List<String[]> villa =new ArrayList();        
//////        String aux2 ;
//////        
//////        String sale = "";
//////        while (st.hasMoreTokens()) {
//////            String[] articulo = {"", "", ""};
//////            for (int i = 0; i < 3; i++) {
//////                if (st.hasMoreTokens()) {
//////                    aux2 = st.nextToken();
//////                    if (i == 2) {
//////                        char[] cPalabra = aux2.toCharArray();
//////                        String aux3 = "";
//////                        for (int j = 0; j < cPalabra.length; j++) {
//////                            if (cPalabra[j] != '$' && cPalabra[j] != ','&&cPalabra[j] != '"') {
//////                                                                aux3 = aux3 + cPalabra[j];
//////                            }
//////                        }
//////                        aux2 = aux3;
//////                    }else{
//////                        char[] cPalabra = aux2.toCharArray();
//////                        String aux3 = "";
//////                        for (int j = 0; j < cPalabra.length; j++) {
//////                            if (cPalabra[j] != '$' && cPalabra[j] != ','&&cPalabra[j] != '"') {
//////                                aux3 = aux3 + cPalabra[j];
//////                            }
//////                        }
//////                        aux2 = aux3;
//////                    }
//////                    articulo[i] = aux2;
//////                }
//////            }
//////            
//////            villa.add(articulo);
//////        }
//////
//////       
//////       
//////        String[] articulo2 ={"","",""}   ;
//////        for (int i = 0; i < villa.size(); i++) {
//////            articulo2=villa.get(i);
//////            
//////            for (int j = 0; j < articulo2.length; j++) {
//////                System.out.println(j+"      "+articulo2[j]);    
//////                sale=sale+" "+articulo2[j];
//////            }
//////           sale=sale+"\n";  
//////            System.out.println("");
//////        }
//////        System.out.println();
////// 
//////        // checking next token
//////        
//////        salida.setText(sale);
//////        System.out.println();

    }//GEN-LAST:event_jButton1ActionPerformed

    public void proVilla(String Aux) {

        String Entra = Aux;
        StringTokenizer st = new StringTokenizer(Entra, "\n\t");
        List<String[]> villa = new ArrayList();
        String aux2;
        String sale = "";
        while (st.hasMoreTokens()) {
            String[] articulo = {"", "", ""};
            for (int i = 0; i < 3; i++) {
                if (st.hasMoreTokens()) {
                    aux2 = st.nextToken();
                    if (i == 2) {
                        char[] cPalabra = aux2.toCharArray();
                        String aux3 = "";
                        for (int j = 0; j < cPalabra.length; j++) {
                            if (cPalabra[j] != '$' && cPalabra[j] != ',' && cPalabra[j] != '"') {
                                aux3 = aux3 + cPalabra[j];
                            }
                        }
                        aux2 = aux3;
                    }
                    articulo[i] = aux2;
                }
            }
            villa.add(articulo);
        }

    }


    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        String aux = "232-----23";
        System.out.println(aux);
        char[] cPalabra = aux.toCharArray();
        String aux3 = "";
        for (int j = 0; j < cPalabra.length; j++) {
            if (cPalabra[j] != '$' && cPalabra[j] != '-' && cPalabra[j] != '"') {
                aux3 = aux3 + cPalabra[j];
            }
        }
        System.out.println(aux3);

        ImpreMonedas mo = new ImpreMonedas();


    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:

//        jTable1.
        ProcesaTabla tabla = new ProcesaTabla();
        DefaultTableModel modelo = tabla.consulta_Tablas("select * from dentitodo.facturas") ;   
        jTable1.setModel(modelo);

        
        
        
    }//GEN-LAST:event_jButton3ActionPerformed

    
    
    
    
    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(Temporal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Temporal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Temporal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Temporal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Temporal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea entrada;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextArea salida;
    private javax.swing.JTextArea salida1;
    // End of variables declaration//GEN-END:variables
}