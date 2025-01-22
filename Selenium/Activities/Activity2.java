import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity2 {

	public static void main(String[] args) {

//		WebDriver driver = new FirefoxDriver();
		WebDriver driver = new ChromeDriver();
		driver.get("https://training-support.net/webelements/login-form");
		driver.manage().window().maximize();
		System.out.println("Title of the page is : " + driver.getTitle());
		driver.findElement(By.id("username")).sendKeys("admin");
		driver.findElement(By.id("password")).sendKeys("password");
		driver.findElement(By.xpath("//button[text()='Submit']")).click();

//		System.out.println("The link of the page is " + driver.getCurrentUrl());
		String message = driver.findElement(By.tagName("h1")).getText();
		System.out.println(message);
		driver.quit();

	}

}
