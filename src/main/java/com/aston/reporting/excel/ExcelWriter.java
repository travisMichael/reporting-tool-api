package com.aston.reporting.excel;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class ExcelWriter {

    private static String[] columns = {"Name", "Email", "Date Of Birth", "Salary"};
    private static List<Employee> employees =  new ArrayList<>();

    // Initializing employees data to insert into the excel file
    static {
        Calendar dateOfBirth = Calendar.getInstance();
        dateOfBirth.set(1992, 7, 21);
        employees.add(new Employee("Rajeev Singh", "rajeev@example.com",
                dateOfBirth.getTime(), 1200000.0));

        dateOfBirth.set(1965, 10, 15);
        employees.add(new Employee("Thomas cook", "thomas@example.com",
                dateOfBirth.getTime(), 1500000.0));

        dateOfBirth.set(1987, 4, 18);
        employees.add(new Employee("Steve Maiden", "steve@example.com",
                dateOfBirth.getTime(), 1800000.0));
    }

    public static void main(String[] args) throws IOException, InvalidFormatException {
        // Create a Workbook
//        Workbook workbook = new HSSFWorkbook(); // new HSSFWorkbook() for generating `.xls` file
//
//        /* CreationHelper helps us create instances of various things like DataFormat,
//           Hyperlink, RichTextString etc, in a format (HSSF, XSSF) independent way */
//        CreationHelper createHelper = workbook.getCreationHelper();
//
//        // Create a Sheet
//        Sheet sheet = workbook.createSheet("Employee");
//        sheet.autoSizeColumn(2);
//
//        // Create a Font for styling header cells
//        Font headerFont = workbook.createFont();
//        headerFont.setBold(true);
//        headerFont.setFontHeightInPoints((short) 14);
//        headerFont.setColor(IndexedColors.RED.getIndex());
//
//        // Create a CellStyle with the font
//        CellStyle headerCellStyle = workbook.createCellStyle();
//        headerCellStyle.setFont(headerFont);
//
//        // Create a Row
//        Row headerRow = sheet.createRow(0);
//
//        // Create cells
//        for(int i = 0; i < columns.length; i++) {
//            Cell cell = headerRow.createCell(i);
//            cell.setCellValue(columns[i]);
//            cell.setCellStyle(headerCellStyle);
//        }
//
//        // Create Cell Style for formatting Date
//        CellStyle dateCellStyle = workbook.createCellStyle();
//        dateCellStyle.setWrapText(true);
//        dateCellStyle.setDataFormat(createHelper.createDataFormat().getFormat("dd-MM-yyyy"));
//
//
//        // Create Other rows and cells with employees data
//        int rowNum = 1;
//        for(Employee employee: employees) {
//            Row row = sheet.createRow(rowNum++);
//
//            row.createCell(0).setCellValue(employee.getName());
//
//            row.createCell(1).setCellValue(createHelper.createRichTextString("Use \n with word wrap on to create a new line"));
//            row.setHeightInPoints((2*sheet.getDefaultRowHeightInPoints()));
//
//            Cell dateOfBirthCell = row.createCell(2);
//            dateOfBirthCell.setCellValue(employee.getDateOfBirth());
//            dateOfBirthCell.setCellStyle(dateCellStyle);
//
//            row.createCell(3).setCellValue(employee.getSalary());
//        }
//
//        // Resize all columns to fit the content size
//        for(int i = 0; i < columns.length; i++) {
//            sheet.autoSizeColumn(i);
//        }
//
//        // Write the output to a file
//        FileOutputStream fileOut = new FileOutputStream("poi-generated-file.xls");
//        workbook.write(fileOut);
//        fileOut.close();
//
//        // Closing the workbook
//        workbook.close();

        Workbook wb = new XSSFWorkbook();
        FileOutputStream fileOut = new FileOutputStream("workbook.xlsx");
        CreationHelper createHelper = wb.getCreationHelper();
        Sheet sheet = wb.createSheet("new sheet");


        Row row = sheet.createRow((short) 0);
        row.setHeight((short) (2*sheet.getDefaultRowHeight()));


        CellStyle cs = wb.createCellStyle();
        cs.setWrapText(true);
        Cell cell = row.createCell(0);
        cell.setCellStyle(cs);
        cell.setCellValue(
                createHelper.createRichTextString("\u2022This is \n     \u2022a string"));
        Cell cell2 = row.createCell(1);
        cell2.setCellStyle(cs);
        cell2.setCellValue("dd");
        wb.write(fileOut);
        fileOut.close();
    }
}