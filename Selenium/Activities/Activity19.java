import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Activity19 {
	
	public static void main(String[] args) {
		
		WebDriver driver = new FirefoxDriver();
		
//		WebDriver driver = new ChromeDriver();
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		driver.get("https://training-support.net/webelements/alerts");
		
		driver.manage().window().maximize();
		
		System.out.println(driver.getTitle());
		
		WebElement confirmation = driver.findElement(By.id("confirmation"));
		confirmation.click();
		
		Alert confirmAlert = driver.switchTo().alert();
		String alertText = confirmAlert.getText();
		System.out.println("Text in Alert is : " + alertText);
		confirmAlert.accept();
		
		System.out.println(driver.findElement(By.id("result")).getText());
		
		confirmation.click();
		
		System.out.println("Text in Alert is : " + alertText);
		confirmAlert.dismiss();
		System.out.println(driver.findElement(By.id("result")).getText());
		
		
		
		
		driver.quit();
	}

}
