/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dent.clases;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Date;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Edwin
 */
public class ManipulaArchivos extends javax.swing.JFrame {
    
    String cadena; 

    public void copioArchivo(String facturaRuta, String noFactura) throws IOException {

        Path o = Paths.get(facturaRuta);
        String carpeta = "fsr\\";

        StringTokenizer tokens = new StringTokenizer(facturaRuta, "\\");
        String Aux = "";
        while (tokens.hasMoreTokens()) {

            Aux = tokens.nextToken();
            //  System.out.println(Aux);
        }
        System.out.println("");
        System.out.println("Nombre :" + Aux);
        carpeta = carpeta + fecha() + "\\" + noFactura.toUpperCase();
        File crea_carpeta = new File(carpeta);
        carpeta = carpeta + "\\" + Aux;
        Path D = Paths.get(carpeta);

        if (crea_carpeta.exists()) {
            System.out.println("ya existe");
        } else {
            System.out.println("creada existe");
            crea_carpeta.mkdirs();
        }
        carpeta = "\\Facturas" + "\\" + fecha() + "\\" + noFactura.toUpperCase();
        File crea_carpeta2 = new File(carpeta);
        carpeta = carpeta + "\\" + Aux;
        Path D2 = Paths.get(carpeta);
        if (crea_carpeta2.exists()) {
            System.out.println("Ya Existe la carpeta");
        } else {
            System.out.println("Fue Creada la carpeta");
            crea_carpeta2.mkdirs();
        }

        Files.copy(o, D, StandardCopyOption.REPLACE_EXISTING);
        Files.copy(o, D2, StandardCopyOption.REPLACE_EXISTING);
    }

    public String fecha() {

        Date fecha = new Date();
        String Fecha = fecha.toString();
        int aux = 0;
        String Aux = "";
        String aux2 = "";
        StringTokenizer tokens = new StringTokenizer(Fecha);

        while (tokens.hasMoreTokens()) {
            Aux = tokens.nextToken();
            if (aux == 1 || aux == 2 || aux == 5) {
                if (aux == 1) {
                    aux2 = Aux;
                }
                if (aux == 2) {
                    Fecha = Aux;
                    Fecha = Fecha + aux2;
                } else {
                    Fecha = Fecha + Aux;
                }
            }

            aux++;
        }
        System.out.println(Fecha);
        return Fecha;

    }

    public File CargaArchivo() {
        File arch = null;
        String Ruta = "";
        JFileChooser jfC = new JFileChooser();
        jfC.setFileFilter(new FileNameExtensionFilter(" Archivo .XML", "xml"));

        int r = jfC.showOpenDialog(this);
        if (r == JFileChooser.APPROVE_OPTION) {
            arch = jfC.getSelectedFile();

        }

        return arch;

    }

    public String RutaArchivoCSV(String Clase) {
        File arch = null;
        String Ruta = "";
        JFileChooser jfC = new JFileChooser();
        jfC.setFileFilter(new FileNameExtensionFilter(" Archivo ." + Clase, Clase));

        int r = jfC.showOpenDialog(this);
        if (r == JFileChooser.APPROVE_OPTION) {
            arch = jfC.getSelectedFile();

        }

        return arch.toString();

    }

    public String ArchivoCadenaCSV(String ruta) {
        String cadenaAux;
        String Final = "";

        FileReader f;
        try {
            f = new FileReader(ruta);
            BufferedReader b = new BufferedReader(f);
            b.readLine();
            
            while ((cadenaAux = b.readLine()) != null) {
                System.out.println();
                System.out.println(cadenaAux);
                if (cadenaAux.length()>8) {
                    Final = Final + cadenaAux + "\n";
                }
                

            }
            cadena=cadenaAux;
            b.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Temporal.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Temporal.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Final;
    }

    public String getCadena() {
        return cadena;
    }

    public void setCadena(String cadena) {
        this.cadena = cadena;
    }
    
    
}
