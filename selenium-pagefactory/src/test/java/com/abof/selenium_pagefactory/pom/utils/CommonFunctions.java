package com.abof.selenium_pagefactory.pom.utils;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;

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
