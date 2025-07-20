package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	 WebDriver driver;

	    // Locators
	 //test
	    private By emailField = By.id("wk_email");
	    private By passwordField = By.id("wk_password");
	    private By loginButton = By.xpath("//button[normalize-space()='LOGIN']");

	    // Constructor
	    public LoginPage(WebDriver driver) {
	        this.driver = driver;
	    }

	    // Actions (functions)
	    public void enterEmail(String email) {
	        driver.findElement(emailField).sendKeys(email);
	    }

	    public void enterPassword(String password) {
	        driver.findElement(passwordField).sendKeys(password);
	    }

	    public void clickLogin() {
	        driver.findElement(loginButton).click();
	    }

	    public void loginToAdmin(String email, String password) {
	        enterEmail(email);
	        enterPassword(password);
	    }


}
