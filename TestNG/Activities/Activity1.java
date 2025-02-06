package testngactivities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity1 {

	WebDriver driver;

	@BeforeClass
	public void setUp() {
		driver = new FirefoxDriver();
		driver.get("https://training-support.net");
		driver.manage().window().maximize();
	}

	@Test
	public void method() {
		String title = driver.getTitle();
		System.out.println("Title of the page : " + title);
		Assert.assertEquals(title, "Training Support");
		driver.findElement(By.xpath("//a[text()='About Us']")).click();
		Assert.assertEquals(driver.getTitle(), "About Training Support");
	}

	@AfterClass
	public void tearDown() {
		driver.close();
	}

}