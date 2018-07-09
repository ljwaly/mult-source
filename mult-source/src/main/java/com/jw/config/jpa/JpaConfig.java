package com.jw.config.jpa;

import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.apache.jasper.runtime.PerThreadTagHandlerPool;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
		entityManagerFactoryRef = "mysqlEntityManagerFactory", 
		transactionManagerRef = "mysqlTransactionManager",
		basePackages = {"com.jw.jpa.dao" })
public class JpaConfig {
	
	@Autowired
    private JpaProperties jpaProperties;
	
	@Autowired
    @Qualifier("datasourceMovie")
    private DataSource dataSource;
	
	
	@Bean(name = "mysqlEntityManagerFactory")
	public LocalContainerEntityManagerFactoryBean entityManagerFactory(EntityManagerFactoryBuilder builder){
		Map<String, String> hibernateProperties = jpaProperties.getHibernateProperties(dataSource);
		return builder
				.dataSource(dataSource)
				.properties(hibernateProperties)
				.packages("com.jw.domain.movie")//实体类所在的包
				.persistenceUnit("moviePersistenceUnit")
				.build();
	}
	
	@Bean(name = "mysqlTransactionManager")
	public PlatformTransactionManager transactionManager(EntityManagerFactoryBuilder builder){
		return new JpaTransactionManager(entityManagerFactory(builder).getObject());
		
	}

	
//	@Bean(name = "mysqlEntityManagerFactory")
//	@Autowired
//	@Qualifier("datasourceMovie")
//	public EntityManagerFactory entityManagerFactory(DataSource datasource) {
//		
//		HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
//		vendorAdapter.setGenerateDdl(true);
//		vendorAdapter.setShowSql(true);
//		
//		LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
//		factory.setJpaVendorAdapter(vendorAdapter);
//		factory.setDataSource(datasource);
//		factory.setPackagesToScan("com.jw.domain.movie");//实体类放到com.jw.domain.movie下
//		Properties jpaProperties = new Properties();
//		jpaProperties.put("hibernate.ejb.naming_strategy", "org.hibernate.cfg.ImprovedNamingStrategy");// 命名策略
//		factory.setJpaProperties(jpaProperties);
//		factory.afterPropertiesSet();
//		
//		
//		return factory.getObject();
//
//	}

//	@Bean(name = "mysqlTransactionManager")
//	@Autowired
//	@Qualifier("datasourceMovie")
//	public PlatformTransactionManager transactionManagerSecondary(DataSource datasource) {
//		JpaTransactionManager txManager = new JpaTransactionManager();
//		txManager.setEntityManagerFactory(entityManagerFactory(datasource));
//		return txManager;
//	}
}
