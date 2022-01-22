package TestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FileUpload {

	WebDriver driver;
	
	@BeforeTest
	public void launchbrowser() {
		
		System.setProperty("webdriver.chrome.driver", "D:\\workspace\\AutomationTesting\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demo.guru99.com/test/upload/");
		
	}
	@Test
	public void uploadingfile() throws InterruptedException {
		WebElement uploadfile=driver.findElement(By.name("uploadfile_0"));
		//uploadfile.click();
		
		uploadfile.sendKeys("C:\\Users\\Dharani\\Downloads\\image.jpg");
		Thread.sleep(5000);
		driver.findElement(By.name("terms")).click();
		driver.findElement(By.id("submitbutton")).click();
		
		String Title=driver.getTitle();
		Reporter.log(Title,true);
		String url=driver.getTitle();
		Reporter.log(url,true);
		
	}
	@AfterTest
	public void CloseBrowser() {
		driver.close();
	}
}
