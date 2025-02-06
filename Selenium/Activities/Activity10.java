import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class Activity10 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		FirefoxDriver driver = new FirefoxDriver();
		driver.get("https://training-support.net/webelements/drag-drop");
		driver.manage().window().maximize();

		System.out.println("Title of the page is : " + driver.getTitle());

		WebElement ball = driver.findElement(By.xpath("//img[@id='ball']"));
		WebElement dropZone_1 = driver.findElement(By.xpath("//div[@id='dropzone1']"));
		WebElement dropZone_2 = driver.findElement(By.xpath("//div[@id='dropzone2']"));

		Actions builder = new Actions(driver);
		builder.clickAndHold(ball).moveToElement(dropZone_1).release().build().perform();
		if (dropZone_1.findElement(By.className("dropzone-text")).getText().equals("Dropped!")) {
			System.out.println("Ball is dropped in DropZone 1");
		}

		builder.dragAndDrop(ball, dropZone_2).build().perform();
		if (dropZone_2.findElement(By.className("dropzone-text")).getText().equals("Dropped!")) {
			System.out.println("Ball is dropped in DropZone 2");
		}

		driver.quit();
	}

}