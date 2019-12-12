package com.autoprac.qa.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.autoprac.qa.base.TestBase;

public class TestUtil extends TestBase {

	public static long PAGELOAD_TIMEOUT = 40;
	public static long IMPLICIT_WAIT = 10;
	XSSFWorkbook workbook;
	static XSSFSheet sheet;
	String excelPath;
	String sheetName;

	/**
	 * @param filePath
	 *            excel file path
	 * @param sheetName
	 *            sheet name in xlsx file
	 * @return excel data
	 * @throws InvalidFormatException
	 * @throws IOException
	 */
	public Object[][] readExcel(String excelPath, String sheetName) throws InvalidFormatException, IOException {
		FileInputStream file = new FileInputStream(excelPath);
		workbook = new XSSFWorkbook(file);
		sheet = workbook.getSheet(sheetName);
		int rowCount = sheet.getLastRowNum();
		int column = sheet.getRow(0).getLastCellNum();
		Object[][] data = new Object[rowCount][column];
		for (int i = 1; i <= rowCount; i++) {
			XSSFRow row = sheet.getRow(i);
			for (int j = 0; j < column; j++) {
				XSSFCell cell = row.getCell(j);
				DataFormatter formatter = new DataFormatter();
				String val = formatter.formatCellValue(cell);
				data[i - 1][j] = val;
			}
		}

		return data;
	}

	public static void takeScreenshotAtEndOfTest() throws IOException {
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String currentDir = System.getProperty("user.dir");
		FileUtils.copyFile(scrFile, new File(currentDir + "/screenshots/" + System.currentTimeMillis() + ".png"));
	}
}