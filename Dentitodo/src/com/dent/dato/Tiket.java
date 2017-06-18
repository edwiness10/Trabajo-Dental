/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dent.dato;

import java.awt.Desktop;
import java.awt.print.PageFormat;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.print.Doc;
import javax.print.DocFlavor;
import javax.print.DocPrintJob;
import javax.print.PrintException;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.print.SimpleDoc;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;
import javax.print.attribute.standard.Copies;
import javax.print.attribute.standard.MediaSize;


/**
 *
 * @author Ventas
 */
public class Tiket {
    
    public static void imprimirCocina(String textoAImprimir) throws IOException {
        agregarLogoATicket(textoAImprimir);
        
        PrintService[] services = PrintServiceLookup.lookupPrintServices(null, null); //nos da el array de los servicios de impresion

        byte[] bytes = textoAImprimir.getBytes();

        //Especificamos el tipo de dato a imprimir
        //Tipo: bytes; Subtipo: autodetectado
        DocFlavor flavor = DocFlavor.BYTE_ARRAY.AUTOSENSE;
        Doc doc = new SimpleDoc(bytes, flavor, null);
        //Creamos un trabajo de impresión
        DocPrintJob job = null;
        boolean impresora=false;
        if (services.length > 0) {
            for (int i = 0; i < services.length; i++) {                
                if (services[i].getName().equals("\\\\OPTIPLEX\\EPSON TM-T20 Receipt5")) {//aqui escribimos/elegimos la impresora por la que queremos imprimir                  
                    
                    job = services[i].createPrintJob();// 
                    
                    System.out.println(i+": "+services[i].getName());
                    impresora=true;

                } else {
                  
                }
            }
            
            PrinterJob pj = PrinterJob.getPrinterJob();   
            System.out.println("hola"+pj.printDialog());
            System.out.println(pj.getPrintService());
            
            try {
                if (job != null) {

                    job.print(doc, null);
                 
                    System.out.println("im");
                }
            } catch (PrintException ex) {
                System.out.println(ex);
            }

            
            
//            
//            PrinterJob pj = PrinterJob.getPrinterJob();        
//            PageFormat mPageFormat = pj.defaultPage();
            
            //pj.setPrintable(cp, mPageFormat);
            
//            if (pj.printDialog()) {
//                System.out.println(pj.getPrintService());
//                try {
//                    PrintService service = pj.getPrintService();//PrintServiceLookup.lookupDefaultPrintService();
//                    System.out.println("se imprimio ");
//                     pj.print();
//                    
//                     DocPrintJob pjb;
//                     job = service.createPrintJob();
//                     System.out.println(service.createPrintJob().getAttributes().size());
//                     System.out.println(doc.getReaderForText());
//                } catch (PrinterException ex) {
//                    Logger.getLogger(Tiket.class.getName()).log(Level.SEVERE, null, ex);
//                }
//            }

        }

//Imprimimos dentro de un try obligatoriamente
        
    }
//
//    public static void main(String[] args) throws IOException {
////        Tiket.imprimirCocina("hola \n ");
////        imprimirGenerico("hola \n");
//        PrinterJob job = PrinterJob.getPrinterJob();       
//        job.setPrintable(new ObjetoDeImpresion());
//        if (job.printDialog()) {
//            System.out.println(job.getCopies());
//            try {
//                job.print();              
//                System.out.println("Tamaño");
//        
//            } catch (PrinterException e) {
//                System.out.println(e);
//            }
//        }
//
//    }


    public static void imprimirCaja(String textoAImprimir) {
        agregarLogoATicket(textoAImprimir);
        PrintService[] services = PrintServiceLookup.lookupPrintServices(null, null); //nos da el array de los servicios de impresion

        byte[] bytes = textoAImprimir.getBytes();

//Especificamos el tipo de dato a imprimir
//Tipo: bytes; Subtipo: autodetectado
        DocFlavor flavor = DocFlavor.BYTE_ARRAY.AUTOSENSE;

        Doc doc = new SimpleDoc(bytes, flavor, null);
//Creamos un trabajo de impresión
        DocPrintJob job = null;
        if (services.length > 0) {
//            for (int i = 0; i < services.length; i++) {
//                if (services[i].getName().equals("caja")) {//aqui escribimos/elegimos la impresora por la que queremos imprimir
//                    job = services[i].createPrintJob();// System.out.println(i+": "+services[i].getName());
//                }
//            }
            for (PrintService service : services) {
                if (service.getName().equals("caja")) {
                    //aqui escribimos/elegimos la impresora por la que queremos imprimir
                    job = service.createPrintJob(); // System.out.println(i+": "+services[i].getName());
                }
            }
        }

//Imprimimos dentro de un try obligatoriamente
        try {
            job.print(doc, null);
        } catch (PrintException ex) {
            System.out.println(ex);
        }

    }

    public static void imprimirGenerico(String contentTicket) {
        PrintService[] services = PrintServiceLookup.lookupPrintServices(null, null); //nos da el array de los servicios de impresion
        byte[] bytes = contentTicket.getBytes();
        DocFlavor flavor = DocFlavor.BYTE_ARRAY.AUTOSENSE;
            Doc doc = new SimpleDoc(bytes, flavor, null); //Creamos un trabajo de impresión
        PrintRequestAttributeSet pras = new HashPrintRequestAttributeSet();
        pras.add(new Copies(1));
        DocPrintJob job = null;
        if (services.length > 0) {
            for (int i = 0; i < services.length; i++) {
                if (services[i].getName().equals("\\\\OPTIPLEX\\EPSON TM-T20 Receipt5")) {
                    job = services[i].createPrintJob();
                    System.out.println(i + ": " + services[i].getName());
                }
            }
        }
        System.out.println(job.getAttributes());

        try {            
            job.print(doc,pras);
    } catch (PrintException ex) {
            System.out.println(ex);
        }
    }


    private static String agregarLogoATicket(String textoAImprimir) {
        //TODO hacer pruebas de impresión de logo
        //TODO tal vez también se necesite imprimir una parte común al final
        return textoAImprimir;
    }
}

    
    
        


