package utils;

import org.openqa.selenium.WebDriver;

import pages.RegisterPage;

public class RegisterTasks {
    
    private WebDriver driver; 
    private RegisterPage registerPage ;


    public RegisterTasks(WebDriver driver){
        this.driver = driver; 
        this.registerPage = new RegisterPage(driver);

    }

    public void goToRegisterSection(){
        registerPage.getRegisterButton().click();
    }
}
