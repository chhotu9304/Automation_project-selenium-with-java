package TestCases;

import Data.TestData;
import Drivers.WebDriverSetup;
import Pages.LoginPage;
import Pages.Seller_createPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Seller_prod_crt {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        WebDriverSetup.setupGeckoDriver();
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get(TestData.get_url);
    }

    @Test
    public void createSellerProduct() {
        // Login
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginToAdmin(TestData.ADMIN_EMAIL, TestData.ADMIN_PASSWORD);
        loginPage.clickLogin();

        // Navigate to product page and add product
        Seller_createPage dashboard = new Seller_createPage(driver);
        dashboard.navigateToProductPage();
        dashboard.clickAddProduct();
        dashboard.fillProductForm("asd@gmail.com", "akar", "100", "https://www.google.com");
        dashboard.submitForm();
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
