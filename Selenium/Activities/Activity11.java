import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Activity11 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		FirefoxDriver driver = new FirefoxDriver();
		driver.get("https://training-support.net/webelements/dynamic-controls");
		driver.manage().window().maximize();

		System.out.println("Title of the page is : " + driver.getTitle());

		WebElement checkbox = driver.findElement(By.id("checkbox"));
		System.out.println("Checkbox is visible? " + checkbox.isDisplayed());

		WebElement toggle_checkbox = driver.findElement(By.xpath("//button[text()='Toggle Checkbox']"));
		toggle_checkbox.click();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.invisibilityOf(checkbox));
		System.out.println("Checkbox is visible? " + checkbox.isDisplayed());

		toggle_checkbox.click();
		wait.until(ExpectedConditions.elementToBeClickable(By.id("checkbox"))).click();
		System.out.println("Checkbox is selected? " + checkbox.isSelected());

		driver.quit();
	}

}