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

    public String validationNewAcountCreated() {

        String ModalText = registerPage.getModalText().getText();
        Assertions.assertTrue(ModalText.contains("foi criada com sucesso"));
        registerPage.getCloseModalButton().click();

        String AccountNumber = ModalText.split(" ")[2];
        //A conta 845-6 foi criada com sucesso

        return AccountNumber;
    }

    public void validationRegisterFields(String email, String name, String password, String passwordConfirmation) {

        if(email == "" || password == "" || passwordConfirmation == ""){

            String InputWarning = registerPage.getInputWarning().getText();
            Assertions.assertTrue(InputWarning.contains("É campo obrigatório"));
            return; 
        }
        if(name == "") {
            String ModalText = registerPage.getModalText().getText();
            Assertions.assertTrue(ModalText.contains("Nome não pode ser vazio."));
            registerPage.getCloseModalButton().click();
            return; 
        } 
        
        if(password!= passwordConfirmation){
            String ModalText = registerPage.getModalText().getText();
            Assertions.assertTrue(ModalText.contains("As senhas não são iguais."));
            registerPage.getCloseModalButton().click();
        }
        
    }


    
}
