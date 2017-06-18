/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dent.clases;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

/**
 *
 * @author Edwin
 */
public class ProXML {
    
        String noFactura;
        String Rfc;
        String rfcNombre;   
        String RfcDeposito;
        String noArticulos;   
        String ruta;
        double totalCIVA;
        double arti_Fac;
        double arti_Carga;

    
   

   
    
      SAXBuilder builder = new SAXBuilder();
      public   List<Articulo> lista = new ArrayList<>();
               List<Articulo> listaAux = new ArrayList<>();
        
    public int tamañoLista (){
        
        int tamaño= lista.size();
        
        
        return tamaño;
      
    }
    public int getArLista (int numero){
        int tamaño= lista.size();
            
        
        return tamaño;
      
    }
    
    
    public void insetLista ( String clave,String Descripcion,double precio,double cantidad ){
        int tamaño= lista.size();
        
        Articulo arti =new Articulo(clave,Descripcion,precio,cantidad);
        lista.add(arti);  
             
    }
    public void insetLista2 ( String clave,String Descripcion,double precio,double cantidad ){
               
        Articulo arti4 =new Articulo(clave,Descripcion,precio,cantidad);
             
        listaAux.add(arti4);  
             
    }
    public void reviArticulo (){
        
        Articulo aux = new Articulo("", "", 0, 0);

        for (int i = 0; i < lista.size(); i++) {

            double cantidad = lista.get(i).getCantidad();
            aux = lista.get(i);

            for (int j = 0; j < lista.size(); j++) {

                if ((aux.getCodigo() == null ? lista.get(j).getCodigo() == null : aux.getCodigo().equals(lista.get(j).getCodigo())) && i != j) {

                    // aux = newArticulo(aux);
                    cantidad = cantidad + lista.get(j).getCantidad();
                    lista.remove(j);
                } else {

                }
            }
            insetLista2(aux.getCodigo(), aux.getArticulo(), aux.getValor(), cantidad);

        }

        lista.clear();

        listaAux.stream().forEach((listaAux) -> {
            insetLista(listaAux.getCodigo(), listaAux.getArticulo(), listaAux.getValor(), listaAux.getCantidad());
        });
        listaAux.clear();
    }
    
    
    public int LecturaXML(){
        
        int error = 0;
        
        String Codigo ="";
        String Articulo ="";
        double Valor = 0;
        double Cantidad =0 ;
       
        
       
        
        
         try{
            File xmlFile = new File(ruta);
            Document document = (Document) builder.build( xmlFile );
            Element rootNode = document.getRootElement();
            String nombreXml = (rootNode.getName());
            
            String strSerie = rootNode.getAttributeValue("serie");
            String strFolio = rootNode.getAttributeValue("folio");
            String strevento = rootNode.getAttributeValue("version");
           
            noFactura=strSerie+ "-" +strFolio;                           // No de factura del proveedor
            System.out.println(noFactura);
          
            List list = rootNode.getChildren();
             
            System.out.println(list.size());
            
            for (int i = 0; i < list.size(); i++) {
               Element elementoCFDI =(Element)list.get(i);
               String valor = elementoCFDI.getName();
                System.out.println(valor);
               
                if (valor.equals("Emisor")){
                    Rfc=elementoCFDI.getAttributeValue("rfc");          // se carga el Rfc del proveedor
                    System.out.println("RFC= "+Rfc);
                    rfcNombre=elementoCFDI.getAttributeValue("nombre");
                    System.out.println("Nombre= "+rfcNombre);
                    System.out.println("");
                }
                if (valor.equals("Receptor")){
                    RfcDeposito=elementoCFDI.getAttributeValue("rfc");
                    System.out.println("RFC= "+RfcDeposito);
                    System.out.println("Nombre= "+elementoCFDI.getAttributeValue("nombre"));
                    System.out.println("");
                }
                
                if (valor.equals("Conceptos")){
                   
                    //System.out.println(list);
                    System.out.println(elementoCFDI);
                    
                    List list2 = elementoCFDI.getChildren();
                    System.out.println("No de articulos en la lista "+ list2.size());
                    
                    for (int j = 0; j < list2.size(); j++) {
                        
                        
                        
                        
                      System.out.println( list2.get(j)); 
                      Element elementoArticulo =(Element)list2.get(j);
                        
                        Codigo   = elementoArticulo.getAttributeValue("noIdentificacion");
                        Articulo = elementoArticulo.getAttributeValue("descripcion");
                        Valor    = Double.parseDouble(elementoArticulo.getAttributeValue("valorUnitario"));
                        Cantidad = Double.parseDouble(elementoArticulo.getAttributeValue("cantidad"));

                         if (Codigo==null) {
                            Random rnd = new Random();
                            Codigo="Sin"+rnd.nextInt();
                             System.out.println("Se genero Codigo aArticulo ");
                             }
                         
                       insetLista (Codigo, Articulo, Valor,Cantidad);
                         
                         
                         
                         
                         
                      System.out.println("Codigo = "+Codigo); 
                      System.out.println("Articulo = "+Articulo); 
                      System.out.println("Valor = "+Valor); 
                      System.out.println("Cantidad = "+Cantidad); 
                      System.out.println(j);
                      System.out.println("");
                    }
                    System.out.println("");
                    
                   
                }
            }
            
             arti_Fac=lista.size();
             System.out.println("Total de artculos antes de la revicion " +lista.size());
             reviArticulo ();
             System.out.println("");
             arti_Carga=lista.size();
             System.out.println("Total de artculos despues de la revicion " +lista.size());
            
            error = 0;
        }catch(JDOMException | IOException | NumberFormatException e){
            error = 1;
        }
         double aux=0;
         for (int i = 0; i < lista.size(); i++) {
            aux=aux+(lista.get(i).getCantidad()*lista.get(i).getValor());
        }
//         aux=aux*1.16;
         aux=(double)((int)(aux*1000)/1000); 
         
         totalCIVA=aux;
         
            return error;
            
    }
        
    
    
    
    
    
    public String getNoFactura() {
        return noFactura;
    }

    public void setNoFactura(String noFactura) {
        this.noFactura = noFactura;
    }

    public String getRfc() {
        return Rfc;
    }

    public void setRfc(String Rfc) {
        this.Rfc = Rfc;
    }

    public String getRfcDeposito() {
        return RfcDeposito;
    }

    public void setRfcDeposito(String RfcDeposito) {
        this.RfcDeposito = RfcDeposito;
    }

    public String getNoArticulos() {
        return noArticulos;
    }

    public void setNoArticulos(String noArticulos) {
        this.noArticulos = noArticulos;
    }
     public String getRuta() {
        return ruta;
    }

    public void setRuta(String ruta) {
        this.ruta = ruta;
    }
     public double getTotalCIVA() {
        return totalCIVA;
    }

    public void setTotalCIVA(double totalCIVA) {
        this.totalCIVA = totalCIVA;
    }
     public String getRfcNombre() {
        return rfcNombre;
    }

    public void setRfcNombre(String rfcNombre) {
        this.rfcNombre = rfcNombre;
    }
    public double getArti_Fac() {
        return arti_Fac;
    }

    public void setArti_Fac(double arti_Fac) {
        this.arti_Fac = arti_Fac;
    }

    public double getArti_Carga() {
        return arti_Carga;
    }

    public void setArti_Carga(double arti_Carga) {
        this.arti_Carga = arti_Carga;
    }

            
}
