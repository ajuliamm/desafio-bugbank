package tests;

import java.util.Locale;

import org.junit.jupiter.api.Test;

import com.github.javafaker.Faker;
import com.github.javafaker.service.FakeValuesService;
import com.github.javafaker.service.RandomService;

import validations.TransferValidation;
import utils.HomeTasks;
import utils.LoginUser;
import utils.RegisterUser;
import utils.TransferTasks;

public class TransferTest extends Setup{
    Faker faker = new Faker(); 
    FakeValuesService fakeValuesService = new FakeValuesService(new Locale("en-GB"), new RandomService());

    String email_1 = fakeValuesService.bothify("????##@gmail.com");
    String name_1 = faker.name().fullName();
    String password_1 = fakeValuesService.regexify("[a-z1-9]{10}");

    String email_2 = fakeValuesService.bothify("????##@gmail.com");
    String name_2 = faker.name().fullName();
    String password_2 = fakeValuesService.regexify("[a-z1-9]{10}");


    
    @Test
    public void testShouldSendTransferFormWithSuccess(){
        
        boolean balance = true; 
        RegisterUser registerUser = new RegisterUser(getDriver());
        registerUser.registerNewAcount(email_1, name_1, password_1, password_1, balance);


        String accountNumberUserTwo = registerUser.registerNewAcountAndReturnAccounNumber(email_2, name_2, password_2, password_2, balance);
        String description = "Teste"; 
        String value = "200";

        LoginUser loginUser = new LoginUser(getDriver());
        loginUser.LoginAccount(email_1, password_1);
        
        HomeTasks homeTasks = new HomeTasks(getDriver());
        homeTasks.goToTransferPage(); 

        TransferTasks transferTasks = new TransferTasks(getDriver());
        transferTasks.transfer(accountNumberUserTwo, value , description);

        TransferValidation transferValidation = new TransferValidation(getDriver());

        transferValidation.validationTransfer();

    }

    @Test
    public void testShouldNotTransferToOwnAccount(){
        
        boolean balance = true; 
        RegisterUser registerUser = new RegisterUser(getDriver());

        String accountNumber = registerUser.registerNewAcountAndReturnAccounNumber(email_1, name_1, password_1, password_1, balance);
        String description = "Teste"; 
        String value = "200";

        LoginUser loginUser = new LoginUser(getDriver());
        loginUser.LoginAccount(email_1, password_1);
        
        HomeTasks homeTasks = new HomeTasks(getDriver());
        homeTasks.goToTransferPage(); 

        TransferTasks transferTasks = new TransferTasks(getDriver());
        transferTasks.transfer(accountNumber, value , description);

        TransferValidation transferValidation = new TransferValidation(getDriver());
        transferValidation.validationTransferInvalid(accountNumber, accountNumber, value, balance );

        

    }

    @Test
    public void testShouldNotSendTransferWithAccountFieldBlank(){
        
        boolean balance = true; 
        RegisterUser registerUser = new RegisterUser(getDriver());
        String accountNumber1 = registerUser.registerNewAcountAndReturnAccounNumber(email_1, name_1, password_1, password_1, balance);


        String accountNumber2Blank = "";
        String description = "Teste"; 
        String value = "200";

        LoginUser loginUser = new LoginUser(getDriver());
        loginUser.LoginAccount(email_1, password_1);
        
        HomeTasks homeTasks = new HomeTasks(getDriver());
        homeTasks.goToTransferPage(); 

        TransferTasks transferTasks = new TransferTasks(getDriver());
        transferTasks.transfer(accountNumber2Blank, value , description);

        TransferValidation transferValidation = new TransferValidation(getDriver());
        transferValidation.validationTransferInvalid(accountNumber1, accountNumber2Blank,  value, balance );

    }

