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
public class Articulo {
    
    private String Codigo;
    private String Articulo;
    private double Valor; 
    private double Cantidad;

    public Articulo(String Codigo, String Articulo, double Valor, double Cantidad) {
        this.Codigo = Codigo;
        this.Articulo = Articulo;
        this.Valor = Valor;
        this.Cantidad = Cantidad;
    }

    public String getCodigo() {
        return Codigo;
    }

    public void setCodigo(String Codigo) {
        this.Codigo = Codigo;
    }

    public String getArticulo() {
        return Articulo;
    }

    public void setArticulo(String Articulo) {
        this.Articulo = Articulo;
    }

    public double getValor() {
        return Valor;
    }

    public void setValor(double Valor) {
        this.Valor = Valor;
    }

    public double getCantidad() {
        return Cantidad;
    }

    public void setCantidad(double Cantidad) {
        this.Cantidad = Cantidad;
    }
     

}
