package com.aston.reporting.excel;

import com.aston.reporting.entity.Project;
import com.aston.reporting.entity.Status;
import com.aston.reporting.entity.StatusReport;
import com.aston.reporting.entity.SubStatus;
import com.mysql.jdbc.StringUtils;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.util.List;

public class ExcelWriter {

    public void writeStatusReports(List<StatusReport> statusReportList, String fileName) throws Exception {

        Workbook wb = new XSSFWorkbook();
        FileOutputStream fileOut = new FileOutputStream(fileName);
        CreationHelper createHelper = wb.getCreationHelper();

        for (int i = 0; i < statusReportList.size(); i++) {
            // create report sheet
            createReportSheet(statusReportList.get(i), wb, createHelper);
            // create details sheet
            createDetailsSheet(statusReportList.get(i), wb, createHelper);
        }


        wb.write(fileOut);
        fileOut.close();
    }

    private Sheet createReportSheet(StatusReport statusReport, Workbook wb, CreationHelper creationHelper) {

        Sheet sheet = wb.createSheet(statusReport.getFullName());

        Row row = sheet.createRow((short) 0);
        row.setHeight((short) (2*sheet.getDefaultRowHeight()));

        CellStyle cs = wb.createCellStyle();
        cs.setWrapText(true);
        Cell cell = row.createCell(0);
        cell.setCellStyle(cs);
        cell.setCellValue(creationHelper.createRichTextString("\u2022This is \n     \u2022a string"));
        Cell cell2 = row.createCell(1);
        cell2.setCellStyle(cs);
        cell2.setCellValue("dd");
        return sheet;
    }

    private Sheet createDetailsSheet(StatusReport statusReport, Workbook wb, CreationHelper creationHelper) {
        String firstNameChar = statusReport.getFirstName().substring(0, 1).toUpperCase();
        String lastNameChar = statusReport.getLastName().substring(0, 1).toUpperCase();
        Sheet sheet = wb.createSheet(firstNameChar + lastNameChar + " Details");
        // sheet.autoSizeColumn(1);
        sheet.setColumnWidth(3, 20000);

        // create headers
        addHeaders(sheet, wb, creationHelper);

        for (int i = 0; i < statusReport.getProjectList().size(); i++) {
            addProject(statusReport.getProjectList().get(i), i+1, sheet, wb, creationHelper);
        }


        return sheet;
    }

    private void addHeaders(Sheet sheet, Workbook wb, CreationHelper creationHelper) {
        Row row = sheet.createRow((short) 0);

        CellStyle cs = wb.createCellStyle();
        cs.setWrapText(true);
        Cell cell = row.createCell(1);
        cell.setCellStyle(cs);
        cell.setCellValue("Project Name");

        // set Project allocation
        Cell cell2 = row.createCell(2);
        cs.setWrapText(true);
        cell2.setCellStyle(cs);
        cell2.setCellValue("Allocation");

        // set Project status/comment
        Cell cell3 = row.createCell(3);
        cs.setWrapText(true);
        cell3.setCellStyle(cs);
        cell3.setCellValue("Status / Comments");

        // set total project hours
        Cell cell4 = row.createCell(4);
        cs.setWrapText(true);
        cell4.setCellStyle(cs);
        cell4.setCellValue("Total Project Hours");

        // set allocation
        Cell cell5 = row.createCell(5);
        cs.setWrapText(true);
        cell5.setCellStyle(cs);
        cell5.setCellValue("Allocation");

        // set status/ comment
        Cell cell6 = row.createCell(6);
        cs.setWrapText(true);
        cell6.setCellStyle(cs);
        cell6.setCellValue("Status / Comments");

        // set expected hours
        Cell cell7 = row.createCell(7);
        cs.setWrapText(true);
        cell7.setCellStyle(cs);
        cell7.setCellValue("Expected Project Hours");

    }

    private void addProject(Project project, int rowIndex, Sheet sheet, Workbook wb, CreationHelper creationHelper) {
        Row row = sheet.createRow((short) rowIndex);
        row.setHeight((short) (4*sheet.getDefaultRowHeight()));

        // set Project Name
        CellStyle cs = wb.createCellStyle();
        cs.setWrapText(true);
        Cell cell = row.createCell(1);
        cell.setCellStyle(cs);
        System.out.println(project.getProjectName());
        cell.setCellValue(project.getProjectName());

        // set Project allocation
        Cell cell2 = row.createCell(2);
        cs.setWrapText(true);
        cell2.setCellStyle(cs);
        cell2.setCellValue("50%");

        // set Project status/comment
        Cell cell3 = row.createCell(3);
        cs.setWrapText(true);
        cell3.setCellStyle(cs);
        String bulletList = createBulletList(project);
        cell3.setCellValue(creationHelper.createRichTextString(bulletList));
    }

    private String createBulletList(Project project) {

        if (project.getStatusList() == null || project.getStatusList().size() == 0) {
            return "";
        }

        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < project.getStatusList().size(); i++) {
            Status status = project.getStatusList().get(i);
            if (StringUtils.isNullOrEmpty(status.getDescription())) {
                continue;
            }
            builder.append("\u2022 ");
            builder.append(status.getDescription());
            builder.append("\n");
            if (status.getSubStatusList() != null && status.getSubStatusList().size() > 0) {
                for (int j = 0; j < status.getSubStatusList().size(); j ++) {
                    SubStatus subStatus = status.getSubStatusList().get(j);
                    if (StringUtils.isNullOrEmpty(subStatus.getDescription())) {
                        continue;
                    }
                    builder.append("   \u2022 ");
                    builder.append(subStatus.getDescription());
                    builder.append("\n");
                }
            }
        }

        return builder.toString();
    }
}