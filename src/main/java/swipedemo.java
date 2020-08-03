import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;

import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static java.time.Duration.ofSeconds;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class swipedemo extends base{

	public static void main(String[] args) throws MalformedURLException {
		AndroidDriver<AndroidElement> driver=Capabilities();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.findElementByXPath("//android.widget.TextView[@text='Views']").click();
		driver.findElementByXPath("//android.widget.TextView[@text='Date Widgets']").click();
		driver.findElementByAndroidUIAutomator("text(\"2. Inline\")").click();
		
		driver.findElementByXPath("//*[@content-desc='9']").click();
		
		TouchAction t = new TouchAction(driver);
		
	    //long press on element --> 2 sec ----> move to another element ---> release
		
		WebElement startElement = driver.findElementByXPath("//*[@content-desc='15']");
		WebElement endElement = driver.findElementByXPath("//*[@content-desc='45']");
		
		t.longPress(longPressOptions().withElement(element(startElement)).withDuration(ofSeconds(2))).moveTo(element(endElement)).release().perform();
		

	}

}
