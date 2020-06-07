package practice.E2Eproject;



import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ValidateText extends Base{
	public WebDriver driver;
	private static Logger log= LogManager.getLogger(HomePage.class.getName());
	@BeforeTest
	public void openBrowser() throws IOException
	{
		driver=browserInvoke();
		log.info("browser invoked for validation test case");
		driver.get(prop.getProperty("url"));
	}
	
	@Test
	public void Validate() throws IOException
	{
		
		LandingPage l=new LandingPage(driver);
		Assert.assertEquals(l.getHeading().getText(), "FEATURED COURSES");
	
		}
	
	@AfterTest
	public void closeDriver()
	{
		driver.close();
		log.info("browser closed for validation test case");
	}

}
