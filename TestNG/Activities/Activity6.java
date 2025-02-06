package testngactivities;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Activity6 {

	WebDriver driver;
	WebDriverWait wait;

	@BeforeClass
	public void setUp() {
		driver = new FirefoxDriver();
		driver.get("https://training-support.net/webelements/login-form");
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.manage().window().maximize();

	}

	@Test
	@Parameters({ "username", "password" })
	public void method(String username, String password) {
		WebElement user_name = driver.findElement(By.xpath("//input[@id='username']"));
		WebElement pass_word = driver.findElement(By.xpath("//input[@id='password']"));
		user_name.sendKeys("admin");
		pass_word.sendKeys("password");
		driver.findElement(By.xpath("//button[text()='Submit']")).click();
		wait.until(ExpectedConditions.titleContains("Success"));

		String loginMessage = driver.findElement(By.cssSelector("h2.text-center")).getText();
		Assert.assertEquals("Welcome Back, Admin!", loginMessage);

	}

	@AfterClass
	public void tearDown() {
		driver.close();
	}

}