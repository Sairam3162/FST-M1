package projectactivities;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class ProjectChromeLoginActivity5 extends ActionBase {

	AndroidDriver driver;
	WebDriverWait wait;

	@BeforeClass
	public void SetUp() throws MalformedURLException, URISyntaxException {
		UiAutomator2Options options = new UiAutomator2Options();
		options.setPlatformName("Android");
		options.setAutomationName("UiAutomator2");
		options.setAppPackage("com.android.chrome");
		options.setAppActivity("com.google.android.apps.chrome.Main");
		options.noReset();

		URL serverURL = new URI("http://localhost:4723/wd/hub").toURL();

		driver = new AndroidDriver(serverURL, options);
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));

		driver.get("https://v1.training-support.net/selenium");
	}

	@Test
	public void loginTestValid() throws InterruptedException {
		wait.until(ExpectedConditions
				.elementToBeClickable(AppiumBy.xpath("//android.widget.Button[@text=\"Get Started!\"]"))).click();

		String UiScrollable = "UiScrollable(UiSelector().scrollable(true))";
		driver.findElement(AppiumBy.androidUIAutomator(UiScrollable + ".scrollTextIntoView(\"Login Form\")"));

		wait.until(ExpectedConditions
				.elementToBeClickable(AppiumBy.xpath("//android.widget.TextView[@text=\"Login Form\"]"))).click();
		Thread.sleep(5000);
		driver.findElement(AppiumBy.xpath(
				"//android.webkit.WebView[@text=\"Login Form\"]/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.EditText[1]"))
				.sendKeys("admin");
		driver.findElement(AppiumBy.xpath(
				"//android.webkit.WebView[@text=\"Login Form\"]/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.EditText[2]"))
				.sendKeys("password");
		driver.findElement(AppiumBy.xpath("//android.widget.Button[@text=\"Log in\"]")).click();

		Assert.assertTrue(driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"Welcome Back, admin\"]"))
				.isDisplayed());
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}
