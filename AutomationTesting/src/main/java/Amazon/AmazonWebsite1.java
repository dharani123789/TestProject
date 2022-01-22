package Amazon;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;

public class AmazonWebsite1 {
	
	private static ChromeDriver driver;
	 
	 public static String readData(String key) throws IOException {
		 Properties properties=new Properties();
		 FileInputStream fileinputstream=new FileInputStream("D:\\workspace\\AutomationTesting\\src\\main\\java\\Amazon\\AmazonData.properties");
		 properties.load(fileinputstream);
		 String value=properties.getProperty(key);
		 return value;
	}
	public static void main (String[] args) throws InterruptedException, IOException {
		System.setProperty("webdriver.chrome.driver","D:\\workspace\\AutomationTesting\\Drivers\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.amazon.in/ap/register?showRememberMe=true&openid.pape.max_auth_age=900&openid.identity=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&pageId=inflex&openid.return_to=https%3A%2F%2Fwww.amazon.in%2Fap%2Fcnep%3Fie%3DUTF8%26orig_return_to%3Dhttps%253A%252F%252Fwww.amazon.in%252Fyour-account%26openid.assoc_handle%3Dinflex%26pageId%3Dinflex&prevRID=X5SJ1FAP1YMGFV81ZGZV&openid.assoc_handle=inflex&openid.mode=checkid_setup&openid.ns.pape=http%3A%2F%2Fspecs.openid.net%2Fextensions%2Fpape%2F1.0&prepopulatedLoginId=&failedSignInCount=0&openid.claimed_id=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.ns=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0");
	    Thread.sleep(3000);
	    driver.findElement(By.id("ap_customer_name")).sendKeys(readData("name"));
	    //driver.findElement(By.id("ap_phone_number")).sendKeys(readData("phonenumber"));
	    driver.findElement(By.id("ap_email")).sendKeys(readData("email"));
	    driver.findElement(By.id("ap_password")).sendKeys(readData("password"));
	    driver.findElement(By.id("ap_password_check")).sendKeys(readData("passwordAgain"));
	    
	    String Title=driver.getTitle();
	    Reporter.log(Title,true);
	    String url=driver.getTitle();
	    Reporter.log(url,true);
	}
	
	public void closeBrowser() {
		driver.close();
	}

}
