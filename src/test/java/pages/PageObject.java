package pages;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageObject {


        protected WebDriver driver; 
        protected WebDriverWait wait; 

        public PageObject(WebDriver driver){
                this.driver = driver; 
                PageFactory.initElements(driver, this);
                this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        }
   
    
}
