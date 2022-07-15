package logic;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelData {

	public static void main(String[] args) throws Exception {
		File fs = new File("./src/main/java/data/Details.xlsx");
		FileInputStream fis = new FileInputStream(fs);

		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet1 = wb.getSheetAt(0);
		int Rowcount = sheet1.getLastRowNum();

		System.out.println(Rowcount);
		Cell value = sheet1.getRow(1).getCell(2);

		System.out.println(value);

		for (int i = 0; i < Rowcount; i++) {

			int cellCount = sheet1.getRow(i).getLastCellNum();

			for (int j = 0; j < cellCount; j++) {

			// System.out.println(sheet1.getRow(i).getCell(j).getStringCellValue() +",");
				sheet1.getRow(i).getCell(j).toString();

			}

		}
	}

}
