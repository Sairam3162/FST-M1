package com.seleniumproject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity6 {

	WebDriver driver;

	@BeforeClass
	public void setUP() {

		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("https://alchemy.hguy.co/lms");
	}

	@Test
	public void navigateToLoginPage() {

		WebElement myAccount = driver.findElement(By.linkText("My Account"));
		myAccount.click();
		String pageTitle = driver.getTitle();
		System.out.println(pageTitle);
		Assert.assertTrue(pageTitle.contains("My Account"));
		WebElement login = driver.findElement(By.linkText("Login"));
		login.click();
		
		WebElement username = driver.findElement(By.id("user_login"));
		username.sendKeys("root");
		WebElement password = driver.findElement(By.id("user_pass"));
		password.sendKeys("pa$$w0rd");
		WebElement loginButton = driver.findElement(By.id("wp-submit"));
		loginButton.click();
		
		WebElement logoutButton = driver.findElement(By.linkText("Logout"));
		Assert.assertTrue(logoutButton.isDisplayed());

	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}
