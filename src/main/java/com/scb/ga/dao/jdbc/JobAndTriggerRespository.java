package com.scb.ga.dao.jdbc;

import java.util.List;

import com.scb.ga.domain.JobAndTrigger;

/**
 * @author David Wang
 *
 */
public interface JobAndTriggerRespository {

	public List<JobAndTrigger> getJobAndTriggerDetails();

}
