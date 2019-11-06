/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jad_ica.GUI;

import jad_ica.furnitureCollection.Furniture;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author t7047098
 */
public class CartPanelBottom extends JPanel implements ActionListener
{
    JButton[] buttons = new JButton[3];
    JFrame menuButtons;
    ArrayList<Furniture> arr;

    CartPanelBottom(ArrayList<Furniture> arr, JFrame menuButtons) 
    {
        this.arr = arr;
        this.menuButtons = menuButtons;
        
        buttons[0] = new JButton("Home");
        buttons[1] = new JButton("Clear");
        buttons[2] = new JButton("Save");
        
        this.setLayout(new GridLayout(1,3));
        
        for (int i = 0; i < 3; i++) 
        {
            this.add(buttons[i],i);
            buttons[i].addActionListener(this);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) 
    {
        if (e.getSource() == buttons[0])
        {
            menuButtons.dispose();
        }
        else if (e.getSource() == buttons[1])
        {
            int answer = JOptionPane.showConfirmDialog(null, "Are You Show You want to cancel the order", "Cancelation", JOptionPane.OK_CANCEL_OPTION);
        
            if (answer == JOptionPane.OK_OPTION)
            {
                arr.clear();
                menuButtons.dispose();
            }
        }
        else
        {
            saveFile();
        }
    }
    
    private void saveFile()
    {
        String answer = JOptionPane.showInputDialog(null, "Please enter a filename.");
        Scanner inDialog = new Scanner(answer);
        String choice = inDialog.nextLine();
        
        try
        {
           FileWriter fw = new FileWriter("filenames.txt",true);
           fw.write(choice +  "\n");
           fw.close();
           FileOutputStream fos = new FileOutputStream(choice + ".dat",false);
           ObjectOutputStream oos = new ObjectOutputStream(fos); 
           oos.writeObject(arr);
           oos.close();
           fos.close();
        }
        catch (Exception e)
        {
            System.out.println(e.toString());
        }  
        menuButtons.dispose();
    }
    
}
