package com.abof.selenium_pagefactory.pom.utils;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;

import com.google.common.base.Function;
import com.google.common.base.Predicate;

public class WebElementWait  {
	
	public static void elementIsDisplayedFluentlyPredicate(WebElement element, long timeOutInSeconds,
			long sleepTimeOut) {
		new FluentWait<WebElement>(element).withTimeout(10, TimeUnit.SECONDS).pollingEvery(100, TimeUnit.MILLISECONDS)
				.ignoring(NoSuchElementException.class).until(new Predicate<WebElement>() {
					public boolean apply(WebElement element) {
						return element.isDisplayed();
					}
				});

	}
	
	public static void elementIsDisplayedFluentlyFunction(WebElement element, long timeOutInSeconds,
			long sleepTimeOut) {
		new FluentWait<WebElement>(element).withTimeout(10, TimeUnit.SECONDS).pollingEvery(100, TimeUnit.MILLISECONDS)
				.ignoring(NoSuchElementException.class).until(new Function<WebElement, Boolean>() {
					public Boolean apply(WebElement element) {
						return element.isDisplayed();
					}
				});

	}
	

}
