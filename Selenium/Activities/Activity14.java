import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity14 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		FirefoxDriver driver = new FirefoxDriver();
		driver.get("https://training-support.net/webelements/tables");
		driver.manage().window().maximize();
		
		System.out.println("Title of the page is : " + driver.getTitle());

		List<WebElement> rows = driver.findElements(By.xpath("//table/tbody/tr"));
		System.out.println("Number of rows : " + rows.size());
		List<WebElement> cols = driver.findElements(By.xpath("//table/tbody/tr[1]/td"));
		System.out.println("Number of columns : " + cols.size());

		WebElement fifth_row_bookName_1 = driver.findElement(By.xpath("//table/tbody/tr[5]/td[2]"));
		System.out.println("fifth_row_bookName is " + fifth_row_bookName_1.getText());

		driver.findElement(By.xpath("//table/thead/tr/th[5]")).click();
		WebElement fifth_row_bookName_2 = driver.findElement(By.xpath("//table/tbody/tr[5]/td[2]"));
		System.out.println("fifth_row_bookName is " + fifth_row_bookName_2.getText());

		driver.quit();
	}

}