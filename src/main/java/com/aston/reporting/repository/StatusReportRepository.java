package com.aston.reporting.repository;

import com.aston.reporting.entity.StatusReport;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


@RepositoryRestResource
public interface StatusReportRepository  extends PagingAndSortingRepository<StatusReport, Long> {

}
