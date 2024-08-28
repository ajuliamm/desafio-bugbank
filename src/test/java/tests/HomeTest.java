package tests;

import java.util.Locale;

import org.junit.jupiter.api.Test;

import com.github.javafaker.Faker;
import com.github.javafaker.service.FakeValuesService;
import com.github.javafaker.service.RandomService;

import Validations.HomeValidation;
import pages.HomePage;
import utils.LoginUser;
import utils.RegisterUser;

public class HomeTest extends Setup{
    Faker faker = new Faker(); 
    FakeValuesService fakeValuesService = new FakeValuesService(new Locale("en-GB"), new RandomService());

    String email = fakeValuesService.bothify("????##@gmail.com");
    String emailNonExistent = fakeValuesService.bothify("????##@gmail.com");

    String name = faker.name().fullName();
    String password = fakeValuesService.regexify("[a-z1-9]{10}");
    String passwordDifferente = fakeValuesService.regexify("[a-z1-9]{10}");

    

    @Test
    public void testShouldShowUserName(){
            
        RegisterUser registerUser = new RegisterUser(getDriver());
        boolean balance = false; 
        registerUser.registerNewAcount(email, name, password, password, balance);
        
        LoginUser loginUser = new LoginUser(getDriver());
        loginUser.LoginAccount(email, password);

        HomePage homePage = new HomePage(getDriver());
        homePage.getUserName();  

        HomeValidation homeValidation = new HomeValidation(getDriver());
        homeValidation.validationUserName(name);

    }

    @Test
    public void testShouldShowPositiveBalanceWhenAddBalance(){
            
        RegisterUser registerUser = new RegisterUser(getDriver());
        boolean balance = true; 
        registerUser.registerNewAcount(email, name, password, password, balance);
        
        LoginUser loginUser = new LoginUser(getDriver());
        loginUser.LoginAccount(email, password);

        HomePage homePage = new HomePage(getDriver());
        homePage.getUserName();  

        HomeValidation homeValidation = new HomeValidation(getDriver());
        homeValidation.validationBalance(balance);

    }

    @Test
    public void testShouldShowBalanceEqualZeroWhenNotAddBalance(){
            
        RegisterUser registerUser = new RegisterUser(getDriver());
        boolean balance = false; 
        registerUser.registerNewAcount(email, name, password, password, balance);
        
        LoginUser loginUser = new LoginUser(getDriver());
        loginUser.LoginAccount(email, password);

        HomePage homePage = new HomePage(getDriver());
        homePage.getUserName();  

        HomeValidation homeValidation = new HomeValidation(getDriver());
        homeValidation.validationBalance(balance);

    }

}