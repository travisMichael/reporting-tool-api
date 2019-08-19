package com.aston.reporting.configuration;


import com.aston.reporting.entity.Project;
import com.aston.reporting.entity.StatusReport;
import com.aston.reporting.handler.StatusReportEventHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurerAdapter;

/**
 * Spring Data REST repository configuration and event handler registration.
 *
 * @see <a href="https://docs.spring.io/spring-data/rest/docs/current/reference/html/">Spring Data REST Documentation</a>
 */
@Configuration
public class SpringDataRestConfig extends RepositoryRestConfigurerAdapter {

    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
        config.exposeIdsFor(
                StatusReport.class,
                Project.class
        );
    }

    @Bean
    StatusReportEventHandler statusReportEventHandler() {
        return new StatusReportEventHandler();
    }


}
