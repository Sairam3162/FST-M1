import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity5 {

	public static void main(String[] args) {

		WebDriver driver = new FirefoxDriver();

//		WebDriver driver = new ChromeDriver();

		driver.get("https://training-support.net/webelements/dynamic-controls");

		driver.manage().window().maximize();

		System.out.println("Page Title : " + driver.getTitle());

		driver.findElement(By.id("checkbox")).isDisplayed();
		driver.findElement(By.xpath("//button[contains(text(), 'Toggle Checkbox')]")).click();
		boolean checkBox = driver.findElement(By.id("checkbox")).isDisplayed();
		System.out.println("Checkkbox is diaplayed: " + checkBox);
		driver.quit();
	}
}
