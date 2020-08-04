package ecommerce;
import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.testng.Assert;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class ecommerce_tc_2 extends baseEcommerce{

	
	public static void main(String[] args) throws MalformedURLException {
		
		AndroidDriver<AndroidElement> driver = Capabilities();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.findElementByXPath("//*[@text='Female']").click();
		
		driver.hideKeyboard();
		
		
		driver.findElementById("android:id/text1").click();
		
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Argentina\"));");
		
		driver.findElementByXPath("//*[@text='Argentina']").click();
		
		driver.findElementById("com.androidsample.generalstore:id/btnLetsShop").click();
		
		//Toast message capture
		//name attribute for toast message has the content
		String toastMessage = driver.findElementByXPath("//android.widget.Toast").getAttribute("name");
		
		System.out.println(toastMessage);
		
		Assert.assertEquals(toastMessage, "Please enter your name");
		
		
		
	}
}
