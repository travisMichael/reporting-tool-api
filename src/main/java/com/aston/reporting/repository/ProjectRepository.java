package com.aston.reporting.repository;


import com.aston.reporting.entity.Project;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(exported = false)
public interface ProjectRepository  extends PagingAndSortingRepository<Project, Long> {

}