package validations;

import java.time.Duration;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import pages.HomePage;
import pages.StatementPage;
import utils.StatementTasks;

public class StatementValidation {
    WebDriver driver;
    WebDriverWait wait; 
    StatementPage statementPage;
    HomePage homePage;

    public StatementValidation(WebDriver driver) {
        this.driver = driver;
        statementPage = new StatementPage(driver);
        wait = new WebDriverWait(driver,  Duration.ofSeconds(30)); 
    }

    public void validationStatementOpenAccount( boolean balance){
        
            String OpenAccountText = statementPage.getTextTypeTransaction().getText();
            Assertions.assertTrue(OpenAccountText.contains("Abertura de conta"));

            String balanceAvailable = statementPage.getTextBalanceAvailable().getText();
            String balanceOpenAccount = statementPage.getTextTransferValue().getText(); 
            Assertions.assertEquals(balanceAvailable, balanceOpenAccount);

            String textDescription = statementPage.getTextDescription().getText();
            if(balance){
                Assertions.assertEquals("Saldo adicionado ao abrir conta", textDescription);
            } else {
                Assertions.assertEquals("Cliente optou por não ter saldo ao abrir conta", textDescription);

            }
        
    }

    public void validationStatementTransaction( boolean balance, Double balanceBeforeTransaction, String value, String description, String typeTransaction){

        if(typeTransaction == "send"){

            String OpenAccountText = statementPage.getLastTextTypeTransaction().getText();
            Assertions.assertTrue(OpenAccountText.contains("Transferência enviada"));

            StatementTasks statementTasks = new StatementTasks(driver);

            String balanceAvailable = statementPage.getTextBalanceAvailable().getText().split(" ")[1];
            Double balanceAvailableDouble = statementTasks.formatValueToDouble(balanceAvailable);

            Double valueSend = statementTasks.formatValueToDouble(value);        
            Assertions.assertEquals(balanceBeforeTransaction - valueSend, balanceAvailableDouble);

            Double textTarnsferValue= statementTasks.formatValueToDouble(statementPage.getLastTextTransferValue().getText().split(" ")[1]);
            Assertions.assertEquals(textTarnsferValue, valueSend);

        }
        


        String textDescription = statementPage.getLastTextDescription().getText();
        Assertions.assertEquals(description, textDescription);
        
    
}
}
