package com.aston.reporting.excel;

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

        Row row = sheet.createRow((short) 0);
        row.setHeight((short) (2*sheet.getDefaultRowHeight()));

        CellStyle cs = wb.createCellStyle();
        cs.setWrapText(true);
        Cell cell = row.createCell(0);
        cell.setCellStyle(cs);
//        cell.setCellValue(creationHelper.createRichTextString("\u2022This is \n     \u2022a string"));
        cell.setCellValue(creationHelper.createRichTextString(createBulletList(statusReport)));
        Cell cell2 = row.createCell(1);
        cell2.setCellStyle(cs);
        cell2.setCellValue("dd");
        return sheet;
    }

    private String createBulletList(StatusReport statusReport) {

        if (statusReport.getStatusList() == null || statusReport.getStatusList().size() == 0) {
            return "";
        }

        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < statusReport.getStatusList().size(); i++) {
            Status status = statusReport.getStatusList().get(i);
            if (StringUtils.isNullOrEmpty(status.getDescription())) {
                continue;
            }
            builder.append("\u2022 ");
            builder.append(status.getDescription());
            builder.append("\n");
            if (status.getSubStatusList() != null && status.getSubStatusList().size() == 0) {
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