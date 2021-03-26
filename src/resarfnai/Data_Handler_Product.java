/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package resarfnai;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * @author Ian Fraser
 * Date: 28/03/2020
 * Description: EPOS System Assessment - Ian Fraser - Product Data Handler
 */

public class Data_Handler_Product {
     
      public Product returnProduct(String input)
    {
        Product empty = new Product();

        try
        {
            // Open access to the database
            Connection con=Database_Utilities.getConnection();
            Statement stmt = con.createStatement();

            // Creates SQL query and reads return
            String SQLStatement = "SELECT * FROM Products WHERE Fruit= '" + input + "'";
            ResultSet rs = stmt.executeQuery (SQLStatement);
            rs.next();
            
            Product fruit = new Product(rs.getString("Fruit"), rs.getDouble("Price"));
            
            return fruit;
        }
            catch (SQLException error)
        {
            System.out.println("[*] Products entry error");
                System.out.println("SQL exception occured\n" + error);
        }
        return empty;
    }   // End of Method
      
       public ArrayList<String> productList()
    {
        ArrayList<String> productList = new ArrayList();
        
          try 
            {
                Connection con=Database_Utilities.getConnection();
                Statement stmt = con.createStatement();
                
                // Creates SQL query and reads return
                String SQLStatement = "SELECT * FROM Products";
                ResultSet rs = stmt.executeQuery (SQLStatement);
                
                while (rs.next()) 
                {
                    String product = rs.getString("ID") + " - " + rs.getString("Fruit") + " £" + rs.getString("Price") + "\n";
                    productList.add(product);
                }
                return productList;
            }
         catch(SQLException error)
            {
                System.out.println("[*] Products entry error");
                System.out.println("SQL exception occured\n" + error);
            }
          return productList;
    }   // End of Method
      
        public void createProduct(Product product)
    {
         try
            {
                // Open access to the database
                Connection con=Database_Utilities.getConnection();
                Statement stmt = con.createStatement();

                // Creates SQL query adds to database
                String SQLStatement = "INSERT INTO Products (Fruit, Price) VALUES ('" 
                + product.getFruitName()    + "', '" 
                + product.getFruitPrice()   + "')";
                stmt.executeUpdate(SQLStatement);
            }
            catch (Exception error)
            {
                System.out.println("[*] Product entry error");
                System.out.println("SQL exception occured\n" + error);
            }
    }   // End of Method
       
        public void updateProduct(Product product, int productID)
    {
         try
            {
                // Open access to the database
                Connection con=Database_Utilities.getConnection();
                Statement stmt = con.createStatement();
                
                // Creates SQL query adds to database
                String SQLStatement = "UPDATE Products SET Fruit = '" + product.getFruitName()
                + "', Price = '" + product.getFruitPrice()
                + "' WHERE ID = " + productID;
                stmt.executeUpdate(SQLStatement);

            }
            catch (Exception error)
            {
                System.out.println("[*] Product entry error");
                System.out.println("SQL exception occured\n" + error);
            }
    }   // End of Method
        
        public void deleteProduct(int productID)
    {
          try
            {
                // Open access to the database
                Connection con=Database_Utilities.getConnection();
                Statement stmt = con.createStatement();

                // Creates SQL query deletes from database
                String SQLStatement = "DELETE FROM Products WHERE ID = '" + productID + "'";
                stmt.executeUpdate(SQLStatement);

            }
            catch (Exception error)
            {
                System.out.println("[*] Product entry error");
                System.out.println("SQL exception occured\n" + error);
            }
    }   // End of Method
        
}
