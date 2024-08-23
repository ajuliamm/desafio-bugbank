package Validations;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;

import pages.HomePage;
import pages.LoginPage;

public class LoginValidation {
        WebDriver driver;
        LoginPage loginPage;
        HomePage homePage;

        public LoginValidation(WebDriver driver) {
            this.driver = driver;
            loginPage = new LoginPage(driver); 
            homePage = new HomePage(driver);
        }

        public void validationLogIn(String name){
            String WelcomeText = homePage.getWelcomeMessage().getText();
            Assertions.assertEquals(WelcomeText, "bem vindo ao BugBank :)");

            String UserName = homePage.getUserName().getText();
            Assertions.assertTrue(UserName.contains(name));


            
        }

        
        public void validationInvalidLogin(String emailRegistered, String emailLoggedIn, String passwordRegistered, String passwordLoggedIn) {

            if(emailLoggedIn == "" || passwordLoggedIn == "" ){
    
                String InputWarning = loginPage.getInputWarning().getText();
                Assertions.assertTrue(InputWarning.contains("É campo obrigatório"));
                return; 
            }
            if(emailRegistered != emailLoggedIn || passwordRegistered != passwordLoggedIn ){
    
                String ModalText = loginPage.getModalText().getText();
                Assertions.assertTrue(ModalText.contains("Usuário ou senha inválido."));
                loginPage.getCloseModalButton().click();
                return;
            }
            
        }

        



}
