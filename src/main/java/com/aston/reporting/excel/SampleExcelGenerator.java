package com.aston.reporting.excel;

import com.aston.reporting.entity.Project;
import com.aston.reporting.entity.Status;
import com.aston.reporting.entity.StatusReport;
import com.aston.reporting.entity.SubStatus;
import java.util.ArrayList;
import java.util.List;

public class SampleExcelGenerator {

    static Status generateStatus(String description) {

        Status status = new Status();
        status.setDescription(description);

        SubStatus subStatus1 = new SubStatus();
        subStatus1.setDescription("sub status 1");

        SubStatus subStatus2 = new SubStatus();
        subStatus2.setDescription("sub status 2");

        List<SubStatus> subStatusList = new ArrayList<>();
        subStatusList.add(subStatus1);
        subStatusList.add(subStatus2);

        status.setSubStatusList(subStatusList);

        return status;
    }

    static Project generateProject(String projectName) {
        Project project = new Project();
        project.setProjectName(projectName);


        List<Status> statusList = new ArrayList<>();
        statusList.add(generateStatus("status 1"));
        statusList.add(generateStatus("status 2"));

        project.setStatusList(statusList);

        return project;

    }

    static StatusReport generateStatusReport(String fName, String lName) {

        StatusReport statusReport = new StatusReport();
        statusReport.setFirstName(fName);
        statusReport.setLastName(lName);

        List<Project> projectList = new ArrayList<>();
        projectList.add(generateProject("project 1"));
        projectList.add(generateProject("project 2"));

        statusReport.setProjectList(projectList);

        return statusReport;

    }

    static List<StatusReport> generateSampleStatusReports() {
        List<StatusReport> statusReportList = new ArrayList<>();
        statusReportList.add(generateStatusReport("Travis", "Latzke"));
        statusReportList.add(generateStatusReport("Anne", "Coleman"));
        return statusReportList;
    }



    public static void main(String[] args) throws Exception {
        List<StatusReport> statusReportList = generateSampleStatusReports();

        ExcelWriter writer = new ExcelWriter();

        writer.writeStatusReports(statusReportList, "workbook.xlsx");
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

//        Workbook wb = new XSSFWorkbook();
//        FileOutputStream fileOut = new FileOutputStream("workbook.xlsx");
//        CreationHelper createHelper = wb.getCreationHelper();
//        Sheet sheet = wb.createSheet("new sheet");
//
//
//        Row row = sheet.createRow((short) 0);
//        row.setHeight((short) (2*sheet.getDefaultRowHeight()));
//
//
//        CellStyle cs = wb.createCellStyle();
//        cs.setWrapText(true);
//        Cell cell = row.createCell(0);
//        cell.setCellStyle(cs);
//        cell.setCellValue(
//                createHelper.createRichTextString("\u2022This is \n     \u2022a string"));
//        Cell cell2 = row.createCell(1);
//        cell2.setCellStyle(cs);
//        cell2.setCellValue("dd");
//        wb.write(fileOut);
//        fileOut.close();
    }
}
