package com.hunt.user.config;

import io.shardingsphere.api.config.rule.ShardingRuleConfiguration;
import io.shardingsphere.api.config.rule.TableRuleConfiguration;
import io.shardingsphere.api.config.strategy.InlineShardingStrategyConfiguration;
import io.shardingsphere.shardingjdbc.api.ShardingDataSourceFactory;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;

@Configuration
public class MultiDatasourceConfig {

    @ConfigurationProperties(prefix = "sharding.jdbc.datasource.user0")
    @Bean
    public DataSource dataSource0() {return DataSourceBuilder.create().build();}

    @ConfigurationProperties(prefix = "sharding.jdbc.datasource.user1")
    @Bean
    public DataSource dataSource1() {return DataSourceBuilder.create().build();}

    @Primary
    @Bean
    public DataSource dataSource() throws SQLException {
        Map<String, DataSource> map = new HashMap<>(2);
        map.put("user0", dataSource0());
        map.put("user1", dataSource1());
        return ShardingDataSourceFactory.createDataSource(map, shardingRuleConf(), new ConcurrentHashMap<>(), new Properties());
    }

    private ShardingRuleConfiguration shardingRuleConf() {
        //user表规则
        TableRuleConfiguration userTableRuleConf = new TableRuleConfiguration();
        userTableRuleConf.setLogicTable("user");
        userTableRuleConf.setActualDataNodes("user${0..1}.user${0..1}");

        //分库分表路由策略
        userTableRuleConf.setDatabaseShardingStrategyConfig(new InlineShardingStrategyConfiguration("id", "user${id % 2}"));
        userTableRuleConf.setTableShardingStrategyConfig(new InlineShardingStrategyConfiguration("id", "user${id % 2}"));

        //分片规则
        ShardingRuleConfiguration shardingRuleConf = new ShardingRuleConfiguration();
        shardingRuleConf.getTableRuleConfigs().add(userTableRuleConf);
        return shardingRuleConf;
    }
}