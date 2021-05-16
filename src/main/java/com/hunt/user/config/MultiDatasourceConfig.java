package com.hunt.user.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

//@Configuration
public class MultiDatasourceConfig {

    //@ConfigurationProperties(prefix = "spring.datasource")
    //@Primary
    //@Bean
    public DataSource dataSource() {return DataSourceBuilder.create().build();}

    //@ConfigurationProperties(prefix = "spring.datasource1")
    //@Bean
    public DataSource dataSource1() {return DataSourceBuilder.create().build();}
}