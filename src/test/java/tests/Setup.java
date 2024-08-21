package tests;

import java.time.Duration;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Setup {
    private String url = "https://bugbank.netlify.app/#";
    private final WebDriver driver = inicializeSetup();

    @BeforeEach
    public void beforeEach() {
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));
        driver.get(url);
    }

    @AfterEach
    public void afterEach() {
      driver.quit();
    }
  

    public WebDriver inicializeSetup(){
        return new ChromeDriver();    
    }

    public WebDriver getDriver() {
        return driver;
    }
}
