package Tests.Login;

import org.testng.annotations.Test;

import Pages.Login.PageFactory;
import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class Test_Login_ForgotPassword_Cancel {
	WebDriver driver = null;

	@BeforeTest
	public void TestSetUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
	}

	@Test
	public void TestLogin() throws InterruptedException {
		PageFactory pf = new PageFactory(driver);
		driver.get("https://opensource-demo.orangehrmlive.com");
		pf.setUserName();
		pf.setInvalidPassword();
		pf.clickForgotPassword();
		pf.setUserNameAuthentication();
		pf.clickCancelPassword();
	}

	@AfterTest
	public void afterTest() throws InterruptedException {
		Thread.sleep(5000);
		driver.close();
		driver.quit();
	}

}