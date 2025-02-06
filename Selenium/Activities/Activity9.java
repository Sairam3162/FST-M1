import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class Activity9 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		FirefoxDriver driver = new FirefoxDriver();
		driver.get("https://training-support.net/webelements/keyboard-events");
		driver.manage().window().maximize();

		String title = driver.getTitle();
		System.out.println("Title of the page is : " + title);

		Actions builder = new Actions(driver);
		builder.sendKeys("Hello Selenium!").sendKeys(Keys.RETURN).build().perform();

		String pageText = driver.findElement(By.cssSelector("h1.mt-3")).getText();
		System.out.println(pageText);

		driver.quit();

	}

}