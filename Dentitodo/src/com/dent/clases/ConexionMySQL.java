/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dent.clases;

/**
 *
 * @author Edwin
 */
import java.sql.*;
import java.util.ArrayList;
import java.util.Stack;
import javax.swing.JOptionPane;


public class ConexionMySQL {

//    public String pass = "smith";
//     public String db = "dentitodo";
    
    public String db = "sicar";
    public String pass = "javac";
    
    public String user = "root";
    
    Connection link = null;
    Statement st = null;
    ResultSet rs = null;
    
    public String url = "jdbc:mysql://192.168.5.75:3306/"+db;
//    public String url = "jdbc:mysql://25.85.247.71:3306/"+db; //base lan dentitodo
    
//    public String url = "jdbc:mysql://192.168.1.75:3306/" + db; //base local dentitodo

    

    public Connection Conectar(String iduser, String idcontra) {

        

        try {

            Class.forName("org.gjt.mm.mysql.Driver");
            link = DriverManager.getConnection(this.url, iduser, idcontra);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }

        return link;

    }
    
    public Connection ConectarLocal(String iduser, String idcontra) {
        try {

            Class.forName("org.gjt.mm.mysql.Driver");
            link = DriverManager.getConnection("jdbc:mysql://localhost:3306/dentitodo", "root", pass);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }

        return link;

    }

    public boolean Ejecuta(String iduser, String idcontra, String consulta) {
        boolean Estado = true;
        String result = consulta;
        Connection link = null;
        Statement st = null;
        
        try {
            Class.forName("org.gjt.mm.mysql.Driver");
            link = DriverManager.getConnection(this.url, iduser, idcontra);
            Estado = true;
        } catch (ClassNotFoundException | SQLException ex) {
            Estado = false;
            JOptionPane.showMessageDialog(null, ex);
        }

        try {
//          result="update dentitodo.pruebatri set dentitodo.pruebatri.id1=10;";  
//          result="call dentitodo.prueba('30')";
            st = link.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
            st.execute(result);
            Estado = true;

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
            Estado = false;
        }
        return Estado;

    }
    public String[] ConsultaMoid() {
        
        Conectar(user,pass);
        
       String[] Moid={"","",""};
        try {
            st = link.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
            rs = st.executeQuery("select max(dentitodo.RegistroMonedas.mo_id) as id  from dentitodo.RegistroMonedas");
            while (rs.next()) {
               Moid[0]=Integer.toString(rs.getInt("id"));
            }
            rs = st.executeQuery("select fecha,total from dentitodo.RegistroMonedas  where  dentitodo.RegistroMonedas.mo_id="+Moid[0]);
            while (rs.next()) {
                 Moid[1]=rs.getString("fecha");
                 Moid[2]=String.valueOf(rs.getDouble("total"));               
            }

        } catch (SQLException e) {
        }
        return Moid;
    }
    
    
    public boolean ConsultaRfc(String rfc) {
        
        Conectar(user,pass);
        
       int Moid=0;
       boolean estado=false;
        try {
            st = link.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
            String RfcCon = "SELECT ifnull(count(dentitodo.emisor.Rfc),0) as rfc FROM dentitodo.emisor where  dentitodo.emisor.rfc='"+rfc+"';";
            rs = st.executeQuery(RfcCon);
            while (rs.next()) {
               Moid=rs.getInt("rfc");
                System.out.println("Resultado de la consulta de rfc "+Moid);
            }
            if (Moid==1) {
                estado=true;
            }
      

        } catch (SQLException e) {
        }
        return estado;
    }
    public int ConsultaRfcFolio() {
        
        Conectar(user,pass);
        
       int Moid=0;
        try {
            st = link.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
            String RfcCon = "SELECT max(dentitodo.facturas.fac_id)+1 as folio FROM dentitodo.facturas;";
            rs = st.executeQuery(RfcCon);
            while (rs.next()) {
               Moid=rs.getInt("folio");
                System.out.println("Resultado de la consulta de rfc "+Moid);
            }
            

        } catch (SQLException e) {
        }
        return Moid;
    }
    
    public String ConsultaNombre(String rfc ) {
        
        Conectar(user,pass);
        
       String Moid="";
        try {
            st = link.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
            String RfcCon = "SELECT nombre FROM dentitodo.emisor where dentitodo.emisor.rfc='"+rfc+"';";
            rs = st.executeQuery(RfcCon);
            while (rs.next()) {
               Moid=rs.getString("nombre");
                System.out.println("Resultado de la consulta de rfc "+Moid);
            }
            

        } catch (SQLException e) {
        }
        return Moid;
    }
    
    
    public Stack ConsultaCategoria() {
        Stack pila =new Stack();
        
        
        Conectar(user,pass);
        
       String Moid="";
        try {
            st = link.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
            String RfcCon = "SELECT dentitodo.categoria.name FROM dentitodo.categoria;";
            rs = st.executeQuery(RfcCon);
            while (rs.next()) {
               pila.push(rs.getString("name"));               
                System.out.println("Resultado de la consulta de name "+Moid);
            }
            

        } catch (SQLException e) {
        }
        return pila;
    }
    

