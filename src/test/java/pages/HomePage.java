package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends PageObject{

    public HomePage(WebDriver driver) {
        super(driver);

    }

    public WebElement getWelcomeMessage(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[text()='bem vindo ao BugBank :)']")));
    }

    public WebElement getUserName(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("textName")));
    }

}
