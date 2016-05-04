package com.abof.selenium_pagefactory.pom.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
 
public class LoginPage {

	WebDriver driver;

	@FindBy(how = How.ID, using = "WC_UserRegistrationAddForm_FormInput_logonId_In_Register_1_1")
	WebElement txtEmail_Existing;
	
	@FindBy(how = How.ID, using = "WC_UserRegistrationAddForm_FormInput_logonId_In_Register_1_2")
	WebElement txtEmail_New;

	@FindBy(how = How.ID, using = "WC_UserRegistrationAddForm_FormInput_logonPassword_In_Register_1")
	WebElement txtPassword_Existing;
	
	@FindBy(how = How.ID, using = "WC_UserRegistrationAddForm_FormInput_logonPassword_In_Register_2")
	WebElement txtPassword_new;

	@FindBy(how = How.ID, using = "WC_AccountDisplay_links_2")
	WebElement btnLogin;	
 
	@FindBy(how = How.ID, using = "WC_UserRegistrationAddForm_links_1")
	WebElement btnJoinAbof; 
	
	@FindBy(how = How.ID, using = "existing-customer1")	
	WebElement radioExistingUser;		
	
	@FindBy(how = How.ID, using = "new-customer")	
	WebElement radioNewUser;
		
	@FindBy(how = How.ID, using = "firstName")
	WebElement txtFName;	
	
	@FindBy(how = How.ID, using = "lastName")
	WebElement txtLName;	
	
	@FindBy(how = How.ID, using = "WC_UserRegistrationAddForm_FormInput_phoneNum_In_Register_1")
	WebElement txtPhNo;	
	
	@FindBy(how = How.ID, using = "male")
	WebElement radioGenderMale;
	
	@FindBy(how = How.ID, using = "female")
	WebElement radioGenderFemale;
 
	// http://selenium2advanced.blogspot.in/2013/08/working-with-page-factory-and-webdriver.html
	public LoginPage(WebDriver driver) throws Exception {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		/*if (!driver.getTitle().contains("n"))
			throw new Exception("This is not the Login page");*/
	}

	public void presenceOfuserNameLocated(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, 60, 1000);
		wait.until(ExpectedConditions.presenceOfElementLocated((By) element));
	}

	public void login(String uname, String pwd) {
		presenceOfuserNameLocated(txtEmail_Existing);
		radioExistingUser.click();		
		txtEmail_Existing.sendKeys(uname);
		txtPassword_Existing.sendKeys(pwd);
		btnLogin.click();
	}

	public void registerNewAccount(){
		presenceOfuserNameLocated(txtEmail_New);
		radioNewUser.click();	
	}
	 

}
