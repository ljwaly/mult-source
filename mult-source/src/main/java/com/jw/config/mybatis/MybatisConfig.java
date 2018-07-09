package com.jw.config.mybatis;


import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

@Configuration
@MapperScan(basePackages ="com.jw.mybatis.dao",sqlSessionFactoryRef="oracleSessionFactory")
public class MybatisConfig {

    @Bean(name="oracleSessionFactory")
    @Autowired
    @Qualifier("datasourcePeople")
    public SqlSessionFactory sqlSessionFactory(DataSource datasource) throws Exception {
        final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(datasource);
        
        Resource[] mappers = new PathMatchingResourcePatternResolver().getResources("classpath*:com/mapper/*Mapper.xml");//获取路径
        sessionFactory.setMapperLocations(mappers);
        
        return sessionFactory.getObject();
    }
}