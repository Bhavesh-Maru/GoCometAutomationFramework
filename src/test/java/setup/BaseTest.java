package setup;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
	  public static ThreadLocal<WebDriver> drivers = new ThreadLocal<WebDriver>();
	  
	  @BeforeMethod
	  public void setup(){
		  drivers.set(new FirefoxDriver());
		  driver().manage().window().maximize();
		  driver().get("https://the-internet.herokuapp.com/login");
	  }
	  
	  public synchronized WebDriver driver() {
		  return drivers.get();
	  }
	  
	  @AfterMethod
	  public void teardown(){
	    driver().quit();
	  }
	}
