package ecommerce;
import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class ecommerce_tc_1 extends baseEcommerce{

	
	public static void main(String[] args) throws MalformedURLException {
		
		AndroidDriver<AndroidElement> driver = Capabilities();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.findElementById("com.androidsample.generalstore:id/nameField").sendKeys("hello");
		
		driver.findElementByXPath("//*[@text='Female']").click();
		
		driver.hideKeyboard();
		
		driver.findElementById("android:id/text1").click();
		
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Argentina\"));");
		
		driver.findElementByXPath("//*[@text='Argentina']").click();
		
		driver.findElementById("com.androidsample.generalstore:id/btnLetsShop").click();
				
	}
}
