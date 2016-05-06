package com.abof.selenium_pagefactory.pom.utils;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Clock;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Sleeper;
import org.openqa.selenium.support.ui.SystemClock;
import com.google.common.base.Function;
import com.google.common.base.Predicate;

public class WebElementWait extends FluentWait<WebElement> {
	/**
	 * @param input
	 *            The input value to pass to the evaluated conditions.
	 * @param clock
	 *            The clock to use when measuring the timeout.
	 * @param sleeper
	 *            Used to put the thread to sleep between evaluation loops.
	 */
	public WebElementWait(WebElement input, Clock clock, Sleeper sleeper) {
		super(input, clock, sleeper);
		// TODO Auto-generated constructor stub
	}

	public void WebElementWaitFluentlyPredicate(WebElement element, Clock clock, Sleeper sleeper, long timeOutInSeconds,
			long sleepTimeOut) {
		withTimeout(timeOutInSeconds, TimeUnit.SECONDS);
		pollingEvery(sleepTimeOut, TimeUnit.MILLISECONDS);
		ignoring(NotFoundException.class);

		until(new Predicate<WebElement>() {
			public boolean apply(WebElement element) {
				return element.getText().endsWith("04");
			}
		});

	}

	public void WebElementWaitFluentlyFunction(WebElement element, Clock clock, Sleeper sleeper, long timeOutInSeconds,
			long sleepTimeOut) {
		withTimeout(timeOutInSeconds, TimeUnit.SECONDS);
		pollingEvery(sleepTimeOut, TimeUnit.MILLISECONDS);
		ignoring(NotFoundException.class);

		until(new Function<WebElement, Boolean>() {
			public Boolean apply(WebElement element) {
				return element.getText().endsWith("04");
			}
		});
	}

}
