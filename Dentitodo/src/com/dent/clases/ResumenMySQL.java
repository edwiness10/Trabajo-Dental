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

public class ResumenMySQL {

//    public String pass = "smith";
//     public String db = "dentitodo";
    public String db = "sicar";
    public String pass = "javac";

    public String user = "root";

    Connection link = null;
    Statement st = null;
    ResultSet rs = null;

    public String url = "jdbc:mysql://localhost:3306/" + db;
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

//     public Connection Cerrar() {
//
//        try {
//
//            Class.forName("org.gjt.mm.mysql.Driver");
//            link = DriverManager.getConnection(this.url, iduser, idcontra);
//        } catch (Exception ex) {
//            JOptionPane.showMessageDialog(null, ex);
//        }
//
//        return link;
//
//    }
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
        } finally {
            try {
                if (link != null) {
                    link.close();
                }
            } catch (SQLException sqle) {
                JOptionPane.showMessageDialog(null, "Error al cerrar la conexion");
            }
        }
        return Estado;

    }

    public String[] ConsultaMoid() {

        Conectar(user, pass);

        String[] Moid = {"", "", ""};
        try {
            st = link.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
            rs = st.executeQuery("select max(dentitodo.RegistroMonedas.mo_id) as id  from dentitodo.RegistroMonedas");
            while (rs.next()) {
                Moid[0] = Integer.toString(rs.getInt("id"));
            }
            rs = st.executeQuery("select fecha,total from dentitodo.RegistroMonedas  where  dentitodo.RegistroMonedas.mo_id=" + Moid[0]);
            while (rs.next()) {
                Moid[1] = rs.getString("fecha");
                Moid[2] = String.valueOf(rs.getDouble("total"));
            }

        } catch (SQLException e) {
        } finally {
            try {
                if (link != null) {
                    link.close();
                }
            } catch (SQLException sqle) {
                JOptionPane.showMessageDialog(null, "Error al cerrar la conexion");
            }
        }
        return Moid;
    }

    public double ConsultaFactu(String dia, String mes, String año, String diaF, String mesF, String añoF) {

        Conectar(user, pass);

        int diaAu = Integer.parseInt(diaF);
        if (diaAu != 31) {
            diaAu = diaAu + 1;
            diaF = String.valueOf(diaAu);
        }

        double Moid = 0;
        try {
            st = link.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
            String fecha = año + "-" + mes + "-" + dia;
            String fechaFin = añoF + "-" + mesF + "-" + diaF;
            System.out.println(fecha);
            String RfcCon = "SELECT sum(sicar.facturacfdi.total) as suma FROM sicar.facturacfdi where sicar.facturacfdi.fecha>'" + fecha + "' and sicar.facturacfdi.fecha<'" + fechaFin + "' and sicar.facturacfdi.status=1;";
            System.out.println("con " + RfcCon);
            rs = st.executeQuery(RfcCon);
            while (rs.next()) {
                Moid = rs.getDouble("suma");
                System.out.println("Resultado de la consulta de suma " + Moid);
            }
        } catch (SQLException e) {
            System.out.println("error " + e);
        } finally {
            try {
                if (link != null) {
                    link.close();
                }
            } catch (SQLException sqle) {
                JOptionPane.showMessageDialog(null, "Error al cerrar la conexion");
            }
        }
        return Moid;
    }

    public double ConsultaFactuC(String dia, String mes, String año, String diaF, String mesF, String añoF) {

        Conectar(user, pass);
        int diaAu = Integer.parseInt(diaF);
        if (diaAu != 31) {
            diaAu = diaAu + 1;
            diaF = String.valueOf(diaAu);
        }

        double Moid = 0;
        try {
            st = link.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
            String fecha = año + "-" + mes + "-" + dia;
            String fechaFin = añoF + "-" + mesF + "-" + diaF;
            String RfcCon = "SELECT sum(sicar.facturacfdi.total)  as suma FROM sicar.facturacfdi where sicar.facturacfdi.fecha>'" + fecha + "' and sicar.facturacfdi.fecha<'" + fechaFin + "'  and sicar.facturacfdi.status=-1";
            rs = st.executeQuery(RfcCon);
            while (rs.next()) {
                Moid = rs.getDouble("suma");
                System.out.println("Resultado de la consulta de suma " + Moid);
            }
        } catch (SQLException e) {
        } finally {
            try {
                if (link != null) {
                    link.close();
                }
            } catch (SQLException sqle) {
                JOptionPane.showMessageDialog(null, "Error al cerrar la conexion");
            }
        }
        return Moid;
    }

    public double ConsultaVT(String dia, String mes, String año, String diaF, String mesF, String añoF) {

        Conectar(user, pass);

        int diaAu = Integer.parseInt(diaF);
        if (diaAu != 31) {
            diaAu = diaAu + 1;
            diaF = String.valueOf(diaAu);
        }
        double Moid = 0;
        try {
            st = link.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
            String fecha = año + "-" + mes + "-" + dia;
            String fechaFin = añoF + "-" + mesF + "-" + diaF;
            String RfcCon = "SELECT sum(sicar.venta.total) as suma FROM sicar.venta where sicar.venta.fecha>'" + fecha + "' and sicar.venta.fecha<'" + fechaFin + "' and sicar.venta.status=1;";
            rs = st.executeQuery(RfcCon);
            while (rs.next()) {
                Moid = rs.getDouble("suma");
                System.out.println("Resultado de la consulta de suma " + Moid);
            }
        } catch (SQLException e) {
        } finally {
            try {
                if (link != null) {
                    link.close();
                }
            } catch (SQLException sqle) {
                JOptionPane.showMessageDialog(null, "Error al cerrar la conexion");
            }
        }
        return Moid;
    }

    public double ConsultaTotalSalidasSicar(String dia, String mes, String año, String diaF, String mesF, String añoF) {

        Conectar(user, pass);
        int diaAu = Integer.parseInt(diaF);
        if (diaAu != 31) {
            diaAu = diaAu + 1;
            diaF = String.valueOf(diaAu);
        }

        double Moid = 0;
        try {
            st = link.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
            String fecha = año + "-" + mes + "-" + dia;
            String fechaFin = añoF + "-" + mesF + "-" + diaF;
            String RfcCon = "SELECT sum(m.total) as suma FROM sicar.movimiento as m join sicar.cortecaja as c  where m.cor_id = c.cor_id   and m.tipo =2 and m.com_id is null and m.ven_id is null and m.comentario!='SALIDA POR CORTE DE CAJA' and ncr_id is null and c.fecha >'" + fecha + "' and c.fecha <'" + fechaFin + "';";
            rs = st.executeQuery(RfcCon);
            while (rs.next()) {
                Moid = rs.getDouble("suma");
                System.out.println("Resultado de la consulta de suma " + Moid);
            }
            RfcCon = "SELECT sum(m.total) as suma FROM sicar.movimiento as m join sicar.cortecaja as c  where m.cor_id = c.cor_id   and m.tipo =1 and m.com_id is null and m.ven_id is null and m.comentario!='SALIDA POR CORTE DE CAJA' and ncr_id is null and c.fecha >'" + fecha + "';";
            rs = st.executeQuery(RfcCon);
            while (rs.next()) {
                Moid = Moid - rs.getDouble("suma");
                System.out.println("Resultado de la consulta de suma " + Moid);
            }
        } catch (SQLException e) {
        } finally {
            try {
                if (link != null) {
                    link.close();
                }
            } catch (SQLException sqle) {
                JOptionPane.showMessageDialog(null, "Error al cerrar la conexion");
            }
        }
        return Moid;
    }

    public double ConsultaGasto(String dia, String mes, String año, String diaF, String mesF, String añoF, boolean estado1) {

        int diaAu = Integer.parseInt(diaF);
        if (diaAu != 31) {
            diaAu = diaAu + 1;
            diaF = String.valueOf(diaAu);
        }

        String estado = "";
        if (estado1) {
            estado = "SIN";
        } else {
            estado = "CON";
        }

        Conectar(user, pass);

        double Moid = 0;
        try {
            st = link.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
            String fecha = año + "-" + mes + "-" + dia;
            String fechaFin = añoF + "-" + mesF + "-" + diaF;
            String RfcCon = "select sum(f.total) as suma from dentitodo.facturas f   join dentitodo.emisor e where f.rfc = e.Rfc and f.id_Razon=0 and f.Status=1 and  (f.Fecha_facturada>'" + fecha + "' and f.Fecha_facturada<'" + fechaFin + "' ) and gasto='gasto' and  f.Estado='" + estado + "'";

            rs = st.executeQuery(RfcCon);
            while (rs.next()) {
                Moid = rs.getDouble("suma");
                System.out.println("Resultado de la consulta de suma " + Moid);
            }

        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            try {
                if (link != null) {
                    link.close();
                }
            } catch (SQLException sqle) {
                JOptionPane.showMessageDialog(null, "Error al cerrar la conexion");
            }
        }
        return Moid;
    }

    public double ConsultaCompra(String dia, String mes, String año, String diaF, String mesF, String añoF, boolean estado1) {
        int diaAu = Integer.parseInt(diaF);
        if (diaAu != 31) {
            diaAu = diaAu + 1;
            diaF = String.valueOf(diaAu);
        }

        String estado = "";
        if (estado1) {
            estado = "SIN";
        } else {
            estado = "CON";
        }

        Conectar(user, pass);

        double Moid = 0;
        try {
            st = link.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
            String fecha = año + "-" + mes + "-" + dia;
            String fechaFin = añoF + "-" + mesF + "-" + diaF;
            String RfcCon = "select sum(f.total) as suma from dentitodo.facturas f   join dentitodo.emisor e where f.rfc = e.Rfc and f.id_Razon=0 and f.Status=1 and  (f.Fecha_facturada>'" + fecha + "' and f.Fecha_facturada<'" + fechaFin + "' ) and gasto='compra' and  f.Estado='" + estado + "'";

            rs = st.executeQuery(RfcCon);

            ResultSetMetaData rsmd = rs.getMetaData();

            for (int i = 1; i <= rsmd.getColumnCount(); i++) {
                System.out.println(rsmd.getColumnName(i));
            }

            while (rs.next()) {

                Moid = rs.getDouble("suma");
                System.out.println("Resultado de la consulta de suma " + Moid);
            }

        } catch (SQLException e) {
            System.out.println("ConsultaCompra " + e);
        } finally {
            try {
                if (link != null) {
                    link.close();
                }
            } catch (SQLException sqle) {
                JOptionPane.showMessageDialog(null, "Error al cerrar la conexion");
            }
        }
        return Moid;
    }

    public String[][] ConsultaGeneral(String RfcCon) {

        int filas = 0;
        String[][] dato2 = new String[3][filas];

        Conectar(user, pass);

        try {
            st = link.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);

            rs = st.executeQuery(RfcCon);

            ResultSetMetaData rsmd = rs.getMetaData();

            System.out.println(rs.getMetaData().getColumnCount());
            rs.last();
            filas = rs.getRow();
            rs.beforeFirst();
            String[][] dato = new String[filas + 1][rsmd.getColumnCount()];

            for (int i = 1; i <= rsmd.getColumnCount(); i++) {
                dato[0][i - 1] = rsmd.getColumnName(i);
//                System.out.println(rsmd.getColumnName(i) + "  " + rsmd.getColumnTypeName(i));

            }

            while (rs.next()) {

                String Cadena = "";
                for (int i = 1; i <= rsmd.getColumnCount(); i++) {
                    dato[rs.getRow()][i - 1] = rs.getString(rsmd.getColumnName(i));
                }
                System.out.println(Cadena);

            }
            return dato;

        } catch (SQLException e) {
            System.out.println("ConsultaCompra " + e);

        } finally {
            try {
                if (link != null) {
                    link.close();
                }
            } catch (SQLException sqle) {
                JOptionPane.showMessageDialog(null, "Error al cerrar la conexion");
            }
        }

        return dato2;
    }

    public int ConsultaRfcFolio() {

        Conectar(user, pass);

        int Moid = 0;
        try {
            st = link.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
            String RfcCon = "SELECT max(dentitodo.facturas.fac_id)+1 as folio FROM dentitodo.facturas;";
            rs = st.executeQuery(RfcCon);
            while (rs.next()) {
                Moid = rs.getInt("folio");
                System.out.println("Resultado de la consulta de rfc " + Moid);
            }

        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            try {
                if (link != null) {
                    link.close();
                }
            } catch (SQLException sqle) {
                JOptionPane.showMessageDialog(null, "Error al cerrar la conexion");
            }
        }
        return Moid;
    }

    public String ConsultaNombre(String rfc) {

        Conectar(user, pass);

        String Moid = "";
        try {
            st = link.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
            String RfcCon = "SELECT nombre FROM dentitodo.emisor where dentitodo.emisor.rfc='" + rfc + "';";
            rs = st.executeQuery(RfcCon);

            while (rs.next()) {
                Moid = rs.getString("nombre");
                System.out.println("Resultado de la consulta de rfc " + Moid);
            }

        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            try {
                if (link != null) {
                    link.close();
                }
            } catch (SQLException sqle) {
                JOptionPane.showMessageDialog(null, "Error al cerrar la conexion");
            }
        }
        return Moid;
    }

    public Stack ConsultaCategoria() {
        Stack pila = new Stack();

        Conectar(user, pass);

        String Moid = "";
        try {
            st = link.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
            String RfcCon = "SELECT dentitodo.categoria.name FROM dentitodo.categoria;";
            rs = st.executeQuery(RfcCon);
            while (rs.next()) {
                pila.push(rs.getString("name"));
                System.out.println("Resultado de la consulta de name " + Moid);
            }

        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            try {
                if (link != null) {
                    link.close();
                }
            } catch (SQLException sqle) {
                JOptionPane.showMessageDialog(null, "Error al cerrar la conexion");
            }
        }
        return pila;
    }

    public ArrayList<Articulo> ConsultaArticulos() {

        Conectar(user, pass);

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
                Articulo artiNue = new Articulo(rs.getString("clave"), rs.getString("descripcion"), aux * 1.16 * 1.34, 1);

//                System.out.println(rs.getFloat("factor"));
//                System.out.println(rs.getString("clave") + "   " + aux * 1.16 * 1.34 + "   " + rs.getFloat("precioCompra"));
                listaArticulos.add(artiNue);
            }

        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            try {
                if (link != null) {
                    link.close();
                }
            } catch (SQLException sqle) {
                JOptionPane.showMessageDialog(null, "Error al cerrar la conexion");
            }
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

        } finally {
            try {
                if (link != null) {
                    link.close();
                }
            } catch (SQLException sqle) {
                JOptionPane.showMessageDialog(null, "Error al cerrar la conexion");
            }
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

            String ejecuto = "insert into dentitodo.categoria (dentitodo.categoria.name) value('" + categoria + "');";
            result = ejecuto;
            st = link.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
            st.execute(result);
            System.out.println(" se guardo correctamente");
            status = true;

        } catch (Exception ex) {
            System.out.println("Error en consulta");
            JOptionPane.showMessageDialog(null, ex);
            status = false;

        } finally {
            try {
                if (link != null) {
                    link.close();
                }
            } catch (SQLException sqle) {
                JOptionPane.showMessageDialog(null, "Error al cerrar la conexion");
            }
        }
        return status;

    }

    public boolean InsertaEmi(String nombre, String rfc, String direccion, String tipo) {
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

            String ejecuto = "insert into  dentitodo.emisor (dentitodo.emisor.Nombre,dentitodo.emisor.rfc,dentitodo.emisor.Direccion,dentitodo.emisor.tipo) value ('" + nombre + "','" + rfc + "','" + direccion + "','" + tipo + "')";
            result = ejecuto;
            st = link.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
            st.execute(result);
            System.out.println(" se guardo correctamente");
            status = true;

        } catch (Exception ex) {
            System.out.println("Error en consulta");
            JOptionPane.showMessageDialog(null, ex);
            status = false;

        } finally {
            try {
                if (link != null) {
                    link.close();
                }
            } catch (SQLException sqle) {
                JOptionPane.showMessageDialog(null, "Error al cerrar la conexion");
            }
        }
        return status;

    }

    public boolean Consultatem(String folio, String nombre, String rfc, String fechaCompra, String fechaFactura, String estado,
            String tipo, String Facturado, double subTotal, double ivaTotal, double total) {
        boolean status = false;
        String result = " ";
        Connection link = null;

//        Conectar(user,pass);
        if ("OK".equals(estado)) {

        }

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
                    + "'" + estado + "','" + tipo + "','" + Facturado + "','" + subTotal + "','" + ivaTotal + "','" + total + "')";
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

        } finally {
            try {
                if (link != null) {
                    link.close();
                }
            } catch (SQLException sqle) {
                JOptionPane.showMessageDialog(null, "Error al cerrar la conexion");
            }
        }
        return status;

    }

}
