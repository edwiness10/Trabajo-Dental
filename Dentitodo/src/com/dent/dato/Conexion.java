/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dent.dato;
import java.awt.*;
import java.sql.*;
import java.util.Arrays;
import javax.swing.*;
import javax.swing.JOptionPane;
/**
 *
 * @author DELL
 */
public class Conexion {
    //jdbc:oracle:thin:@localhost:1521:orcl [administrador on ADMINISTRADOR]
    int contadorRegistro =0, ubicacionRegistro = 0, buscador ;
    boolean enter =false, DPIencontrado= false;
    String dpi[] = new String[25];
    String nombre[] = new String[25];
    String dirreccion[] = new String[25];
    String telefono[] = new String[25];
    String f_nac[] = new String[25];
    String DPT1 = "" ;
    
    public static Connection cn = null;
    public static Statement st = null;
    public static  ResultSet rs = null;
    int cantidadColumnas, cantidadFilas;
    
    
    
    public static void conectarOra() {
        try {
            String  url= "jdbc:oracle:thin:@192.168.5.75:1521:orcl";
            cn= DriverManager.getConnection(url, "system","sys");
            st: cn.createStatement();
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, " No ha sido posible conectarse ala base de datos oracle \n "+ e);
        }
    
}
    public static int conectarSicarLogin(String idUser,String idContra) {
        int estado=0;
        try {
            String  url= "jdbc:mysql://192.168.5.75:3306/mysql?zeroDateTimeBehavior=convertToNull";
            cn= DriverManager.getConnection(url, idUser,idContra);
             st: cn.createStatement();
            estado=1;
        }catch (Exception e){
            estado=0;
            //JOptionPane.showMessageDialog(null, " No ha sido posible conectarse ala base de datos sicar\n "+ e);
        }
  return estado;  
}
    
    
    
    
    
    
    public static void conectarSicar() {
        try {
            String  url= "jdbc:mysql://192.168.5.75:3306/mysql?zeroDateTimeBehavior=convertToNull";
            cn= DriverManager.getConnection(url, "root","javac");
            st: cn.createStatement();
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, " No ha sido posible conectarse ala base de datos sicar\n "+ e);
        }
    }
       public static void dessicar (){
           
           try{

                    cn.close();
                    
                }catch(SQLException ex){

                    System.out.println("Error al desconectar "+ex);

                }
       
               
        
}
    public static void obtenerDatosSicar(){
        conectarOra();
        
        
        
        
    }
    
    
    public static void conectarOnline() {
        try {
            String  url= "jdbc:oracle:thin:@192.168.5.75:1521:orcl";
            cn= DriverManager.getConnection(url, "system","sys");
            st: cn.createStatement();
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, " No ha sido posible conectarse \n "+ e);
        }
    
}
    
    
    
    
    
    
    public static void ingresoTabla(String Codigo, int cantidad) {
    try{
        conectarOra(); 
        
        System.out.println(" ok");
        String result="INSERT INTO \"ADMINISTRADOR\".\"Productos\" (NOMBRE, TASA_IMP, ID_IMPUESTOS_PK) VALUES ('IVA', '.16', '5')";
        st = cn.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
            
        
//       rs=st.executeQuery("");
//       System.out.println(re);
       st.execute(result);
     
        cn.close();
        
    }catch(SQLException e){
        
        JOptionPane.showMessageDialog(null, " Error al insertar datos \n "+ e);
        
    }finally {
            try {
                if (cn != null) {
                    cn.close();
                }
            } catch (SQLException sqle) {
                JOptionPane.showMessageDialog(null, "Error al cerrar la conexion");
            }
        }
}
    public static void borrarTabla(int i) {
    
}
    public static void actualizarTabla_S_I(String codigo,String localizacion, float Existencia, int opcion){
          conectarSicar();
          String result="";
           boolean estado=true;
        try{
       switch (opcion){
           case 0:
             result="update sicar.articulo set existencia ="+Existencia+",localizacion=\""+localizacion+"\" where clave='"+codigo+"'";  
           break;
           
           case 1:
              result="update sicar.articulo set existencia ="+Existencia+" where clave='"+codigo+"'";  
           break;
           
           case 2:
              result="update sicar.articulo set localizacion=\""+localizacion+"\" where clave='"+codigo+"'";
           break;
           
           default:
               
               estado=false;
            break;
                  
                   
       }
        
        
        
        
        st = cn.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
        System.out.println("ok");
        
//       rs=st.executeQuery("");
//       System.out.println(re);
      if(estado)
      {
          st.execute(result);
          System.out.println("Se ejecuto correctamente sicar");
      }else{
          JOptionPane.showMessageDialog(null, "Seleccione una dato a actualizar ");
          System.out.println("No se ejecuto nada en  sicar");
      }
      
      
      
      st.close();
       cn.close();
        
    }catch(SQLException e){
        try{
         result="update sicar.articulo set existencia ="+Existencia+",localizacion=\""+localizacion+"\" where clave='"+codigo+"'";
        st = cn.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
          System.out.println(" ok");
        
//       rs=st.executeQuery("");
//       System.out.println(re);
       st.execute(result);
         }catch(SQLException e2){
             JOptionPane.showMessageDialog(null, " Error al insertar datos \n "+ e);
         }finally {
            try {
                if (cn != null) {
                    cn.close();
                }
            } catch (SQLException sqle) {
                JOptionPane.showMessageDialog(null, "Error al cerrar la conexion");
            }
        }
        
         }    
        
        
        
    
    
}
    public static void actualizarTabla_S_O(String sku,String ubicacion,float Existencia,float Exi_tienda,float Exi_bodega ){
        
       
       
        try{
        
        
        System.out.println(" ok");
        ubicacion= ubicacion.replace('\'','-');
        
       // sFernando.replace('e','a').replace('i','a').replace('o','a').replace('u','a');
        //String result=" CALL administrador.INSERTAR_DATO2 ('"+sku+"','','"+ ubicacion+"','"+Existencia+"','"+ Exi_tienda+"','"+ Exi_bodega+"','','',1)";
      //   String result=" CALL   administrador.Insertar_dato2('Prueba', '1','2','3','3','3,'','','')";
       // String result=" call administrador.Insertar_dato2 ('"+sku+"','',\""+ ubicacion +"\",'"+Existencia+"','"+ Exi_tienda+"','"+ Exi_bodega+"','','',1)";
        st = cn.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
            
        
//       rs=st.executeQuery("");
//       System.out.println(re);
   //   st.execute(result);
      
      
        
    }catch(SQLException e){
        
        JOptionPane.showMessageDialog(null, " Error al insertar datos :( ..... \n "+ e);
        
    }finally {
            try {
                if (cn != null) {
                    cn.close();
                }
            } catch (SQLException sqle) {
                JOptionPane.showMessageDialog(null, "Error al cerrar la conexion");
            }
        }
    
}
    public static void actualizarTabla_S_O_Borar(String tabla ){
        try{
        conectarOra(); 
        
        System.out.println(" ok al vaciar el temporal");
        
         st = cn.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
         st.execute("truncate table ADMINISTRADOR."+tabla+"");// borrar
//       rs=st.executeQuery("");
//       System.out.println(re);
      
      
        cn.close();
        
    }catch(SQLException e){
        
        JOptionPane.showMessageDialog(null, " Error al borra datos :( \n "+ e);
        
    }
    
}
     public static void actualizarTabla_S_S_Borar(String tabla ){
        try{
        conectarOra(); 
        
        System.out.println(" ok al vaciar el temporal");
        
         st = cn.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
         st.execute("truncate table ADMINISTRADOR."+tabla+"");// borrar
//       rs=st.executeQuery("");
//       System.out.println(re);
      
      
        cn.close();
        
    }catch(SQLException e){
        
        JOptionPane.showMessageDialog(null, " Error al borra datos :( \n "+ e);
        
    }
    
}
    public static void actualizarTabla_S_O         (String CODIGO,String UBICACION,String NOMBRE,float PRECIO_COMPRA,float STOCK,float TIENDA,float BODEGA,int GUIA ){
        try{
              
        System.out.println(" ok");
        UBICACION= UBICACION.replace('\'','-');
         CODIGO= CODIGO.replace('\'','-');
         System.out.println(GUIA);
       // sFernando.replace('e','a').replace('i','a').replace('o','a').replace('u','a');
            String result=" CALL administrador.Insertar_dato2('"+CODIGO+"','"+ NOMBRE +"','"+ UBICACION +"','"+STOCK+"','"+ TIENDA +"','"+BODEGA+"','0','0','1')";
        
       // String result=" call administrador.Insertar_dato2 ('"+sku+"','',\""+ ubicacion +"\",'"+Existencia+"','"+ Exi_tienda+"','"+ Exi_bodega+"','','',1)";
       st = cn.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
            
            System.out.println(" ok en oralce si se inserto");
//       rs=st.executeQuery("");
//       System.out.println(re);
       st.execute(result);
       
      
        
    }catch(SQLException e){
            System.out.println("");
        JOptionPane.showMessageDialog(null, " Error al insertar datos :( \n "+ e);
        
    }
    
}
    
    public static void actualizarTabla_S_O_TEMPORAL(String CODIGO,String UBICACION,String NOMBRE,float PRECIO_COMPRA,float STOCK,float TIENDA,float BODEGA,int GUIA ){
        try{
              
        System.out.println(" ok");
        UBICACION= UBICACION.replace('\'','-');
         CODIGO= CODIGO.replace('\'','-');
         System.out.println(GUIA);
       // sFernando.replace('e','a').replace('i','a').replace('o','a').replace('u','a');
            String result=" CALL administrador.insert_tem ('"+CODIGO+"','"+UBICACION+"','"+STOCK+"','"+NOMBRE+"','"+PRECIO_COMPRA+"','"+BODEGA+"','"+TIENDA+"','"+GUIA+"')";
        
       // String result=" call administrador.Insertar_dato2 ('"+sku+"','',\""+ ubicacion +"\",'"+Existencia+"','"+ Exi_tienda+"','"+ Exi_bodega+"','','',1)";
       st = cn.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
            
       
//       rs=st.executeQuery("");
//       System.out.println(re);
       st.execute(result);
       
      
        
    }catch(SQLException e){
            System.out.println("");
        JOptionPane.showMessageDialog(null, " Error al insertar datos :( \n "+ e);
        
    }
    
}
   
    public static void consultarTabla(int i) throws SQLException {
        conectarOra();      
       
            
           st = cn.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);  
        
           String result="select * from ADMINISTRADOR.IMPUESTOS order by ";
        
           rs=st.executeQuery(result);
           
           ResultSetMetaData stMD = rs.getMetaData();
           
           System.out.println(" ok");
           
         try {
            while(rs.next()){
               Object [] fila = new Object[stMD.getColumnCount()];
               //Crea un vector
               //para almacenar los valores del ResultSet
            
                for (int j = 0; j < stMD.getColumnCount(); j++) {
                      
                  
                  
                fila[j] = rs.getObject(j+1); // El primer indice en rs es el 1, no el cero, por eso se suma 1. 
              }//añado el modelo a la tabla
                System.out.println(Arrays.toString(fila));
               fila=null;//limpia los datos de el vector de la memoria
            }
            
            System.out.println("ok 2");
            rs.close();
            cn.close();//cerrar result-set
        } catch (SQLException ex) {
            
                JOptionPane.showMessageDialog(null, " Error al consultar datos "+ ex);
        }
          
    
}
    
    
      
    public static Object[] consultaOracle_Temp ( ){
      Object[]  descripcion = null  ;
        Conexion.conectarOra();
        try {  
           Conexion.st = Conexion.cn.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
          
           String result="select count(codigo) from ADMINISTRADOR.TEMPORAL";
        
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
     public static Object[] consultaOracle ( ){
      Object[]  descripcion = null  ;
        Conexion.conectarOra();
        try {  
           Conexion.st = Conexion.cn.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
          
           String result="select count(ID_PRODUCTO_FK) from ADMINISTRADOR.inventario";
        
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
    
    public static Object[][] consultaOracle_Temp_des ( ){
      
      Object[]  tamaño = null  ;
       tamaño=consultaOracle_Temp ( );
        Conexion.conectarOra();
        
        
          System.out.println(tamaño[0]);
        Object[][]  descripcion = new Object[Integer.parseInt(tamaño[0].toString())+1][8];
        try {  
          //  Object [] fila = new Object[stMD.getColumnCount()];
           Conexion.st = Conexion.cn.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
          
           String result="select nvl(codigo,'0'),nvl(ubicacion,'0'), nvl(stock,'0'),nvl(nombre,'0'),nvl(PRECIO_COMPRA,'0'),nvl(BODEGA,'0'),nvl(tienda,'0'),nvl(guia,'0')from ADMINISTRADOR.TEMPORAL order by guia";
        
           Conexion.rs=Conexion.st.executeQuery(result);
           
           ResultSetMetaData stMD = Conexion.rs.getMetaData();
           
//           System.out.println(" ok");
           
         try {
             
             int conteo =0;
            while(Conexion.rs.next()){
               Object [] fila = new Object[stMD.getColumnCount()];
               //Crea un vector
               //para almacenar los valores del ResultSet
            
                for (int j = 0; j < stMD.getColumnCount(); j++) {
                                
                  
                fila[j] = Conexion.rs.getObject(j+1); 
                    System.out.println(j+" datos "+ conteo+ " columnas "+ stMD.getColumnCount());
                    
                    
                 descripcion[conteo][j] =  fila[j];
     // El primer indice en rs es el 1, no el cero, por eso se suma 1. 
              }//añado el modelo a la tabla
//                System.out.println(Arrays.toString(descripcion));
               // System.out.println(fila);
               // System.out.println(conteo);
               fila=null;//limpia los datos de el vector de la memoria
               conteo =conteo+1;
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
          System.out.println(Arrays.toString(descripcion));
           System.out.println("");
          //  System.out.println(descripcion[0][0].toString());
            System.out.println(descripcion[0][1]);
            System.out.println(descripcion[0][2]);
            System.out.println(descripcion[1][0]);
            System.out.println(descripcion[1][1]);
            System.out.println(descripcion[1][2]);
            System.out.println(Arrays.toString(descripcion[1]));
       
        return descripcion ;
    }
    
    
    
     public static Object[][] consultaOracle_des ( ){
      
      Object[]  tamaño = null  ;
       tamaño=consultaOracle( );
        Conexion.conectarOra();
        
        
          System.out.println(tamaño[0]);
        Object[][]  descripcion = new Object[Integer.parseInt(tamaño[0].toString())+1][8];
        try {  
          //  Object [] fila = new Object[stMD.getColumnCount()];
           Conexion.st = Conexion.cn.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
          
           String result="select nvl(ID_PRODUCTO_FK,'0'),nvl(UBI_GENERAL,'0'), nvl(EXISTENCIAS,'0'),nvl(EX_BODEGA,'0'),nvl(EX_TIENDA,'0') from ADMINISTRADOR.inventario ";
        
           Conexion.rs=Conexion.st.executeQuery(result);
           
           ResultSetMetaData stMD = Conexion.rs.getMetaData();
           
//           System.out.println(" ok");
           
         try {
             
             int conteo =0;
            while(Conexion.rs.next()){
               Object [] fila = new Object[stMD.getColumnCount()];
               //Crea un vector
               //para almacenar los valores del ResultSet
            
                for (int j = 0; j < stMD.getColumnCount(); j++) {
                                
                  
                fila[j] = Conexion.rs.getObject(j+1); 
                    System.out.println(j+" datos "+ conteo+ " columnas "+ stMD.getColumnCount());
                    
                    
                 descripcion[conteo][j] =  fila[j];
     // El primer indice en rs es el 1, no el cero, por eso se suma 1. 
              }//añado el modelo a la tabla
//                System.out.println(Arrays.toString(descripcion));
               // System.out.println(fila);
               // System.out.println(conteo);
               fila=null;//limpia los datos de el vector de la memoria
               conteo =conteo+1;
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
          System.out.println(Arrays.toString(descripcion));
           System.out.println("");
          //  System.out.println(descripcion[0][0].toString());
            System.out.println(descripcion[0][1]);
            System.out.println(descripcion[0][2]);
            System.out.println(descripcion[1][0]);
            System.out.println(descripcion[1][1]);
            System.out.println(descripcion[1][2]);
            System.out.println(Arrays.toString(descripcion[1]));
       
        return descripcion ;
    }
 
}


