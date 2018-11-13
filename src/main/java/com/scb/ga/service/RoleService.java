package com.scb.ga.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.scb.ga.dao.jdbc.MenuRepository;
import com.scb.ga.dao.jdbc.ResourceRepository;
import com.scb.ga.dao.jdbc.RoleRepository;
import com.scb.ga.domain.Role;
import com.scb.ga.domain.SelectMenu;
import com.scb.ga.domain.SelectResource;

/**
 * @author David Wang
 *
 */
@Service
@CacheConfig(cacheNames = "role")
public class RoleService {

	@Autowired
	protected RoleRepository roleRepository;

	@Autowired
	protected ResourceRepository resourceRepository;

	@Autowired
	protected ResourceSelectService resourceSelectService;

	@Autowired
	protected MenuRepository menuRepository;

	@Caching(evict = @CacheEvict(key = "'list'"), put = @CachePut(key = "#role.id"))
	public Role create(Role role) {
		Assert.hasText(role.getName(), "Role name is empty");
		role.setId(UUID.randomUUID().toString());
		roleRepository.add(role);
		return role;
	}

	@Caching(evict = @CacheEvict(key = "'list'"), put = @CachePut(key = "#newRole.id"))
	public Role modify(Role newRole) {
		Assert.hasText(newRole.getId(), "Role id is empty");
		Assert.hasText(newRole.getName(), "Role name is empty");
		roleRepository.update(newRole);
		return newRole;
	}

	@Cacheable
	public Role get(String id) {
		return roleRepository.get(id);
	}

	@Cacheable(key = "'list'")
	public List<Role> list() {
		return roleRepository.list();
	}

	@Caching(evict = { @CacheEvict(key = "'list'"), @CacheEvict(key = "#id") })
	public void delete(String id) {
		roleRepository.remove(id);
	}

	@Caching(evict = { @CacheEvict(key = "'list'"), @CacheEvict(key = "#id") })
	public void switchStatus(String id, boolean disable) {
		roleRepository.switchStatus(id, disable);
	}

	public void grantResource(String roleId, List<String> resources) {
		roleRepository.updateResources(roleId, resources);
	}

	@CacheEvict(value = "user-nav-menu", allEntries = true)
	public void grantMenu(String roleId, List<String> menus) {
		roleRepository.updateMenus(roleId, menus);
	}

	public List<SelectResource> selectResources(String roleId) {
		return resourceSelectService.mergeResource(resourceRepository.list(), resourceRepository.listByRole(roleId));
	}

	public List<SelectMenu> selectMenus(String roleId) {
		return resourceSelectService.mergeMenus(menuRepository.list(), menuRepository.roleMenus(roleId));
	}
}
