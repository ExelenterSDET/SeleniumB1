package Class10;


import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 *  0. Filepath (location of the Excel file)
 *  1. Workbook
 *  2. Sheet1, Sheet2, Sheet3
 *  3. Rows and Columns
 */

public class _01_ExcelIntro {
    public static void main(String[] args) throws IOException {
        String filePath = "/Users/shahnoza/Desktop/Book1.xlsx";     // Don't forget the file name here, including the extension. (.xlsx)
        FileInputStream fis = new FileInputStream(filePath);  // <-- Specifying the excel filepath and insert it inside FIS

        Workbook workbook = new XSSFWorkbook(fis);          // <--- Access the workbook (exel file)
        Sheet sheet = workbook.getSheet("Sheet1");          // <--- Access the sheet within the workbook
        Row row = sheet.getRow(0);                          // <--- Access a row (Row 0 is considered Header)
        Cell cell = row.getCell(0);                         // <--- Access a cell (column)
        System.out.println(cell);                             // Print Row 0, Cell 0 which is the very first line in excel file


        // Task 1: How to get Los Angeles?
        Row row1 = sheet.getRow(1);
        Cell r1c2 = row1.getCell(2);
        System.out.println(r1c2);

        // Task 2: How to access AZ ?
        Row row2 = sheet.getRow(2);
        Cell r2c3 = row2.getCell(3);
        System.out.println(r2c3);

        // Task 3: Phoenix
        System.out.println(sheet.getRow(2).getCell(2));


    }
}
