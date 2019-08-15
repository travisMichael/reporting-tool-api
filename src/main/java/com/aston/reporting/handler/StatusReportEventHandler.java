package com.aston.reporting.handler;


import com.aston.reporting.entity.StatusReport;
import org.springframework.data.rest.core.annotation.HandleBeforeCreate;
import org.springframework.data.rest.core.annotation.HandleBeforeSave;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;

import javax.transaction.Transactional;

@RepositoryEventHandler(StatusReport.class)
public class StatusReportEventHandler {

    @HandleBeforeCreate
    public void handleBeforeCreate(StatusReport statusReport) {
        System.out.println("creating");
    }

    @HandleBeforeSave
    @Transactional
    public void handleBeforeSave(StatusReport statusReport) {
        System.out.println("saving");
    }
}
