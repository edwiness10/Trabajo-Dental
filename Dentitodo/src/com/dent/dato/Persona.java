/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dent.dato;

/**
 *
 * @author DELL
 */
 public class Persona{

    private int idPersona;

    private String nombre;

    private int altura;

 

    public Persona(int idPersona, String nombre, int altura) {

        this.idPersona = idPersona;

        this.nombre = nombre;

        this.altura = altura;}

 

    @Override

    public String toString() {

        return "Persona-> ID: "+getIdPersona()+" Nombre: "+getNombre()+" Altura: "+getAltura()+"\n";

    }

    /**
     * @return the idPersona
     */
    public int getIdPersona() {
        return idPersona;
    }

    /**
     * @param idPersona the idPersona to set
     */
    public void setIdPersona(int idPersona) {
        this.idPersona = idPersona;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the altura
     */
    public int getAltura() {
        return altura;
    }

    /**
     * @param altura the altura to set
     */
    public void setAltura(int altura) {
        this.altura = altura;
    }

}
