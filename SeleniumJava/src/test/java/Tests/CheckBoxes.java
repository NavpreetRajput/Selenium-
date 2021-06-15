package Tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CheckBoxes {

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

		// Click the check boxes link
		driver.findElement(By.xpath("//*[@id=\"content\"]/ul/li[6]/a")).click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		Checking the unchecked box
		driver.findElement(By.xpath("//*[@id=\"checkboxes\"]/input[1]")).click();

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//Unchecking the checked box
		driver.findElement(By.xpath("//*[@id=\"checkboxes\"]/input[2]")).click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@AfterTest
	public void tearDown() {
		driver.close();
		driver.quit();
		System.out.println("Tested successfully");
	}

}
