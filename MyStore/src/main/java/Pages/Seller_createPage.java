package Pages;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;

public class Seller_createPage {
	WebDriver driver;
	
	By typeDropdown = By.id("type");
	By sellerEmail = By.id("seller_email");
	By productName = By.id("product_name");
	By price = By.id("price");
	By productUrl = By.id("product_url");
	By submitButton = By.xpath("//button[@type='submit']");
	By productMenu = By.xpath("html/body/div[5]/div/ul/li[3]");
	By productListLink = By.xpath("/html/body/div[5]/div/ul/li[3]/ul/a[1]/li");
	By addProductLink = By.cssSelector("a[href='index.php?p=admin_add_product']");

	public Seller_createPage(WebDriver driver) {
		this.driver = driver;
	}

	public void navigateToProductPage() {
		Actions action = new Actions(driver);
		WebElement menu = driver.findElement(productMenu);
		action.moveToElement(menu).perform();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		driver.findElement(productListLink).click();
	}

	public void clickAddProduct() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("loader-div")));
		driver.findElement(addProductLink).click();
	}

	public void fillProductForm(String email, String name, String priceValue, String url) {
		Select select = new Select(driver.findElement(typeDropdown));
		select.selectByIndex(0);

		driver.findElement(sellerEmail).sendKeys(email);
		driver.findElement(productName).sendKeys(name);
		driver.findElement(price).sendKeys(priceValue);
		driver.findElement(productUrl).sendKeys(url);
	}
	 public void submitForm() {
	        driver.findElement(submitButton).click();
	    }
}
