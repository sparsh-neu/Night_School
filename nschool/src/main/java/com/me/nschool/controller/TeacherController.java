package com.me.nschool.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.support.SessionStatus;

import com.me.nschool.dao.TeacherDAO;
import com.me.nschool.exception.SchoolException;
import com.me.nschool.pojo.Teacher;


@Controller
public class TeacherController {

	@GetMapping("/addteacher.htm")
	public String addTeacherGet(ModelMap model, Teacher teacher) {
		// command object
		model.addAttribute("teacher", teacher);

		// return form view
		return "addTeacherForm";
	}

	@PostMapping("/addteacher.htm")
	public String addTeacherPost(@ModelAttribute("teacher") Teacher teacher, BindingResult result,
			SessionStatus status, TeacherDAO teacherdao) {
		
		try {
			teacherdao.save(teacher);
		} catch (SchoolException e) {
			System.out.println("Teacher cannot be Added: " + e.getMessage());
		}
		status.setComplete(); // mark it complete
		return "addedTeacher";
	}
}
