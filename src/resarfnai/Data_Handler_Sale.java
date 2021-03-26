/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package resarfnai;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

/**
 * @author Ian Fraser
 * Date: 28/03/2020
 * Description: EPOS System Assessment - Ian Fraser - Sales Data Handler
 */

public class Data_Handler_Sale {
    
    public void insertInToSales(User username, double total)
    {
         try 
            {
                Connection con=Database_Utilities.getConnection();
                Statement stmt = con.createStatement();
                
                // Date formating
                String pattern = "dd-MM-yyyy";
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
                
                // SQL inputs
                String user = username.getUsername();
                String now = simpleDateFormat.format(new Date());
                
                // SQL Text
                String mySql = "INSERT INTO Sales";
                mySql = mySql +  ("(Username, Date, Total) ");
                mySql = mySql +  ("VALUES (") ;
                mySql = mySql +  ("'" +    user      + "',") ;
                mySql = mySql +  ("'" +    now       + "',") ;
                mySql = mySql +  (         total           ) ;
                mySql = mySql +  (")") ;     
                System.out.println("the sql  - " + mySql);
                stmt.executeUpdate(mySql);

                System.out.println("[+] Added to sales database successfully");
            }
         catch(SQLException error)
            {
                System.out.println("[*] Sales entry error");
                System.out.println("SQL exception occured\n" + error);
            }
    }   // End of method
 
    public ArrayList<String> userSalesRecord(String username)
    {
        ArrayList<String> salesRecord = new ArrayList();
        
          try 
            {
                Connection con=Database_Utilities.getConnection();
                Statement stmt = con.createStatement();
                
                // Creates SQL query and reads return
                String SQLStatement = "SELECT * FROM Sales WHERE Username= '" + username + "'";
                ResultSet rs = stmt.executeQuery (SQLStatement);
                
                while (rs.next()) 
                {
                    if (rs.getString("Date").equals(datecheck()))
                    {
                         String salesList = rs.getString("ID") + " - " 
                                 + rs.getString("Username") + " : " 
                                 + rs.getString("Date") + " £" 
                                 + rs.getString("Total") + "\n";
                        salesRecord.add(salesList);
                    }
                }
                return salesRecord;
            }
         catch(SQLException error)
            {
                System.out.println("[*] Sales entry error");
                System.out.println("SQL exception occured\n" + error);
            }
          return salesRecord;
    }   // End of Method
    
    public ArrayList<String> managerSalesRecord(String username)
    {
        ArrayList<String> salesRecord = new ArrayList();
        
          try 
            {
                Connection con=Database_Utilities.getConnection();
                Statement stmt = con.createStatement();
                
                // Creates SQL query and reads return
                String SQLStatement = "SELECT * FROM Sales WHERE Username= '" + username + "'";
                ResultSet rs = stmt.executeQuery (SQLStatement);
                
                while (rs.next()) 
                {
                    String salesList = rs.getString("ID") + " - " 
                        + rs.getString("Username") + " : " 
                        + rs.getString("Date") + " £" 
                        + rs.getString("Total") + "\n";
                    salesRecord.add(salesList);
                }
                return salesRecord;
            }
         catch(SQLException error)
            {
                System.out.println("[*] Sales entry error");
                System.out.println("SQL exception occured\n" + error);
            }
          return salesRecord;
    }   // End of Method
    
    public ArrayList<Double> salesFigures(String username)
    {
        ArrayList<Double> salesFigures = new ArrayList();
        
        try 
            {
                Connection con=Database_Utilities.getConnection();
                Statement stmt = con.createStatement();
                
                // Creates SQL query and reads return
                String SQLStatement = "SELECT * FROM Sales WHERE Username= '" + username + "'";
                ResultSet rs = stmt.executeQuery (SQLStatement);
                
                while (rs.next()) 
                {
                    String sales = rs.getString("Total");
                    double salesList = Double.parseDouble(sales);
                    salesFigures.add(salesList);
                }
                return salesFigures;
            }
         catch(SQLException error)
            {
                System.out.println("[*] Sales entry error");
                System.out.println("SQL exception occured\n" + error);
            }
          return salesFigures;
    }   // End of Method
    
    public void deleteSales(int saleID)
    {
         try 
            {
                Connection con=Database_Utilities.getConnection();
                Statement stmt = con.createStatement();
                
                // Creates SQL query and reads return
                String SQLStatement = "DELETE FROM Sales WHERE ID = '" + saleID + "'";
                stmt.executeUpdate(SQLStatement);
            }
         catch(SQLException error)
            {
                System.out.println("[*] Sales deletion error");
                System.out.println("SQL exception occured\n" + error);
            }
    }   // End of Method
    
    public void deleteSalesRecord(String username)
    {
        try 
            {
                Connection con=Database_Utilities.getConnection();
                Statement stmt = con.createStatement();
                
                // Creates SQL query and reads return
                String SQLStatement = "DELETE FROM Sales WHERE Username = '" + username + "'";
                stmt.executeUpdate(SQLStatement);
            }
         catch(SQLException error)
            {
                System.out.println("[*] Sales deletion error");
                System.out.println("SQL exception occured\n" + error);
            }
    }   // End of Method
    
    public String datecheck() // Checks todays date to displays user sales data
      {
            String pattern = "dd-MM-yyyy";
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
            
            String date = simpleDateFormat.format(new Date());   
            
            return date;
      } // End of Method
    
}

