import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Activity12 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		FirefoxDriver driver = new FirefoxDriver();
		driver.get("https://training-support.net/webelements/dynamic-content");
		driver.manage().window().maximize();

		System.out.println("Title of the page is : " + driver.getTitle());

		driver.findElement(By.xpath("//button[text()='Click me!']")).click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement text_element = driver.findElement(By.xpath("//h2[@id='word']"));
		if (wait.until(ExpectedConditions.textToBePresentInElement(text_element, "release"))) {
			System.out.println("Word Found : " + text_element.getText());
		}

		driver.quit();
	}

}