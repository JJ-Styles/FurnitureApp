/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jad_ica.GUI;

import jad_ica.furnitureCollection.Furniture;
import jad_ica.furnitureCollection.Table;
import jad_ica.furnitureCollection.Table.TypeOfBase;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static java.lang.Integer.parseInt;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

/**
 *
 * @author t7047098
 */
public class AddTableActionHandler implements ActionListener 
{
    ArrayList <Furniture> arr;
    Table newTable = new Table();
    JTextField id;
    JTextField diameter;
    JRadioButton tow;
    JTextField quantity;
    JRadioButton base;
    JFrame addItemFrame;
    
    public AddTableActionHandler(ArrayList<Component> arr1, ArrayList<Furniture> arr, JFrame addItemFrame) 
    {
        this.arr = arr;
        this.addItemFrame = addItemFrame;
        
        id = (JTextField) arr1.get(1);
        tow = (JRadioButton) arr1.get(4);
        quantity = (JTextField) arr1.get(7);
        base = (JRadioButton) arr1.get(10);
        diameter = (JTextField) arr1.get(13);
    }

    @Override
    public void actionPerformed(ActionEvent e) 
    {
        for (int i = 0; i < parseInt(quantity.getText()); i++)
        {
            newTable.setIdNumber(id.getText());

            if (tow.isSelected())
            {
                newTable.setWood(Furniture.TypeOfWood.Walnut);
            }
            else
            {
                newTable.setWood(Furniture.TypeOfWood.oak);
            }

            if (base.isSelected()) 
            {
                newTable.setBase(TypeOfBase.Chrome);
            }
            else
            {
                newTable.setBase(TypeOfBase.Wooden);
            }

            newTable.calculateNoOfUnit();
            newTable.calculatePrice();
            arr.add(newTable);
        }
        addItemFrame.dispose();
    }
    
}
