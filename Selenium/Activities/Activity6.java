import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity6 {

	public static void main(String[] args) {

//		WebDriver driver = new FirefoxDriver();

		WebDriver driver = new ChromeDriver();

		driver.get("https://training-support.net/webelements/dynamic-controls");

		driver.manage().window().maximize();

		System.out.println("Page Title : " + driver.getTitle());

		WebElement checkbox = driver.findElement(By.id("checkbox"));
		checkbox.click();
		System.out.println("Checkbox is selected : " + checkbox.isSelected());
		checkbox.click();
		System.out.println("Checkbox is selected : " + checkbox.isSelected());

		driver.quit();
	}
}
