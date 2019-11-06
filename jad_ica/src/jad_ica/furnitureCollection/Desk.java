/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jad_ica.furnitureCollection;

import java.io.Serializable;
import javax.swing.ImageIcon;

/**
 *
 * @author t7047098
 */
public class Desk extends Furniture implements Serializable
{
    private final int height = 800;
    private final int pricePerDraw = 850;
    private int width;
    private int depth;
    private int noOfDraws;

    public Desk() 
    {
        super();
        width = 0;
        depth = 0;
        noOfDraws = 0;
        calculatePrice();
    }

    public Desk(int width, int depth, int noOfDraws, String idNumber) 
    {
        super(idNumber,new ImageIcon("Desk1.png"));
        this.width = width;
        this.depth = depth;
        this.noOfDraws = noOfDraws;
        calculatePrice();
    }

    public Desk(String idNumber) 
    {
        super(idNumber, new ImageIcon("Desk1.png"));
        width = 0;
        depth = 0;
        noOfDraws = 0;
        calculatePrice();
    }

    public Desk(int width, int depth, int noOfDraws) 
    {
        super();
        this.width = width;
        this.depth = depth;
        this.noOfDraws = noOfDraws;
        calculatePrice();
    }

    public int getWidth() 
    {
        return width;
    }

    public void setWidth(int width) 
    {
        this.width = width;
    }

    public int getDepth() 
    {
        return depth;
    }

    public void setDepth(int depth) 
    {
        this.depth = depth;
    }

    public int getNoOfDraws() 
    {
        return noOfDraws;
    }

    public void setNoOfDraws(int noOfDraws) 
    {
        this.noOfDraws = noOfDraws;
    }
  
    @Override
    public void calculatePrice() 
    {
        if (getWood() == TypeOfWood.Walnut)
            setItemPrice((((height + width + depth) * 12) + (depth * width) * 3) + (noOfDraws * 850));
        else if (getWood() == TypeOfWood.oak)
            setItemPrice((((height + width + depth) * 12) + (depth * width) * 4) + (noOfDraws * 850));
        else
            setItemPrice(0);
    }

    @Override
    public int calculateNoOfUnit() 
    {
        throw new UnsupportedOperationException("Method Should not be used"); 
    }
    
    @Override
    public String toString()
    {
       return "ID Number = " + getIdNumber() + "\n Desk \n Item Price = £" + (double) getItemPrice()/100; 
    }
}
