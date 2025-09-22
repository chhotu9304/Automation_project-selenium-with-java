package TestCases;

import Data.TestData;

import Drivers.WebDriverSetup;
import Pages.LoginPage;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Admin_login_test {

	WebDriver driver;

	@BeforeMethod
	public void setUp() {
		WebDriverSetup.setupGeckoDriver();
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get(TestData.get_url);
	}

	@Test
	public void verifyAdminLogin() throws InterruptedException {
		// Perform login
		LoginPage loginPage = new LoginPage(driver);
		Thread.sleep(2000);

		loginPage.loginToAdmin(TestData.ADMIN_EMAIL, TestData.ADMIN_PASSWORD);

		loginPage.clickLogin();

		// In real projects, use WebDriverWait here to wait for redirect

//         Validate URL
		Thread.sleep(2000);
		String actualUrl = driver.getCurrentUrl();
		String expectedUrl = "https://shopify-trunk1.vachak.com/shopify-mp/admin/index.php?p=admin_home";

		Assert.assertEquals(actualUrl, expectedUrl, "❌ URL did not match after login");
		System.out.println("✅ URL matched: " + actualUrl);
	}

	@AfterMethod
	public void Aftermethod(ITestResult result) throws IOException, InterruptedException {
		if (ITestResult.FAILURE == result.getStatus()) {
			// Take screenshot
			File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

			File destFile = new File(TestData.ScreenshotPath);
			Thread.sleep(2000);
			// Copy file from temp location to your destination
			FileUtils.copyFile(screenshotFile, destFile);

			System.out.println("📸 Screenshot saved at: " + destFile.getAbsolutePath());
		}

		// Close browser after test
		if (driver != null) {
			driver.quit();
		}
	}

}
