/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package resarfnai;

/**
 * @author Ian Fraser
 * Date: 28/03/2020
 * Description: EPOS System Assessment - Ian Fraser - Sales object
 */

import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class Sale {
    
    DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
    
    // Attributes
    int staffID;
    int productID;
    int quantity;
    Date date;
    
    // Getters
    public int getStaffID()
    {
        return staffID;
    }
    
    public int getProductID()
    {
        return productID;
    }
    
    public int getQuantity()
    {
        return quantity;
    }
    
    public Date getDate()
    {
        return date;
    }
    
    // Setters
    public void setStaffID(int staffIDIn)
    {
        staffID = staffIDIn;
    }
    
    public void setProductID(int productIDIn)
    {
        productID = productIDIn;
    }
    
    public void setQuantity(int quantityIn)
    {
        quantity = quantityIn;
    }
    
    public void setDate(Date dateIn)
    {
        date = dateIn;
    }
    
    // Constructor - 0 Parameters
    public Sale()
    {
        staffID = 0;
        productID = 0;
        quantity = 0;
        date = new Date();
    }
    
    // Constructor - 4 Parameters
    public Sale(int staffIDIn, int productIDIn, int quantityIn, Date dateIn)
    {
        staffID = staffIDIn;
        productID = productIDIn;
        quantity = quantityIn;
        date = dateIn;
    }
}
