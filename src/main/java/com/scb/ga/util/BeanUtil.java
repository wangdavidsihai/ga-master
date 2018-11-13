package com.scb.ga.util;

import org.springframework.beans.BeanUtils;

/**
 * @author David Wang
 *
 */
public class BeanUtil {

	public static void copeProperties(Object from, Object dest) {
		try {
			BeanUtils.copyProperties(from, dest);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
