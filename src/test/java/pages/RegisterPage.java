package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class RegisterPage extends PageObject{

    @FindBy(xpath = "//div[@class='card__register']//input[@name='email']")
    private WebElement emailTextField; 

    @FindBy(xpath = "//div[@class='card__register']//input[@name='name']")
    private WebElement nameTextField; 

    @FindBy(xpath = "//div[@class='card__register']//input[@name='password']")
    private WebElement passwordTextField; 

    @FindBy(xpath = "//div[@class='card__register']//input[@name='passwordConfirmation']")
    private WebElement passwordConfirmationTextField; 
    
    @FindBy(xpath = "//button[text()='Registrar']")
    private WebElement registerButton; 
    
    @FindBy(xpath = "//div[@class='card__register']//p[text()='É campo obrigatório']")
    private WebElement inputWarning; 
    
    @FindBy(xpath = "//label[@id='toggleAddBalance']//..")
    private WebElement addBalanceToggle; 

    @FindBy(xpath = "//div[@class='card__register']//button[text()='Cadastrar']")
    private WebElement submitFormRegisterButton; 

    @FindBy(id = "modalText")
    private WebElement modalText; 

    @FindBy(id = "btnCloseModal")
    private WebElement closeModalButton; 


    public RegisterPage(WebDriver driver) {
        super(driver);
    }

    public WebElement getRegisterButton() {
        return wait.until(ExpectedConditions.visibilityOf(registerButton)); 
    }

    public WebElement getEmailField() {
        return wait.until(ExpectedConditions.visibilityOf(emailTextField)); 
    }

    public WebElement getNameField() {
        return wait.until(ExpectedConditions.visibilityOf(nameTextField)); 
    }

    public WebElement getPasswordField() {
        return wait.until(ExpectedConditions.visibilityOf(passwordTextField)); 
    }

    public WebElement getPasswordConfirmationField() {
        return wait.until(ExpectedConditions.visibilityOf(passwordConfirmationTextField)); 
    }

    public WebElement getAddBalanceToggle() {
        return wait.until(ExpectedConditions.visibilityOf(addBalanceToggle)); 
    }

    public WebElement getSubmitFormRegisterButton() {
        return wait.until(ExpectedConditions.visibilityOf(submitFormRegisterButton)); 

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

   
    
}
