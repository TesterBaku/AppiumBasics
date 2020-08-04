import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class basics extends baseEmulatorAndReal{

	public static void main(String[] args) throws MalformedURLException {
		
		AndroidDriver<AndroidElement> driver = Capabilities("real");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//best locators: xpath, id, classname, androidUIautomator
		
		/** xpath syntax
		 *  //tagname[@attribute='value']
		 *  class name can serve as tag name
		 *  
		 *  Below are some ways of finding element
		 */
		driver.findElementByXPath("//android.widget.TextView[@text='Preference']").click();
		driver.findElementByXPath("//android.widget.TextView[@text='3. Preference dependencies']").click();
		driver.findElementById("android:id/checkbox").click();
		driver.findElementByXPath("(//android.widget.RelativeLayout)[2]").click();
		driver.findElementByClassName("android.widget.EditText").sendKeys("aha");
		driver.findElementsByClassName("android.widget.Button").get(1).click();
		
		
		
		
		
	}

}
