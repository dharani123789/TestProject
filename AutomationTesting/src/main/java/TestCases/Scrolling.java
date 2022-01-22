package TestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Scrolling {
   
	WebDriver driver;
	@BeforeTest
	public void LaunchBrowser() {
		System.setProperty("webdriver.chrome.driver","D:\\workspace\\AutomationTesting\\Drivers\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("http://www.facebook.com");
	}
	@Test
	public void scrolldown() {
		//WebElement develop=driver.findElement(By.xpath("//a[@title='Develop on our platform.']"));
		Actions action=new Actions(driver);
		action.sendKeys(Keys.PAGE_DOWN).build().perform();
		//develop.click();
	}
	@Test
	public void scrollup () throws InterruptedException {
		WebElement email=driver.findElement(By.id("email"));
		Actions action=new Actions(driver);
		action.sendKeys(Keys.PAGE_UP).build().perform();
		email.sendKeys("Sample@gmail.com");
		Thread.sleep(3000);
	}
	
	@AfterTest
	public void CloseBrowser() {
		driver.close();
	}
}
