package com.github.fabriciolfj.multitenay.config.datasource;

import lombok.extern.log4j.Log4j2;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.LinkedHashMap;
import java.util.Map;

@Log4j2
@Component
@ConfigurationProperties(prefix = "tenants")
public class DataSourcesProperties {

    public Map<Object, Object> datasources = new LinkedHashMap<>();

    public Map<Object, Object> getDataSources() {
        return datasources;
    }

    public void setDatasources(Map<String, Map<String, String>> datasources) {
        log.info("map: {}", datasources);
        datasources
                .forEach((key, value) -> {
                    log.info("key: {}, value: {}", key, value);
                    this.datasources.put(key, convert(value));
                });
    }

    public DataSource convert(Map<String, String> source) {
        return DataSourceBuilder.create()
                .url(source.get("jdbcUrl"))
                .driverClassName(source.get("driverClassName"))
                .username(source.get("username"))
                .password(source.get("password"))
                .build();
    }
}
