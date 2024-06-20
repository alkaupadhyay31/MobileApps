package nativeApp1;

import java.net.MalformedURLException;



import java.util.concurrent.TimeUnit;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.touch.LongPressOptions;
import nativeApp.ApiCapabilities;
import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static java.time.Duration.ofSeconds;
public class ApiDemos extends ApiCapabilities {
	
	AndroidDriver<AndroidElement> driver;
	
	@BeforeTest
	public void bt() throws MalformedURLException {
		driver = capabilities();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
	}
	
	@Test(enabled = false)
	public void accessibility() throws InterruptedException {
		driver.findElement(MobileBy.AccessibilityId("Access'ibility")).click();
		Thread.sleep(2000);
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		driver.findElement(MobileBy.AccessibilityId("Preference")).click();
		driver.findElement(MobileBy.AccessibilityId("3. Preference dependencies")).click();
		driver.findElement(MobileBy.id("android:id/checkbox")).click();
//		driver.findElement(MobileBy.xpath("//*[@text='WiFi settings']")).click();
//		Another way of using text which you can follow easily is
//		use AndroidUIAutomator
		
		driver.findElement(MobileBy.AndroidUIAutomator("UiSelector().text(\"WiFi settings\")")).click();
		driver.findElement(MobileBy.id("android:id/edit")).sendKeys("Alka");
		driver.findElement(MobileBy.id("android:id/button2")).click();
		driver.hideKeyboard();
		
	}
	
	@Test(enabled = false)
	public void notification() {
		driver.openNotifications();
		driver.findElements(MobileBy.className("android.widget.ImageView")).get(4).click();
		
	}
	
	@Test(enabled = false)
	public void views() {
		System.out.println("view open");
		driver.findElement(MobileBy.AccessibilityId("Views")).click();
//		If you have to scroll you need three things
//		1. UIAutomator
//		2. UiSelector
//		3. UiScrollable
//		4. scrollIntoview
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"WebView\"))");
		
	}
	@Test(enabled = false)
	public void longPress() {
		driver.findElement(MobileBy.AccessibilityId("Views")).click();	
		driver.findElement(MobileBy.AccessibilityId("Expandable Lists")).click();
		driver.findElement(MobileBy.AccessibilityId("1. Custom Adapter")).click();
		AndroidElement fishes = driver.findElement(MobileBy.xpath("//*[@text='Fish Names']"));
		TouchAction ta = new TouchAction(driver);
		ta.longPress(longPressOptions().withElement(element(fishes)).withDuration(ofSeconds(5))).release().perform();
		
		
	}
	
	@Test(enabled = false)
	public void draganddrop() {
		driver.findElement(MobileBy.AccessibilityId("Views")).click();	
		driver.findElement(MobileBy.AccessibilityId("Drag and Drop")).click();
		AndroidElement drag = driver.findElement(MobileBy.id("io.appium.android.apis:id/drag_dot_1"));
	    AndroidElement drop= driver.findElement(MobileBy.id("io.appium.android.apis:id/drag_dot_3"));
	    TouchAction ta = new TouchAction(driver);
	    
	    ta.longPress(longPressOptions().withElement(element(drag)).withDuration(ofSeconds(3))).moveTo(element(drop)).release().perform();
	}
	
	@Test(enabled = false)
	public void dateWidget() {
		driver.findElement(MobileBy.AccessibilityId("Views")).click();	
		driver.findElement(MobileBy.AccessibilityId("Date Widgets")).click();
		driver.findElement(MobileBy.AccessibilityId("2. Inline")).click();
		AndroidElement first = driver.findElement(MobileBy.AccessibilityId("12"));
	    AndroidElement second = driver.findElement(MobileBy.AccessibilityId("5"));
	    TouchAction ta = new TouchAction(driver);
	    
	    ta.longPress(longPressOptions().withElement(element(first)).withDuration(ofSeconds(3))).moveTo(element(second)).release().perform();
	}
	
	@Test(enabled = true)
	public void message() throws InterruptedException {
		driver.findElement(MobileBy.AccessibilityId("OS")).click();	
		driver.findElement(MobileBy.AccessibilityId("SMS Messaging")).click();	
		driver.findElement(MobileBy.AccessibilityId("Enable SMS broadcast receiver")).click();
		driver.findElement(MobileBy.id("io.appium.android.apis:id/sms_recipient")).sendKeys("(650) 555-1212");
		driver.findElement(MobileBy.id("io.appium.android.apis:id/sms_content")).sendKeys("Hello");
		driver.hideKeyboard();
		driver.findElement(MobileBy.AccessibilityId("Send")).click();	
		
//		driver.activateApp("com.google.android.apps.messaging");
//		Thread.sleep(8000);
//	    String msg = driver.findElement(MobileBy.id("com.google.android.apps.messaging:id/conversation_snippet")).getText();
//		driver.activateApp("io.appium.android.apis");
//		Thread.sleep(3000);
//		System.out.println(msg);
		driver.pressKey(new KeyEvent(AndroidKey.APP_SWITCH));
		
		
	}
	
	
	
	

}
