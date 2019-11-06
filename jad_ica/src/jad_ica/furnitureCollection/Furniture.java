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
public abstract class Furniture implements Serializable
{
    private String idNumber;
    private Integer itemPrice;
    private ImageIcon image;
    private TypeOfWood wood;
    
    public enum TypeOfWood
    {
        Walnut,oak;
    }

    public Furniture()
    {
        idNumber = null;
        itemPrice = 0;
        image = null;
        wood = null;
    }

    public Furniture(String idNumber, ImageIcon image)
    {
        this.idNumber = idNumber;
        this.image = image;
    }

    public String getIdNumber()
    {
        return idNumber;
    }

    public void setIdNumber(String idNumber)
    {
        this.idNumber = idNumber;
    }

    public int getItemPrice()
    {
        return itemPrice;
    }

    public void setItemPrice(int itemPrice)
    {
        this.itemPrice = itemPrice;
    }

    public ImageIcon getImage()
    {
        return image;
    }

    public void setImage(ImageIcon image)
    {
        this.image = image;
    }

    public TypeOfWood getWood() 
    {
        return wood;
    }
    
    public void setWood(TypeOfWood wood) 
    {
        this.wood = wood;
    }
      
    abstract void calculatePrice();  
    
    abstract int calculateNoOfUnit();
}