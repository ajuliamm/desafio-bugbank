package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends PageObject{

    @FindBy(xpath = "//p[text()='bem vindo ao BugBank :)']")
    private WebElement welcomeMessage; 

    @FindBy(xpath = "//p[@id='textBalance']//span")
    private WebElement textBalance; 

    @FindBy(id = "textName")
    private WebElement textName; 

    @FindBy(xpath = "//p[@id='textAccountNumber']//span")
    private WebElement textAccountNumber; 

    @FindBy(id = "btn-TRANSFERÊNCIA")
    private WebElement btnTransfer; 

    @FindBy(id = "btn-EXTRATO")
    private WebElement btnStatement; 


    public HomePage(WebDriver driver) {
        super(driver);

    }


    public WebElement getWelcomeMessage(){
        return wait.until(ExpectedConditions.visibilityOf(welcomeMessage));
    }

    public WebElement getUserName(){
        return wait.until(ExpectedConditions.visibilityOf(textName));
    }

    public WebElement getBalance(){
        return wait.until(ExpectedConditions.visibilityOf(textBalance));
    }

    public WebElement getAccountNumber(){
        return wait.until(ExpectedConditions.visibilityOf(textAccountNumber));
    }

    public WebElement getBtnTransfer(){
        return wait.until(ExpectedConditions.visibilityOf(btnTransfer));
    }

    public WebElement getBtnStatement(){
        return wait.until(ExpectedConditions.visibilityOf(btnStatement));
    }

    public String getTransferURL(){
        return "https://bugbank.netlify.app/transfer";
    }

    public String getStatementURL(){
        return "https://bugbank.netlify.app/bank-statement";
    }



}
