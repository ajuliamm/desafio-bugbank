package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.bugbank.tests.clients.ClientFake;

import validations.LoginValidation;
import utils.LoginUser;
import utils.RegisterUser;

public class LoginTest extends Setup{


    @Test
    public void testShouldLoginWithSuccess(){

        ClientFake clientFake = new ClientFake(false); 

        
        RegisterUser registerUser = new RegisterUser(getDriver());
        
        registerUser.registerNewAcount(clientFake.getEmail(), clientFake.getName(), clientFake.getPassword(), clientFake.getPassword(), clientFake.isAddBalance());
        
        LoginUser loginUser = new LoginUser(getDriver());
        loginUser.LoginAccount(clientFake.getEmail(), clientFake.getPassword());

        LoginValidation loginValidation = new LoginValidation(getDriver());
        loginValidation.validationLogIn(clientFake.getName());

        String urlAtual = getDriver().getCurrentUrl();
        Assertions.assertEquals(URL_BASE+"home", urlAtual);

    }

    @Test
    public void testShouldNotLoginInvalidUser(){

        ClientFake clientFake = new ClientFake(false); 
        String emailNonExistent = "emailInexistente@gmail.com";

        
        RegisterUser registerUser = new RegisterUser(getDriver());
        registerUser.registerNewAcount(clientFake.getEmail(), clientFake.getName(), clientFake.getPassword(), clientFake.getPassword(), clientFake.isAddBalance());
        
        LoginUser loginUser = new LoginUser(getDriver());
        loginUser.LoginAccount(emailNonExistent, clientFake.getPassword());

        String urlAtual = getDriver().getCurrentUrl();
        Assertions.assertEquals(URL_BASE, urlAtual);

        LoginValidation loginValidation = new LoginValidation(getDriver());
        loginValidation.validationInvalidLogin(clientFake.getEmail(), emailNonExistent, clientFake.getPassword(), clientFake.getPassword());;

        

    }

    @Test
    public void testShouldNotLoginInvalidPassword(){

        ClientFake clientFake = new ClientFake(false); 
        String passwordDifferent = "senhaErrada";

        
        RegisterUser registerUser = new RegisterUser(getDriver());
        registerUser.registerNewAcount(clientFake.getEmail(), clientFake.getName(), clientFake.getPassword(), clientFake.getPassword(), clientFake.isAddBalance());
        
        LoginUser loginUser = new LoginUser(getDriver());
        loginUser.LoginAccount(clientFake.getEmail(), passwordDifferent);

        String urlAtual = getDriver().getCurrentUrl();
        Assertions.assertEquals(URL_BASE, urlAtual);

        LoginValidation loginValidation = new LoginValidation(getDriver());
        loginValidation.validationInvalidLogin(clientFake.getEmail(), clientFake.getEmail(), clientFake.getPassword(), passwordDifferent);

    }

    @Test
    public void testShouldNotLoginWithBlankFieldEmail(){
        ClientFake clientFake = new ClientFake(false); 


        RegisterUser registerUser = new RegisterUser(getDriver());
        registerUser.registerNewAcount(clientFake.getEmail(), clientFake.getName(), clientFake.getPassword(), clientFake.getPassword(), clientFake.isAddBalance());
        
        LoginUser loginUser = new LoginUser(getDriver());
        loginUser.LoginAccount("", clientFake.getPassword());

        String urlAtual = getDriver().getCurrentUrl();
        Assertions.assertEquals(URL_BASE, urlAtual);

        LoginValidation loginValidation = new LoginValidation(getDriver());
        loginValidation.validationInvalidLogin(clientFake.getEmail(), "", clientFake.getPassword(), clientFake.getPassword());
    }

    @Test
    public void testShouldNotLoginWithBlankFieldPassword(){

        ClientFake clientFake = new ClientFake(false); 


        RegisterUser registerUser = new RegisterUser(getDriver());
        registerUser.registerNewAcount(clientFake.getEmail(), clientFake.getName(), clientFake.getPassword(), clientFake.getPassword(), clientFake.isAddBalance());
        
        LoginUser loginUser = new LoginUser(getDriver());
        loginUser.LoginAccount(clientFake.getEmail(), "");

        String urlAtual = getDriver().getCurrentUrl();
        Assertions.assertEquals(URL_BASE, urlAtual);

        LoginValidation loginValidation = new LoginValidation(getDriver());
        loginValidation.validationInvalidLogin(clientFake.getEmail(), clientFake.getEmail(), clientFake.getPassword(), "");
    }

}
