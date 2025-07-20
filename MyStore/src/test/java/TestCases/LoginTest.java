package TestCases;

import Data.TestData;
import Drivers.WebDriverSetup;
import Pages.LoginPage;
import junit.framework.Assert;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class LoginTest {

	public static void main(String[] args)  {
    	WebDriverSetup.setupGeckoDriver();
        WebDriver driver = new FirefoxDriver();

		driver.get(TestData.get_url);

         // Perform login
         LoginPage loginPage = new LoginPage(driver);
         loginPage.loginToAdmin(TestData.ADMIN_EMAIL, TestData.ADMIN_PASSWORD);
         loginPage.clickLogin();

         // Wait for redirection to complete (use WebDriverWait in real test)

         // Validate the current URL
         String actualUrl = driver.getCurrentUrl();
         System.out.println("Actual URL: " + actualUrl);

         // Match what is really returned
         String expectedUrl = "https://admin-akarsh-mvm-main.sp-seller.webkul.com/admin/index.php?p=admin_home";

         Assert.assertEquals("❌ URL did not match after login", expectedUrl, actualUrl);
         System.out.println("✅ URL matched: " + actualUrl);

         driver.close();
     }

	}

