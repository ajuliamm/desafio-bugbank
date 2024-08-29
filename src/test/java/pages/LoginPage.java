package pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends PageObject {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "(//input[@name='email'])[1]")
    private WebElement emailTextField; 

    @FindBy(xpath = "(//input[@name='password'])[1]")
    private WebElement passwordTextField; 
    
    @FindBy(className = "otUnI")
    private WebElement logginButton; 
    
    @FindBy(xpath = "//div[@class='card__login']//p[text()='É campo obrigatório']")
    private WebElement inputWarning; 
    
    @FindBy(id = "modalText")
    private WebElement modalText; 

    @FindBy(id = "btnCloseModal")
    private WebElement closeModalButton; 
    

    public WebElement getEmailTextField (){
        return wait.until(ExpectedConditions.visibilityOf(emailTextField));

    }
    
    public WebElement getPasswordTextField (){
        return wait.until(ExpectedConditions.visibilityOf(passwordTextField));
    }

    public WebElement getLoginButton() {
        return wait.until(ExpectedConditions.visibilityOf(logginButton));
    }

    public WebElement getInputWarning() {
        return wait.until(ExpectedConditions.visibilityOf(inputWarning)); 

    }

    public WebElement getModalText() {
        return wait.until(ExpectedConditions.visibilityOf(modalText)); 

    }

    public WebElement getCloseModalButton() {
        return wait.until(ExpectedConditions.visibilityOf(closeModalButton)); 

    }

    public String getLoginURL(){
        return "https://bugbank.netlify.app/";
    }

    



    
}
