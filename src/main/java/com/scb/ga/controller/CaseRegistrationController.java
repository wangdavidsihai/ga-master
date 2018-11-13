package com.scb.ga.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author David Wang
 *
 */
@Controller
public class CaseRegistrationController {

	@RequestMapping("/register")
	public String index(@ModelAttribute("navs") List navs) {

		System.out.println("NAV-->" + navs);
		return "maker/register";
	}
}
