package tests;

import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.offset.ElementOption;

public class APIDemos_View_SecureView {
	
	AndroidDriver<AndroidElement> driver;
	
	@Test
	void testSecureView() throws Exception
	{
		
		DesiredCapabilities cap=new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Galaxy");
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, "12");
		cap.setCapability("appPackage","io.appium.android.apis");
		cap.setCapability("appActivity","io.appium.android.apis.ApiDemos");
		driver=new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"),cap);
		TouchAction action=new TouchAction(driver);
		AndroidElement viewsElement=driver.findElement(By.xpath("//*[@text='Views']"));
		action.tap(ElementOption.element(viewsElement)).perform();
		Thread.sleep(1000);
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Secure View\"))");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[contains(@text,'Secure View')]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[contains(@text,'POP TOAST')]")).click();
		Thread.sleep(3000);
		driver.quit();
		
	}
	
	

}
