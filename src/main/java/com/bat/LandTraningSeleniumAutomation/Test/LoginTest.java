package com.bat.LandTraningSeleniumAutomation.Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.bat.LandTraningSeleniumAutomation.Utils.DriverManager;
import com.bat.LandTraningSeleniumAutomation.Utils.TestNGReporting;
import com.bat.LandTraningSeleniumAutomation.Utils.PathUtils;

@Listeners(TestNGReporting.class)
public class LoginTest {

	private WebDriver driver = null;

	@Test
	public void LoginPageTitleVerify() {
		driver = DriverManager.driver;
		driver.get(PathUtils.URL.baseUrl);
		Assert.assertEquals(driver.getTitle(), PathUtils.URL.homepageTitle);
		System.out.println("Page Title verified");
		driver.manage().window().maximize();
	}

	@Test(dependsOnMethods = "LoginPageTitleVerify")
	public void logintest() {
		driver.findElement(By.id(PathUtils.LoginModule.usernameField)).clear();
		driver.findElement(By.id(PathUtils.LoginModule.usernameField)).sendKeys(PathUtils.LoginModule.username);
		driver.findElement(By.id(PathUtils.LoginModule.passwordField)).clear();
		driver.findElement(By.id(PathUtils.LoginModule.passwordField)).sendKeys(PathUtils.LoginModule.password);

		driver.findElement(By.id(PathUtils.LoginModule.loginBtn)).click();
		System.out.println("Logged In Successfully");
	}
}
