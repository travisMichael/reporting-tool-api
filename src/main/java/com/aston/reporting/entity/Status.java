package com.aston.reporting.entity;

import java.util.List;

public class Status {

    private String description;
    private List<SubStatus> subStatusList;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<SubStatus> getSubStatusList() {
        return subStatusList;
    }

    public void setSubStatusList(List<SubStatus> subStatusList) {
        this.subStatusList = subStatusList;
    }
}
