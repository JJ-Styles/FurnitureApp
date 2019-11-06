/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jad_ica.GUI;

import jad_ica.furnitureCollection.Furniture;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Hazel
 */
public class CartMouseHandler implements MouseListener
{
    ArrayList<Furniture> arr;
    int index;

    public CartMouseHandler(ArrayList<Furniture> arr, int i)
    {
        this.arr = arr;
        this.index = i;
    }
    

    @Override
    public void mouseClicked(MouseEvent me)
    {
        switch (me.getButton()) {
            case MouseEvent.BUTTON1:
                JOptionPane.showMessageDialog(null, arr.get(index).toString() + "\n" + arr.get(index).getItemPrice() , "Details", JOptionPane.OK_OPTION);
                break;
            case MouseEvent.BUTTON2:
                updateItem();
                break;
            case MouseEvent.BUTTON3:
                removeItem();
                break;
            default:
                break;
        }
    }

    @Override
    public void mousePressed(MouseEvent me)
    {
    }

    @Override
    public void mouseReleased(MouseEvent me)
    {
    }

    @Override
    public void mouseEntered(MouseEvent me)
    {
    }

    @Override
    public void mouseExited(MouseEvent me)
    {
    }

    private void updateItem() 
    {
        
    }

    private void removeItem() 
    {
        
    }
    
}
