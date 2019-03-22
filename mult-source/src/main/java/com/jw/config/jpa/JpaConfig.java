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
		entityManagerFactoryRef = "oracleEntityManagerFactory", 
		transactionManagerRef = "oracleTransactionManager",
		basePackages = {"com.jw.jpa.dao" })
public class JpaConfig {
	
	@Autowired
    private JpaProperties jpaProperties;
	
	@Autowired
    @Qualifier("datasourceMovie")
    private DataSource dataSource;
	
	
	@Bean(name = "oracleEntityManagerFactory")
	public LocalContainerEntityManagerFactoryBean entityManagerFactory(EntityManagerFactoryBuilder builder){
		jpaProperties.setDatabasePlatform("ORACLE");
		
		Map<String, String> hibernateProperties = jpaProperties.getHibernateProperties(dataSource);
		return builder
				.dataSource(dataSource)
				.properties(hibernateProperties)
				.packages("com.jw.domain.movie")//实体类所在的包
				.persistenceUnit("moviePersistenceUnit")
				.build();
	}
	
	@Bean(name = "oracleTransactionManager")
	public PlatformTransactionManager transactionManager(EntityManagerFactoryBuilder builder){
		return new JpaTransactionManager(entityManagerFactory(builder).getObject());
		
	}

	

}
