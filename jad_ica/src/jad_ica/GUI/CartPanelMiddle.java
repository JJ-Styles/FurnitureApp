/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jad_ica.GUI;

import jad_ica.furnitureCollection.Furniture;
import java.awt.Component;
import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 *
 * @author t7047098
 */
public class CartPanelMiddle extends JPanel 
{
    ArrayList<Furniture> arr;
    ArrayList<Component> arr1 = new ArrayList<>();
    JScrollPane scrollBar = new JScrollPane();
    
    public CartPanelMiddle(ArrayList<Furniture> arr) 
    {
        this.arr = arr;
        this.setLayout(new GridLayout(arr.size(),2));
        this.setAutoscrolls(true);
        
        for (int i = 0; i < arr.size(); i++)
        {
            switch (arr.get(i).getClass().getSimpleName())
            {
                case "Chair":
                    arr1.add(new JLabel(new ImageIcon("Chair1.png")));
                    break;
                case "Table":
                    arr1.add(new JLabel(new ImageIcon("Table1.png")));
                    break;
                default:
                    arr1.add(new JLabel(new ImageIcon("Desk1.png")));
                    break;
            }
            
            arr1.add(new JTextArea(arr.get(i).toString()));    
        }
        
        for (int i = 0; i < (arr.size() * 2); i++) 
        {
            this.add(arr1.get(i),i);
            
            if (i % 2 == 1)
            {
                arr1.get(i).setEnabled(false);
            }
        }
    }
    
}
