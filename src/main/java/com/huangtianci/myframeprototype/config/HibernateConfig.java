package com.huangtianci.myframeprototype.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;

/**
 * @author Huang Tianci
 * Hibernate配置类
 */
@Configuration
@EnableTransactionManagement
@ComponentScan({ "com.huangtianci.myframeprototype.config" })
@PropertySource(value = { "classpath:application.properties" })
public class HibernateConfig {

    static final Logger logger = LoggerFactory.getLogger(HibernateConfig.class);

    @Autowired
    Environment environment;

    @Bean
    public LocalSessionFactoryBean sessionFactory() {
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setDataSource(dataSource());
        sessionFactory.setPackagesToScan(new String[] { "com.huangtianci.myframeprototype.program" });
        sessionFactory.setHibernateProperties(hibernateProperties());
        return sessionFactory;
    }

    @Bean
    public DataSource dataSource(){
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        try {
            dataSource.setDriverClass(environment.getRequiredProperty("jdbc.driverClassName"));
        } catch (Exception e) {
            logger.error("Property jdbc.driverClassName vote exception, Please check!",e);
        }
        dataSource.setJdbcUrl(environment.getRequiredProperty("jdbc.url"));
        dataSource.setUser(environment.getRequiredProperty("jdbc.username"));
        dataSource.setPassword(environment.getRequiredProperty("jdbc.password"));
        dataSource.setTestConnectionOnCheckout(Boolean.valueOf(environment.getRequiredProperty("jdbc.c3p0.testConnectionOnCheckout")));
        dataSource.setTestConnectionOnCheckin(Boolean.valueOf(environment.getRequiredProperty("jdbc.c3p0.testConnectionOnCheckin")));
        dataSource.setIdleConnectionTestPeriod(Integer.parseInt(environment.getRequiredProperty("jdbc.c3p0.idleConnectionTestPeriod")));
        dataSource.setInitialPoolSize(Integer.parseInt(environment.getRequiredProperty("jdbc.c3p0.initialPoolSize")));
        dataSource.setMinPoolSize(Integer.parseInt(environment.getRequiredProperty("jdbc.c3p0.minPoolSize")));
        dataSource.setMaxPoolSize(Integer.parseInt(environment.getRequiredProperty("jdbc.c3p0.maxPoolSize")));
        dataSource.setMaxIdleTime(Integer.parseInt(environment.getRequiredProperty("jdbc.c3p0.maxIdleTime")));
        return dataSource;
    }

    private Properties hibernateProperties() {
        Properties properties = new Properties();
        properties.put("hibernate.dialect", environment.getRequiredProperty("hibernate.dialect"));
        properties.put("hibernate.show_sql", environment.getRequiredProperty("hibernate.show_sql"));
        properties.put("hibernate.format_sql", environment.getRequiredProperty("hibernate.format_sql"));
        properties.put("hibernate.hbm2ddl.auto", environment.getRequiredProperty("hibernate.hbm2ddl.auto"));
        return properties;
    }

    @Bean
    @Autowired
    public HibernateTransactionManager transactionManager(SessionFactory s) {
        HibernateTransactionManager txManager = new HibernateTransactionManager();
        txManager.setSessionFactory(s);
        return txManager;
    }
}
