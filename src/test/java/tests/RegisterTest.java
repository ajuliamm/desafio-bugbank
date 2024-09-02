package tests;

import org.junit.jupiter.api.Test;

import com.bugbank.tests.clients.ClientFake;

import utils.RegisterUser;

public class RegisterTest extends Setup{

    


    @Test
    public void testShouldRegisterNewAcountWithSuccess(){

        ClientFake clientFake = new ClientFake(false); 


        RegisterUser registerUser = new RegisterUser(getDriver()); 

        registerUser.registerNewAcount(clientFake.getEmail(), clientFake.getName(), clientFake.getPassword(), clientFake.getPassword(), clientFake.isAddBalance());

    }

    @Test
    public void testShouldRegisterNewAcountWithSuccessAddBalance(){

        ClientFake clientFake = new ClientFake(true); 


        RegisterUser registerUser = new RegisterUser(getDriver()); 

        registerUser.registerNewAcount(clientFake.getEmail(), clientFake.getName(), clientFake.getPassword(), clientFake.getPassword(), clientFake.isAddBalance());

    }

    @Test
    public void testShouldNotRegisterWithIncompleteFieldEmail(){
        ClientFake clientFake = new ClientFake(false); 


        RegisterUser registerUser = new RegisterUser(getDriver()); 

        registerUser.registerNewAcount("", clientFake.getName(), clientFake.getPassword(), clientFake.getPassword(), clientFake.isAddBalance());
        
    }
    @Test
    public void testShouldNotRegisterWithIncompleteFieldPassword(){

        ClientFake clientFake = new ClientFake(false); 


        RegisterUser registerUser = new RegisterUser(getDriver()); 
        
        registerUser.registerNewAcount(clientFake.getEmail(), clientFake.getName(), "", clientFake.getPassword(), clientFake.isAddBalance());


     }

    @Test
    public void testShouldNotRegisterWithIncompleteFieldPasswordConfirmation(){
        ClientFake clientFake = new ClientFake(false); 


        RegisterUser registerUser = new RegisterUser(getDriver()); 
    
        registerUser.registerNewAcount(clientFake.getEmail(), clientFake.getName(), clientFake.getPassword(), clientFake.getPassword(), clientFake.isAddBalance());

    }

    @Test
    public void testShouldNotRegisterWithIncompleteFieldName(){

        ClientFake clientFake = new ClientFake(false); 


        RegisterUser registerUser = new RegisterUser(getDriver()); 
    
        registerUser.registerNewAcount(clientFake.getEmail(), "", clientFake.getPassword(), clientFake.getPassword(), clientFake.isAddBalance());

    }

    @Test
    public void testShouldNotRegisterWithDifferentPassword(){

        ClientFake clientFake = new ClientFake(false); 
        String passwordDiferent = "senhaErrada";


        RegisterUser registerUser = new RegisterUser(getDriver()); 
    
        registerUser.registerNewAcount(clientFake.getEmail(), clientFake.getName(), clientFake.getPassword(), passwordDiferent, clientFake.isAddBalance());

    }

    
}
