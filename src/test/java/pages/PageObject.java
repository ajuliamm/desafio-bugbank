package pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageObject {

        protected WebDriver driver; 
        protected WebDriverWait wait;

    public PageObject(WebDriver driver){
            if(driver == null){
                    this.driver = new ChromeDriver();

            } else {

                    this.driver = driver; 
            }
            this.driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));
    }
    
}
