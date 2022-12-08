package Class10;


import org.apache.poi.ss.usermodel.*;
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


        // 1st way of accessing cell value
        Cell cellValue2 = sheet.getRow(0).getCell(2);
        System.out.println("cellValue2 = " + cellValue2);

        // 2nd way of accessing cell value
        String cellValue1 = sheet.getRow(0).getCell(2).getStringCellValue();  // .toString()
        System.out.println("cellValue1 = " + cellValue1);

        // You cannot get String from Numeric, if data mismatch, you will get IllegalStateException
        // String caZipCode = sheet.getRow(1).getCell(4).getStringCellValue();
        double caZipCode = sheet.getRow(1).getCell(4).getNumericCellValue();
        System.out.println("caZipCode = " + caZipCode);

        // Identifying cell data types using the .getCellTypes() method.
        CellType r0c2DataType = sheet.getRow(0).getCell(2).getCellType();
        System.out.println("r0c2DataType = " + r0c2DataType);

        // Task 4: Find data type for CA Zip Code
        CellType r1c4DataType = sheet.getRow(1).getCell(4).getCellType();
        System.out.println("r1c4DataType = " + r1c4DataType);

        // How to find total number of the rows?
        int numberOfRows = sheet.getPhysicalNumberOfRows();
        System.out.println("numberOfRows = " + numberOfRows);

        // How to find total number of the columns?
        short numberOfColumns = sheet.getRow(0).getLastCellNum();
        System.out.println("numberOfColumns = " + numberOfColumns);


        int lastRowNum = sheet.getLastRowNum();
        System.out.println("lastRowNum = " + lastRowNum);  // Index of the last row.

        // Task Open new excel workbook (excel file) and name it EmployeeList.xlsx

    }
}
