/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dent.dato;

import java.io.Serializable;

/**
 *
 * @author lanix
 */
public class Nodo implements Serializable
{
    private final static long serialVersionUID =1L;
    private int claveI = 0;
    private Object obj;
    private String claveS = "";
    private Nodo siguiente = null;


    public Nodo(int claveI, Object obj) {
        this.claveI = claveI;
        this.obj = obj;
    }

    public Nodo(Object obj, String claveS) {
        this.obj = obj;
        this.claveS = claveS;
    }
    
    public int getClaveI() {
        return claveI;
    }
    
    public void setClaveI(int claveI) {
        this.claveI = claveI;
    }
    public Object getObj() {
        return obj;
    }
    public void setObj(Object obj) {
        this.obj = obj;
    }
    public String getClaveS() {
        return claveS;
    }
    public void setClaveS(String claveS) {
        this.claveS = claveS;
    }
    public Nodo getSiguiente() {
        return siguiente;
    }
    public void setSiguiente(Nodo siguiente) {
        this.siguiente = siguiente;
    }    
}