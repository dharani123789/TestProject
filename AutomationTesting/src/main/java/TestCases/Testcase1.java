package TestCases;

import javax.xml.stream.XMLReporter;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Testcase1 {

	WebDriver driver;
	@BeforeTest
	public void LaunchBrowser() {
		System.setProperty("webdriver.chrome.driver","D:\\workspace\\AutomationTesting\\Drivers\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("http://www.facebook.com");
	}
	@Test
	public void facebook() {
		driver.findElement(By.xpath("//a[text()='Create New Account']"));
		String Title=driver.getTitle();
	     Reporter.log(Title,true);
	     String url=driver.getCurrentUrl();
	     Reporter.log(url,true);
	}
	
	@AfterTest
	public void CloseBrowser() {
		driver.close();
	}
}
