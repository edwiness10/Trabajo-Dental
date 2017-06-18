/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dent.clases;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 *
 * @author Ventas
 */
public class ConPreciosOnline {
    
    public List<String[]> villa =new ArrayList();   
    
    
    public void cargaVilla(String Entra) {
        StringTokenizer st = new StringTokenizer(Entra,"\n\t");
              
        String aux2 ;
                while (st.hasMoreTokens()) {
            String[] articulo = {"", "", ""};
            for (int i = 0; i < 3; i++) {
                if (st.hasMoreTokens()) {
                    aux2 = st.nextToken();
                    articulo[i] = aux2;
                    System.out.println(aux2);
                }
            }
            villa.add(articulo);
        }    
   
    }
    
    
    public String despVilla() {
        String[] articulo2 = {"", "", ""};
        String sale = "";
        for (int i = 0; i < villa.size(); i++) {
            articulo2 = villa.get(i);
            
            for (String articulo21 : articulo2) {
                sale = sale + " " + articulo21;
            }
            sale = sale + "\n";
        }
        System.out.println();
        return sale;

    }


}
