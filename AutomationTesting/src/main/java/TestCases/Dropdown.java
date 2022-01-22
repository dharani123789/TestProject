package TestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Dropdown {

	
	WebDriver driver;
	@BeforeTest
	public void LaunchBrowser() {
		System.setProperty("webdriver.chrome.driver","D:\\workspace\\AutomationTesting\\Drivers\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("http://www.facebook.com");
	}
	@Test
	public void dropdowns() throws InterruptedException {
		
		String Title=driver.getTitle();
		Reporter.log(Title,true);
		String url=driver.getCurrentUrl();
		Reporter.log(url,true);
		driver.findElement(By.xpath("//a[text()='Create New Account']")).click();
		Thread.sleep(3000);
		driver.findElement(By.name("firstname")).sendKeys("selenium");
		driver.findElement(By.name("lastname")).sendKeys("testing");
		driver.findElement(By.name("reg_email__")).sendKeys("selinium@gmail.com");
		driver.findElement(By.id("password_step_input")).sendKeys("testing");
		
		WebElement daydropdown=driver.findElement(By.id("day"));
		Select day=new Select(daydropdown);
		day.selectByIndex(5);
		
		WebElement monthdropdown=driver.findElement(By.id("month"));
		Select month=new Select(monthdropdown);
		month.selectByValue("8");
		
		WebElement yeardropdown=driver.findElement(By.name("birthday_year"));
		Select year=new Select(yeardropdown);
		year.selectByVisibleText("2004");
		
		driver.findElement(By.xpath("//label[text()='Female']")).click();
		String Title1=driver.getTitle();
		Reporter.log(Title1,true);
		String url1=driver.getCurrentUrl();
		Reporter.log(url1,true);
		
		
	}
	
	
	
	
	
	
	
	@AfterTest
	public void CloseBrowser() {
		driver.quit();
	}
}
