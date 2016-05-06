package com.abof.selenium_pagefactory.pom.utils;

import com.google.common.base.Function;
import com.google.common.base.Predicate;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class WebDriverWaits extends FluentWait<WebElement> {
	public WebDriverWaits(WebElement input) {
		super(input);
		// TODO Auto-generated constructor stub
	}

	WebElement element;

	public void waitForWebElementFluently() {

		new FluentWait<WebElement>(element).withTimeout(10, TimeUnit.SECONDS).pollingEvery(100, TimeUnit.MILLISECONDS)
				.until(new Function<WebElement, Boolean>() {
					public Boolean apply(WebElement element) {
						return element.getText().endsWith("04");
					}
				});
	}

	public void waitForWebElementFluentlyPredicate() {

		new FluentWait<WebElement>(element).withTimeout(10, TimeUnit.SECONDS).pollingEvery(100, TimeUnit.MILLISECONDS)
				.until(new Predicate<WebElement>() {

					public boolean apply(WebElement element) {
						return element.getText().endsWith("04");
					}
				});
	}

}
