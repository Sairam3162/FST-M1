package com.seleniumproject;

import java.time.Duration;
import java.util.List;

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

public class Activity8 {

	WebDriver driver;

	@BeforeClass
	public void setUP() {

		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("https://alchemy.hguy.co/lms");
	}

	@Test
	public void navigateToContactPage() {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

		// Find all the navigation items
		List<WebElement> navigationBar = driver.findElements(By.xpath("//div[@class='main-navigation']//a"));
		boolean contact = false;
		// Iterate over navigation items
		for (WebElement item : navigationBar) {
			System.out.println(item.getText());

			// Check if this is the "“Contact”" link
			if (item.getText().equalsIgnoreCase("Contact")) {
				// Wait until the "“Contact”" link is clickable
				wait.until(ExpectedConditions.elementToBeClickable(item));
				// Click the link
				item.click();
				System.out.println("Moving to the next Page");
				contact = true;
				break;
			}
		}
		Assert.assertTrue(contact, "Contact link was not found in the navigation bar");

		WebElement pageTitle = driver.findElement(By.xpath("//div[@class='uagb-ifb-title-wrap']"));
		System.out.println("The Title is: " + pageTitle.getText());

		WebElement fullName = driver.findElement(By.id("wpforms-8-field_0"));
		fullName.sendKeys("Sairam");
		WebElement email = driver.findElement(By.id("wpforms-8-field_1"));
		email.sendKeys("sairam@gmail.com");
		WebElement message = wait.until(ExpectedConditions.elementToBeClickable(By.id("wpforms-8-field_2")));
		message.sendKeys("Hello Sairam");
		WebElement subject = driver.findElement(By.id("wpforms-8-field_3"));
		subject.sendKeys("Selenium");
		WebElement submitButton = driver.findElement(By.id("wpforms-submit-8"));
		submitButton.click();

		WebElement confirmMessage = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.id("wpforms-confirmation-8")));
		System.out.println("The confirmMessage Displaying as : " + confirmMessage.getText());

		Assert.assertTrue(confirmMessage.isDisplayed(), "confirmMessage is not displayed, Contact might have failed.");

	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}
