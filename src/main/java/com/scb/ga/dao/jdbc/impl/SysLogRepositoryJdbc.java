package com.scb.ga.dao.jdbc.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.scb.ga.dao.jdbc.SysLogRepository;
import com.scb.ga.domain.SysLog;

/**
 * @author David Wang
 *
 */
@Repository
public class SysLogRepositoryJdbc implements SysLogRepository {

	@Autowired
	protected JdbcTemplate jdbcTemplate;

	@Override
	public void add(SysLog sysLog) {
		jdbcTemplate.update("INSERT syslog (uid,content,operation,createTime,user) VALUES (?,?,?,?,?)", sysLog.getUid(),
				sysLog.getContent(), sysLog.getOperation(), sysLog.getCreateTime(), sysLog.getUser());
	}

	@Override
	public List<SysLog> list() {
		return jdbcTemplate.query("select * from syslog", BeanPropertyRowMapper.newInstance(SysLog.class));
	}

	@Override
	public void clear() {
		jdbcTemplate.update("DELETE FROM syslog");
	}
}
