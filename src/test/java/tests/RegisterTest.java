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





    @Test
    public void registerNewAcountWithSuccess(){

        RegisterUser registerUser = new RegisterUser(getDriver()); 

        registerUser.registerNewAcount(email, name, password, password);

    }

    @Test
    public void registerNewAcountWithSuccessAddBalance(){

        RegisterUser registerUser = new RegisterUser(getDriver()); 

        registerUser.registerNewAcount("email@email.com", "Fulano", "123456", "123456");

    }







    
}
