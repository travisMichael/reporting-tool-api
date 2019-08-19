package com.aston.reporting.controller;

import com.aston.reporting.entity.Project;
import com.aston.reporting.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class ProjectController {

    @Autowired
    ProjectRepository projectRepository;

    @RequestMapping(value = "/api/v1/projects/{projectId}", method = RequestMethod.GET)
    @ResponseBody
    public Optional<Project> get(@PathVariable Long projectId) {
        System.out.println(projectId);
        return projectRepository.findById(projectId);
    }

    @RequestMapping(value = "/projects/{projectId}", method = RequestMethod.PUT)
    public void update(@PathVariable Long projectId) {
        System.out.println(projectId);
    }
}
