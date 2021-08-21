package com.bat.LandTraningSeleniumAutomation.DataProvider;

import org.testng.annotations.DataProvider;

import com.bat.LandTraningSeleniumAutomation.Utils.ExcellUtils;

public class LoginDataProvider {

	@DataProvider(name = "loginData")
	public static Object[][] getLoginData() {
		try {
			return new Object[][] { { ExcellUtils.getLoginData() }, };

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
