package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class StatementPage extends PageObject{

    public StatementPage(WebDriver driver) {
        super(driver);
    }

     @FindBy(id = "modalText")
    private WebElement modalText; 

    @FindBy(id = "btnCloseModal")
    private WebElement closeModalButton; 

    @FindBy(id = "textBalanceAvailable")
    private WebElement textBalanceAvailable; 

    @FindBy(id = "textTransferValue")
    private WebElement textTransferValue; 

    @FindBy(id = "textTypeTransaction")
    private WebElement textTypeTransaction; 

    @FindBy(id = "textDescription")
    private WebElement textDescription; 

    @FindBy(xpath = "(//p[@id='textTransferValue'])[last()]")
    private WebElement lastTextTransferValue; 

    @FindBy(xpath = "(//p[@id='textTypeTransaction'])[last()]")
    private WebElement lastTextTypeTransaction; 

    @FindBy(xpath = "(//p[@id='textDescription'])[last()]")
    private WebElement lastTxtDescription; 

    @FindBy(id = "btnBack")
    private WebElement btnBack; 

    @FindBy(id = "btnExit")
    private WebElement btnExit; 

    public WebElement getModalText() {
        return wait.until(ExpectedConditions.visibilityOf(modalText)); 
    }

    public WebElement getCloseModalButton() {
        return wait.until(ExpectedConditions.visibilityOf(closeModalButton)); 
    }

    public WebElement getTextBalanceAvailable() {
        return wait.until(ExpectedConditions.visibilityOf(textBalanceAvailable)); 
    }

    public WebElement getTextTransferValue() {
        return wait.until(ExpectedConditions.visibilityOf(textTransferValue)); 
    }
    
    public WebElement getTextTypeTransaction() {
        return wait.until(ExpectedConditions.visibilityOf(textTypeTransaction)); 
    }

    public WebElement getTextDescription() {
        return wait.until(ExpectedConditions.visibilityOf(textDescription)); 
    }

    public WebElement getLastTextTransferValue() {
        return wait.until(ExpectedConditions.visibilityOf(lastTextTransferValue)); 
    }
    
    public WebElement getLastTextTypeTransaction() {
        return wait.until(ExpectedConditions.visibilityOf(lastTextTypeTransaction)); 
    }

    public WebElement getLastTextDescription() {
        return wait.until(ExpectedConditions.visibilityOf(lastTxtDescription)); 
    }


    public WebElement getButtonBack() {
        return wait.until(ExpectedConditions.visibilityOf(btnBack)); 
    }

    public WebElement getButtonExit() {
        return wait.until(ExpectedConditions.visibilityOf(btnExit)); 
    }
    
    
    
}
