/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dent.clases;

import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Ventas
 */
public class ProcesaTabla {
    
    public DefaultTableModel consulta_Tablas ( String consulta){
        DefaultTableModel modelo = new DefaultTableModel();
        
        ResumenMySQL sql = new ResumenMySQL();
        String[][] datos1 = sql.ConsultaGeneral(consulta);
        
        
        String[] titulo = new String[datos1[0].length];
        
        for (int i = 0; i < datos1[0].length; i++) {
            titulo[i] = datos1[0][i];
        }
        
        modelo.setColumnIdentifiers(titulo);

        for (int i = 1; i < datos1.length; i++) {
            modelo.addRow(datos1[i]);
        }

        return modelo;
    }
    
    
}
