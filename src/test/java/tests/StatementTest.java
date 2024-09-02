package tests;

import java.util.Locale;

import org.junit.jupiter.api.Test;

import com.github.javafaker.Faker;
import com.github.javafaker.service.FakeValuesService;
import com.github.javafaker.service.RandomService;

import utils.HomeTasks;
import utils.LoginUser;
import utils.RegisterUser;
import utils.StatementTasks;
import utils.TransferTasks;
import validations.StatementValidation;

public class StatementTest extends Setup {

    Faker faker = new Faker(); 
    FakeValuesService fakeValuesService = new FakeValuesService(new Locale("en-GB"), new RandomService());

    String email_1 = fakeValuesService.bothify("????##@gmail.com");
    String name_1 = faker.name().fullName();
    String password_1 = fakeValuesService.regexify("[a-z1-9]{10}");

    String email_2 = fakeValuesService.bothify("????##@gmail.com");
    String name_2 = faker.name().fullName();
    String password_2 = fakeValuesService.regexify("[a-z1-9]{10}");

    @Test
    public void testShouldShowEqualValuesToActualBalanceAndFirstStatementValueWhenOpenAccount() throws InterruptedException{
        boolean balance_1 = false; 
        boolean balance_2 = true; 

        RegisterUser registerUser = new RegisterUser(getDriver());
        registerUser.registerNewAcount(email_1, name_1, password_1, password_1, balance_1);
        Thread.sleep(3000);
        registerUser.registerNewAcount(email_2, name_2, password_2, password_2, balance_2);        
        Thread.sleep(3000);

        LoginUser loginUser = new LoginUser(getDriver());
        loginUser.LoginAccount(email_1, password_1);
        Thread.sleep(3000);

        HomeTasks homeTasks = new HomeTasks(getDriver());

        homeTasks.goToStatementPage(); 
        Thread.sleep(3000);

        StatementValidation statementValidation = new StatementValidation(getDriver());
        statementValidation.validationStatementOpenAccount( balance_1); 
        Thread.sleep(3000);

        StatementTasks statementTasks = new StatementTasks(getDriver());
        statementTasks.exitAccount();
        Thread.sleep(3000);

        
        loginUser.LoginAccount(email_2, password_2);
        Thread.sleep(3000);

        homeTasks.goToStatementPage(); 
        Thread.sleep(3000);

        statementValidation.validationStatementOpenAccount(balance_2); 

    }

    @Test
    public void testShouldShowTransactionOnStatementPage(){
        boolean balance = true; 
        RegisterUser registerUser = new RegisterUser(getDriver());
        registerUser.registerNewAcount(email_1, name_1, password_1, password_1, balance);

        String accountNumber2 = registerUser.registerNewAcountAndReturnAccounNumber(email_2, name_2, password_2, password_2, balance);
        String description = "Teste"; 
        String value = "200";

        LoginUser loginUser = new LoginUser(getDriver());
        loginUser.LoginAccount(email_1, password_1);
        
        HomeTasks homeTasks = new HomeTasks(getDriver());
        Double actualBalance = homeTasks.getActualBalance();

        homeTasks.goToTransferPage(); 

        TransferTasks transferTasks = new TransferTasks(getDriver());
        transferTasks.transfer(accountNumber2, value , description);
        transferTasks.closeModal();
        transferTasks.backToHomePage();

        homeTasks.goToStatementPage();

        StatementValidation statementValidation = new StatementValidation(getDriver());
        statementValidation.validationStatementTransaction( balance, actualBalance, value, description, "send"); 

    }
    
}
