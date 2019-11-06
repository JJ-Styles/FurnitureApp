/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jad_ica.GUI;

import jad_ica.furnitureCollection.*;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author t7047098
 */
public class MainPanelTop extends JPanel
{
    ArrayList <ImageIcon> list = new ArrayList<>();
    ArrayList <JLabel> labelList = new ArrayList<>();

    public MainPanelTop(ArrayList<Furniture> arr) 
    {
        list.add(new ImageIcon("Chair1.png"));
        list.add(new ImageIcon("Table1.png"));
        list.add(new ImageIcon("Desk1.png"));
        
        this.setLayout(new GridLayout(1,3));
        
        for (int i = 0; i < 3; i++) 
        {
            labelList.add(new JLabel(list.get(i)));
            this.add(labelList.get(i),i);
            labelList.get(i).addMouseListener(new MainMouseHandler(list.get(i),i,arr));
        }
    }
}
