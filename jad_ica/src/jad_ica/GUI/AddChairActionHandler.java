/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jad_ica.GUI;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JTextField;
import jad_ica.furnitureCollection.Chair;
import jad_ica.furnitureCollection.Furniture;
import jad_ica.furnitureCollection.Furniture.TypeOfWood;
import static java.lang.Integer.parseInt;
import javax.swing.JFrame;
import javax.swing.JRadioButton;

/**
 *
 * @author t7047098
 */
public class AddChairActionHandler implements ActionListener 
{
    ArrayList <Furniture> arr;
    Chair newChair = new Chair();
    JTextField id;
    JRadioButton tow1;
    JTextField quantity;
    JRadioButton armrest1;
    JFrame addItemFrame;
    
    public AddChairActionHandler(ArrayList<Component> arr1, ArrayList<Furniture> arr, JFrame addItemFrame) 
    {   
        this.arr = arr;
        this.addItemFrame = addItemFrame;
        
        id = (JTextField) arr1.get(1);
        tow1 = (JRadioButton) arr1.get(4);
        quantity = (JTextField) arr1.get(7);
        armrest1 = (JRadioButton) arr1.get(10);
    }

    @Override
    public void actionPerformed(ActionEvent e) 
    {
        for (int i = 0; i < parseInt(quantity.getText());i++)
        {
            newChair.setIdNumber(id.getText());

            if (tow1.isSelected())
            {
                newChair.setWood(TypeOfWood.Walnut);
            }
            else
            {
                newChair.setWood(TypeOfWood.oak);
            }

            if (armrest1.isSelected()) 
            {
                newChair.setArmrests(true);
            }
            else
            {
                newChair.setArmrests(false);
            }

            newChair.calculatePrice();
            arr.add(newChair);
        }
        addItemFrame.dispose();
    }
    
}
