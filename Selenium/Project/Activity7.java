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

public class Activity7 {
	WebDriver driver;

	@BeforeClass
	public void setUp() {

		driver = new FirefoxDriver();
		driver.get("https://alchemy.hguy.co/lms");
		driver.manage().window().maximize();
	}

	@Test
	public void count_The_Number_Of_Courses() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

		List<WebElement> navigationBar = driver.findElements(By.xpath("//div[@class='main-navigation']//a"));
		boolean myAccountFound = false;
		System.out.println("**************************************************************");

		for (WebElement item : navigationBar) {
			System.out.println(item.getText());

			if (item.getText().equalsIgnoreCase("All Courses")) {
				wait.until(ExpectedConditions.elementToBeClickable(item));
				item.click();
				System.out.println("Moving to the next Page");

				myAccountFound = true;
				break;
			}
		}

		Assert.assertTrue(myAccountFound, "All Courses link was not found in the navigation bar");

		WebElement pageTitle = driver.findElement(By.xpath("//h1[@class='uagb-ifb-title']"));
		System.out.println("The Title is: " + pageTitle.getText());
		Assert.assertEquals(pageTitle.getText(), "All Courses");
		System.out.println("**************************************************************");

		List<WebElement> allCourses = driver.findElements(By.xpath("//h3[@class='entry-title']"));
		wait.until(ExpectedConditions.visibilityOfAllElements(allCourses));
		System.out.println("The total number of courses are: " + allCourses.size());
		for (WebElement course : allCourses) {
			System.out.println("Course details: " + course.getText());
		}
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}