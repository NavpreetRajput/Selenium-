package Tests;

import org.testng.annotations.Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AddRemoveElements {

	private static WebDriver driver = null;
	public static String browserName = null;

	//Setting up the Chrome browser
	@BeforeTest
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

	}

	@Test
	public void testingAB() {

		// Go to the page of dummy Website
		driver.get("http://the-internet.herokuapp.com");

		// Click the Add remove elements link
		driver.findElement(By.xpath("//*[@id=\"content\"]/ul/li[2]/a")).click();

		int j = 0;
		int i = 0;
		for (i = 1; i <= 5; i++) {
			//Adding an element by clicking on Add element
			driver.findElement(By.xpath("//*[@id=\"content\"]/div/button")).click();
			//Adding an element after 1 second.
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (j = 1; j <= 5; j++) {
//			Deleting an element by clicking on delete Button.
			driver.findElement(By.xpath("//*[@id=\"elements\"]/button")).click();
			//Deleting an item after one second
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		try {
			Thread.sleep(20000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@AfterTest
	public void tearDown() {
		//Quitting and Closing the browser after test
		driver.close();
		driver.quit();
		System.out.println("Tested successfully");
	}

}
