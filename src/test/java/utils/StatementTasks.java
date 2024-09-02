package utils;

import org.openqa.selenium.WebDriver;

import pages.StatementPage;

public class StatementTasks {
    private WebDriver driver; 
    private StatementPage statementPage ;


    public StatementTasks(WebDriver driver){
        this.driver = driver; 
        this.statementPage = new StatementPage(driver);

    }

    public void exitAccount() {
        statementPage.getButtonExit().click();
    }

    public Double formatValueToDouble(String value){
        String valueString = value;

        valueString = valueString.replace(".", "");
        valueString = valueString.replace(",", ".");

        Double valueDouble;
        try {
            valueDouble = Double.valueOf(valueString);
        } catch (NumberFormatException e) {
            System.err.println("Erro ao converter a string para Double: " + e.getMessage());
            valueDouble = null; // 

            return valueDouble;
        }
        return valueDouble; 
    }
}
