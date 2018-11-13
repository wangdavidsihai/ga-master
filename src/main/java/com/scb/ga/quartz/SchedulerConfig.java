package com.scb.ga.quartz;

import java.io.IOException;
import java.util.Properties;

import org.quartz.Scheduler;
import org.quartz.ee.servlet.QuartzInitializerListener;
import org.springframework.beans.factory.config.PropertiesFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

/**
 * @author David Wang
 *
 */
@Configuration
public class SchedulerConfig {

	/**
	 * Load quartz properties
	 */
	@Bean
	public Properties quartzProperties() throws IOException {
		PropertiesFactoryBean propertiesFactoryBean = new PropertiesFactoryBean();
		propertiesFactoryBean.setLocation(new ClassPathResource("/quartz.properties"));
		propertiesFactoryBean.afterPropertiesSet();
		return propertiesFactoryBean.getObject();
	}

	/**
	 * 
	 * Initialize scheduler factory bean
	 */
	@Bean(name = "SchedulerFactoryBean")
	public SchedulerFactoryBean schedulerFactoryBean() throws IOException {
		SchedulerFactoryBean schedulerFactoryBean = new SchedulerFactoryBean();
		schedulerFactoryBean.setQuartzProperties(quartzProperties());
		return schedulerFactoryBean;

	}

	/**
	 * 
	 * Initialize scheduler
	 * 
	 * @throws IOException
	 */
	@Bean(name = "Scheduler")
	public Scheduler scheduler() throws IOException {
		return schedulerFactoryBean().getScheduler();
	}

	/*
	 * quartz listener
	 */
	@Bean(name = "quartzInitializerListener")
	public QuartzInitializerListener executorListener() {
		return new QuartzInitializerListener();
	}

}
