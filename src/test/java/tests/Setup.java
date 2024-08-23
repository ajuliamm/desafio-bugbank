package tests;

import java.time.Duration;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Setup {

    protected WebDriver driver;
    protected String URL_BASE = "https://bugbank.netlify.app/";

    @BeforeEach
    public void setUp() {
        driver = new ChromeDriver();
        driver.get(URL_BASE);
        this.driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));

    }

    @AfterEach
        public void tearDown() {
            if (driver != null) {
                driver.quit();
            }
    }

    public WebDriver getDriver(){
        return driver; 
    }
    

}
