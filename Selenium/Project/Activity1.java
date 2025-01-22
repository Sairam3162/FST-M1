package com.seleniumproject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity1 {

	WebDriver driver;

	@BeforeClass
	public void setUP() {

		driver = new FirefoxDriver();
//		driver = new ChromeDriver();
		driver.manage().window().maximize();

	}

	@Test(priority = 1)
	public void verifyWebsiteTitle() {

		driver.get("https://alchemy.hguy.co/lms");
		String homePageTitle = driver.getTitle();
		System.out.println(homePageTitle);
		Assert.assertEquals(homePageTitle, "Alchemy LMS – An LMS Application");
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}

}
