package utils;

import org.openqa.selenium.WebDriver;

import pages.RegisterPage;

public class ClearFields {
    WebDriver driver; 
    RegisterPage registerPage;

    public ClearFields(WebDriver driver) {
        this.driver = driver;
        registerPage = new RegisterPage(driver);
    }

    public void clearRegisterFields(){
        registerPage.getEmailField().clear();
        registerPage.getNameField().clear();
        registerPage.getPasswordConfirmationField().clear();
        registerPage.getPasswordField().clear();
    }


}
