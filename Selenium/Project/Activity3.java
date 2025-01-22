package com.seleniumproject;

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
import org.testng.annotations.Test;

public class Activity3 {

	WebDriver driver;

	@BeforeClass
	public void setUP() {

		driver = new FirefoxDriver();
//		driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://alchemy.hguy.co/lms");
	}

	@Test
	public void verifyFirstInfoBoxTitle() {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement firstInfoBoxTitle = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//h3[contains(text(), ' Actionable Training ')]")));
		System.out.println(firstInfoBoxTitle.getText());
		Assert.assertEquals(firstInfoBoxTitle.getText(), "Actionable Training");

	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}

}
