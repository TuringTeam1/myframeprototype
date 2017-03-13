package com.huangtianci.myframeprototype.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.Properties;

/**
 * @author Huang Tianci
 * web相关配置
 */
@Configuration
@EnableWebMvc
@EnableTransactionManagement
@EnableJpaRepositories("com.huangtianci.myframeprototype")
@PropertySource(value = { "classpath:application.properties" })
@ComponentScan(basePackages = "com.huangtianci.myframeprototype")
public class WebConfig extends WebMvcConfigurerAdapter{

    static final Logger logger = LoggerFactory.getLogger(WebConfig.class);

    @Autowired
    Environment environment;

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {

        final LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(dataSource());
        em.setPackagesToScan(new String[] { "com.huangtianci.myframeprototype" });

        final HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        em.setJpaVendorAdapter(vendorAdapter);
        em.setJpaProperties(hibernateProperties());

        return em;
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
    public PlatformTransactionManager transactionManager(final EntityManagerFactory emf) {
        final JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(emf);
        return transactionManager;
    }

    @Bean
    public ViewResolver viewResolver(){
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/page/");
        resolver.setSuffix(".jsp");
        resolver.setExposeContextBeansAsAttributes(true);
        return resolver;
    }

    /**
     * Configure ResourceHandlers to serve static resources like CSS/ Javascript etc...
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**").addResourceLocations("/static/");
    }

    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer){
        configurer.enable();
    }

}
