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

    public Double getActualBalance(){
        String balanceString = homePage.getBalance().getText().split(" ")[1].trim();

        balanceString = balanceString.replace(".", "");
        balanceString = balanceString.replace(",", ".");

        Double balanceDouble;
        try {
            balanceDouble = Double.valueOf(balanceString);
        } catch (NumberFormatException e) {
            System.err.println("Erro ao converter a string para Double: " + e.getMessage());
            balanceDouble = null; // 

            return balanceDouble;
        }
        return balanceDouble; 
    }

    public void goToStatementPage() {
        homePage.getBtnStatement().click();
    }

    public void exitAccount() {
        homePage.getExitButton().click();

    }


    
}
