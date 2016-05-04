package com.abof.selenium_pagefactory.pom.driver;

import java.io.FileInputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class BaseClass {

	public WebDriver driver;

	String chrome = "chrome";
	String firefox = "firefox";
	String ie = "ie";

	protected String user_dir = System.getProperty("user.dir");

	protected Properties prop = new Properties();

	public String getProperty(String configItemName) {
		try {
			FileInputStream f = new FileInputStream(user_dir + "\\selenium.properties");
			prop.load(f);
		} catch (Exception e) {
			e.getStackTrace();
		}
		return prop.getProperty(configItemName);
	}

	public void startSession() {
		if (getProperty("remoteWebdriver").equalsIgnoreCase("false")) {
			if (getProperty("browser").equalsIgnoreCase(firefox)) {
				driver = new FirefoxDriver();
			} else if (getProperty("browser").equals(chrome)) {
				System.setProperty("webdriver.chrome.driver",
						user_dir + "\\src\\ExternalJars\\chromeDriver\\chromedriver.exe");
				driver = new ChromeDriver();

			} else if (getProperty("browser").equals(ie)) {
				System.setProperty("webdriver.ie.driver",
						user_dir + "\\src\\ExternalJars\\IEDriverServer_x64_2.25.3\\IEDriverServer.exe");

				DesiredCapabilities ieCapabilities = DesiredCapabilities.internetExplorer();
				ieCapabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,
						true);
				driver = new InternetExplorerDriver(ieCapabilities);
			}
		} else {
			URL gridUrl = null;
			try {
				gridUrl = new URL(getProperty("gridHubURL"));
			} catch (MalformedURLException e) {
			}
			if (getProperty("browser").equalsIgnoreCase(firefox)) {

				FirefoxProfile fp = new FirefoxProfile();
				// set something on the profile...
				DesiredCapabilities dc = DesiredCapabilities.firefox();
				dc.setCapability(FirefoxDriver.PROFILE, fp);
				 driver = new RemoteWebDriver(gridUrl, dc);

			} else if (getProperty("browser").equals(chrome)) {
				System.setProperty("webdriver.chrome.driver",
						user_dir + "\\src\\ExternalJars\\chromeDriver\\chromedriver.exe");
				ChromeOptions options = new ChromeOptions();
				// set some options
				DesiredCapabilities dc = DesiredCapabilities.chrome();
				dc.setCapability(ChromeOptions.CAPABILITY, options);
				 driver = new RemoteWebDriver(gridUrl, dc);

			} else if (getProperty("browser").equals(ie)) {
				System.setProperty("webdriver.ie.driver",
						user_dir + "\\src\\ExternalJars\\IEDriverServer_x64_2.25.3\\IEDriverServer.exe");

				DesiredCapabilities ieCapabilities = DesiredCapabilities.internetExplorer();
				ieCapabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,
						true);
				driver = new InternetExplorerDriver(ieCapabilities);
			}

		}
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.get(getProperty("baseurl_qa"));
		driver.manage().window().maximize();
	}

	public void stopSession() {
		driver.quit();
	}
}
