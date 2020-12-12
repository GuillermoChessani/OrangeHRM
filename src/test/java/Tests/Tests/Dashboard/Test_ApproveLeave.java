package Tests.Tests.Dashboard;

import org.testng.annotations.Test;

import Pages.Login.PageFactory;
import Tests.Login.Test_LoginValid;
import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class Test_ApproveLeave {
	WebDriver driver = null;
	Test_LoginValid Login;

  @Test
  public void Test_ApproveLeave() {
	  	PageFactory pf = new PageFactory(driver);
		driver.manage().deleteAllCookies();
		driver.get("https://opensource-demo.orangehrmlive.com");
		Login.doAValidLogin();
		
		pf.clickApplyLeave();
		pf.selectApplyLeaveType();
		pf.setDateApplyTo();
		pf.setDateApplyFrom();
		
		pf.submitLeaveApply();
  }

  @BeforeTest
 	  public void TestSetUp() {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			Login = new Test_LoginValid();
		}
  

  @AfterTest
  public void afterTest() {
	  driver.quit();
  }

}
