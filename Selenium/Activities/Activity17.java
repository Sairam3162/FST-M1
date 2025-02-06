import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Activity17 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		FirefoxDriver driver = new FirefoxDriver();
		driver.get("https://training-support.net/webelements/selects");
		driver.manage().window().maximize();

		String title = driver.getTitle();
		System.out.println("Title of the page is " + title);

		WebElement dropdown = driver.findElement(By.cssSelector("select.h-80"));
		Select select = new Select(dropdown);

		select.selectByVisibleText("HTML");
		select.selectByIndex(4);
		select.selectByIndex(5);
		select.selectByIndex(6);
		select.selectByValue("nodejs");
		select.deselectByIndex(5);

		List<WebElement> selectedOptions = select.getAllSelectedOptions();
		System.out.println("Selected options are: ");
		for (WebElement option : selectedOptions) {
			System.out.println(option.getText());
		}

		driver.quit();
	}

}