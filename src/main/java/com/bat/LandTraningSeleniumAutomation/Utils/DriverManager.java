package com.bat.LandTraningSeleniumAutomation.Utils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.testng.annotations.Test;

@Test

public class DriverManager {

	static {
		System.setProperty("webdriver.chrome.driver", "D:\\do't click (soft)\\webSoft\\selenium\\slenium-files\\chromedriver_win32\\chromedriver.exe");
	}
	
	public static WebDriver driver =  new ChromeDriver();
	
	// code for Html Unit Driver and headless browser
	//public static WebDriver driver =  new HtmlUnitDriver();
	
	DriverManager()
	{
		
	}
}
