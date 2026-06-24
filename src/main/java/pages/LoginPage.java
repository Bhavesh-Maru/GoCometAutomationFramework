package pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.qameta.allure.Step;

public class LoginPage {
	
	Wait<WebDriver> wait;
	
	@FindBy(how = How.ID, using="username")
	private WebElement username;
	
	@FindBy(how = How.ID, using="password")
	private WebElement password;
	
	@FindBy(how = How.CSS, using=".radius")
	private WebElement loginBtn;
	
	@FindBy(how = How.ID, using="flash")
	private WebElement flash;
	
	public LoginPage(WebDriver driver) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		PageFactory.initElements(driver, this);
	}
	
	@Step("Enter $username")
	public void enterUsername(String username) {
		this.username.sendKeys(username);
	}
	
	@Step("Enter $password")
	public void enterPassword(String password) {
		this.password.sendKeys(password);
	}
	
	@Step("Click on login submit button")
	public void clickLogin() {
		this.loginBtn.click();
	}
	
	@Step("Verify Flash message after login")
	public void verifyFlashText(String expectedText) {
		wait.until(ExpectedConditions.visibilityOf(this.flash));
		Assert.assertTrue(flash.getText().contains(expectedText));
	}
}
