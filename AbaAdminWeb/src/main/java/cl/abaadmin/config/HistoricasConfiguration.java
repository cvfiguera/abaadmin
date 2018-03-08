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
		 basePackages = "cl.abaadmin.repository.hist", 
		 entityManagerFactoryRef = "histEntityManager", 
		 transactionManagerRef = "histTransactionManager")
public class HistoricasConfiguration {
	@Autowired
    private Environment env;
     
	@Bean
    public LocalContainerEntityManagerFactoryBean histEntityManager() {
        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(histDataSource());
        em.setPackagesToScan(
          new String[] { "cl.abaadmin.entities.hist" });
 
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
    public DataSource histDataSource() {
  
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(env.getProperty("spring.datasource.hist.driver-class-name.driverClassName"));
        dataSource.setUrl(env.getProperty("spring.datasource.hist.url"));
        dataSource.setUsername(env.getProperty("spring.datasource.hist.username"));
        dataSource.setPassword(env.getProperty("spring.datasource.hist.password"));
        dataSource.setSchema(env.getProperty("spring.datasource.hist.schema"));
        return dataSource;
    }
 
    @Bean
    public PlatformTransactionManager histTransactionManager() {
  
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(histEntityManager().getObject());
        return transactionManager;
    }

}
