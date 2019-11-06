/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jad_ica.GUI;

import jad_ica.furnitureCollection.Furniture;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author t7047098
 */
public class MainMouseHandler implements MouseListener 
{
    private JLabel label;
    private int index;
    ArrayList <Furniture> arr;

    public MainMouseHandler(ImageIcon image, int i, ArrayList <Furniture> arr) 
    {
        this.label = new JLabel(image);
        this.index = i;
        this.arr = arr;
    }
    
    @Override
    public void mouseClicked(MouseEvent e) 
    {
        JFrame addItemFrame = new JFrame("AddItem");
        addItemFrame.setLayout(new GridLayout(1,2));
        addItemFrame.add(label,0);
        addItemFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        addItemFrame.setSize(800,600);
        AddItemPanelRight rightPanel = new AddItemPanelRight(index, arr,addItemFrame);
        addItemFrame.add(rightPanel);
        addItemFrame.setVisible(true);
    }

    @Override
    public void mousePressed(MouseEvent e) 
    {
    }

    @Override
    public void mouseReleased(MouseEvent e) 
    {
    }

    @Override
    public void mouseEntered(MouseEvent e) 
    {
    }

    @Override
    public void mouseExited(MouseEvent e) 
    {
    }
    
}
