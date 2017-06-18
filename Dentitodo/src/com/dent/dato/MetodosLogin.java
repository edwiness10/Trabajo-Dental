/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dent.dato;



import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author Edwin
 */
public class MetodosLogin {
    

Pool metodospool = new Pool() {};

public int validar_ingreso(String usuario, String clave){

//    String usuario = usuario;
//    String clave = String.valueOf(Login.jpassClave.getPassword());

    int resultado=0;
    
    String SSQL="SELECT * FROM usuarios WHERE usuario='"+usuario+"' AND clave=sha1('"+clave+"')";

    Connection conect = null;

    try {
   
        conect = metodospool.dataSource.getConnection();
        Statement st = conect.createStatement();
        ResultSet rs = st.executeQuery(SSQL);

        if(rs.next()){

            resultado=1;

        }

    } catch (SQLException ex) {

        JOptionPane.showMessageDialog(null, ex, "Error de conexión", JOptionPane.ERROR_MESSAGE);

    }finally{


        try {

            conect.close();

        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, ex, "Error de desconexión", JOptionPane.ERROR_MESSAGE);

        }

    }

return resultado;

}

}