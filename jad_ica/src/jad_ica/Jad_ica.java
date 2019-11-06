/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jad_ica;

import jad_ica.GUI.MainPanelTop;
import jad_ica.GUI.MainPanelbottom;
import jad_ica.furnitureCollection.Furniture;
import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.JFrame;

/**
 *
 * @author t7047098
 */
public class Jad_ica
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        ArrayList <Furniture> arr = new ArrayList<>();
        JFrame mainFrame = new JFrame("Main");
        mainFrame.setLayout(new GridLayout(2,1));
        MainPanelTop panel = new MainPanelTop(arr);
        MainPanelbottom panel1 = new MainPanelbottom(arr);
        mainFrame.add(panel,0);  
        mainFrame.add(panel1,1);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.pack();
        mainFrame.setVisible(true);
    }
    
}
