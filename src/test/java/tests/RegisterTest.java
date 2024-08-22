package tests;


import org.junit.jupiter.api.Test;

import utils.RegisterUser;

public class RegisterTest extends Setup{

    @Test
    public void registerNewAcountWithSuccess(){

        RegisterUser registerUser = new RegisterUser(getDriver()); 

        registerUser.registerNewAcount("email@email.com", "Fulano", "123456", "123456");

        

    }

    @Test
    public void registerNewAcountWithSuccessAddBalance(){

        RegisterUser registerUser = new RegisterUser(getDriver()); 

        registerUser.registerNewAcount("email@email.com", "Fulano", "123456", "123456");

    }







    
}
