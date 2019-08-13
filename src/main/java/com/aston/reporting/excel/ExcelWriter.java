package com.aston.reporting.excel;

import com.aston.reporting.entity.StatusReport;
import org.apache.poi.ss.usermodel.*;

import java.io.FileOutputStream;
import java.util.List;

public class ExcelWriter {

    public void writeStatusReports(List<StatusReport> statusReportList, String fileName) throws Exception {

        FileOutputStream fileOut = new FileOutputStream(fileName);

        WorkbookBuilder workbookBuilder = new WorkbookBuilder(statusReportList);
        Workbook wb = workbookBuilder.build();
        wb.write(fileOut);
        fileOut.close();
    }

}