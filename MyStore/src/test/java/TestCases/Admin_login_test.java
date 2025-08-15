package TestCases;

import Data.TestData;
import Drivers.WebDriverSetup;
import Pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
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
    public void verifyAdminLogin() {
        // Perform login
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginToAdmin(TestData.ADMIN_EMAIL, TestData.ADMIN_PASSWORD);
        loginPage.clickLogin();

        // In real projects, use WebDriverWait here to wait for redirect

        // Validate URL
        String actualUrl = driver.getCurrentUrl();
        String expectedUrl = "https://admin-akarsh-mvm-main.sp-seller.webkul.com/admin/index.php?p=admin_home";

        Assert.assertEquals(actualUrl, expectedUrl, "❌ URL did not match after login");
        System.out.println("✅ URL matched: " + actualUrl);
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