    @Test
    public void testShouldNotSendTransferWithValueFieldBlank(){
        
        boolean balance = true; 
        RegisterUser registerUser = new RegisterUser(getDriver());
        String accountNumber1 = registerUser.registerNewAcountAndReturnAccounNumber(email_1, name_1, password_1, password_1, balance);


        String accountNumber2 = registerUser.registerNewAcountAndReturnAccounNumber(email_2, name_2, password_2, password_2, balance);
        String description = "Teste"; 
        String value = "";

        LoginUser loginUser = new LoginUser(getDriver());
        loginUser.LoginAccount(email_1, password_1);
        
        HomeTasks homeTasks = new HomeTasks(getDriver());
        homeTasks.goToTransferPage(); 

        TransferTasks transferTasks = new TransferTasks(getDriver());
        transferTasks.transfer(accountNumber2, value , description);

        TransferValidation transferValidation = new TransferValidation(getDriver());

        transferValidation.validationTransferInvalid(accountNumber1, accountNumber2,  value, balance);

    }

    @Test
    public void testShouldNotSendTransferWithValueFieldNotANumber(){
        
        boolean balance = true; 
        RegisterUser registerUser = new RegisterUser(getDriver());
        String accountNumber1 = registerUser.registerNewAcountAndReturnAccounNumber(email_1, name_1, password_1, password_1, balance);


        String accountNumber2 = registerUser.registerNewAcountAndReturnAccounNumber(email_2, name_2, password_2, password_2, balance);
        String description = "Teste"; 
        String value = "abc";

        LoginUser loginUser = new LoginUser(getDriver());
        loginUser.LoginAccount(email_1, password_1);
        
        HomeTasks homeTasks = new HomeTasks(getDriver());
        homeTasks.goToTransferPage(); 

        TransferTasks transferTasks = new TransferTasks(getDriver());
        transferTasks.transfer(accountNumber2, value , description);

        TransferValidation transferValidation = new TransferValidation(getDriver());

        transferValidation.validationTransferInvalid(accountNumber1, accountNumber2,  value, balance );

    }

    @Test
    public void testShouldSendTransferWithDescriptionFieldBlank(){
        
        boolean balance = true; 
        RegisterUser registerUser = new RegisterUser(getDriver());
        String accountNumber1 = registerUser.registerNewAcountAndReturnAccounNumber(email_1, name_1, password_1, password_1, balance);


        String accountNumber2 = registerUser.registerNewAcountAndReturnAccounNumber(email_2, name_2, password_2, password_2, balance);
        String description = ""; 
        String value = "200";

        LoginUser loginUser = new LoginUser(getDriver());
        loginUser.LoginAccount(email_1, password_1);
        
        HomeTasks homeTasks = new HomeTasks(getDriver());
        homeTasks.goToTransferPage(); 

        TransferTasks transferTasks = new TransferTasks(getDriver());
        transferTasks.transfer(accountNumber2, value , description);

        TransferValidation transferValidation = new TransferValidation(getDriver());

        transferValidation.validationTransfer();

    }

    @Test
    public void testShouldNotSendTransferWithNoBalance(){
        
        boolean balance = false; 
        RegisterUser registerUser = new RegisterUser(getDriver());
        String accountNumber1 = registerUser.registerNewAcountAndReturnAccounNumber(email_1, name_1, password_1, password_1, balance);


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

        TransferValidation transferValidation = new TransferValidation(getDriver());

        transferValidation.validationBalanceTransfer( balance, actualBalance, value );

    }

    @Test
    public void testShouldNotSendTransferWithValueBiggerThanBalance(){
        
        boolean balance = true; 
        RegisterUser registerUser = new RegisterUser(getDriver());
        String accountNumber1 = registerUser.registerNewAcountAndReturnAccounNumber(email_1, name_1, password_1, password_1, balance);


        String accountNumber2 = registerUser.registerNewAcountAndReturnAccounNumber(email_2, name_2, password_2, password_2, balance);
        String description = "Teste"; 
        

        LoginUser loginUser = new LoginUser(getDriver());
        loginUser.LoginAccount(email_1, password_1);
        
        HomeTasks homeTasks = new HomeTasks(getDriver());
        double actualBalance = homeTasks.getActualBalance();

        String value = String.valueOf(actualBalance + 5);

        homeTasks.goToTransferPage(); 

        TransferTasks transferTasks = new TransferTasks(getDriver());
        transferTasks.transfer(accountNumber2, value , description);

        TransferValidation transferValidation = new TransferValidation(getDriver());
        transferValidation.validationBalanceTransfer( balance, actualBalance, value );

    }
}
