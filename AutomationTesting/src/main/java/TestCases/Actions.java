package TestCases;


import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Actions {
	
	WebDriver driver;
	@BeforeTest
	public void LaunchBrowser() {
		System.setProperty("webdriver.chrome.driver","D:\\workspace\\AutomationTesting\\Drivers\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		//driver.navigate().to("https://www.browserstack.com/");
	}

	@Test(priority = 0)
	public void Mousehouver() throws InterruptedException {
		driver.navigate().to("https://www.browserstack.com/"); 
		WebElement DevelopersTab=driver.findElement(By.xpath("//span[@class='nav_item_name']"));
         org.openqa.selenium.interactions.Actions action=new org.openqa.selenium.interactions.Actions(driver);
         action.moveToElement(DevelopersTab).build().perform();
         Thread.sleep(3000);
         String title=driver.getTitle();
         Reporter.log(title,true);
         String url=driver.getCurrentUrl();
         Reporter.log(url,true);
         
         //for clicking on the support link under developers tab
         WebElement Supportlink=driver.findElement(By.xpath("//a[text()='Support']"));
         Supportlink.click();
         Thread.sleep(3000);
        String title1=driver.getTitle();
        Reporter.log(title1,true);
        String url1=driver.getCurrentUrl();
        Reporter.log(url1,true);
		
	}
	@Test(priority = 1)
	public void RightClick() throws InterruptedException {
		driver.navigate().to("http://demo.guru99.com/test/simple_context_menu.html");
		WebElement text=driver.findElement(By.xpath("//span[text()='right click me']"));
		
		org.openqa.selenium.interactions.Actions action=new org.openqa.selenium.interactions.Actions(driver);
		action.contextClick(text).build().perform();
		String Title=driver.getTitle();
		Reporter.log(Title,true);
		 String url=driver.getCurrentUrl();
	        Reporter.log(url,true);
	        Thread.sleep(5000);
	}
//	@Test(priority = 2)
//	public void DoubleClick() throws InterruptedException {
//		driver.navigate().to("http://demo.guru99.com/test/simple_context_menu.html");
//        WebElement text=driver.findElement(By.xpath("//button[text()='Double-Click Me To See Alert']"));
//		
//		org.openqa.selenium.interactions.Actions action=new org.openqa.selenium.interactions.Actions(driver);
//		action.doubleClick(text).build().perform();
//		Thread.sleep(10000);
//		Alert alert=driver.switchTo().alert();
//		alert.accept();
//		String Title=driver.getTitle();
//		Reporter.log(Title,true);
//		 String url=driver.getCurrentUrl();
//	        Reporter.log(url,true);
//	}
	
	@Test(priority = 2)
	public void DragandDrop() {
		driver.navigate().to("https://demoqa.com/droppable");
        WebElement source=driver.findElement(By.id("draggable"));
        WebElement destination=driver.findElement(By.id("droppable"));
        org.openqa.selenium.interactions.Actions action=new org.openqa.selenium.interactions.Actions(driver);
        action.dragAndDrop(source, destination).build().perform();
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
