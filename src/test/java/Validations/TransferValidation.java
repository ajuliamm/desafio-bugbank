package validations;

import java.time.Duration;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import pages.HomePage;
import pages.TransferPage;

public class TransferValidation {
    
    WebDriver driver;
    WebDriverWait wait; 
    TransferPage transferPage;
    HomePage homePage;

    public TransferValidation(WebDriver driver) {
        this.driver = driver;
        transferPage = new TransferPage(driver);
        wait = new WebDriverWait(driver,  Duration.ofSeconds(30)); 


    }

    public void validationTransfer(){
        String ModalText = transferPage.getModalText().getText();
        Assertions.assertTrue(ModalText.contains("Transferencia realizada com sucesso"));
        transferPage.getCloseModalButton().click();

    }

    public void validationTransferInvalid(String accountToSend, String accountToReceived, String value, boolean balance){
        if(accountToSend == accountToReceived){
            String ModalText = transferPage.getModalText().getText();
            Assertions.assertTrue(ModalText.contains("Nao pode transferir pra mesmo conta"));
            transferPage.getCloseModalButton().click();

        }
        
        if(accountToReceived.isEmpty()){
            WebElement warningText = transferPage.getInputWarning();
            Assertions.assertTrue(warningText.isDisplayed());


        }

        if(value.isEmpty() || !value.matches("\\d+")){
            String warningText = transferPage.getInputWarningValue().getText();
            Assertions.assertTrue(warningText.contains("transferValue must be a `number` type, but the final value was: `NaN`"));
        }


    }

    public void validationBalanceTransfer(boolean balance, double balanceBeforeTransfer, String value){
        if(!balance || balanceBeforeTransfer < Double.valueOf(value)){
            String ModalText = transferPage.getModalText().getText();
            Assertions.assertTrue(ModalText.contains("Você não tem saldo suficiente para essa transação"));
            transferPage.getCloseModalButton().click();

        }

    }
}
