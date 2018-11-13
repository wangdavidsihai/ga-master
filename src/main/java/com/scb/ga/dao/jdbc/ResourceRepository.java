package com.scb.ga.dao.jdbc;

import java.util.List;

import com.scb.ga.domain.Resource;

/**
 * @author David Wang
 *
 */
public interface ResourceRepository {

	void add(Resource resource);

	void update(Resource resource);

	Resource get(String code);

	List<Resource> list();

	void remove(String code);

	void switchStatus(String code, boolean disabled);

	List<Resource> listByRole(String roleId);

	List<Resource> getEnableResources();

}
