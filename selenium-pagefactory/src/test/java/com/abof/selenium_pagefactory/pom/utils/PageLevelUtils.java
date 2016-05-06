package com.abof.selenium_pagefactory.pom.utils;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;

import com.google.common.base.Function;

public class PageLevelUtils {
	/*
	 * public void visibilityOf(WebDriver driver, WebElement element, long
	 * duration, long pollingTime) { WebDriverWait wait=new
	 * WebDriverWait(driver, duration, pollingTime);
	 * wait.until(ExpectedConditions.visibilityOf(element)); }
	 * 
	 * public void presenceOfElementLocated(WebDriver driver, By by, long
	 * duration, long pollingTime) { WebDriverWait wait=new
	 * WebDriverWait(driver, duration, pollingTime);
	 * wait.until(ExpectedConditions.presenceOfElementLocated(by)); }
	 */

	public static void elementIsDisplayedFluentlyPredicate(WebElement element, long timeOutInSeconds,
			long sleepTimeOut) {
		new FluentWait<WebElement>(element).withTimeout(10, TimeUnit.SECONDS).pollingEvery(100, TimeUnit.MILLISECONDS)
				.ignoring(NoSuchElementException.class).until(new Function<WebElement, Boolean>() {
					public Boolean apply(WebElement element) {
						return element.isDisplayed();
					}
				});

	}

}