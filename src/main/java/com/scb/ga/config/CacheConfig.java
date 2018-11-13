package com.scb.ga.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.guava.GuavaCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.common.cache.CacheBuilder;

/**
 * Cache management using guava
 * 
 * @author David Wang
 */
@Configuration
@ConfigurationProperties(prefix = "spring.cache.guava")
@EnableCaching(proxyTargetClass = true)
public class CacheConfig {

	private String spec;

	@Bean
	protected CacheManager cacheManager() {
		GuavaCacheManager cacheManager = new GuavaCacheManager();
		cacheManager.setCacheBuilder(CacheBuilder.from(spec));
		return cacheManager;
	}

	public void setSpec(String spec) {
		this.spec = spec;
	}
}
