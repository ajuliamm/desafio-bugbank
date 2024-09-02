package tests;

import org.junit.jupiter.api.Test;

import com.bugbank.tests.clients.ClientFake;

import validations.TransferValidation;
import utils.HomeTasks;
import utils.LoginUser;
import utils.RegisterUser;
import utils.TransferTasks;

public class TransferTest extends Setup{

    
    @Test
    public void testShouldSendTransferFormWithSuccess(){
        ClientFake clientFake_1 = new ClientFake(true); 
        ClientFake clientFake_2 = new ClientFake(true); 

        RegisterUser registerUser = new RegisterUser(getDriver());
        registerUser.registerNewAcount(clientFake_1.getEmail(), clientFake_1.getName(), clientFake_1.getPassword(), clientFake_1.getPassword(), clientFake_1.isAddBalance());


        String accountNumberUserTwo = registerUser.registerNewAcountAndReturnAccounNumber(clientFake_2.getEmail(), clientFake_2.getName(), clientFake_2.getPassword(), clientFake_2.getPassword(), clientFake_2.isAddBalance());
        String description = "Teste"; 
        String value = "200";

        LoginUser loginUser = new LoginUser(getDriver());
        loginUser.LoginAccount(clientFake_1.getEmail(), clientFake_2.getPassword());
        
        HomeTasks homeTasks = new HomeTasks(getDriver());
        homeTasks.goToTransferPage(); 

        TransferTasks transferTasks = new TransferTasks(getDriver());
        transferTasks.transfer(accountNumberUserTwo, value , description);

        TransferValidation transferValidation = new TransferValidation(getDriver());

        transferValidation.validationTransfer();

    }

    @Test
    public void testShouldNotTransferToOwnAccount(){
        
        ClientFake clientFake_1 = new ClientFake(true); 
        
        RegisterUser registerUser = new RegisterUser(getDriver());

        String accountNumber = registerUser.registerNewAcountAndReturnAccounNumber(clientFake_1.getEmail(), clientFake_1.getName(), clientFake_1.getPassword(), clientFake_1.getPassword(), clientFake_1.isAddBalance());
        String description = "Teste"; 
        String value = "200";

        LoginUser loginUser = new LoginUser(getDriver());
        loginUser.LoginAccount(clientFake_1.getEmail(), clientFake_1.getPassword());
        
        HomeTasks homeTasks = new HomeTasks(getDriver());
        homeTasks.goToTransferPage(); 

        TransferTasks transferTasks = new TransferTasks(getDriver());
        transferTasks.transfer(accountNumber, value , description);

        TransferValidation transferValidation = new TransferValidation(getDriver());
        transferValidation.validationTransferInvalid(accountNumber, accountNumber, value, clientFake_1.isAddBalance() );

    }

    @Test
    public void testShouldNotSendTransferWithAccountFieldBlank(){
        ClientFake clientFake_1 = new ClientFake(true); 

        RegisterUser registerUser = new RegisterUser(getDriver());
        String accountNumber1 = registerUser.registerNewAcountAndReturnAccounNumber(clientFake_1.getEmail(), clientFake_1.getName(), clientFake_1.getPassword(), clientFake_1.getPassword(), clientFake_1.isAddBalance());

        String accountNumber2Blank = "";
        String description = "Teste"; 
        String value = "200";

        LoginUser loginUser = new LoginUser(getDriver());
        loginUser.LoginAccount(clientFake_1.getEmail(), clientFake_1.getPassword());
        
        HomeTasks homeTasks = new HomeTasks(getDriver());
        homeTasks.goToTransferPage(); 

        TransferTasks transferTasks = new TransferTasks(getDriver());
        transferTasks.transfer(accountNumber2Blank, value , description);

        TransferValidation transferValidation = new TransferValidation(getDriver());
        transferValidation.validationTransferInvalid(accountNumber1, accountNumber2Blank,  value, clientFake_1.isAddBalance() );

    }

    @Test
    public void testShouldNotSendTransferWithValueFieldBlank(){
        ClientFake clientFake_1 = new ClientFake(true); 
        ClientFake clientFake_2 = new ClientFake(true); 

        RegisterUser registerUser = new RegisterUser(getDriver());
        String accountNumber1 = registerUser.registerNewAcountAndReturnAccounNumber(clientFake_1.getEmail(), clientFake_1.getName(), clientFake_1.getPassword(), clientFake_1.getPassword(), clientFake_1.isAddBalance());


        String accountNumber2 = registerUser.registerNewAcountAndReturnAccounNumber(clientFake_2.getEmail(), clientFake_2.getName(), clientFake_2.getPassword(), clientFake_2.getPassword(), clientFake_2.isAddBalance());
        String description = "Teste"; 
        String value = "";

        LoginUser loginUser = new LoginUser(getDriver());
        loginUser.LoginAccount(clientFake_1.getEmail(), clientFake_1.getPassword());
        
        HomeTasks homeTasks = new HomeTasks(getDriver());
        homeTasks.goToTransferPage(); 

        TransferTasks transferTasks = new TransferTasks(getDriver());
        transferTasks.transfer(accountNumber2, value , description);

        TransferValidation transferValidation = new TransferValidation(getDriver());

        transferValidation.validationTransferInvalid(accountNumber1, accountNumber2,  value, clientFake_1.isAddBalance());

    }

