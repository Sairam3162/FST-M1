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

public class Activity9 {

	WebDriver driver;

	@BeforeClass
	public void setUP() {

		driver = new FirefoxDriver();
//		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://alchemy.hguy.co/lms");
	}

	@Test
	public void navigateToSocialMediaMarketingPage() {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

		List<WebElement> navigationBar = driver.findElements(By.xpath("//div[@class='main-navigation']//a"));

		boolean myAccountFound = false;
		for (WebElement item : navigationBar) {
			System.out.println(item.getText());

			if (item.getText().equalsIgnoreCase("My Account")) {
				wait.until(ExpectedConditions.elementToBeClickable(item));
				item.click();
				System.out.println("Moving to the next Page");
				myAccountFound = true;
				break;
			}
		}
		Assert.assertTrue(myAccountFound, "My Account link was not found in the navigation bar");
		WebElement pageTitle = driver.findElement(By.xpath("//div[@class='uagb-ifb-title-wrap']"));
		System.out.println("The Title is: " + pageTitle.getText());
		Assert.assertEquals(pageTitle.getText(), "My Account");

		WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(
				By.xpath("//a[@class='ld-login ld-login ld-login-text ld-login-button ld-button']")));
		loginButton.click();
		WebElement username = driver.findElement(By.id("user_login"));
		username.sendKeys("root");
		WebElement password = driver.findElement(By.id("user_pass"));
		password.sendKeys("pa$$w0rd");
		WebElement submitButton = driver.findElement(By.id("wp-submit"));
		submitButton.click();

		WebElement logoutButton = wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//a[@class='ld-logout ld-logout ld-login-text ld-login-button ld-button']")));
		System.out.println("Is Logout Button Displaying: " + logoutButton.isDisplayed());
		Assert.assertTrue(logoutButton.isDisplayed(), "Logout button is not displayed, login might have failed.");

		WebElement allCoursesNavigationBar = driver.findElement(By.xpath("//a[normalize-space()='All Courses']"));
		wait.until(ExpectedConditions.visibilityOf(allCoursesNavigationBar));
		allCoursesNavigationBar.click();

		WebElement allCoursesPageTitle = driver.findElement(By.xpath("//h1[@class='uagb-ifb-title']"));
		System.out.println("The Title is: " + allCoursesPageTitle.getText());
		Assert.assertEquals(allCoursesPageTitle.getText(), "All Courses");

		List<WebElement> allCourses = driver.findElements(By.xpath("//h3[@class='entry-title']"));
		wait.until(ExpectedConditions.visibilityOfAllElements(allCourses));
		System.out.println("The total number of courses are: " + allCourses.size());
		for (WebElement course : allCourses) {
			System.out.println("Course details: " + course.getText());
		}
		WebElement courseNo1 = driver.findElement(By.xpath(
				"//a[@href='https://alchemy.hguy.co/lms/courses/social-media-marketing/'][normalize-space()='See more...']"));
		wait.until(ExpectedConditions.visibilityOfAllElements(courseNo1));
		courseNo1.click();

		System.out.println("**************Course Details page****************");
		WebElement courseNo1_Detailpagetile = driver.findElement(By.xpath("//h1[@class='entry-title']"));
		System.out.println("The course tile is  :" + courseNo1_Detailpagetile.getText());
		Assert.assertTrue(courseNo1_Detailpagetile.isDisplayed(), "The course details page have not been opened yet");

	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}
