package com.abof.selenium_pagefactory.pom.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.abof.selenium_pagefactory.pom.utils.PageLevelUtils;

public class HeaderPage {
	WebDriver driver;

	@FindBy(how = How.LINK_TEXT, using = "Track my order")
	WebElement linkTrackMyOrder;

	@FindBy(how = How.ID, using = "Header_GlobalLogin_signInQuickLink")
	WebElement linkSignIn;

	@FindBy(how = How.ID, using = "Header_GlobalLogin_signOutQuickLinkUser")
	WebElement linkSignOut;

	@FindBy(how = How.ID, using = "Header_GlobalLogin_loggedInDropdown_SignOut")
	WebElement btnSignOut;

	public HeaderPage(WebDriver driver) throws Exception {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void navigateToSignInPage() {
		linkSignIn.click();
	}

	public void signOut() {
		linkSignOut.click();
		btnSignOut.click();
	}

	public void navigateToTrackingOrderPage() {
		linkTrackMyOrder.click();
	}

	public String getMeLoggedInPersonFirstName() {
		PageLevelUtils.elementIsDisplayedFluentlyPredicate(linkSignOut, 5, 500);
		return linkSignOut.getText();
	}

}
