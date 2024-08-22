package tests;


import java.util.Locale;

import org.junit.jupiter.api.Test;

import com.github.javafaker.Faker;
import com.github.javafaker.service.FakeValuesService;
import com.github.javafaker.service.RandomService;

import utils.RegisterUser;

public class RegisterTest extends Setup{

    Faker faker = new Faker(); 

    FakeValuesService fakeValuesService = new FakeValuesService(
      new Locale("en-GB"), new RandomService());

    String email = fakeValuesService.bothify("????##@gmail.com");
    String name = faker.name().fullName();
    String password = fakeValuesService.regexify("[a-z1-9]{10}");
    String passwordDifferente = fakeValuesService.regexify("[a-z1-9]{10}");



    @Test
    public void testShouldRegisterNewAcountWithSuccess(){

        RegisterUser registerUser = new RegisterUser(getDriver()); 

        registerUser.registerNewAcount(email, name, password, password);

    }

    @Test
    public void testShouldRegisterNewAcountWithSuccessAddBalance(){

        RegisterUser registerUser = new RegisterUser(getDriver()); 

        registerUser.registerNewAcount(email, name, password, password);

    }

    @Test
    public void testShouldNotRegisterWithIncompleteFieldEmail(){

        RegisterUser registerUser = new RegisterUser(getDriver()); 

        registerUser.registerNewAcount("", name, password, password);
        
    }
    @Test
    public void testShouldNotRegisterWithIncompleteFieldPassword(){

        RegisterUser registerUser = new RegisterUser(getDriver()); 
        
        registerUser.registerNewAcount(email, name, "" , password);


    }
    @Test
    public void testShouldNotRegisterWithIncompleteFieldPasswordConfirmation(){

        RegisterUser registerUser = new RegisterUser(getDriver()); 
    
        registerUser.registerNewAcount(email, name, password, "");

    }

    @Test
    public void testShouldNotRegisterWithIncompleteFieldName(){

        RegisterUser registerUser = new RegisterUser(getDriver()); 
    
        registerUser.registerNewAcount(email, "", password, password);

    }

    @Test
    public void testShouldNotRegisterWithDifferentPassword(){

        RegisterUser registerUser = new RegisterUser(getDriver()); 
    
        registerUser.registerNewAcount(email, name, password, passwordDifferente);

    }

    
}
