package Validations;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;

import pages.HomePage;
import pages.LoginPage;

public class HomeValidation {
    WebDriver driver;
        LoginPage loginPage;
        HomePage homePage;

    public HomeValidation(WebDriver driver) {
        this.driver = driver;
        homePage = new HomePage(driver);
    }

    public void validationUserName(String name){
        String UserName = homePage.getUserName().getText();
        Assertions.assertTrue(UserName.contains(name));
    }

    public void validationBalance(boolean balance) {

        String expectedBalance = balance ? "R$ 1.000,00" : "R$ 0,00";


        String actualBalance = homePage.getBalance().getText(); 
        Assertions.assertEquals(expectedBalance, actualBalance);

    }
}
