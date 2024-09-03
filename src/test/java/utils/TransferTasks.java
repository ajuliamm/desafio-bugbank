package utils;

import org.openqa.selenium.WebDriver;

import pages.TransferPage;

public class TransferTasks {
    
    private WebDriver driver; 
    private TransferPage transferPage ;


    public TransferTasks(WebDriver driver){
        this.driver = driver; 
        this.transferPage = new TransferPage(driver);

    }

    public void transfer(String accountNumber, String value, String descriptions){
        String account;
        String digit;

        if(accountNumber != ""){
            String[] parts = accountNumber.split("-");
            account = parts[0];
            digit = parts[1];

            transferPage.getAccountNumberInput().sendKeys(account);
            transferPage.getDigitInput().sendKeys(digit);
            transferPage.getTransferValue().sendKeys(value);
            transferPage.getDescriptionInput().sendKeys(descriptions);
            transferPage.getFormTransfer().submit();
        }
        else {
            transferPage.getAccountNumberInput().sendKeys(accountNumber);
            transferPage.getDigitInput().sendKeys(accountNumber);
            transferPage.getTransferValue().sendKeys(value);
            transferPage.getDescriptionInput().sendKeys(descriptions);
            transferPage.getFormTransfer().submit();
        }

    }

    public void backToHomePage(){
        transferPage.getButtonBack().click();
    }

    public void closeModal(){
        transferPage.getCloseModalButton().click();
    }




}
