package TestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CheckboxRadiobutton {

	
	WebDriver driver;
	@BeforeTest
	public void LaunchBrowser() {
		System.setProperty("webdriver.chrome.driver","D:\\workspace\\AutomationTesting\\Drivers\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("https://demo.guru99.com/test/radio.html");
	}
	@Test(priority = 0)
	public void Radiobutton() {
		
		driver.findElement(By.xpath("//input[@value='Option 2']")).click();
	}
	
	@Test(priority = 1)
	public void checkboxes() throws InterruptedException {
		
		driver.findElement(By.xpath("//input[@value='checkbox2']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@value='checkbox3']")).click();
		Thread.sleep(3000);
	
	}
	
	@AfterTest
	public void CloseBrowser() {
		driver.quit();
	}
}
