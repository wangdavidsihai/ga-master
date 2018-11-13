package com.scb.ga.quartz;

import java.util.Date;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author David Wang
 *
 */
public class DownloadJob implements Job {

	private Logger log = LoggerFactory.getLogger(this.getClass());

	/*
	 * Download file from upstream
	 */
	@Override
	public void execute(JobExecutionContext arg0) throws JobExecutionException {
		// TODO Auto-generated method stub
		System.out.println("Downloading file from ............." + new Date());
	}

}
