import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity20 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		FirefoxDriver driver = new FirefoxDriver();
		driver.get("https://training-support.net/webelements/alerts");
		driver.manage().window().maximize();

		String title = driver.getTitle();
		System.out.println("Title of the page is " + title);

		WebElement promptButton = driver.findElement(By.id("prompt"));
		promptButton.click();

		Alert alert = driver.switchTo().alert();
		System.out.println("Alert message is : " + alert.getText());
		alert.sendKeys("Awesome!");
		alert.accept();

		System.out.println(driver.findElement(By.id("result")).getText());

		driver.quit();

	}

}