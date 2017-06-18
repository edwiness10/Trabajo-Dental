/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.awt.Color;
import java.awt.Component;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class MiRender extends DefaultTableCellRenderer
{
@Override
public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,int row,int column)
{

super.getTableCellRendererComponent (table, value, isSelected, hasFocus, row, column);

if(isSelected)
{
this.setOpaque(true);
this.setBackground(Color.RED);
this.setForeground(Color.BLUE);
}
else
{
this.setOpaque(true);
this.setBackground(Color.WHITE);
this.setForeground(Color.BLACK);

}
// JOptionPane.showMessageDialog(null,"position");


return this;
}
}
