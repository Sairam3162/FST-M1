package testngactivities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity3 {
	
	WebDriver driver;
	@BeforeClass
	public void setUp() {
		driver = new FirefoxDriver();
		driver.get("https://training-support.net/webelements/login-form/");
		driver.manage().window().maximize();
	}
	@Test
	public void loginTest() {
		WebElement username = driver.findElement(By.xpath("//input[@id='username']"));
		WebElement password = driver.findElement(By.xpath("//input[@id='password']"));
		username.sendKeys("admin");
		password.sendKeys("password");
		driver.findElement(By.xpath("//button[text()='Submit']")).click();
		String message = driver.findElement(By.cssSelector("h2.text-center")).getText();
		System.out.println(message);
		Assert.assertEquals(message, "Welcome Back, Admin!");
	}
	@AfterClass
	public void tearDown() {
		driver.close();
	}

}