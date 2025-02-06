import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Activity16 {
	public static void main(String[] args) throws Exception {

		FirefoxDriver driver = new FirefoxDriver();
		driver.get("https://training-support.net/webelements/selects");
		driver.manage().window().maximize();

		String title = driver.getTitle();
		System.out.println("Title of the page is " + title);

		WebElement dropdown = driver.findElement(By.cssSelector("select.h-10"));
		Select select = new Select(dropdown);

		select.selectByVisibleText("Two");
		select.selectByIndex(3);
		select.selectByValue("four");
		List<WebElement> options = select.getOptions();
		System.out.println("Options in the dropdown: ");
		for (WebElement option : options) {
			System.out.println(option.getText());
		}

		driver.quit();

	}

}