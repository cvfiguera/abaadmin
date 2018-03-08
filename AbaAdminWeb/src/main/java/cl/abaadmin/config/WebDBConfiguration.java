package cl.abaadmin.config;

import java.util.HashMap;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
@PropertySource({ "classpath:application.properties" })
@EnableJpaRepositories(
		 basePackages = "cl.abaadmin.repository.web", 
		 entityManagerFactoryRef = "webEntityManager", 
		 transactionManagerRef = "webTransactionManager")
public class WebDBConfiguration {
    @Autowired
    private Environment env;
     
    @Bean
    public LocalContainerEntityManagerFactoryBean webEntityManager() {
        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(webDataSource());
        em.setPackagesToScan(
          new String[] { "cl.abaadmin.entities.web" });
 
        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        em.setJpaVendorAdapter(vendorAdapter);
        HashMap<String, Object> properties = new HashMap<>();
        properties.put("spring.jpa.hibernate.ddl-auto", env.getProperty("spring.jpa.hibernate.ddl-auto"));
        properties.put("spring.jpa.properties.hibernate.dialect", env.getProperty("spring.jpa.properties.hibernate.dialect"));
        properties.put("spring.jpa.database", env.getProperty("spring.jpa.database"));
        properties.put("spring.jpa.properties.hibernate.id.new_generator_mappings", env.getProperty("spring.jpa.properties.hibernate.id.new_generator_mappings"));
        properties.put("spring.jpa.properties.hibernate.show_sql", env.getProperty("spring.jpa.properties.hibernate.show_sqle"));
        em.setJpaPropertyMap(properties);
 
        return em;
    }
 

    @Bean
    public DataSource webDataSource() {
  
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(env.getProperty("spring.datasource.web.driver-class-name.driverClassName"));
        dataSource.setUrl(env.getProperty("spring.datasource.web.url"));
        dataSource.setUsername(env.getProperty("spring.datasource.web.username"));
        dataSource.setPassword(env.getProperty("spring.datasource.web.password"));
        dataSource.setSchema(env.getProperty("spring.datasource.web.schema"));
 
        return dataSource;
    }
 

    @Bean
    public PlatformTransactionManager webTransactionManager() {
  
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(webEntityManager().getObject());
        return transactionManager;
    }
}