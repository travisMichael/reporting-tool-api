package com.aston.reporting.excel;

import com.aston.reporting.entity.StatusReport;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.util.List;

public class WorkbookBuilder {

    List<StatusReport> statusReportList;
    Workbook wb;
    CreationHelper createHelper;


    public WorkbookBuilder(List<StatusReport> statusReportList) {
        this.statusReportList = statusReportList;
        this.wb = new XSSFWorkbook();
        this.createHelper = this.wb.getCreationHelper();
    }

    public Workbook build() {

        for (int i = 0; i < statusReportList.size(); i++) {
            // create report sheet
            GeneralReportSheetHelper.create(statusReportList.get(i), wb, createHelper);
            // create details sheet
            DetailsSheetHelper.create(statusReportList.get(i), wb, createHelper);
        }

        return wb;
    }


}
