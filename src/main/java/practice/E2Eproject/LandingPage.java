package practice.E2Eproject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {
	public WebDriver driver;
	By login= By.xpath("//i[@class='fa fa-lock fa-lg']");
	By heading= By.xpath("//div[@class='text-center']/h2");
	By navbar=By.xpath("//ul[@class='nav navbar-nav navbar-right']/li[i]");
	
	public LandingPage(WebDriver driver) {
		this.driver=driver;
	}

	public WebElement clickLogin()
	{
	
	return driver.findElement(login);	
	}
	
	public WebElement getHeading()
	{
		return driver.findElement(heading);
	}
	
	public WebElement getNavBar()
	{
		
		
		return driver.findElement(navbar);
	}
	
	

}
