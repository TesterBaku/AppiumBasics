package ecommerce;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.offset.PointOption;

import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static java.time.Duration.ofSeconds;
import static io.appium.java_client.touch.offset.ElementOption.element;

public class ecommerce_tc_4 extends baseEcommerce {

	public static void main(String[] args) throws MalformedURLException, InterruptedException {

		AndroidDriver<AndroidElement> driver = Capabilities();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.findElementById("com.androidsample.generalstore:id/nameField").sendKeys("hello");

		driver.findElementByXPath("//*[@text='Female']").click();

		driver.hideKeyboard();

		driver.findElementById("android:id/text1").click();

		driver.findElementByAndroidUIAutomator(
				"new UiScrollable(new UiSelector()).scrollIntoView(text(\"Argentina\"));");

		driver.findElementByXPath("//*[@text='Argentina']").click();

		driver.findElementById("com.androidsample.generalstore:id/btnLetsShop").click();
		
		driver.findElementsByXPath("//*[@text='ADD TO CART']").get(0).click();
		driver.findElementsByXPath("//*[@text='ADD TO CART']").get(0).click();
		driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
		
		Thread.sleep(4000);
		
		String amount1 = driver.findElementsById("com.androidsample.generalstore:id/productPrice").get(0).getText();
		double amountValue1 = getAmount(amount1);
		
		String amount2 = driver.findElementsById("com.androidsample.generalstore:id/productPrice").get(1).getText();
		System.out.println(amount2);
		double amountValue2 = getAmount(amount2);
		
		double sumOfProducts = amountValue1 + amountValue2;
		System.out.println("sum of products: " + sumOfProducts);
		
		String total = driver.findElementById("com.androidsample.generalstore:id/totalAmountLbl").getText();
		
		double totalValue = Double.parseDouble(total = total.substring(1));
		
		Assert.assertEquals(sumOfProducts, totalValue);
		
		//Mobile gestures
		
		WebElement checkbox = driver.findElementByClassName("android.widget.CheckBox");
		
		TouchAction t = new TouchAction(driver);
		t.tap(tapOptions().withElement(element(checkbox))).perform();
		
		WebElement link = driver.findElementByXPath("//*[@text = 'Please read our terms of conditions']");
//		t.longPress(longPressOptions().withElement(element(link)).withDuration(ofSeconds(2))).release().perform();
		
		
		t.longPress(longPressOptions().withElement(element(link)).withPosition(PointOption.point(540, 1964)).withDuration(ofSeconds(2))).release().perform();
		
		driver.findElementById("android:id/button1").click();
		driver.findElementById("com.androidsample.generalstore:id/btnProceed").click();
	}
	
	public static double getAmount(String value) {
		
		value = value.substring(1);
		double amountValue = Double.parseDouble(value);
		return amountValue;
	}
	
}
