import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity3 {

	public static void main(String[] args) {

//		WebDriver driver = new FirefoxDriver();

		WebDriver driver = new ChromeDriver();

		driver.get("https://training-support.net/webelements/login-form");

		driver.manage().window().maximize();

		System.out.println("Title of the page is : " + driver.getTitle());

		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("admin");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("password");
		driver.findElement(By.xpath("//button[text()='Submit']")).click();

		String message = driver.findElement(By.xpath("//h1[contains(text(), 'Login')]")).getText();
		System.out.println(message);

//		driver.quit();
	}

}
