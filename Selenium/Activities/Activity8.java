import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Activity8 {

	public static void main(String[] args) {

//		WebDriver driver = new ChromeDriver();
		WebDriver driver = new FirefoxDriver();

		driver.manage().window().maximize();

		driver.get("https://training-support.net/webelements/mouse-events");
		System.out.println("Title of the page is : " + driver.getTitle());

		WebElement CargoLock = driver.findElement(By.xpath("//h1[text()='Cargo.lock']"));
		WebElement CargoToml = driver.findElement(By.xpath("//h1[text()='Cargo.toml']"));
		WebElement src = driver.findElement(By.xpath("//h1[text()='src']"));
		WebElement target = driver.findElement(By.xpath("//h1[text()='target']"));

		Actions builder = new Actions(driver);
		builder.click(CargoLock).pause(2000).moveToElement(CargoToml).click().pause(2000).build().perform();

		WebElement result = driver.findElement(By.id("result"));
		System.out.println("Result of the Cargo.Toml : " + result.getText());

		builder.doubleClick(src).pause(2000).contextClick(target).pause(2000).build().perform();

		WebElement open = driver.findElement(By.xpath("//div[@id='menu']/div/ul/li[1]"));
		builder.click(open).pause(2000).build().perform();

		System.out.println("Result of the target : " + result.getText());

		driver.quit();
	}

}
