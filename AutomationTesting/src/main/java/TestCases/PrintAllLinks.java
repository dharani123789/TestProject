package TestCases;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class PrintAllLinks {

	WebDriver driver;
	@BeforeTest
	public void LaunchBrowser() {
		System.setProperty("webdriver.chrome.driver","D:\\workspace\\AutomationTesting\\Drivers\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("http://www.facebook.com");
	}
	@Test
	public void alllinks() {
		List<WebElement>alllinks=driver.findElements(By.tagName("a"));
		System.out.println(alllinks.size());
		
		for(int i=0;i<alllinks.size();i++) {
			Reporter.log(alllinks.get(i).getText(),true);
	     }
	}
	@AfterTest
	public void CloseBrowser() {
		driver.close();
	}
}
