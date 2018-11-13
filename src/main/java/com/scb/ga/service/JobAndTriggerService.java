package com.scb.ga.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scb.ga.dao.jdbc.JobAndTriggerRespository;
import com.scb.ga.domain.JobAndTrigger;

/**
 * @author David Wang
 *
 */
@Service
public class JobAndTriggerService {

	@Autowired
	public JobAndTriggerRespository jobAndTriggerRespository;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.scb.ga.service.IJobAndTriggerService#getJobAndTriggerDetails()
	 */
	public List<JobAndTrigger> getJobAndTriggerDetails() {
		// TODO Auto-generated method stub
		List<JobAndTrigger> jobAndTriggerList = new ArrayList<JobAndTrigger>();
		jobAndTriggerList = jobAndTriggerRespository.getJobAndTriggerDetails();
		return jobAndTriggerList;
	}

}
