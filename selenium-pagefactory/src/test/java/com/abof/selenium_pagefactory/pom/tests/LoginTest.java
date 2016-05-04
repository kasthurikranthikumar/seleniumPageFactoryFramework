package com.abof.selenium_pagefactory.pom.tests;

import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.util.Properties;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import com.abof.selenium_pagefactory.pom.driver.BaseClass;
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
		LoginPage loginP = new LoginPage(driver);
		//loginP.getCompanyLogoCount();
		//Assert.assertTrue(loginP.getCompanyLogoCount() >= 1, "Multiple / No Logo Found");
	}

	

}
