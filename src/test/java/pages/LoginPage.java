package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends PageObject {

    public LoginPage(WebDriver driver) {
        super(driver);
        this.driver.get("https://bugbank.netlify.app/");
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
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
