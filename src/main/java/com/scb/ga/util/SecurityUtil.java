package com.scb.ga.util;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import com.scb.ga.security.SecurityUser;

/**
 * @author David Wang
 *
 */
public class SecurityUtil {

	public static String getUid() {
		return getUser() == null ? "" : getUser().getUid();
	}

	public static SecurityUser getUser() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (authentication == null) {
			return null;
		}
		return (SecurityUser) authentication.getPrincipal();
	}

	public static boolean isRoot() {
		return "root".equals(getUser().getUsername());
	}

}
