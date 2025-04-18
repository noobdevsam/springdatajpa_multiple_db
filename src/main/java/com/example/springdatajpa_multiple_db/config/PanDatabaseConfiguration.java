package com.example.springdatajpa_multiple_db.config;

import com.example.springdatajpa_multiple_db.domain.pan.CreditCardPAN;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@EnableJpaRepositories(basePackages = "com.example.springdatajpa_multiple_db.repositories.pan",
        entityManagerFactoryRef = "panEntityManagerFactory",
        transactionManagerRef = "panTransactionManager") // enabling spring data repository package for a specific database
public class PanDatabaseConfiguration {

    @Bean
    @Primary
    @ConfigurationProperties("spring.pan.datasource")
    public DataSourceProperties panDataSourceProperties() {
        return new DataSourceProperties();
    }

    @Primary
    @Bean
    @ConfigurationProperties("spring.pan.datasource.hikari")
    public DataSource panDataSource(@Qualifier(value = "panDataSourceProperties") DataSourceProperties panDataSourceProperties) {
        return panDataSourceProperties.initializeDataSourceBuilder()
                .type(HikariDataSource.class).build();
    }

    @Primary
    @Bean
    public LocalContainerEntityManagerFactoryBean panEntityManagerFactory(
            @Qualifier(value = "panDataSource") DataSource panDataSource,
            EntityManagerFactoryBuilder builder) {

        var props = new Properties();
        props.put("hibernate.hbm2ddl.auto", "validate");
        props.put("hibernate.physical_naming_strategy",
                "org.hibernate.boot.model.naming.CamelCaseToUnderscoresNamingStrategy");

        var efb = builder
                .dataSource(panDataSource)
                .packages(CreditCardPAN.class)
                .persistenceUnit("pan")
                .build();
        efb.setJpaProperties(props);

        return efb;
    }

    @Primary
    @Bean
    public PlatformTransactionManager panTransactionManager(
            @Qualifier("panEntityManagerFactory") LocalContainerEntityManagerFactoryBean panEntityManagerFactory) {
        return new JpaTransactionManager(panEntityManagerFactory.getObject());
    }

}
