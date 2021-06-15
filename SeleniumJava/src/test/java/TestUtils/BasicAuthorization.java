package TestUtils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
//import utils.ExcelUtils;

public class BasicAuthorization {
	public static WebDriver driver = null;

	@BeforeTest
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

	}

	// Getting data from excel using dataProvider
	@Test(dataProvider = "testData")
	public void test1(String Username, String password) {
		System.out.println(Username + " | " + password);

//		Navigating to the page
		driver.get("https://opensource-demo.orangehrmlive.com/");
//		Entering USernames and PAsswords stored in exel file
		driver.findElement(By.id("txtUsername")).sendKeys(Username);
		driver.findElement(By.id("txtPassword")).sendKeys(password);
		driver.findElement(By.id("btnLogin")).click();
		try {
			Thread.sleep(1000);
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

	@DataProvider(name = "testData")
	public Object[][] getData() {
		Object data[][] = testData("/Users/navpreetkaur/git/Selenium-/SeleniumJava/ExcelData/DummyAuthorization.xlsx",
				"Sheet1");
		return data;
	}

	public Object[][] testData(String excelPath, String sheetName) {

		utils excel = new utils(excelPath, sheetName);

		int rowCount = excel.getRowCount();
		int colCount = excel.getColCount();

		Object data[][] = new Object[rowCount - 1][colCount];

		for (int i = 1; i < rowCount; i++) {
			for (int n = 0; n < colCount; n++) {
				String cellDataString = excel.getCellData(i, n);

				data[i - 1][n] = cellDataString;
				

			}
			System.out.println();
		}
		return data;
	}

}
