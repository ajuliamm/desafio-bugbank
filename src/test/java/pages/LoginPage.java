package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends PageObject {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public WebElement getEmailTextField (String email){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@name='email'])[1]")));
    }
    
    public WebElement getPasswordTextField (String password){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@name='password'])[1]")));
    }

    public WebElement getLoginButton() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".otUnI")));
    }

    



    
}
