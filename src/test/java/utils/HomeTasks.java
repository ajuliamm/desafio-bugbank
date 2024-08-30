package utils;

import org.openqa.selenium.WebDriver;

import pages.HomePage;

public class HomeTasks {

    private WebDriver driver; 
    private HomePage homePage ;


    public HomeTasks(WebDriver driver){
        this.driver = driver; 
        this.homePage = new HomePage(driver);

    }

    public void goToTransferPage(){
        homePage.getBtnTransfer().click();
    }


    
}
