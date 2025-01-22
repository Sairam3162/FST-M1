package com.seleniumproject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity5 {

	WebDriver driver;

	@BeforeClass
	public void setUP() {

		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("https://alchemy.hguy.co/lms");
	}

	@Test
	public void navigateToMyAccountPge() {

		WebElement myAccount = driver.findElement(By.linkText("My Account"));
		myAccount.click();
		String pageTitle = driver.getTitle();
		System.out.println(pageTitle);
		Assert.assertTrue(pageTitle.contains("My Account"));

	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}
