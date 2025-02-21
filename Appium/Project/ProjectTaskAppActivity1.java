package projectactivities;

import static projectactivities.ActionBase.doSwipe;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class ProjectTaskAppActivity1  {

	AppiumDriver driver;
	WebDriverWait wait;

	@BeforeClass
	public void setup() throws MalformedURLException, URISyntaxException {
		// Desired Capabilities
		UiAutomator2Options options = new UiAutomator2Options();
		options.setPlatformName("android");
		options.setAutomationName("UiAutomator2");
		options.setAppPackage("com.android.chrome");
		options.setAppActivity("com.google.android.apps.chrome.Main");
		options.noReset();

		// Server Address
		URL serverURL = new URI("http://localhost:4723").toURL();
		// Driver Initialization
		driver = new AndroidDriver(serverURL, options);
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.get("https://v1.training-support.net/selenium");
	}

	@Test
	public void toDoTest() throws InterruptedException {

		wait.until(ExpectedConditions
				.visibilityOfElementLocated(AppiumBy.xpath("//android.view.View[@text=\"Selenium\"]")));

		Dimension dims = driver.manage().window().getSize();
		Point start = new Point((int) (dims.getWidth() * .42), (int) (dims.getHeight() * .83));
		Point end = new Point((int) (dims.getWidth() * .45), (int) (dims.getHeight() * .20));

		doSwipe(driver, start, end, 2000);
		doSwipe(driver, start, end, 2000);
		doSwipe(driver, start, end, 2000);
		doSwipe(driver, start, end, 2000);

		wait.until(ExpectedConditions.visibilityOfElementLocated(
				AppiumBy.xpath("//android.view.View[@text=\"To-Do List  Elements get added at run time \"]"))).click();
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(AppiumBy.xpath("//android.widget.EditText[@resource-id=\"taskInput\"]")))
				.sendKeys("meeting");

		driver.findElement(AppiumBy.xpath("//android.widget.Button[@text=\"Add Task\"]")).click();
		Thread.sleep(5000);
		List<WebElement> list2 = driver
				.findElements(AppiumBy.xpath("//android.view.View[@resource-id=\"tasksList\"]/android.view.View"));

		System.out.println(list2.size());
		for (int i = 2; i <= list2.size(); i++) {
			WebElement element = driver.findElement(AppiumBy.xpath(
					"//android.view.View[@resource-id=\"tasksList\"]/android.view.View[" + i + "]/android.view.View"));
			String text = element.getText();
			System.out.println(text);
			driver.findElement(AppiumBy.xpath("//android.view.View[@text=\"" + text + "\"]")).click();
			Thread.sleep(4000);
		}
		driver.findElement(AppiumBy.xpath("//android.view.View[@text=\" Clear List\"]")).click();

	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}

}
