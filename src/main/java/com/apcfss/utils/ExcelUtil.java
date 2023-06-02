package com.apcfss.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.apcfss.constants.FrameworkConstants;
import com.apcfss.frameworkexceptions.InvalidPathOfExcelException;
import com.apcfss.frameworkexceptions.UnableToReadDataException;
/**
 * Utility class to read or write to excel.
 * 
 * @author Pavan Kumar T
 * @version 1.0
 * @since 1.0
 * @see com.apcfss.listeners.MethodInterceptor
 * @see DataProviderUtil
 */
public final class ExcelUtil {
	private ExcelUtil() {
	}
	
	/**
	 * Encapsulates all the value from the mentioned excel sheet and store it in
	 * List holding HashMaps. Key for the map in the column header in the excel sheet.
	 * 
	 * @author Pavan Kumar T
	 * 22-05-2023
	 * @param sheetName Excel sheet name to read the value from
	 * @return List where each index holds a map and Each map holds the details about the test
	 */
	public static List<Map<String, String>> getTestDetails(String sheetName) {
		List<Map<String, String>> list = null;
		try (FileInputStream fileInputStream = new FileInputStream(FrameworkConstants.getExcelRunmanagerPath());
				XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);) {
			XSSFSheet sheet = workbook.getSheet(sheetName);
			Map<String, String> map;
			list = new ArrayList<>();
			int lastRownum = sheet.getLastRowNum();
			int lastColnum = sheet.getRow(0).getLastCellNum();
			for (int i = 1; i <= lastRownum; i++) {
				map = new HashMap<>();
				for (int j = 0; j < lastColnum; j++) {
					String key = sheet.getRow(0).getCell(j).getStringCellValue();
					String value = sheet.getRow(i).getCell(j).getStringCellValue();
					map.put(key, value);
				}
				list.add(map);
			}
		} catch (FileNotFoundException e) {
			throw new InvalidPathOfExcelException("Excel File trying to read is not found");
		} catch (IOException e) {
			throw new UnableToReadDataException("Unable to read data from excel file");
		} 
		return list;
	}

	public static Object[][] getTestDetailsForDataProvider(String sheetName) {
		Object[][] data = null;
		try (FileInputStream fileInputStream = new FileInputStream(FrameworkConstants.getExcelRunmanagerPath());
				XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);) {
			XSSFSheet sheet = workbook.getSheet(sheetName);
			Map<String, String> map;
			int lastRownum = sheet.getLastRowNum();
			int lastColnum = sheet.getRow(0).getLastCellNum();
			data = new Object[lastRownum][1];
			for (int i = 1; i <= lastRownum; i++) {
				map = new HashMap<>();
				for (int j = 0; j < lastColnum; j++) {
					String key = sheet.getRow(0).getCell(j).getStringCellValue();
					String value = sheet.getRow(i).getCell(j).getStringCellValue();
					map.put(key, value);
				}
				data[i - 1][0] = map;
			}
		} catch (FileNotFoundException e) {
			throw new InvalidPathOfExcelException("Excel File trying to read is not found");
		} catch (IOException e) {
			throw new UnableToReadDataException("Unable to read data from excel file");
		}
		return data;
	}

	public static Object[][] readMultipleData(String sheetName)  {
		Object[][] data=null;
		try (FileInputStream fileInputStream = new FileInputStream(FrameworkConstants.getExcelRunmanagerPath());
				XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);) {
			XSSFSheet sheet = workbook.getSheet(sheetName);
			int lastRow = sheet.getLastRowNum();
			int lastcell = sheet.getRow(0).getLastCellNum();

			data = new Object[lastRow][lastcell];

			for (int i = 0; i < lastRow; i++) {
				for (int j = 0; j < lastcell; j++) {
					data[i][j] = sheet.getRow(i + 1).getCell(j).getStringCellValue();
				}
			}
		} catch (FileNotFoundException e) {
			throw new InvalidPathOfExcelException("Excel File trying to read is not found");
		} catch (IOException e) {
			throw new UnableToReadDataException("Unable to read data from excel file");
		}
		return data;
	}
}
