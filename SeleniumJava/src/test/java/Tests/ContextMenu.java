package Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ContextMenu {
	private static WebDriver driver = null;
	public static String browserName = null;

	@BeforeTest
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

	}

	@Test
	public void testingAB() {

		// Go to the page of dummy Website
		driver.get("http://the-internet.herokuapp.com");

		// Click the Context Menu link
		driver.findElement(By.xpath("//*[@id=\"content\"]/ul/li[7]/a")).click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// Instantiate Action Class

		Actions actions = new Actions(driver);
		// Retrieve WebElement to perform right click and Right Click the button to
		// display Context Menu&nbsp;

		actions.contextClick(driver.findElement(By.id("hot-spot"))).perform();

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@AfterTest
	public void tearDown() {
		driver.close();
		driver.quit();
		System.out.println("Right click Tested successfully");
	}
}
