import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Activity15 {
	
	public static void main(String[] args) {
		
		WebDriver driver = new FirefoxDriver();
		
//		WebDriver driver = new ChromeDriver();
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		driver.get("https://training-support.net/webelements/dynamic-attributes");
		
		driver.manage().window().maximize();
		
		String title = driver.getTitle();
		System.out.println("Page Title : " + title);
		
		driver.findElement(By.xpath("//input[starts-with(@id, 'full-name')]")).sendKeys("Sairam");
		driver.findElement(By.xpath("//input[contains(@id, '-email')]")).sendKeys("sairam@gmail.com");
		driver.findElement(By.xpath("//input[contains(@name, 'event-date')]")).sendKeys("2025-01-01");
		driver.findElement(By.xpath("//textarea[contains(@id, '-additional-details-')]")).sendKeys("Hello!");
		driver.findElement(By.xpath("//button[contains(text(), 'Submit')]")).click();
		
		String message = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("action-confirmation")))
                .getText();
		
		System.out.println(message);
		
		driver.quit();
		
		
		
		
		
	}

}
