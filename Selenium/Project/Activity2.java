package com.seleniumproject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity2 {

	WebDriver driver;

	@BeforeClass
	public void setUP() {

		driver = new FirefoxDriver();
//		driver = new ChromeDriver();
		driver.manage().window().maximize();

	}

	@Test
	public void verifyWebsiteHeading() {

		driver.get("https://alchemy.hguy.co/lms");
		WebElement header = driver.findElement(By.xpath("//h1[text()=' Learn from Industry Experts ']"));
		System.out.println(header.getText());
		Assert.assertEquals(header.getText(), "Learn from Industry Experts");
		;
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}

}
