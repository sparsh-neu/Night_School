package com.me.nschool.controller;

import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.support.SessionStatus;

import com.me.nschool.dao.SchoolDAO;
import com.me.nschool.exception.SchoolException;
import com.me.nschool.pojo.School;


@Controller
public class SchoolController {

	@GetMapping("/listschool.htm")
	public String listSchoolsGet(HttpServletRequest request, SchoolDAO schooldao) {
		request.setAttribute("schoollist", schooldao.list());
		return "viewSchoolList";
	}

	@GetMapping("/addschool.htm")
	public String addSchoolGet(ModelMap model, School school) {
		// command object
		model.addAttribute("school", school);

		// return form view
		return "addSchoolForm";
	}

	@PostMapping("/addschool.htm")
	public String addSchoolPost(@ModelAttribute("school") School school, BindingResult result, SessionStatus status, SchoolDAO schooldao) {
		try {
			schooldao.save(school);
		} catch (SchoolException e) {
			System.out.println("School Item cannot be Added: " + e.getMessage());
		}
		
		status.setComplete(); //mark it complete
		return "addedSchool";
	}
}
