package com.abof.selenium_pagefactory.pom.tests;

import java.io.FileInputStream;
import java.util.Properties;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.abof.selenium_pagefactory.pom.driver.BaseClass;
import com.abof.selenium_pagefactory.pom.pages.HeaderPage;
import com.abof.selenium_pagefactory.pom.pages.LoginPage;

public class LoginTest extends BaseClass {

	protected Properties testData = new Properties();

	@BeforeTest(enabled = true)
	public void startWebdriverSession() {
		startSession();
		try {
			FileInputStream fin = new FileInputStream(user_dir
					+ "\\src\\test\\java\\com\\abof\\selenium_pagefactory\\pom\\tests\\testdata\\loginData.properties");
			testData.load(fin);
		} catch (Exception ex) {
		}
	}

	@AfterTest(enabled = true)
	public void stopWebdriverSession() {
		stopSession();
	}

	@Test
	public void On_LoginPage_8X8Logo_Should_Present() throws Exception {
		HeaderPage hPageObj = new HeaderPage(driver);
		hPageObj.navigateToSignInPage();
		LoginPage lPageObj = new LoginPage(driver);
		lPageObj.login(testData.getProperty("ValidUname"), testData.getProperty("ValidPassword"));

		Assert.assertTrue(hPageObj.getMeLoggedInPersonFirstName().equalsIgnoreCase(testData.getProperty("firstName")),
				"Login Failed");
	}

}
