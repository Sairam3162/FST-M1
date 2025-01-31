package activities;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class Activity2 {

	AppiumDriver driver;
	WebDriverWait wait;

	@BeforeClass
	public void setUp() throws MalformedURLException, URISyntaxException {

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
		wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		driver.get("https://training-support.net/");
	}

	@Test
	public void chromeTest() {

//		// Locate heading on page and print it
		List<WebElement> pageTitle = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(AppiumBy.xpath("//android.view.View[@text=\"Training Support\"]")));
//		String pageTitle = driver.findElement(AppiumBy.xpath("//android.view.View[@text=\"Training Support\"]")).getText();
		System.out.println("Heading: " + pageTitle);

		driver.findElement(AppiumBy.xpath("//android.view.View[@text='About Us']")).click();

		WebElement aboutUspageHeading = driver.findElement(AppiumBy.xpath("//android.view.View[@text='About Us']"));

		System.out.println("About US page heading is : " + aboutUspageHeading);

	}

	@AfterClass
	public void tearDown() {

		driver.quit();
	}
}
