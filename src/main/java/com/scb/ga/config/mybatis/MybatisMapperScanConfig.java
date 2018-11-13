package com.scb.ga.config.mybatis;

import org.mybatis.spring.mapper.MapperScannerConfigurer;

/**
 * @author David Wang
 *
 */
// @Configuration
// @MapperScan(basePackages = "com.scb.ga.dao.mybatis")
public class MybatisMapperScanConfig {
	/**
	 * Scan all class under dao
	 */
	// @Bean
	public MapperScannerConfigurer MapperScannerConfigurer() {
		MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
		mapperScannerConfigurer.setBasePackage("com.scb.ga.dao.mybatis");
		mapperScannerConfigurer.setSqlSessionFactoryBeanName("sqlSessionFactory");
		return mapperScannerConfigurer;
	}
}
