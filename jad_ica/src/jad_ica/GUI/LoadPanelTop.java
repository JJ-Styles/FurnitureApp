/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jad_ica.GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JComboBox;
import javax.swing.JPanel;

/**
 *
 * @author t7047098
 */
public class LoadPanelTop extends JPanel implements ActionListener
{
    JComboBox saveFiles;
    String saveFile;
    
    public LoadPanelTop(String saveFile) 
    {       
        ArrayList<String> fileNames = new ArrayList<>();
        this.saveFile = saveFile;
        
        try
        {
            FileReader fr = new FileReader("filenames.txt");
            Scanner input = new Scanner(fr); 
            
            while(input.hasNext())
            {
                fileNames.add(input.next());
            }
            fr.close();
            input.close();
        }
        catch (Exception e)
        {
            System.out.println(e.toString());
        }
        
        String[] fileN = new String[fileNames.size()];
        
        for (int i = 0; i < fileNames.size(); i++)
        {
            fileN[i] = fileNames.get(i);
        }
        
        saveFiles = new JComboBox(fileN);
        saveFiles.setSelectedIndex(fileN.length -1);
        this.add(saveFiles);
        saveFiles.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) 
    {
        saveFile = saveFiles.getSelectedItem().toString();
    }
    
}
