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
 *
 * @author iFras
 */
public class Data_Handler_User {
    
     public User returnUser(String input)
     {
         User empty = new User();  // deafult user doesn't exist in database
         
        Database_Utilities.isDatabaseDriversExist(); // Check drivers are working

         try 
            {   // Checks username and manager status within database records - if not manager found then managerIsTrue remains false
                Connection con=Database_Utilities.getConnection();
                Statement stmt = con.createStatement();

                // Creates SQL query and reads return
                String SQLStatement = "SELECT * FROM Staff WHERE Username = '" + input + "'";
                ResultSet rs = stmt.executeQuery (SQLStatement);
                rs.next();
                    
                User user = new User(rs.getString("FirstName"), rs.getString("LastName"), rs.getString("Username"), rs.getString("Password"), rs.getBoolean("Manager"));
            
            return user;
            }
         catch(SQLException error) // Exception handling
            {
                System.out.println("[*] User entry error");
                System.out.println("SQL exception occured\n" + error);
            }
        return empty;
     }  // End of Method
    
     public boolean checkUserIsValid(User UserIn){   // Boolean check user details exist within database for login

        boolean userExistsInDatabase = false;  // deafult user doesn't exist in database
         
        Database_Utilities.isDatabaseDriversExist(); // Check drivers are working

         try 
            {   // Checks username and password again database records - if user not found then userExistsInDatabase remains false
                Connection con=Database_Utilities.getConnection();
                Statement stmt = con.createStatement();
                
                String username = UserIn.getUsername();
                String password = UserIn.getPassword();
                
                ResultSet rs = stmt.executeQuery ("SELECT * FROM Staff WHERE Username='" + username + "' AND " + " Password= '" + password + "'");
                while (rs.next()) 
                {        
                  userExistsInDatabase=true; // user records has been found in databse
                }
            }
         catch(SQLException error) // Exception handling
            {
                System.out.println("[*] User entry error");
                System.out.println("SQL exception occured\n" + error);
            }
    return (userExistsInDatabase);
    }   // End of Method
    
    public boolean checkIfManager(User UserIn)
    {
        boolean managerIsTrue = false;  // deafult user doesn't exist in database
         
        Database_Utilities.isDatabaseDriversExist(); // Check drivers are working

         try 
            {   // Checks username and manager status within database records - if not manager found then managerIsTrue remains false
                Connection con=Database_Utilities.getConnection();
                Statement stmt = con.createStatement();
                
                String username = UserIn.getUsername();
                
                ResultSet rs = stmt.executeQuery ("SELECT * FROM Staff WHERE Username='" + username + "'");
                while (rs.next())
                {   
                  String manager = rs.getString("Manager");
                  if (manager.equals("true"))
                  {
                      managerIsTrue=true; // Is Manager
                      return (managerIsTrue);
                  }
                }
            }
         catch(SQLException error) // Exception handling
            {
                System.out.println("[*] User entry error");
                System.out.println("SQL exception occured\n" + error);
            }
        return (managerIsTrue);
    }   // End of Method
    
    public ArrayList<String> returnUserList()
    {
        ArrayList<String> StaffList = new ArrayList();
        
        try {
             Connection con=Database_Utilities.getConnection();
             Statement stmt = con.createStatement();
                
             // Creates SQL query and reads return
             String SQLStatement = "SELECT * FROM Staff";
             ResultSet rs = stmt.executeQuery (SQLStatement);
             
             while (rs.next()) 
                {
                    String UserList = rs.getString("FirstName") + " " + rs.getString("LastName") + " - " + rs.getString("Username");
                    StaffList.add(UserList);
                }
             return StaffList;
        } catch (Exception error) {
            System.out.println("[*] User entry error");
            System.out.println("SQL exception occured\n" + error);
     
            return StaffList;
        }
    }   // End of Method
    
    public void createUser(User newuser)
    {
         try
            {
                // Open access to the database
                Connection con=Database_Utilities.getConnection();
                Statement stmt = con.createStatement();

                // Creates SQL query adds to database
                String SQLStatement = "INSERT INTO Staff (FirstName, LastName, Username, Password, Manager) VALUES ('" 
                + newuser.getfirstName() + "', '" 
                + newuser.getlastName()  + "', '" 
                + newuser.getUsername()  + "', '" 
                + newuser.getPassword()  + "', '" 
                + newuser.getManager()   + "')";
                stmt.executeUpdate(SQLStatement);
            }
            catch (Exception error)
            {
                System.out.println("[*] User entry error");
                System.out.println("SQL exception occured\n" + error);
            }
    }   // End of Method
    
    public void updateUser(User user)
    {
         try
            {
                // Open access to the database
                Connection con=Database_Utilities.getConnection();
                Statement stmt = con.createStatement();
                
                // Creates SQL query adds to database
                String SQLStatement = "UPDATE Staff SET FirstName = '" + user.getfirstName() 
                + "', LastName = '" + user.getlastName()
                + "', Username = '" + user.getUsername()
                + "', Password = '" + user.getPassword()
                + "', Manager = '"  + user.getManager()
                + "' WHERE Username = " + "'" + user.getUsername() + "'";
                stmt.executeUpdate(SQLStatement);

            }
            catch (Exception error)
            {
                System.out.println("[*] User entry error");
                System.out.println("SQL exception occured\n" + error);
            }
    }   // End of Method
    
    public void deleteUser(User user)
    {
          try
            {
                // Open access to the database
                Connection con=Database_Utilities.getConnection();
                Statement stmt = con.createStatement();

                // Creates SQL query deletes from database
                String SQLStatement = "DELETE FROM Staff WHERE Username = '" + user.getUsername() + "'";
                stmt.executeUpdate(SQLStatement);

            }
            catch (Exception error)
            {
                System.out.println("[*] User entry error");
                System.out.println("SQL exception occured\n" + error);
            }
    }   // End of Method
    
}
