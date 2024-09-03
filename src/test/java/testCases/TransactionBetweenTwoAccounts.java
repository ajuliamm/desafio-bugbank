package testCases;

import org.junit.jupiter.api.Test;

import com.bugbank.tests.clients.ClientFake;

import tests.Setup;
import utils.HomeTasks;
import utils.LoginUser;
import utils.RegisterUser;
import utils.StatementTasks;
import utils.TransferTasks;
import validations.StatementValidation;
import validations.TransferValidation;

public class TransactionBetweenTwoAccounts extends Setup {

    ClientFake clientFake_1 = new ClientFake(false); 
    ClientFake clientFake_2 = new ClientFake(true); 

    @Test
    public void transactionBetweenTwoAccountsWithSuccess(){

        RegisterUser registerUser = new RegisterUser(getDriver());
        LoginUser loginUser = new LoginUser(getDriver());
        HomeTasks homeTasks = new HomeTasks(getDriver());
        TransferTasks transferTasks = new TransferTasks(getDriver());
        TransferValidation transferValidation = new TransferValidation(getDriver());
        StatementTasks statementTasks = new StatementTasks(getDriver()); 
        StatementValidation statementValidation = new StatementValidation(getDriver());
        
        String accountNumberUser_1 = registerUser.registerNewAcountAndReturnAccounNumber(clientFake_1.getEmail(), clientFake_1.getName(), clientFake_1.getPassword(), clientFake_1.getPassword(), clientFake_1.isAddBalance());
        String accountNumberUser_2 = registerUser.registerNewAcountAndReturnAccounNumber(clientFake_2.getEmail(), clientFake_2.getName(), clientFake_2.getPassword(), clientFake_2.getPassword(), clientFake_2.isAddBalance());
       
        String description = "Transfer 1"; 
        String value = "200";

        loginUser.LoginAccount(clientFake_1.getEmail(), clientFake_1.getPassword());
        double balanceBeforeTransfer_c1 = homeTasks.getActualBalance();
        homeTasks.exitAccount();
        loginUser.LoginAccount(clientFake_2.getEmail(), clientFake_2.getPassword());
        double balanceBeforeTransfer_c2 = homeTasks.getActualBalance();
        homeTasks.goToTransferPage(); 
        transferTasks.transfer(accountNumberUser_1, value , description);
        transferValidation.validationTransfer();
        transferTasks.backToHomePage();
        homeTasks.goToStatementPage();
        statementValidation.validationStatementTransaction(clientFake_2.isAddBalance(), balanceBeforeTransfer_c2, value, description, "send");
        statementTasks.exitAccount();
        loginUser.LoginAccount(clientFake_1.getEmail(), clientFake_1.getPassword());
        homeTasks.goToStatementPage();
        statementValidation.validationStatementTransaction(clientFake_1.isAddBalance(), balanceBeforeTransfer_c1, value, description, "received");

    }
    
}
