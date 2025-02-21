package projectactivities;

import static projectactivities.ActionBase.doSwipe;

import static org.testng.Assert.assertEquals;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class ProjectKeepAppReminderActivity3 {

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

	}

	@Test(priority = 1)
	public void valid_login_test() {
		driver.get("https://v1.training-support.net/selenium");
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(AppiumBy.xpath("//android.view.View[@text=\"Selenium\"]")));

		Dimension dims = driver.manage().window().getSize();
		Point start = new Point((int) (dims.getWidth() * .42), (int) (dims.getHeight() * .83));
		Point end = new Point((int) (dims.getWidth() * .45), (int) (dims.getHeight() * .20));

		doSwipe(driver, start, end, 2000);
		doSwipe(driver, start, end, 2000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				AppiumBy.xpath("//android.view.View[@text=\"Login Form  Please sign in. \"]"))).click();
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(AppiumBy.xpath("//android.widget.EditText[@resource-id=\"username\"]")))
				.sendKeys("admin");
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(AppiumBy.xpath("//android.widget.EditText[@resource-id=\"password\"]")))
				.sendKeys("password");
		driver.findElement(AppiumBy.xpath("//android.widget.Button[@text=\"Log in\"]")).click();
		String msg = wait.until(ExpectedConditions.visibilityOfElementLocated(
				AppiumBy.xpath("//android.view.View[@resource-id=\"action-confirmation\"]"))).getText();
		assertEquals(msg, "Welcome Back, admin");

	}

	@Test(priority = 2)
	public void invalid_login_test() {
		driver.get("https://v1.training-support.net/selenium");
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(AppiumBy.xpath("//android.view.View[@text=\"Selenium\"]")));

		Dimension dims = driver.manage().window().getSize();
		Point start = new Point((int) (dims.getWidth() * .42), (int) (dims.getHeight() * .83));
		Point end = new Point((int) (dims.getWidth() * .45), (int) (dims.getHeight() * .20));

		doSwipe(driver, start, end, 1000);
		doSwipe(driver, start, end, 1000);

		wait.until(ExpectedConditions.visibilityOfElementLocated(
				AppiumBy.xpath("//android.view.View[@text=\"Login Form  Please sign in. \"]"))).click();
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(AppiumBy.xpath("//android.widget.EditText[@resource-id=\"username\"]")))
				.sendKeys("admin1");
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(AppiumBy.xpath("//android.widget.EditText[@resource-id=\"password\"]")))
				.sendKeys("password");
		driver.findElement(AppiumBy.xpath("//android.widget.Button[@text=\"Log in\"]")).click();
		String msg = wait.until(ExpectedConditions.visibilityOfElementLocated(
				AppiumBy.xpath("//android.view.View[@resource-id=\"action-confirmation\"]"))).getText();
		assertEquals(msg, "Invalid Credentials");

	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}

}
