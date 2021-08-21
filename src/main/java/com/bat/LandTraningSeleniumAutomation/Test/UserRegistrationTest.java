package com.bat.LandTraningSeleniumAutomation.Test;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.bat.LandTraningSeleniumAutomation.DTO.LoginDTO;
import com.bat.LandTraningSeleniumAutomation.DataProvider.LoginDataProvider;
import com.bat.LandTraningSeleniumAutomation.Utils.DriverManager;
import com.bat.LandTraningSeleniumAutomation.Utils.TestNGReporting;
import com.bat.LandTraningSeleniumAutomation.Utils.PathUtils;

@Listeners(TestNGReporting.class)
public class UserRegistrationTest {

	private WebDriver driver = null;

	@Test
	public void dashboardToRegistrationPage() throws InterruptedException {

		driver = DriverManager.driver;

		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(PathUtils.Variabls.সেটিংস)));
		System.out.println("Setting Button Present");
		Thread.sleep(1000);
		driver.findElement(By.xpath(PathUtils.Variabls.সেটিংস)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(PathUtils.Variabls.ব্যবহারকারী_ব্যবস্থাপনা)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(PathUtils.Variabls.ব্যবহারকারী_তালিকা)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(PathUtils.Variabls.নতুন_ব্যবহারকারী)).click();
		Thread.sleep(1000);
	}

	@Test(dependsOnMethods = "dashboardToRegistrationPage", dataProvider = "loginData", dataProviderClass = LoginDataProvider.class)
	public void newUserRegistration(List<LoginDTO> logData) throws InterruptedException {

		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(PathUtils.Variabls.সংরক্ষণ)));
		System.out.println("In new user registration page...");

		driver = DriverManager.driver;
		for (LoginDTO user : logData) {
			driver.findElement(By.id(PathUtils.Variabls.ব্যবহারকারী_নাম)).clear();
			driver.findElement(By.id(PathUtils.Variabls.ব্যবহারকারী_নাম)).sendKeys(user.getUsername());

			driver.findElement(By.id(PathUtils.Variabls.পাসওয়ার্ড)).clear();
			driver.findElement(By.id(PathUtils.Variabls.পাসওয়ার্ড)).sendKeys(user.getPassword());

			driver.findElement(By.id(PathUtils.Variabls.email)).clear();
			driver.findElement(By.id(PathUtils.Variabls.email)).sendKeys(user.getEmail());

			driver.findElement(By.id(PathUtils.Variabls.mobile)).clear();
			driver.findElement(By.id(PathUtils.Variabls.mobile)).sendKeys("0"+user.getMobile());

			driver.findElement(By.id(PathUtils.Variabls.নাম_বাংলা)).clear();
			driver.findElement(By.id(PathUtils.Variabls.নাম_বাংলা)).sendKeys(user.getNameBn());

			driver.findElement(By.id(PathUtils.Variabls.নাম_ইংরেজি)).clear();
			driver.findElement(By.id(PathUtils.Variabls.নাম_ইংরেজি)).sendKeys(user.getNameEn());

			Select div = new Select(driver.findElement(By.id(PathUtils.Variabls.বিভাগ)));
			div.selectByVisibleText(user.getDiv());
			Thread.sleep(1000);

			Select dis = new Select(driver.findElement(By.id(PathUtils.Variabls.জেলা)));
			dis.selectByVisibleText(user.getDis());
			Thread.sleep(1000);

			Select upo = new Select(driver.findElement(By.id(PathUtils.Variabls.উপজেলা)));
			upo.selectByVisibleText(user.getUpa());
			Thread.sleep(1000);

			Select off = new Select(driver.findElement(By.id(PathUtils.Variabls.অফিস)));
			off.selectByVisibleText(user.getOffice());
			Thread.sleep(1000);

			Select des = new Select(driver.findElement(By.id(PathUtils.Variabls.পদবী)));
			des.selectByVisibleText(user.getDes());
			Thread.sleep(1000);

			Select grp = new Select(driver.findElement(By.id(PathUtils.Variabls.ব্যবহারকারী_গ্রুপ)));
			grp.selectByVisibleText(user.getUsergroup());

			driver.findElement(By.id(PathUtils.Variabls.ফোন)).clear();
			driver.findElement(By.id(PathUtils.Variabls.ফোন)).sendKeys(user.getPhone());

			driver.findElement(By.id(PathUtils.Variabls.অফিস_ফোন)).clear();
			driver.findElement(By.id(PathUtils.Variabls.অফিস_ফোন)).sendKeys(user.getOffphone());

			driver.findElement(By.id(PathUtils.Variabls.জন্ম_তারিখ)).clear();
			driver.findElement(By.id(PathUtils.Variabls.জন্ম_তারিখ)).sendKeys(user.getDob());

			Select gen = new Select(driver.findElement(By.id(PathUtils.Variabls.জেন্ডার)));
			gen.selectByVisibleText(user.getGender());

			driver.findElement(By.id(PathUtils.Variabls.স্থায়ী_ঠিকানা)).clear();
			driver.findElement(By.id(PathUtils.Variabls.স্থায়ী_ঠিকানা)).sendKeys(user.getPeraddress());

			driver.findElement(By.id(PathUtils.Variabls.বর্তমান_ঠিকানা)).clear();
			driver.findElement(By.id(PathUtils.Variabls.বর্তমান_ঠিকানা)).sendKeys(user.getPreaddress());

			driver.findElement(By.id(PathUtils.Variabls.লগইনের_মেয়াদ_শেষ_হওয়ার_তারিখ)).clear();
			driver.findElement(By.id(PathUtils.Variabls.লগইনের_মেয়াদ_শেষ_হওয়ার_তারিখ)).sendKeys(user.getExdate());
			driver.findElement(By.xpath(PathUtils.Variabls.c)).click();

			driver.findElement(By.id(PathUtils.Variabls.জাতীয়_পরিচয়পত্র)).clear();
			driver.findElement(By.id(PathUtils.Variabls.জাতীয়_পরিচয়পত্র)).sendKeys(user.getNid());

			driver.findElement(By.id(PathUtils.Variabls.ছবি)).clear();
			driver.findElement(By.id(PathUtils.Variabls.ছবি)).sendKeys(user.getPhoto());
			Thread.sleep(2000);

			driver.findElement(By.id(PathUtils.Variabls.স্বাক্ষর)).clear();
			driver.findElement(By.id(PathUtils.Variabls.স্বাক্ষর)).sendKeys(user.getSign());
			Thread.sleep(2000);

			// driver.findElement(By.xpath(PathUtils.Variabls.সংরক্ষণ)).click();
			// driver.findElement(By.xpath(PathUtils.Variabls.রিসেট)).click();
		}
	}

}
