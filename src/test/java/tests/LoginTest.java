package tests;

import java.util.Locale;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.github.javafaker.Faker;
import com.github.javafaker.service.FakeValuesService;
import com.github.javafaker.service.RandomService;

import Validations.LoginValidation;
import utils.LoginUser;
import utils.RegisterUser;

public class LoginTest extends Setup{

    Faker faker = new Faker(); 
    FakeValuesService fakeValuesService = new FakeValuesService(new Locale("en-GB"), new RandomService());

    String email = fakeValuesService.bothify("????##@gmail.com");
    String emailNonExistent = fakeValuesService.bothify("????##@gmail.com");

    String name = faker.name().fullName();
    String password = fakeValuesService.regexify("[a-z1-9]{10}");
    String passwordDifferente = fakeValuesService.regexify("[a-z1-9]{10}");

    @Test
    public void testShouldLoginWithSuccess(){
        
        RegisterUser registerUser = new RegisterUser(getDriver());
        registerUser.registerNewAcount(email, name, password, password);
        
        LoginUser loginUser = new LoginUser(getDriver());
        loginUser.LoginAccount(email, password);

        LoginValidation loginValidation = new LoginValidation(getDriver());
        loginValidation.validationLogIn(name);

        String urlAtual = getDriver().getCurrentUrl();
        Assertions.assertEquals(URL_BASE+"home", urlAtual);

    }

    @Test
    public void testShouldNotLoginInvalidUser(){
        
        RegisterUser registerUser = new RegisterUser(getDriver());
        registerUser.registerNewAcount(email, name, password, password);
        
        LoginUser loginUser = new LoginUser(getDriver());
        loginUser.LoginAccount(emailNonExistent, password);

        String urlAtual = getDriver().getCurrentUrl();
        Assertions.assertEquals(URL_BASE, urlAtual);

        LoginValidation loginValidation = new LoginValidation(getDriver());
        loginValidation.validationInvalidLogin(email, emailNonExistent, password, password);;

        

    }

    @Test
    public void testShouldNotLoginInvalidPassword(){
        
        RegisterUser registerUser = new RegisterUser(getDriver());
        registerUser.registerNewAcount(email, name, password, password);
        
        LoginUser loginUser = new LoginUser(getDriver());
        loginUser.LoginAccount(email, passwordDifferente);

        String urlAtual = getDriver().getCurrentUrl();
        Assertions.assertEquals(URL_BASE, urlAtual);

        LoginValidation loginValidation = new LoginValidation(getDriver());
        loginValidation.validationInvalidLogin(email, email, password, passwordDifferente);

    }

    @Test
    public void testShouldNotLoginWithBlankFieldEmail(){

        RegisterUser registerUser = new RegisterUser(getDriver());
        registerUser.registerNewAcount(email, name, password, password);
        
        LoginUser loginUser = new LoginUser(getDriver());
        loginUser.LoginAccount("", password);

        String urlAtual = getDriver().getCurrentUrl();
        Assertions.assertEquals(URL_BASE, urlAtual);

        LoginValidation loginValidation = new LoginValidation(getDriver());
        loginValidation.validationInvalidLogin(email, "", password, password);
    }

    @Test
    public void testShouldNotLoginWithBlankFieldPassword(){

        RegisterUser registerUser = new RegisterUser(getDriver());
        registerUser.registerNewAcount(email, name, password, password);
        
        LoginUser loginUser = new LoginUser(getDriver());
        loginUser.LoginAccount(email, "");

        String urlAtual = getDriver().getCurrentUrl();
        Assertions.assertEquals(URL_BASE, urlAtual);

        LoginValidation loginValidation = new LoginValidation(getDriver());
        loginValidation.validationInvalidLogin(email, email, password, "");
    }

}
