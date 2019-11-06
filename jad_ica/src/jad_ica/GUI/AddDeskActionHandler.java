/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jad_ica.GUI;

import jad_ica.furnitureCollection.Desk;
import jad_ica.furnitureCollection.Furniture;
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
public class AddDeskActionHandler implements ActionListener 
{
    ArrayList <Furniture> arr;
    Desk newDesk = new Desk();
    JTextField id;
    JTextField width;
    JTextField depth;
    JRadioButton tow;
    JTextField quantity;
    JRadioButton noOfDraws1;
    JRadioButton noOfDraws2;
    JRadioButton noOfDraws3;
    JFrame addItemFrame;
    
    public AddDeskActionHandler(ArrayList<Component> arr1, ArrayList<Furniture> arr, JFrame addItemFrame) 
    {
        this.arr = arr;
        this.addItemFrame = addItemFrame;
        
        id = (JTextField) arr1.get(1);
        tow = (JRadioButton) arr1.get(4);
        quantity = (JTextField) arr1.get(7);
        noOfDraws1 = (JRadioButton) arr1.get(10);
        noOfDraws2 = (JRadioButton) arr1.get(11);
        noOfDraws3 = (JRadioButton) arr1.get(13);
        width = (JTextField) arr1.get(16);
        depth = (JTextField) arr1.get(19);
    }

    @Override
    public void actionPerformed(ActionEvent e) 
    {
        for (int i = 0; i < parseInt(quantity.getText()); i++)
        {
            newDesk.setIdNumber(id.getText());
            newDesk.setWidth(parseInt(width.getText()));
            newDesk.setDepth(parseInt(depth.getText()));

            if (tow.isSelected())
            {
                newDesk.setWood(Furniture.TypeOfWood.Walnut);
            }
            else
            {
                newDesk.setWood(Furniture.TypeOfWood.oak);
            }

            if (noOfDraws1.isSelected())
            {
                newDesk.setNoOfDraws(1);
            }
            else if (noOfDraws2.isSelected())
            {
                newDesk.setNoOfDraws(2);
            }
            else if (noOfDraws3.isSelected())
            {
                newDesk.setNoOfDraws(3);
            }
            else
            {
                newDesk.setNoOfDraws(4);
            }

            newDesk.calculatePrice();
            arr.add(newDesk);
        }
        addItemFrame.dispose();
    }
    
}
