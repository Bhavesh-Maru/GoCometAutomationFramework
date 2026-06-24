package setup;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import utility.PropertyClass;

public class BaseTest {
	  public static ThreadLocal<WebDriver> drivers = new ThreadLocal<WebDriver>();
	  PropertyClass property;
	  
	  @BeforeMethod
	  public void setup() throws IOException{
		  property = new PropertyClass();
		  
		  drivers.set(new FirefoxDriver());
		  driver().manage().window().maximize();
		  driver().get(property.getUrl());
	  }
	  
	  public synchronized WebDriver driver() {
		  return drivers.get();
	  }
	  
	  @AfterMethod
	  public void teardown(){
	    driver().quit();
	  }
	}
