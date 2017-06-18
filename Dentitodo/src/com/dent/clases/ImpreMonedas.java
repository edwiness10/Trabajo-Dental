/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dent.clases;

import java.awt.Graphics;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import static java.awt.print.Printable.NO_SUCH_PAGE;
import static java.awt.print.Printable.PAGE_EXISTS;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Ventas
 */





public class ImpreMonedas {
    int[] cantidad = {0 
} ;
    
    public boolean impreMonedas (int[] cantdad,int foleo, double totalAN, String comentario ){
        boolean estado=true;
        ObjetoDeImpresion.cantidad=cantdad;
        ObjetoDeImpresion.foleo=foleo;
        ObjetoDeImpresion.totalAn=totalAN;
        ObjetoDeImpresion.comentario=comentario;
        PrinterJob job = PrinterJob.getPrinterJob();       
        job.setPrintable(new ObjetoDeImpresion());
        if (job.printDialog()) {
            System.out.println(job.getCopies());
            try {
                job.print();              
                System.out.println("Tamaño");
        
            } catch (PrinterException e) {
                System.out.println(e);
                estado=false;
                
            }
        }else estado=false;
        
        
        
        
        return estado;
        
    }
    
}
class ObjetoDeImpresion implements Printable{
    public static int[] cantidad = {0,0,0,0,0,0,0,0,0,0,0} ;
    String[] valor = {"$1000","$500","$200","$100","$50","$20","$10","$5","$2","$1","$0.5"} ;
    double[] monto = {1000,500,200,100,50,20,10,5,2,1,0.5} ;
    double total=0;
    static double totalAn=0;
    public static String comentario ="";

    
    static int foleo=0;
    String usuario= "0";
    
    
public int print(Graphics g, PageFormat f, int pageIndex){
if(pageIndex == 0){
   g.setClip(0, 90, 400, 697);
   
   
          total=0;
    for (int i = 0; i < cantidad.length; i++) {        
        total=total+(cantidad[i]*monto[i]); 
        System.out.println(total);
    }
   //220
    
        Date date = new Date();
        DateFormat hourdateFormat = new SimpleDateFormat("HH:mm:ss dd/MM/yyyy");
        System.out.println("Hora y fecha: "+hourdateFormat.format(date));
        g.drawString("Conteo de monedas", 30,220);
        g.drawString("No."+foleo, 150,220);
        g.drawString("Fecha :"+hourdateFormat.format(date), 30,235);
        g.drawString("Moneda", 30,260);
        g.drawString(" Cantidad", 80,260);
        g.drawString("    Total", 130,260);
   
       int x = 280;
    for (int i = 0; i < cantidad.length; i++) {
        g.drawString(String.valueOf(valor[i]), 30, x);
        g.drawString(String.valueOf("|      "+cantidad[i]), 80, x);
            g.drawString("|    $" + String.valueOf(monto[i] * cantidad[i]), 130, x);
        x = x + 15;
    }
    x = x + 10;
    g.drawString("Total", 50, x );
    g.drawString("$"+total, 135, x );
    x = x + 30;
    g.drawString("Corte anterior", 50, x );
    g.drawString("$"+totalAn, 130, x );
    x = x + 20;
    g.drawString("Diferencia", 50, x );
    g.drawString("$"+(total-totalAn), 130, x );
    x = x + 20;
    g.drawString("Firma de "+usuario, 30, x );
    x = x + 30;
    g.drawString("------------------------------------------", 30, x );
    g.drawString("Este es una copia del sistema", 30, x + 20);
    g.drawString(comentario, 30, x + 20);
    System.out.println(g.getClip());

    
    System.out.println(PAGE_EXISTS);
return PAGE_EXISTS;
}else{
return NO_SUCH_PAGE;
}
}

}
