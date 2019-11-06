/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jad_ica.GUI;

import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author t7047098
 */
public class CartPanelTop extends JPanel 
{

    public CartPanelTop() 
    {
        JLabel title = new JLabel("Cart");
        title.setFont(new Font(title.getFont().getName(), Font.BOLD, 30));
        this.add(title);
    }
    
}
