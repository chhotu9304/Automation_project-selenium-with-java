package TestCases;



import org.openqa.selenium.WebDriver;

import org.openqa.selenium.firefox.FirefoxDriver;

import Data.TestData;
import Drivers.WebDriverSetup;
import Pages.LoginPage;
import Pages.Seller_createPage;

public class Seller_product_create_Test {

	public static void main(String[] args) {
		WebDriverSetup.setupGeckoDriver();
        WebDriver driver = new FirefoxDriver();
        driver.get(TestData.get_url);

        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginToAdmin(TestData.ADMIN_EMAIL, TestData.ADMIN_PASSWORD);
        loginPage.clickLogin();

        Seller_createPage dashboard = new Seller_createPage(driver);
        dashboard.navigateToProductPage();
        dashboard.clickAddProduct();

        Seller_createPage addProductPage = new Seller_createPage(driver);
        addProductPage.fillProductForm("asd@gmail.com", "akar", "100", "https://www.google.com");
        addProductPage.submitForm();
    }


}
