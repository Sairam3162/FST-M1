import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity13 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		FirefoxDriver driver = new FirefoxDriver();
		driver.get("https://training-support.net/webelements/tables");
		driver.manage().window().maximize();

		System.out.println("Title of the Page is : " + driver.getTitle());

		List<WebElement> rows = driver.findElements(By.xpath("//table/tbody/tr"));
		System.out.println("Number of rows : " + rows.size());
		List<WebElement> cols = driver.findElements(By.xpath("//table/tbody/tr[1]/td"));
		System.out.println("Number of columns : " + cols.size());

		List<WebElement> third_row = driver.findElements(By.xpath("//table/tbody/tr[3]/td"));
		System.out.println("Third row elemets are : ");
		for (WebElement cell : third_row) {
			System.out.println(cell.getText());
		}

		WebElement second_row_second_col_element = driver.findElement(By.xpath("//table/tbody/tr[2]/td[2]"));
		System.out.println("second_row_second_col_element is : " + second_row_second_col_element.getText());

		driver.quit();

	}

}