package utils;

import org.openqa.selenium.WebDriver;

import Validations.RegisterValidation;
import pages.RegisterPage;

public class RegisterUser {

    WebDriver driver; 
    RegisterPage registerPage;
    RegisterValidation registerValidation;


    public RegisterUser(WebDriver driver) {
        this.driver = driver;
        registerPage = new RegisterPage(driver); 
        registerValidation = new RegisterValidation(driver);

    }

    public void registerNewAcount(String email, String name, String password, String passwordConfirmation){


        registerPage.getRegisterButton().click();
        registerPage.getEmailField().sendKeys(email);
        registerPage.getNameField().sendKeys(name);
        registerPage.getPasswordField().sendKeys(password);
        registerPage.getPasswordConfirmationField().sendKeys(passwordConfirmation);

        registerPage.getSubmitFormRegisterButton().click();

        if(email != "" && name != "" && password != "" && passwordConfirmation != "" && password == passwordConfirmation){
            registerValidation.validationNewAcountCreated();

        } else{
            registerValidation.validationRegisterFields(email, name, password, password); 
        }



        
    }

    public void registerNewAcountAddBalance(String email, String name, String password, String passwordConfirmation){

        registerPage.getRegisterButton().click();
        registerPage.getEmailField().sendKeys(email);
        registerPage.getNameField().sendKeys(name);
        registerPage.getPasswordField().sendKeys(password);
        registerPage.getPasswordConfirmationField().sendKeys(passwordConfirmation);
        registerPage.getAddBalanceToggle().click();

        registerPage.getSubmitFormRegisterButton().click();
        registerValidation.validationNewAcountCreated();
        
    }

    


}
