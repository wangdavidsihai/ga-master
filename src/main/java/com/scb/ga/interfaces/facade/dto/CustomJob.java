package com.scb.ga.interfaces.facade.dto;

import java.io.Serializable;

/**
 * @author David Wang
 *
 */
public class CustomJob implements Serializable {

	private String jobClassName;
	private String jobGroupName;
	private String cronExp;

	public String getJobClassName() {
		return jobClassName;
	}

	public void setJobClassName(String jobClassName) {
		this.jobClassName = jobClassName;
	}

	public String getJobGroupName() {
		return jobGroupName;
	}

	public void setJobGroupName(String jobGroupName) {
		this.jobGroupName = jobGroupName;
	}

	public String getCronExp() {
		return cronExp;
	}

	public void setCronExp(String cronExp) {
		this.cronExp = cronExp;
	}

}
