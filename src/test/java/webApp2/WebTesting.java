package webApp2;

import java.net.MalformedURLException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.w3c.dom.Text;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class WebTesting extends WCapabilities{
AndroidDriver<AndroidElement> driver;
	
	@BeforeTest
	public void bt() throws MalformedURLException {
		
		driver = capabilities();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
	}
		
		@Test (enabled = true)
		public void testing() throws InterruptedException {
			
			driver.get("https://www.google.com/");
			WebElement text = driver.findElement(MobileBy.xpath("//textarea[@class='gLFyf']"));
			
		    text.sendKeys("masai");
		    text.sendKeys(Keys.ENTER);
		    
		   
		   
		   List<AndroidElement> links = driver.findElements(By.tagName("a"));
		   
		   System.out.println("total : "+ links.size());
		   
		   
			for (AndroidElement link : links) {
				
				
				String hrefval = link.getAttribute("href");
				
				
				System.out.println(hrefval);
				
			}
				
				JavascriptExecutor js = (JavascriptExecutor)driver;
				
//				js.executeScript("window.scrollBy(0,300)");
				
				AndroidElement MP = driver.findElement(MobileBy.xpath("//*[text()='Maasai people']"));
				
				Thread.sleep(3000);
				
				js.executeScript("arguments[0].scrollIntoView();", MP);
				
				driver.findElement(MobileBy.xpath("//*[text()='Maasai people']")).click();
				
		}
				
		
		
		@Test (enabled = false)
		public void orangeHrm() throws InterruptedException {
			
			driver.get("https://www.google.com/");
			WebElement text = driver.findElement(MobileBy.xpath("//textarea[@class='gLFyf']"));
			
			text.sendKeys("orangehrmLogin");
		    text.sendKeys(Keys.ENTER);
			
		    driver.findElement(MobileBy.xpath("(//div[text()='OrangeHRM'])[1]")).click();
		    
		    Thread.sleep(3000);
			
		    driver.findElement(MobileBy.xpath("//input[@name='username']")).sendKeys("Admin");
		    
		    Thread.sleep(3000);
		    
		    driver.findElement(MobileBy.xpath("//input[@name='password']")).sendKeys("admin123");
		    
		    driver.hideKeyboard();
		    
		    Thread.sleep(3000);
		    
		    driver.findElement(By.xpath("//button[@type='submit']")).click();
		    
		    
		   
		    
		    
			
		}
		
}
