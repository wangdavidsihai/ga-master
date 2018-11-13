package com.scb.ga.config.mybatis;

import java.beans.PropertyVetoException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import com.mchange.v2.c3p0.ComboPooledDataSource;

/**
 * @author David Wang
 *
 */
@Configuration
@ConfigurationProperties(prefix = "spring.datasource")
public class DataSourceConfig {

	@Value("url")
	private String url;
	@Value("username")
	private String username;
	@Value("password")
	private String password;
	@Value("driver-class-name")
	private String driverClassName;

	// @Bean(name = "datasource")
	public ComboPooledDataSource dataSource() throws PropertyVetoException {
		ComboPooledDataSource dataSource = new ComboPooledDataSource();
		dataSource.setDriverClass(driverClassName);
		dataSource.setJdbcUrl(url);
		dataSource.setUser(username);
		dataSource.setPassword(password);
		dataSource.setMaxPoolSize(20);
		dataSource.setMinPoolSize(5);
		dataSource.setInitialPoolSize(10);
		dataSource.setMaxIdleTime(300);
		dataSource.setAcquireIncrement(5);
		dataSource.setIdleConnectionTestPeriod(60);
		return dataSource;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getDriverClassName() {
		return driverClassName;
	}

	public void setDriverClassName(String driverClassName) {
		this.driverClassName = driverClassName;
	}

}
