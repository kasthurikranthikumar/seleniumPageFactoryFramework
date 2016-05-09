package com.abof.selenium_pagefactory.pom.utils;

import java.util.Random;

import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class CommonFunctions {
	static char specialCharacters[] = { '!', '@', '#', '$', '%', '^', '&', '*', '(', ')', '?', '/', '"', '|', '{', '[',
			'<', '>', ';', '`', ',', '_', '-' };

	public static String getPopupMessage(final WebDriver driver) {
		String message = null;
		try {
			Alert alert = driver.switchTo().alert();

			message = alert.getText();
			alert.accept();
		} catch (Exception e) {
			// Sometimes the text exist, but not the accept button.
			// this means the popup wasn't displayed and therefore
			// really never existed.
			//
			message = null;
		}
		System.out.println("message" + message);
		return message;
	}

	public static String cancelPopupMessageBox(final WebDriver driver) {
		String message = null;
		try {
			Alert alert = driver.switchTo().alert();

			message = alert.getText();
			alert.dismiss();
		} catch (Exception e) {
			// Sometimes the text exist, but not the accept button.
			// this means the popup wasn't displayed and therefore
			// really never existed.
			//
			message = null;
		}

		return message;
	}

	public static int generateRandomNumberBetweenNumbers(int min, int max) {
		Random random = new Random();
		return random.nextInt(max - min) + min;
	}

	public String generateAlphaNumericRandomString(int length) {
		// RandomStringUtils.random(length, (('A'..'Z') +
		// ('0'..'9')).join().toCharArray());
		return "";
	}

	public void scrollToCenter() {

		/*
		 * int center = driver.manage().window().getSize().getHeight()/2 int
		 * locatorHeight = element.firstElement().getLocation().getY() - center
		 * js.exec("window.scrollTo(0,$locatorHeight);")
		 */

	}

	/**
	 * to scroll the page to top based on the element.
	 * 
	 * @param block
	 */
	public void scrollToTop() {

		/*
		 * int center = driver.manage().window().getSize().getHeight()/4 int
		 * locatorHeight = element.firstElement().getLocation().getY() + center
		 * js.exec("window.scrollTo(0,$locatorHeight);")
		 */

	}
	
	
	public void zoomOutBrowser(boolean reset, WebDriver driver ) {
        Actions action = new Actions(driver);
        if(reset) {
            action.sendKeys(Keys.chord(Keys.CONTROL,"0")).build().perform();
        } else {
            action.sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT))
                    .sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT))
                    .sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT))
                    .sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT))
                    .sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT)).build().perform();
        }
    }

	/*
	 * public static void downloadFile(String href, String fileName) throws
	 * Exception{
	 * 
	 * PropertyConfigurator.configure("config/log4j.properties");
	 * 
	 * URL url = null; URLConnection con = null; int i;
	 * 
	 * url = new URL(href);
	 * 
	 * con = url.openConnection(); File file = new File(".//OutputData//" +
	 * fileName); BufferedInputStream bis = new
	 * BufferedInputStream(con.getInputStream());
	 * 
	 * BufferedOutputStream bos = new BufferedOutputStream( new
	 * FileOutputStream(file)); while ((i = bis.read()) != -1) { bos.write(i); }
	 * bos.flush(); bis.close();
	 * 
	 * }
	 */

	/*
	 * public static void writeExcel(String text,String fileName) throws
	 * Exception { FileOutputStream file = new
	 * FileOutputStream(".//OutputData//" + fileName+".csv",true);
	 * WritableWorkbook book = Workbook.createWorkbook(file); WritableSheet
	 * sheet = book.createSheet("output", 0); Label l = new Label(0, 0, text);
	 * sheet.addCell(l); book.write(); book.close(); }
	 */
}
