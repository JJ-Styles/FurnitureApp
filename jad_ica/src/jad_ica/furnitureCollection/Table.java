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
public class Table extends Furniture implements Serializable
{
    private TypeOfBase base;
    private int noOfUnits;
    private int diameter;

    public enum TypeOfBase
    {
        Wooden,Chrome
    }

    public Table() 
    {
        super();
        base = null;
        diameter = 0;
        noOfUnits = calculateNoOfUnit();   
        calculatePrice();
    }

    public Table(TypeOfBase base, int diameter, String idNumber) 
    {
        super(idNumber,new ImageIcon("Table1.png"));
        this.base = base;
        this.diameter = diameter;
        this.noOfUnits = calculateNoOfUnit();
        calculatePrice();
    }

    public Table(String idNumber, int quantity) 
    {
        super(idNumber, new ImageIcon("Table1.png"));
        base = null;
        diameter = 0;
        noOfUnits = calculateNoOfUnit();
    }

    public Table(TypeOfBase base, int diameter) 
    {
        super();
        this.base = base;
        this.diameter = diameter;
        this.noOfUnits = calculateNoOfUnit(); 
    }

    public TypeOfBase getBase() 
    {
        return base;
    }

    public void setBase(TypeOfBase base) 
    {
        this.base = base;
    }

    public int getNoOfUnits()
    {
        return noOfUnits;
    }

    public int getDiameter() 
    {
        return diameter;
    }

    public void setDiameter(int diameter) 
    {
        this.diameter = diameter;
        noOfUnits = calculateNoOfUnit(); 
    }
 
    @Override
    public void calculatePrice() 
    {
        if (getWood() == TypeOfWood.Walnut && base == TypeOfBase.Wooden)
            setItemPrice((3 * calculateNoOfUnit()) + 4500);
        else if (getWood() == TypeOfWood.oak && base == TypeOfBase.Wooden)
            setItemPrice((4 * calculateNoOfUnit()) + 4500);
        else if (getWood() == TypeOfWood.oak && base == TypeOfBase.Chrome)
            setItemPrice((4 * calculateNoOfUnit()) + 3500);
        else if (getWood() == TypeOfWood.Walnut && base == TypeOfBase.Chrome)
            setItemPrice((3 * calculateNoOfUnit()) + 3500);
        else
            setItemPrice(0);
    }

    @Override
    public int calculateNoOfUnit() 
    {
        return diameter * diameter;
    }
    
    @Override
    public String toString()
    {
       return "ID Number = " + getIdNumber() + "\n Table \n Item Price = £" + (double) getItemPrice()/100; 
    }
}
