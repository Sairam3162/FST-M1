package stepDefinitions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class GoogleSearchSteps {

	WebDriver driver;
	WebDriverWait wait;

	@Given("^User is on Google Home Page$")
	public void givenFunctionName() {
		driver = new FirefoxDriver();
		wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		driver.get("https://www.google.com");

	}

	@When("^User types in Cheese and hits ENTER$")
	public void whenFunctionName() {
//		driver.findElement(By.className("gLFyf")).sendKeys("Cheese", Keys.ENTER);
		driver.findElement(By.name("q")).sendKeys("Cheese", Keys.ENTER);
	}

	@Then("^Show how many search results were shown$")
	public void thenFunctionName() {
		wait.until(ExpectedConditions.elementToBeClickable(By.id("hdtb-tls"))).click();
		String resultStats = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("result-stats"))).getText();
		System.out.println("Number of results found: " + resultStats);
	}

}