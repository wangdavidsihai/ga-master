package com.scb.ga.dao.jdbc.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.scb.ga.dao.jdbc.JobAndTriggerRespository;
import com.scb.ga.domain.JobAndTrigger;

/**
 * @author David Wang
 *
 */
@Repository
public class JobAndTriggerRepositoryJdbc implements JobAndTriggerRespository {

	@Autowired
	protected JdbcTemplate jdbcTemplate;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.scb.ga.dao.jdbc.IJobAndTriggerDao#getJobAndTriggerDetails()
	 */
	@Override
	public List<JobAndTrigger> getJobAndTriggerDetails() {
		String sql = "SELECT\n" + "				qrtz_job_details.JOB_NAME,\n"
				+ "				qrtz_job_details.JOB_GROUP,\n" + "				qrtz_job_details.JOB_CLASS_NAME,\n"
				+ "				qrtz_triggers.TRIGGER_NAME,\n" + "				qrtz_triggers.TRIGGER_GROUP,\n"
				+ "				qrtz_cron_triggers.CRON_EXPRESSION,\n"
				+ "				qrtz_cron_triggers.TIME_ZONE_ID\n" + "			FROM\n"
				+ "				qrtz_job_details\n" + "			JOIN qrtz_triggers\n"
				+ "			JOIN qrtz_cron_triggers ON qrtz_job_details.JOB_NAME = qrtz_triggers.JOB_NAME\n"
				+ "			AND qrtz_triggers.TRIGGER_NAME = qrtz_cron_triggers.TRIGGER_NAME\n"
				+ "			AND qrtz_triggers.TRIGGER_GROUP = qrtz_cron_triggers.TRIGGER_GROUP";
		return jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(JobAndTrigger.class));
	}

}
