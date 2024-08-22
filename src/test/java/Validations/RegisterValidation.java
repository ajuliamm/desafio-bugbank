package Validations;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;

import pages.RegisterPage;

public class RegisterValidation {
    WebDriver driver;
    RegisterPage registerPage;


    public RegisterValidation(WebDriver driver){
        this.driver = driver; 
        registerPage = new RegisterPage(driver); 


    }

    public void validationNewAcountCreated() {
        String ModalText = registerPage.getModalText().getText();
        Assertions.assertTrue(ModalText.contains("foi criada com sucesso"));
        registerPage.getCloseModalButton().click();
    }


    
}
