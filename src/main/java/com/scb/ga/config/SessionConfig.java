package com.scb.ga.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.session.hazelcast.config.annotation.web.http.EnableHazelcastHttpSession;

import com.hazelcast.config.Config;
import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;

/**
 * Use Haselcast to cache session,also can change to use redis etc.. It is very
 * easy to enable http session with Hazelcast. e.g sessiontimeout = 1*60(s)
 *
 * @author David Wang
 */
@Configuration
@EnableHazelcastHttpSession(maxInactiveIntervalInSeconds = 30 * 60)
public class SessionConfig {

	@Bean
	public HazelcastInstance embeddedHazelcast() {
		Config hazelcastConfig = new Config();
		return Hazelcast.newHazelcastInstance(hazelcastConfig);
	}

}
