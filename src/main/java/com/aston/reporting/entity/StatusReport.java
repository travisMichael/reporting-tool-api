package com.aston.reporting.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class StatusReport {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private List<Project> projectList = new ArrayList<>();

    private String firstName;
    private String LastName;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public List<Project> getProjectList() {
        return projectList;
    }

    public void setProjectList(List<Project> projectList) {
        this.projectList.clear();
        this.projectList.addAll(projectList);
    }

    public String getFullName() {
        return getFirstName() + " " + getLastName();
    }
}
