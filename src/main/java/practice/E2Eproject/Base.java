package practice.E2Eproject;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Base {
	public static WebDriver driver;
	Properties prop=new Properties();
	public WebDriver browserInvoke() throws IOException
	{
		
		FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\resources\\Data.properties");
		prop.load(fis);
		//String browserName=prop.getProperty("browser"); //this will get browser from data file
		String browserName=System.getProperty("browser"); //to take browser not from data file but from jenkins build
		if(browserName.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\src\\main\\java\\resources\\chromedriver.exe");
			
			ChromeOptions options= new ChromeOptions(); // used for running test without opening browser window
			options.addArguments("headless","user-agent=rock");
			driver=new ChromeDriver(options);	
		}
		else if(browserName.equals("firefox"))
		{
			
		}
		else if(browserName.equals("IE"))
		{
			
		}
		//driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		return driver;
		}
	
	public String getScreenShotPath(String testCaseName,WebDriver driver) throws IOException

	{

	TakesScreenshot ts=(TakesScreenshot) driver;

	File source =ts.getScreenshotAs(OutputType.FILE);

	String destinationFile = System.getProperty("user.dir")+"\\reports\\"+testCaseName+".png";

	FileUtils.copyFile(source,new File(destinationFile));

	return destinationFile;

	}
	

}
