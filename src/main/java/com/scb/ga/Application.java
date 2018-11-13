package com.scb.ga;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.SecurityAutoConfiguration;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.context.annotation.Bean;

import de.codecentric.boot.admin.config.EnableAdminServer;

/**
 * @author David Wang
 *
 */
@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
@EnableAdminServer
public class Application {

	public static void main(String[] arg) {
		SpringApplication.run(Application.class);
	}

	@Bean
	public EmbeddedServletContainerCustomizer containerCustomizer() {
		return new EmbeddedServletContainerCustomizer() {

			@Override
			public void customize(ConfigurableEmbeddedServletContainer container) {
				// TODO Auto-generated method stub
				container.setSessionTimeout(60);
			}
		};
	}
}
