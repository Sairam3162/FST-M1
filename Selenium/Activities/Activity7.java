import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity7 {

	public static void main(String[] args) {

//		WebDriver driver = new ChromeDriver();
		WebDriver driver = new FirefoxDriver();

		driver.get("https://training-support.net/webelements/dynamic-controls");
		driver.manage().window().maximize();

		System.out.println("Page Title : " + driver.getTitle());

		WebElement text = driver.findElement(By.id("textInput"));
		text.click();
		System.out.println("Input text field is enabled :" + text.isEnabled());

		WebElement textBox = driver.findElement(By.id("textInputButton"));
		textBox.click();

		System.out.println("Input text field is enabled :" + text.isEnabled());

		text.sendKeys("Test");
		System.out.println(text.getDomProperty("value"));

		driver.quit();

	}

}
