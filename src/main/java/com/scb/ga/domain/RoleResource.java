package com.scb.ga.domain;

import java.io.Serializable;

/**
 * @author David Wang
 *
 */
public class RoleResource implements Serializable {

	private int roleId;
	private String resourceId;

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	public String getResourceId() {
		return resourceId;
	}

	public void setResourceId(String resourceId) {
		this.resourceId = resourceId;
	}

}
