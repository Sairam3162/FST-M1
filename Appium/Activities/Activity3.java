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

public class Activity3 {

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

	@Test(priority = 1)
	public void AddingNumbersTest() {

		driver.findElement(AppiumBy.id("com.android.calculator2:id/digit_5")).click();
		driver.findElement(AppiumBy.accessibilityId("plus")).click();
		driver.findElement(AppiumBy.id("com.android.calculator2:id/digit_9")).click();
		driver.findElement(AppiumBy.accessibilityId("equals")).click();

		String result = driver.findElement(AppiumBy.id("result")).getText();
		Assert.assertEquals(result, "14");
	}

	@Test(priority = 2)
	public void SubtractingingNumbersTest() {

		driver.findElement(AppiumBy.id("com.android.calculator2:id/digit_1")).click();
		driver.findElement(AppiumBy.id("com.android.calculator2:id/digit_0")).click();
		driver.findElement(AppiumBy.accessibilityId("minus")).click();
		driver.findElement(AppiumBy.id("com.android.calculator2:id/digit_5")).click();
		driver.findElement(AppiumBy.accessibilityId("equals")).click();

		String result = driver.findElement(AppiumBy.id("result")).getText();
		Assert.assertEquals(result, "5");
	}

	@Test(priority = 3)
	public void multiplyingNumbersTest() {

		driver.findElement(AppiumBy.id("com.android.calculator2:id/digit_5")).click();
		driver.findElement(AppiumBy.accessibilityId("×")).click();
		driver.findElement(AppiumBy.id("com.android.calculator2:id/digit_1")).click();
		driver.findElement(AppiumBy.id("com.android.calculator2:id/digit_0")).click();
		driver.findElement(AppiumBy.id("com.android.calculator2:id/digit_0")).click();
		driver.findElement(AppiumBy.accessibilityId("equals")).click();

		String result = driver.findElement(AppiumBy.id("result")).getText();
		Assert.assertEquals(result, "500");
	}

	@Test(priority = 4)
	public void DividingNumbersTest() {

		driver.findElement(AppiumBy.id("com.android.calculator2:id/digit_5")).click();
		driver.findElement(AppiumBy.id("com.android.calculator2:id/digit_0")).click();
		driver.findElement(AppiumBy.accessibilityId("divide")).click();
		driver.findElement(AppiumBy.id("com.android.calculator2:id/digit_2")).click();
		driver.findElement(AppiumBy.accessibilityId("equals")).click();

		String result = driver.findElement(AppiumBy.id("result")).getText();
		Assert.assertEquals(result, "25");
	}

	@AfterClass
	public void tearDown() {

		driver.quit();
	}
}
