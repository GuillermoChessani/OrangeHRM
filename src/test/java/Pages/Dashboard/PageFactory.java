package Pages.Dashboard;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageFactory {
	private static WebDriver driver;
	WebElement element;
	String varUser = "Admin";
	String varPass = "admin123";
	String varMail = "admin@hotmail.com";
	
	
	WebDriverWait wait;
	
	By txtUserName = By.name("txtUsername");
	By txtPassword = By.name("txtPassword");
	By btnLogin = By.name("Submit");
	By linkForgotPassword = By.linkText("Forgot your password?");
	By txtAuthentication_userName = By.id("securityAuthentication_userName");
	By btnReset = By.id("btnSearchValues");
	By btnCancel = By.id("btnCancel");
	
	By linkAdmin = By.id("firstLevelMenu");
	 
	
	
	
	
	public PageFactory(WebDriver driver) {
		this.driver = driver;
	}
	
	public void setUserName() {
		wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.visibilityOfElementLocated(txtUserName)).sendKeys(varUser);
	}

	public void setPassword() {
		wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.visibilityOfElementLocated(txtPassword)).sendKeys(varPass);
	}
	
	public void setInvalidPassword() {
		wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.visibilityOfElementLocated(txtPassword)).sendKeys("Invalid");
	}
	
	public void clickLogin() {
		wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.visibilityOfElementLocated(btnLogin)).click();
	}
	
	public void clickLinkAdmin() {
		wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.visibilityOfElementLocated(linkAdmin)).click();
	}
	
}
