package hybridApp1;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import hybridApp.HybridCapabilities;
import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class GeneralStore extends HybridCapabilities{
	
AndroidDriver<AndroidElement> driver;
	
	@BeforeTest
	public void bt() throws MalformedURLException {
		
		driver = capabilities();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
	}
	
	@Test(enabled=true)
	public void genStoreOpen() throws InterruptedException {
		
		driver.findElement(MobileBy.id("android:id/text1")).click();
		
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Aruba\"))");
		
		driver.findElement(MobileBy.xpath("//*[@text='Aruba']")).click();
		
		driver.findElement(MobileBy.id("com.androidsample.generalstore:id/nameField")).sendKeys("Alka");
		
		driver.hideKeyboard();
		
		driver.findElement(MobileBy.id("com.androidsample.generalstore:id/radioFemale")).click();
		
		driver.findElement(MobileBy.id("com.androidsample.generalstore:id/btnLetsShop")).click();
		
		driver.findElements(MobileBy.xpath("//*[@text='ADD TO CART']")).get(0).click();
		
		driver.findElements(MobileBy.xpath("//*[@text='ADD TO CART']")).get(0).click();
		
//		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Air Jordan 9 Retro\"))");
		
//		driver.findElements(MobileBy.xpath("//*[@text='ADD TO CART']")).get(0).click();
		
		driver.findElement(MobileBy.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
		Thread.sleep(3000);
		
		String message = driver.findElement(MobileBy.xpath("//*[@text='$160.97']")).getText();
	    String product1 = message.substring(1);
	    Double  Istproduct  = Double.parseDouble(product1);
		
		System.out.println(message);
		
		String message1 = driver.findElement(MobileBy.xpath("//*[@text='$120.0']")).getText();
  	    String product2 = message1.substring(1);
	    Double  IIndproduct  = Double.parseDouble(product2);
		System.out.println(message1);
		
		String message2 = driver.findElement(MobileBy.id("com.androidsample.generalstore:id/totalAmountLbl")).getText();
		System.out.println("Total Purchase Amount :" + message2);
		String totalPrice = message2.substring(1);
		Double totalPrice1 = Double.parseDouble(totalPrice);
		System.out.println("Total Purchase Amount :" + totalPrice);
		Double total = Istproduct + IIndproduct;
		
		if(total.equals(totalPrice1)) {
			System.out.println("Cost Matching");
		}else {
			System.out.println("Cost Not Matching");
		}
		
		driver.findElement(MobileBy.xpath("//*[@text='Send me e-mails on discounts related to selected products in future']")).click();
		driver.findElement(MobileBy.id("com.androidsample.generalstore:id/btnProceed")).click();
		
	}
	
	
	
		
	}


