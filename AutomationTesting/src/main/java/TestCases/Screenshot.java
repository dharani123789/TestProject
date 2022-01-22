package TestCases;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Screenshot {
	WebDriver driver;
	@BeforeTest
	public void launchbrowser() {
		
		System.setProperty("webdriver.chrome.driver", "D:\\workspace\\AutomationTesting\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://www.facebook.com");
		
	}
	
	@Test
	public void create() throws InterruptedException, IOException {
		
		driver.findElement(By.xpath("//a[text()='Create New Account']")).click();
		Thread.sleep(10000);
		driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys("abcd");
		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("efgh");
		driver.findElement(By.xpath("//input[@name='reg_email__']")).sendKeys("abcdefgh@gmail.com");
		driver.findElement(By.xpath("//input[@name='reg_email_confirmation__']")).sendKeys("abcdefgh@gmail.com");
		driver.findElement(By.xpath("//input[@name='reg_passwd__']")).sendKeys("abcdef1234");
		
		WebElement daydropdown=driver.findElement(By.xpath("//select[@id='day']"));
		Select day=new Select(daydropdown);
		day.selectByIndex(25);
		
		WebElement monthdrropdown=driver.findElement(By.xpath("//select[@id='month']"));
		Select month=new Select(monthdrropdown);
		month.selectByValue("12");
		
		WebElement yeardropdown=driver.findElement(By.xpath("//select[@id='year']"));
		Select year=new Select(yeardropdown);
		year.selectByVisibleText("2006");
		
		driver.findElement(By.xpath("//label[text()='Male']")).click();
		
		Thread.sleep(3000);
		
		String title=driver.getTitle();
		Reporter.log(title,true);
		
		String url=driver.getCurrentUrl();
		Reporter.log(url,true);
		
		
				
		
	File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("D:\\workspace\\AutomationTesting\\Screenshots\\facebook.png"));
		
	}
	
	
	
	@AfterTest
	public void closebrowser() {
		driver.close();

}
}


