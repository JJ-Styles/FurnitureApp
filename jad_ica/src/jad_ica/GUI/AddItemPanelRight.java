/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jad_ica.GUI;

import jad_ica.furnitureCollection.Furniture;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

/**
 *
 * @author t7047098
 */
public class AddItemPanelRight extends JPanel implements ActionListener
{
    JFrame addItemFrame;
    ArrayList<Component> arr1 = new ArrayList<>();
    ArrayList <Furniture> arr;
    JRadioButton[] check = new JRadioButton[6];
    ButtonGroup[] menu = new ButtonGroup[2];
    JButton[] buttons = new JButton[2];
    int index;

    public AddItemPanelRight(int index,ArrayList <Furniture> arr, JFrame addItemFrame) 
    {
        this.index = index;
        this.arr = arr;
        this.addItemFrame = addItemFrame;
        
        switch (index)
        {
            case 0:
                generateChairPanel();
                break;
            case 1:
                generateTablePanel();
                break;
            case 2:
                generateDeskPanel();
                break;
        }
            
    } 
    
    private void generateChairPanel()
    {
        
        arr1.add(new JLabel("ID Number: "));
        arr1.add(new JTextField());
        arr1.get(1).setSize(new Dimension(1,1));
        arr1.get(1).setMaximumSize(new Dimension(1,1));
        arr1.get(1).setPreferredSize(new Dimension(1,1));
        arr1.add(new JLabel());
        arr1.add(new JLabel("Type Of Wood: "));
        
        check[0] = new JRadioButton("Walnut");
        check[1] = new JRadioButton("Oak");
        check[2] = new JRadioButton("Yes");
        check[3] = new JRadioButton("No");
        
        for (int i = 0; i < 2; i++) 
        {
            menu[i] = new ButtonGroup();
        }
        
        menu[0].add(check[0]);
        menu[0].add(check[1]);
        menu[1].add(check[2]);
        menu[1].add(check[3]);
        
        arr1.add(check[0]);
        arr1.add(check[1]);
        arr1.add(new JLabel("Quantity: "));
        arr1.add(new JTextField());
        arr1.get(7).setPreferredSize(new Dimension(50,100));
        arr1.add(new JLabel());
        arr1.add(new JLabel("Armrests: "));
        arr1.add(check[2]);
        arr1.add(check[3]);
        buttons[0] = new JButton("Add");
        buttons[1] = new JButton("Cancel");
        
        this.setLayout(new GridLayout(5,3));
        
        for (int i = 0; i < 12; i++) 
        {
            this.add(arr1.get(i),i);
        }
        
        this.add(buttons[0],12);
        this.add(buttons[1],13);
        
        buttons[0].addActionListener(new AddChairActionHandler(arr1,arr, addItemFrame));
        buttons[1].addActionListener(this);   
    }

    private void generateTablePanel() 
    {
        arr1.clear();
        arr1.add(new JLabel("ID Number: "));
        arr1.add(new JTextField());
        arr1.get(1).setPreferredSize(new Dimension(50,100));
        arr1.add(new JLabel());
        arr1.add(new JLabel("Type Of Wood: "));
        
        check[0] = new JRadioButton("Walnut");
        check[1] = new JRadioButton("Oak");
        check[2] = new JRadioButton("Chrome");
        check[3] = new JRadioButton("Wooden");
        
        for (int i = 0; i < 2; i++) 
        {
            menu[i] = new ButtonGroup();
        }
        
        menu[0].add(check[0]);
        menu[0].add(check[1]);
        menu[1].add(check[2]);
        menu[1].add(check[3]);
        
        arr1.add(check[0]);
        arr1.add(check[1]);
        arr1.add(new JLabel("Quantity: "));
        arr1.add(new JTextField());
        arr1.get(7).setPreferredSize(new Dimension(50,100));
        arr1.add(new JLabel());
        arr1.add(new JLabel("Base: "));
        arr1.add(check[2]);
        arr1.add(check[3]);
        arr1.add(new JLabel("Diameter (in mm): "));
        arr1.add(new JTextField());
        arr1.get(13).setPreferredSize(new Dimension(50,100));
        arr1.add(new JLabel());
        buttons[0] = new JButton("Add");
        buttons[1] = new JButton("Cancel");
        
        this.setLayout(new GridLayout(6,3));
        
        for (int i = 0; i < 15; i++) 
        {
            this.add(arr1.get(i),i);
        }
        
        this.add(buttons[0],15);
        this.add(buttons[1],16);
        
        buttons[0].addActionListener(new AddTableActionHandler(arr1,arr,addItemFrame));
        buttons[1].addActionListener(this);
    }

    private void generateDeskPanel() 
    {
        arr1.clear();
        arr1.add(new JLabel("ID Number: "));
        arr1.add(new JTextField());
        arr1.get(1).setPreferredSize(new Dimension(50,100));
        arr1.add(new JLabel());
        arr1.add(new JLabel("Type Of Wood: "));
        
        check[0] = new JRadioButton("Walnut");
        check[1] = new JRadioButton("Oak");
        check[2] = new JRadioButton("1");
        check[3] = new JRadioButton("2");
        check[4] = new JRadioButton("3");
        check[5] = new JRadioButton("4");
        
        for (int i = 0; i < 2; i++) 
        {
            menu[i] = new ButtonGroup();
        }
        
        menu[0].add(check[0]);
        menu[0].add(check[1]);
        menu[1].add(check[2]);
        menu[1].add(check[3]);
        menu[1].add(check[4]);
        menu[1].add(check[5]);
        
        arr1.add(check[0]);
        arr1.add(check[1]);
        arr1.add(new JLabel("Quantity: "));
        arr1.add(new JTextField());
        arr1.get(7).setPreferredSize(new Dimension(50,100));
        arr1.add(new JLabel());
        arr1.add(new JLabel("No. Of Draws: "));
        arr1.add(check[2]);
        arr1.add(check[3]);
        arr1.add(new JLabel());
        arr1.add(check[4]);
        arr1.add(check[5]);
        arr1.add(new JLabel("Width (in mm): "));
        arr1.add(new JTextField());
        arr1.get(16).setPreferredSize(new Dimension(50,100));
        arr1.add(new JLabel());
        arr1.add(new JLabel("Depth (in mm): "));
        arr1.add(new JTextField());
        arr1.get(19).setPreferredSize(new Dimension(50,100));
        arr1.add(new JLabel());
        buttons[0] = new JButton("Add");
        buttons[1] = new JButton("Cancel");
        
        this.setLayout(new GridLayout(8,3));
        
        for (int i = 0; i < 21; i++) 
        {
            this.add(arr1.get(i),i);
        }
        
        this.add(buttons[0],21);
        this.add(buttons[1],22);
        
        buttons[0].addActionListener(new AddDeskActionHandler(arr1,arr,addItemFrame));
        buttons[1].addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) 
    {
        int answer = JOptionPane.showConfirmDialog(null, "Are You Show You want to cancel", "Cancelation", JOptionPane.OK_CANCEL_OPTION);
        
        if (answer == JOptionPane.OK_OPTION)
        {
            addItemFrame.dispose();
        }
    }
}
