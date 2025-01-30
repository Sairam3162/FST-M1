package activities;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class Activity1 {

	AppiumDriver driver;

	@BeforeClass
	public void setUp() throws MalformedURLException, URISyntaxException {

		UiAutomator2Options options = new UiAutomator2Options();
		options.setPlatformName("android");
		options.setAutomationName("UiAutomator2");
		options.setAppPackage("com.android.calculator2");
		options.setAppActivity(".Calculator");

		URL serverUrl = new URI("http://localhost:4723").toURL();

		driver = new AppiumDriver(serverUrl, options);

	}

	@Test
	public void multiplicationTest() {

		driver.findElement(AppiumBy.id("com.android.calculator2:id/digit_5")).click();
		driver.findElement(AppiumBy.accessibilityId("×")).click();
		driver.findElement(AppiumBy.id("com.android.calculator2:id/digit_9")).click();
		driver.findElement(AppiumBy.accessibilityId("equals")).click();

		String result = driver.findElement(AppiumBy.id("result")).getText();
		Assert.assertEquals(result, "45");
	}

	@AfterClass
	public void tearDown() {

		driver.quit();
	}
}
