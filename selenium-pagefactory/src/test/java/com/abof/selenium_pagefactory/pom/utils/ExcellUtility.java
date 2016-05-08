package com.abof.selenium_pagefactory.pom.utils;

import java.io.File;
import java.io.FileInputStream; 
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;

//import com.google.common.collect.Table.Cell;

//HSSF (Horrible SpreadSheet Format) – reads and writes Microsoft Excel (XLS) format files.
//XSSF (XML SpreadSheet Format) – reads and writes Office Open XML (XLSX) format files.

public class ExcellUtility {
	public void readme() throws IOException {
		FileInputStream file = new FileInputStream(
				new File("D:\\Selenium\\JavaWorld\\WorkSpace\\EXCELLWORLD\\JobServe_Suit.xls"));

		// Get the workbook instance for XLS file
		HSSFWorkbook workbook = new HSSFWorkbook(file);
		int i = workbook.getSheetIndex("JobServe-Suit");

		// Get sheet from the workbook
		HSSFSheet sheet = workbook.getSheetAt(i);

		// Iterate through each rows from first sheet
		Iterator<Row> rowIterator = sheet.iterator();
		while (rowIterator.hasNext()) {
			Row row = rowIterator.next();

			Iterator<org.apache.poi.ss.usermodel.Cell> cellIterator = row.iterator();
			while (cellIterator.hasNext()) {
				org.apache.poi.ss.usermodel.Cell cell = cellIterator.next();

				String s = cell.getStringCellValue();
				System.out.println(s);
			}
		}
		file.close();

	}

	public String[][] readData(String sheetName) throws IOException {
		FileInputStream file = new FileInputStream(
				new File("D:\\Selenium\\JavaWorld\\WorkSpace\\EXCELLWORLD\\JobServe_Suit.xls"));

		// Get the workbook instance for XLS file
		HSSFWorkbook workbook = new HSSFWorkbook(file);
		int x = workbook.getSheetIndex(sheetName);
		HSSFSheet sheet = workbook.getSheetAt(x);

		int r = sheet.getPhysicalNumberOfRows();
		System.out.println("rows" + r);
		int c = sheet.getRow(0).getPhysicalNumberOfCells();
		System.out.println("column" + c);

		String arr[][] = new String[r][c];
		Iterator<Row> rowIterator = sheet.iterator();
		int i = 0;
		int j = 0;
		while (rowIterator.hasNext()) {

			Row row = rowIterator.next();

			Iterator<org.apache.poi.ss.usermodel.Cell> cellIterator = row.iterator();
			while (cellIterator.hasNext()) {
				org.apache.poi.ss.usermodel.Cell cell = cellIterator.next();

				String s = cell.getStringCellValue();
				System.out.println(i + "" + j);
				System.out.println("loop:   " + s);
				arr[i][j] = s;
				j++;
			}
			i++;
			j = 0;
		}
		System.out.println("returned");
		return arr;

	}
}
