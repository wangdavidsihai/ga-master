package com.scb.ga.config.mybatis;

import java.io.IOException;

import javax.sql.DataSource;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.context.ApplicationContext;

/**
 * @author David Wang
 *
 */
// @Configuration
public class SessionFactoryConfig {

	// @Autowired
	private DataSource dataSource;

	// @Bean(name = "sqlSessionFactory")
	public SqlSessionFactoryBean sessionFactoryBean(ApplicationContext applicationContext) throws IOException {
		SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
		sessionFactory.setDataSource(dataSource);
		sessionFactory.setMapperLocations(applicationContext.getResources("classpath*:mapper/*.xml"));
		return sessionFactory;
	}
}
