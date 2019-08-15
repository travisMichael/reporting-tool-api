package com.aston.reporting.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Status {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @OneToMany
    private List<SubStatus> subStatusList;

    private String description;

    public String getDescription() {
        return description;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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
