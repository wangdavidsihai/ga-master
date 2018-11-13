package com.scb.ga.dao.jdbc;

import java.util.List;

import com.scb.ga.domain.SysLog;

/**
 * @author David Wang
 *
 */
public interface SysLogRepository {

	void add(SysLog sysLog);

	List<SysLog> list();

	void clear();
}
