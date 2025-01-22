import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.Color;

public class Activity4 {

	public static void main(String[] args) {

//		WebDriver driver = new FirefoxDriver();

		WebDriver driver = new ChromeDriver();

		driver.get("https://training-support.net/webelements/target-practice");

		driver.manage().window().maximize();

		System.out.println("The title of the page is : " + driver.getTitle());

		String thirdHeader = driver.findElement(By.xpath("//h3[contains(text(), 'Heading #3')]")).getText();
		System.out.println(thirdHeader);

		String header5 = driver.findElement(By.xpath("//h5[contains(text(), 'Heading #5')]")).getCssValue("color");
		Color fifthHeader = Color.fromString(header5);
		System.out.println("Color as RGB: " + fifthHeader.asRgb());
		System.out.println("Color as hexcode: " + fifthHeader.asHex());
		System.out.println(fifthHeader);

		String purpleButtonClass = driver.findElement(By.xpath("//button[contains(text(),'Purple')]"))
				.getDomAttribute("class");
		System.out.println(purpleButtonClass);

		String slateButtonText = driver.findElement(By.xpath("//button[contains(text(),'Slate')]")).getText();
		System.out.println(slateButtonText);
		driver.quit();
	}

}
