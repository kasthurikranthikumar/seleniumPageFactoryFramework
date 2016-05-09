package com.abof.selenium_pagefactory.pom.utils;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.json.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JsonParserUtil {
	/**
	 * @param f
	 *            file
	 * @return returns the JSON object on the passed file
	 * @throws IOException
	 * @throws ParseException
	 *
	 */

	public JSONObject getJsonObjFromFile(File f) throws IOException, ParseException {
		JSONParser parser = new JSONParser();
		FileReader flr = new FileReader(f);
		JSONObject json = (JSONObject) parser.parse(flr);
		flr.close();
		return json;
	}

	/**
	 * @param filePath
	 *            path of the file
	 * @return returns the JSON object on the passed file located at filePath
	 * @throws ParseException
	 * @throws IOException
	 *
	 */

	public JSONObject getJsonObjFromFile(String filePath) throws IOException, ParseException {
		File file = new File(filePath);
		return getJsonObjFromFile(file);
	}

	/**
	 * @param file
	 *            file
	 * @return returns the JSON object on the passed file
	 * @throws ParseException
	 * @throws IOException
	 *
	 */

	public String getJsonStringFromFile(File file) throws IOException, ParseException {
		JSONObject json = getJsonObjFromFile(file);
		return json.toString();
	}

	/**
	 * @param filePath
	 *            path of the file
	 * @return returns the JSON object on the passed file located at filePath
	 * @throws ParseException
	 * @throws IOException
	 *
	 */

	public String getJsonStringFromFile(String filepath) throws IOException, ParseException {
		File file = new File(filepath);
		return getJsonStringFromFile(file);
	}
}
