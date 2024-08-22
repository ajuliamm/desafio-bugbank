package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class RegisterPage extends PageObject{

    public RegisterPage(WebDriver driver) {
        super(driver);
    }

    public WebElement getRegisterButton() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Registrar']"))); 
    }

    public WebElement getEmailField() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='card__register']//input[@name='email']"))); 
    }

    public WebElement getNameField() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='card__register']//input[@name='name']"))); 
    }

    public WebElement getPasswordField() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='card__register']//input[@name='password']"))); 
    }

    public WebElement getPasswordConfirmationField() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='card__register']//input[@name='passwordConfirmation']"))); 
    }

    public WebElement getAddBalanceToggle() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[@id='toggleAddBalance']//.."))); 
    }

    public WebElement getSubmitFormRegisterButton() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='card__register']//button[text()='Cadastrar']"))); 

    }

    public WebElement getModalText() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("modalText"))); 

    }

   
    
}
