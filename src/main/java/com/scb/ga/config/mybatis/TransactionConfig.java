package com.scb.ga.config.mybatis;

import javax.sql.DataSource;

import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.TransactionManagementConfigurer;

/**
 * @author David Wang
 *
 */
// @Configuration
public class TransactionConfig implements TransactionManagementConfigurer {

	// @Autowired
	private DataSource dataSource;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.springframework.transaction.annotation.TransactionManagementConfigurer#
	 * annotationDrivenTransactionManager()
	 */
	@Override
	// @Bean(name = "transactionManager")
	public PlatformTransactionManager annotationDrivenTransactionManager() {
		// TODO Auto-generated method stub
		return new DataSourceTransactionManager(dataSource);
	}

}
