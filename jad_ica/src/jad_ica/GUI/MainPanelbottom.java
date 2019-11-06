/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jad_ica.GUI;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import jad_ica.furnitureCollection.*;
import java.awt.BorderLayout;
import java.util.ArrayList;
import javax.swing.JComboBox;

/**
 *
 * @author t7047098
 */
public class MainPanelbottom extends JPanel implements ActionListener
{
    JButton[] menuOptions = new JButton[3];
    ArrayList <Furniture> arr;
    
    public MainPanelbottom(ArrayList <Furniture> arr)
    {
        this.setLayout(new GridLayout(1,3));
        this.arr = arr;
        
        menuOptions[0] = new JButton("Total");
        menuOptions[1] = new JButton("Load");
        menuOptions[2] = new JButton("Cart");
        
        for (int i = 0; i < 3; i++) 
        {
            this.add(menuOptions[i],i);
            menuOptions[i].addActionListener(this);
        }       
    }

    @Override
    public void actionPerformed(ActionEvent e) 
    {
        JFrame menuButtons = new JFrame();
        String saveFile = "";
        
        if (e.getSource() == menuOptions[0]) 
        {
            int total = 0;
            
            for (int i = 0; i < arr.size(); i++) 
            {
                total += arr.get(i).getItemPrice();
            }
            
            double totalPound = (double) total / 100;
            Double write = totalPound;
            
            JOptionPane.showMessageDialog(null,"Total Price = £" + write.toString() , "Total Price", JOptionPane.OK_OPTION);
        }
        else if (e.getSource() == menuOptions[1]) 
        {   
            menuButtons.setLayout(new GridLayout(2,1));
            menuButtons.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            menuButtons.setSize(600,600);
            menuButtons.setVisible(true);
            LoadPanelTop loadTop = new LoadPanelTop(saveFile);
            LoadPanelBottom loadBottom = new LoadPanelBottom(saveFile,arr,menuButtons);     
            menuButtons.add(loadTop,0);
            menuButtons.add(loadBottom,1);
        }
        else
        {
            menuButtons.setLayout(new BorderLayout());
            menuButtons.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            menuButtons.setSize(600,600);
            menuButtons.setVisible(true);
            CartPanelTop cartTop = new CartPanelTop();
            CartPanelMiddle cartMiddle = new CartPanelMiddle(arr);
            CartPanelBottom cartBottom = new CartPanelBottom(arr,menuButtons);
            menuButtons.add(cartTop,BorderLayout.NORTH);
            menuButtons.add(cartMiddle,BorderLayout.CENTER);
            menuButtons.add(cartBottom,BorderLayout.SOUTH);
        }
    }
}
