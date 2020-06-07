package practice.E2Eproject;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class HomePage extends Base {
	public WebDriver driver;
	private static Logger log= LogManager.getLogger(HomePage.class.getName());
	@BeforeTest
	public void openBrowser() throws IOException
	{
		driver=browserInvoke();
		log.info("browser invoked for login case");
		driver.get(prop.getProperty("url"));
		log.info("url entered");
	}
	
	@Test(dataProvider="getData")
	public void pageNavigation(String email, String password) throws IOException
	{
		System.out.println("new from github");
		driver.get(prop.getProperty("url"));
		LandingPage lp=new LandingPage(driver);
		
		lp.clickLogin().click();
		
		LoginPage sign=new LoginPage(driver);
		sign.getEmail().sendKeys(email);
		log.info("email entered");
		sign.getPassword().sendKeys(password);
		log.info("password entered");
		sign.getButton().click();
		log.info("sign in clicked");
		
	}

	@DataProvider
	public Object[][] getData()
	{
		Object[][] data=new Object[2][2];
		data[0][0]="abc@gmail.com";
		data[0][1]="test123";
		
		data[1][0]="abc@gmail";
		data[1][1]="123456";
		
		return data;
	}
	@AfterTest
	public void closeDriver()
	{
		driver.close();
		log.info("browser closed");
	}
}