    public ArrayList<Articulo> ConsultaArticulos() {
        
        Conectar(user,pass);

        ArrayList<Articulo> listaArticulos = new ArrayList();
        try {
            st = link.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
//            rs = st.executeQuery("select * from sicar.articulo where sicar.articulo.art_id>3300");
            rs = st.executeQuery("select * from sicar.articulo");
            while (rs.next()) {
//                System.out.println(rs.getString("clave"));
//                System.out.println(rs.getString("descripcion"));
//                System.out.println(rs.getFloat("precioCompra"));
                float aux = rs.getFloat("precioCompra");
                aux = aux / rs.getFloat("factor");
                Articulo artiNue = new Articulo(rs.getString("clave"), rs.getString("descripcion"), aux* 1.16 * 1.34, 1);

//                System.out.println(rs.getFloat("factor"));
//                System.out.println(rs.getString("clave") + "   " + aux * 1.16 * 1.34 + "   " + rs.getFloat("precioCompra"));
                listaArticulos.add(artiNue);
            }

        } catch (SQLException e) {
        }
        return listaArticulos;
    }
    
    public void Consulta(String iduser, String idcontra) {

        String result = " ";
        Connection link = null;

        try {
            Class.forName("org.gjt.mm.mysql.Driver");
            link = DriverManager.getConnection(this.url, iduser, idcontra);
        } catch (ClassNotFoundException | SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }

        try {
            result = "update dentitodo.pruebatri set dentitodo.pruebatri.id1=10;";
            result = "call dentitodo.prueba('30)";
            st = link.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
            st.execute(result);

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);

        }

    }
    
     public boolean InsertaCate(String categoria) {
        boolean status = false;
        String result = " ";
        Connection link = null;

//        Conectar(user,pass);
        

        try {
            Class.forName("org.gjt.mm.mysql.Driver");
            link = DriverManager.getConnection("jdbc:mysql://localhost:3306/", "root", pass);

        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("erro Consulta1");
            JOptionPane.showMessageDialog(null, ex);
        }
        System.out.println("hola");
        try {

            String ejecuto = "insert into dentitodo.categoria (dentitodo.categoria.name) value('"+categoria+"');";
            result = ejecuto;
            st = link.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
            st.execute(result);
            System.out.println(" se guardo correctamente");
            status = true;

        } catch (Exception ex) {
            System.out.println("Error en consulta");
            JOptionPane.showMessageDialog(null, ex);
            status = false;

        }
        return status;

    }
     
     
     public Stack ConsultaPagos() {
        Stack pila = new Stack();

        Conectar(user, pass);

        String Moid = "";
        try {
            st = link.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
            String RfcCon = "SELECT dentitodo.Tipo_pago.nombre FROM dentitodo.Tipo_pago;";
            rs = st.executeQuery(RfcCon);
            while (rs.next()) {
                pila.push(rs.getString("nombre"));
                System.out.println("Resultado de la consulta de tipo " + Moid);
            }

        } catch (SQLException e) {
            System.out.println(e);
        }
        return pila;
    }
     public boolean InsertaEmi(String nombre ,String rfc,String direccion,String tipo) {
        boolean status = false;
        String result = " ";
        Connection link = null;

//        Conectar(user,pass);
        

        try {
            Class.forName("org.gjt.mm.mysql.Driver");
            link = DriverManager.getConnection("jdbc:mysql://localhost:3306/", "root", pass);

        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("erro Consulta1");
            JOptionPane.showMessageDialog(null, ex);
        }
        System.out.println("hola");
        try {

            String ejecuto = "insert into  dentitodo.emisor (dentitodo.emisor.Nombre,dentitodo.emisor.rfc,dentitodo.emisor.Direccion,dentitodo.emisor.tipo) value ('"+nombre+"','"+rfc+"','"+direccion+"','"+tipo+"')";
            result = ejecuto;
            st = link.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
            st.execute(result);
            System.out.println(" se guardo correctamente");
            status = true;

        } catch (Exception ex) {
            System.out.println("Error en consulta");
            JOptionPane.showMessageDialog(null, ex);
            status = false;

        }
        return status;

    }
     
     

    public boolean Consultatem(String folio, String nombre, String rfc, String fechaCompra, String fechaFactura, boolean estado1,
            String tipo, String Facturado, double subTotal, double ivaTotal, double total,int razon, String gasto, String referencia, String pago, String numero) {
        boolean status = false;
        String result = " ";
        Connection link = null;
        
        String  estado ="";

//        Conectar(user,pass);
        if (estado1) {
          estado="SIN";
        }else{
              estado="CON";  
            }
        System.out.println(estado1 +"  entra "+estado);
   
        try {
            Class.forName("org.gjt.mm.mysql.Driver");
            link = DriverManager.getConnection("jdbc:mysql://localhost:3306/", "root", pass);

        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("erro Consulta1");
            JOptionPane.showMessageDialog(null, ex);
        }
        System.out.println("hola");
        try {

            String ejecuto = "call dentitodo.insert_facturas ('" + folio + "','" + nombre + "','" + rfc + "','" + fechaCompra + "','" + fechaFactura + "',"
                    + "'" + estado + "','" + tipo + "','" + Facturado + "','" + subTotal + "','" + ivaTotal + "','" + total + "','" + razon+"','" + gasto+"','" + referencia+ "','" + pago+"','" + numero+"')";
            System.out.println(ejecuto);
            
            result = ejecuto;
//            result = "call dentitodo.prueba('30')";
            st = link.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
            st.execute(result);
            System.out.println(" se guardo correctamente");
            status = true;

        } catch (Exception ex) {
            System.out.println("erro Consulta2");
            JOptionPane.showMessageDialog(null, ex);
            status = false;

        }
        return status;

    }

}
