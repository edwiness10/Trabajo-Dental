/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dent.clases;

import com.dent.Int.IntOnline;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 *
 * @author Edwin
 */
public class AutoOnline {

    public List<String[]> online = new ArrayList();
    public List<String[]> villa = new ArrayList();
    public ArrayList<Articulo> listaOnline = new ArrayList();
    public ArrayList<Articulo> listaVilla = new ArrayList();

    public void ProseOnline(String archivoCSV) {
        String Entra = archivoCSV;
        StringTokenizer st = new StringTokenizer(Entra, "~\n");

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
                    } else {
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
            online.add(articulo);
        }
    }

    public void ProseVilla(String archivoVilla) {
        String Entra = archivoVilla;
        StringTokenizer st = new StringTokenizer(Entra, "\n\t");
        String aux2;
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

    public String Resulta(int op) {
        String[] articulo2 = {"", "", ""};
        String sale = "";
        if (op == 0) {
            for (int i = 0; i < villa.size(); i++) {
                articulo2 = villa.get(i);

                for (int j = 0; j < articulo2.length; j++) {
                    sale = sale + articulo2[j] + "\t";
                }
                sale = sale + "\n";
            }

        } else if (op == 1) {
            for (int i = 0; i < online.size(); i++) {
                articulo2 = online.get(i);

                for (int j = 0; j < articulo2.length; j++) {
                    sale = sale + articulo2[j] + "\t";
                }
                sale = sale + "\n";
            }
        }

        return sale;
    }

    public int ConvierteArtiVilla() {
        String[] articulo2 = {"", "", ""};
        String sale = "";

        listaVilla.clear();

        for (String[] villa1 : villa) {
            articulo2 = villa1;
            Articulo artiNue = new Articulo(articulo2[0], articulo2[1], Double.valueOf(articulo2[2]) * 1.05, 1);
            listaVilla.add(artiNue);
        }
        return listaVilla.size();
    }

    public int ConvierteArtiOnline() {
        String[] articulo2 = {"", "", ""};
        String sale = "";
        listaOnline.clear();

        for (String[] online1 : online) {
            articulo2 = online1;
            String aux = articulo2[2];
            if (aux == null || aux == "") {
                aux = "0";
            }
            Articulo artiNue = new Articulo(articulo2[0], articulo2[1], Double.valueOf(aux), 1);
            listaOnline.add(artiNue);
        }

        return listaOnline.size();
    }

    public boolean guardaArchivOnline() {
        boolean estado = true;
        FileWriter fichero = null;
        PrintWriter pw = null;
        try {
            fichero = new FileWriter("\\Facturas\\ArchivoSalida.csv");
            pw = new PrintWriter(fichero);

            System.out.println("si");
            pw.println("SKU~post_title~regular_price");

            for (int i = 0; i < IntOnline.listaSalida.size(); i++) {
                System.out.println(IntOnline.listaSalida.get(i).getCodigo() + "~\"" + IntOnline.listaSalida.get(i).getArticulo() + "\"~" + IntOnline.listaSalida.get(i).getValor() + "\n");
                pw.println(IntOnline.listaSalida.get(i).getCodigo() + "~" + IntOnline.listaSalida.get(i).getArticulo() + "~" + IntOnline.listaSalida.get(i).getValor() + "\n");
            }
        } catch (Exception e) {
            System.out.println("no se hixo" + e);
            estado = false;
        }

        try {
            if (null != fichero) {
                fichero.close();

            }
        } catch (Exception e2) {
            estado = false;
            System.out.println("no se hizo");

        }
        return estado;
    }

    public boolean guardaArchivNO() {
        boolean estado = true;
        FileWriter fichero = null;
        PrintWriter pw = null;
        try {
            fichero = new FileWriter("\\Facturas\\ArchivoNO.csv");
            pw = new PrintWriter(fichero);

            System.out.println("si");
            pw.println("SKU~post_title~regular_price");

            for (int i = 0; i < IntOnline.listaNO.size(); i++) {
                System.out.println(IntOnline.listaNO.get(i).getCodigo() + "~\"" + IntOnline.listaNO.get(i).getArticulo() + "\"~" + IntOnline.listaNO.get(i).getValor() + "\n");
                pw.println(IntOnline.listaNO.get(i).getCodigo() + "~" + IntOnline.listaNO.get(i).getArticulo() + "~" + IntOnline.listaNO.get(i).getValor() + "\n");
            }
        } catch (Exception e) {
            System.out.println("no se hixo" + e);
            estado = false;
        }

        try {
            if (null != fichero) {
                fichero.close();
            }
        } catch (Exception e2) {
            estado = false;
            System.out.println("no se hizo");
        }
        return estado;
    }

}
