package utils;

import org.openqa.selenium.WebDriver;


import pages.LoginPage;

public class LoginUser {
    
    private WebDriver driver; 
    private LoginPage loginPage;
    



    public LoginUser(WebDriver driver) {
        this.driver = driver;
        loginPage = new LoginPage(driver);
    } 
    
    public void LoginAccount(String email, String password){

        loginPage.getEmailTextField().sendKeys(email);
        loginPage.getPasswordTextField().sendKeys(password);
        loginPage.getLoginButton().click();

    }
    
}
