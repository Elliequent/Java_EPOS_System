/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package resarfnai;

/**
 * @author Ian Fraser
 * Date: 27/03/2020
 * Description: EPOS System Assessment - Ian Fraser - User object
 */

public class User {
    
    
// Attributes
    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private boolean manager;
    
    
// Setters
public void setName(String firstNameIn)
{
    if (!firstNameIn.equals(""))
    {
        this.firstName = firstNameIn;
    }
}
     
public void setlastName(String lastNameIn)
{
    if (!lastNameIn.equals(""))
    {
        this.lastName = lastNameIn;
    }
} 
   
public void setUsername(String usernameIn)
{
    if (!usernameIn.equals(""))
    {
        this.username = usernameIn;
    }
} 

public void setPassword(String passwordIn)
{
    if (!passwordIn.equals(""))
    {
        this.password = passwordIn;
    }
} 

public void setManager(boolean managerIn)
{
        this.manager = managerIn;
} 


// Getters
public String getfirstName()
{
    return this.firstName;
}

public String getlastName()
{
    return this.lastName;
}

public String getUsername()
{
    return this.username;
}

public String getPassword()
{
    return this.password;
}

public boolean getManager()
{
    return this.manager;
}

// Constructer - 0 Parameters
public User()
{
    firstName = "";
    lastName = "";
    username = "";
    password = "";
    manager = false;
}

// Constructor - 5 Parameters
public User(String fristNameIn, String lastNameIn, String usernameIn, String passwordIn, boolean managerIn)
{
    firstName = fristNameIn;
    lastName = lastNameIn;
    username = usernameIn;
    password = passwordIn;
    manager = managerIn;
}

}   // End of User Class
