package tests;


import org.junit.jupiter.api.Test;

import com.bugbank.tests.clients.ClientFake;


import utils.HomeTasks;
import utils.LoginUser;
import utils.RegisterUser;
import utils.StatementTasks;
import utils.TransferTasks;
import validations.StatementValidation;

public class StatementTest extends Setup {

    
    @Test
    public void testShouldShowEqualValuesToActualBalanceAndFirstStatementValueWhenOpenAccount() throws InterruptedException{

        ClientFake clientFake_1 = new ClientFake(false); 
        ClientFake clientFake_2 = new ClientFake(true); 

        RegisterUser registerUser = new RegisterUser(getDriver());
        registerUser.registerNewAcount(clientFake_1.getEmail(), clientFake_1.getName(), clientFake_1.getPassword(), clientFake_1.getPassword(), clientFake_1.isAddBalance());
        registerUser.registerNewAcount(clientFake_2.getEmail(), clientFake_2.getName(), clientFake_2.getPassword(), clientFake_2.getPassword(), clientFake_2.isAddBalance());        

        LoginUser loginUser = new LoginUser(getDriver());
        loginUser.LoginAccount(clientFake_1.getEmail(), clientFake_1.getPassword());

        HomeTasks homeTasks = new HomeTasks(getDriver());

        homeTasks.goToStatementPage(); 

        StatementValidation statementValidation = new StatementValidation(getDriver());
        statementValidation.validationStatementOpenAccount( clientFake_1.isAddBalance()); 

        StatementTasks statementTasks = new StatementTasks(getDriver());
        statementTasks.exitAccount();
        
        loginUser.LoginAccount(clientFake_2.getEmail(), clientFake_2.getPassword());

        homeTasks.goToStatementPage(); 

        statementValidation.validationStatementOpenAccount(clientFake_2.isAddBalance()); 

    }

    @Test
    public void testShouldShowTransactionOnStatementPage(){
        ClientFake clientFake_1 = new ClientFake(true); 
        ClientFake clientFake_2 = new ClientFake(true); 

        RegisterUser registerUser = new RegisterUser(getDriver());
        registerUser.registerNewAcount(clientFake_1.getEmail(), clientFake_1.getName(), clientFake_1.getPassword(), clientFake_1.getPassword(), clientFake_1.isAddBalance());

        String accountNumber2 = registerUser.registerNewAcountAndReturnAccounNumber(clientFake_2.getEmail(), clientFake_2.getName(), clientFake_2.getPassword(), clientFake_2.getPassword(), clientFake_2.isAddBalance());
        String description = "Teste"; 
        String value = "200";

        LoginUser loginUser = new LoginUser(getDriver());
        loginUser.LoginAccount(clientFake_1.getEmail(), clientFake_1.getPassword());
        
        HomeTasks homeTasks = new HomeTasks(getDriver());
        Double actualBalance = homeTasks.getActualBalance();

        homeTasks.goToTransferPage(); 

        TransferTasks transferTasks = new TransferTasks(getDriver());
        transferTasks.transfer(accountNumber2, value , description);
        transferTasks.closeModal();
        transferTasks.backToHomePage();

        homeTasks.goToStatementPage();

        StatementValidation statementValidation = new StatementValidation(getDriver());
        statementValidation.validationStatementTransaction( clientFake_1.isAddBalance(), actualBalance, value, description, "send"); 

    }
    
}
