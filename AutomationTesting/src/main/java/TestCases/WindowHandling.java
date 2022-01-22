package TestCases;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class WindowHandling {
	
	WebDriver driver;
	@BeforeTest
	public void LaunchBrowser() {
		System.setProperty("webdriver.chrome.driver","D:\\workspace\\AutomationTesting\\Drivers\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("http://seleniumpractise.blogspot.com/2017/07/multiple-window-examples.html");
	}
	@Test
	public void windowhandle() {
		
		
		driver.findElement(By.xpath("(//a[text()=' Click this link to start new Tab '])[1]")).click();
		driver.findElement(By.xpath("(//a[text()=' Click this link to start new Tab '])[2]")).click();
		driver.findElement(By.xpath("(//a[text()=' Click this link to start new Tab '])[3]")).click();
		driver.findElement(By.xpath("(//a[text()=' Click this link to start  Session in same window'])")).click();
		String parentwindow=driver.getWindowHandle();
		System.out.println(parentwindow);
		String Title=driver.getTitle();
		Reporter.log(Title,true);
		String url=driver.getCurrentUrl();
		Reporter.log(url,true);
		Set<String> allwindows=driver.getWindowHandles();
		ArrayList<String> allTabs=new ArrayList<String>(allwindows);
		System.out.println(allwindows.size());
//		driver.switchTo().window(allTabs.get(1));
//		String Title1=driver.getTitle();
//		Reporter.log(Title1,true);
//		driver.
		
		for(int i=0;i<allTabs.size();i++) {
			driver.switchTo().window(allTabs.get(i));
			String Titles=driver.getTitle();
			Reporter.log(Titles,true);
			String urls=driver.getCurrentUrl();
			Reporter.log(urls,true);
		}
		
		
//		for (String window:allwindows) {
//			if(!parentwindow.equals(window)) {
//				driver.switchTo().window(window)
//			}
//		}
	}
	
	
	
	@AfterTest
	public void CloseBrowser() {
		driver.quit();
	}

}
