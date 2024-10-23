package com.example.springdatajpa_multiple_db.config;

import com.example.springdatajpa_multiple_db.domain.cardholder.CreditCardHolder;
import com.example.springdatajpa_multiple_db.domain.creditcard.CreditCard;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@EnableJpaRepositories(basePackages = "com.example.springdatajpa_multiple_db.repositories.cardholder",
        entityManagerFactoryRef = "cardHolderEntityManagerFactory",
        transactionManagerRef = "cardHolderTransactionManager") // enabling spring data repository package for a specific database
public class CardHolderDatabaseConfiguration {

    @Bean
    @ConfigurationProperties("spring.cardholder.datasource")
    public DataSourceProperties cardHolderDataSourceProperties() {
        return new DataSourceProperties();
    }

    @Bean
    @ConfigurationProperties("spring.cardholder.datasource.hikari")
    public DataSource cardHolderDataSource(@Qualifier(value = "cardHolderDataSourceProperties") DataSourceProperties cardHolderDataSourceProperties) {
        return cardHolderDataSourceProperties.initializeDataSourceBuilder()
                .type(HikariDataSource.class).build();
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean cardHolderEntityManagerFactory(
            @Qualifier(value = "cardHolderDataSource") DataSource cardHolderDataSource,
            EntityManagerFactoryBuilder builder) {

        var props = new Properties();
        props.put("hibernate.hbm2ddl.auto", "validate");
        props.put("hibernate.physical_naming_strategy",
                "org.hibernate.boot.model.naming.CamelCaseToUnderscoresNamingStrategy");

        var efb = builder
                .dataSource(cardHolderDataSource)
                .packages(CreditCardHolder.class)
                .persistenceUnit("cardholder")
                .build();
        efb.setJpaProperties(props);

        return efb;
    }

    @Bean
    public PlatformTransactionManager cardHolderTransactionManager(
            @Qualifier("cardHolderEntityManagerFactory") LocalContainerEntityManagerFactoryBean cardHolderEntityManagerFactory) {
        return new JpaTransactionManager(cardHolderEntityManagerFactory.getObject());
    }

}
