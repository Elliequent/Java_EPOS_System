/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package resarfnai;

/**
 * @author Ian Fraser
 * Date: 28/03/2020
 * Description: EPOS System Assessment - Ian Fraser - Product object
 */

public class Product {
    
    // Attributes
    String fruitName;
    double fruitPrice;
    
    // Getters
    public String getFruitName()
    {
        return fruitName;
    }
    
    public double getFruitPrice()
    {
        return fruitPrice;
    }
    
    // Setters
    public void setFruitName(String fruitNameIn)
    {
        fruitName = fruitNameIn;
    }
    
    public void setFruitPrice(double fruitPriceIn)
    {
        fruitPrice = fruitPriceIn;
    }
    
    // Constructor - 0 Paramaters
    public Product()
    {
        fruitName = " ";
        fruitPrice = 0;
    }
    
    // Constructor - 2 Paramaters
    public Product(String fruitNameIn, double fruitPriceIn)
    {
        fruitName = fruitNameIn;
        fruitPrice = fruitPriceIn;
    }
    
}
