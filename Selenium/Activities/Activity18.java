import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Activity18 {

	public static void main(String[] args) {

		WebDriver driver = new FirefoxDriver();

//		WebDriver driver = new ChromeDriver();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		driver.get("https://training-support.net/webelements/alerts");

		driver.manage().window().maximize();

		System.out.println("Page Title: " + driver.getTitle());

		driver.findElement(By.id("simple")).click();

		Alert simpleAlert = driver.switchTo().alert();

		System.out.println("Text in Alert : " + simpleAlert.getText());

		simpleAlert.accept();

		System.out.println(driver.findElement(By.id("result")).getText());

		driver.quit();
	}

}
