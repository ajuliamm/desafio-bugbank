package pages;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageObject {


        protected WebDriver driver; 
        protected WebDriverWait wait; 

        public PageObject(WebDriver driver){
                this.driver = driver; 
                this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        }
   
    
}
