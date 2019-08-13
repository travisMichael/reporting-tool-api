package com.aston.reporting.excel;

import com.aston.reporting.entity.StatusReport;
import org.apache.poi.ss.usermodel.*;

public class GeneralReportSheetHelper {

    static void create(StatusReport statusReport, Workbook workbook, CreationHelper creationHelper) {
        Sheet sheet = workbook.createSheet(statusReport.getFullName());

        Row row = sheet.createRow((short) 0);
        row.setHeight((short) (2*sheet.getDefaultRowHeight()));

        CellStyle cs = workbook.createCellStyle();
        cs.setWrapText(true);
        Cell cell = row.createCell(0);
        cell.setCellStyle(cs);
        cell.setCellValue(creationHelper.createRichTextString("\u2022This is \n     \u2022a string"));
        Cell cell2 = row.createCell(1);
        cell2.setCellStyle(cs);
        cell2.setCellValue("dd");

    }
}
