package testngactivities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity2 {

	WebDriver driver;

	@BeforeClass
	public void setUp() {

		driver = new FirefoxDriver();
		driver.get("https://training-support.net/webelements/target-practice/");
		driver.manage().window().maximize();
	}

	@Test(priority = 1)
	public void testCase1() {

		String title = driver.getTitle();
		Assert.assertEquals("Selenium: Target Practice", title);
	}

	@Test(priority = 2)
	public void testCase2() throws Exception {

		WebElement blackButton = driver.findElement(By.cssSelector("button.black"));
		Assert.assertTrue(blackButton.isDisplayed());
		Assert.assertEquals(blackButton.getText(), "black");
	}

	@Test(priority = 3, enabled = false)
	public void testCase3() {

		driver.findElement(By.xpath("//h1[contains(text(), 'Heading #1')]")).click();
	}

	@Test(priority = 4)
	public void testCase4() throws SkipException {

		driver.findElement(By.xpath("//h1[contains(text(), 'Heading #1')]")).click();
		System.out.println("Skip Exception!");

	}

	@AfterClass
	public void tearDown() {

		driver.close();
	}
}
