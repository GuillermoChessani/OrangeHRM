package Tests.Tests.Dashboard;
import org.testng.annotations.Test;

import Pages.Login.PageFactory;
import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeTest;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import Tests.Login.Test_LoginValid;
public class Test_AssignLeave {
	WebDriver driver = null;
	Test_LoginValid Login;

	@BeforeTest
	public void TestSetUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		Login = new Test_LoginValid();
	}

	@Test
	public void Test_AssignLeave() throws InterruptedException {
		PageFactory pf = new PageFactory(driver);
		driver.manage().deleteAllCookies();
		driver.get("https://opensource-demo.orangehrmlive.com");
		Login.doAValidLogin();
		pf.clickAssignLeave();
		pf.setDateTo();
		pf.setDateFrom();
		pf.setComments();
		pf.submitLeave();
		
		pf.setEmployeeName();
		pf.selectLeaveType();
			
		pf.submitLeave();
		
	/*	pf.clickLinkAdmin();
		pf.clickaUser();
	*/	
		
		}

	@AfterTest
	public void afterTest() throws InterruptedException {
		Thread.sleep(5000);
		driver.close();
		driver.quit();
	}

}
