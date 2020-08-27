package Tests.Login;
import org.testng.annotations.Test;

import Pages.Login.PageFactory;
import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeTest;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class Test_LoginValid {
	WebDriver driver = null;
	PageFactory pf = new PageFactory(driver);
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
		
		driver.manage().deleteAllCookies();
		driver.get("https://opensource-demo.orangehrmlive.com");
		doAValidLogin();
		}
	
	
	@AfterTest
	public void afterTest() throws InterruptedException {
		Thread.sleep(5000);
		driver.close();
		driver.quit();
	}

	public void doAValidLogin(){
		pf.setUserName();
		pf.setPassword();
		pf.clickLogin();
	}
}
