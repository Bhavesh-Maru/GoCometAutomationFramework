package testcases;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.Test;

import pages.LoginPage;
import setup.BaseTest;

public class LoginTests extends BaseTest {

	@Test
	public void loginWithValidCredential(){
	    LoginPage login = new LoginPage(driver());
	    
	    login.enterUsername("tomsmith");
	    login.enterPassword("SuperSecretPassword!");
	    login.clickLogin();
	    
	    login.verifyFlashText("You logged into a secure area!");
    }
	
	@Test
	public void loginWithInvalidCredential(){
	    LoginPage login = new LoginPage(driver());
	    
	    login.enterUsername("tomsmith");
	    login.enterPassword(RandomStringUtils.random(10));
	    login.clickLogin();
	    
	    login.verifyFlashText("Your password is invalid!");
    }
}
