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
public class Chair extends Furniture implements Serializable
{
    private boolean armrests;
    private int noOfUnits;

    public Chair(boolean armrests) 
    {
        super();
        this.armrests = armrests;
        this.noOfUnits = calculateNoOfUnit();
        calculatePrice();
    }

    public Chair(boolean armrests,String idNumber) 
    {
        super(idNumber,new ImageIcon("Chair1.png"));
        this.armrests = armrests;
        this.noOfUnits = calculateNoOfUnit();
        calculatePrice();
    }

    public Chair() 
    {
        super();
        this.armrests = false;
        this.noOfUnits = 0;
    }

    public Chair(String idNumber) 
    {
        super(idNumber,new ImageIcon("Chair1.png"));
        this.armrests = false;
        this.noOfUnits = calculateNoOfUnit();
    }

    public boolean isArmrests() 
    {
        return armrests;
    }

    public void setArmrests(boolean armrests) 
    {
        this.armrests = armrests;
        noOfUnits = calculateNoOfUnit();
    }

    public int getNoOfUnits() 
    {
        return noOfUnits;
    }
    
    @Override
    public void calculatePrice()
    {
        if (getWood() == TypeOfWood.Walnut)
            setItemPrice(3 * noOfUnits);
        else if (getWood() == TypeOfWood.oak)
            setItemPrice(4 * noOfUnits);
        else
            setItemPrice(0);
    }

    @Override
    public int calculateNoOfUnit() 
    {
        if (armrests)
            return 1875;
        return 1625;
    }  
    
    @Override
    public String toString()
    {
       return "ID Number = " + getIdNumber() + "\n Chair \n Item Price = £" + (double) getItemPrice()/100; 
    }
}
