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

    public WebElement getModalText() {
        return wait.until(ExpectedConditions.visibilityOf(modalText)); 
    }

    public WebElement getCloseModalButton() {
        return wait.until(ExpectedConditions.visibilityOf(closeModalButton)); 
    }

    public WebElement getTextBalanceAvailable() {
        return wait.until(ExpectedConditions.visibilityOf(textBalanceAvailable)); 
    }
    
}
