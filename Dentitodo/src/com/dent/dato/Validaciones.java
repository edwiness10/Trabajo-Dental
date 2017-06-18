/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dent.dato;

import java.awt.event.KeyEvent;

/**
 *
 * @author Sala_C_01
 */
public class Validaciones {

    public static void alfabetico(KeyEvent evt) {
        if ((evt.getKeyChar() < 'a' || evt.getKeyChar() > 'z') && (evt.getKeyChar() < 'A' || evt.getKeyChar() > 'Z')
                && evt.getKeyChar() != 'á' && evt.getKeyChar() != 'é' && evt.getKeyChar() != 'í' && evt.getKeyChar() != 'ó'
                && evt.getKeyChar() != 'ú' && evt.getKeyChar() != 'Á' && evt.getKeyChar() != 'É' && evt.getKeyChar() != 'Í'
                && evt.getKeyChar() != 'Ó' && evt.getKeyChar() != 'Ú' && evt.getKeyChar() != 'ñ' && evt.getKeyChar() != 'Ñ'
                && evt.getKeyCode() != 8 && evt.getKeyChar() != ' ') {
            evt.setKeyChar((char) 8);
        }
    }

    public static void numerico(KeyEvent evt) {
        if ((evt.getKeyChar() < '0' || evt.getKeyChar() > '9') && evt.getKeyCode() != 8) {
            evt.setKeyChar((char) 8);
        }
    }

    public static void alfanumerico(KeyEvent evt) {
        if ((evt.getKeyChar() < 'a' || evt.getKeyChar() > 'z') && (evt.getKeyChar() < 'A' || evt.getKeyChar() > 'Z')
                && evt.getKeyChar() != 'á' && evt.getKeyChar() != 'é' && evt.getKeyChar() != 'í' && evt.getKeyChar() != 'ó'
                && evt.getKeyChar() != 'ú' && evt.getKeyChar() != 'Á' && evt.getKeyChar() != 'É' && evt.getKeyChar() != 'Í'
                && evt.getKeyChar() != 'Ó' && evt.getKeyChar() != 'Ú' && evt.getKeyChar() != 'ñ' && evt.getKeyChar() != 'Ñ'
                && evt.getKeyCode() != 8 && evt.getKeyChar() != ' ' && (evt.getKeyChar() < '0' || evt.getKeyChar() > '9'
                && evt.getKeyChar() != '!' )) {
            evt.setKeyChar((char) 8);
        }
    }

    public static void direccion(KeyEvent evt) {
        if ((evt.getKeyChar() < 'a' || evt.getKeyChar() > 'z') && (evt.getKeyChar() < 'A' || evt.getKeyChar() > 'Z')
                && evt.getKeyChar() != 'á' && evt.getKeyChar() != 'é' && evt.getKeyChar() != 'í' && evt.getKeyChar() != 'ó'
                && evt.getKeyChar() != 'ú' && evt.getKeyChar() != 'Á' && evt.getKeyChar() != 'É' && evt.getKeyChar() != 'Í'
                && evt.getKeyChar() != 'Ó' && evt.getKeyChar() != 'Ú' && evt.getKeyChar() != 'ñ' && evt.getKeyChar() != 'Ñ'
                && evt.getKeyCode() != 8 && evt.getKeyChar() != ' ' && (evt.getKeyChar() < '0' || evt.getKeyChar() > '9')
                && evt.getKeyChar() != '#' && evt.getKeyChar() != '.' && evt.getKeyChar() != ',') {
            evt.setKeyChar((char) 8);
        }
    }

    public static void horario(KeyEvent evt) {
        if ((evt.getKeyChar() < '0' || evt.getKeyChar() > '9') && evt.getKeyChar() != '-' && evt.getKeyChar() != ':') {
            evt.setKeyChar((char) 8);
        }
    }
    

    public static void correo(KeyEvent evt, String correo) {
        int c;
        if ((evt.getKeyChar() < 'a' || evt.getKeyChar() > 'z') && (evt.getKeyChar() < 'A' || evt.getKeyChar() > 'Z')
                && (evt.getKeyChar() < '0' || evt.getKeyChar() > '9') && evt.getKeyChar() != '.' && evt.getKeyChar() != '-'
                && evt.getKeyChar() != '_' && evt.getKeyCode() != 8 && evt.getKeyChar() != '@') {
            evt.setKeyChar((char) 8);
        }
        
    }
    
    
}
