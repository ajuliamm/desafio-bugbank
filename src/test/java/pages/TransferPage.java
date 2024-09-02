package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class TransferPage extends PageObject{
    
    public TransferPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//input[@name='accountNumber']")
    private WebElement inputAccountNumber;

    @FindBy(xpath = "//input[@name='digit']")
    private WebElement inputDigit;

    @FindBy(xpath = "//input[@name='transferValue']")
    private WebElement inputTransferValue;

    @FindBy(xpath = "//input[@name='description']")
    private WebElement inputDescription;

    @FindBy(xpath = "(//form//p[@class='input__warging'])[3]")
    private WebElement inputWarningValue;

    @FindBy(xpath = "//form//p[@class='input__warging']")
    private WebElement inputWarning;

    @FindBy(xpath = "//form")
    private WebElement formTransfer; 

    @FindBy(id = "modalText")
    private WebElement modalText; 

    @FindBy(id = "btnCloseModal")
    private WebElement closeModalButton; 

    @FindBy(id = "btnBack")
    private WebElement btnBack; 



    public WebElement getModalText() {
        return wait.until(ExpectedConditions.visibilityOf(modalText)); 
    }

    public WebElement getCloseModalButton() {
        return wait.until(ExpectedConditions.visibilityOf(closeModalButton)); 
    }

    public WebElement getInputWarning() {
        return wait.until(ExpectedConditions.visibilityOf(inputWarning)); 

    }

    public WebElement getInputWarningValue() {
        return wait.until(ExpectedConditions.visibilityOf(inputWarningValue)); 

    }

    public WebElement getAccountNumberInput() {
        return wait.until(ExpectedConditions.visibilityOf(inputAccountNumber)); 
    }

    public WebElement getDigitInput() {
        return wait.until(ExpectedConditions.visibilityOf(inputDigit)); 
    }

    public WebElement getTransferValue() {
        return wait.until(ExpectedConditions.visibilityOf(inputTransferValue)); 
    }

    public WebElement getDescriptionInput() {
        return wait.until(ExpectedConditions.visibilityOf(inputDescription)); 
    }

    public WebElement getFormTransfer() {
        return wait.until(ExpectedConditions.visibilityOf(formTransfer)); 
    }

    public WebElement getButtonBack() {
        return wait.until(ExpectedConditions.visibilityOf(btnBack)); 
    }


    
}
