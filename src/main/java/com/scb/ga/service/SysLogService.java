package com.scb.ga.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.scb.ga.dao.jdbc.SysLogRepository;
import com.scb.ga.domain.SysLog;

/**
 * @author David Wang
 *
 */
@Service
public class SysLogService {

	@Autowired
	protected SysLogRepository sysLogRepository;

	public void create(SysLog sysLog) {
		sysLogRepository.add(sysLog);
	}

	@CacheEvict(value = "syslog", allEntries = true)
	public void clear() {
		sysLogRepository.clear();
	}

	@Cacheable(value = "syslog")
	public List<SysLog> list() {
		return sysLogRepository.list();
	}
}
