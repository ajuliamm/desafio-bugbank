package validations;
import java.time.Duration; 
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import pages.HomePage;
import pages.LoginPage;

public class HomeValidation {
    WebDriver driver;
    WebDriverWait wait; 
        LoginPage loginPage;
        HomePage homePage;

    public HomeValidation(WebDriver driver) {
        this.driver = driver;
        homePage = new HomePage(driver);
        wait = new WebDriverWait(driver,  Duration.ofSeconds(30)); 


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

    public void validationAccountNumber(String accountNumberRegistered) {
        String accountNumberHomePage = homePage.getAccountNumber().getText();
        Assertions.assertEquals(accountNumberRegistered, accountNumberHomePage);
    }

    public void validationButtons(String button) {

        if(button == "transfer"){
            homePage.getBtnTransfer().click();

            wait.until(ExpectedConditions.urlToBe(homePage.getTransferURL()));

            String urlActual = driver.getCurrentUrl();
            Assertions.assertEquals(homePage.getTransferURL(), urlActual);
        }
        
        if(button == "statement"){
            homePage.getBtnStatement().click();
            
            wait.until(ExpectedConditions.urlToBe(homePage.getStatementURL()));

            String urlActual = driver.getCurrentUrl();
            Assertions.assertEquals(homePage.getStatementURL(), urlActual);
        }

        if(button == "saque" || button == "payment"){
            homePage.getBtnSaque().click();
            String ModalText = homePage.getModalText().getText();
            Assertions.assertTrue(ModalText.contains("Funcionalidade em desenvolvimento"));
        }
    }

    public void validationLogout() {
        homePage.getExitButton().click();

        LoginPage loginPage = new LoginPage(driver); 
    
        wait.until(ExpectedConditions.urlToBe(loginPage.getLoginURL()));

        String urlActual = driver.getCurrentUrl();
        Assertions.assertEquals(loginPage.getLoginURL(), urlActual);

    }
}
