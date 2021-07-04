package com.github.fabriciolfj.multitenay.config.datasource;

import lombok.RequiredArgsConstructor;
import org.flywaydb.core.Flyway;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

@Configuration
@RequiredArgsConstructor
public class DataSourceConfiguration {

    private final DataSourcesProperties dataSourcesProperties;

    @Bean
    public DataSource dataSource() {
        final var customDataSource = new TenantRoutingDataSource();
        customDataSource.setTargetDataSources(dataSourcesProperties.getDataSources());
        return customDataSource;
    }

    @PostConstruct
    public void migrate() {
        for (Object dataSource : dataSourcesProperties
                .getDataSources()
                .values()) {
            DataSource source = (DataSource) dataSource;
            Flyway flyway = Flyway.configure().dataSource(source).load();
            flyway.migrate();
        }
    }
}