    @Test
    public void testShouldNotSendTransferWithValueFieldNotANumber(){
        ClientFake clientFake_1 = new ClientFake(true); 
        ClientFake clientFake_2 = new ClientFake(true); 

        RegisterUser registerUser = new RegisterUser(getDriver());
        String accountNumber1 = registerUser.registerNewAcountAndReturnAccounNumber(clientFake_1.getEmail(), clientFake_1.getName(), clientFake_1.getPassword(), clientFake_1.getPassword(), clientFake_1.isAddBalance());

        String accountNumber2 = registerUser.registerNewAcountAndReturnAccounNumber(clientFake_2.getEmail(), clientFake_2.getName(), clientFake_2.getPassword(), clientFake_2.getPassword(), clientFake_2.isAddBalance());
        String description = "Teste"; 
        String value = "abc";

        LoginUser loginUser = new LoginUser(getDriver());
        loginUser.LoginAccount(clientFake_1.getEmail(), clientFake_1.getPassword());
        
        HomeTasks homeTasks = new HomeTasks(getDriver());
        homeTasks.goToTransferPage(); 

        TransferTasks transferTasks = new TransferTasks(getDriver());
        transferTasks.transfer(accountNumber2, value , description);

        TransferValidation transferValidation = new TransferValidation(getDriver());

        transferValidation.validationTransferInvalid(accountNumber1, accountNumber2,  value, clientFake_1.isAddBalance() );

    }

    @Test
    public void testShouldSendTransferWithDescriptionFieldBlank(){
        ClientFake clientFake_1 = new ClientFake(true); 
        ClientFake clientFake_2 = new ClientFake(true); 

        RegisterUser registerUser = new RegisterUser(getDriver());
        registerUser.registerNewAcount(clientFake_1.getEmail(), clientFake_1.getName(), clientFake_1.getPassword(), clientFake_1.getPassword(), clientFake_1.isAddBalance());


        String accountNumber2 = registerUser.registerNewAcountAndReturnAccounNumber(clientFake_2.getEmail(), clientFake_2.getName(), clientFake_2.getPassword(), clientFake_2.getPassword(), clientFake_2.isAddBalance());
        String description = ""; 
        String value = "200";

        LoginUser loginUser = new LoginUser(getDriver());
        loginUser.LoginAccount(clientFake_1.getEmail(), clientFake_1.getPassword());
        
        HomeTasks homeTasks = new HomeTasks(getDriver());
        homeTasks.goToTransferPage(); 

        TransferTasks transferTasks = new TransferTasks(getDriver());
        transferTasks.transfer(accountNumber2, value , description);

        TransferValidation transferValidation = new TransferValidation(getDriver());

        transferValidation.validationTransfer();

    }

    @Test
    public void testShouldNotSendTransferWithNoBalance(){
        ClientFake clientFake_1 = new ClientFake(false); 
        ClientFake clientFake_2 = new ClientFake(false); 
        
        RegisterUser registerUser = new RegisterUser(getDriver());
        registerUser.registerNewAcount(clientFake_1.getEmail(), clientFake_1.getName(), clientFake_1.getPassword(), clientFake_1.getPassword(), clientFake_1.isAddBalance());
//

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

        TransferValidation transferValidation = new TransferValidation(getDriver());

        transferValidation.validationBalanceTransfer( clientFake_1.isAddBalance(), actualBalance, value );

    }

    @Test
    public void testShouldNotSendTransferWithValueBiggerThanBalance(){
        ClientFake clientFake_1 = new ClientFake(true); 
        ClientFake clientFake_2 = new ClientFake(true); 
        
        RegisterUser registerUser = new RegisterUser(getDriver());
       registerUser.registerNewAcount(clientFake_1.getEmail(), clientFake_1.getName(), clientFake_1.getPassword(), clientFake_1.getPassword(), clientFake_1.isAddBalance());

        String accountNumber2 = registerUser.registerNewAcountAndReturnAccounNumber(clientFake_2.getEmail(), clientFake_2.getName(), clientFake_2.getPassword(), clientFake_2.getPassword(), clientFake_2.isAddBalance());
        String description = "Teste"; 
        

        LoginUser loginUser = new LoginUser(getDriver());
        loginUser.LoginAccount(clientFake_1.getEmail(), clientFake_1.getPassword());
        
        HomeTasks homeTasks = new HomeTasks(getDriver());
        double actualBalance = homeTasks.getActualBalance();

        String value = String.valueOf(actualBalance + 5);

        homeTasks.goToTransferPage(); 

        TransferTasks transferTasks = new TransferTasks(getDriver());
        transferTasks.transfer(accountNumber2, value , description);

        TransferValidation transferValidation = new TransferValidation(getDriver());
        transferValidation.validationBalanceTransfer( clientFake_1.isAddBalance(), actualBalance, value );

    }
}
