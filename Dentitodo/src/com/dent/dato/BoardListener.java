/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dent.dato;
import java.awt.Toolkit;
import java.awt.datatransfer.*;
import java.io.IOException;

import java.awt.datatransfer.ClipboardOwner;

/**
 *
 * @author Ventas
 */
public class BoardListener implements ClipboardOwner{
     
    public String getClipboard()
    {
        // Obtenemos el contenido del portapapeles del sistema.
        Transferable t = Toolkit.getDefaultToolkit().getSystemClipboard().getContents(null);
        try
        {
            // Comprobamos que la información sea de tipo cadena, lo recuperamos y lo devolvemos.
            if (t != null && t.isDataFlavorSupported(DataFlavor.stringFlavor))
            {
                String text = (String) t.getTransferData(DataFlavor.stringFlavor);
                return text;
            }
        }
        catch (UnsupportedFlavorException | IOException e)
        {
        }
        // Si lo copiado no es un texto, devolvemos null
        return null;
    }
 
    // Método que inserta en el portapapeles una cadena.
     public void setClipboard(String str)
    {
        StringSelection ss = new StringSelection(str);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, this);
     }
 
    // Necesario para poder implementar la interfaz ClipboardOwner. Para nosotros no tendrá uso, pero es obligatorio "implementarlo".
     @Override
     public void lostOwnership(Clipboard clipboard, Transferable contents)
    {
        // TODO Auto-generated method stub
    }
}
