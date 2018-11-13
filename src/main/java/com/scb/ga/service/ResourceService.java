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

import com.scb.ga.dao.jdbc.ResourceRepository;
import com.scb.ga.dao.jdbc.RoleRepository;
import com.scb.ga.domain.Resource;

/**
 * @author David Wang
 *
 */
@Service
@CacheConfig(cacheNames = "resource")
public class ResourceService {

	@Autowired
	protected ResourceRepository resourceRepository;

	@Autowired
	protected RoleRepository roleRepository;

	@Caching(put = @CachePut(key = "#resource.id"), evict = @CacheEvict(key = "'list'"))
	public Resource create(Resource resource) {
		validate(resource);
		resource.setId(UUID.randomUUID().toString());
		resourceRepository.add(resource);
		return resource;
	}

	@Caching(put = @CachePut(key = "#resource.id"), evict = @CacheEvict(key = "'list'"))
	public Resource modify(Resource resource) {
		validate(resource);
		resourceRepository.update(resource);
		return resource;
	}

	@Cacheable
	public Resource get(String code) {
		return resourceRepository.get(code);
	}

	@Cacheable(key = "'list'")
	public List<Resource> list() {
		return resourceRepository.list();
	}

	@Caching(evict = { @CacheEvict(key = "#code"), @CacheEvict(key = "'list'") })
	public void delete(String code) {
		roleRepository.removeRoleResourceByResourceId(code);
		resourceRepository.remove(code);
	}

	@Caching(evict = { @CacheEvict(key = "#code"), @CacheEvict(key = "'list'") })
	public void switchStatus(String code, boolean disable) {
		resourceRepository.switchStatus(code, disable);
	}

	private void validate(Resource resource) {
		Assert.hasText(resource.getTitle());
		Assert.hasText(resource.getUrl());

	}
}
