/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jad_ica.GUI;

import jad_ica.furnitureCollection.Chair;
import jad_ica.furnitureCollection.Furniture;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author t7047098
 */
public class LoadPanelBottom extends JPanel implements ActionListener
{
    JButton[] buttons = new JButton[2];
    String saveFile;
    ArrayList<Furniture> arr;
    JFrame menuButtons;
    
    public LoadPanelBottom(String saveFile, ArrayList<Furniture> arr, JFrame menuButtons) 
    {
        this.saveFile = saveFile;
        this.arr = arr;
        this.menuButtons = menuButtons;
        
        buttons[0] = new JButton("Load");
        buttons[1] = new JButton("Cancel");
        this.setLayout(new GridLayout(1,2));
        for (int i = 0; i < 2; i++) 
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
            if (arr.isEmpty())
            {
                loadFile();
                //menuButtons.dispose();
            }
            else
            {
                int answer = JOptionPane.showConfirmDialog(null, "Are You Show You want to override contents of the order", "Load", JOptionPane.YES_NO_OPTION);

                if (answer == JOptionPane.YES_OPTION)
                {
                    arr.clear();
                    loadFile();
                    //menuButtons.dispose();
                }   
            }
        }
        else
        {
            int answer = JOptionPane.showConfirmDialog(null, "Are You Show You want to cancel", "Cancelation", JOptionPane.OK_CANCEL_OPTION);
        
            if (answer == JOptionPane.OK_OPTION)
            {
                menuButtons.dispose();
            }
        }
    }
    
    private void loadFile()
    {
        try
        {
           FileInputStream fis = new FileInputStream(saveFile + ".dat");        // This is still not picking up the name. this is due to miss referencing somewhere
           ObjectInputStream ois = new ObjectInputStream(fis); 
           ArrayList<Furniture> arr1 = (ArrayList<Furniture>) ois.readObject();
           
           for (int i = 0; i < arr1.size(); i++)
           {
               arr.add(arr1.get(i));
           }
           
           ois.close();
           fis.close();
           JOptionPane.showMessageDialog(null,"The File loaded Successfully" , "Load Successful", JOptionPane.OK_OPTION);
        }
        catch (Exception e)
        {
            JOptionPane.showMessageDialog(null, e.getStackTrace() , "Error", JOptionPane.OK_OPTION);
        }
        finally
        {       
            menuButtons.dispose();
        }
        
    }
    
}
