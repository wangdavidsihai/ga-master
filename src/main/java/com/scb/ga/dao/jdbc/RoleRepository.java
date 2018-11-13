package com.scb.ga.dao.jdbc;

import java.util.List;

import com.scb.ga.domain.Role;

/**
 * @author David Wang
 *
 */
public interface RoleRepository {

	void add(Role role);

	void update(Role role);

	void updateMenus(String rid, List<String> mids);

	void updateResources(String rid, List<String> resources);

	boolean contains(String roleName);

	Role get(String id);

	List<Role> list();

	void remove(String id);

	void removeRoleMenuByMenuId(String menuId);

	void removeRoleResourceByResourceId(String resourceId);

	void switchStatus(String id, boolean disabled);

	List<Role> getRoles(String userId);

}
