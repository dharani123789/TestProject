package TestCases;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Alerts {

	
	WebDriver driver;
	@BeforeTest
	public void LaunchBrowser() {
		System.setProperty("webdriver.chrome.driver","D:\\workspace\\AutomationTesting\\Drivers\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("https://demoqa.com/alerts");
	}
	
	
	
	//leaning automation testing the tool is selinium webdriver
	//programming language is java
	
	
	@Test
	public void handlingAlerts() throws InterruptedException {
		driver.findElement(By.id("alertButton")).click();
		Alert alert=driver.switchTo().alert();
		alert.accept();
		Thread.sleep(3000);
		driver.findElement(By.id("timerAlertButton")).click();
		Thread.sleep(7000);
		Alert alert1=driver.switchTo().alert();
		alert1.accept();
		Thread.sleep(5000);
		driver.findElement(By.id("confirmButton")).click();
		Alert alert2=driver.switchTo().alert();
		alert2.accept();
		Thread.sleep(3000);
		String output=driver.findElement(By.id("confirmResult")).getText();
		System.out.println("the result is:"+output);
		WebElement button=driver.findElement(By.id("promtButton"));
		button.click();
		Alert alert3=driver.switchTo().alert();
		alert.sendKeys("sample");
		alert3.accept();
		String output1=driver.findElement(By.id("promptResult")).getText();
		System.out.println("the result is:"+output1);
		
		
	}
	
	
	@AfterTest
	public void CloseBrowser() {
		driver.quit();
	}
	
}
