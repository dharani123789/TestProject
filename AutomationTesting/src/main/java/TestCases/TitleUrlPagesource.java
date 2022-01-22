package TestCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TitleUrlPagesource {

	WebDriver driver;
	@BeforeTest
	public void LaunchBrowser() {
		System.setProperty("webdriver.chrome.driver","D:\\workspace\\AutomationTesting\\Drivers\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("http://www.facebook.com");
	}
	@Test(priority = 2)
	public void title1() {
		
		String Title=driver.getTitle();
		Reporter.log(Title,true);
			}
	
	@Test(priority = 1)
	public void url1() {
		
		String Url=driver.getCurrentUrl();
		Reporter.log(Url,true);
		
	}
	
	@Test(priority = 0)
	public void Pagesource1() {
		
		String Pagesource=driver.getPageSource();
		Reporter.log(Pagesource,true);
		
	}
	
	
	@AfterTest
	public void CloseBrowser() {
		driver.quit();
	}
	
}
