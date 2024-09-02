package tests;

import org.junit.jupiter.api.Test;

import com.bugbank.tests.clients.ClientFake;

import validations.HomeValidation;
import utils.LoginUser;
import utils.RegisterUser;

public class HomeTest extends Setup{
 

    @Test
    public void testShouldShowUserName(){

        ClientFake clientFake = new ClientFake(false); 

            
        RegisterUser registerUser = new RegisterUser(getDriver());
        registerUser.registerNewAcount(clientFake.getEmail(), clientFake.getName(), clientFake.getPassword(), clientFake.getPassword(), clientFake.isAddBalance());
        
        LoginUser loginUser = new LoginUser(getDriver());
        loginUser.LoginAccount(clientFake.getEmail(), clientFake.getPassword());

        HomeValidation homeValidation = new HomeValidation(getDriver());
        homeValidation.validationUserName(clientFake.getName());

    }

    @Test
    public void testShouldShowPositiveBalanceWhenAddBalance(){

        ClientFake clientFake = new ClientFake(true); 

        RegisterUser registerUser = new RegisterUser(getDriver());
        registerUser.registerNewAcount(clientFake.getEmail(), clientFake.getName(), clientFake.getPassword(), clientFake.getPassword(), clientFake.isAddBalance());
        
        LoginUser loginUser = new LoginUser(getDriver());
        loginUser.LoginAccount(clientFake.getEmail(), clientFake.getPassword());

        HomeValidation homeValidation = new HomeValidation(getDriver());
        homeValidation.validationBalance(clientFake.isAddBalance());

    }

    @Test
    public void testShouldShowBalanceEqualZeroWhenNotAddBalance(){

        ClientFake clientFake = new ClientFake(false); 

            
        RegisterUser registerUser = new RegisterUser(getDriver());
        registerUser.registerNewAcount(clientFake.getEmail(), clientFake.getName(), clientFake.getPassword(), clientFake.getPassword(), clientFake.isAddBalance());
        
        LoginUser loginUser = new LoginUser(getDriver());
        loginUser.LoginAccount(clientFake.getEmail(), clientFake.getPassword());

        HomeValidation homeValidation = new HomeValidation(getDriver());
        homeValidation.validationBalance(clientFake.isAddBalance());

    }

    @Test
    public void testShouldVerifyAccountNumber(){

        ClientFake clientFake = new ClientFake(false); 
            
        RegisterUser registerUser = new RegisterUser(getDriver());
    
        String accountNumberRegistered = registerUser.registerNewAcountAndReturnAccounNumber(clientFake.getEmail(), clientFake.getName(), clientFake.getPassword(), clientFake.getPassword(), clientFake.isAddBalance());
        
        LoginUser loginUser = new LoginUser(getDriver());
        loginUser.LoginAccount(clientFake.getEmail(), clientFake.getPassword());

        HomeValidation homeValidation = new HomeValidation(getDriver());
        homeValidation.validationAccountNumber(accountNumberRegistered);



    }

    @Test
    public void testShouldVerifyTransferButtonAndChangeToTransferPage(){
        ClientFake clientFake = new ClientFake(false); 
            
        RegisterUser registerUser = new RegisterUser(getDriver());
        registerUser.registerNewAcount(clientFake.getEmail(), clientFake.getName(), clientFake.getPassword(), clientFake.getPassword(), clientFake.isAddBalance());
        
        LoginUser loginUser = new LoginUser(getDriver());
        loginUser.LoginAccount(clientFake.getEmail(), clientFake.getPassword());
        
        HomeValidation homeValidation = new HomeValidation(getDriver());
        homeValidation.validationButtons("transfer");


    }

    @Test
    public void testShouldVerifyStatementButtonAndChangeToStatementPage(){
        ClientFake clientFake = new ClientFake(false); 
            
        RegisterUser registerUser = new RegisterUser(getDriver());
        registerUser.registerNewAcount(clientFake.getEmail(), clientFake.getName(), clientFake.getPassword(), clientFake.getPassword(), clientFake.isAddBalance());
        
        LoginUser loginUser = new LoginUser(getDriver());
        loginUser.LoginAccount(clientFake.getEmail(), clientFake.getPassword());
        
        HomeValidation homeValidation = new HomeValidation(getDriver());
        homeValidation.validationButtons("statement");
    }

    @Test
    public void testShouldVerifySaqueButton(){

        ClientFake clientFake = new ClientFake(false); 
            
        RegisterUser registerUser = new RegisterUser(getDriver());

        registerUser.registerNewAcount(clientFake.getEmail(), clientFake.getName(), clientFake.getPassword(), clientFake.getPassword(), clientFake.isAddBalance());
        
        LoginUser loginUser = new LoginUser(getDriver());
        loginUser.LoginAccount(clientFake.getEmail(), clientFake.getPassword());
        
        HomeValidation homeValidation = new HomeValidation(getDriver());
        homeValidation.validationButtons("saque");
    }

    @Test
    public void testShouldVerifyPaymentButton(){
        ClientFake clientFake = new ClientFake(false); 
            
        RegisterUser registerUser = new RegisterUser(getDriver());
       
        registerUser.registerNewAcount(clientFake.getEmail(), clientFake.getName(), clientFake.getPassword(), clientFake.getPassword(), clientFake.isAddBalance());
        
        LoginUser loginUser = new LoginUser(getDriver());
        loginUser.LoginAccount(clientFake.getEmail(), clientFake.getPassword());
        
        HomeValidation homeValidation = new HomeValidation(getDriver());
        homeValidation.validationButtons("saque");
    }

    @Test
    public void testShouldBackToLoginPageWhenExitButtonClicked(){

        ClientFake clientFake = new ClientFake(false); 

        RegisterUser registerUser = new RegisterUser(getDriver());
        registerUser.registerNewAcount(clientFake.getEmail(), clientFake.getName(), clientFake.getPassword(), clientFake.getPassword(), clientFake.isAddBalance());
        
        LoginUser loginUser = new LoginUser(getDriver());
        loginUser.LoginAccount(clientFake.getEmail(), clientFake.getPassword());
        
        HomeValidation homeValidation = new HomeValidation(getDriver());
        homeValidation.validationLogout();

    }

}